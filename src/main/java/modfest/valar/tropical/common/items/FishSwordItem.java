package modfest.valar.tropical.common.items;

import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FishSwordItem extends SwordItem
{
    public FishSwordItem(int int_1, float float_1, Settings item$Settings_1)
    {
        super(new ToolMaterial()
        {
            @Override
            public int getDurability()
            {
                return 0;
            }

            @Override
            public float getBlockBreakingSpeed()
            {
                return 0;
            }

            @Override
            public float getAttackDamage()
            {
                return 0;
            }

            @Override
            public int getMiningLevel()
            {
                return 0;
            }

            @Override
            public int getEnchantability()
            {
                return 0;
            }

            @Override
            public Ingredient getRepairIngredient()
            {
                return null;
            }
        }, int_1, float_1, item$Settings_1);
    }
}
