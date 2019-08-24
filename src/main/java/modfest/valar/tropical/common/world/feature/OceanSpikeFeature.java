package modfest.valar.tropical.common.world.feature;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;
import java.util.function.Function;

public class OceanSpikeFeature extends Feature<DefaultFeatureConfig>
{
    public OceanSpikeFeature(Function<Dynamic<?>, ? extends DefaultFeatureConfig> function_1) {
        super(function_1);
    }

    @Override
    public boolean generate(IWorld world, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, Random random, BlockPos pos, DefaultFeatureConfig defaultFeatureConfig)
    {
        // System.out.println("generating: " + pos);

        int aboveOceanHeight = 5 + random.nextInt(10);

        int addedY = 0;
        for(int i = pos.getY(); world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())).getBlock() != Blocks.AIR; i++)
        {
            for (int x = -2; x < 3; x++)
            {
                for (int z = -2; z < 3; z++)
                {
                    world.setBlockState(new BlockPos(pos.getX() + x, i, pos.getZ() + z), getRandomStone(random), 0);
                }
            }

            addedY++;
        }

        for (int i = pos.getY() + addedY; i < pos.getY() + addedY + aboveOceanHeight; i++)
        {
            for (int x = -1; x < 2; x++)
            {
                for (int z = -1; z < 2; z++)
                {
                    world.setBlockState(new BlockPos(pos.getX() + x, i, pos.getZ() + z), getRandomStone(random), 0);
                }
            }
        }

        return false;
    }

    private BlockState getRandomStone(Random random)
    {
         int rand = random.nextInt(4);

         switch(rand)
         {
             case 0:
                 return Blocks.STONE.getDefaultState();
             case 1:
                 return Blocks.ANDESITE.getDefaultState();
             case 2:
                 return Blocks.GRAVEL.getDefaultState();
             case 3:
                 return Blocks.COBBLESTONE.getDefaultState();
         }

         return Blocks.STONE.getDefaultState();
    }
}
