package modfest.valar.tropical.common.blocks.margarita_maker;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class MargaritaMakerBlock extends BlockWithEntity
{
    private static VoxelShape MACHINE_SHAPE;

    public MargaritaMakerBlock(Settings block$Settings_1)
    {
        super(block$Settings_1);
    }

    @Override
    public BlockEntity createBlockEntity(BlockView var1)
    {
        return new MargaritaMakerBlockEntity();
    }

    @Override
    public boolean activate(BlockState blockState_1, World world_1, BlockPos blockPos_1, PlayerEntity playerEntity_1, Hand hand_1, BlockHitResult blockHitResult_1)
    {
        BlockEntity entity = world_1.getBlockEntity(blockPos_1);
        if(entity instanceof MargaritaMakerBlockEntity && hand_1 == Hand.MAIN)
        {
            ((MargaritaMakerBlockEntity) entity).activate(blockState_1, world_1, blockPos_1, playerEntity_1, hand_1, blockHitResult_1);
        }

        return super.activate(blockState_1, world_1, blockPos_1, playerEntity_1, hand_1, blockHitResult_1);
    }

    static
    {
        MACHINE_SHAPE = VoxelShapes.empty();
    }
}
