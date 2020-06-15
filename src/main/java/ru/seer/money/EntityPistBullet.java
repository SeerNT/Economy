package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRedstoneDiode;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityPistBullet extends EntityThrowable {


		    public EntityLivingBase shootingEntity;
		    public int canBePickedUp;

			public EntityPistBullet(World world)
		    {
		        super(world);
		    }

		    public EntityPistBullet(World world, EntityLivingBase entity)
		    {
		        super(world, entity);
		    }
		    public EntityPistBullet(World p_i1755_1_, EntityLivingBase p_i1755_2_, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_)
		    {
		        super(p_i1755_1_);
		        this.renderDistanceWeight = 10.0D;
		        this.shootingEntity = p_i1755_2_;

		        if (p_i1755_2_ instanceof EntityPlayer)
		        {
		            this.canBePickedUp = 1;
		        }

		        this.posY = p_i1755_2_.posY + (double)p_i1755_2_.getEyeHeight() - 0.10000000149011612D;
		        double d0 = p_i1755_3_.posX - p_i1755_2_.posX;
		        double d1 = p_i1755_3_.boundingBox.minY + (double)(p_i1755_3_.height / 3.0F) - this.posY;
		        double d2 = p_i1755_3_.posZ - p_i1755_2_.posZ;
		        double d3 = (double)MathHelper.sqrt_double(d0 * d0 + d2 * d2);

		        if (d3 >= 1.0E-7D)
		        {
		            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
		            float f3 = (float)(-(Math.atan2(d1, d3) * 180.0D / Math.PI));
		            double d4 = d0 / d3;
		            double d5 = d2 / d3;
		            this.setLocationAndAngles(p_i1755_2_.posX + d4, this.posY, p_i1755_2_.posZ + d5, f2, f3);
		            this.yOffset = 0.0F;
		            float f4 = (float)d3 * 0.2F;
		            this.setThrowableHeading(d0, d1 + (double)f4, d2, p_i1755_4_, p_i1755_5_);
		        }
		    }
		    private void explode(MovingObjectPosition movingObjectPosition)
		    {
		        int bx = (int)posX;
		        int by = (int)posY;
		        int bz = (int)posZ;
		        EntityPlayer player = worldObj.getClosestPlayerToEntity(this, 5);
		        MovingObjectPosition movingobjectposition = movingObjectPosition;
		        EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;
		        if (entitylivingbase != null) {
		        	entitylivingbase.attackEntityFrom(Test.bulletDamage1, 11.0f);
		        }
		        
		        setDead();
		    }
		    @Override
		    public void onUpdate()
		    {
		        super.onUpdate();
		        if (ticksExisted > 20) {
		        	setDead();
		        }
		    }

		    @Override
		    protected float getGravityVelocity()
		    {
		        return 0.005F;
		    }

		    @Override
		    public void onImpact(MovingObjectPosition movingObjectPosition)
		    {
		        explode(movingObjectPosition);
		    }

}
