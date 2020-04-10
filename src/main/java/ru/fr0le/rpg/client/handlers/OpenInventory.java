package ru.fr0le.rpg.client.handlers;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.GuiOpenEvent;
import ru.fr0le.rpg.Core;
import ru.fr0le.rpg.network.PacketDispatcher;
import ru.fr0le.rpg.network.server.OpenGuiMessage;

public class OpenInventory {

	@SubscribeEvent
	public void onOpenGui(GuiOpenEvent event) {
		if(event.gui instanceof GuiInventory) {
			EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;
			if (!player.capabilities.isCreativeMode) {
				event.setCanceled(true);
				PacketDispatcher.sendToServer(new OpenGuiMessage(Core.GUI_CUSTOM_INV));
			}
		}
	}

}