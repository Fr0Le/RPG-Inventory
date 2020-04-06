package ru.fr0le.rpg.items.jewels;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class LoadItemJewels {
	
	public static Item necklace = new ItemNecklace("necklace").setUnlocalizedName("necklace");
	public static Item ringRed = new ItemRing("ringRed").setUnlocalizedName("ringRed");
	public static Item ringBlue = new ItemRing("ringBlue").setUnlocalizedName("ringBlue");
	public static Item artifact = new ItemArtifact("artifact").setUnlocalizedName("artifact");
	
	public LoadItemJewels() {
		registerItem(necklace);	
		registerItem(ringRed);		
		registerItem(ringBlue);	
		registerItem(artifact);	
	}
	
    private void registerItem(Item i) {
		String name = i.getUnlocalizedName().replace("item.", "");
		GameRegistry.registerItem(i, name);
	}
    
}
