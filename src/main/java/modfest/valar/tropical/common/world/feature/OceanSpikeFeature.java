package modfest.valar.tropical.common.world.feature;

import com.mojang.datafixers.Dynamic;
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
        int aboveOceanHeight = random.nextInt(10);

        for(int i = pos.getY(); world.getBlockState(new BlockPos(pos.getX(), i, pos.getZ())).getBlock() == Blocks.AIR; i++)
        {
            world.setBlockState(new BlockPos(pos.getX(), i, pos.getZ()), Blocks.OBSERVER.getDefaultState(), 0);
        }

        return false;
    }
}
