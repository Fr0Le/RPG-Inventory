package ru.fr0le.rpg.client;

import java.util.HashMap;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.common.MinecraftForge;
import ru.fr0le.rpg.Info;
import ru.fr0le.rpg.client.handlers.OpenInventory;
import ru.fr0le.rpg.client.handlers.PlayerRenderHandler;
import ru.fr0le.rpg.client.render.armor.RenderItemArmor;
import ru.fr0le.rpg.common.CommonProxy;
import ru.fr0le.rpg.items.armor.LoadItemArmor;

public class ClientProxy extends CommonProxy {

	private static final HashMap<String, Integer> hash = new HashMap<String, Integer>();

	@Override
	public void preInit() {
		super.preInit();  
		Display.setTitle(Info.name + " demo");
	}

	@Override
	public void Init() {
		super.Init();
		renderIcons();
		renderEquip();
		openInventory();
	}

	@Override
	public void postInit() {
		super.postInit(); 
	}

	public void renderIcons() {	
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.helmet, new RenderItemArmor.renderItemHelmet());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.body, new RenderItemArmor.renderItemBody());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.pants, new RenderItemArmor.renderItemPants());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.boots, new RenderItemArmor.renderItemBoots());

		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.shoulders, new RenderItemArmor.renderItemShoulders());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.bracers, new RenderItemArmor.renderItemBracers());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.gloves, new RenderItemArmor.renderItemGloves());
		MinecraftForgeClient.registerItemRenderer(LoadItemArmor.belt, new RenderItemArmor.renderItemBelt());	
	}

	public void renderEquip() {	
		MinecraftForge.EVENT_BUS.register(new PlayerRenderHandler());
	}

	private void openInventory() {
		MinecraftForge.EVENT_BUS.register(new OpenInventory());		
	}

	@Override
	public EntityPlayer getPlayerEntity(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().thePlayer : super.getPlayerEntity(ctx));
	}

	public static int getRenderPart(String model, String partName) {
		if(hash.containsKey(model + "_" + partName)) 
			return hash.get(model + "_" + partName);

		int displayList = GLAllocation.generateDisplayLists(1);
		GL11.glNewList(displayList, GL11.GL_COMPILE);
		AdvancedModelLoader.loadModel(new ResourceLocation(Info.modid, "models/armor/" + model + ".obj")).renderPart(partName);
		GL11.glEndList();
		hash.put(model + "_" + partName, displayList);
		return displayList;
	}

}