package modfest.valar.tropical;

import modfest.valar.tropical.common.TropicsBlocks;
import modfest.valar.tropical.common.TropicsItems;
import modfest.valar.tropical.common.gui.TropicalItemGroup;
import modfest.valar.tropical.common.world.dim.ChunkGeneratorTypeWorkaround;
import modfest.valar.tropical.common.world.dim.TropicalDimension;
import modfest.valar.tropical.common.world.dim.TropicalDimensionType;
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
		TropicsBlocks.register();
		TropicsItems.register();
	}

	public static Identifier getModIdentifier(String name)
	{
		return new Identifier("tropical", name);
	}
}
