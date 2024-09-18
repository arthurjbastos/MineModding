package net.doremista.villager;

import com.google.common.collect.ImmutableSet;
import net.doremista.Doremitales;
import net.doremista.block.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterest;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> BOOKSHELF_POI_KEY = poiKey("bookshelfpoi");
    public static final PointOfInterestType BOOKSHELF_POI = registerPoi("bookshelfpoi", Blocks.CHISELED_BOOKSHELF);

    public static final VillagerProfession LORE_MASTER = registerProfession("lore_master", BOOKSHELF_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(Doremitales.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        // ticket count = how many villagers can get the job from that workstation
        return PointOfInterestHelper.register(new Identifier(Doremitales.MOD_ID, name), 1, 1, block);

    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(Doremitales.MOD_ID, name));

    }

    public static void registerVillagers() {
        Doremitales.LOGGER.info("Registering Villagers" + Doremitales.MOD_ID);
    }
}
