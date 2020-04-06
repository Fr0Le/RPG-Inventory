package ru.fr0le.rpg.client.render;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import ru.fr0le.rpg.client.render.armor.RenderEquipArmor;
import ru.fr0le.rpg.containers.ContainerCustomPlayer;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBracers;

public class RenderBracers {
	
	public RenderBracers() {
		
	}
	
	public void render(EntityPlayer player, RenderPlayer renderModel) {
		ItemStack equipStack = ExtendedPlayer.get(player).inventory.getStackInSlot(ContainerCustomPlayer.slotBracers);
		Item equip = equipStack.getItem();
		
		if(equip instanceof armorTypeBracers) RenderEquipArmor.renderBracers(renderModel, equip);
	}
	
}
