package ru.fr0le.rpg.client.resources;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.fr0le.rpg.Info;

public class Resources {

	public static final IModelCustom customArmorModel = AdvancedModelLoader.loadModel(new ResourceLocation(Info.modid, "models/items/customArmorModel.obj"));

	public static final ResourceLocation customArmorTexture = new ResourceLocation(Info.modid, "textures/models/items/customArmorTexture.png");

	public static final ResourceLocation inventoryTexture = new ResourceLocation(Info.modid, "textures/gui/inventory.png");

}