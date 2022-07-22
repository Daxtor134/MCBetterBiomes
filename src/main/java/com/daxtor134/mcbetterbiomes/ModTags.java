package com.daxtor134.mcbetterbiomes;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

@SuppressWarnings("unused")
public class ModTags
{
	public static class ModBlocks
	{
		public static final TagKey<Block> REDWOOD_LOG = forgeTag("redwood_log");
		public static final TagKey<Block> REDWOOD_WOOD = forgeTag("redwood_wood");
		public static final TagKey<Block> REDWOOD_PLANKS = forgeTag("redwood_planks");
		public static final TagKey<Block> REDWOOD_LEAVES = forgeTag("redwood_leaves");
		public static final TagKey<Block> STRIPPED_REDWOOD_LOG = forgeTag("stripped_redwood_log");
		public static final TagKey<Block> STRIPPED_REDWOOD_WOOD = forgeTag("stripped_redwood_wood");

		private static TagKey<Block> tag(String name)
		{
			return BlockTags.create(new ResourceLocation(MCBetterBiomes.MOD_ID, name));
		}

		private static TagKey<Block> forgeTag(String name)
		{
			return BlockTags.create(new ResourceLocation("forge", name));
		}
	}

	public static class ModItems
	{
		private static TagKey<Item> tag(String name)
		{
			return ItemTags.create(new ResourceLocation(MCBetterBiomes.MOD_ID, name));
		}

		private static TagKey<Item> forgeTag(String name)
		{
			return ItemTags.create(new ResourceLocation("forge", name));
		}
	}
}
