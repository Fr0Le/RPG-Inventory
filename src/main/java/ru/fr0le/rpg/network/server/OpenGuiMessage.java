package ru.fr0le.rpg.network.server;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import ru.fr0le.rpg.Core;
import ru.fr0le.rpg.network.AbstractMessage.AbstractServerMessage;

public class OpenGuiMessage extends AbstractServerMessage<OpenGuiMessage> {
	
	private int id;

	public OpenGuiMessage() {
		
	}

	public OpenGuiMessage(int id) {
		this.id = id;
	}

	@Override
	protected void read(PacketBuffer buffer) {
		id = buffer.readInt();
	}

	@Override
	protected void write(PacketBuffer buffer) {
		buffer.writeInt(id);
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.openGui(Core.mod, this.id, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}
	
}
