package com.vassalx.vfm.init;

import java.util.ArrayList;
import java.util.List;

import com.vassalx.vfm.objects.blocks.BlockBase;
import com.vassalx.vfm.objects.blocks.BlockDungeonEnterance;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;

public class BlockInit {
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_DUNGEON_ENTERANCE = new BlockDungeonEnterance();
}
