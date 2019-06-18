package modfest.valar.tropical.common.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FishSwordItem extends SwordItem
{
    public FishSwordItem(Settings item$Settings_1)
    {
        super(new ToolMaterial()
        {
            @Override
            public int getDurability()
            {
                return 750;
            }

            @Override
            public float getMiningSpeed()
            {
                return 0;
            }

            @Override
            public float getAttackDamage()
            {
                return 5;
            }

            @Override
            public int getMiningLevel()
            {
                return 1;
            }

            @Override
            public int getEnchantability()
            {
                return 15;
            }

            @Override
            public Ingredient getRepairIngredient()
            {
                return null;
            }
        }, 1, 1, item$Settings_1);
    }
}
