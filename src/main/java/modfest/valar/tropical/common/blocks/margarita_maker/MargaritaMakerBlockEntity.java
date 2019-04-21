package modfest.valar.tropical.common.blocks.margarita_maker;

import modfest.valar.tropical.common.TropicalEntities;
import modfest.valar.tropical.common.TropicalItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Hand;
import net.minecraft.util.Tickable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MargaritaMakerBlockEntity extends BlockEntity implements Tickable
{
    private int glassCount = 0;
    private int iceCubeCount = 0;

    private int currentTime = 0;
    private int maxTime = 60;

    private ItemStack outputStack = ItemStack.EMPTY;

    public MargaritaMakerBlockEntity()
    {
        super(TropicalEntities.MARGARITA_MAKER);
    }

    void activate(BlockState state, World world, BlockPos pos, PlayerEntity playerEntity, Hand hand, BlockHitResult hitResult)
    {
        ItemStack stack = playerEntity.getMainHandStack();
        int count = stack.getAmount();

        if (stack.getItem() == TropicalItems.ICE_CUBES)
        {
            int changedCount = 0;

            for (int neededCount = 0; neededCount < 16 - iceCubeCount; neededCount++)
            {
                if (count >= neededCount) changedCount++;
                else break;
            }

            stack.subtractAmount(changedCount);
            iceCubeCount += changedCount;
        }

        else if (stack.getItem() == TropicalItems.MARGARITA_GLASS)
        {
            int changedCount = 0;

            for (int neededCount = 0; neededCount < 16 - glassCount; neededCount++)
            {
                if (count >= neededCount) changedCount++;
                else break;
            }

            stack.subtractAmount(changedCount);
            glassCount += changedCount;
        }

        else if (stack.isEmpty())
        {
            playerEntity.inventory.setInvStack(playerEntity.inventory.selectedSlot, outputStack);
            outputStack = ItemStack.EMPTY;
        }
    }

    @Override
    public void tick()
    {
        if(isBurning())
        {
            if(currentTime >= maxTime)
            {
                currentTime = 0;
                outputStack = new ItemStack(Items.DIAMOND);
            }

            else currentTime++;
        }

        else if(outputStack == ItemStack.EMPTY && glassCount >= 1 && iceCubeCount >= 4)
        {
            // start creation
            currentTime = 1;
            glassCount--;
            iceCubeCount-=4;
        }
    }

    private boolean isBurning()
    {
        return this.currentTime > 0;
    }

    @Override
    public CompoundTag toTag(CompoundTag compoundTag_1)
    {
        compoundTag_1.putInt("glassCount", glassCount);
        compoundTag_1.putInt("iceCubeCount", iceCubeCount);
        return super.toTag(compoundTag_1);
    }

    @Override
    public void fromTag(CompoundTag compoundTag_1)
    {
        glassCount = compoundTag_1.getInt("glassCount");
        iceCubeCount = compoundTag_1.getInt("iceCubeCount");
        super.fromTag(compoundTag_1);
    }
}