package ru.fr0le.rpg.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.util.ChatComponentText;
import ru.fr0le.rpg.containers.slots.SlotArmor;
import ru.fr0le.rpg.containers.slots.SlotArtifact;
import ru.fr0le.rpg.containers.slots.SlotBelt;
import ru.fr0le.rpg.containers.slots.SlotBracers;
import ru.fr0le.rpg.containers.slots.SlotGloves;
import ru.fr0le.rpg.containers.slots.SlotNecklace;
import ru.fr0le.rpg.containers.slots.SlotRing;
import ru.fr0le.rpg.containers.slots.SlotShoulders;
import ru.fr0le.rpg.containers.slots.SlotType.customArmorSlot;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.entities.player.InventoryCustomPlayer;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBelt;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBody;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBoots;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBracers;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeGloves;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeHelmet;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypePants;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeShoulders;
import ru.fr0le.rpg.items.armor.ArmorType.customArmor;
import ru.fr0le.rpg.items.jewels.JewelsType.customJewel;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeArtifact;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeNecklace;
import ru.fr0le.rpg.items.jewels.JewelsType.jewelTypeRing;

public class ContainerCustomPlayer extends Container {
	
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 2, 2);
	public IInventory craftResult = new InventoryCraftResult();
    private final EntityPlayer player;
    
    public final static int[] slots = new int[] {0, 1, 2, 3, 4, 5, 6, 7};
        
    public static int slotShoulders = slots[0];
    public static int slotBracers = slots[1];
    public static int slotGloves = slots[2];
    public static int slotBelt = slots[3];
    public static int slotNecklace = slots[4];
    public static int slotRing1 = slots[5];
    public static int slotRing2 = slots[6];
    public static int slotArtifact = slots[7];
    
    public static int slotHelmet = slots.length; //8
    public static int slotBody = slotHelmet + 1; //9
    public static int slotPants = slotBody + 1; //10
    public static int slotBoots = slotPants + 1; //11

    public static int slotCraftStart = slotBoots + 1; //12
    public static int slotCraftEnd = slotCraftStart + 3; //15
    public static int slotCraftResult = slotCraftEnd + 1; //16    
        
    //17 - 43 инвентарь
    //44 - 52 хотбар
    
    //main
    //9 - 35 инвентарь
    //0 - 8 хотбар
    //36 - 39 броня
	
	public ContainerCustomPlayer(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryCustomPlayer inventoryCustom) {
		this.player = player;
        int i;
        int j;      

        //кастомные слоты
		addSlotToContainer(new SlotShoulders(inventoryCustom, slotShoulders, 8, 8)); //наплечники
		addSlotToContainer(new SlotBracers(inventoryCustom, slotBracers, 8, 26)); //наручи
		addSlotToContainer(new SlotGloves(inventoryCustom, slotGloves, 8, 44)); //перчатки
		addSlotToContainer(new SlotBelt(inventoryCustom, slotBelt, 8, 62)); //пояс        
		
		addSlotToContainer(new SlotNecklace(inventoryCustom, slotNecklace, 44, 8)); //ожерелье
		addSlotToContainer(new SlotRing(inventoryCustom, slotRing1, 44, 26)); //кольцо
		addSlotToContainer(new SlotRing(inventoryCustom, slotRing2, 44, 44)); //кольцо
		addSlotToContainer(new SlotArtifact(inventoryCustom, slotArtifact, 44, 62)); //артефакт   
		
		//сюда добавлять новые кастомные слоты
		//потом увеличить - slots[]
		
      	for (i = 0; i < 4; ++i) { //броня
			addSlotToContainer(new SlotArmor(player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 26, 8 + i * 18, i));
		}
		
		//сетка крафта
		for(i = 0; i < 2; ++i) {
			for(j = 0; j < 2; ++j) {
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 80 + j * 18, 26 + i * 18));
			}
		}
		
		//результат крафта
		this.addSlotToContainer(new SlotCrafting(player, this.craftMatrix, this.craftResult, 12, 134, 35));
		
		//инвентарь		
		for (j = 0; j < 9; ++j) { //верхний ряд			
			addSlotToContainer(new Slot(inventoryPlayer, j + 9, 8 + j * 18, 84));
		}
		
		for (j = 0; j < 9; ++j) { //средний ряд	
			addSlotToContainer(new Slot(inventoryPlayer, j + 18, 8 + j * 18, 102));
		}
		
		for (j = 0; j < 9; ++j) { //нижний ряд	
			addSlotToContainer(new Slot(inventoryPlayer, j + 27, 8 + j * 18, 120));
		}
		
		for (i = 0; i < 9; ++i) { //хотбар			
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}	
		
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack itemStack = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if(slot != null && slot.getHasStack()) {
			ItemStack itemStackInSlot = slot.getStack();
			//itemStack = itemStackInSlot.copy();

			if(slot instanceof customArmorSlot) {				
				itemToInventoryOrHotbar(slot, itemStackInSlot);				
			} else if(slotCraftStart <= slot.slotNumber && slot.slotNumber <= slotCraftEnd) {
				itemToInventoryOrHotbar(slot, itemStackInSlot);
			} else if(slot.slotNumber == slotCraftResult) {
  				player.addChatMessage(new ChatComponentText("Не реализовано через шифт-клик")); 
				//TODO сделать шифт-клик из ячейки результата крафта
			} else if(itemStackInSlot.getItem() instanceof customArmor) {
				itemToArmorSlot(slot, itemStackInSlot);		
			} else if(itemStackInSlot.getItem() instanceof customJewel) {
				itemToJewelSlot(slot, itemStackInSlot);		
			} else if(0 <= slot.getSlotIndex() && slot.getSlotIndex() <= 8) {
				itemToInventory(slot, itemStackInSlot);
			} else if(9 <= slot.getSlotIndex() && slot.getSlotIndex() <= 35) {
				itemToHotbar(slot, itemStackInSlot);
			} else {
  				player.addChatMessage(new ChatComponentText("transferStackInSlot error")); 
			}
				//TODO сделать возможность стакать предметы при перемещении через шифт-клик
				//TODO сделать так, если через шифт-клик нужно одеть бронь, но слот занят, переместить итем
		}
	
		return itemStack;
	}
	
	public void itemToHotbar(Slot slot, ItemStack itemStackInSlot) {
		for(int i = 0; i <= 8; i++) {
			if(player.inventory.getStackInSlot(i) == null) {
				player.inventory.setInventorySlotContents(i, itemStackInSlot.copy());						
				slot.putStack((ItemStack)null);
				break;
			}
		}
	}
	
	public void itemToInventory(Slot slot, ItemStack itemStackInSlot) {
		for(int i = 9; i <= 35; i++) {
			if(player.inventory.getStackInSlot(i) == null) {
				player.inventory.setInventorySlotContents(i, itemStackInSlot.copy());						
				slot.putStack((ItemStack)null);
				break;
			}
		}
	}
	
	public void itemToInventoryOrHotbar(Slot slot, ItemStack itemStackInSlot) {
		boolean itemChange = false;
		
		for(int i = 9; i <= 35; i++) {
			if(player.inventory.getStackInSlot(i) == null) {
				player.inventory.setInventorySlotContents(i, itemStackInSlot.copy());						
				slot.putStack((ItemStack)null);
				itemChange = true;
				break;
			}
		}
		
		if(!itemChange) {
			for(int i = 0; i <= 8; i++) {
				if(player.inventory.getStackInSlot(i) == null) {
					player.inventory.setInventorySlotContents(i, itemStackInSlot.copy());						
					slot.putStack((ItemStack)null);
					break;
				}
			}
		}		
	}
	
	public void itemToArmorSlot(Slot slot, ItemStack itemStackInSlot) {
		
    	if(itemStackInSlot.getItem() instanceof armorTypeShoulders && ExtendedPlayer.get(player).inventory.getStackInSlot(slotShoulders) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotShoulders, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypeBracers && ExtendedPlayer.get(player).inventory.getStackInSlot(slotBracers) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotBracers, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypeGloves && ExtendedPlayer.get(player).inventory.getStackInSlot(slotGloves) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotGloves, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypeBelt && ExtendedPlayer.get(player).inventory.getStackInSlot(slotBelt) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotBelt, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypeHelmet && player.getCurrentArmor(3) == null) {
			player.setCurrentItemOrArmor(4, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypeBody && player.getCurrentArmor(2) == null) {
			player.setCurrentItemOrArmor(3, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypePants && player.getCurrentArmor(1) == null) {
			player.setCurrentItemOrArmor(2, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof armorTypeBoots && player.getCurrentArmor(0) == null) {
			player.setCurrentItemOrArmor(1, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
	}
	
	public void itemToJewelSlot(Slot slot, ItemStack itemStackInSlot) {
    	if(itemStackInSlot.getItem() instanceof jewelTypeNecklace && ExtendedPlayer.get(player).inventory.getStackInSlot(slotNecklace) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotNecklace, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}
    	
    	if(itemStackInSlot.getItem() instanceof jewelTypeRing) {
    		boolean itemChange = false;
    		
    		if(ExtendedPlayer.get(player).inventory.getStackInSlot(slotRing1) == null) {
    			ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotRing1, itemStackInSlot.copy());
    			itemChange = true;
    			slot.putStack((ItemStack)null);
    		}
    		
    		if(!itemChange) {
	    		if(ExtendedPlayer.get(player).inventory.getStackInSlot(slotRing2) == null) {
	    			ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotRing2, itemStackInSlot.copy());
	    			slot.putStack((ItemStack)null);
	    		}    	
    		}
    	}
    	
    	if(itemStackInSlot.getItem() instanceof jewelTypeArtifact && ExtendedPlayer.get(player).inventory.getStackInSlot(slotArtifact) == null) {
    		ExtendedPlayer.get(player).inventory.setInventorySlotContents(slotArtifact, itemStackInSlot.copy());
			slot.putStack((ItemStack)null);
    	}  
	}
	
	public void onCraftMatrixChanged(IInventory par1IInventory) {
		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, player.worldObj));
	}
	
	public boolean func_94530_a(ItemStack itemStack, Slot slot) {
		return slot.inventory != this.craftResult && super.func_94530_a(itemStack, slot);
	}
	
	public void onContainerClosed(EntityPlayer player) {
        super.onContainerClosed(player);
        
        //дропаем из сетки при закрытии если там не пусто
        for (int i = slotCraftStart; i <= slotCraftEnd; ++i) {
        Slot slot = (Slot) this.inventorySlots.get(i);
        	if(slot != null && slot.getHasStack()) {
	            ItemStack itemstack = slot.getStack();
                player.dropPlayerItemWithRandomChoice(itemstack, false);
        	}
        } 
    }
	
	@Override
	public ItemStack slotClick(int slot, int button, int modifier, EntityPlayer player) {	
		return super.slotClick(slot, button, modifier, player);
    }
	
	//public int clearInventory(Item p_146027_1_, int p_146027_2_) {
	//TODO очистку кастомных слотов при /clear
	//}
	
}
