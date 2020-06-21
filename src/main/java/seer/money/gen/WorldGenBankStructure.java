package seer.money.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirectional;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.util.Direction;
import net.minecraft.util.Facing;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import ru.seer.money.Test;

public class WorldGenBankStructure extends WorldGenerator{
	Blocks b;
	public static BiomeGenBase biome_player;
	public static int x2;
	public static int z2;
    public boolean generate(World world, Random p_76484_2_, int x, int y, int z)
    {
    	biome_player = world.getBiomeGenForCoords(x, z);
    	
        for (int l = 0; l < 64; ++l)
        {
            int i1 = x + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
            int j1 = y + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
            int k1 = z + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);

            if (world.isAirBlock(i1, j1, k1) && world.getBlock(i1, j1 - 1, k1) == Blocks.grass && Blocks.pumpkin.canPlaceBlockAt(world, i1, j1, k1))
            {
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
        		world.setBlock(x + 6, y + 1, z, b.planks); 
        		world.setBlock(x + 6,y + 1, z + 1, b.planks);
        		world.setBlock(x + 6,y + 1, z + 2, b.planks);
        		world.setBlock(x + 6,y + 1, z + 3, b.planks);
        		world.setBlock(x + 6,y + 1, z + 4, b.planks);
        		world.setBlock(x + 6,y + 1, z + 5, b.planks);
        		world.setBlock(x + 6,y + 1, z + 6, b.planks);
        		world.setBlock(x + 6,y + 1, z + 7, b.planks);
        		world.setBlock(x + 6,y + 1, z + 8, b.planks);
        		
        		world.setBlock(x + 6,y + 2, z, b.planks); 
        		world.setBlock(x + 6,y + 2, z + 1, b.planks);
        		world.setBlock(x + 6,y + 2, z + 2, Test.ReinforcedGlass);
        		world.setBlock(x + 6,y + 2, z + 3, Test.ReinforcedGlass);
        		world.setBlock(x + 6,y + 2, z + 4, b.planks);
        		world.setBlock(x + 6,y + 2, z + 5, b.planks);
        		//world.setBlock(x + 6,y + 2, z + 6, b.planks);
        		//world.setBlock(x + 6,y + 2, z + 7, b.planks);
        		world.setBlock(x + 6,y + 2, z + 8, b.planks);
        		
        		world.setBlock(x + 6,y + 3, z, b.planks); 
        		world.setBlock(x + 6,y + 3, z + 1, b.planks);
        		world.setBlock(x + 6,y + 3, z + 2, b.planks);
        		world.setBlock(x + 6,y + 3, z + 3, b.planks);
        		world.setBlock(x + 6,y + 3, z + 4, b.planks);
        		world.setBlock(x + 6,y + 3, z + 5, b.planks);
        		world.setBlock(x + 6,y + 3, z + 6, b.planks);
        		world.setBlock(x + 6,y + 3, z + 7, b.planks);
        		world.setBlock(x + 6,y + 3, z + 8, b.planks);
        		
        		world.setBlock(x + 6,y + 4, z, b.planks); 
        		world.setBlock(x + 6,y + 4, z + 1, b.planks);
        		world.setBlock(x + 6,y + 4, z + 2, b.planks);
        		world.setBlock(x + 6,y + 4, z + 3, b.planks);
        		world.setBlock(x + 6,y + 4, z + 4, b.planks);
        		world.setBlock(x + 6,y + 4, z + 5, b.planks);
        		world.setBlock(x + 6,y + 4, z + 6, b.planks);
        		world.setBlock(x + 6,y + 4, z + 7, b.planks);
        		world.setBlock(x + 6,y + 4, z + 8, b.planks);
        		
        		world.setBlock(x + 6,y + 5, z, b.planks); 
        		world.setBlock(x + 6,y + 5, z + 1, b.planks);
        		world.setBlock(x + 6,y + 5, z + 2, b.planks);
        		world.setBlock(x + 6,y + 5, z + 3, b.planks);
        		world.setBlock(x + 6,y + 5, z + 4, b.planks);
        		world.setBlock(x + 6,y + 5, z + 5, b.planks);
        		world.setBlock(x + 6,y + 5, z + 6, b.planks);
        		world.setBlock(x + 6,y + 5, z + 7, b.planks);
        		world.setBlock(x + 6,y + 5, z + 8, b.planks);
        		
        		world.setBlock(x, y + 1, z, b.planks); 
        		world.setBlock(x, y + 1, z + 1, b.planks);
        		ItemDoor.placeDoorBlock(world, x, y + 1, z + 2,0, b.wooden_door);
        		ItemDoor.placeDoorBlock(world, x, y + 1, z + 3,0, b.wooden_door);
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
        		//world.setBlock(x + 9, y + 1, z + 2, );
        		ItemDoor.placeDoorBlock(world, x + 9, y + 1, z + 2,0, Test.ReinforcedDoor);
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
        		//world.setBlock(x + 9, y + 2, z + 2, b.planks);
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
        		world.setBlock(x + 7, y, z + 1, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 2, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 3, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 4, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 5, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 6, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 7, Test.ReinforcedBlock);
        		world.setBlock(x + 7, y, z + 8, b.planks);
        		
        		world.setBlock(x + 8, y, z, b.planks); 
        		world.setBlock(x + 8, y, z + 1, Test.ReinforcedBlock);
        		world.setBlock(x + 8, y, z + 2, Test.ReinforcedBlock);
        		world.setBlock(x + 8, y, z + 3, Test.ReinforcedBlock);
        		world.setBlock(x + 8, y, z + 4, Test.ReinforcedBlock);
        		world.setBlock(x + 8, y, z + 5, Test.ReinforcedBlock);
        		world.setBlock(x + 8, y, z + 6, Test.ReinforcedBlock);
        		world.setBlock(x + 8, y, z + 7, Test.ReinforcedBlock);
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
        		
        		//Крыша
        		world.setBlock(x + 1, y + 6, z, b.planks); 
        		world.setBlock(x + 1, y + 6, z + 1, b.planks);
        		world.setBlock(x + 1, y + 6, z + 2, b.planks);
        		world.setBlock(x + 1, y + 6, z + 3, b.planks);
        		world.setBlock(x + 1, y + 6, z + 4, b.planks);
        		world.setBlock(x + 1, y + 6, z + 5, b.planks);
        		world.setBlock(x + 1, y + 6, z + 6, b.planks);
        		world.setBlock(x + 1, y + 6, z + 7, b.planks);
        		world.setBlock(x + 1, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 2, y + 6, z, b.planks); 
        		world.setBlock(x + 2, y + 6, z + 1, b.planks);
        		world.setBlock(x + 2, y + 6, z + 2, b.planks);
        		world.setBlock(x + 2, y + 6, z + 3, b.planks);
        		world.setBlock(x + 2, y + 6, z + 4, b.planks);
        		world.setBlock(x + 2, y + 6, z + 5, b.planks);
        		world.setBlock(x + 2, y + 6, z + 6, b.planks);
        		world.setBlock(x + 2, y + 6, z + 7, b.planks);
        		world.setBlock(x + 2, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 3, y + 6, z, b.planks); 
        		world.setBlock(x + 3, y + 6, z + 1, b.planks);
        		world.setBlock(x + 3, y + 6, z + 2, b.planks);
        		world.setBlock(x + 3, y + 6, z + 3, b.planks);
        		world.setBlock(x + 3, y + 6, z + 4, b.planks);
        		world.setBlock(x + 3, y + 6, z + 5, b.planks);
        		world.setBlock(x + 3, y + 6, z + 6, b.planks);
        		world.setBlock(x + 3, y + 6, z + 7, b.planks);
        		world.setBlock(x + 3, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 4, y + 6, z, b.planks); 
        		world.setBlock(x + 4, y + 6, z + 1, b.planks);
        		world.setBlock(x + 4, y + 6, z + 2, b.planks);
        		world.setBlock(x + 4, y + 6, z + 3, b.planks);
        		world.setBlock(x + 4, y + 6, z + 4, b.planks);
        		world.setBlock(x + 4, y + 6, z + 5, b.planks);
        		world.setBlock(x + 4, y + 6, z + 6, b.planks);
        		world.setBlock(x + 4, y + 6, z + 7, b.planks);
        		world.setBlock(x + 4, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 5, y + 6, z, b.planks); 
        		world.setBlock(x + 5, y + 6, z + 1, b.planks);
        		world.setBlock(x + 5, y + 6, z + 2, b.planks);
        		world.setBlock(x + 5, y + 6, z + 3, b.planks);
        		world.setBlock(x + 5, y + 6, z + 4, b.planks);
        		world.setBlock(x + 5, y + 6, z + 5, b.planks);
        		world.setBlock(x + 5, y + 6, z + 6, b.planks);
        		world.setBlock(x + 5, y + 6, z + 7, b.planks);
        		world.setBlock(x + 5, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 6, y + 6, z, b.planks); 
        		world.setBlock(x + 6, y + 6, z + 1, b.planks);
        		world.setBlock(x + 6, y + 6, z + 2, b.planks);
        		world.setBlock(x + 6, y + 6, z + 3, b.planks);
        		world.setBlock(x + 6, y + 6, z + 4, b.planks);
        		world.setBlock(x + 6, y + 6, z + 5, b.planks);
        		world.setBlock(x + 6, y + 6, z + 6, b.planks);
        		world.setBlock(x + 6, y + 6, z + 7, b.planks);
        		world.setBlock(x + 6, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 7, y + 6, z, b.planks); 
        		world.setBlock(x + 7, y + 6, z + 1, b.planks);
        		world.setBlock(x + 7, y + 6, z + 2, b.planks);
        		world.setBlock(x + 7, y + 6, z + 3, b.planks);
        		world.setBlock(x + 7, y + 6, z + 4, b.planks);
        		world.setBlock(x + 7, y + 6, z + 5, b.planks);
        		world.setBlock(x + 7, y + 6, z + 6, b.planks);
        		world.setBlock(x + 7, y + 6, z + 7, b.planks);
        		world.setBlock(x + 7, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 8, y + 6, z, b.planks); 
        		world.setBlock(x + 8, y + 6, z + 1, b.planks);
        		world.setBlock(x + 8, y + 6, z + 2, b.planks);
        		world.setBlock(x + 8, y + 6, z + 3, b.planks);
        		world.setBlock(x + 8, y + 6, z + 4, b.planks);
        		world.setBlock(x + 8, y + 6, z + 5, b.planks);
        		world.setBlock(x + 8, y + 6, z + 6, b.planks);
        		world.setBlock(x + 8, y + 6, z + 7, b.planks);
        		world.setBlock(x + 8, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x + 9, y + 6, z, b.planks); 
        		world.setBlock(x + 9, y + 6, z + 1, b.planks);
        		world.setBlock(x + 9, y + 6, z + 2, b.planks);
        		world.setBlock(x + 9, y + 6, z + 3, b.planks);
        		world.setBlock(x + 9, y + 6, z + 4, b.planks);
        		world.setBlock(x + 9, y + 6, z + 5, b.planks);
        		world.setBlock(x + 9, y + 6, z + 6, b.planks);
        		world.setBlock(x + 9, y + 6, z + 7, b.planks);
        		world.setBlock(x + 9, y + 6, z + 8, b.planks);
        		
        		world.setBlock(x, y + 6, z, b.planks); 
        		world.setBlock(x, y + 6, z + 1, b.planks);
        		world.setBlock(x, y + 6, z + 2, b.planks);
        		world.setBlock(x, y + 6, z + 3, b.planks);
        		world.setBlock(x, y + 6, z + 4, b.planks);
        		world.setBlock(x, y + 6, z + 5, b.planks);
        		world.setBlock(x, y + 6, z + 6, b.planks);
        		world.setBlock(x, y + 6, z + 7, b.planks);
        		world.setBlock(x, y + 6, z + 8, b.planks);
            }
        }

        return true;
    }
}
