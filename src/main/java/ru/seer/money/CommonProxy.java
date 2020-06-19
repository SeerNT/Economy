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
	public static Achievement achievementBoom;
	public static Achievement achievementLuxury;
	public static Achievement achievementWorth;
	public static Achievement achievementShopping;
	public static Achievement achievementPrinterMan;
	public static Achievement achievementCashMachine;
	//Civilization
	public static Achievement achievementCiv;
	public static Achievement achievementPolice;
	public static Achievement achievementRob;
	public static Achievement achievementSucRob;
	public static Achievement achievementRich;
	public static Achievement achievementRevenge;
	
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
    	//Beginning
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
      	achievementShopping =  new Achievement("achievement.shop", "shop", 
  		      -4, -2, Test.Shop,achievementPrinter);
      	achievementAmethyst =  new Achievement("achievement.amethyst", "amethyst", 
    		      0, 2, Test.AmethystOre,achievementStart);	
      	achievementRuby =  new Achievement("achievement.ruby", "ruby", 
    		      0, 4, Test.RubyOre,achievementAmethyst);
      	achievementLuxury = new Achievement("achievement.luxury", "luxury", 
  		      0, 6, Test.OpalOre,achievementRuby);
      	achievementWorth = new Achievement("achievement.worth", "worth", 
    		      -2, 6, Test.OpalSword,achievementLuxury.setSpecial());
      	achievementFirstGoodTool =  new Achievement("achievement.firstgoodtool", "goodtool", 
  		      2, 4, Test.RubyPickaxe,achievementRuby.setSpecial());
      	achievementCombatSet =  new Achievement("achievement.combatset", "combatset", 
    		      -2, 4, Test.RubySword,achievementRuby);
      	achievementPairOfBows =  new Achievement("achievement.pairofbows", "pairofbows", 
  		      -4, 4, Test.RubyBow,achievementCombatSet);
      	achievementBoom =  new Achievement("achievement.boom", "boom", 
    		      -6, 4, Test.Explosive,achievementPairOfBows);
      	achievementPrinterMan =  new Achievement("achievement.printerman", "printerman", 
  		      0, -2, Test.MillionPackOfDollars,achievementPrinter);
      	achievementCashMachine =  new Achievement("achievement.cashmachine", "cashmachine", 
    		      2, -2, Test.Cash_Machine,achievementPrinterMan);
      	//Civilization
      	achievementCiv =  new Achievement("achievement.civ", "civ", 
  		      0, 0, Test.Dollars, (Achievement)null);
      	achievementPolice =  new Achievement("achievement.police", "police", 
    		      -2, 0, Test.Bat, achievementCiv);
      	achievementRob =  new Achievement("achievement.rob", "rob", 
  		      -4, 0, Test.Signalization_Button, achievementPolice);
      	achievementSucRob =  new Achievement("achievement.sucrob", "sucrob", 
    		      -6, 0, Test.ReadyBlock, achievementRob);
      	achievementRevenge =  new Achievement("achievement.revenge", "revenge", 
  		      -2, -2, Test.Blood, achievementPolice);
      	achievementRich =  new Achievement("achievement.rich", "rich", 
    		      0, 2, Blocks.diamond_block, achievementCiv);
      	//Registry
      	achievementPrinterMan.setSpecial();
      	achievementCiv.setSpecial();
      	achievementRevenge.setSpecial();
      	achievementRich.setSpecial();
      	achievementSucRob.setSpecial();
      	achievementCiv.registerStat();
      	achievementPrinterMan.registerStat();
      	achievementPolice.registerStat();
      	achievementRob.registerStat();
      	achievementSucRob.registerStat();
      	achievementRevenge.registerStat();
      	achievementRich.registerStat();
      	achievementCashMachine.registerStat();
      	achievementShopping.registerStat();
      	achievementWorth.registerStat();
      	achievementLuxury.registerStat();
      	achievementBoom.registerStat();
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
    	//Achievement Pages
    	AchievementPage.registerAchievementPage(
    		      new AchievementPage("Economy Beginning", 
    		            new Achievement[] {achievementStart, achievementFirstDollar, achievementFirstPackOfDollars,
    		            		achievementWallet, achievementCard, achievementPrinter, achievementRuby, achievementAmethyst,
    		            		achievementFirstGoodTool,achievementCombatSet, achievementPairOfBows, achievementBoom,
    		            		achievementLuxury,achievementWorth,achievementShopping,achievementPrinterMan,achievementCashMachine}));
    	AchievementPage.registerAchievementPage(
  		      new AchievementPage("Economy Civilization", 
  		            new Achievement[] {achievementCiv,achievementPolice, achievementRob, achievementSucRob,
  		            		achievementRich,achievementRevenge}));
    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}