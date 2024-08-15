package net.doremista.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.doremista.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {




    private static final Identifier VILLAGE_WEAPONSMITH_ID =
            new Identifier("minecraft", "chests/village/village_weaponsmith");

    private static final Identifier VILLAGE_ARMORER_ID =
            new Identifier("minecraft", "chests/village/village_armorer");

    private static final Identifier SUSPICIOUS_SAND_ID =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    private static final Identifier SUSPICIOUS_GRAVEL_ID =
            new Identifier("minecraft", "archaeology/ocean_ruin_cold");

    private static final Identifier SIMPLE_DUNGEON_ID =
            new Identifier("minecraft", "chests/simple_dungeon");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if(SIMPLE_DUNGEON_ID.equals(id)) { // página 1 em dungeon
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.09f))
                        .with(ItemEntry.builder(ModItems.CODEXPAGE1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

                //              ADAGSTEEL EM VILA

                    if(VILLAGE_ARMORER_ID.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.5f))
                                .with(ItemEntry.builder(ModItems.ADAGSTEELHELMET))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());

                        tableBuilder.pool(poolBuilder.build());
                    }
                    if(VILLAGE_WEAPONSMITH_ID.equals(id)) {
                        LootPool.Builder poolBuilder = LootPool.builder()
                                .rolls(ConstantLootNumberProvider.create(1))
                                .conditionally(RandomChanceLootCondition.builder(0.8f))
                                .with(ItemEntry.builder(ModItems.ADAGSTEELINGOT))
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 6.0f)).build());

                        tableBuilder.pool(poolBuilder.build());
                    }

                        //  ----------

            if(SIMPLE_DUNGEON_ID.equals(id)) { // disco em dungeon
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.EVELYNTHEMEMUSICDISC))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

        });


        LootTableEvents.REPLACE.register((resourceManager1, lootManager1, id, original, source1) -> {
                if(SUSPICIOUS_GRAVEL_ID.equals(id)){
                    List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                    entries.add(ItemEntry.builder(ModItems.CODEXPAGE1).build());

                    LootPool.Builder pool = LootPool.builder().with(entries);
                    return LootTable.builder().pool(pool).build();
                }

                return null;
            });

        LootTableEvents.REPLACE.register((resourceManager1, lootManager1, id, original, source1) -> {
            if(SUSPICIOUS_SAND_ID.equals(id)){
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));

                entries.add(ItemEntry.builder(ModItems.CODEXPAGE1).build());

                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }
}