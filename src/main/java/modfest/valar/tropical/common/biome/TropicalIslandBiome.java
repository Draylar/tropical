package modfest.valar.tropical.common.biome;

import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class TropicalIslandBiome extends TropicsBiome
{

	public TropicalIslandBiome()
	{
		super(new Properties("tropical_island", SurfaceBuilder.DEFAULT));
		
		this.theBiomePopulator.treesPerChunk = 2;
		
		this.theBiomePopulator.addTreeFeature(Feature.FANCY_TREE, 1);
		
		this.theBiomePopulator.buildTreeFeatures();
	}
	
}
