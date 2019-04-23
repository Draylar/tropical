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

public class RockyShoreBiome extends TropicsBiome
{

	public RockyShoreBiome()
	{
		super(new Properties("rocky_shore", ROCKY_SHORE_BUILDER));
		
		this.biomePopulator.extraTreeChance = 0.15F;
		
		this.biomePopulator.addTreeFeature(TropicalFeatures.BEACH_ROCK, 1);
		
		this.biomePopulator.buildTreeFeatures();
	}
	
	private static final SurfaceBuilder<TernarySurfaceConfig> ROCKY_SHORE_BUILDER;
	private static final TernarySurfaceConfig SANDY_CONFIG = new TernarySurfaceConfig(Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState(), Blocks.SAND.getDefaultState());
	private static final TernarySurfaceConfig COBBLED_CONFIG = new TernarySurfaceConfig(Blocks.COBBLESTONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState());
	private static final TernarySurfaceConfig ROCKY_CONFIG = new TernarySurfaceConfig(Blocks.STONE.getDefaultState(), Blocks.STONE.getDefaultState(), Blocks.SAND.getDefaultState());
	
	static
	{
		ROCKY_SHORE_BUILDER = Registry.register(Registry.SURFACE_BUILDER, "tropical:rocky_shore", new WhiteShoreBuilder());
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
			if (noise > 1.45D)
				TropicsGenUtils.generate(chunk, x, z, worldHeight, seaLevel, ROCKY_CONFIG);
			else
			{
				if (rand.nextInt(3) == 0)
					TropicsGenUtils.generate(chunk, x, z, worldHeight, seaLevel, COBBLED_CONFIG);
				else
					TropicsGenUtils.generate(chunk, x, z, worldHeight, seaLevel, SANDY_CONFIG);
			}
		}
	}
	
}
