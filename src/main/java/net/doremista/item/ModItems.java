package net.doremista.item;

import net.doremista.Doremitales;
import net.doremista.item.custom.HealerBookItem;
import net.doremista.item.custom.RatchattsItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ModItems {

    public static final Item KIKIANMASS = registerItem("kikianmass", new Item(new FabricItemSettings()));
    public static final Item ADAGSTEELINGOT = registerItem("adagsteelingot", new Item(new FabricItemSettings()));
    public static final Item RAWADAGSTEEL = registerItem("rawadagsteel", new Item(new FabricItemSettings()));
    public static final Item LETTERA = registerItem("lettera", new Item(new FabricItemSettings()));
    public static final Item PERFECTTENCAKE = registerItem("perfecttencake", new Item(new FabricItemSettings().food(ModFoodComponents.PERFECTTENCAKE)));

    //      TOOLS
    public static final Item HEALERBOOK = registerItem("healerbook",
            new HealerBookItem(new FabricItemSettings().maxCount(1).maxDamage(120)));
    public static final Item KIKIANMASSPICKAXE = registerItem("kikianmasspickaxe",
            new PickaxeItem(ModToolMaterial.KIKIANMASS, 3, 4f, new FabricItemSettings()));
    public static final Item KIKIANMASSSWORD = registerItem("kikianmasssword",
            new SwordItem(ModToolMaterial.KIKIANMASS, 8, 3f, new FabricItemSettings()));

    public static final Item RATCHATTS = registerItem("ratchatts",
            new RatchattsItem(new FabricItemSettings().maxCount(1).maxDamage(360).rarity(Rarity.UNCOMMON)));


    //      ADAGSTEEL TOOL
    public static final Item ADAGSTEELSWORD = registerItem("adagsteelsword",
            new SwordItem(ModToolMaterial.ADAGSTEEL, 3, -2.5f, new FabricItemSettings()));
    public static final Item ADAGSTEELPICKAXE = registerItem("adagsteelpickaxe",
            new PickaxeItem(ModToolMaterial.ADAGSTEEL, 1, -2.8f, new FabricItemSettings()));
    public static final Item ADAGSTEELAXE = registerItem("adagsteelaxe",
            new AxeItem(ModToolMaterial.ADAGSTEEL, 6, -3.1f, new FabricItemSettings()));
    public static final Item ADAGSTEELSHOVEL = registerItem("adagsteelshovel",
            new ShovelItem(ModToolMaterial.ADAGSTEEL, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item ADAGSTEELHOE = registerItem("adagsteelhoe",
            new HoeItem(ModToolMaterial.ADAGSTEEL, -2, 1.0f, new FabricItemSettings()));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(KIKIANMASS);
        entries.add(LETTERA);
        entries.add(ADAGSTEELINGOT);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Doremitales.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Doremitales.LOGGER.info("Registring Mod Items for " + Doremitales.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
