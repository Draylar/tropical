package modfest.valar.tropical.common.world.layer;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.InitLayer;
import net.minecraft.world.biome.layer.LayerRandomnessSource;

public interface TropicalInitLayer extends InitLayer {
	default public Biome pickBiome(LayerRandomnessSource rand, Biome[] array)
	{
		return array[rand.nextInt(array.length)];
	}
}
