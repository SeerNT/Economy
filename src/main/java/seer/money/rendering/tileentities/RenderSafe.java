package seer.money.rendering.tileentities;

import java.util.Calendar;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.google.common.base.Strings;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.seer.money.safe;

public class RenderSafe extends TileEntitySpecialRenderer{
	ResourceLocation texture = new ResourceLocation("money", "textures/blocks/Gray.png");
	ResourceLocation pr = new ResourceLocation("money", "textures/blocks/safe.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(pr);
	private static final ResourceLocation field_147505_d = new ResourceLocation("money", "textures/blocks/Gray.png");
    private static final ResourceLocation field_147504_g = new ResourceLocation("money", "textures/blocks/Gray.png");
    private IModelCustom field_147510_h = model;
    private boolean field_147509_j;
    private static final String __OBFID = "CL_00000965";

    public RenderSafe()
    {
        Calendar calendar = Calendar.getInstance();

        if (calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26)
        {
            this.field_147509_j = true;
        }
    }

    public void renderTileEntityAt(safeTileEntity p_147502_1_, double p_147502_2_, double p_147502_4_, double p_147502_6_, float p_147502_8_)
    {
    	int i;
        if (!p_147502_1_.hasWorldObj())
        {
            i = 0;
        }
        else
        {
            Block block = p_147502_1_.getBlockType();
            i = p_147502_1_.getBlockMetadata();
            if (block instanceof safe && i == 0)
            {
                try
                {
                ((safe)block).func_149954_e(p_147502_1_.getWorldObj(), p_147502_1_.xCoord, p_147502_1_.yCoord, p_147502_1_.zCoord);
                }
                catch (ClassCastException e)
                {
                    FMLLog.severe("Attempted to render a chest at %d,  %d, %d that was not a chest", p_147502_1_.xCoord, p_147502_1_.yCoord, p_147502_1_.zCoord);
                }
                i = p_147502_1_.getBlockMetadata();
            }

            p_147502_1_.checkForAdjacentChests();
        }

        if (p_147502_1_.adjacentChestZNeg == null && p_147502_1_.adjacentChestXNeg == null)
        {
        	IModelCustom modelchest;

            if (p_147502_1_.adjacentChestXPos == null && p_147502_1_.adjacentChestZPos == null)
            {
                modelchest = this.field_147510_h;

              
                    this.bindTexture(field_147504_g);
                
            }
            else
            {
            	modelchest = this.field_147510_h;

                
                this.bindTexture(field_147504_g);
                
            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }

            

            float f1 = p_147502_1_.prevLidAngle + (p_147502_1_.lidAngle - p_147502_1_.prevLidAngle) * p_147502_8_;
            float f2;

            if (p_147502_1_.adjacentChestZNeg != null)
            {
                f2 = p_147502_1_.adjacentChestZNeg.prevLidAngle + (p_147502_1_.adjacentChestZNeg.lidAngle - p_147502_1_.adjacentChestZNeg.prevLidAngle) * p_147502_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            if (p_147502_1_.adjacentChestXNeg != null)
            {
                f2 = p_147502_1_.adjacentChestXNeg.prevLidAngle + (p_147502_1_.adjacentChestXNeg.lidAngle - p_147502_1_.adjacentChestXNeg.prevLidAngle) * p_147502_8_;

                if (f2 > f1)
                {
                    f1 = f2;
                }
            }

            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            GL11.glTranslated(p_147502_2_ + 0.5, p_147502_4_ + 0.5, p_147502_6_ + 0.5);
            int rotationAngle = 0;
            GL11.glScalef(1.0F, -1F, -1F);
            switch (i) {
            case 3:
            	rotationAngle = 90;//done
            	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, 0.0F);
                break;
            case 4:
            	rotationAngle = 90;//done
            	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, -270.0F);
                break;
            case 2:
            	rotationAngle = 90;//done
            	GL11.glRotatef(rotationAngle*90, 0.0F, 1.0F, 90.0F);
                break;
            case 5:
            	rotationAngle = 90;//done
            	GL11.glRotated(rotationAngle*90, 270.0F, 1.0F, 270.0F);
                break;
            default:
                break;
            }
            modelchest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((safeTileEntity)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }
	
	
	/*
	 * 
	 * ResourceLocation texture = new ResourceLocation("money", "textures/blocks/Gray.png");
	ResourceLocation pr = new ResourceLocation("money", "textures/blocks/safe.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(pr);
	@Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
		int metadata = te.getBlockMetadata();
        
        bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}
	 */
}
