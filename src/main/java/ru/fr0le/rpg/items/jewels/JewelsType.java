package ru.fr0le.rpg.items.jewels;

import java.util.List;

import net.minecraft.util.StatCollector;

public class JewelsType {
	
	public interface customJewel {
		
	}
	
	public interface jewelTypeNecklace {
		
	}
	
	public interface jewelTypeRing {
		
	}
	
	public interface jewelTypeArtifact {
		
	}
	
	public static String getTranslate(String s) {
		return StatCollector.translateToLocal(s);
	}

	public static void getDescription(List line) {
		line.add("§9" + getTranslate("jewel.description"));
	}

}
