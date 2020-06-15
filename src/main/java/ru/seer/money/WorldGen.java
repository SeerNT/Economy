package ru.seer.money;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGen implements IWorldGenerator {
	private int i3;
	private int l3;
	private int l1;
	private Block underBlock;
	private Block upBlock;
	private Block leftXBlock;
	private Block leftZBlock;
	private Block rightXBlock;
	private Block rightZBlock;

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

	    generateOverworld(rand, chunkX, chunkZ, world);

	}

	private void generateOverworld(Random rand, int chunkX, int chunkZ, World world) {

	  generateOverworld(world, rand, chunkX * 16, chunkZ * 16);

	}

	public void generateOverworld(World world, Random rand, int blockXPos, int blockZPos) {

	  addOreSpawn(Test.BankStructure, Blocks.grass, world, rand, blockXPos, blockZPos, 16, 16, 1, 1, 1, 4, 30, 50, 70);

	}

	public static void addOreSpawn(Block ore, Block replace, World world, Random rand, int blockXPos, int blockZPos, int maxX, int maxZ,
			int minVeinSize, int maxVeinSize, int minVeinsPerChunk, int maxVeinsPerChunk, int chanceToSpawn, int minY, int maxY) {
			  if (rand.nextInt(101) < (100 - chanceToSpawn)) return;
			  int veins = rand.nextInt(maxVeinsPerChunk - minVeinsPerChunk + 1) + minVeinsPerChunk;
			  for (int i = 0; i < veins; i++) {
			    int posX = blockXPos + rand.nextInt(maxX);
			    int posY = minY + rand.nextInt(maxY - minY);
			    int posZ = blockZPos + rand.nextInt(maxZ);
			    (new WorldGenMinable(ore, minVeinSize + rand.nextInt(maxVeinSize - minVeinSize + 1),
			      replace)).generate(world, rand, posX, posY, posZ);
			  }
			}
}
