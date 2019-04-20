package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import net.minecraft.block.Block;
import net.minecraft.util.registry.Registry;

public class TropicsBlocks
{
    public static void register()
    {

    }

    private static void register(Block block, String name)
    {
        Registry.register(Registry.BLOCK, TropicalMod.getModIdentifier(name), block);
    }
}
