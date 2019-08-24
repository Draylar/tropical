package modfest.valar.tropical.common.world.layer;

import java.util.function.LongFunction;

import com.google.common.collect.ImmutableList;

import net.minecraft.world.biome.layer.BiomeLayerSampler;
import net.minecraft.world.biome.layer.CachingLayerContext;
import net.minecraft.world.biome.layer.CachingLayerSampler;
import net.minecraft.world.biome.layer.CellScaleLayer;
import net.minecraft.world.biome.layer.LayerFactory;
import net.minecraft.world.biome.layer.LayerSampleContext;
import net.minecraft.world.biome.layer.LayerSampler;
import net.minecraft.world.biome.layer.ScaleLayer;

public class TropicalLayers
{
	public static BiomeLayerSampler[] getBiomeLayers(long seed)
	{
		ImmutableList<LayerFactory<CachingLayerSampler>> factories = create((salt) -> {
			return new CachingLayerContext(1, seed, salt);
		});

		BiomeLayerSampler land = new BiomeLayerSampler(factories.get(0));
		BiomeLayerSampler shore = new BiomeLayerSampler(factories.get(1));
		BiomeLayerSampler sea = new BiomeLayerSampler(factories.get(2));
		return new BiomeLayerSampler[]{land, shore, sea};
	}

	private static <R extends LayerSampler> ImmutableList<LayerFactory<R>> create(LongFunction<LayerSampleContext<R>> context)
	{
		LayerFactory<R> land = LandTropicalBiomeLayer.INSTANCE.create(context.apply(1L));
		LayerFactory<R> shore = ShoreTropicalBiomeLayer.INSTANCE.create(context.apply(2L));
		LayerFactory<R> sea = SeaTropicalBiomeLayer.INSTANCE.create(context.apply(1L));
		
		
		int biomeSize = 5;
		
		for (int i = 0; i < biomeSize; ++i) {
			land = ScaleLayer.NORMAL.create(context.apply(100L + i), land);
			shore = ScaleLayer.NORMAL.create(context.apply(100L + i), shore);
			sea = ScaleLayer.NORMAL.create(context.apply(100L + i), sea);
		}
		
		land = CellScaleLayer.INSTANCE.create(context.apply(4L), land);
		shore = CellScaleLayer.INSTANCE.create(context.apply(4L), shore);
		sea = CellScaleLayer.INSTANCE.create(context.apply(4L), sea);
		
		return ImmutableList.of(land, shore, sea);
	}
}
