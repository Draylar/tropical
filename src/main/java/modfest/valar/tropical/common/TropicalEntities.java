package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.blocks.margarita_maker.MargaritaMakerBlockEntity;
import modfest.valar.tropical.common.entity.sword_fish.SwordFishEntity;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
import net.fabricmc.fabric.impl.entity.FabricEntityType;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCategory;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public class TropicalEntities
{
    public static final BlockEntityType<MargaritaMakerBlockEntity> MARGARITA_MAKER = BlockEntityType.Builder.create(MargaritaMakerBlockEntity::new).build(null);
    public static final EntityType<SwordFishEntity> SWORD_FISH = FabricEntityTypeBuilder.create(EntityCategory.CREATURE, (EntityType.EntityFactory<SwordFishEntity>) SwordFishEntity::new).size(EntitySize.resizeable(1, 1).scaled(1, .5f)).build();


    public static void register()
    {
        register(MARGARITA_MAKER, "margarita_maker");
        register(SWORD_FISH, "sword_fish");
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
