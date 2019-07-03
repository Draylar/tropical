package modfest.valar.tropical.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class ProjectileTikiEntity extends ProjectileEntity
{
    public ProjectileTikiEntity(EntityType<? extends ProjectileEntity> entityType, World world)
    {
        super(entityType, world);
    }

    @Override
    protected ItemStack asItemStack()
    {
        return new ItemStack(Items.STONE);
    }
}
