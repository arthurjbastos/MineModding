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
import net.minecraft.entity.damage.DamageType;
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

    public static final Item KIKIANMASS = registerItem("kikianmass", new Item(new FabricItemSettings()) {
        //todo
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
    public static final Item BATCHERSTHEMEMUSICDISC = registerItem("batchersthememusicdisc",
            new MusicDiscItem(7, ModSounds.BATCHERSTHEME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 79));
    public static final Item ELEPHASTICTHEMEMUSICDISC = registerItem("elephasticthememusicdisc",
            new MusicDiscItem(7, ModSounds.ELEPHASTICTHEME, new FabricItemSettings().maxCount(1).rarity(Rarity.RARE), 197));


    public static final Item CODEXPAGE1 = registerItem("codexpage1",
            new CodexPage1Item(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item EVELYNLORE = registerItem("evelynlore",
            new EvelynLoreItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item ELEPHASTICLORE = registerItem("elephasticlore",
            new ElephasticLoreItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item BATCHERSLORE = registerItem("batcherslore",
            new BatchersLoreItem(new FabricItemSettings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item HARDAGSTEELGUIDE1 = registerItem("hardagsteelguide1",
            new HardagsteelGuide1Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));

    public static final Item HARDAGSTEELGUIDE2 = registerItem("hardagsteelguide2",
            new HardagsteelGuide2Item(new FabricItemSettings().maxCount(1).rarity(Rarity.UNCOMMON)));

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
    public static final Item HARDAGSTEELMOLD = registerItem("hardagsteelmold", new Item(new FabricItemSettings().rarity(Rarity.UNCOMMON)));

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


    //      ADAGSTEEL TOOL VALORES IGUAIS AO FERRO literalmente
    public static final Item ADAGSTEELSWORD = registerItem("adagsteelsword",
            new SwordItem(ModToolMaterial.ADAGSTEEL, 3, -2.4f, new FabricItemSettings()));
    public static final Item ADAGSTEELPICKAXE = registerItem("adagsteelpickaxe",
            new PickaxeItem(ModToolMaterial.ADAGSTEEL, 1, -2.8f, new FabricItemSettings()));
    public static final Item ADAGSTEELAXE = registerItem("adagsteelaxe",
            new AxeItem(ModToolMaterial.ADAGSTEEL, 6.0f, -3.1f, new FabricItemSettings()));
    public static final Item ADAGSTEELSHOVEL = registerItem("adagsteelshovel",
            new ShovelItem(ModToolMaterial.ADAGSTEEL, 1.5f, -3.0f, new FabricItemSettings()));
    public static final Item ADAGSTEELHOE = registerItem("adagsteelhoe",
            new HoeItem(ModToolMaterial.ADAGSTEEL, -2, -1.0f, new FabricItemSettings()));

    //      ADAGSTEEL ARMOR
    public static final Item ADAGSTEELHELMET = registerItem("adagsteelhelmet",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item ADAGSTEELCHESTPLATE = registerItem("adagsteelchestplate",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item ADAGSTEELLEGGINGS = registerItem("adagsteelleggings",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item ADAGSTEELBOOTS = registerItem("adagsteelboots",
            new ArmorItem(ModArmorMaterials.ADAGSTEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //      HARDAGSTEEL
    public static final Item ADAGSTEELIMBUED = registerItem("adagsteelimbued", new AdagsteelImbuedItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item MELTEDADAGSTEELALLOY = registerItem("meltedadagsteelalloy", new MeltedAdagsteelAlloyItem(new FabricItemSettings().rarity(Rarity.UNCOMMON)));
    public static final Item HARDAGSTEELALLOY = registerItem("hardagsteelalloy", new Item(new FabricItemSettings().rarity(Rarity.RARE).fireproof()) {
        @Override
        public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelalloy.tooltip"));
                tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelalloy.tooltip_2"));
                tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelalloy.tooltip_3"));
                tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelalloy.tooltip_4"));
            } else {
                tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
            }
            super.appendTooltip(stack, world, tooltip, context);
        }
    });

    //      HARDAGSTEEL TOOLS
    //      ToolMaterials.class might help but not actually IDK about those values they are weird
    public static final Item HARDAGSTEELSWORD = registerItem("hardagsteelsword",
            new SwordItem(ModToolMaterial.HARDAGSTEEL, 3, -2.2f, new FabricItemSettings()));
    public static final Item HARDAGSTEELPICKAXE = registerItem("hardagsteelpickaxe",
            new PickaxeItem(ModToolMaterial.HARDAGSTEEL, 1, -2.7f, new FabricItemSettings()));
    public static final Item HARDAGSTEELAXE = registerItem("hardagsteelaxe",
            new AxeItem(ModToolMaterial.HARDAGSTEEL, 5.0f, -2.9f, new FabricItemSettings()));
    public static final Item HARDAGSTEELSHOVEL = registerItem("hardagsteelshovel",
            new ShovelItem(ModToolMaterial.HARDAGSTEEL, 1.6f, -3.0f, new FabricItemSettings()));
    public static final Item HARDAGSTEELHOE = registerItem("hardagsteelhoe",
            new HoeItem(ModToolMaterial.HARDAGSTEEL, -3, 0.0f, new FabricItemSettings()));


    //  HARDAGSTEEL ARMOR
    public static final Item LUMANDIAHELMET = registerItem("lumandiahelmet",
            new ModArmorItem(ModArmorMaterials.LUMANDIA, ArmorItem.Type.HELMET, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });
    public static final Item LUMANDIACHESTPLATE = registerItem("lumandiachestplate",
            new ArmorItem(ModArmorMaterials.LUMANDIA, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });
    public static final Item LUMANDIALEGGINGS = registerItem("lumandialeggings",
            new ArmorItem(ModArmorMaterials.LUMANDIA, ArmorItem.Type.LEGGINGS, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });
    public static final Item LUMANDIABOOTS = registerItem("lumandiaboots",
            new ArmorItem(ModArmorMaterials.LUMANDIA, ArmorItem.Type.BOOTS, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.lumandiaset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });


    //      LUMANDIA ARMOR
    public static final Item HARDAGSTEELHELMET = registerItem("hardagsteelhelmet",
            new ModArmorItem(ModArmorMaterials.HARDAGSTEEL, ArmorItem.Type.HELMET, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });
    public static final Item HARDAGSTEELCHESTPLATE = registerItem("hardagsteelchestplate",
            new ArmorItem(ModArmorMaterials.HARDAGSTEEL, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });
    public static final Item HARDAGSTEELLEGGINGS = registerItem("hardagsteelleggings",
            new ArmorItem(ModArmorMaterials.HARDAGSTEEL, ArmorItem.Type.LEGGINGS, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });
    public static final Item HARDAGSTEELBOOTS = registerItem("hardagsteelboots",
            new ArmorItem(ModArmorMaterials.HARDAGSTEEL, ArmorItem.Type.BOOTS, new FabricItemSettings()) {
                @Override
                public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
                    if (Screen.hasShiftDown()) {
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_2"));
                        tooltip.add(Text.translatable("tooltip.doremitales.hardagsteelset.tooltip_3"));
                    } else {
                        tooltip.add(Text.translatable("tooltip.doremitales.tooltip.shift"));
                    }
                    super.appendTooltip(stack, world, tooltip, context);
                }
            });

    // MOBS

    public static final Item RUBBERCHICKENSPAWNEGG = registerItem("rubberchickenspawnegg",
            new SpawnEggItem(ModEntities.RUBBERCHICKEN, 0xcf0000, 0xf7ff1c, new FabricItemSettings()));
    
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
