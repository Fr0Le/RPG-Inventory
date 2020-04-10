package ru.fr0le.rpg.items.jewels;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import ru.fr0le.rpg.Info;
import ru.fr0le.rpg.creativetabs.LoadTab;
import ru.fr0le.rpg.items.jewels.JewelsType.customJewel;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeRing;

public class ItemRing extends CustomItemJewel implements jewelTypeRing, customJewel {	

	public ItemRing(String texture) {
		this.setTextureName(Info.modid + ":" + texture);
		this.setCreativeTab(LoadTab.tabRPGi);
		this.setMaxStackSize(1);
		this.setMaxDamage(1000);
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean par4) {
		JewelsType.getDescription(line);
	}	

}