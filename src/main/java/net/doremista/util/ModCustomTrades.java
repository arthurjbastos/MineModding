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

        // rubber chicken book
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 7),
                            customBooks.get(0),  // Usa o ItemStack criado
                            4, 5, 0.03f));
                });

        // neeth
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 8),
                            customBooks.get(3),  // Usa o ItemStack criado
                            4, 5, 0.05f));
                });

        // carminox
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 18),
                            customBooks.get(1),  // Usa o ItemStack criado
                            4, 15, 0.05f));
                });

        // verdanova
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 2,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 16),
                            customBooks.get(2),  // Usa o ItemStack criado
                            4, 15, 0.05f));
                });

        // nivel 3 aq

        // kate's journal
        TradeOfferHelper.registerVillagerOffers(ModVillagers.LORE_MASTER, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 20),
                            customBooks.get(4),  // Usa o ItemStack criado
                            2, 25, 0.07f));
                });


        //  HARDAGSTEEL MOLD
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.WEAPONSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(ModItems.HARDAGSTEELMOLD, 1),
                            2, 17, 0.09f));
                });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.TOOLSMITH, 4,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.EMERALD, 32),
                            new ItemStack(ModItems.HARDAGSTEELMOLD, 1),
                            2, 17, 0.09f));
                });
    }
}
