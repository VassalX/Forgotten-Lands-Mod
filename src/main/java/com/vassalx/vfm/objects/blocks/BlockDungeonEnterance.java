package com.vassalx.vfm.objects.blocks;

import java.util.TimerTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import com.vassalx.vfm.objects.items.ItemDungeonKey;
import com.vassalx.vfm.util.LinkedQueue;
import com.vassalx.vfm.util.ModConstants;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import scala.collection.mutable.Queue;
import scala.reflect.internal.util.Set;

public class BlockDungeonEnterance extends BlockBase {

	public BlockDungeonEnterance() {
		super("block_dungeon_enterance", Material.ROCK);
		setBlockUnbreakable();
	}

	private static long dstrDelayTicks = 2;
	private static long dstrDelayMilSec = dstrDelayTicks * ModConstants.MILSEC_IN_TICK;

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		
		Item heldItem = playerIn.getHeldItem(hand).getItem();
		System.out.println(facing.toString());
		
		if (heldItem instanceof ItemDungeonKey) {
			
			playerIn.getHeldItem(hand).shrink(1);
			LinkedQueue<BlockPos> queue = new LinkedQueue<BlockPos>();
			HashMap<BlockPos, Boolean> marked = new HashMap<BlockPos, Boolean>();
			
			queue.enqueue(pos);
			marked.put(pos, true);
			long count = 0;
			
			while (!queue.isEmpty()) {
				
				count++;
				BlockPos v = queue.dequeue();
				delayedDestroy(worldIn, v, false,count);
				
				for (BlockPos w : v.getAllInBox(v.getX() - 1, v.getY() - 1, v.getZ() - 1, v.getX() + 1, v.getY() + 1, v.getZ() + 1)) {
					if (worldIn.getBlockState(w).getBlock() instanceof BlockDungeonEnterance && !marked.containsKey(w)) {
						marked.put(w, true);
						queue.enqueue(w);
					}
				}
			}
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
	}

	private static void delayedDestroy(World worldIn, BlockPos pos, boolean drop,long count) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if (worldIn.isRemote)
					worldIn.setBlockToAir(pos);
				else
					worldIn.destroyBlock(pos, drop);
			}
		}, dstrDelayMilSec*count);
	}

}
