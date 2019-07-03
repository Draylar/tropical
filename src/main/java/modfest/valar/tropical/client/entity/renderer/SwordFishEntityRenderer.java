package modfest.valar.tropical.client.entity.renderer;

import modfest.valar.tropical.common.entity.models.SwordFishEntityModel;
import modfest.valar.tropical.common.entity.SwordFishEntity;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.Identifier;

public class SwordFishEntityRenderer extends MobEntityRenderer<SwordFishEntity, EntityModel<SwordFishEntity>>
{
    public SwordFishEntityRenderer(EntityRenderDispatcher entityRenderDispatcher_1) {
        super(entityRenderDispatcher_1, new SwordFishEntityModel(), 0.15F);
    }

    @Override
    protected Identifier getTexture(SwordFishEntity var1)
    {
        return new Identifier("tropical", "textures/entity/sword_fish.png");
    }
}
