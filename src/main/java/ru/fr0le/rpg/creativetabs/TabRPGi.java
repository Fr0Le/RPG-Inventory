package ru.fr0le.rpg.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import ru.fr0le.rpg.items.armor.LoadItemArmor;

public class TabRPGi extends CreativeTabs {
	
	public TabRPGi(int nextID, String lable) {
		super(nextID, lable);
	}

	@Override
	public Item getTabIconItem() {
		return LoadItemArmor.body;
	}
	
}
