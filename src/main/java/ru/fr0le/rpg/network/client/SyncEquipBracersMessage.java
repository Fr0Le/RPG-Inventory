package ru.fr0le.rpg.network.client;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import ru.fr0le.rpg.containers.CustomSlots;
import ru.fr0le.rpg.entities.player.ExtendedPlayer;
import ru.fr0le.rpg.items.armor.LoadItemArmor;
import ru.fr0le.rpg.network.AbstractMessage.AbstractClientMessage;

public class SyncEquipBracersMessage extends AbstractClientMessage<SyncEquipBracersMessage> {

	private int playerID;
	private int equipID;

	public SyncEquipBracersMessage() {

	}

	public SyncEquipBracersMessage(int playerID, int equipID) {
		this.playerID = playerID;
		this.equipID = equipID;
	}

	@Override
	protected void read(PacketBuffer buffer) {
		playerID = buffer.readInt();
		equipID = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) {
		buffer.writeInt(playerID);
		buffer.writeInt(equipID);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		if(Minecraft.getMinecraft().thePlayer.getEntityId() == playerID) {
			return;
		}

		Entity playerToUpd = player.worldObj.getEntityByID(playerID);
		if(playerToUpd == null || !(playerToUpd instanceof EntityPlayer)) {
			return;
		}

		ItemStack itemStack = null;
		if (equipID == 1) itemStack = new ItemStack(LoadItemArmor.bracers);
		else itemStack = null;
		ExtendedPlayer.get((EntityPlayer) playerToUpd).inventory.inventory[CustomSlots.BRACERS.ordinal()] = itemStack;
	}

}