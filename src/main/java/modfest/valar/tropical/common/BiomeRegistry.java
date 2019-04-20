package modfest.valar.tropical.common;

import modfest.valar.tropical.common.biome.TropicsBiome;
import modfest.valar.tropical.common.biome.TropicsBiome;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;

public class BiomeRegistry
{
	private static int nextID = 0;
	
	//Mostly just to initialise MC biomes before custom biomes
	public static final Biome defaultBiome = Biomes.PLAINS;
	
	private static Biome register(Biome biome, String ID, int specifiedID)
	{	
		Registry.register(Registry.BIOME, specifiedID, ID, biome);
		if (biome.hasParent())
		{
			Biome.PARENT_BIOME_ID_MAP.set(biome, Registry.BIOME.getRawId(Registry.BIOME.get(new Identifier(biome.getParent()))));
		}

		return biome;
	}
	
	public static Biome register(TropicsBiome biome)
	{
		int thisId = getNextId();
		
		return register(biome, biome.getId(), thisId);
	}
	
	private static int getNextId()
	{
		++nextID;
		while (isIdTaken(nextID)) ++nextID;
		
		return nextID;
	}
	
	private static boolean isIdTaken(int id)
	{
		return !(Registry.BIOME.get(id) == null);
	}
}
