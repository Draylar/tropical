package modfest.valar.tropical.common;

import java.util.HashSet;
import java.util.Set;

import modfest.valar.tropical.common.biome.TropicsBiome;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeRegistry
{
	private static Set<Biome> customBiomes = new HashSet<>();
	
	//Mostly just to initialise MC biomes before custom biomes
	public static final Biome defaultBiome = Biomes.PLAINS;
	
	private static Biome register(Biome biome, String ID)
	{	
		Registry.register(Registry.BIOME, ID, biome);
		customBiomes.add(biome);
		
		return biome;
	}
	
	static final Set<Biome> customBiomes()
	{
		return customBiomes;
	}
	
	public static Biome register(TropicsBiome biome)
	{
		return register(biome, biome.getId());
	}
}
