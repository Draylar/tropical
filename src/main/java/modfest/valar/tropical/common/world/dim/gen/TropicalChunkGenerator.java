package modfest.valar.tropical.common.world.dim.gen;

import modfest.valar.tropical.common.TropicalBiomes;
import modfest.valar.tropical.util.noise.NoiseGenerator;
import modfest.valar.tropical.util.noise.OctaveNoiseGenerator;
import modfest.valar.tropical.util.noise.OpenSimplexNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;

public class TropicalChunkGenerator extends SurfaceChunkGenerator<ChunkGeneratorConfig>
{

    // use a map to determine where peaks are, and a map to determine how tall they are
    private static NoiseGenerator simplexnoise = new OctaveNoiseGenerator(0, 0);
    private static final int MIDLINE = 100;

    public TropicalChunkGenerator(IWorld world, BiomeSource biomeSource_1, ChunkGeneratorConfig config) {
        super(world, biomeSource_1, 4, 8, 256, config, true);
        this.random.consume(2620);
        simplexnoise = new OpenSimplexNoise();
    }

    public static Biome getBiome(int x, int z)
    {
        double posY = MIDLINE + simplexnoise.eval( x / 30,z / 30) * 6;
        double distanceFromOrigin = getDistanceFrom(0, 0, (int) x, (int) z);
        distanceFromOrigin = Math.min(1000, distanceFromOrigin);

        double range = convertRange(distanceFromOrigin, 0, 1000, 1, 0);
        double finalY = posY * range;

        System.out.println(range);

        if(finalY <= 50)
        {
            return TropicalBiomes.TROPICAL_SEA;
        }

        if(finalY <= 65)
        {
            return TropicalBiomes.WHITE_SHORE;
        }

        else
        {
            return Biomes.FOREST;
        }
    }

    public static double convertRange(double value, double oldMin, double oldMax, double newMin, double newMax)
    {
        return (((value - oldMin) * (newMax - newMin)) / (oldMax - oldMin)) + newMin;
    }

    public static double getDistanceFrom(int originX, int originZ, int currentX, int currentZ)
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