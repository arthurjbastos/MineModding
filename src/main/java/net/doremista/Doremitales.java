package net.doremista;

import net.doremista.block.ModBlocks;
import net.doremista.block.entity.ModBlockEntities;
import net.doremista.entity.ModEntities;
import net.doremista.entity.ModEntitiesSpawn;
import net.doremista.entity.custom.RubberChickenEntity;
import net.doremista.item.ModItemGroups;
import net.doremista.item.ModItems;
import net.doremista.recipe.ModRecipes;
import net.doremista.screen.ModScreenHandlers;
import net.doremista.sound.ModSounds;
import net.doremista.util.ModCustomTrades;
import net.doremista.util.ModLootTableModifiers;
import net.doremista.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.JukeboxBlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

import static net.minecraft.block.JukeboxBlock.HAS_RECORD;

public class Doremitales implements ModInitializer {
	public static final String MOD_ID = "doremitales";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();
		ModSounds.registerSounds();
		ModRecipes.registerRecipes();
		ModLootTableModifiers.modifyLootTables();
		ModCustomTrades.reigsterCustomTrades();
		ModWorldGeneration.generateModWorldGen();
		ModEntities.registerModEntities();
		ModScreenHandlers.registerScreenHandlers();
		FabricDefaultAttributeRegistry.register(ModEntities.RUBBERCHICKEN, RubberChickenEntity.createRubberChickenAttributes());
		ModEntitiesSpawn.addEntitySpawn();

		//valores default p/ inflamavel:
		//planks: 5, 20; logs: 5, 5; leaves: 30, 60;
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANOVALOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANOVAWOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPEDVERDANOVALOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPEDVERDANOVAWOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANOVAPLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.VERDANOVALEAVES, 1, 1);

		// Registrar o evento de quebra de bloco
		PlayerBlockBreakEvents.BEFORE.register((world, player, pos, state, blockEntity) -> {

			if (!world.isClient && state.isOf(Blocks.JUKEBOX)) {
				// Verificar se a Jukebox está tocando
				if (blockEntity instanceof JukeboxBlockEntity jukebox && state.get(HAS_RECORD)) {
					Random random = new Random();

					// Remover o disco da Jukebox
					ItemStack recordStack = jukebox.getStack().copy();
					jukebox.clear();

					// 50% de chance de dropar o disco
					if (random.nextBoolean()) {
						Vec3d dropPos = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
						ItemEntity recordEntity = new ItemEntity(world, dropPos.x, dropPos.y, dropPos.z, recordStack);
						world.spawnEntity(recordEntity);
					}

					// Destruir o bloco da Jukebox sem dropar o bloco
					world.removeBlock(pos, false);

					// Dropar o item ILUMSHARD
					dropIlumShard(world, pos);

					// Cancelar o drop padrão
					return false;
				}
			}
			// Retorna true para permitir que o bloco seja quebrado normalmente se não tiver disco tocando
			return true;
		});

	}

	private void dropIlumShard(World world, BlockPos pos) {
		ItemStack ilumShardStack = new ItemStack(ModItems.ILUMSHARD);
		Vec3d dropPos = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);
		ItemEntity itemEntity = new ItemEntity(world, dropPos.x, dropPos.y, dropPos.z, ilumShardStack);
		world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, 1.0F, 1.0F);
		world.spawnEntity(itemEntity);
	}
}
