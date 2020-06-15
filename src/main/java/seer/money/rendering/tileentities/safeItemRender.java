package seer.money.rendering.tileentities;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class safeItemRender implements IItemRenderer {
	protected ResourceLocation blockTexture;
	TileEntitySpecialRenderer render;
	private TileEntity entity;
	ResourceLocation texture = new ResourceLocation("money", "textures/blocks/Gray.png");
	ResourceLocation pr = new ResourceLocation("money", "textures/blocks/safe.obj");
	IModelCustom model = AdvancedModelLoader.loadModel(pr);
	
	private ModelChest chestModel;

	public safeItemRender() {
		blockTexture = texture;
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
		case ENTITY:
		case INVENTORY:
			return true;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		switch (type) {
		case ENTITY: {
			return false;
		}
		case EQUIPPED: {
			return false;
		}
		case EQUIPPED_FIRST_PERSON: {
			return false;
		}
		case INVENTORY:// this case statement is required to get an inventory texture
		{
			return helper == ItemRendererHelper.INVENTORY_BLOCK;
		}
		default: {
			return false;
		}
		}	
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		//TileEntityRendererDispatcher.instance.renderTileEntityAt(new safeTileEntity(), 0.0D, 0.0D, 0.0D, 0.0F);
		switch (type) {
		case EQUIPPED:
		case EQUIPPED_FIRST_PERSON:
			GL11.glPushMatrix();
			// rotates the item
			GL11.glRotatef(8100, 270.0F, 1.0F, -270.0F);
			//GL11.glRotatef(0, 0, 1, 0);
			//GL11.glRotatef(0, 1, 0, 0);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(this.blockTexture);
			// renders the item
			model.renderAll();
			GL11.glPopMatrix();

		default:
			break;
		// Renders the Campfire on ground as a pickable item
		}
		switch (type) {
		case ENTITY:

			GL11.glPushMatrix();
			// rotates the item and translates the item
			GL11.glRotatef(0, 0, 0, 1);
			//GL11.glRotatef(45, 0, 1, 0);
			GL11.glRotatef(10, 1, 0, 0);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(this.blockTexture);
			// renders the item
			model.renderAll();
			GL11.glPopMatrix();
		default:
			break;
		}
		switch (type) {
		case INVENTORY:

			GL11.glPushMatrix();
			// rotates the item and translates the item
			GL11.glRotatef(0, 0, 0, 1);
			//GL11.glRotatef(45, 0, 1, 0);
			GL11.glRotatef(10, 1, 0, 0);
			Minecraft.getMinecraft().renderEngine
					.bindTexture(this.blockTexture);
			// renders the item
			model.renderAll();
			GL11.glPopMatrix();
		default:
			break;
		}
	}

}