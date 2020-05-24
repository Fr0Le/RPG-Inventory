package ru.fr0le.rpg.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import ru.fr0le.rpg.client.ClientProxy;
import ru.fr0le.rpg.client.resources.Resources;
import ru.fr0le.rpg.items.armor.ArmorType.customArmor;

public class RenderEquipArmor {

	private static ResourceLocation texture;
	private static String model;

	public static void setResources(Item equip) {		
		if(equip instanceof customArmor) {
			texture = Resources.customArmorTexture;
			model = "customArmorModel";
		}		
	}

	public static void renderHelmet(RenderPlayer renderModel, Item equip) {
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedHead.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "head"));
		GL11.glPopMatrix();
	}

	public static void renderBody(RenderPlayer renderModel, Item equip) {    
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "body"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedLeftArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(-.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bodyHandRight"));
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
		GL11.glCallList(ClientProxy.getRenderPart(model, "legLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.1275F, 0.75F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "legRight"));
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
		GL11.glCallList(ClientProxy.getRenderPart(model, "bootLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightLeg.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.125F, 0.75F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bootRight"));
		GL11.glPopMatrix();
	}

	public static void renderBelt(RenderPlayer renderModel, Item equip) {
		setResources(equip);

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedBody.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "belt"));
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
		GL11.glCallList(ClientProxy.getRenderPart(model, "shouldeLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "shouldeRight"));
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
		GL11.glCallList(ClientProxy.getRenderPart(model, "bracerLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "bracerRight"));
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
		GL11.glCallList(ClientProxy.getRenderPart(model, "gloveLeft"));
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		renderModel.modelBipedMain.bipedRightArm.postRender(0.0625F);
		GL11.glRotatef(180.0f, 1F, 0F, 0F);
		GL11.glTranslatef(.315F, .125F, 0F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		GL11.glCallList(ClientProxy.getRenderPart(model, "gloveRight"));
		GL11.glPopMatrix();
	}

}