package modfest.valar.tropical.common;

import modfest.valar.tropical.common.biome.TropicalSeaBiome;
import modfest.valar.tropical.common.biome.WhiteShoreBiome;
import net.minecraft.world.biome.Biome;

public class TropicsBiomes
{
	public static final Biome TROPICAL_SEA = BiomeRegistry.register(new TropicalSeaBiome());
	public static final Biome WHITE_SHORE = BiomeRegistry.register(new WhiteShoreBiome());
}
