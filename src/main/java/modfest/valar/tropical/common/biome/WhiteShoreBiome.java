package modfest.valar.tropical.common.biome;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class WhiteShoreBiome extends TropicsBiome
{

	public WhiteShoreBiome()
	{
		super(new Properties("white_shore", WHITE_SHORE_BUILDER));
	}
	
	private static final SurfaceBuilder<TernarySurfaceConfig> WHITE_SHORE_BUILDER = new WhiteShoreBuilder();
	
	private static class WhiteShoreBuilder extends TropicalSurfaceBuilder
	{
		//TODO will be white sand
		private static final TernarySurfaceConfig DEFAULT_CONFIG = new SingleSurfaceConfig(Blocks.SAND.getDefaultState());
		
		public WhiteShoreBuilder()
		{
			super(TernarySurfaceConfig::deserialize);
		}

		@Override
		public TernarySurfaceConfig getSurfaceBlocks(double noise, long seed, int x, int z)
		{
			return DEFAULT_CONFIG;
		}
		
	}
	
}
