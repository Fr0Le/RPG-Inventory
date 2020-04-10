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

	@SubscribeEvent
	public void onPlayerRenderTick(RenderPlayerEvent.Specials.Post event) {
		if(event.entityPlayer == null) {
			return;
		}		

		EntityPlayer player = (EntityPlayer) event.entityLiving;
		if (player.getCurrentArmor(3) != null) new RenderHelmet().render(player, event.renderer);
		if (player.getCurrentArmor(2) != null) new RenderBody().render(player, event.renderer);
		if (player.getCurrentArmor(1) != null) new RenderPants().render(player, event.renderer);
		if (player.getCurrentArmor(0) != null) new RenderBoots().render(player, event.renderer);		

		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.SHOULDERS.ordinal()) != null) new RenderShoulders().render(player, event.renderer);
		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BRACERS.ordinal()) != null) new RenderBracers().render(player, event.renderer);
		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.GLOVES.ordinal()) != null) new RenderGloves().render(player, event.renderer);
		if (ExtendedPlayer.get(player).inventory.getStackInSlot(CustomSlots.BELT.ordinal()) != null) new RenderBelt().render(player, event.renderer);		
	}

}