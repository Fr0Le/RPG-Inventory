package ru.fr0le.rpg.client.render;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.fr0le.rpg.client.render.armor.RenderEquipArmor;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypePants;

public class RenderPants {
	
	public RenderPants() {
		
	}
	
	public void render(EntityPlayer player, RenderPlayer renderModel) {
		ItemStack equipStack = player.getCurrentArmor(1);
		Item equip = equipStack.getItem();
		
		if(equip instanceof armorTypePants) RenderEquipArmor.renderPants(renderModel, equip);	
	}
	
}
