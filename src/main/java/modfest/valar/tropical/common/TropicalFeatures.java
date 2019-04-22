package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.world.feature.PalmCoconutFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TropicalFeatures
{
	public static final Feature<DefaultFeatureConfig> COCONUT_PALM;
	
	private static Feature<DefaultFeatureConfig> register(Feature<DefaultFeatureConfig> feature, String name)
	{
		Registry.register(Registry.FEATURE, TropicalMod.getModIdentifier(name), feature);
		
		return feature;
	}
	
	static
	{
		COCONUT_PALM = register(new PalmCoconutFeature(false), "coconut_palm");
	}
}
