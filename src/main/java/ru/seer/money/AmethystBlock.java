package ru.seer.money;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AmethystBlock extends Block {
	private Blocks b;
	protected AmethystBlock() {
		super(Material.iron);
		this.setBlockName("AmethystBlock");
		this.setCreativeTab(Test.tabTutorial);
		this.setHardness(20F);
		this.setResistance(1F);
		this.setHarvestLevel("pickaxe",3);
		this.setBlockTextureName("money:AmethystBlock");
	}
}
