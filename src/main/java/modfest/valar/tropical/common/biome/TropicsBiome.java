package modfest.valar.tropical.common.biome;

import modfest.valar.tropical.TropicalMod;
import net.minecraft.world.biome.Biome;

public abstract class TropicsBiome extends Biome
{
	private final String id;
	
	protected TropicsBiome(Properties properties)
	{
		super(properties.build());
		
		this.id = properties.getId();
	}
	
	public String getId()
	{
		return id;
	}

	public static class Properties
	{
		private final float baseHeight, scale;
		private final String name;
		
		public Properties(String biomeName, float baseHeight, float scale)
		{
			this.baseHeight = baseHeight;
			this.scale = scale;
			this.name = biomeName;
		}
		
		public Biome.Settings build()
		{
			return new Biome.Settings().depth(baseHeight).scale(scale);
		}
		
		public String getId()
		{
			return TropicalMod.MODID + ":" + this.name;
		}
	}

}
