package net.doremista.item;

import net.doremista.Doremitales;
import net.doremista.entity.ModEntities;
import net.doremista.item.custom.*;
import net.doremista.sound.ModSounds;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {

    //              TEST ITEMS

    public static final Item LETTERA = registerItem("lettera", new Item(new FabricItemSettings()){
        //todo
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.translatable("tooltip.doremitales.test.tooltip"));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    public static final Item KIKIANMASS = registerItem("kikianmass", new Item(new FabricItemSettings()) {
        //todo
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            tooltip.add(Text.translatable("tooltip.doremitales.test.tooltip"));
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    public static final Item KIKIANMASSPICKAXE = registerItem("kikianmasspickaxe",
            new PickaxeItem(ModToolMaterial.KIKIANMASS, 3, 4f, new FabricItemSettings()){
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(Text.translatable("tooltip.doremitales.test.tooltip"));
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });


    public static final Item KIKIANMASSSWORD = registerItem("kikianmasssword",
            new SwordItem(ModToolMaterial.KIKIANMASS, 8, 3f, new FabricItemSettings()){
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(Text.translatable("tooltip.doremitales.test.tooltip"));
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });

    //              FIM DOS TEST ITEMS


    public static final Item ILUMSHARD = registerItem("ilumshard", new IlumItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item ILUM = registerItem("ilum", new IlumItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item EVELYNTHEMEMUSICDISC = registerItem("evelynthememusicdisc",
            new MusicDiscItem(7, ModSounds.EVELYNTHEME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 140));
    public static final Item SUSUTHEMEMUSICDISC = registerItem("susuthememusicdisc",
            new MusicDiscItem(7, ModSounds.SUSUTHEME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 73));
    public static final Item ELEPHASTICTHEMEMUSICDISC = registerItem("elephasticthememusicdisc",
            new MusicDiscItem(7, ModSounds.ELEPHASTICTHEME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 197));

    //todo musica HORRIVEL MEU DEUS FAZ DIREITO DPS OK

    public static final Item CODEXPAGE1 = registerItem("codexpage1",
            new CodexPage1Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item EVELYNLORE = registerItem("evelynlore",
            new EvelynLoreItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item ELEPHASTICLORE = registerItem("elephasticlore",
            new ElephasticLoreItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));


    public static final Item ADAGIOREDUCER = registerItem("adagioreducer",
            new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    tooltip.add(Text.translatable("tooltip.doremitales.adagioreducer.tooltip"));
                    tooltip.add(Text.translatable("tooltip.doremitales.adagioreducer.tooltip_2"));
                    super.appendTooltip(stack, world, tooltip, context);
                }

                @Override
                public boolean hasGlint(ItemStack stack) {
                    return true;
                }
            }
    );


    public static final Item ADAGSTEELINGOT = registerItem("adagsteelingot", new Item(new FabricItemSettings()));
    public static final Item RAWADAGSTEEL = registerItem("rawadagsteel", new Item(new FabricItemSettings()));
    public static final Item PERFECTTENCAKE = registerItem("perfecttencake", new Item(new FabricItemSettings().food(ModFoodComponents.PERFECTTENCAKE)));
    public static final Item VERDANOVAWOODSPLINTERS = registerItem("verdanovawoodsplinters", new Item(new FabricItemSettings()));
    public static final Item VERDANOVASAP = registerItem("verdanovasap", new VerdanovaSapItem(new FabricItemSettings().food(ModFoodComponents.VERDANOVASAP).rarity(Rarity.UNCOMMON)));
    public static final Item VERDANOVASAPBOTTLE = registerItem("verdanovasapbottle", new VerdanovaSapBottleItem(new FabricItemSettings().food(ModFoodComponents.VERDANOVASAPBOTTLE).maxCount(16).rarity(Rarity.UNCOMMON)));


    //      TOOLS
    public static final Item HEALERBOOK = registerItem("healerbook",
            new HealerBookItem(new FabricItemSettings().maxCount(1).maxDamage(120).rarity(Rarity.UNCOMMON)));
    public static final Item RATCHATTS = registerItem("ratchatts",
            new RatchattsItem(new FabricItemSettings().maxCount(1).maxDamage(360).rarity(Rarity.UNCOMMON)));
    public static final Item AEONFLUTE = registerItem("aeonflute",
            new AeonFluteItem(new FabricItemSettings().maxCount(1).maxDamage(560).rarity(Rarity.UNCOMMON)));
    public static final Item FREQUENCYEXTRACTOR = registerItem("frequencyextractor",
            new FrequencyExtractorItem(new FabricItemSettings().maxCount(1).maxDamage(150).rarity(Rarity.UNCOMMON)));


    //      ADAGSTEEL TOOL
    public static final Item ADAGSTEELSWORD = registerItem("adagsteelsword",
            new SwordItem(ModToolMaterial.ADAGSTEEL, 3, -2.4f, new FabricItemSettings()));
    public static final Item ADAGSTEELPICKAXE = registerItem("adagsteelpickaxe",
            new PickaxeItem(ModToolMaterial.ADAGSTEEL, 1, -2.8f, new FabricItemSettings()));
    public static final Item ADAGSTEELAXE = registerItem("adagsteelaxe",
            new AxeItem(ModToolMaterial.ADAGSTEEL, 6.0f, -3.1f, new FabricItemSettings()));
    public static final Item ADAGSTEELSHOVEL = registerItem("adagsteelshovel",
            new ShovelItem(ModToolMaterial.ADAGSTEEL, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item ADAGSTEELHOE = registerItem("adagsteelhoe",
            new HoeItem(ModToolMaterial.ADAGSTEEL, -2, -3.0f, new FabricItemSettings()));

    //      ADAGSTEEL ARMOR
    public static final Item ADAGSTEELHELMET = registerItem("adagsteelhelmet",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ADAGSTEELCHESTPLATE = registerItem("adagsteelchestplate",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ADAGSTEELLEGGINGS = registerItem("adagsteelleggings",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ADAGSTEELBOOTS = registerItem("adagsteelboots",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    // MOBS

    public static final Item RUBBERCHICKENSPAWNEGG = registerItem("rubberchickenspawnegg",
            new SpawnEggItem(ModEntities.RUBBERCHICKEN, 0xFF0000, 0xFF0000, new FabricItemSettings()));
    
    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        // items p/ tab de ingredientes padrao do mine, n sei pq serve n
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(Doremitales.MOD_ID, name), item);
    }

    public static void registerModItems(){
        Doremitales.LOGGER.info("Registring Mod Items for " + Doremitales.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
