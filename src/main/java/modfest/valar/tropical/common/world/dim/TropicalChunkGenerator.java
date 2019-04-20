package modfest.valar.tropical.common.world.dim;

import net.minecraft.world.IWorld;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;

public class TropicalChunkGenerator extends SurfaceChunkGenerator<ChunkGeneratorConfig>
{
    public TropicalChunkGenerator(IWorld world, BiomeSource biomeSource, ChunkGeneratorConfig config)
    {
        super(world, biomeSource, 4, 8, 256, config, true);
    }

    @Override
    protected double[] computeNoiseRange(int i, int i1)
    {
        return new double[0];
    }

    @Override
    protected double computeNoiseFalloff(double v, double v1, int i)
    {
        return 0;
    }

    @Override
    protected void sampleNoiseColumn(double[] doubles, int i, int i1)
    {

    }

    @Override
    public int getSpawnHeight()
    {
        return 0;
    }
}
