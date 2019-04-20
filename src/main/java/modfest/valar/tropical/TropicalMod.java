package modfest.valar.tropical;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class TropicalMod implements ModInitializer
{
	@Override
	public void onInitialize()
	{

	}

	public static Identifier getModIdentifier(String name)
	{
		return new Identifier("tropical", name);
	}
}
