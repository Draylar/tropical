package modfest.valar.tropical.common.entity.sword_fish;

import modfest.valar.tropical.common.TropicalEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class SwordFishEntity extends FishEntity
{
    public SwordFishEntity(EntityType<?> entityType_1, World world_1) {
        super((EntityType<SwordFishEntity>) entityType_1, world_1);
    }

    public SwordFishEntity(World world_1)
    {
        super(TropicalEntities.SWORD_FISH, world_1);
    }



    @Override
    protected ItemStack getFishBucketItem()
    {
        return new ItemStack(Items.WATER_BUCKET);
    }

    @Override
    protected SoundEvent getFlopSound()
    {
        return SoundEvents.ENTITY_COD_FLOP;
    }
}
