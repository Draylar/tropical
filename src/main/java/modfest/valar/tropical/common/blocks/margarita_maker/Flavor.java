package modfest.valar.tropical.common.blocks.margarita_maker;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.StringRepresentable;

public enum Flavor implements StringRepresentable
{
    BANANA("banana", new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 60 * 2, 1)),
    PLAIN("plain", null),
    BERRY("berry", new StatusEffectInstance(StatusEffects.REGENERATION, 20 * 60 * 2, 1)),
    CHERRY("cherry", new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 60 * 2, 1));

    private final String name;
    private final StatusEffectInstance effect;

    Flavor(String name, StatusEffectInstance effect)
    {
        this.name = name;
        this.effect = effect;
    }

    @Override
    public String asString()
    {
        return name;
    }

    public StatusEffectInstance getEffect()
    {
        return effect;
    }
}
