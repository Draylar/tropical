package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.world.feature.BeachSpikeFeature;
import modfest.valar.tropical.common.world.feature.OceanSpikeFeature;
import modfest.valar.tropical.common.world.feature.PalmCoconutFeature;
import modfest.valar.tropical.common.world.feature.PalmJungleFeature;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

public class TropicalFeatures
{
	public static final Feature<DefaultFeatureConfig> COCONUT_PALM;
	public static final Feature<DefaultFeatureConfig> JUNGLE_PALM;
	public static final Feature<DefaultFeatureConfig> OCEAN_SPIKE;
	public static final Feature<DefaultFeatureConfig> BEACH_ROCK;
	
	private static Feature<DefaultFeatureConfig> register(Feature<DefaultFeatureConfig> feature, String name)
	{
		Registry.register(Registry.FEATURE, TropicalMod.getModIdentifier(name), feature);
		
		return feature;
	}
	
	static
	{
		BEACH_ROCK = register(new BeachSpikeFeature(), "beach_spike");
		COCONUT_PALM = register(new PalmCoconutFeature(false), "coconut_palm");
		JUNGLE_PALM = register(new PalmJungleFeature(false), "jungle_palm");
		OCEAN_SPIKE = register(new OceanSpikeFeature(DefaultFeatureConfig::deserialize), "ocean_spike");
	}
}
