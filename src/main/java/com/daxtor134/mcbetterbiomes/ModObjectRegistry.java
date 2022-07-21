package com.daxtor134.mcbetterbiomes;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModObjectRegistry
{
	// Deferred Register for Blocks.
	private static final DeferredRegister<Block> BLOCKS =
		DeferredRegister.create(ForgeRegistries.BLOCKS, MCBetterBiomes.MOD_ID);

	public static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
	{
		RegistryObject<T> toReturn = BLOCKS.register(name, block);
		registerBlockItem(name, toReturn, tab);
		return toReturn;
	}

	public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
	{
		return ITEMS.register(name, () -> new BlockItem(block.get(),
			new Item.Properties().tab(tab)));
	}

	// Deferred Register for Items.
	private static final DeferredRegister<Item> ITEMS =
		DeferredRegister.create(ForgeRegistries.ITEMS, MCBetterBiomes.MOD_ID);

	public static void register(IEventBus eventBus)
	{
		BLOCKS.register(eventBus);
		ITEMS.register(eventBus);
	}
}
