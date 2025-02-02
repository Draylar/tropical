package modfest.valar.tropical;

import modfest.valar.tropical.common.TropicalEntities;
import modfest.valar.tropical.common.TropicalBlocks;
import modfest.valar.tropical.common.TropicalItems;
import modfest.valar.tropical.common.TropicalItemGroup;
import modfest.valar.tropical.common.world.dim.TropicalDimension;
import modfest.valar.tropical.common.world.dim.TropicalDimensionType;
import modfest.valar.tropical.common.world.dim.gen.ChunkGeneratorTypeWorkaround;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.chunk.ChunkGeneratorConfig;
import net.minecraft.world.gen.chunk.ChunkGeneratorType;

public class TropicalMod implements ModInitializer
{
	public static TropicalItemGroup GROUP = new TropicalItemGroup();
	public static DimensionType TROPICAL_DIMENSION = new TropicalDimensionType(getModIdentifier("tropical"), 5, TropicalDimension::new);
	public static ChunkGeneratorType FABRIC_CHUNK_GENERATOR = new ChunkGeneratorTypeWorkaround().getChunkGeneratorType(ChunkGeneratorConfig::new);

	@Override
	public void onInitialize()
	{
		TropicalBlocks.register();
		TropicalItems.register();
		TropicalEntities.register();
	}

	public static Identifier getModIdentifier(String name)
	{
		return new Identifier("tropical", name);
	}
}
