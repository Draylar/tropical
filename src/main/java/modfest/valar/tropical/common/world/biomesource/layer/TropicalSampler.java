package modfest.valar.tropical.common.world.biomesource.layer;

import net.minecraft.world.biome.Biome;
import modfest.valar.tropical.util.noise.NoiseGenerator;

public interface TropicalSampler
{
	Biome sample(int x, int z, int height, NoiseGenerator noise);
}
