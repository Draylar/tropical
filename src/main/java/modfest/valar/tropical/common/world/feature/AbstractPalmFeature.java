package modfest.valar.tropical.common.world.feature;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public abstract class AbstractPalmFeature extends AbstractTropicalTreeFeature
{
	protected static final BlockState LEAVES = Blocks.OAK_LEAVES.getDefaultState();
	protected static final BlockState LOG = Blocks.JUNGLE_LOG.getDefaultState();
	
	public AbstractPalmFeature(boolean notify, int minHeight)
	{
		super(notify, minHeight, minHeight + 5);
		
		this.setBeachFeature();
	}

}
