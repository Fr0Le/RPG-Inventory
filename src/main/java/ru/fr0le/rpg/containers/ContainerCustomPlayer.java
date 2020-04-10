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

	public static int slotCraftStart = CustomSlots.values().length + ArmorSlots.values().length; //12
	public static int slotCraftEnd = slotCraftStart + 3; //15
	public static int slotCraftResult = slotCraftEnd + 1; //16    
	public static int slotInventoryStart = CustomSlots.values().length + ArmorSlots.values().length + CraftSlots.values().length; //17
	public static int slotInventoryEnd = slotInventoryStart + 26; //43
	public static int slotHotbarStart = slotInventoryEnd + 1; //44
	public static int slotHotbarEnd = slotHotbarStart + 8; //52

	//к индексам кастомного инвентаря не относится
	public static int vanillaSlotHotbarStart = 0;
	public static int vanillaSlotHotbarEnd = 8;	
	public static int vanillaSlotInventoryStart = 9;
	public static int vanillaSlotInventoryEnd = 35;

	public ContainerCustomPlayer(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryCustomPlayer inventoryCustom) {
		this.player = player;
		int i;
		int j;   

		//кастомные слоты
		addSlotToContainer(new SlotShoulders(inventoryCustom, CustomSlots.SHOULDERS.ordinal(), 8, 8)); //наплечники
		addSlotToContainer(new SlotBracers(inventoryCustom, CustomSlots.BRACERS.ordinal(), 8, 26)); //наручи
		addSlotToContainer(new SlotGloves(inventoryCustom, CustomSlots.GLOVES.ordinal(), 8, 44)); //перчатки
		addSlotToContainer(new SlotBelt(inventoryCustom, CustomSlots.BELT.ordinal(), 8, 62)); //пояс        

		addSlotToContainer(new SlotNecklace(inventoryCustom, CustomSlots.NECKLACE.ordinal(), 44, 8)); //ожерелье
		addSlotToContainer(new SlotRing(inventoryCustom, CustomSlots.RING1.ordinal(), 44, 26)); //кольцо
		addSlotToContainer(new SlotRing(inventoryCustom, CustomSlots.RING2.ordinal(), 44, 44)); //кольцо
		addSlotToContainer(new SlotArtifact(inventoryCustom, CustomSlots.ARTIFACT.ordinal(), 44, 62)); //артефакт   

		//сюда добавлять новые кастомные слоты
		//потом изменить - enum в CustomSlots

		//броня
		for (i = 0; i < 4; ++i) {
			addSlotToContainer(new SlotArmor(player, inventoryPlayer, inventoryPlayer.getSizeInventory() - 1 - i, 26, 8 + i * 18, i));
		}

		//сетка крафта
		for(i = 0; i < 2; ++i) {
			for(j = 0; j < 2; ++j) {
				this.addSlotToContainer(new Slot(this.craftMatrix, j + i * 2, 80 + j * 18, 26 + i * 18));
			}
		}

		//результат крафта
		this.addSlotToContainer(new SlotCrafting(player, this.craftMatrix, this.craftResult, slotCraftResult, 134, 35));

		//инвентарь	все 3 ряда
		for (i = 0; i < 3; ++i) {
			for (j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(inventoryPlayer, j + 9 + i * 9, 8 + j * 18, 84 + i * 18));
			}
		}

		//хотбар
		for (i = 0; i < 9; ++i) {
			addSlotToContainer(new Slot(inventoryPlayer, i, 8 + i * 18, 142));
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}	

	//взаимодейстиве через шифт-клик
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack itemStack = null;
		Slot slot = (Slot)inventorySlots.get(index);

		if(slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();

			//если это кастомные слоты
			if(index < CustomSlots.values().length + ArmorSlots.values().length + CraftSlots.values().length) {
				//если слот результата крафта
				if(index == slotCraftResult) {
					itemCraftToInventoryOrHotbar(slot, itemStack1);
					//другие кастомные слоты
				} else {
					if (!this.mergeItemStack(itemStack1, slotInventoryStart, slotHotbarEnd, false)) {
						return null;
					}

					changeSlot(slot, itemStack);
				}
				//если это броня в инвентаре или хотбаре
			} else if(itemStack1.getItem() instanceof customArmor) {
				itemToArmorSlot(slot, itemStack1);		
				//если это аксессуары в инвентаре или хотбаре
			} else if(itemStack1.getItem() instanceof customJewel) {
				itemToJewelSlot(slot, itemStack1);		
				//если это хотбар или инвентарь
			} else if(vanillaSlotHotbarStart <= slot.getSlotIndex() && slot.getSlotIndex() <= vanillaSlotInventoryEnd) {
				itemToInventoryOrHotbar(slot, itemStack1);		
				//если чтото другое ;D
			} else {
				player.addChatMessage(new ChatComponentText("transferStackInSlot error - сообщите автору для фикса")); 
			}
		}
		return itemStack;
	}

	public void itemToInventoryOrHotbar(Slot slot, ItemStack itemStack) {
		if(vanillaSlotHotbarStart <= slot.getSlotIndex() && slot.getSlotIndex() <= vanillaSlotHotbarEnd) {
			if (!this.mergeItemStack(itemStack, slotInventoryStart, slotInventoryEnd, false)) {
				return;
			}

			changeSlot(slot, itemStack);
		}

		if(vanillaSlotInventoryStart <= slot.getSlotIndex() && slot.getSlotIndex() <= vanillaSlotInventoryEnd) {
			if (!this.mergeItemStack(itemStack, slotHotbarStart, slotHotbarEnd, false)) {
				return;
			}

			changeSlot(slot, itemStack);
		}
	}		

	public void itemCraftToInventoryOrHotbar(Slot slot, ItemStack itemStack) {
		ItemStack itemStack1 = itemStack.copy();

		if (!this.mergeItemStack(itemStack1, slotInventoryStart, slotHotbarEnd, false)) {
			return;
		}

		for(int i = slotCraftStart; i <= slotCraftEnd; i++) {
			Slot slotCraft = (Slot)inventorySlots.get(i);
			if(slotCraft != null && slotCraft.getHasStack()) {
				slotCraft.getStack().stackSize--;
				if(slotCraft.getStack().stackSize <= 0) {
					slotCraft.putStack((ItemStack)null);
				}
			}
		}
	}

	public void changeSlot(Slot slot, ItemStack itemStack) {
		if (itemStack.stackSize <= 0) {
			slot.putStack((ItemStack)null);
		} else {
			slot.onSlotChanged();
		}
	}

	public void itemToArmorSlot(Slot slot, ItemStack itemStack) {
		if(itemStack.getItem() instanceof armorTypeShoulders) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.SHOULDERS.ordinal()) == null) {		
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.SHOULDERS.ordinal(), itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypeBracers) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BRACERS.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.BRACERS.ordinal(), itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypeGloves) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.GLOVES.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.GLOVES.ordinal(), itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypeBelt) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BELT.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.BELT.ordinal(), itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypeHelmet) {
			if(player.getCurrentArmor(3) == null) {
				player.setCurrentItemOrArmor(4, itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypeBody) {
			if(player.getCurrentArmor(2) == null) {
				player.setCurrentItemOrArmor(3, itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypePants) {
			if(player.getCurrentArmor(1) == null) {
				player.setCurrentItemOrArmor(2, itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof armorTypeBoots) {
			if(player.getCurrentArmor(0) == null) {
				player.setCurrentItemOrArmor(1, itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}
	}

	public void itemToJewelSlot(Slot slot, ItemStack itemStack) {
		if(itemStack.getItem() instanceof jewelTypeNecklace) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.NECKLACE.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.NECKLACE.ordinal(), itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		}

		if(itemStack.getItem() instanceof jewelTypeRing) {
			boolean itemChange = false;

			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING1.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.RING1.ordinal(), itemStack.copy());
				itemChange = true;
				slot.putStack((ItemStack)null);
			}

			if(!itemChange) {
				if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.RING2.ordinal()) == null) {
					ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.RING2.ordinal(), itemStack.copy());
					slot.putStack((ItemStack)null);
				} else {
					itemToInventoryOrHotbar(slot, itemStack);
				}   	
			}
		}

		if(itemStack.getItem() instanceof jewelTypeArtifact) {
			if(ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.ARTIFACT.ordinal()) == null) {
				ExtendedPlayer.get(player).inventory.setInventorySlotContents(CustomSlots.ARTIFACT.ordinal(), itemStack.copy());
				slot.putStack((ItemStack)null);
			} else {
				itemToInventoryOrHotbar(slot, itemStack);
			}
		} 
	}

	public void onCraftMatrixChanged(IInventory par1IInventory) {
		this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, player.worldObj));
	}

	public boolean func_94530_a(ItemStack itemStack, Slot slot) {
		return slot.inventory != this.craftResult && super.func_94530_a(itemStack, slot);
	}

	@Override
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

}