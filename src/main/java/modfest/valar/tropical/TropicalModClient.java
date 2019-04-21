package modfest.valar.tropical;

import modfest.valar.tropical.common.entity.sword_fish.SwordFishEntity;
import modfest.valar.tropical.common.entity.sword_fish.SwordFishEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.EntityRendererRegistry;

public class TropicalModClient implements ClientModInitializer
{
    @Override
    public void onInitializeClient()
    {
        EntityRendererRegistry.INSTANCE.register(SwordFishEntity.class, (r, w) -> new SwordFishEntityRenderer(r));
    }
}
