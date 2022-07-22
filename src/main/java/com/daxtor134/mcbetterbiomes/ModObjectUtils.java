package com.daxtor134.mcbetterbiomes;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModObjectUtils
{
	public static final DeferredRegister<Block> MOD_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MCBetterBiomes.MOD_ID);
	public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MCBetterBiomes.MOD_ID);

	public static void registerObjects(IEventBus eventBus)
	{
		MOD_BLOCKS.register(eventBus);
		MOD_ITEMS.register(eventBus);
	}

	public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
	{
		return MOD_ITEMS.register(name,
			() -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	// Method will return a new Block as well as Block Item using the registerBlockItem method.
	public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
	{
		RegistryObject<T> returnObject = MOD_BLOCKS.register(name, block);
		registerBlockItem(name, returnObject, tab);
		return returnObject;
	}

	@SuppressWarnings("unused")
	public static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block)
	{
		return MOD_BLOCKS.register(name, block);
	}

	public static <T extends Item> RegistryObject<T> registerItem(String name, Supplier<T> item)
	{
		RegistryObject<T> returnObject = MOD_ITEMS.register(name, item);
		return returnObject;
	}

	// ******************************************************************************************************************
	// Mod Items and Blocks. Each object will a comment signifying whether it is an Item or a Block.

	@SuppressWarnings("unused") // Block w/ Forge Tags.
	public static final RegistryObject<Block> REDWOOD_LOG = registerBlock("redwood_log",
		() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(9.0f).sound(SoundType.WOOD)),
		CreativeModeTab.TAB_BUILDING_BLOCKS);

	@SuppressWarnings("unused") // Block w/ Forge Tags.
	public static final RegistryObject<Block> REDWOOD_WOOD = registerBlock("redwood_wood",
		() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(9.0f).sound(SoundType.WOOD)),
		CreativeModeTab.TAB_BUILDING_BLOCKS);

	@SuppressWarnings("unused") // Block w/ Forge Tags.
	public static final RegistryObject<Block> STRIPPED_REDWOOD_WOOD = registerBlock("stripped_redwood_wood",
		() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(9.0f).sound(SoundType.WOOD)),
		CreativeModeTab.TAB_BUILDING_BLOCKS);

	@SuppressWarnings("unused") // Block w/ Forge Tags.
	public static final RegistryObject<Block> STRIPPED_REDWOOD_LOG = registerBlock("stripped_redwood_log",
		() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(9.0f).sound(SoundType.WOOD)),
		CreativeModeTab.TAB_BUILDING_BLOCKS);

	@SuppressWarnings("unused") // Block w/ Forge Tags.
	public static final RegistryObject<Block> REDWOOD_PLANKS = registerBlock("redwood_planks",
		() -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f).sound(SoundType.WOOD)),
		CreativeModeTab.TAB_BUILDING_BLOCKS);

	@SuppressWarnings("unused") // Block w/ Forge Tags.
	public static final RegistryObject<Block> REDWOOD_LEAVES = registerBlock("redwood_leaves",
		() -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES).noOcclusion()
			.strength(0.2f).sound(SoundType.GRASS)), CreativeModeTab.TAB_BUILDING_BLOCKS);
}
