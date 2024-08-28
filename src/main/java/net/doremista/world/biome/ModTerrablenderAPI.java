package net.doremista.world.biome;

import net.doremista.Doremitales;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(Doremitales.MOD_ID, "overworld"), 4));

        // i'm not using surface rules for now
        //SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, Doremitales.MOD_ID, ModMaterialRules.makeRules());
    }
}
