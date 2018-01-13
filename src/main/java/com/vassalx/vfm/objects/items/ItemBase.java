package com.vassalx.vfm.objects.items;

import com.vassalx.vfm.ForgottenLandsMod;
import com.vassalx.vfm.init.ItemInit;
import com.vassalx.vfm.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel{
	
	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ItemInit.ITEMS.add(this);
	}

	public void registerModels() {
		ForgottenLandsMod.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
