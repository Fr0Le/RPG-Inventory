package ru.fr0le.rpg.items.jewels;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.fr0le.rpg.containers.ContainerCustomPlayer;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeArtifact;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeNecklace;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeRing;

public class CustomItemJewel extends Item {
	
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {   	
    	
    	if(itemStack.getItem() instanceof jewelTypeNecklace && ExtendedPlayer.get(player).inventory.getStackInSlot(ContainerCustomPlayer.slotNecklace) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(ContainerCustomPlayer.slotNecklace, itemStack.copy());
    		itemStack.stackSize = 0;
    	}
    	
    	if(itemStack.getItem() instanceof jewelTypeRing) {
    		if(ExtendedPlayer.get(player).inventory.getStackInSlot(ContainerCustomPlayer.slotRing1) == null) {
    			ExtendedPlayer.get(player).inventory.setInventorySlotContents(ContainerCustomPlayer.slotRing1, itemStack.copy());
        		itemStack.stackSize = 0;
    		}
    		
    		if(ExtendedPlayer.get(player).inventory.getStackInSlot(ContainerCustomPlayer.slotRing2) == null) {
    			ExtendedPlayer.get(player).inventory.setInventorySlotContents(ContainerCustomPlayer.slotRing2, itemStack.copy());
        		itemStack.stackSize = 0;
    		}    	
    	}
    	
    	if(itemStack.getItem() instanceof jewelTypeArtifact && ExtendedPlayer.get(player).inventory.getStackInSlot(ContainerCustomPlayer.slotArtifact) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(ContainerCustomPlayer.slotArtifact, itemStack.copy());
    		itemStack.stackSize = 0;
    	}    	

        return itemStack;
    }

}
