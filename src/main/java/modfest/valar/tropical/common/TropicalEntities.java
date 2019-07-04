package modfest.valar.tropical.common;

import modfest.valar.tropical.TropicalMod;
import modfest.valar.tropical.common.blocks.margarita_maker.MargaritaMakerBlockEntity;
import modfest.valar.tropical.common.entity.LoungeChairBlockEntity;
import modfest.valar.tropical.common.entity.ProjectileTikiEntity;
import modfest.valar.tropical.common.entity.TikiTotemEntity;
import modfest.valar.tropical.common.entity.SwordFishEntity;
import net.fabricmc.fabric.api.entity.FabricEntityTypeBuilder;
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
    public static final BlockEntityType<LoungeChairBlockEntity> LOUNGE_CHAIR = register("lounge_chair", BlockEntityType.Builder.create(LoungeChairBlockEntity::new).build(null));
    public static final EntityType<SwordFishEntity> SWORD_FISH = FabricEntityTypeBuilder.create(EntityCategory.CREATURE, SwordFishEntity::new).size(EntitySize.resizeable(1, 1).scaled(1, .5f)).build();
    public static final EntityType<TikiTotemEntity> TIKI_TOTEM = FabricEntityTypeBuilder.create(EntityCategory.CREATURE, TikiTotemEntity::new).size(EntitySize.resizeable(2, 3)).build();
    public static final EntityType<ProjectileTikiEntity> PROJECTILE_TIKI = FabricEntityTypeBuilder.create(EntityCategory.CREATURE, ProjectileTikiEntity::new).size(EntitySize.resizeable(1, 1)).build();

    public static void register()
    {
        register("margarita_maker", MARGARITA_MAKER);
        register(SWORD_FISH, "sword_fish");
        register(TIKI_TOTEM, "tiki_totem");
        register(PROJECTILE_TIKI, "projectile_tiki");
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(String name, BlockEntityType<T> entity)
    {
        return Registry.register(Registry.BLOCK_ENTITY, TropicalMod.getModIdentifier(name), entity);
    }

    private static void register(EntityType<? extends Entity> entity, String name)
    {
        Registry.register(Registry.ENTITY_TYPE, TropicalMod.getModIdentifier(name), entity);
    }
}
