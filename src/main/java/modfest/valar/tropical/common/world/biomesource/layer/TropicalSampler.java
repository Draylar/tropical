package modfest.valar.tropical.common.world.biomesource.layer;

import modfest.valar.common.noise.NoiseGenerator;
import net.minecraft.world.biome.Biome;

public interface TropicalSampler
{
	Biome sample(int x, int z, int height, NoiseGenerator noise);
}
