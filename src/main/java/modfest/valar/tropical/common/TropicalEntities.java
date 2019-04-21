package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.blocks.margarita_maker.MargaritaMakerBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class TropicalEntities
{
    public static final BlockEntityType<MargaritaMakerBlockEntity> MARGARITA_MAKER = BlockEntityType.Builder.create(MargaritaMakerBlockEntity::new).build(null);


    public static void register()
    {
        register(MARGARITA_MAKER, "margarita_maker");
    }

    private static void register(BlockEntityType<? extends BlockEntity> BE, String name)
    {
        Registry.register(Registry.BLOCK_ENTITY, TropicalMod.getModIdentifier(name), BE);
    }

    private static void register(EntityType<? extends Entity> entity, String name)
    {
        Registry.register(Registry.ENTITY_TYPE, TropicalMod.getModIdentifier(name), entity);
    }
}
