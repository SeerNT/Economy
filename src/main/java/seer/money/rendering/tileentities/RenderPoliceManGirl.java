package seer.money.rendering.tileentities;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderPoliceManGirl extends RenderBiped {
	private static final ResourceLocation textureLocation = new ResourceLocation("money:textures/entity/policemangirl.png");

	public RenderPoliceManGirl(ModelBiped model, float shadowSize)
	{
	  super(model, shadowSize);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
	  return textureLocation;
	}
}