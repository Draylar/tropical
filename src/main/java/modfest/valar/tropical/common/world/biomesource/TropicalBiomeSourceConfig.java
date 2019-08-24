package modfest.valar.tropical.common.world.biomesource;

import net.minecraft.world.biome.source.BiomeSourceConfig;

public class TropicalBiomeSourceConfig implements BiomeSourceConfig
{
	private long seed;
	
	public TropicalBiomeSourceConfig setSeed(long seed)
	{
		this.seed = seed;
		return this;
	}
	
	public long getSeed()
	{
		return seed;
	}
}
