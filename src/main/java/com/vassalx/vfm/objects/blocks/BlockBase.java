package com.vassalx.vfm.objects.blocks;

import com.vassalx.vfm.ForgottenLandsMod;
import com.vassalx.vfm.init.BlockInit;
import com.vassalx.vfm.init.ItemInit;
import com.vassalx.vfm.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel{

	public BlockBase(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public void registerModels() {
		ForgottenLandsMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
