package modfest.valar.tropical.common.biome;

import modfest.valar.tropical.common.TropicalFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class TropicalJungleBiome extends TropicsBiome
{

	public TropicalJungleBiome()
	{
		super(new Properties("tropical_jungle", SurfaceBuilder.DEFAULT).withDownfall(Downfall.HUMID));
		
		this.biomePopulator.treesPerChunk = 20;
		
		this.biomePopulator.addTreeFeature(Feature.JUNGLE_GROUND_BUSH, 5);
		this.biomePopulator.addTreeFeature(TropicalFeatures.JUNGLE_PALM, 1.5F);
		this.biomePopulator.addTreeFeature(TropicalFeatures.BEACH_ROCK, 0.1F);
		this.biomePopulator.addTreeFeature(Feature.MEGA_JUNGLE_TREE, 0.8F);
		
		this.biomePopulator.buildTreeFeatures();
	}
	
}
