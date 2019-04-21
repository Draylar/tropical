package modfest.valar.tropical.common.entity.sword_fish;

import modfest.valar.tropical.common.TropicalEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FishEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
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
        return null;
    }

    @Override
    protected SoundEvent getFlopSound()
    {
        return null;
    }
}
