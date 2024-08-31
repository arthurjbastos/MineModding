package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.KIKIANMASSBLOCK);
        addDrop(ModBlocks.ADAGSTEELBLOCK);

        addDrop(ModBlocks.ADAGSTEELORE, oreDrops(ModBlocks.ADAGSTEELORE, ModItems.RAWADAGSTEEL));
        addDrop(ModBlocks.DEEPSLATEADAGSTEELORE, oreDrops(ModBlocks.DEEPSLATEADAGSTEELORE, ModItems.RAWADAGSTEEL));

        addDrop(ModBlocks.ADAGSTEELTRAPDOOR);
        addDrop(ModBlocks.ADAGSTEELFENCE);
        addDrop(ModBlocks.ADAGSTEELFENCEGATE);
        addDrop(ModBlocks.ADAGSTEELWALL);
        addDrop(ModBlocks.ADAGSTEELSTAIRS);

        addDrop(ModBlocks.HARDAGSTEELFORGE);

        addDrop(ModBlocks.BENCH);

        addDrop(ModBlocks.ADAGSTEELDOOR, doorDrops(ModBlocks.ADAGSTEELDOOR));
        addDrop(ModBlocks.ADAGSTEELSLAB, slabDrops(ModBlocks.ADAGSTEELSLAB));

        // verdanova set

        addDrop(ModBlocks.VERDANOVADOOR, doorDrops(ModBlocks.VERDANOVADOOR));
        addDrop(ModBlocks.VERDANOVASLAB, slabDrops(ModBlocks.VERDANOVASLAB));

        addDrop(ModBlocks.CARNATION);
        addPottedPlantDrops(ModBlocks.POTTEDCARNATION);
        addDrop(ModBlocks.VERDANOVALOG);
        addDrop(ModBlocks.VERDANOVAWOOD);
        addDrop(ModBlocks.STRIPPEDVERDANOVALOG);
        addDrop(ModBlocks.STRIPPEDVERDANOVAWOOD);
        addDrop(ModBlocks.VERDANOVAPLANKS);
        addDrop(ModBlocks.VERDANOVASAPLING);
        addDrop(ModBlocks.VERDANOVATRAPDOOR);
        addDrop(ModBlocks.VERDANOVAFENCE);
        addDrop(ModBlocks.VERDANOVAFENCEGATE);
        addDrop(ModBlocks.VERDANOVASTAIRS);

        addDrop(ModBlocks.VERDANOVALEAVES, leavesDrops(ModBlocks.VERDANOVALEAVES,
                ModBlocks.VERDANOVASAPLING, 0.0180f)); //   SAPLING DROP

    }

    public LootTable.Builder copperLikeOreDrops(Block drop, Item item) {
        return dropsWithSilkTouch(
                drop,
                (LootPoolEntry.Builder<?>)this.applyExplosionDecay(
                        drop,
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 5.0F)))
                                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                )
        );
    }
}
