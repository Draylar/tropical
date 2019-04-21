package modfest.valar.tropical.common;

import modfest.valar.tropical.common.biome.TropicsBiome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeRegistry
{
	
	//Mostly just to initialise MC biomes before custom biomes
	public static final Biome defaultBiome = Biomes.PLAINS;
	
	private static Biome register(Biome biome, String ID)
	{	
		Registry.register(Registry.BIOME, ID, biome);

		return biome;
	}
	
	public static Biome register(TropicsBiome biome)
	{
		return register(biome, biome.getId());
	}
}
