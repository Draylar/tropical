package modfest.valar.tropical.common.biome;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;

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
		private final String name;
		private final SurfaceBuilder<TernarySurfaceConfig> builder;
		private Downfall downfall = Downfall.STANDARD;
		
		public Properties(String biomeName, SurfaceBuilder<TernarySurfaceConfig> surfaceBuilder)
		{
			this.name = biomeName;
			this.builder = surfaceBuilder;
		}
		
		public Properties withDownfall(Downfall downfall)
		{
			this.downfall = downfall;
			
			return this;
		}
		
		public Biome.Settings build()
		{
			return new Biome.Settings().configureSurfaceBuilder(this.builder, SurfaceBuilder.GRASS_SAND_UNDERWATER_CONFIG).precipitation(Biome.Precipitation.RAIN).category(Biome.Category.NONE).depth(0.0F).scale(0.0F).temperature(1.2F).downfall(this.downfall.toFloat()).waterColor(4445678).waterFogColor(270131).parent((String)null);
		}
		
		public String getId()
		{
			return "tropical" + ":" + this.name;
		}
	}
	
	public static enum Downfall
	{
		VULCAN(0.28F),
		OCEANIC(0.5F),
		STANDARD(0.78F),
		HUMID(0.98F);
		
		private final float downfall;
		
		private Downfall(float downfall)
		{
			this.downfall = downfall;
		}
		
		public float toFloat()
		{
			return this.downfall;
		}
	}

}
