package modfest.valar.tropical.common.world.biomesource.layer;

import modfest.valar.common.noise.NoiseGenerator;
import modfest.valar.tropical.common.TropicalBiomes;
import net.minecraft.world.biome.Biome;

public enum AddIslandVariantsLayer implements TropicalBiomeLayer
{
	INSTANCE;

	@Override
	public Biome sample(TropicalSampler sampler, NoiseGenerator noise, int x, int z, int height)
	{
		Biome biome = sampler.sample(x, z, height, noise);
		
		if (biome == TropicalBiomes.DEFAULT)
		{
			double d0 = noise.eval(x, z);
			
			if (d0 > 0.75D || d0 < -0.75D)
				biome = TropicalBiomes.JUNGLE;
			else if (d0 > 0D)
				biome = TropicalBiomes.DEFAULT; //another variant
		}
		
		return biome;
	}

}
