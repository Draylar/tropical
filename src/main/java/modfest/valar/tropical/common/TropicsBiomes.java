package modfest.valar.tropical.common;

import java.util.Set;

import modfest.valar.tropical.common.biome.TropicalIslandBiome;
import modfest.valar.tropical.common.biome.TropicalSeaBiome;
import modfest.valar.tropical.common.biome.WhiteShoreBiome;
import net.minecraft.world.biome.Biome;

public class TropicsBiomes
{
	//Only have the frameworks of the biomes at the moment
	public static final Biome TROPICAL_SEA = BiomeRegistry.register(new TropicalSeaBiome());
	public static final Biome WHITE_SHORE = BiomeRegistry.register(new WhiteShoreBiome());
	public static final Biome DEFAULT = BiomeRegistry.register(new TropicalIslandBiome());
	
	public static Biome[] asBiomeArray()
	{
		Set<Biome> biomes = BiomeRegistry.customBiomes();
		Biome[] b = new Biome[biomes.size()];
		return biomes.toArray(b);
	}
}
