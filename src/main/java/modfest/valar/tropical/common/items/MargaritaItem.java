package modfest.valar.tropical.common.items;

import java.util.List;

import modfest.valar.tropical.common.TropicalItems;
import modfest.valar.tropical.common.blocks.margarita_maker.Flavor;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.util.DefaultedList;
import net.minecraft.world.World;

public class MargaritaItem extends Item
{
    public MargaritaItem(Settings item$Settings_1)
    {
        super(item$Settings_1.food(new FoodComponent.Builder().build()));
    }

    @Override
    public ItemStack finishUsing(ItemStack itemStack_1, World world_1, LivingEntity livingEntity_1)
    {
        if (livingEntity_1 instanceof PlayerEntity)
        {
            PlayerEntity playerEntity = (PlayerEntity) livingEntity_1;
            playerEntity.getHungerManager().setFoodLevel(playerEntity.getHungerManager().getFoodLevel() + 4);
        }

        return super.finishUsing(itemStack_1, world_1, livingEntity_1);
    }

    public static ItemStack createMargarita(Flavor flavor)
    {
        ItemStack stack = new ItemStack(TropicalItems.MARGARITA);
        stack.getOrCreateTag().putString("flavor", flavor.name());

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Component> list, TooltipContext tooltipContext_1)
    {
        if (stack.hasTag())
        {
            CompoundTag tag = stack.getTag();
            if (tag.containsKey("flavor")) ;
            {
                String flavor = tag.getString("flavor");
                list.add(new TextComponent(flavor));
            }
        }

        super.appendTooltip(stack, world, list, tooltipContext_1);
    }

    @Override
    public void appendStacks(ItemGroup group, DefaultedList<ItemStack> defaultedList)
    {
        defaultedList.add(createMargarita(Flavor.PLAIN));
        defaultedList.add(createMargarita(Flavor.CHERRY));
        defaultedList.add(createMargarita(Flavor.BANANA));
        defaultedList.add(createMargarita(Flavor.BERRY));
    }

    public static int getColorFromStack(ItemStack stack)
    {
        if (stack.hasTag())
        {
            CompoundTag tag = stack.getTag();
            if (tag.containsKey("flavor")) ;
            {
                String flavorString = tag.getString("flavor");
                Flavor flavor = Flavor.valueOf(flavorString);

                switch (flavor)
                {
                    case BERRY:
                        return 6579455;
                    case BANANA:
                        return 16776960;
                    case CHERRY:
                        return 13107200;
                }
            }
        }

        return 16777215;
    }
}
