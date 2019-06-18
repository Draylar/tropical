package modfest.valar.tropical.mixin;

import modfest.valar.tropical.common.TropicalItems;
import modfest.valar.tropical.common.items.MargaritaItem;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.item.ItemColors;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MargaritaColorMixin
{
    @Shadow private ItemColors itemColorMap;

    @Inject(at = @At(
            value = "INVOKE_ASSIGN",
            target = "Lnet/minecraft/client/color/item/ItemColors;create(Lnet/minecraft/client/color/block/BlockColors;)Lnet/minecraft/client/color/item/ItemColors;",
            shift = At.Shift.AFTER
    ), method = "init")
    private void initializeItemColors(CallbackInfo info)
    {
        itemColorMap.register((stack, int_1) ->
        {
            return int_1 > 0 ? -1 : MargaritaItem.getColorFromStack(stack);
        }, TropicalItems.MARGARITA);
    }
}
