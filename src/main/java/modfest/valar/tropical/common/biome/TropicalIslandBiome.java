package modfest.valar.tropical.common.biome;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class TropicalIslandBiome extends TropicsBiome
{

	public TropicalIslandBiome()
	{
		super(new Properties("tropical_island", SurfaceBuilder.DEFAULT));
		
		this.biomePopulator.treesPerChunk = 2;
		
		this.biomePopulator.addTreeFeature(Feature.FANCY_TREE, 1);
		this.biomePopulator.addTreeFeature(Feature.JUNGLE_GROUND_BUSH, 0.5F);
		
		this.biomePopulator.buildTreeFeatures();
	}
	
}
