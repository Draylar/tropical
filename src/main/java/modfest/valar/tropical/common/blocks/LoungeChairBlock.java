package modfest.valar.tropical.common.blocks;

import modfest.valar.tropical.common.entity.LoungeChairBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.DyeColor;
import net.minecraft.world.BlockView;

public class LoungeChairBlock extends BlockWithEntity
{
    private final DyeColor color;

    public LoungeChairBlock(Settings settings, DyeColor color)
    {
        super(settings);
        this.color = color;
    }

    @Override
    public BlockEntity createBlockEntity(BlockView var1)
    {
        return new LoungeChairBlockEntity();
    }

    @Override
    public BlockRenderType getRenderType(BlockState blockState_1)
    {
        return BlockRenderType.MODEL;
    }

    @Environment(EnvType.CLIENT)
    public DyeColor getColor() {
        return this.color;
    }
}
