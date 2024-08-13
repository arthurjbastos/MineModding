package net.doremista.datagen;

import net.doremista.block.ModBlocks;
import net.doremista.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
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
        addDrop(ModBlocks.ADAGSTEELBUTTON);
        addDrop(ModBlocks.ADAGSTEELPRESSUREPLATE);
        addDrop(ModBlocks.ADAGSTEELWALL);
        addDrop(ModBlocks.ADAGSTEELSTAIRS);

        addDrop(ModBlocks.BENCH);

        addDrop(ModBlocks.ADAGSTEELDOOR, doorDrops(ModBlocks.ADAGSTEELDOOR));
        addDrop(ModBlocks.ADAGSTEELSLAB, slabDrops(ModBlocks.ADAGSTEELSLAB));

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
