package modfest.valar.tropical.common.biome;

import java.util.Random;

import modfest.valar.tropical.common.TropicalFeatures;
import modfest.valar.tropical.common.world.dim.gen.TropicsGenUtils;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class PalmShoreBiome extends TropicsBiome
{

	public PalmShoreBiome()
	{
		super(new Properties("palm_beach", PALM_BEACH_BUILDER));
		
		this.theBiomePopulator.extraTreeChance = 0.5F;
		
		this.theBiomePopulator.addTreeFeature(TropicalFeatures.COCONUT_PALM, 1);
		
		this.theBiomePopulator.buildTreeFeatures();
	}
	
	public static final SurfaceBuilder<TernarySurfaceConfig> PALM_BEACH_BUILDER;
	private static final TernarySurfaceConfig PALM_BEACH_BLOCKS = new TernarySurfaceConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
	
	static
	{
		PALM_BEACH_BUILDER = Registry.register(Registry.SURFACE_BUILDER, "tropical:palm_beach", new WhiteShoreBuilder());
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
			TropicsGenUtils.generate(chunk, x, z, worldHeight, seaLevel, PALM_BEACH_BLOCKS);
		}
	}
	
}
