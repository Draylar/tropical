package modfest.valar.tropical.common.world.layer;

import modfest.valar.tropical.common.TropicalBiomes;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public enum ShoreTropicalBiomeLayer implements TropicalInitLayer
{
	INSTANCE;
	
	private static final Biome[] biomes = new Biome[] {
			TropicalBiomes.PALM_BEACH,
			TropicalBiomes.ROCKY_SHORE,
			TropicalBiomes.WHITE_SHORE
	};
	
	@Override
	public int sample(LayerRandomnessSource rand, int x, int z)
	{
		return Registry.BIOME.getRawId(pickBiome(rand, biomes));
	}
	
}
