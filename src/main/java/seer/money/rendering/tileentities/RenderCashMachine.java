package seer.money.rendering.tileentities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.seer.money.Cash_Machine;
import ru.seer.money.ShopTileEntity;
import seer.money.rendering.tileentities.Cash_MachineTileEntity;

public class RenderCashMachine extends TileEntitySpecialRenderer{
	
	ResourceLocation texture = new ResourceLocation("money", "textures/blocks/monitor.png");
	ResourceLocation pr = new ResourceLocation("money", "textures/blocks/cashier.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(pr);	

	public void renderAModelAt(Cash_MachineTileEntity par1EntityGrinder, double par2, double par4, double par6, float par8) {
        
		
       }
	@Override
	public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_,
			float p_147500_8_) {
		int metadata = p_147500_1_.getBlockMetadata();
        int rotationAngle = 0;
        
        GL11.glPushMatrix();
        GL11.glTranslated((float)p_147500_2_ + 0.5F, (float)p_147500_4_ + 0.5f, (float)p_147500_6_ + 0.5F);
        GL11.glScalef(1.0F, -1F, -1F);
        switch (metadata) {
        case 2:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, 0.0F);
            break;
        case 5:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, -270.0F);
            break;
        case 3:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 0.0F, 1.0F, 90.0F);
            break;
        case 4:
        	rotationAngle = 90;//done
        	GL11.glRotated(rotationAngle*90, 270.0F, 1.0F, 270.0F);
            break;
        default:
            break;
        }

        this.bindTexture(texture);
        this.model.renderAll();
        GL11.glPopMatrix();
		
	}

	
}
