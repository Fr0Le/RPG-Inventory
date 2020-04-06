package ru.fr0le.rpg.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModelCustom;
import ru.fr0le.rpg.client.resources.Resources;
import ru.fr0le.rpg.items.armor.ArmorType.customArmor;

public class RenderEquipArmor {
	
	private static ResourceLocation texture;
	private static IModelCustom model;
	
	public static void setResources(Item equip) {		
		if(equip instanceof customArmor) {
			texture = Resources.customArmorTexture;
			model = Resources.customArmorModel;
		}		
	}
	
    public static void renderHelmet(RenderPlayer renderModel, Item equip) {
    	setResources(equip);
    	
    	GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedHead.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("head");
		GL11.glPopMatrix();
    }
    
    public static void renderBody(RenderPlayer renderModel, Item equip) {    
    	setResources(equip);
    	
    	GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("body");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("bodyHandLeft");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("bodyHandRight");
		GL11.glPopMatrix();
    }
	
    public static void renderPants(RenderPlayer renderModel, Item equip) {
    	setResources(equip);
    	
    	GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.1275F, 0.75F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("legLeft");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.1275F, 0.75F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("legRight");
		GL11.glPopMatrix();
    }
    
    public static void renderBoots(RenderPlayer renderModel, Item equip) {
    	setResources(equip);
    	
    	GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.125F, 0.75F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("bootLeft");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.125F, 0.75F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("bootRight");
		GL11.glPopMatrix();
    }
    
    public static void renderBelt(RenderPlayer renderModel, Item equip) {
    	setResources(equip);
    	
    	GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("belt");
		GL11.glPopMatrix();
    }
    
	public static void renderShoulders(RenderPlayer renderModel, Item equip) {
		setResources(equip);
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("shouldeLeft");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("shouldeRight");
		GL11.glPopMatrix();
	}
	
	public static void renderBracers(RenderPlayer renderModel, Item equip) {
		setResources(equip);
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("bracerLeft");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("bracerRight");
		GL11.glPopMatrix();
	}
	
	public static void renderGloves(RenderPlayer renderModel, Item equip) {
		setResources(equip);
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("gloveLeft");
		GL11.glPopMatrix();
		
		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		model.renderPart("gloveRight");
		GL11.glPopMatrix();
	}
	
}