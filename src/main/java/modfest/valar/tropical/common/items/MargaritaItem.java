package modfest.valar.tropical.common.items;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodItemSetting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MargaritaItem extends Item
{
    public MargaritaItem(Settings item$Settings_1)
    {
        super(item$Settings_1.food(new FoodItemSetting.Builder().hunger(0).build()));
    }

    @Override
    public ItemStack onItemFinishedUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1)
    {
        if(livingEntity_1 instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) livingEntity_1;
            playerEntity.getHungerManager().setFoodLevel(playerEntity.getHungerManager().getFoodLevel() + 4);
        }

        return super.onItemFinishedUsing(itemStack_1, world_1, livingEntity_1);
    }
}
