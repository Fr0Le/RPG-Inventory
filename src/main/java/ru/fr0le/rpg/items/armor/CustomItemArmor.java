package ru.fr0le.rpg.items.armor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.fr0le.rpg.containers.CustomSlots;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBelt;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBracers;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeGloves;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeShoulders;

public class CustomItemArmor extends Item {

	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {

		if(itemStack.getItem() instanceof armorTypeShoulders && ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.SHOULDERS.ordinal()) == null) {
			ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.SHOULDERS.ordinal(), itemStack.copy());
			itemStack.stackSize = 0;
		}

		if(itemStack.getItem() instanceof armorTypeBracers && ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BRACERS.ordinal()) == null) {
			ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.BRACERS.ordinal(), itemStack.copy());
			itemStack.stackSize = 0;
		}

		if(itemStack.getItem() instanceof armorTypeGloves && ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.GLOVES.ordinal()) == null) {
			ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.GLOVES.ordinal(), itemStack.copy());
			itemStack.stackSize = 0;
		}

		if(itemStack.getItem() instanceof armorTypeBelt && ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BELT.ordinal()) == null) {
			ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.BELT.ordinal(), itemStack.copy());
			itemStack.stackSize = 0;
		}    

		return itemStack;
	}

	public static void destroyItemArmor(ItemStack stack, EntityPlayer player, int slot) {
		if(stack.getItemDamage() >= stack.getMaxDamage()) {
			player.inventory.setInventorySlotContents(slot, null);
		}
	}

	public static void onCustomArmorTick(World world, EntityPlayer player, ItemStack stack) {
		//что-то делаем
	}

}