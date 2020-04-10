package ru.fr0le.rpg.common;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import ru.fr0le.rpg.common.handlers.CustomArmorTick;
import ru.fr0le.rpg.common.handlers.CustomSlotDurability;
import ru.fr0le.rpg.common.handlers.EntityPlayerHandler;
import ru.fr0le.rpg.common.handlers.PlayerUpdateEquipBelt;
import ru.fr0le.rpg.common.handlers.PlayerUpdateEquipBracers;
import ru.fr0le.rpg.common.handlers.PlayerUpdateEquipGloves;
import ru.fr0le.rpg.common.handlers.PlayerUpdateEquipShoulders;
import ru.fr0le.rpg.creativetabs.LoadTab;
import ru.fr0le.rpg.items.armor.LoadItemArmor;
import ru.fr0le.rpg.items.jewels.LoadItemJewels;

public class CommonProxy {

	public void preInit() {
		loadTabs();
		loadArmors();
		loadItems();
	}

	public void Init() {	
		playerHandler();
		playerUpdateEquip();
	}

	public void postInit() {

	}

	public void loadTabs() {
		LoadTab.registerTabs();
	}

	public void loadArmors() {
		LoadItemArmor.registerItems();
	}

	public void loadItems() {
		new LoadItemJewels();
	}

	public void playerHandler() {
		MinecraftForge.EVENT_BUS.register(new EntityPlayerHandler());
		MinecraftForge.EVENT_BUS.register(new CustomSlotDurability());
		MinecraftForge.EVENT_BUS.register(new CustomArmorTick());

	}

	public void playerUpdateEquip() {
		MinecraftForge.EVENT_BUS.register(new PlayerUpdateEquipShoulders());
		MinecraftForge.EVENT_BUS.register(new PlayerUpdateEquipBracers());
		MinecraftForge.EVENT_BUS.register(new PlayerUpdateEquipGloves());
		MinecraftForge.EVENT_BUS.register(new PlayerUpdateEquipBelt());
	}

	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return ctx.getServerHandler().playerEntity;
	}

}