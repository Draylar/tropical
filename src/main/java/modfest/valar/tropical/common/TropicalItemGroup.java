package modfest.valar.tropical.common;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class TropicalItemGroup extends ItemGroup
{
    public TropicalItemGroup()
    {
        super(0, "tropical:tropical_group");
    }

    @Override
    public ItemStack createIcon()
    {
        return new ItemStack(Items.OBSIDIAN);
    }
}
