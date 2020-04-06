package ru.fr0le.rpg.items.armor;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import ru.fr0le.rpg.Info;
import ru.fr0le.rpg.creativetabs.LoadTab;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBelt;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBody;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBoots;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeBracers;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeGloves;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeHelmet;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypePants;
import ru.fr0le.rpg.items.armor.ArmorType.armorTypeShoulders;
import ru.fr0le.rpg.items.armor.ArmorType.customArmor;

public class ItemCustomArmor {
	
	public static class Helmet extends ItemArmor implements armorTypeHelmet, customArmor {
		public Helmet(ArmorMaterial armorMaterial, int par3, int par4) {
	        super(armorMaterial, par3, par4);
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setUnlocalizedName("helmet");
	        this.setTextureName(Info.modid + ":null");
	        this.setMaxDamage(1000);
	    }
		
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
			CustomItemArmor.destroyItemArmor(stack, player, 39);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}
	    
	    @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
	        return Info.modid + ":textures/items/null.png";
	    }	   

	}
	
	public static class Body extends ItemArmor implements armorTypeBody, customArmor {
		public Body(ArmorMaterial armorMaterial, int par3, int par4) {
	        super(armorMaterial, par3, par4);
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setUnlocalizedName("body");
	        this.setTextureName(Info.modid + ":null");
	        this.setMaxDamage(1000);
	    }
		
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
			CustomItemArmor.destroyItemArmor(stack, player, 38);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}
	    
	    @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
	        return Info.modid + ":textures/items/null.png";
	    }
	    
	}
	
	public static class Pants extends ItemArmor implements armorTypePants, customArmor {
		public Pants(ArmorMaterial armorMaterial, int par3, int par4) {
	        super(armorMaterial, par3, par4);
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setUnlocalizedName("pants");
	        this.setTextureName(Info.modid + ":null");
	        this.setMaxDamage(1000);
	    }
		
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
			CustomItemArmor.destroyItemArmor(stack, player, 37);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}
	    
	    @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
	        return Info.modid + ":textures/items/null.png";
	    }

	}
	
	public static class Boots extends ItemArmor implements armorTypeBoots, customArmor {
		public Boots(ArmorMaterial armorMaterial, int par3, int par4) {
	        super(armorMaterial, par3, par4);
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setUnlocalizedName("boots");
	        this.setTextureName(Info.modid + ":null");
	        this.setMaxDamage(1000);
	    }
		
		public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {
			CustomItemArmor.destroyItemArmor(stack, player, 36);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			ArmorType.getDefence(line, this.damageReduceAmount);
		}
	    
	    @SideOnly(Side.CLIENT)
	    @Override
	    public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
	        return Info.modid + ":textures/items/null.png";
	    }	    
	    
	}
	
	public static class Shoulders extends CustomItemArmor implements armorTypeShoulders, customArmor {	
		public Shoulders() {
			super();
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setMaxStackSize(1);
	        this.setUnlocalizedName("shoulders");
	        this.setMaxDamage(1000);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			int customDefence = 0;
			ArmorType.getDefence(line, customDefence);
		}

		@Override
		public void registerIcons(IIconRegister par1IconRegister) {
			this.itemIcon = par1IconRegister.registerIcon(Info.modid + ":null");
		}
		
	}
	
	public static class Bracers extends CustomItemArmor implements armorTypeBracers, customArmor {	
		public Bracers() {
			super();
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setMaxStackSize(1);
	        this.setUnlocalizedName("bracers");
	        this.setMaxDamage(1000);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			int customDefence = 0;
			ArmorType.getDefence(line, customDefence);
		}

		@Override
		public void registerIcons(IIconRegister par1IconRegister) {
			this.itemIcon = par1IconRegister.registerIcon(Info.modid + ":null");
		}
		
	}
	
	public static class Gloves extends CustomItemArmor implements armorTypeGloves, customArmor {	
		public Gloves() {
			super();
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setMaxStackSize(1);
	        this.setUnlocalizedName("gloves");
	        this.setMaxDamage(1000);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			int customDefence = 0;
			ArmorType.getDefence(line, customDefence);
		}

		@Override
		public void registerIcons(IIconRegister par1IconRegister) {
			this.itemIcon = par1IconRegister.registerIcon(Info.modid + ":null");
		}
		
	}

	public static class Belt extends CustomItemArmor implements armorTypeBelt, customArmor {	
		public Belt() {
			super();
	        this.setCreativeTab(LoadTab.tabRPGi);
	        this.setMaxStackSize(1);
	        this.setUnlocalizedName("belt");
	        this.setMaxDamage(1000);
		}
		
		@SideOnly(Side.CLIENT)
		public void addInformation(ItemStack stack, EntityPlayer player, List line, boolean advanced) {
			int customDefence = 0;
			ArmorType.getDefence(line, customDefence);
		}

		@Override
		public void registerIcons(IIconRegister par1IconRegister) {
			this.itemIcon = par1IconRegister.registerIcon(Info.modid + ":null");
		}

	}
	
}
