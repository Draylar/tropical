package modfest.valar.tropical.common.items;

import modfest.valar.tropical.TropicalMod;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

public class DebugTeleporterItem extends Item
{
    public DebugTeleporterItem(Settings item$Settings_1)
    {
        super(item$Settings_1);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world_1, PlayerEntity playerEntity_1, Hand hand_1)
    {
        if(!world_1.isClient && hand_1 == Hand.MAIN_HAND)
        {
            if(playerEntity_1.dimension == TropicalMod.TROPICAL_DIMENSION) playerEntity_1.changeDimension(DimensionType.OVERWORLD);
            else playerEntity_1.changeDimension(TropicalMod.TROPICAL_DIMENSION);
        }

        return super.use(world_1, playerEntity_1, hand_1);
    }
}
