package ru.seer.money;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import seer.money.rendering.tileentities.PrinterTileEntity;

public class PackOfDollars extends Block {

	protected PackOfDollars() {
		super(Material.cake);
		this.setBlockName("Pack Of Dollars");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(0.2F);
		this.setResistance(1F);
		this.setHarvestLevel("shovel",0);
		this.setBlockTextureName("money:PackOfDollars");
	}
	

}
