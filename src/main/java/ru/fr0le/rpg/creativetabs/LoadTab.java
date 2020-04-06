package ru.fr0le.rpg.creativetabs;

import net.minecraft.creativetab.CreativeTabs;

public class LoadTab {
	
	public static CreativeTabs tabRPGi;
	
	public static void registerTabs() {
		tabRPGi = new TabRPGi(CreativeTabs.getNextID(), "tabRPGi");
	}
	
}
