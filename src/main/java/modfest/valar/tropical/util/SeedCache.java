package modfest.valar.tropical.util;

public class SeedCache
{
	private static long seed = 0L;
	
	public static long getSeed()
	{
		return seed;
	}
	
	public static void setSeed(long long_1)
	{
		seed = long_1;
	}
}
