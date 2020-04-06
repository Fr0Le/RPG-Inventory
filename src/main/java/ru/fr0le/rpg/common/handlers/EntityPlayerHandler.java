package ru.fr0le.rpg.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;

public class EntityPlayerHandler {
	
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if (ExtendedPlayer.get((EntityPlayer) event.entity) == null)
				ExtendedPlayer.register((EntityPlayer) event.entity);
		}
	}

	@SubscribeEvent
	public void onClonePlayer(PlayerEvent.Clone event) {
		ExtendedPlayer.get(event.entityPlayer).copy(ExtendedPlayer.get(event.original));
	}
		
	@SubscribeEvent
    public void onDeath(LivingDeathEvent event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			
			for (int i = 0; i < ExtendedPlayer.get(player).inventory.inventory.length; i++) {
				ItemStack stack = ExtendedPlayer.get(player).inventory.inventory[i];
				player.dropPlayerItemWithRandomChoice(stack, true);
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(i, null);
			}
		}
	}
	
}
