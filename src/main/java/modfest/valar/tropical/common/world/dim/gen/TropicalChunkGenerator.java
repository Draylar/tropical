package modfest.valar.tropical.common.world.dim.gen;

import modfest.valar.tropical.util.noise.NoiseGenerator;
import modfest.valar.tropical.util.noise.OctaveNoiseGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;

public class TropicalChunkGenerator extends SurfaceChunkGenerator<ChunkGeneratorConfig>
{

    // use a map to determine where peaks are, and a map to determine how tall they are
    private final NoiseGenerator simplexnoise;
    private final int MIDLINE = 100;

    public TropicalChunkGenerator(IWorld world, BiomeSource biomeSource_1, ChunkGeneratorConfig config) {
        super(world, biomeSource_1, 4, 8, 256, config, true);
        this.random.consume(2620);
        simplexnoise = new OctaveNoiseGenerator(0L, 2);
    }

    @Override
    public void buildSurface(Chunk chunk_1)
    {
        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                double posX = x + chunk_1.getPos().getStartX();
                double posZ = z + chunk_1.getPos().getStartZ();

                double posY = MIDLINE + simplexnoise.eval( posX / 30,posZ / 30) * 6;

                double distanceFromOrigin = getDistanceFrom(0, 0, (int) posX, (int) posZ);
                System.out.println(distanceFromOrigin);
                distanceFromOrigin = Math.min(1000, distanceFromOrigin);
                
                for (int y = 0; y < posY * convertRange(distanceFromOrigin, 0, 1000, 1, 0); y++)
                {
                    chunk_1.setBlockState(new BlockPos(x, y, z), Blocks.STONE.getDefaultState(), false);
                }
            }
        }

        for (int x = 0; x < 16; x++)
        {
            for (int z = 0; z < 16; z++)
            {
                chunk_1.setBlockState(new BlockPos(x, 0, z), net.minecraft.block.Blocks.STONE.getDefaultState(), false);
            }
        }
    }

    public double convertRange(double value, double oldMin, double oldMax, double newMin, double newMax)
    {
        return (((value - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
    }

    public double getDistanceFrom(int originX, int originZ, int currentX, int currentZ)
    {
        return Math.sqrt((currentX - originX) * (currentX - originX) + (currentZ - originZ) * (currentZ - originZ));
    }

    public int getSpawnHeight() {
        return 150;
    }

    public int getSeaLevel() {
        return 60;
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
}