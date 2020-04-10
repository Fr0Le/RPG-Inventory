package ru.fr0le.rpg.items.jewels;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.fr0le.rpg.containers.CustomSlots;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeArtifact;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeNecklace;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeRing;

public class CustomItemJewel extends Item {

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {   	

		if(itemStack.getItem() instanceof jewelTypeNecklace && ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.NECKLACE.ordinal()) == null) {
			ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.NECKLACE.ordinal(), itemStack.copy());
			itemStack.stackSize = 0;
		}

		if(itemStack.getItem() instanceof jewelTypeRing) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING1.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.RING1.ordinal(), itemStack.copy());
				itemStack.stackSize = 0;
			}

			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING2.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.RING2.ordinal(), itemStack.copy());
				itemStack.stackSize = 0;
			}    	
		}

		if(itemStack.getItem() instanceof jewelTypeArtifact && ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.ARTIFACT.ordinal()) == null) {
			ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.ARTIFACT.ordinal(), itemStack.copy());
			itemStack.stackSize = 0;
		}    	

		return itemStack;
	}

	public static void onCustomArmorTick(World world, EntityPlayer player, ItemStack stack) {
		//что-то делаем
	}

}