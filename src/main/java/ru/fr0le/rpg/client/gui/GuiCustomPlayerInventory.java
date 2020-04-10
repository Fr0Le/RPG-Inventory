package ru.fr0le.rpg.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import ru.fr0le.rpg.client.resources.Resources;
import ru.fr0le.rpg.containers.ContainerCustomPlayer;
import ru.fr0le.rpg.entities.player.InventoryCustomPlayer;

public class GuiCustomPlayerInventory extends GuiContainer {

	private int xSize_lo;
	private int ySize_lo;

	private final InventoryCustomPlayer inventory;

	public GuiCustomPlayerInventory(EntityPlayer player, InventoryPlayer inventoryPlayer, InventoryCustomPlayer inventoryCustom) {
		super(new ContainerCustomPlayer(player, inventoryPlayer, inventoryCustom));
		this.inventory = inventoryCustom;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float f) {
		super.drawScreen(mouseX, mouseY, f);
		xSize_lo = mouseX;
		ySize_lo = mouseY;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int mouseX, int mouseY) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(Resources.inventoryTexture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		//рендер кастомных слотов когда пустые
		for (int i = 0; i < 4; i++) {
			int noEquip = 169;
			if(inventory.getStackInSlot(i) != null) {
				noEquip = 0;
			}
			drawTexturedModalRect(guiLeft + 7, guiTop + 7 + 18 * i, 7 + noEquip, 7 + 18 * i, 18, 18);
		}

		for (int i = 0; i < 4; i++) {
			int noEquip = 205;
			if(inventory.getStackInSlot(i + 4) != null) {
				noEquip = 0;
			}
			drawTexturedModalRect(guiLeft + 43, guiTop + 7 + 18 * i, 7 + noEquip, 7 + 18 * i, 18, 18);
		}	

		//рендер игрока в инвентаре
		GuiInventory.func_147046_a(guiLeft - 70, guiTop + 165, 85, guiLeft + 51 - xSize_lo, guiTop + 25 - ySize_lo, mc.thePlayer);		
	}

}