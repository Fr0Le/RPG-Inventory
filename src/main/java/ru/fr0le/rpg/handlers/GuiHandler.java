package ru.fr0le.rpg.handlers;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ru.fr0le.rpg.Core;
import ru.fr0le.rpg.client.gui.GuiCustomPlayerInventory;
import ru.fr0le.rpg.containers.ContainerCustomPlayer;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;

public class GuiHandler implements IGuiHandler {
	
	@Override
	public Object getServerGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
		if (guiId == Core.GUI_CUSTOM_INV) return new ContainerCustomPlayer(player, player.inventory, ExtendedPlayer.get(player).inventory);
		else return null;
	}

	@Override
	public Object getClientGuiElement(int guiId, EntityPlayer player, World world, int x, int y, int z) {
		if (guiId == Core.GUI_CUSTOM_INV) return new GuiCustomPlayerInventory(player, player.inventory, ExtendedPlayer.get(player).inventory);
		else return null;
	}
	
}
