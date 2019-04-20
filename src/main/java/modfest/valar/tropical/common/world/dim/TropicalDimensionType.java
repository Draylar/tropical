package modfest.valar.tropical.common.world.dim;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.dimension.Dimension;
import net.minecraft.world.dimension.DimensionType;

import java.util.function.BiFunction;

public class TropicalDimensionType extends DimensionType
{
    private int id;

    public TropicalDimensionType(Identifier name, int id, BiFunction<World, DimensionType, ? extends Dimension> factory)
    {
        super(id, name.getNamespace() + "_" + name.getPath(), "DIM_" + name.getNamespace() + "_" + name.getPath(), factory, true);
        this.id = id;
        register(name);
    }

    private DimensionType register(Identifier id)
    {
        return Registry.register(Registry.DIMENSION, this.id, id.toString(), this);
    }
}
