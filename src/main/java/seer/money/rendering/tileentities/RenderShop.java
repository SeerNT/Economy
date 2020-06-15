package seer.money.rendering.tileentities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import ru.seer.money.ShopTileEntity;

public class RenderShop extends TileEntitySpecialRenderer{
	
	ResourceLocation texture = new ResourceLocation("money", "textures/blocks/Gray.png");
	ResourceLocation pr = new ResourceLocation("money", "textures/blocks/Shop.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(pr);
	public void RenderTileEntityShop(){

	}
	@Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
		int metadata = te.getBlockMetadata();
        int rotationAngle = 0;
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5, posY, posZ + 0.5);
        GL11.glScalef(1.0F, -1F, -1F);
        switch (metadata) {
        case 3:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, 0.0F);
            break;
        case 4:
        	rotationAngle = 90;
        	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, -270.0F);
            break;
        case 2:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 0.0F, 1.0F, 90.0F);
            break;
        case 5:
        	rotationAngle = 90;
        	GL11.glRotated(rotationAngle*90, 270.0F, 1.0F, 270.0F);
            break;
        default:
            break;
        }
        bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}
	
	
}