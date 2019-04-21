package modfest.valar.tropical.common.blocks.margarita_maker;

import modfest.valar.tropical.common.TropicalEntities;
import modfest.valar.tropical.common.TropicalItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MargaritaMakerBlockEntity extends BlockEntity
{
    private ItemStack ICE_CUBES = ItemStack.EMPTY;
    private ItemStack FLAVOR = ItemStack.EMPTY;
    private ItemStack CUPS = ItemStack.EMPTY;

    public MargaritaMakerBlockEntity()
    {
        super(TropicalEntities.MARGARITA_MAKER);
    }

    void activate(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult)
    {
        ItemStack stack = playerEntity.getMainHandStack();
        int count = stack.getAmount();

        if(stack.getItem() == TropicalItems.ICE_CUBES)
        {

        }
    }
}
