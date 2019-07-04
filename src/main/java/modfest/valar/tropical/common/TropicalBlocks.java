package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.blocks.CustomSandBlock;
import modfest.valar.tropical.common.blocks.LoungeChairBlock;
import modfest.valar.tropical.common.blocks.PineappleBlock;
import modfest.valar.tropical.common.blocks.margarita_maker.MargaritaMakerBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;

public class TropicalBlocks
{
    public static Block MARGARITA_MAKER = register("margarita_maker", new MargaritaMakerBlock(FabricBlockSettings.of(Material.STONE).build()));
    public static Block PINEAPPLE = register("pineapple", new PineappleBlock(FabricBlockSettings.of(Material.PUMPKIN).build()));
    public static Block WHITE_SAND = register("white_sand", new CustomSandBlock(FabricBlockSettings.of(Material.SAND).sounds(BlockSoundGroup.SAND).hardness(0.1F).resistance(0.1F).build()));
    public static Block BASALT = register("basalt", new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).build()));
    public static Block SCORIA = register("scoria", new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).build()));
    public static Block PUMICE = register("pumice", new Block(FabricBlockSettings.of(Material.STONE).hardness(1f).build()));

    public static ArrayList<LoungeChairBlock> loungeChairs = new ArrayList<>();
    
    public static void register()
    {
        for(DyeColor color : DyeColor.values())
        {
            loungeChairs.add((LoungeChairBlock) register(color.getName() + "_lounge_chair", new LoungeChairBlock(FabricBlockSettings.of(Material.WOOD).build(), color)));
        }
    }
    
    private static Block register(String name, Block block)
    {
        return Registry.register(Registry.BLOCK, new Identifier("tropical", name), block);
    }
}
