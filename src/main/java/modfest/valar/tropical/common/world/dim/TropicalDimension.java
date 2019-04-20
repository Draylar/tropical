package modfest.valar.tropical.common.world.dim;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.TropicsBiomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.biome.source.BiomeSourceType;
import net.minecraft.world.chunk.ChunkPos;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;

public class TropicalDimension extends Dimension
{
    public TropicalDimension(World world_1, DimensionType dimensionType_1)
    {
        super(world_1, dimensionType_1);
    }

    @Override
    public ChunkGenerator<?> createChunkGenerator()
    {
        return TropicalMod.FABRIC_CHUNK_GENERATOR.create(world, BiomeSourceType.FIXED.applyConfig(BiomeSourceType.FIXED.getConfig().setBiome(TropicsBiomes.TROPICAL_SEA)), new ChunkGeneratorConfig());
    }

    @Override
    public BlockPos getSpawningBlockInChunk(ChunkPos chunkPos, boolean b)
    {
        return null;
    }

    @Override
    public BlockPos getTopSpawningBlockPosition(int i, int i1, boolean b)
    {
        return null;
    }

    @Override
    public float getSkyAngle(long l, float v)
    {
        double double_1 = MathHelper.fractionalPart((double) l / 24000.0D - 0.25D);
        double double_2 = 0.5D - Math.cos(double_1 * 3.141592653589793D) / 2.0D;
        return (float)(double_1 * 2.0D + double_2) / 3.0F;
    }

    @Override
    public boolean hasVisibleSky()
    {
        return true;
    }

    @Override
    public Vec3d getFogColor(float v, float v1)
    {
        float float_3 = MathHelper.cos(v * 6.2831855F) * 2.0F + 0.5F;
        float_3 = MathHelper.clamp(float_3, 0.0F, 1.0F);
        float float_4 = 0.7529412F;
        float float_5 = 0.84705883F;
        float float_6 = 1.0F;
        float_4 *= float_3 * 0.94F + 0.06F;
        float_5 *= float_3 * 0.94F + 0.06F;
        float_6 *= float_3 * 0.91F + 0.09F;
        return new Vec3d((double)float_4, (double)float_5, (double)float_6);
    }

    @Override
    public boolean canPlayersSleep()
    {
        return true;
    }

    @Override
    public boolean shouldRenderFog(int i, int i1)
    {
        return false;
    }

    @Override
    public DimensionType getType()
    {
        return TropicalMod.TROPICAL_DIMENSION;
    }
}
