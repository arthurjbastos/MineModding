package net.doremista.item;

import net.doremista.Doremitales;
import net.doremista.item.custom.HealerBookItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item KIKIANMASS = registerItem("kikianmass", new Item(new FabricItemSettings()));
    public static final Item LETTERA = registerItem("lettera", new Item(new FabricItemSettings()));
    public static final Item PERFECTTENCAKE = registerItem("perfecttencake", new Item(new FabricItemSettings().food(ModFoodComponents.PERFECTTENCAKE)));

    public static final Item HEALERBOOK = registerItem("healerbook",
            new HealerBookItem(new FabricItemSettings().maxCount(1).maxDamage(120)));
    public static final Item KIKIANMASSPICKAXE = registerItem("kikianmasspickaxe",
            new PickaxeItem(ModToolMaterial.KIKIANMASS, 3, 4f, new FabricItemSettings()));
    public static final Item KIKIANMASSSWORD = registerItem("kikianmasssword",
            new SwordItem(ModToolMaterial.KIKIANMASS, 8, 3f, new FabricItemSettings()));



    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(KIKIANMASS);
        entries.add(LETTERA);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Doremitales.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Doremitales.LOGGER.info("Registring Mod Items for " + Doremitales.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
