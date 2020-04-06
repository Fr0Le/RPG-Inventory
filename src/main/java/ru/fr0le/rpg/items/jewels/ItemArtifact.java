package ru.fr0le.rpg.items.jewels;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.fr0le.rpg.Info;
import ru.fr0le.rpg.creativetabs.LoadTab;
import ru.fr0le.rpg.items.jewels.JewelsType.customJewel;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeArtifact;

public class ItemArtifact extends CustomItemJewel implements jewelTypeArtifact, customJewel {	
	
	public ItemArtifact(String texture) {
        this.setTextureName(Info.modid + ":" + texture);
        this.setCreativeTab(LoadTab.tabRPGi);
        this.setMaxStackSize(1);
        this.setMaxDamage(1000);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean par4) {
		JewelsType.getDescription(line);
    }	
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {
       super.onUpdate(stack, world, entity, par4, par5);
       
       //Что-то дает       
	} 
	
}