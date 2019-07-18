package modfest.valar.tropical.common.world.biomesource.layer;

import modfest.valar.common.noise.NoiseGenerator;
import modfest.valar.tropical.common.TropicalBiomes;
import net.minecraft.world.biome.Biome;

public class SetIslandSectionsLayer implements TropicalSampler
{

	@Override
	public Biome sample(int x, int z, int height, NoiseGenerator noise)
	{
		if (height < 57) return TropicalBiomes.TROPICAL_SEA;
		else if (height < 64) return TropicalBiomes.PALM_BEACH;
		else return TropicalBiomes.DEFAULT;
	}

}
