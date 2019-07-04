package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.items.DebugTeleporterItem;
import modfest.valar.tropical.common.items.FishSwordItem;
import modfest.valar.tropical.common.items.MargaritaItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.util.registry.Registry;

public class TropicalItems
{
    private static final Item.Settings DEFAULT_SETTINGS = new Item.Settings().group(TropicalMod.GROUP);

    // generic
    private static final Item DEBUG_TELEPORTER = register("debug_teleporter", new DebugTeleporterItem(DEFAULT_SETTINGS));
    public static final Item MARGARITA = register("margarita", new MargaritaItem(DEFAULT_SETTINGS.maxCount(1)));
    public static final Item ICE_CUBES = register("ice_cubes", new Item(DEFAULT_SETTINGS));
    public static final Item MARGARITA_GLASS = register("margarita_glass", new Item(DEFAULT_SETTINGS));
    private static final Item MARGARITA_MAKER = register("margarita_maker", new BlockItem(TropicalBlocks.MARGARITA_MAKER, DEFAULT_SETTINGS));
    private static final Item COCONUT = register("coconut", new Item(DEFAULT_SETTINGS));
    private static final Item FISH_SWORD = register("fish_sword", new FishSwordItem(DEFAULT_SETTINGS));

    // blocks
    private static final Item BASALT = register("basalt", new BlockItem(TropicalBlocks.BASALT, DEFAULT_SETTINGS));
    private static final Item PUMICE = register("pumice", new BlockItem(TropicalBlocks.PUMICE, DEFAULT_SETTINGS));
    private static final Item SCORIA = register("scoria", new BlockItem(TropicalBlocks.SCORIA, DEFAULT_SETTINGS));


    // food
    private static final Item RAW_CRAB = register("raw_crab", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(3).build())));
    private static final Item SEARED_CRAB = register("seared_crab", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(6).build())));
    private static final Item BANANA = register("banana", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(2).snack().build())));
    private static final Item PINEAPPLE = register("pineapple", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(3).build())));
    private static final Item FISH_STEW = register("fish_stew", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(10).build())));
    private static final Item SWORD_FISH_SPAWN_EGG = register("sword_fish_spawn_egg", new SpawnEggItem(TropicalEntities.SWORD_FISH, 0x6d9ce8, 0xced8e8, DEFAULT_SETTINGS));
    private static final Item COCONUT_JUICE = register("coconut_juice", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(3).build())));
    private static final Item SURF_AND_TURF = register("surf_and_turf", new Item(DEFAULT_SETTINGS.food(new FoodComponent.Builder().hunger(10).build())));
    private static final Item TROPICAL_CORE = register("tropical_core", new Item(DEFAULT_SETTINGS));

    public static void register()
    {
        TropicalBlocks.loungeChairs.forEach(chair ->
        {
            register(chair.getColor().getName() + "_lounge_chair", new BlockItem(chair, DEFAULT_SETTINGS));
        });
    }

    private static Item register(String name, Item item)
    {
        return Registry.register(Registry.ITEM, TropicalMod.getModIdentifier(name), item);
    }
}
