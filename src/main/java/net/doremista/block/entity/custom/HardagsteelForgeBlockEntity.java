package net.doremista.block.entity.custom;

import net.doremista.block.custom.HardagsteelForgeBlock;
import net.doremista.block.entity.ImplementedInventory;
import net.doremista.block.entity.ModBlockEntities;
import net.doremista.recipe.HardagsteelForgeRecipe;
import net.doremista.screen.HardagsteelForgeScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class HardagsteelForgeBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(4, ItemStack.EMPTY); // Updated to 4 slots

    private static final int INPUT_SLOT_1 = 0;
    private static final int INPUT_SLOT_2 = 1;
    private static final int INPUT_SLOT_3 = 2;
    private static final int OUTPUT_SLOT = 3; // Updated output slot

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 190;

    public HardagsteelForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HARDAGSTEEL_FORGE_BLOCK_ENTITY, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> HardagsteelForgeBlockEntity.this.progress;
                    case 1 -> HardagsteelForgeBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> HardagsteelForgeBlockEntity.this.progress = value;
                    case 1 -> HardagsteelForgeBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("hardagsteelforge.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("hardagsteelforge.progress");
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Hardagsteel Forge");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new HardagsteelForgeScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.isClient) {
            return;
        }

        boolean wasLit = state.get(HardagsteelForgeBlock.LIT);
        boolean shouldBeLit = false;

        if (hasRecipe()) {
            increaseCraftProgress();
            markDirty(world, pos, state);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }

            shouldBeLit = true;
        } else {
            resetProgress();
        }

        if (wasLit != shouldBeLit) {
            world.setBlockState(pos, state.with(HardagsteelForgeBlock.LIT, shouldBeLit), 3);
        }

        markDirty(world, pos, state);
    }


    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<HardagsteelForgeRecipe> recipe = getCurrentRecipe();

        if (recipe.isPresent()) {
            HardagsteelForgeRecipe recipeInstance = recipe.get();

            // Consume ingredients
            for (int i = 0; i < recipeInstance.getIngredients().size(); i++) {
                this.removeStack(i, 1);
            }

            // Handle output
            ItemStack outputStack = recipeInstance.getOutput(null).copy();
            ItemStack currentOutputStack = this.getStack(OUTPUT_SLOT);

            if (currentOutputStack.isEmpty() || currentOutputStack.getItem() != outputStack.getItem()) {
                this.setStack(OUTPUT_SLOT, outputStack);
            } else {
                currentOutputStack.increment(outputStack.getCount());
            }
        }
    }

    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<HardagsteelForgeRecipe> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            ItemStack outputStack = recipe.get().getOutput(null);
            ItemStack currentOutputStack = this.getStack(OUTPUT_SLOT);

            // If the output slot is empty, or it contains the same item as the recipe's output, continue
            if (currentOutputStack.isEmpty() || currentOutputStack.getItem() == outputStack.getItem()) {
                return canInsertAmountIntoOutputSlot(outputStack);
            } else {
                // If the output slot contains a different item, return false
                return false;
            }
        }
        return false;
    }


    private Optional<HardagsteelForgeRecipe> getCurrentRecipe() {
        SimpleInventory inv = new SimpleInventory(this.size());
        for (int i = 0; i < this.size(); i++) {
            inv.setStack(i, this.getStack(i));
        }
        return getWorld().getRecipeManager().getFirstMatch(HardagsteelForgeRecipe.Type.INSTANCE, inv, getWorld());
    }

    private boolean canInsertAmountIntoOutputSlot(ItemStack result) {
        return this.getStack(OUTPUT_SLOT).getCount() + result.getCount() <= getStack(OUTPUT_SLOT).getMaxCount();
    }
}
