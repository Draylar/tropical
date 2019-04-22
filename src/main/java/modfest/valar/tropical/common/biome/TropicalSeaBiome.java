package modfest.valar.tropical.common.biome;

import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;

public class TropicalSeaBiome extends TropicsBiome
{
	
	public TropicalSeaBiome()
	{
		super(new Properties("tropical_sea", SurfaceBuilder.DEFAULT).withDownfall(Downfall.OCEANIC));
	}
	
}
