package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.items.DebugTeleporterItem;
import modfest.valar.tropical.common.items.MargaritaItem;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class TropicsItems
{
    private static final Item.Settings DEFAULT_SETTINGS = new Item.Settings().itemGroup(TropicalMod.GROUP);

    private static final Item DEBUG_TELEPORTER = new DebugTeleporterItem(DEFAULT_SETTINGS);
    public static final Item MARGARITA = new MargaritaItem(DEFAULT_SETTINGS);

    public static void register()
    {
        register(DEBUG_TELEPORTER, "debug_teleporter");
        register(MARGARITA, "margarita");
    }

    private static void register(Item item, String name)
    {
        Registry.register(Registry.ITEM, TropicalMod.getModIdentifier(name), item);
    }
}
