package modfest.valar.tropical.common.world.dim.biomesource;

import java.util.ArrayList;
import java.util.List;

import modfest.valar.tropical.common.biome.TropicsBiome;
import net.minecraft.util.Pair;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class BiomePopulator
{
	public final TropicsBiome parent;
	
	public BiomePopulator(TropicsBiome parent)
	{
		this.parent = parent;
	}

	public int treesPerChunk = 0;
	public float extraTreeChance = 0.1F;
	public int extraTreeCount = 1;

	private List<Pair<Feature<DefaultFeatureConfig>, Float>> treeFeatures = new ArrayList<>();

	private float weightSum = 0;

	public BiomePopulator addTreeFeature(Feature<DefaultFeatureConfig> feature, float weight)
	{
		weightSum += weight;
		this.treeFeatures.add(new Pair<Feature<DefaultFeatureConfig>, Float>(feature, weight));
		return this;
	}

	public void buildTreeFeatures()
	{
		float tpc = (float) this.treesPerChunk;
		for (Pair<Feature<DefaultFeatureConfig>, Float> feature : treeFeatures)
		{
			int n1 = MathHelper.floor(tpc * (feature.getRight().floatValue() / this.weightSum));

			this.parent.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Biome.configureFeature(feature.getLeft(), FeatureConfig.DEFAULT, Decorator.COUNT_EXTRA_HEIGHTMAP, new CountExtraChanceDecoratorConfig(n1, this.extraTreeChance, this.extraTreeCount)));
		}
	}
}
