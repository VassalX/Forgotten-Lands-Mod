package com.vassalx.vfm.init;

import java.util.ArrayList;
import java.util.List;

import com.vassalx.vfm.objects.items.ItemBase;
import com.vassalx.vfm.objects.items.ItemDungeonKey;

import net.minecraft.item.Item;

public class ItemInit {
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item DUNGEON_KEY = new ItemDungeonKey();
}
