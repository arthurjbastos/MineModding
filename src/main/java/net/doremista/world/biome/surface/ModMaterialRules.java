package net.doremista.world.biome.surface;

import net.doremista.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;

public class ModMaterialRules {

    //   -------- I'M NOT USING SURFACE RULES BECAUSE THEY ARE DUMB -------

    private static final MaterialRules.MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRules.MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRules.MaterialRule CARNATION = makeStateRule(ModBlocks.CARNATION);

//    public static MaterialRules.MaterialRule makeRules() {
//        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
//
//        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
//
//        return MaterialRules.sequence(
//                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.ALCATRAZ),
//                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, RAW_RUBY)),
//                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, RUBY)),
//
//                // Default to a grass and dirt surface
//                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
//        );
//    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}
