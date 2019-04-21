package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.items.DebugTeleporterItem;
import modfest.valar.tropical.common.items.MargaritaItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class TropicalItems
{
    private static final Item.Settings DEFAULT_SETTINGS = new Item.Settings().itemGroup(TropicalMod.GROUP);

    private static final Item DEBUG_TELEPORTER = new DebugTeleporterItem(DEFAULT_SETTINGS);
    public static final Item MARGARITA = new MargaritaItem(DEFAULT_SETTINGS);
    public static final Item ICE_CUBES = new Item(DEFAULT_SETTINGS);
    public static final Item MARGARITA_GLASS = new Item(DEFAULT_SETTINGS);
    private static final Item MARGARITA_MAKER = new BlockItem(TropicalBlocks.MARGARITA_MAKER, DEFAULT_SETTINGS);
    private static final Item RAW_CRAB = new Item(DEFAULT_SETTINGS.food(new FoodItemSetting.Builder().hunger(3).build()));
    private static final Item SEARED_CRAB = new Item(DEFAULT_SETTINGS.food(new FoodItemSetting.Builder().hunger(6).build()));
    private static final Item BANANA = new Item(DEFAULT_SETTINGS.food(new FoodItemSetting.Builder().hunger(2).eatenFast().build()));
    private static final Item PINEAPPLE = new Item(DEFAULT_SETTINGS.food(new FoodItemSetting.Builder().hunger(3).build()));

    public static void register()
    {
        register(DEBUG_TELEPORTER, "debug_teleporter");
        register(MARGARITA, "margarita");
        register(ICE_CUBES, "ice_cubes");
        register(MARGARITA_GLASS, "margarita_glass");
        register(MARGARITA_MAKER, "margarita_maker");
        register(RAW_CRAB, "raw_crab");
        register(SEARED_CRAB, "seared_crab");
        register(BANANA, "banana");
        register(PINEAPPLE, "pineapple");
    }

    private static void register(Item item, String name)
    {
        Registry.register(Registry.ITEM, TropicalMod.getModIdentifier(name), item);
    }
}
