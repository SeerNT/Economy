package ru.seer.money;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy
{	public static Achievement  achievementFirstDollar;
	public static Achievement  achievementStart;
	public static Achievement achievementFirstPackOfDollars;
	public static Achievement achievementWallet;
	public static Achievement achievementCard;
	public static Achievement achievementPrinter;
	public static Achievement achievementRuby;
	public static Achievement achievementAmethyst;
	public static Achievement achievementFirstGoodTool;
	public static Achievement achievementCombatSet;
	public static Achievement achievementPairOfBows;
    public void preInit(FMLPreInitializationEvent event)
    {

    }
    public void registerRenderers()
    {
      // Здесь ничего, так как сервер не рендерит графику или существ!
    }
    public void init(FMLInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new EventsHandler());
    	achievementStart =  new Achievement("achievement.start", "start", 
    		      0, 0, Blocks.gold_block, (Achievement)null);
      	achievementFirstDollar =  new Achievement("achievement.firstdollar", "firstdollar", 
    		      2, 1, new ItemStack(Test.Dollars), achievementStart);
      	achievementFirstPackOfDollars =  new Achievement("achievement.firstpack", "firstpack", 
  		      4, 1, Test.PackOfDollars, achievementFirstDollar);
      	achievementWallet =  new Achievement("achievement.wallet", "wallet", 
    		      -2, 0, new ItemStack(Test.Wallet), achievementStart);
      	achievementCard =  new Achievement("achievement.card", "card", 
  		      -2, 2, new ItemStack(Test.Card), achievementWallet);
      	achievementPrinter =  new Achievement("achievement.printer", "printer", 
    		      -2, -2, Test.Printer,achievementWallet);
      	achievementAmethyst =  new Achievement("achievement.amethyst", "amethyst", 
    		      0, 2, Test.AmethystOre,achievementStart);	
      	achievementRuby =  new Achievement("achievement.ruby", "ruby", 
    		      0, 4, Test.RubyOre,achievementAmethyst);
      	achievementFirstGoodTool =  new Achievement("achievement.firstgoodtool", "goodtool", 
  		      2, 4, Test.RubyPickaxe,achievementRuby.setSpecial());
      	achievementCombatSet =  new Achievement("achievement.combatset", "combatset", 
    		      -2, 4, Test.RubySword,achievementRuby);
      	achievementPairOfBows =  new Achievement("achievement.pairofbows", "pairofbows", 
  		      -4, 4, Test.RubyBow,achievementCombatSet);
      	achievementPairOfBows.registerStat();
      	achievementCombatSet.registerStat();
      	achievementFirstGoodTool.registerStat();
    	achievementStart.registerStat(); 
    	achievementFirstDollar.registerStat(); 
    	achievementFirstPackOfDollars.registerStat();
    	achievementWallet.registerStat();
    	achievementCard.registerStat();
    	achievementPrinter.registerStat();
    	achievementRuby.registerStat();
    	achievementAmethyst.registerStat();
    	AchievementPage.registerAchievementPage(
    		      new AchievementPage("Economy Beginning", 
    		            new Achievement[] {achievementStart, achievementFirstDollar, achievementFirstPackOfDollars,
    		            		achievementWallet, achievementCard, achievementPrinter, achievementRuby, achievementAmethyst,
    		            		achievementFirstGoodTool,achievementCombatSet, achievementPairOfBows}));
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}