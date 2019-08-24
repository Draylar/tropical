package modfest.valar.tropical.common.world.biomesource;

import java.util.List;
import java.util.Random;
import java.util.Set;

import com.google.common.collect.Sets;

import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import modfest.valar.common.noise.NoiseGenerator;
import modfest.valar.tropical.common.TropicalBiomes;
import modfest.valar.tropical.common.world.dim.gen.TropicalChunkGenerator;
import modfest.valar.tropical.common.world.layer.TropicalLayers;
import modfest.valar.tropical.util.noise.TweakableOctaveNoiseGenerator;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.layer.BiomeLayerSampler;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.feature.StructureFeature;

public class TropicalBiomeSource extends BiomeSource
{
	private Biome[] allowedBiomes;
	private final BiomeLayerSampler landSampler, shoreSampler, seaSampler;

	private NoiseGenerator biomeNoise;

	public TropicalBiomeSource(TropicalBiomeSourceConfig config)
	{
		this.allowedBiomes = TropicalBiomes.asBiomeArray();

		BiomeLayerSampler[] samplers = TropicalLayers.getBiomeLayers(config.getSeed());

		landSampler = samplers[0];
		shoreSampler = samplers[1];
		seaSampler = samplers[2];

		biomeNoise = new TweakableOctaveNoiseGenerator(config.getSeed() + 23L, 3).apply(250D);
	}

	@Override
	public Biome getBiome(int x, int z)
	{
		double offset = 4 * biomeNoise.eval(x, z);
		
		double y = TropicalChunkGenerator.getTerrainScale(x, z);
		if (y > 59)
			y += offset;
		
		return this.getBiome(x, (int) y, z);
	}

	@Override
	public Biome[] sampleBiomes(int x, int z, int xSize, int zSize, boolean cacheFlag)
	{
		Biome[] biomes_1 = new Biome[xSize * zSize];
		Long2ObjectMap<Biome> long2ObjectMap_1 = new Long2ObjectOpenHashMap<Biome>();

		for(int int_5 = 0; int_5 < xSize; ++int_5)
		{
			for(int int_6 = 0; int_6 < zSize; ++int_6)
			{
				int int_7 = int_5 + x;
				int int_8 = int_6 + z;
				long long_1 = ChunkPos.toLong(int_7, int_8);
				Biome biome_1 = (Biome)long2ObjectMap_1.get(long_1);
				if (biome_1 == null)
				{
					biome_1 = this.getBiome(int_7, int_8);
					long2ObjectMap_1.put(long_1, biome_1);
				}

				biomes_1[int_5 + int_6 * xSize] = biome_1;
			}
		}

		return biomes_1;
	}

	@Override
	public Set<Biome> getBiomesInArea(int x, int z, int range)
	{
		int int_4 = x - range >> 2;;
		int int_5 = z - range >> 2;
		int int_6 = x + range >> 2;
		int int_7 = z + range >> 2;
		int int_8 = int_6 - int_4 + 1;
		int int_9 = int_7 - int_5 + 1;

		return Sets.newHashSet(this.sampleBiomes(int_4, int_5, int_8, int_9));
	}

	//From analogy of 1.12 code
	//If there's a better way to do this please do
	@Override
	public BlockPos locateBiome(int x, int z, int range, List<Biome> biomes, Random random)
	{
		int i = x - range >> 2;
		int j = z - range >> 2;
		int k = x + range >> 2;
		int l = z + range >> 2;
		int i1 = k - i + 1;
		int j1 = l - j + 1;

		BlockPos blockpos = null;
		int k1 = 0;

		Biome[] biomesInArea = this.sampleBiomes(x, z, i1, j1);

		for (int l1 = 0; l1 < i1 * j1; ++l1)
		{
			int i2 = i + l1 % i1 << 2;
			int j2 = j + l1 / i1 << 2;
			Biome biome = biomesInArea[l1];

			if (biomes.contains(biome) && (blockpos == null || random.nextInt(k1 + 1) == 0))
			{
				blockpos = new BlockPos(i2, 0, j2);
				++k1;
			}
		}

		return blockpos;
	}

	@Override
	public boolean hasStructureFeature(StructureFeature<?> var1)
	{
		return (Boolean)this.structureFeatures.computeIfAbsent(var1, (structureFeature_1x) -> {
			Biome[] var2 = this.allowedBiomes;
			int var3 = var2.length;

			for(int var4 = 0; var4 < var3; ++var4) {
				Biome biome_1 = var2[var4];
				if (biome_1.hasStructureFeature(structureFeature_1x)) {
					return true;
				}
			}

			return false;
		});
	}

	@Override
	public Set<BlockState> getTopMaterials()
	{
		if (this.topMaterials.isEmpty()) {
			Biome[] var1 = this.allowedBiomes;
			int var2 = var1.length;

			for(int var3 = 0; var3 < var2; ++var3) {
				Biome biome_1 = var1[var3];
				this.topMaterials.add(biome_1.getSurfaceConfig().getTopMaterial());
			}
		}

		return this.topMaterials;
	}

	public Biome getBiome(int x, int y, int z)
	{
		IslandSection section = IslandSection.get(y);

		Biome biome = getSectionBiome(section, x, z);

		return biome;
	}

	private Biome getSectionBiome(IslandSection section, int x, int z)
	{
		switch(section)
		{
		case LAND:
			return landSampler.sample(x, z);
		case SEA:
			return seaSampler.sample(x, z);
		case SHORE:
			return shoreSampler.sample(x, z);
		default:
			return TropicalBiomes.DEFAULT;
		}
	}

	private static enum IslandSection
	{
		SEA,
		SHORE,
		LAND;

		public static IslandSection get(int height)
		{
			if (height < 59) return SEA;
			else if (height < 64) return SHORE;
			else return LAND;
		}
	}

}
