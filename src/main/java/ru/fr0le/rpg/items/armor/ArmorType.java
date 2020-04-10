package ru.fr0le.rpg.items.armor;

import java.util.List;

import net.minecraft.util.StatCollector;

public class ArmorType {

	public interface customArmor {

	}

	public interface armorTypeHelmet {

	}

	public interface armorTypeBody {

	}

	public interface armorTypePants {

	}

	public interface armorTypeBoots {

	}

	public interface armorTypeShoulders {

	}

	public interface armorTypeBracers {

	}

	public interface armorTypeGloves {

	}

	public interface armorTypeBelt {

	}

	public static String getTranslate(String s) {
		return StatCollector.translateToLocal(s);
	}

	public static void getDefence(List line, int defence) {
		line.add("§9" + getTranslate("armor.defence") + ":§7 " + defence);
	}	

}