package modfest.valar.tropical.common.world.dim.gen;

import java.util.Random;

import modfest.valar.tropical.common.world.biomesource.TropicalBiomeSource;
import modfest.valar.tropical.util.noise.NoiseGenerator;
import modfest.valar.tropical.util.noise.OctaveNoiseGenerator;
import modfest.valar.tropical.util.properties.MathUtils;
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
    private static NoiseGenerator heightNoise;
    private static NoiseGenerator blockNoise;
    private static NoiseGenerator biomeNoise;

    private static final double MIDLINE = 100;

    public TropicalChunkGenerator(IWorld world, BiomeSource biomeSource_1, ChunkGeneratorConfig config) {
        super(world, biomeSource_1, 4, 8, 256, config, true);
        this.random.consume(2620);
        
        heightNoise = new OctaveNoiseGenerator(world.getSeed(), 2).apply(30D);
        blockNoise = new OctaveNoiseGenerator(world.getSeed() - 23L, 6).apply(8D);
        biomeNoise = new OctaveNoiseGenerator(world.getSeed() + 23L, 2).apply(250D);
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
        
        return TropicalBiomeSource.buildBiomes(x, z, (int) finalY, (OctaveNoiseGenerator) biomeNoise);
    }
    
    static
    {
    	System.out.println(getDistanceFromOrigin(0, 0));
    	System.out.println(getDistanceFromOrigin(0, 200));
    	System.out.println(getDistanceFromOrigin(0, 400));
    	
    	System.out.println(MathUtils.sigmoid(400D - 0, 31.5D, 2.5D, 0.02D, -200D));
    	System.out.println(MathUtils.sigmoid(400D - 200, 31.5D, 2.5D, 0.02D, -200D));
    	System.out.println(MathUtils.sigmoid(400D - 400, 31.5D, 2.5D, 0.02D, -200D));
    }
    
    private static double getTerrainScale(double x, double z)
    {
        double noiseHeight;
        
        double scaleValue = sigmoidLand(getDistanceFromOrigin(x, z));
        
        noiseHeight = scale(heightNoise.eval(x, z), a(scaleValue), scaleValue);
        
        double posY = (MIDLINE  + noiseHeight) * (1 - Math.min(1000, getDistanceFromOrigin(x, z)) / 1000);

        return posY;
    }
    
    /**
     * Get lower land scale
     * Too lazy to name this function
     * 
     * @param a land scale
     * @return
     */
    private static double a(double a)
    {
    	double b = a / 2.5D;
    	
    	if (b < 3D) return 3D; else return b;
    }
    
    /**
     * Sigmoid for land scale
     * 
     * @param dIn
     * @return
     */
    private static double sigmoidLand(double dIn)
    {
    	if (dIn >= 400D)
    		return 3;
    	else
    		return MathUtils.sigmoid(400D - dIn, 31.5D, 2.5D, 0.02D, -200D);
    }
    
    @SuppressWarnings("unused")
	private static double scale(double noise, double scale)
    {
    	return noise * scale;
    }
    
    private static double scale(double noise, double scaleBelow, double scaleAbove)
    {
    	if (noise > 0)
    		return noise * scaleAbove;
    	else
    		return noise * scaleBelow;
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