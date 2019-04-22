package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.blocks.CustomSandBlock;
import modfest.valar.tropical.common.blocks.PineappleBlock;
import modfest.valar.tropical.common.blocks.margarita_maker.MargaritaMakerBlock;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TropicalBlocks
{
    public static MargaritaMakerBlock MARGARITA_MAKER = new MargaritaMakerBlock(FabricBlockSettings.of(Material.STONE).build());
    public static PineappleBlock PINEAPPLE = new PineappleBlock(FabricBlockSettings.of(Material.PUMPKIN).build());
    public static CustomSandBlock WHITE_SAND = new CustomSandBlock(FabricBlockSettings.of(Material.SAND).sounds(BlockSoundGroup.SAND).hardness(0.1F).resistance(0.1F).build());
    
    public static void register()
    {
        register(MARGARITA_MAKER, "margarita_maker");
        register(PINEAPPLE, "pineapple");
        register(WHITE_SAND, "white_sand").registerItemBlock(TropicalMod.GROUP);;
    }
    
    private static BlockRegistryOutput register(Block block, String name)
    {
    	Identifier identifier = TropicalMod.getModIdentifier(name);
    	
        Registry.register(Registry.BLOCK, identifier, block);
        
        return new BlockRegistryOutput(block, identifier);
    }
    
    private static final class BlockRegistryOutput
    {
    	private final Block block;
    	private final Identifier name;
    	
    	private BlockRegistryOutput(Block block, Identifier name)
    	{
    		this.block = block;
    		this.name = name;
    	}
    	
    	public void registerItemBlock(ItemGroup group)
    	{
    		Registry.register(Registry.ITEM, this.name, new BlockItem(this.block, new Item.Settings().itemGroup(group)));
    	}
    }
}
