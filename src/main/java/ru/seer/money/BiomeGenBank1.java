package ru.seer.money;

import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenDesertWells;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import seer.money.gen.WorldGenBankStructure;

import java.util.Random;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBank1 extends BiomeGenBase{

	public BiomeGenBank1(int id){
		super(id);
		this.spawnableCreatureList.add(new SpawnListEntry(PoliceMan.class, 100, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(PoliceManGirl.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(PoliceMan.class, 100, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(PoliceManGirl.class, 100, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(PoliceManGunner.class, 80, 4, 4));
		this.spawnableCreatureList.add(new SpawnListEntry(PoliceManGirlGunner.class, 80, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(PoliceManGunner.class, 80, 4, 4));
		this.spawnableMonsterList.add(new SpawnListEntry(PoliceManGirlGunner.class, 80, 4, 4));

		this.spawnableCreatureList.remove(0);
		this.spawnableCreatureList.remove(1);
		this.spawnableCreatureList.remove(2);
		this.spawnableCreatureList.remove(3);
		this.spawnableMonsterList.remove(0);
		this.spawnableMonsterList.remove(1);
		this.spawnableMonsterList.remove(2);
		this.spawnableMonsterList.remove(3);
		this.spawnableMonsterList.remove(4);
		this.theBiomeDecorator.treesPerChunk = 5;
		this.theBiomeDecorator.grassPerChunk = 2;
		this.theBiomeDecorator.bigMushroomsPerChunk = 5;
		this.topBlock = Blocks.grass;
		
		
	}
	public void decorate(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_)
    {
        super.decorate(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
        if (p_76728_2_.nextInt(50) == 0)
        {
            int k = p_76728_3_ + p_76728_2_.nextInt(16) + 8;
            int l = p_76728_4_ + p_76728_2_.nextInt(16) + 8;
            WorldGenBankStructure worldgenbank= new WorldGenBankStructure();
            worldgenbank.generate(p_76728_1_, p_76728_2_, k, p_76728_1_.getHeightValue(k, l) + 1, l);
        }
    }
	
}