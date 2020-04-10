package ru.fr0le.rpg.common.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import ru.fr0le.rpg.containers.CustomSlots;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.items.armor.CustomItemArmor;
import ru.fr0le.rpg.items.jewels.CustomItemJewel;

public class CustomArmorTick {

	private static ItemStack shoulders = (ItemStack)null;
	private static ItemStack bracers = (ItemStack)null;
	private static ItemStack gloves = (ItemStack)null;
	private static ItemStack belt = (ItemStack)null;

	private static ItemStack necklace = (ItemStack)null;
	private static ItemStack ring1 = (ItemStack)null;
	private static ItemStack ring2 = (ItemStack)null;
	private static ItemStack artifact = (ItemStack)null;

	@SubscribeEvent
	public void onPlayerUpdateEvent(LivingUpdateEvent event) {
		if(event.entity.worldObj.isRemote || !(event.entityLiving instanceof EntityPlayer)) {
			return;
		}

		EntityPlayer player = (EntityPlayer) event.entityLiving;

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.SHOULDERS.ordinal()) != null) {
			shoulders = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.SHOULDERS.ordinal());
			CustomItemArmor.onCustomArmorTick(player.worldObj, player, shoulders);
		} else {
			shoulders = (ItemStack)null;
		}

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BRACERS.ordinal()) != null) {
			bracers = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BRACERS.ordinal());
			CustomItemArmor.onCustomArmorTick(player.worldObj, player, bracers);
		} else {
			bracers = (ItemStack)null;
		}

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.GLOVES.ordinal()) != null) {
			gloves = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.GLOVES.ordinal());
			CustomItemArmor.onCustomArmorTick(player.worldObj, player, gloves);
		} else {
			gloves = (ItemStack)null;
		}

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BELT.ordinal()) != null) {
			belt = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BELT.ordinal());
			CustomItemArmor.onCustomArmorTick(player.worldObj, player, belt);
		} else {
			belt = (ItemStack)null;
		}	

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.NECKLACE.ordinal()) != null) {
			necklace = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.NECKLACE.ordinal());
			CustomItemJewel.onCustomArmorTick(player.worldObj, player, necklace);
		} else {
			necklace = (ItemStack)null;
		}

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING1.ordinal()) != null) {
			ring1 = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING1.ordinal());
			CustomItemJewel.onCustomArmorTick(player.worldObj, player, ring1);
		} else {
			ring1 = (ItemStack)null;
		}

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING2.ordinal()) != null) {
			ring2 = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING2.ordinal());
			CustomItemJewel.onCustomArmorTick(player.worldObj, player, ring2);
		} else {
			ring2 = (ItemStack)null;
		}

		if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.ARTIFACT.ordinal()) != null) {
			artifact = ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.ARTIFACT.ordinal());
			CustomItemJewel.onCustomArmorTick(player.worldObj, player, artifact);
		} else {
			artifact = (ItemStack)null;
		}
	}

}