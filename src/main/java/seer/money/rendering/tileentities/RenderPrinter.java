package seer.money.rendering.tileentities;

import org.apache.http.impl.client.ProxyClient;
import org.lwjgl.opengl.GL11;

//import com.sun.org.apache.xml.internal.serialize.Printer;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import net.minecraftforge.client.model.obj.WavefrontObject;
import ru.seer.money.ClientProxy;
import ru.seer.money.Test;
import seer.money.model.ModelTable;

public class RenderPrinter extends TileEntitySpecialRenderer{
	
	ResourceLocation texture = new ResourceLocation("money", "textures/blocks/Gray.png");
	ResourceLocation pr = new ResourceLocation("money", "textures/blocks/Printer.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(pr);
	public void RenderTileEntityPrinter(){

	}
	@Override
    public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ, float timeSinceLastTick) {
		
		int metadata = te.getBlockMetadata();
        int rotationAngle = 0;
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5, posY + 0.5, posZ + 0.5);
        GL11.glScalef(1.0F, -1F, -1F);
        switch (metadata) {
        case 3:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, 0.0F);
            break;
        case 0:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 270.0F, 1.0F, -270.0F);
            break;
        case 2:
        	rotationAngle = 90;//done
        	GL11.glRotatef(rotationAngle*90, 0.0F, 1.0F, 90.0F);
            break;
        case 1:
        	rotationAngle = 90;//done
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
