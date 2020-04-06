package ru.fr0le.rpg.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import ru.fr0le.rpg.containers.ContainerCustomPlayer;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;

public class CustomSlotDurability {

	@SubscribeEvent
	public void takingPlayerDamage(LivingHurtEvent event) {
		if(event.entity.worldObj.isRemote || !(event.entityLiving instanceof EntityPlayer)) {
			return;
		}

		if(event.source.getEntity() instanceof Entity) {
			EntityPlayer player = (EntityPlayer)event.entityLiving;
	
			for(int i = ContainerCustomPlayer.slots[0]; i < ContainerCustomPlayer.slots.length; i++) {
				if(ExtendedPlayer.get(player).inventory.getStackInSlot(i) != null) {
					ItemStack stack = ExtendedPlayer.get(player).inventory.getStackInSlot(i);
					stack.damageItem(1, event.entityLiving);
					if(stack.getItemDamage() >= stack.getMaxDamage()) {
						ExtendedPlayer.get(player).inventory.setInventorySlotContents(i, null);
					}
				}
			}				
		}
	}

}
