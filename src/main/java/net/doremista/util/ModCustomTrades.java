package net.doremista.util;

import net.doremista.item.ModItems;
import net.doremista.item.customBooks.CustomBooks;
import net.doremista.villager.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

import java.util.List;

public class ModCustomTrades {

    public static void reigsterCustomTrades() {

        List<ItemStack> customBooks = CustomBooks.createAllCustomBooks();

        //        ****** NIVEL 1 ******

        // rubber chicken book
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            customBooks.get(0),  // Usa o ItemStack criado
                            4, 8, 0.03f));
                });

        // adagsteel book
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 9),
                            customBooks.get(10),  // Usa o ItemStack criado
                            4, 9, 0.03f));
                });

        // neeth
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            customBooks.get(3),  // Usa o ItemStack criado
                            4, 8, 0.05f));
                });

        //        ****** NIVEL 2 ******

        // verdanova
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 12),
                            customBooks.get(2),  // Usa o ItemStack criado
                            4, 27, 0.05f));
                });

        // musicism
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 14),
                            customBooks.get(9),  // Usa o ItemStack criado
                            4, 28, 0.05f));
                });

        // pirates
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.BATCHERSLORE, 1),
                            customBooks.get(11),  // Usa o ItemStack criado
                            1, 29, 0.00f));
                });

        //        ****** NIVEL 3 ******

        // bard book
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            customBooks.get(5),  // Usa o ItemStack criado
                            4, 38, 0.06f));
                });

        // ilum book
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 17),
                            customBooks.get(7),  // Usa o ItemStack criado
                            4, 37, 0.06f));
                });

        //        ****** NIVEL 4 ******

        // kate's journal
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 20),
                            customBooks.get(4),  // Usa o ItemStack criado
                            2, 40, 0.07f));
                });

        // lauren's journal
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 23),
                            customBooks.get(8),  // Usa o ItemStack criado
                            2, 48, 0.08f));
                });

        //        ****** NIVEL 5 ******

        // mute maigc book
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 27),
                            customBooks.get(6),  // Usa o ItemStack criado
                            3, 10, 0.07f));
                });

        // carminox
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.EVELYNLORE, 1),
                            customBooks.get(1),  // Usa o ItemStack criado
                            2, 10, 0.00f));
                });

        //        ****** FIM DOS LIVROS ******

        //  HARDAGSTEEL MOLD
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(ModItems.HARDAGSTEELMOLD, 1),
                            1, 20, 0.09f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(ModItems.HARDAGSTEELMOLD, 1),
                            1, 20, 0.09f));
                });
    }
}
