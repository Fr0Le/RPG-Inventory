package ru.fr0le.rpg.items.armor;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class LoadItemArmor {

	public static ItemArmor helmet, body, pants, boots;
	public static Item shoulders, bracers, gloves, belt;	

	public static ArmorMaterial ARMOR;

	public static void registerItems() {
		ARMOR = EnumHelper.addArmorMaterial("ARMOR", 100, new int[] {4, 7, 6, 3}, 0);

		helmet = new ItemCustomArmor.Helmet(LoadItemArmor.ARMOR, 0, 0);
		body = new ItemCustomArmor.Body(LoadItemArmor.ARMOR, 1, 1);
		pants = new ItemCustomArmor.Pants(LoadItemArmor.ARMOR, 2, 2);
		boots = new ItemCustomArmor.Boots(LoadItemArmor.ARMOR, 3, 3);	

		shoulders = new ItemCustomArmor.Shoulders();
		bracers = new ItemCustomArmor.Bracers();
		gloves = new ItemCustomArmor.Gloves();
		belt = new ItemCustomArmor.Belt();

		GameRegistry.registerItem(helmet, helmet.getUnlocalizedName());
		GameRegistry.registerItem(body, body.getUnlocalizedName());
		GameRegistry.registerItem(pants, pants.getUnlocalizedName());
		GameRegistry.registerItem(boots, boots.getUnlocalizedName());

		GameRegistry.registerItem(shoulders, shoulders.getUnlocalizedName());
		GameRegistry.registerItem(bracers, bracers.getUnlocalizedName());
		GameRegistry.registerItem(gloves, gloves.getUnlocalizedName());
		GameRegistry.registerItem(belt, belt.getUnlocalizedName());
	}

}