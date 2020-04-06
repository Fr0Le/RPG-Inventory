package ru.fr0le.rpg;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import ru.fr0le.rpg.common.CommonProxy;
import ru.fr0le.rpg.handlers.GuiHandler;
import ru.fr0le.rpg.network.PacketDispatcher;

@Mod(modid = Info.modid, name = Info.name, version = Info.version)

public class Core {
	
	@Mod.Instance(Info.modid)
	public static Core mod;
		
	@SidedProxy(clientSide = "ru.fr0le.rpg.client.ClientProxy", 
				serverSide = "ru.fr0le.rpg.common.CommonProxy")
	public static CommonProxy proxy;
	
	private static int modGuiIndex = 0;
	public static final int GUI_CUSTOM_INV = modGuiIndex++;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {		
		proxy.preInit();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		PacketDispatcher.registerPackets();
	}
		
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		proxy.Init();
		System.out.println(Info.name + " has been successfully initialized");
	}
		
	@EventHandler
    public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}
	
}
