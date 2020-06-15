package ru.seer.money;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BankStructure extends Block
{
	Blocks b;

	public BankStructure(Material material)
	{
			super(material);
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
	{
		//Super
		super.onBlockPlacedBy(world, x, y, z, entity, itemstack);

		//Sets the block to air on the x, y, and z coords from where you placed the block
		world.setBlockToAir(x, y, z);

		//Sets the block on the x, y, and z coords starting from where you placed the block

		//Sets the block(with set metadata) on the x, y, and z coords from where you placed the block
		world.setBlock(x, y, z, b.planks); 
		world.setBlock(x, y, z + 1, b.planks);
		world.setBlock(x, y, z + 2, b.planks);
		world.setBlock(x, y, z + 3, b.planks);
		world.setBlock(x, y, z + 4, b.planks);
		world.setBlock(x, y, z + 5, b.planks);
		world.setBlock(x, y, z + 6, b.planks);
		world.setBlock(x, y, z + 7, b.planks);
		world.setBlock(x, y, z + 8, b.planks);
		// Cтенки
		world.setBlock(x, y + 1, z, b.planks); 
		world.setBlock(x, y + 1, z + 1, b.planks);
		//world.setBlock(x, y + 1, z + 2, b.wooden_door);
		//world.setBlock(x, y + 1, z + 3, b.wooden_door);
		world.setBlock(x, y + 1, z + 4, b.planks);
		world.setBlock(x, y + 1, z + 5, b.planks);
		world.setBlock(x, y + 1, z + 6, b.planks);
		world.setBlock(x, y + 1, z + 7, b.planks);
		world.setBlock(x, y + 1, z + 8, b.planks);
		
		world.setBlock(x + 1, y + 1, z + 8, b.planks);
		world.setBlock(x + 2, y + 1, z + 8, b.planks);
		world.setBlock(x + 3, y + 1, z + 8, b.planks);
		world.setBlock(x + 4, y + 1, z + 8, b.planks);
		world.setBlock(x + 5, y + 1, z + 8, b.planks);
		world.setBlock(x + 6, y + 1, z + 8, b.planks);
		world.setBlock(x + 7, y + 1, z + 8, b.planks);
		world.setBlock(x + 8, y + 1, z + 8, b.planks);
		world.setBlock(x + 9, y + 1, z + 8, b.planks);
		
		world.setBlock(x + 9, y + 1, z + 8, b.planks);
		world.setBlock(x + 9, y + 1, z + 7, b.planks);
		world.setBlock(x + 9, y + 1, z + 6, b.planks);
		world.setBlock(x + 9, y + 1, z + 5, b.planks);
		world.setBlock(x + 9, y + 1, z + 4, b.planks);
		world.setBlock(x + 9, y + 1, z + 3, b.planks);
		world.setBlock(x + 9, y + 1, z + 2, b.planks);
		world.setBlock(x + 9, y + 1, z + 1, b.planks);
		world.setBlock(x + 9, y + 1, z, b.planks);
		
		world.setBlock(x + 9, y + 1, z, b.planks);
		world.setBlock(x + 8, y + 1, z, b.planks);
		world.setBlock(x + 7, y + 1, z, b.planks);
		world.setBlock(x + 6, y + 1, z, b.planks);
		world.setBlock(x + 5, y + 1, z, b.planks);
		world.setBlock(x + 4, y + 1, z, b.planks);
		world.setBlock(x + 3, y + 1, z, b.planks);
		world.setBlock(x + 2, y + 1, z, b.planks);
		world.setBlock(x + 1, y + 1, z, b.planks);
		
		
		world.setBlock(x, y + 2, z, b.planks); 
		world.setBlock(x, y + 2, z + 1, b.planks);
		//world.setBlock(x, y + 2, z + 2, b.planks);
		//world.setBlock(x, y + 2, z + 3, b.planks);
		world.setBlock(x, y + 2, z + 4, b.planks);
		world.setBlock(x, y + 2, z + 5, b.planks);
		world.setBlock(x, y + 2, z + 6, b.planks);
		world.setBlock(x, y + 2, z + 7, b.planks);
		world.setBlock(x, y + 2, z + 8, b.planks);
	
		world.setBlock(x + 1, y + 2, z + 8, b.planks);
		world.setBlock(x + 2, y + 2, z + 8, b.planks);
		world.setBlock(x + 3, y + 2, z + 8, b.planks);
		world.setBlock(x + 4, y + 2, z + 8, b.planks);
		world.setBlock(x + 5, y + 2, z + 8, b.planks);
		world.setBlock(x + 6, y + 2, z + 8, b.planks);
		world.setBlock(x + 7, y + 2, z + 8, b.planks);
		world.setBlock(x + 8, y + 2, z + 8, b.planks);
		world.setBlock(x + 9, y + 2, z + 8, b.planks);
		
		world.setBlock(x + 9, y + 2, z + 8, b.planks);
		world.setBlock(x + 9, y + 2, z + 7, b.planks);
		world.setBlock(x + 9, y + 2, z + 6, b.planks);
		world.setBlock(x + 9, y + 2, z + 5, b.planks);
		world.setBlock(x + 9, y + 2, z + 4, b.planks);
		world.setBlock(x + 9, y + 2, z + 3, b.planks);
		world.setBlock(x + 9, y + 2, z + 2, b.planks);
		world.setBlock(x + 9, y + 2, z + 1, b.planks);
		world.setBlock(x + 9, y + 2, z, b.planks);
		
		world.setBlock(x + 9, y + 2, z, b.planks);
		world.setBlock(x + 8, y + 2, z, b.planks);
		world.setBlock(x + 7, y + 2, z, b.planks);
		world.setBlock(x + 6, y + 2, z, b.planks);
		world.setBlock(x + 5, y + 2, z, b.planks);
		world.setBlock(x + 4, y + 2, z, b.planks);
		world.setBlock(x + 3, y + 2, z, b.planks);
		world.setBlock(x + 2, y + 2, z, b.planks);
		world.setBlock(x + 1, y + 2, z, b.planks);
		
		
		world.setBlock(x, y + 3, z, b.planks); 
		world.setBlock(x, y + 3, z + 1, b.planks);
		world.setBlock(x, y + 3, z + 2, b.planks);
		world.setBlock(x, y + 3, z + 3, b.planks);
		world.setBlock(x, y + 3, z + 4, b.planks);
		world.setBlock(x, y + 3, z + 5, b.planks);
		world.setBlock(x, y + 3, z + 6, b.planks);
		world.setBlock(x, y + 3, z + 7, b.planks);
		world.setBlock(x, y + 3, z + 8, b.planks);
		
		world.setBlock(x + 1, y + 3, z + 8, b.planks);
		world.setBlock(x + 2, y + 3, z + 8, b.planks);
		world.setBlock(x + 3, y + 3, z + 8, b.planks);
		world.setBlock(x + 4, y + 3, z + 8, b.planks);
		world.setBlock(x + 5, y + 3, z + 8, b.planks);
		world.setBlock(x + 6, y + 3, z + 8, b.planks);
		world.setBlock(x + 7, y + 3, z + 8, b.planks);
		world.setBlock(x + 8, y + 3, z + 8, b.planks);
		world.setBlock(x + 9, y + 3, z + 8, b.planks);
		
		world.setBlock(x + 9, y + 3, z + 8, b.planks);
		world.setBlock(x + 9, y + 3, z + 7, b.planks);
		world.setBlock(x + 9, y + 3, z + 6, b.planks);
		world.setBlock(x + 9, y + 3, z + 5, b.planks);
		world.setBlock(x + 9, y + 3, z + 4, b.planks);
		world.setBlock(x + 9, y + 3, z + 3, b.planks);
		world.setBlock(x + 9, y + 3, z + 2, b.planks);
		world.setBlock(x + 9, y + 3, z + 1, b.planks);
		world.setBlock(x + 9, y + 3, z, b.planks);
		
		world.setBlock(x + 9, y + 3, z, b.planks);
		world.setBlock(x + 8, y + 3, z, b.planks);
		world.setBlock(x + 7, y + 3, z, b.planks);
		world.setBlock(x + 6, y + 3, z, b.planks);
		world.setBlock(x + 5, y + 3, z, b.planks);
		world.setBlock(x + 4, y + 3, z, b.planks);
		world.setBlock(x + 3, y + 3, z, b.planks);
		world.setBlock(x + 2, y + 3, z, b.planks);
		world.setBlock(x + 1, y + 3, z, b.planks);
		
		world.setBlock(x, y + 4, z, b.planks); 
		world.setBlock(x, y + 4, z + 1, b.planks);
		world.setBlock(x, y + 4, z + 2, Test.ReinforcedGlass);
		world.setBlock(x, y + 4, z + 3, Test.ReinforcedGlass);
		world.setBlock(x, y + 4, z + 4, b.planks);
		world.setBlock(x, y + 4, z + 5, b.planks);
		world.setBlock(x, y + 4, z + 6, b.planks);
		world.setBlock(x, y + 4, z + 7, b.planks);
		world.setBlock(x, y + 4, z + 8, b.planks);
		
		world.setBlock(x + 1, y + 4, z + 8, b.planks);
		world.setBlock(x + 2, y + 4, z + 8, b.planks);
		world.setBlock(x + 3, y + 4, z + 8, b.planks);
		world.setBlock(x + 4, y + 4, z + 8, b.planks);
		world.setBlock(x + 5, y + 4, z + 8, b.planks);
		world.setBlock(x + 6, y + 4, z + 8, b.planks);
		world.setBlock(x + 7, y + 4, z + 8, b.planks);
		world.setBlock(x + 8, y + 4, z + 8, b.planks);
		world.setBlock(x + 9, y + 4, z + 8, b.planks);
		
		world.setBlock(x + 9, y + 4, z + 8, b.planks);
		world.setBlock(x + 9, y + 4, z + 7, b.planks);
		world.setBlock(x + 9, y + 4, z + 6, b.planks);
		world.setBlock(x + 9, y + 4, z + 5, b.planks);
		world.setBlock(x + 9, y + 4, z + 4, b.planks);
		world.setBlock(x + 9, y + 4, z + 3, b.planks);
		world.setBlock(x + 9, y + 4, z + 2, b.planks);
		world.setBlock(x + 9, y + 4, z + 1, b.planks);
		world.setBlock(x + 9, y + 4, z, b.planks);
		
		world.setBlock(x + 9, y + 4, z, b.planks);
		world.setBlock(x + 8, y + 4, z, b.planks);
		world.setBlock(x + 7, y + 4, z, b.planks);
		world.setBlock(x + 6, y + 4, z, b.planks);
		world.setBlock(x + 5, y + 4, z, b.planks);
		world.setBlock(x + 4, y + 4, z, b.planks);
		world.setBlock(x + 3, y + 4, z, b.planks);
		world.setBlock(x + 2, y + 4, z, b.planks);
		world.setBlock(x + 1, y + 4, z, b.planks);
		
		
		world.setBlock(x, y + 5, z, b.planks); 
		world.setBlock(x, y + 5, z + 1, b.planks);
		world.setBlock(x, y + 5, z + 2, b.planks);
		world.setBlock(x, y + 5, z + 3, b.planks);
		world.setBlock(x, y + 5, z + 4, b.planks);
		world.setBlock(x, y + 5, z + 5, b.planks);
		world.setBlock(x, y + 5, z + 6, b.planks);
		world.setBlock(x, y + 5, z + 7, b.planks);
		world.setBlock(x, y + 5, z + 8, b.planks);
		
		world.setBlock(x + 1, y + 5, z + 8, b.planks);
		world.setBlock(x + 2, y + 5, z + 8, b.planks);
		world.setBlock(x + 3, y + 5, z + 8, b.planks);
		world.setBlock(x + 4, y + 5, z + 8, b.planks);
		world.setBlock(x + 5, y + 5, z + 8, b.planks);
		world.setBlock(x + 6, y + 5, z + 8, b.planks);
		world.setBlock(x + 7, y + 5, z + 8, b.planks);
		world.setBlock(x + 8, y + 5, z + 8, b.planks);
		world.setBlock(x + 9, y + 5, z + 8, b.planks);
		
		world.setBlock(x + 9, y + 5, z + 8, b.planks);
		world.setBlock(x + 9, y + 5, z + 7, b.planks);
		world.setBlock(x + 9, y + 5, z + 6, b.planks);
		world.setBlock(x + 9, y + 5, z + 5, b.planks);
		world.setBlock(x + 9, y + 5, z + 4, b.planks);
		world.setBlock(x + 9, y + 5, z + 3, b.planks);
		world.setBlock(x + 9, y + 5, z + 2, b.planks);
		world.setBlock(x + 9, y + 5, z + 1, b.planks);
		world.setBlock(x + 9, y + 5, z, b.planks);
		
		world.setBlock(x + 9, y + 5, z, b.planks);
		world.setBlock(x + 8, y + 5, z, b.planks);
		world.setBlock(x + 7, y + 5, z, b.planks);
		world.setBlock(x + 6, y + 5, z, b.planks);
		world.setBlock(x + 5, y + 5, z, b.planks);
		world.setBlock(x + 4, y + 5, z, b.planks);
		world.setBlock(x + 3, y + 5, z, b.planks);
		world.setBlock(x + 2, y + 5, z, b.planks);
		world.setBlock(x + 1, y + 5, z, b.planks);
		// Пол
		world.setBlock(x + 1, y, z, b.planks); 
		world.setBlock(x + 1, y, z + 1, b.planks);
		world.setBlock(x + 1, y, z + 2, b.planks);
		world.setBlock(x + 1, y, z + 3, b.planks);
		world.setBlock(x + 1, y, z + 4, b.planks);
		world.setBlock(x + 1, y, z + 5, b.planks);
		world.setBlock(x + 1, y, z + 6, b.planks);
		world.setBlock(x + 1, y, z + 7, b.planks);
		world.setBlock(x + 1, y, z + 8, b.planks);
		
		world.setBlock(x + 2, y, z, b.planks); 
		world.setBlock(x + 2, y, z + 1, b.planks);
		world.setBlock(x + 2, y, z + 2, b.planks);
		world.setBlock(x + 2, y, z + 3, b.planks);
		world.setBlock(x + 2, y, z + 4, b.planks);
		world.setBlock(x + 2, y, z + 5, b.planks);
		world.setBlock(x + 2, y, z + 6, b.planks);
		world.setBlock(x + 2, y, z + 7, b.planks);
		world.setBlock(x + 2, y, z + 8, b.planks);
		
		world.setBlock(x + 3, y, z, b.planks); 
		world.setBlock(x + 3, y, z + 1, b.planks);
		world.setBlock(x + 3, y, z + 2, b.planks);
		world.setBlock(x + 3, y, z + 3, b.planks);
		world.setBlock(x + 3, y, z + 4, b.planks);
		world.setBlock(x + 3, y, z + 5, b.planks);
		world.setBlock(x + 3, y, z + 6, b.planks);
		world.setBlock(x + 3, y, z + 7, b.planks);
		world.setBlock(x + 3, y, z + 8, b.planks);
		
		world.setBlock(x + 4, y, z, b.planks); 
		world.setBlock(x + 4, y, z + 1, b.planks);
		world.setBlock(x + 4, y, z + 2, b.planks);
		world.setBlock(x + 4, y, z + 3, b.planks);
		world.setBlock(x + 4, y, z + 4, b.planks);
		world.setBlock(x + 4, y, z + 5, b.planks);
		world.setBlock(x + 4, y, z + 6, b.planks);
		world.setBlock(x + 4, y, z + 7, b.planks);
		world.setBlock(x + 4, y, z + 8, b.planks);
		
		world.setBlock(x + 5, y, z, b.planks); 
		world.setBlock(x + 5, y, z + 1, b.planks);
		world.setBlock(x + 5, y, z + 2, b.planks);
		world.setBlock(x + 5, y, z + 3, b.planks);
		world.setBlock(x + 5, y, z + 4, b.planks);
		world.setBlock(x + 5, y, z + 5, b.planks);
		world.setBlock(x + 5, y, z + 6, b.planks);
		world.setBlock(x + 5, y, z + 7, b.planks);
		world.setBlock(x + 5, y, z + 8, b.planks);
		
		world.setBlock(x + 6, y, z, b.planks); 
		world.setBlock(x + 6, y, z + 1, b.planks);
		world.setBlock(x + 6, y, z + 2, b.planks);
		world.setBlock(x + 6, y, z + 3, b.planks);
		world.setBlock(x + 6, y, z + 4, b.planks);
		world.setBlock(x + 6, y, z + 5, b.planks);
		world.setBlock(x + 6, y, z + 6, b.planks);
		world.setBlock(x + 6, y, z + 7, b.planks);
		world.setBlock(x + 6, y, z + 8, b.planks);
		
		world.setBlock(x + 7, y, z, b.planks); 
		world.setBlock(x + 7, y, z + 1, b.planks);
		world.setBlock(x + 7, y, z + 2, b.planks);
		world.setBlock(x + 7, y, z + 3, b.planks);
		world.setBlock(x + 7, y, z + 4, b.planks);
		world.setBlock(x + 7, y, z + 5, b.planks);
		world.setBlock(x + 7, y, z + 6, b.planks);
		world.setBlock(x + 7, y, z + 7, b.planks);
		world.setBlock(x + 7, y, z + 8, b.planks);
		
		world.setBlock(x + 8, y, z, b.planks); 
		world.setBlock(x + 8, y, z + 1, b.planks);
		world.setBlock(x + 8, y, z + 2, b.planks);
		world.setBlock(x + 8, y, z + 3, b.planks);
		world.setBlock(x + 8, y, z + 4, b.planks);
		world.setBlock(x + 8, y, z + 5, b.planks);
		world.setBlock(x + 8, y, z + 6, b.planks);
		world.setBlock(x + 8, y, z + 7, b.planks);
		world.setBlock(x + 8, y, z + 8, b.planks);
		
		world.setBlock(x + 9, y, z, b.planks); 
		world.setBlock(x + 9, y, z + 1, b.planks);
		world.setBlock(x + 9, y, z + 2, b.planks);
		world.setBlock(x + 9, y, z + 3, b.planks);
		world.setBlock(x + 9, y, z + 4, b.planks);
		world.setBlock(x + 9, y, z + 5, b.planks);
		world.setBlock(x + 9, y, z + 6, b.planks);
		world.setBlock(x + 9, y, z + 7, b.planks);
		world.setBlock(x + 9, y, z + 8, b.planks);
	}
}