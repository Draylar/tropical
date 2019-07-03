package modfest.valar.tropical.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.MobEntityWithAi;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BoundingBox;
import net.minecraft.world.World;

import java.util.List;

public class TikiTotemEntity extends MobEntityWithAi
{
    private static float MAX_HEALTH = 225;
    private static float STAGE_2_HP = 150;
    private static float STAGE_1_HP = 75;

    // stage 1 mechanics
    private int ticksSinceLastMelee = 0;
    private int ticksSinceLastStomp = 0;
    private boolean isStomping = false;
    private int stompingTicks = 0;

    public TikiTotemEntity(EntityType<? extends MobEntityWithAi> entityType_1, World world_1)
    {
        super(entityType_1, world_1);
        this.setHealth(MAX_HEALTH);
    }

    @Override
    protected void initAttributes()
    {
        super.initAttributes();
        this.getAttributeContainer().get(EntityAttributes.MAX_HEALTH).setBaseValue(MAX_HEALTH);
        this.getAttributeContainer().get(EntityAttributes.KNOCKBACK_RESISTANCE).setBaseValue(100);
    }

    @Override
    public void tick()
    {
        super.tick();
        float health = this.getHealth();

        if(health > STAGE_2_HP)
        {
            tickStage1();
        }

        else if (health > STAGE_1_HP)
        {
            tickStage2();
        }

        else if (health <= STAGE_1_HP)
        {
            tickStage3();
        }
    }

    private void tickStage1()
    {
        // handle stomp first if we're in the process of doing it
        if(isStomping)
        {
            stompingTicks++;

            if(stompingTicks >= 100)
            {
                stompingTicks = 0;
                List<Entity> nearbyEntities = world.getEntities(
                        (Entity) null,
                        new BoundingBox(
                                new BlockPos(
                                        getPos().getX() - 8,
                                        getPos().getY() - 1,
                                        getPos().getZ() - 8
                                ),
                                new BlockPos(
                                        getPos().getX() + 8,
                                        getPos().getY() + 2,
                                        getPos().getZ() + 8
                                )
                        )
                );

                nearbyEntities.forEach(entity ->
                        entity.damage(DamageSource.MAGIC, 5));

                System.out.println("STOMP");
                isStomping = false;
            }
            
            else
            {
                for (double i = 0; i < (100d - (stompingTicks)) / 5; i++)
                {
                    world.addParticle(ParticleTypes.SMOKE, getPos().getX(), getPos().getY() + (i / 5d) + 3, getPos().getZ(), 0, 0, 0);
                }
            }

            return;
        }

        LivingEntity meleeTargetEntity = world.getClosestPlayer(this, 10);

        if(meleeTargetEntity != null)
        {
            ticksSinceLastMelee++;
            ticksSinceLastStomp++;

            // melee
            if(ticksSinceLastMelee >= 100)
            {
                double distanceToTarget = distanceTo(meleeTargetEntity);

                if(distanceToTarget <= 3)
                {
                    ticksSinceLastMelee = 0;
                    meleeTargetEntity.damage(DamageSource.MAGIC, 3);
                }
            }

            // stomp
            if(ticksSinceLastStomp >= 300)
            {
                double distanceToTarget = distanceTo(meleeTargetEntity);

                if(distanceToTarget <= 15)
                {
                    System.out.println("Starting stomp");

                    // reset stomp fields
                    isStomping = true;
                    stompingTicks = 0;
                    ticksSinceLastStomp = 0;
                }
            }
        }
    }

    private void tickStage2()
    {

    }

    private void tickStage3()
    {

    }
}
