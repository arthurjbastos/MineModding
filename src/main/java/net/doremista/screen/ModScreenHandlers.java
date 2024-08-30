package net.doremista.screen;

import net.doremista.Doremitales;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<HardagsteelForgeScreenHandler> HARDAGSTEEL_FORGE_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(Doremitales.MOD_ID, "hardagsteelforge"),
                    new ExtendedScreenHandlerType<>(HardagsteelForgeScreenHandler::new));

    public static void registerScreenHandlers() {
        Doremitales.LOGGER.info("Registering Screen Handlers for DoremiTales");
    }

}
