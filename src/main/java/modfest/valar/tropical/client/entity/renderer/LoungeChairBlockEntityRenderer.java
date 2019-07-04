package modfest.valar.tropical.client.entity.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import modfest.valar.tropical.common.entity.LoungeChairBlockEntity;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;

public class LoungeChairBlockEntityRenderer extends BlockEntityRenderer<LoungeChairBlockEntity>
{
    @Override
    public void render(LoungeChairBlockEntity chair, double double_1, double double_2, double double_3, float float_1, int int_1)
    {
        GlStateManager.pushMatrix();
        GlStateManager.popMatrix();
    }
}
