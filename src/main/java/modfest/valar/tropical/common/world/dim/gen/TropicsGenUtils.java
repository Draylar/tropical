package modfest.valar.tropical.common.world.dim.gen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

public class TropicsGenUtils
{
	public static void generate(Chunk chunk, int x, int z, int worldHeight, int seaLevel, TernarySurfaceConfig surfaceBlocks)
	{
		int x1 = x & 15;
		int z1 = z & 15;

		for (int j1 = worldHeight; j1 >= 0; --j1)
		{
			Block b = chunk.getBlockState(new BlockPos(x1, j1, z1)).getBlock();

			if (b == Blocks.STONE)
			{
				if (j1 < seaLevel) chunk.setBlockState(new BlockPos(x1, j1, z1), surfaceBlocks.getUnderwaterMaterial(), false);
				else
				{
					Block b1;
					BlockState material = surfaceBlocks.getTopMaterial();
					
					if (j1 < 255)
					{
						material = Blocks.STONE.getDefaultState();
						
						b1 = chunk.getBlockState(new BlockPos(x1, j1 + 1, z1)).getBlock();
						if (b1 == Blocks.AIR)
							material = surfaceBlocks.getTopMaterial();
						else if (j1 < 252)
						{
							b1 = chunk.getBlockState(new BlockPos(x1, j1 + 4, z1)).getBlock();
							if (b1 == Blocks.AIR)
								material = surfaceBlocks.getUnderMaterial();
						}
					}
					
					chunk.setBlockState(new BlockPos(x1, j1, z1), material, false);
				}
			}
			else if (b == Blocks.WATER)
			{
				chunk.setBlockState(new BlockPos(x1, j1, z1), Blocks.WATER.getDefaultState(), false);
			}
			else
			{
				chunk.setBlockState(new BlockPos(x1, j1, z1), Blocks.AIR.getDefaultState(), false);
			}
		}
	}
}
