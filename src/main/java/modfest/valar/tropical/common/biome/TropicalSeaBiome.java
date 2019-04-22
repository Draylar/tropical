package modfest.valar.tropical.common.biome;

import modfest.valar.tropical.common.TropicalFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class TropicalSeaBiome extends TropicsBiome
{
	
	public TropicalSeaBiome()
	{
		super(new Properties("tropical_sea", SurfaceBuilder.DEFAULT).withDownfall(Downfall.OCEANIC));

		this.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(TropicalFeatures.OCEAN_SPIKE, new DefaultFeatureConfig(), Decorator.CHANCE_TOP_SOLID_HEIGHTMAP, new ChanceDecoratorConfig(4)));
	}
	
}
