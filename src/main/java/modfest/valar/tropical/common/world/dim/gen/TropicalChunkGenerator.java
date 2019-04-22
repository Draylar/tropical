package modfest.valar.tropical.common.world.dim.gen;

import java.util.Random;

import modfest.valar.tropical.common.TropicalBiomes;
import modfest.valar.tropical.util.SeedCache;
import modfest.valar.tropical.util.noise.NoiseGenerator;
import modfest.valar.tropical.util.noise.OctaveNoiseGenerator;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;

public class TropicalChunkGenerator extends SurfaceChunkGenerator<ChunkGeneratorConfig>
{

    // use a map to determine where peaks are, and a map to determine how tall they are
    private static NoiseGenerator heightNoise = new OctaveNoiseGenerator(0, 2);
    private static NoiseGenerator blockNoise;
    private static NoiseGenerator biomeNoise;

    private static final int MIDLINE = 100;

    public TropicalChunkGenerator(IWorld world, BiomeSource biomeSource_1, ChunkGeneratorConfig config) {
        super(world, biomeSource_1, 4, 8, 256, config, true);
        SeedCache.setSeed(world.getSeed());
        this.random.consume(2620);

        heightNoise = new OctaveNoiseGenerator(world.getSeed(), 2);
        blockNoise = new OctaveNoiseGenerator(world.getSeed(), 6).apply(8D);
        biomeNoise = new OctaveNoiseGenerator(world.getSeed() + 23L, 1).apply(15D);
    }

    @Override
    public void buildSurface(Chunk chunk_1)
    {
        {
            for (int x = 0; x < 16; x++)
            {
                for (int z = 0; z < 16; z++)
                {
                    int posX = x + chunk_1.getPos().getStartX();
                    int posZ = z + chunk_1.getPos().getStartZ();

                    double height = getTerrainScale(posX, posZ);

                    for (int y = 0; y < height; y++)
                    {
                        chunk_1.setBlockState(new BlockPos(x, y, z), Blocks.STONE.getDefaultState(), false);
                    }
                    
                    getBiome(posX, posZ).buildSurface(new Random(234612362L * posX + -8264616432452L * posZ), chunk_1, posX, posZ, 255, blockNoise.eval(x, z), Blocks.STONE.getDefaultState(), Blocks.WATER.getDefaultState(), getSeaLevel(), world.getSeed());
                }
            }
        }
    }


    public static Biome getBiome(int x, int z)
    {
        double finalY = getTerrainScale(x, z);

        if(finalY < 57) return TropicalBiomes.TROPICAL_SEA;

        else if(finalY <= 64)
        {
            double d = biomeNoise.eval(0.03D * x, 0.03D * z);
            
            if (d > 0)
            	return TropicalBiomes.WHITE_SHORE;
            else
            	return TropicalBiomes.PALM_BEACH;
        }

        else return TropicalBiomes.DEFAULT;
    }


    private static double getTerrainScale(int x, int z)
    {
        // position based on height noise
        double posY = MIDLINE + heightNoise.eval(x / 30, z / 30) * 6;

        // 0 - 1 number representing how far out we are from 0, 0
        double distanceScale = convertRange(
                Math.min(
                        1000,
                        getDistanceFrom(
                                0,
                                0,
                                x,
                                z)
                ),
                0,
                1000,
                1,
                0
        );

        return posY * distanceScale;
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