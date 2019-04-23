package modfest.valar.tropical.common.world.dim.gen;

import modfest.valar.tropical.common.TropicalBiomes;
import modfest.valar.tropical.util.SeedCache;
import modfest.valar.tropical.util.noise.NoiseGenerator;
import modfest.valar.tropical.util.noise.OctaveNoiseGenerator;
import modfest.valar.tropical.util.noise.OpenSimplexNoise;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;

import java.util.Random;

public class TropicalChunkGenerator extends SurfaceChunkGenerator<ChunkGeneratorConfig>
{

    // use a map to determine where peaks are, and a map to determine how tall they are
    private static NoiseGenerator heightNoise;
    private static NoiseGenerator blockNoise;
    private static NoiseGenerator biomeNoise;

    private static final double MIDLINE = 100;

    public TropicalChunkGenerator(IWorld world, BiomeSource biomeSource_1, ChunkGeneratorConfig config) {
        super(world, biomeSource_1, 4, 8, 256, config, true);
        this.random.consume(2620);

        heightNoise = new OctaveNoiseGenerator(world.getSeed(), 2);
        blockNoise = new OctaveNoiseGenerator(world.getSeed(), 6).apply(8D);
        biomeNoise = new OctaveNoiseGenerator(world.getSeed() + 23L, 1).apply(15D);
    }

    @Override
    public void buildSurface(Chunk chunk_1)
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


    private static double getTerrainScale(double x, double z)
    {
        double noiseHeight;
        if(getDistanceFromOrigin(x, z) < 300)
        {
            noiseHeight = heightNoise.eval(x / 30, z / 30) * 7;
        }

        else noiseHeight = heightNoise.eval(x / 30, z / 30) * 3;

        double posY = (MIDLINE  + noiseHeight) * (1 - Math.min(1000, getDistanceFromOrigin(x, z)) / 1000);

        return posY;
    }



    private static double getDistanceFromOrigin(double x, double z)
    {
        double xDifference = Math.pow(x, 2);
        double zDifference = Math.pow(z, 2);
        return Math.sqrt(xDifference + zDifference);
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