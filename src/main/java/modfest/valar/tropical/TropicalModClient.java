package modfest.valar.tropical;

import modfest.valar.tropical.common.TropicalItems;
import modfest.valar.tropical.common.entity.sword_fish.SwordFishEntity;
import modfest.valar.tropical.common.entity.sword_fish.SwordFishEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.render.ColorProviderRegistryImpl;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.item.DyeableItem;
import net.minecraft.potion.Potions;

public class TropicalModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.INSTANCE.register(SwordFishEntity.class, (r, w) -> new SwordFishEntityRenderer(r));
    }
}
