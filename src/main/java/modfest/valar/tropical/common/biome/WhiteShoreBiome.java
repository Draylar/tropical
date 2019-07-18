package modfest.valar.tropical.common.biome;

import java.util.Random;

import modfest.valar.tropical.common.TropicalBlocks;
import modfest.valar.tropical.common.world.dim.gen.TropicsGenUtils;
import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class WhiteShoreBiome extends TropicsBiome
{

	public WhiteShoreBiome()
	{
		super(new Properties("white_shore", WHITE_SHORE_BUILDER));
	}
	
	private static final SurfaceBuilder<TernarySurfaceConfig> WHITE_SHORE_BUILDER;
	private static final TernarySurfaceConfig WHITE_SHORE_BLOCKS = new TernarySurfaceConfig(TropicalBlocks.WHITE_SAND.getDefaultState(), TropicalBlocks.WHITE_SAND.getDefaultState(), TropicalBlocks.WHITE_SAND.getDefaultState());
	
	static
	{
		WHITE_SHORE_BUILDER = Registry.register(Registry.SURFACE_BUILDER, "tropical:white_shore", new WhiteShoreBuilder());
	}
	
	private static class WhiteShoreBuilder extends TropicalSurfaceBuilder
	{
		
		public WhiteShoreBuilder()
		{
			super(TernarySurfaceConfig::deserialize);
		}

		@Override
		public void generate(Random rand, Chunk chunk, Biome biome, int x, int z, int worldHeight, double noise,
				BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed,
				TernarySurfaceConfig surfaceBlocks)
		{
			TropicsGenUtils.generate(chunk, x, z, worldHeight, seaLevel, WHITE_SHORE_BLOCKS);
		}
	}
	
}
