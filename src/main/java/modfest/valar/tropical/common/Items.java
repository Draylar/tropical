package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class Items
{
    public static void register()
    {

    }

    private static void register(Item item, String name)
    {
        Registry.register(Registry.ITEM, TropicalMod.getModIdentifier(name), item);
    }
}
