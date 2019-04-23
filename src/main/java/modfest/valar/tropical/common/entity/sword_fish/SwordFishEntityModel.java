package modfest.valar.tropical.common.entity.sword_fish;

import net.minecraft.client.model.Cuboid;
import net.minecraft.client.render.entity.model.EntityModel;

public class SwordFishEntityModel extends EntityModel<SwordFishEntity>
{
    private final Cuboid bone;
    private final Cuboid back;
    private final Cuboid bottomfin;
    private final Cuboid tail;
    private final Cuboid backfin;
    private final Cuboid front;
    private final Cuboid topfin;


    private float tailRotation = 0;
    private boolean tailDirection = true;

    public SwordFishEntityModel() {
        textureWidth = 48;
        textureHeight = 48;

        bone = new Cuboid(this);
        bone.setRotationPoint(0.0F, 24.0F, 0.0F);
        bone.y = -.7f;

        back = new Cuboid(this, 24, 0);
        back.setRotationPoint(0.0F, -5.0F, 2.0F);
        bone.addChild(back);
        back.addBox(-2, -2, 0, 3, 3, 6);

        bottomfin = new Cuboid(this, 8, 26);
        bottomfin.setRotationPoint(0.0F, 1.0F, 1.5F);
        back.addChild(bottomfin);
        bottomfin.addBox(-1, 0, -.5f, 1, 2, 1);
        bottomfin.setTextureOffset(16, 26);
        bottomfin.addBox(-1, 2, 0, 1, 1, 1);

        tail = new Cuboid(this, 10, 18);
        tail.setRotationPoint(0.0F, 0.0F, 6.0F);
        back.addChild(tail);
        tail.addBox(-1.5f, -1.25f, 0, 2, 2, 2);
        tail.setTextureOffset(14, 12);
        tail.addBox(-1.25f, -1.5f, 2, 1, 2, 4);
                

        backfin = new Cuboid(this, 0, 22);
        backfin.setRotationPoint(0.0F, 0.0F, 6.0F);
        tail.addChild(backfin);
        backfin.addBox(-1.0F, -1.75F, 0.0F, 1, 1, 2);
        backfin.setTextureOffset(4, 29);
        backfin.addBox(-1.0F, -0.75F, 0.0F, 1, 1, 1);
        backfin.setTextureOffset(24, 18);
        backfin.addBox(-1.0F, 0.25F, 0.0F, 1, 1, 2);
        backfin.setTextureOffset(0, 26);
        backfin.addBox(-1.0F, 2.25F, 2.0F, 1, 2, 1);
        backfin.setTextureOffset(12, 26);
        backfin.addBox(-1.0F, 1.25F, 1.0F, 1, 2, 1);
        backfin.setTextureOffset(16, 22);
        backfin.addBox(-1.0F, -3.75F, 1.0F, 1, 2, 1);
        backfin.setTextureOffset(12, 22);
        backfin.addBox(-1.0F, -5.75F, 2.0F, 1, 3, 1);
        

        front = new Cuboid(this, 4, 26);
        front.setRotationPoint(0.0F, -5.0F, 2.0F);
        bone.addChild(front);
        front.addBox(-3, 0, -6, 1, 2, 1);
        front.setTextureOffset(0, 12);
        front.addBox(-2, -1.75f, -13, 3, 1, 4);
        front.setTextureOffset(0, 0);
        front.addBox(-2, -2, -9, 3, 3, 9);
        front.setTextureOffset(24, 12);
        front.addBox(-1, -1.75f, -17, 1, 1, 4);
        front.setTextureOffset(0, 18);
        front.addBox(-2, -.75f, -11, 3, 1, 2);
        front.setTextureOffset(20, 22);
        front.addBox(1, 0, -6, 1, 2, 1);
        front.setTextureOffset(20, 26);
        front.addBox(1, 2, -5.5f, 1, 1, 1);
        front.setTextureOffset(0, 29);
        front.addBox(-3, 2, -5.5f, 1, 1, 1);


        topfin = new Cuboid(this, 18, 18);
        topfin.setRotationPoint(0.0F, -2.0F, -6.0F);
        front.addChild(topfin);
        topfin.addBox(-1, -2, -1, 1, 2, 2);
        topfin.setTextureOffset(6, 22);
        topfin.addBox(-1, -3, 0, 1, 1, 2);
        topfin.setTextureOffset(8, 29);
        topfin.addBox(-1, -4, 1, 1, 1, 1);
    }

    @Override
    public void render(SwordFishEntity entity_1, float float_1, float float_2, float float_3, float float_4, float float_5, float float_6)
    {
        tail.yaw = tailRotation;

        // back tail
        if(tailDirection)
        {
            tailRotation += 0.01;
            if(tailRotation > .4) tailDirection = false;
        }

        else
        {
            tailRotation -= 0.01;
            if(tailRotation < -.4) tailDirection = true;
        }


        bone.render(.1f);
    }
}
