package ru.seer.money;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class AmethystOreGenerator implements IWorldGenerator {
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

	    generateOverworld(rand, chunkX, chunkZ, world);
	    generateNether(rand, chunkX, chunkZ, world);
	    generateEnd(rand, chunkX, chunkZ, world);

	}

	private void generateOverworld(Random rand, int chunkX, int chunkZ, World world) {

	  generateOverworld(world, rand, chunkX * 16, chunkZ * 16);

	}

	private void generateNether(Random rand, int chunkX, int chunkZ, World world) {

	  generateNether(world, rand, chunkX * 16, chunkZ * 16);

	}

	private void generateEnd(Random rand, int chunkX, int chunkZ, World world) {

	  generateEnd(world, rand, chunkX * 16, chunkZ * 16);

	}

	public void generateOverworld(World world, Random rand, int blockXPos, int blockZPos) {

	  addOreSpawn(Test.AmethystOre, Blocks.stone, world, rand, blockXPos, blockZPos, 16, 16, 1, 4, 8, 22, 42, 15, 30);

	}

	public void generateNether(World world, Random rand, int blockXPos, int blockZPos) {

	  addOreSpawn(Test.AmethystOre, Blocks.netherrack, world, rand, blockXPos, blockZPos, 16, 16, 1, 2, 1, 1, 10, 5, 6);

	}

	public void generateEnd(World world, Random rand, int blockXPos, int blockZPos) {

	   addOreSpawn(Test.AmethystOre, Blocks.end_stone, world, rand, blockXPos, blockZPos, 16, 16, 1, 4, 1, 8, 7, 15, 30);

	}

	/**
	  * ��������� ��������� ���� � Minecraft. ������ �������������� ���� ������� ��� ����������� ������������ ���.

	  * @param block              ����, ������� ������ ������������
	  * @param block replace      ����, ����� � ������� ������ ������������
	  * @param world              ��� (�� ���������), � ������� ���� ���� ������ ��������������
	  * @param random             ��������� ����� ��� ��������� ��������� ��������� �����
	  * @param blockXPos          ����� ��� ����, ����� ���� ������ ����� �� ����������� X ��� ������ ��������� (���������� ��������� ����)
	  * @param blockZPos          ����� ��� ����, ����� ���� ������ ����� �� ����������� Z ��� ������ ��������� (���������� ��������� ����)
	  * @param maxX               �����, ������� �������� ������������ X ���������� ��� ��������� ���� �� ��� X �� ����
	  * @param maxZ               �����, ������� �������� ������������ Z ���������� ��� ��������� ���� �� ��� Z �� ����
	  * @param minVeinSize        ����������� ����� ������ ���� � ����� ����
	  * @param maxVeinSize        ������������ ����� ������ ���� � ����� ����
	  * @param minVeinsPerChunk   ����������� ����� ��� � �����
	  * @param maxVeinsPerChunk   ������������ ����� ��� � �����
	  * @param chancesToSpawn     ���� ��������� ������ �� ���� � ���������
	  * @param minY               ����������� ���������� Y �� ������� ���� ����� ���������������
	  * @param maxY               ������������ ���������� Y �� ������� ���� ����� ���������������
	**/

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
