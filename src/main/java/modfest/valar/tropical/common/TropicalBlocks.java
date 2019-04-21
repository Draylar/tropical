package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.blocks.PineappleBlock;
import modfest.valar.tropical.common.blocks.margarita_maker.MargaritaMakerBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

public class TropicalBlocks
{
    public static MargaritaMakerBlock MARGARITA_MAKER = new MargaritaMakerBlock(FabricBlockSettings.of(Material.STONE).build());
    public static PineappleBlock PINEAPPLE = new PineappleBlock(FabricBlockSettings.of(Material.PUMPKIN).build());

    public static void register()
    {
        register(MARGARITA_MAKER, "margarita_maker");
        register(PINEAPPLE, "pineapple");
    }

    private static void register(Block block, String name)
    {
        Registry.register(Registry.BLOCK, TropicalMod.getModIdentifier(name), block);
    }
}
