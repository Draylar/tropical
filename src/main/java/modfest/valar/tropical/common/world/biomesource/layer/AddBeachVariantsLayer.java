package modfest.valar.tropical.common.world.biomesource.layer;

import modfest.valar.common.noise.NoiseGenerator;
import modfest.valar.tropical.common.TropicalBiomes;
import net.minecraft.world.biome.Biome;

public enum AddBeachVariantsLayer implements TropicalBiomeLayer
{
	INSTANCE;

	@Override
	public Biome sample(TropicalSampler sampler, NoiseGenerator noise, int x, int z, int height)
	{
		Biome biome = sampler.sample(x, z, height, noise);
		
		if (biome == TropicalBiomes.PALM_BEACH)
		{
			double d = noise.eval(x, z);
			
			System.out.println(d);
			
			if (d > 0.75D || d < -0.75D)
				biome = TropicalBiomes.ROCKY_SHORE;
			else if (d > 0)
				biome = TropicalBiomes.WHITE_SHORE;
		}
		
		return biome;
	}

}
