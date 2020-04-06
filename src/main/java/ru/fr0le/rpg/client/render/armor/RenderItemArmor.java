package ru.fr0le.rpg.client.render.armor;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.IModelCustom;
import ru.fr0le.rpg.client.resources.Resources;
import ru.fr0le.rpg.items.armor.ArmorType.customArmor;

public class RenderItemArmor {			
	
	private static ResourceLocation texture;
	private static IModelCustom model;
	
	public static void setResources(ItemStack item) {				
		Item equip = item.getItem();
		if(equip instanceof customArmor) {
			texture = Resources.customArmorTexture;
			model = Resources.customArmorModel;
		}		
	}
   
	public static class renderItemHelmet implements IItemRenderer {
		
		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);
			
			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, -.4F, 0F);
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				model.renderPart("head");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, 0F, 0.5F);
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				model.renderPart("head");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0.2F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("head");
				GL11.glPopMatrix();
			}
		}
	}
	
	public static class renderItemBody implements IItemRenderer {
		
		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, .4F, 0F);
				GL11.glScalef(0.65F, 0.65F, 0.75F);
				model.renderPart("body");
				model.renderPart("bodyHandLeft");
				model.renderPart("bodyHandRight");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-0.25F, 1.5F, 0.75F);
				GL11.glScalef(1F, 1F, 1F);
				model.renderPart("body");
				model.renderPart("bodyHandLeft");
				model.renderPart("bodyHandRight");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0.5F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("body");
				model.renderPart("bodyHandLeft");
				model.renderPart("bodyHandRight");
				GL11.glPopMatrix();
			}
		}
	}
	
	public static class renderItemPants implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 2F, 0F);
				GL11.glScalef(0.95F, 0.95F, 0.95F);
				model.renderPart("legLeft");
				model.renderPart("legRight");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, 2.5F, 0.5F);
				model.renderPart("legLeft");
				model.renderPart("legRight");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 1.2F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("legLeft");
				model.renderPart("legRight");
				GL11.glPopMatrix();
			}
		}
	}
	
	public static class renderItemBoots implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 3.4F, 0F);
				GL11.glScalef(1.2F, 1.2F, 1.2F);
				model.renderPart("bootLeft");
				model.renderPart("bootRight");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, 3.2F, 0.5F);
				model.renderPart("bootLeft");
				model.renderPart("bootRight");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 1.4F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("bootLeft");
				model.renderPart("bootRight");
				GL11.glPopMatrix();
			}
		}
	}
	

	
	public static class renderItemShoulders implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-1F, 0.5F, 0.1F);
				GL11.glScalef(1.4F, 1.4F, 1.4F);
				model.renderPart("shouldeLeft");
				//model.renderPart("shouldeRight");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-0.25F, 1F, 0.75F);
				GL11.glScalef(1F, 1F, 1F);
				model.renderPart("shouldeLeft");
				//model.renderPart("shouldeRight");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0.5F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("shouldeLeft");
				model.renderPart("shouldeRight");
				GL11.glPopMatrix();
			}
		}
	}
	
	public static class renderItemBracers implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-1F, 1.4F, 0.1F);
				GL11.glScalef(1.4F, 1.4F, 1.4F);
				model.renderPart("bracerLeft");
				//model.renderPart("bracerRight");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-0.25F, 1.5F, 0.75F);
				GL11.glScalef(1F, 1F, 1F);
				model.renderPart("bracerLeft");
				//model.renderPart("bracerRight");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0.5F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("bracerLeft");
				model.renderPart("bracerRight");
				GL11.glPopMatrix();
			}
		}
	}
	
	public static class renderItemGloves implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-0.9F, 1.9F, 0.1F);
				GL11.glScalef(1.4F, 1.4F, 1.4F);
				model.renderPart("gloveLeft");
				//model.renderPart("gloveRight");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(-0.25F, 1.9F, 0.75F);
				GL11.glScalef(1F, 1F, 1F);
				model.renderPart("gloveLeft");
				//model.renderPart("gloveRight");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 0.7F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("gloveLeft");
				model.renderPart("gloveRight");
				GL11.glPopMatrix();
			}
		}
	}
	
	public static class renderItemBelt implements IItemRenderer {

		@Override
		public boolean handleRenderType(ItemStack item, ItemRenderType type) { 
			return true; 
		}

		@Override
		public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
			return true; 
		}

		@Override
		public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
			setResources(item);

			if (type == ItemRenderType.INVENTORY) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0F, 2F, 0F);
				GL11.glScalef(1.3F, 1.3F, 1.3F);
				model.renderPart("belt");
				GL11.glPopMatrix();	
			} else if (type == ItemRenderType.EQUIPPED) {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glTranslatef(0.25F, 2F, 0.5F);
				model.renderPart("belt");
				GL11.glPopMatrix();
			} else {
				GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);		
				GL11.glTranslatef(0F, 1.2F, 0F);
				GL11.glScalef(0.5F, 0.5F, 0.5F);
				model.renderPart("belt");
				GL11.glPopMatrix();
			}
		}
	}
	
}