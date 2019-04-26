package modfest.valar.tropical.common.world.biomesource.layer;

import modfest.valar.tropical.util.noise.NoiseGenerator;
import net.minecraft.world.biome.Biome;

public interface TropicalBiomeLayer
{
	Biome sample(TropicalSampler sampler, NoiseGenerator noise, int x, int z, int height);
}
