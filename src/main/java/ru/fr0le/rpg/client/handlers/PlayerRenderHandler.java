package ru.fr0le.rpg.client.handlers;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import ru.fr0le.rpg.client.render.RenderBelt;
import ru.fr0le.rpg.client.render.RenderBody;
import ru.fr0le.rpg.client.render.RenderBoots;
import ru.fr0le.rpg.client.render.RenderBracers;
import ru.fr0le.rpg.client.render.RenderGloves;
import ru.fr0le.rpg.client.render.RenderHelmet;
import ru.fr0le.rpg.client.render.RenderPants;
import ru.fr0le.rpg.client.render.RenderShoulders;
import ru.fr0le.rpg.containers.CustomSlots;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;

public class PlayerRenderHandler {

	private RenderHelmet renderHelmet = new RenderHelmet();
	private RenderBody renderBody = new RenderBody();
	private RenderPants renderPants = new RenderPants();
	private RenderBoots renderBoots = new RenderBoots();
	private RenderShoulders renderShoulders = new RenderShoulders();
	private RenderBracers renderBracers = new RenderBracers();
	private RenderGloves renderGloves = new RenderGloves();
	private RenderBelt renderBelt = new RenderBelt();

	@SubscribeEvent
	public void onPlayerRenderTick(RenderPlayerEvent.Specials.Post event) {
		if(event.entityPlayer == null) {
			return;
		}		

		EntityPlayer player = (EntityPlayer) event.entityLiving;
		if (player.getCurrentArmor(3) != null) renderHelmet.render(player, event.renderer);
		if (player.getCurrentArmor(2) != null) renderBody.render(player, event.renderer);
		if (player.getCurrentArmor(1) != null) renderPants.render(player, event.renderer);
		if (player.getCurrentArmor(0) != null) renderBoots.render(player, event.renderer);		

		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.SHOULDERS.ordinal()) != null) renderShoulders.render(player, event.renderer);
		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BRACERS.ordinal()) != null) renderBracers.render(player, event.renderer);
		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.GLOVES.ordinal()) != null) renderGloves.render(player, event.renderer);
		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BELT.ordinal()) != null) renderBelt.render(player, event.renderer);		
	}

}