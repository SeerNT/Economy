package ru.seer.money;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemSlab;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import seer.money.armor.AmethystArmor;
import seer.money.armor.OpalArmor;
import seer.money.armor.RubyArmor;
import seer.money.armor.SapphireArmor;
import seer.money.guihandlers.TMGuiHandler;
import seer.money.rendering.tileentities.AmethystArrow;
import seer.money.rendering.tileentities.Cash_MachineTileEntity;
import seer.money.rendering.tileentities.PrinterTileEntity;
import seer.money.rendering.tileentities.RubyArrow;


@Mod(modid = "money", name = "Economy Mod", version = "2.7.0")
public class Test implements IRecipe {
	
	@Instance("money")
	public static Test instance;
	@SidedProxy(clientSide = "ru.seer.money.ClientProxy", serverSide = "ru.seer.money.CommonProxy")
	public static CommonProxy proxy;
	public static String version = "2.7.0";
	public static Item SapphirePickaxe;
	public static Item SapphireAxe;
	public static Item SapphireSword;
	public static Item SapphireShovel;
	public static Item SapphireHelmet;
	public static Item SapphireChestplate;
	public static Item SapphirePants;
	public static Item SapphireBoots;
	public static Item OpalPickaxe;
	public static Item OpalAxe;
	public static Item OpalSword;
	public static Item OpalShovel;
	public static Item OpalHelmet;
	public static Item OpalChestplate;
	public static Item OpalPants;
	public static Item OpalBoots;
	public static Item AmethystPickaxe;
	public static Item AmethystAxe;
	public static Item RubyAxe;
	public static Item RubyPickaxe;
	public static Item RubyShovel;
	public static Item AmethystShovel;
	public static Item RubySword;
	public static Item RubyBow;
	public static Item RubyArrows;
	public static Item AmethystBow;
	public static Item AmethystArrows;
	public static Item AmethystSword;
	public static Item RubyHelmet;
	public static Item RubyChestplate;
	public static Item RubyPants;
	public static Item RubyBoots;
	public static Item AmethystHelmet;
	public static Item AmethystChestplate;
	public static Item AmethystPants;
	public static Item AmethystBoots;
	public static Item Dollars;
	public static Item Cents;
	public static Item Wallet;
	public static Item Card;
	public static Item Ruby;
	public static Item Amethyst;
	public static Item ReinforcedAmethyst;
	public static CreativeTabs tabTutorial = new TabTutorial("Blocks");
	public static CreativeTabs tools = new tools("Tools");
	public static CreativeTabs others = new others("Other");
	public static CreativeTabs combat = new combat("Combat");
	public static Block AmethystBlock;
	public static Block RubyBlock;
	public static Block RubyOre;
	public static Block AmethystOre;
	public static Block PackOfDollars;
	public static Block MegaPackOfDollars;
	public static Block UltraPackOfDollars;
	public static Block OmegaPackOfDollars;
	public static Block MillionPackOfDollars;
	public static Block Shop;
	public static Block Printer;
	public static Block Cash_Machine;
	public static Block MegaPrinter;
	public static Block UltraPrinter;
	public static Block OmegaPrinter;
	public static Block MillionPrinter;
	public static Block Explosive;
	public static Block ReinforcedGlass;
	public static Block ReinforcedBlock;
	public static Block ReinforcedDoor;
	public static Item  ReinforcedDoorItem;
	public static Block ReadyBlock;
	public static Block NotReadyBlock;
	public static Block Signalization_Button;
	public static Block ReinforcedTrapdoor;
	public static RubyOreGenerator bestblockgenerator = new RubyOreGenerator();
	public static AmethystOreGenerator ametGen = new AmethystOreGenerator();
	public static OpalOreGenerator opalGen = new OpalOreGenerator();
	public static SapphireOreGenerator sapphireGen = new SapphireOreGenerator();
	public static Block safe;
	public static Block rubyStairs;
	public static Block amethystStairs;
	public static Item Opal;
	public static Item Sapphire;
	public static Block OpalOre;
	public static Block SapphireOre;
	public static Block SapphireBlock;
	public static Block OpalBlock;
	public static Item Bat;
	public static Item Pistol;
	public static Item pistBullet;
	public static Block rubySlab;
	public static Block rubySlab_double;
	public static Block amethystSlab;
	public static Block amethystSlab_double;
	public static String MODID = "money";
	public static Item Blood;
	private static int modGuiIndex = 1;
	
	@EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		EntityRegistry.registerModEntity(EntityPistBullet.class, "EntityPistBullet", 0, this, 64, 10, true);
		EntityRegistry.registerModEntity(AmethystArrow.class, "AmethystArrow", 5001, this, 100, 1, true);
		EntityRegistry.registerModEntity(RubyArrow.class, "RubyArrow", 5002, this, 100, 1, true);
		registerEntity(PoliceMan.class, "PoliceMan", 0x0000CD, 0x00008B);
		registerEntity(PoliceManGirl.class, "PoliceManGirl", 0x0000CD, 0x6495ED);
		registerEntity(PoliceManGunner.class, "PoliceManGunner", 0x0000CD, 0x00008B);
		registerEntity(PoliceManGirlGunner.class, "PoliceManGirlGunner", 0x0000CD, 0x6495ED);
		
		Blood = new Blood().setUnlocalizedName("blood");
		rubySlab = new CustomRubySlab(false).setBlockTextureName("money:rubySlab").setStepSound(Block.soundTypeStone);
		rubySlab_double = new CustomRubySlab(true).setBlockTextureName("money:rubySlab").setStepSound(Block.soundTypeStone);
		
		amethystSlab = new CustomAmetSlab(false).setBlockTextureName("money:amethystSlab").setStepSound(Block.soundTypeStone);
		amethystSlab_double = new CustomAmetSlab(true).setBlockTextureName("money:amethystSlab").setStepSound(Block.soundTypeStone);
		
		pistBullet = new pistBullet();
		Pistol = new Pistol();
		Bat = new Bat().setUnlocalizedName("Bat");
		
		OpalBlock = new OpalBlock();
		SapphireBlock = new SapphireBlock();
		Opal = new Opal().setUnlocalizedName("opal");
		OpalOre = new OpalOre();
		SapphireOre = new SapphireOre();
		Sapphire = new Sapphire().setUnlocalizedName("sapphire");
		
		
		safe = new safe(0);
		Signalization_Button = new Signalization_Button();
		NotReadyBlock = new NotReadyBlock();
		ReadyBlock = new ReadyBlock();
		ReinforcedTrapdoor = new ReinforcedTrapdoor();
		ReinforcedDoor = new ReinforcedDoor(Material.iron).setBlockTextureName("money:ReinforcedDoor");
		ReinforcedDoorItem = new ReinforcedDoorItem(Material.iron).setUnlocalizedName("ReinforcedDoor").setTextureName("money:ReinforcedDoor");
		ReinforcedAmethyst = new ReinforcedAmethyst().setUnlocalizedName("ReinforcedAmethyst").setTextureName("money:ReinforcedAmethyst");
		ReinforcedBlock = new ReinforcedBlock();
		ReinforcedGlass = new ReinforcedGlass();
		Explosive = new Explosive();
		
		RubyOre = new RubyOre();
		AmethystOre = new AmethystOre();
		
		OpalHelmet = new OpalArmor(3,0).setUnlocalizedName("OpalHelmet").setTextureName("money:OpalHelmet");
		OpalChestplate = new OpalArmor(2,1).setUnlocalizedName("OpalChestplate").setTextureName("money:OpalChestplate");
		OpalPants = new OpalArmor(3,2).setUnlocalizedName("OpalPants").setTextureName("money:OpalPants");
		OpalBoots = new OpalArmor(3,3).setUnlocalizedName("OpalBoots").setTextureName("money:OpalBoots");
		
		SapphireHelmet = new SapphireArmor(2,0).setUnlocalizedName("SapphireHelmet").setTextureName("money:SapphireHelmet");
		SapphireChestplate = new SapphireArmor(2,1).setUnlocalizedName("SapphireChestplate").setTextureName("money:SapphireChestplate");
		SapphirePants = new SapphireArmor(2,2).setUnlocalizedName("SapphirePants").setTextureName("money:SapphirePants");
		SapphireBoots = new SapphireArmor(2,3).setUnlocalizedName("SapphireBoots").setTextureName("money:SapphireBoots");
		
		OpalShovel = new OpalShovel().setUnlocalizedName("OpalShovel");
		SapphireShovel = new SapphireShovel().setUnlocalizedName("SapphireShovel");
		OpalSword = new OpalSword().setUnlocalizedName("OpalSword");
		SapphireSword = new SapphireSword().setUnlocalizedName("SapphireSword");
		
		SapphirePickaxe = new SapphirePickaxe().setUnlocalizedName("SapphirePickaxe");
		OpalPickaxe = new OpalPickaxe().setUnlocalizedName("OpalPickaxe");
		SapphireAxe = new SapphireAxe().setUnlocalizedName("SapphireAxe");
		OpalAxe = new OpalAxe().setUnlocalizedName("OpalAxe");
		
		RubyHelmet = new RubyArmor(0,0).setUnlocalizedName("RubyHelmet").setTextureName("money:RubyHelmet");
		RubyChestplate = new RubyArmor(0,1).setUnlocalizedName("RubyChestplate").setTextureName("money:RubyChestplate");
		RubyPants = new RubyArmor(0,2).setUnlocalizedName("RubyPants").setTextureName("money:RubyPants");
		RubyBoots = new RubyArmor(0,3).setUnlocalizedName("RubyBoots").setTextureName("money:RubyBoots");
		
		AmethystHelmet = new AmethystArmor(1,0).setUnlocalizedName("AmethystHelmet").setTextureName("money:AmethystHelmet");
		AmethystChestplate = new AmethystArmor(1,1).setUnlocalizedName("AmethystChestplate").setTextureName("money:AmethystChestplate");
		AmethystPants = new AmethystArmor(1,2).setUnlocalizedName("AmethystPants").setTextureName("money:AmethystPants");
		AmethystBoots = new AmethystArmor(1,3).setUnlocalizedName("AmethystBoots").setTextureName("money:AmethystBoots");
		
		RubyShovel = new RubyShovel().setUnlocalizedName("RubyShovel");
		AmethystShovel = new AmethystShovel().setUnlocalizedName("AmethystShovel");
		RubySword = new RubySword().setUnlocalizedName("RubySword");
		AmethystSword = new AmethystSword().setUnlocalizedName("AmethystSword");
		
		RubyBlock = new RubyBlock();
		AmethystBlock = new AmethystBlock();
		
		PackOfDollars = new PackOfDollars();
		MegaPackOfDollars = new MegaPackOfDollars();
		UltraPackOfDollars = new UltraPackOfDollars();
		OmegaPackOfDollars = new OmegaPackOfDollars();
		MillionPackOfDollars = new MillionPackOfDollars();
		
		Cash_Machine = new Cash_Machine();
		
		MegaPrinter = new MegaPrinter(false,Blocks.wool,0);
		UltraPrinter = new UltraPrinter(false,Blocks.wool,0);
		OmegaPrinter = new OmegaPrinter(false,Blocks.wool,0);
		MillionPrinter = new MillionPrinter(false,Blocks.wool,0);
		Printer = new Printer(false,Blocks.wool,0);
		Shop = new Shop();
		
		AmethystPickaxe = new AmethystPickaxe().setUnlocalizedName("amethyst pickaxe");
		RubyPickaxe = new RubyPickaxe().setUnlocalizedName("ruby pickaxe");
		AmethystAxe = new AmethystAxe().setUnlocalizedName("AmethystAxe");
		RubyAxe = new RubyAxe().setUnlocalizedName("RubyAxe");
		
		AmethystBow = new AmethystBow();
		RubyBow = new RubyBow();
		AmethystArrows = new AmethystArrows();
		RubyArrows = new RubyArrows();
		
		Amethyst = new Amethyst().setUnlocalizedName("amethyst");
		Ruby = new Ruby().setUnlocalizedName("ruby");
		//Changer = new Changer();
		Dollars = new Dollars().setUnlocalizedName("dollars");
		Cents = new Cents().setUnlocalizedName("cents");
		Wallet = new Wallet().setUnlocalizedName("wallet");
		Card = new Card().setUnlocalizedName("card");
		rubyStairs = new rubyStairs(RubyBlock, 0);
		amethystStairs = new amethystStairs(AmethystBlock, 0);
		
		GameRegistry.registerItem(Blood, "Blood");
		GameRegistry.registerItem(pistBullet, "pistBullet");
		GameRegistry.registerItem(Bat, "Bat");
		GameRegistry.registerItem(OpalSword, "OpalSword");
		GameRegistry.registerItem(SapphireSword, "SapphireSword");
		GameRegistry.registerItem(OpalShovel, "OpalShovel");
		GameRegistry.registerItem(SapphireShovel, "SapphireShovel");
		GameRegistry.registerItem(OpalPickaxe, "OpalPickaxe");
		GameRegistry.registerItem(SapphirePickaxe, "SapphirePickaxe");
		GameRegistry.registerItem(OpalAxe, "OpalAxe");
		GameRegistry.registerItem(SapphireAxe, "SapphireAxe");
		GameRegistry.registerItem(Opal,"Opal");
		GameRegistry.registerItem(Sapphire,"Sapphire");
		GameRegistry.registerItem(OpalHelmet,"OpalHelmet");
		GameRegistry.registerItem(OpalChestplate,"OpalChestplate");
		GameRegistry.registerItem(OpalPants,"OpalPants");
		GameRegistry.registerItem(OpalBoots,"OpalBoots");
		GameRegistry.registerItem(SapphireHelmet,"SapphireHelmet");
		GameRegistry.registerItem(SapphireChestplate,"SapphireChestplate");
		GameRegistry.registerItem(SapphirePants,"SapphirePants");
		GameRegistry.registerItem(SapphireBoots,"SapphireBoots");
		GameRegistry.registerItem(ReinforcedAmethyst,"ReinforcedAmethyst");
		GameRegistry.registerItem(RubyArrows,"RubyArrows");
		GameRegistry.registerItem(AmethystArrows,"AmethystArrows");
		GameRegistry.registerItem(RubyHelmet,"RubyHelmet");
		GameRegistry.registerItem(RubyChestplate,"RubyChestplate");
		GameRegistry.registerItem(RubyPants,"RubyPants");
		GameRegistry.registerItem(RubyBoots,"RubyBoots");
		GameRegistry.registerItem(AmethystBow,"AmethystBow");
		GameRegistry.registerItem(RubyBow,"RubyBow");
		GameRegistry.registerItem(AmethystHelmet,"AmethystHelmet");
		GameRegistry.registerItem(AmethystChestplate,"AmethystChestplate");
		GameRegistry.registerItem(AmethystPants,"AmethystPants");
		GameRegistry.registerItem(AmethystBoots,"AmethystBoots");
		GameRegistry.registerItem(RubySword, "RubySword");
		GameRegistry.registerItem(AmethystSword, "AmethystSword");
		GameRegistry.registerItem(RubyShovel, "RubyShovel");
		GameRegistry.registerItem(AmethystShovel, "AmethystShovel");
		GameRegistry.registerItem(RubyPickaxe, "RubyPickaxe");
		GameRegistry.registerItem(AmethystPickaxe, "AmethystPickaxe");
		GameRegistry.registerItem(RubyAxe, "RubyAxe");
		GameRegistry.registerItem(AmethystAxe, "AmethystAxe");
		GameRegistry.registerItem(Amethyst, "Amethyst");
		GameRegistry.registerItem(Dollars, "Dollars");
		GameRegistry.registerItem(Cents, "Cents");
		GameRegistry.registerItem(Ruby, "Ruby");
		GameRegistry.registerItem(Wallet, "Wallet");
		GameRegistry.registerItem(Card, "Card");
		GameRegistry.registerItem(ReinforcedDoorItem, "ReinforcedDoorItem");
		GameRegistry.registerItem(Pistol, "Pistol");
		
		GameRegistry.registerBlock(OpalBlock, "OpalBlock");
	    GameRegistry.registerBlock(SapphireBlock, "SapphireBlock");
		GameRegistry.registerBlock(OpalOre, "OpalOre");
		GameRegistry.registerBlock(SapphireOre, "SapphireOre");
		GameRegistry.registerBlock(amethystStairs, "amethystStairs");
		GameRegistry.registerBlock(rubyStairs, "rubyStairs");
		GameRegistry.registerBlock(safe, "safe");
		GameRegistry.registerBlock(ReinforcedTrapdoor, "ReinforcedTrapdoor");
		GameRegistry.registerBlock(Signalization_Button, "Signalization_Button");
		GameRegistry.registerBlock(NotReadyBlock, "NotReadyBlock");
		GameRegistry.registerBlock(ReadyBlock, "ReadyBlock");
		GameRegistry.registerBlock(ReinforcedDoor, "ReinforcedDoor");
		GameRegistry.registerBlock(ReinforcedBlock, "ReinforcedBlock");
		GameRegistry.registerBlock(Shop, "Shop");
		GameRegistry.registerBlock(Explosive, "Explosive");
		GameRegistry.registerBlock(RubyBlock, "RubyBlock");
		GameRegistry.registerBlock(AmethystBlock, "AmethystBlock");
		GameRegistry.registerBlock(AmethystOre, "AmethystOre");
		GameRegistry.registerBlock(RubyOre, "RubyOre");
		GameRegistry.registerBlock(MegaPackOfDollars, "MegaPackOfDollars");
		GameRegistry.registerBlock(UltraPackOfDollars, "UltraPackOfDollars");
		GameRegistry.registerBlock(OmegaPackOfDollars, "OmegaPackOfDollars");
		GameRegistry.registerBlock(MillionPackOfDollars, "MillionPackOfDollars");
		GameRegistry.registerBlock(PackOfDollars, "PackOfDollars");
		GameRegistry.registerBlock(Printer, "Printer");
		GameRegistry.registerBlock(MegaPrinter, "MegaPrinter");
		GameRegistry.registerBlock(UltraPrinter, "UltraPrinter");
		GameRegistry.registerBlock(OmegaPrinter, "OmegaPrinter");
		GameRegistry.registerBlock(MillionPrinter, "MillionPrinter");
		GameRegistry.registerBlock(Cash_Machine, "Cash_Machine");
		GameRegistry.registerBlock(ReinforcedGlass, "ReinforcedGlass");
		GameRegistry.registerBlock(rubySlab_double, RubyItemSlab.class, "rubySlab_double");
		GameRegistry.registerBlock(rubySlab, RubyItemSlab.class, "rubySlab");
		GameRegistry.registerBlock(amethystSlab_double, AmetItemSlab.class, "amethystSlab_double");
		GameRegistry.registerBlock(amethystSlab, AmetItemSlab.class, "amethystSlab");
		
		//GameRegistry.registerTileEntity(ExplosiveTileEntity.class, "Boom");
		GameRegistry.registerTileEntity(Cash_MachineTileEntity.class, "Custom block");
		GameRegistry.registerTileEntity(ShopTileEntity.class, "seer.money.rendering.tiles.ShopTileEntity");
		GameRegistry.registerTileEntity(PrinterTileEntity.class, "seer.money.rendering.tiles.PrinterTileEntity");
		GameRegistry.registerTileEntity(MegaTileEntity.class, "seer.money.rendering.tiles.MegaTileEntity");
		GameRegistry.registerTileEntity(OmegaTileEntity.class, "seer.money.rendering.tiles.OmegaTileEntity");
		GameRegistry.registerTileEntity(UltraTileEntity.class, "seer.money.rendering.tiles.UltraTileEntity");
		GameRegistry.registerTileEntity(MillionTileEntity.class, "seer.money.rendering.tiles.MillionTileEntity");
		
		proxy.registerRenderers();
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	GameRegistry.registerWorldGenerator(ametGen, 0);
    	GameRegistry.registerWorldGenerator(bestblockgenerator, 0);

    	GameRegistry.addSmelting(RubyOre, new ItemStack(Ruby, 1), 35.0F);
    	GameRegistry.addSmelting(AmethystOre, new ItemStack(Amethyst, 1), 20.0F);
    	GameRegistry.addSmelting(OpalOre, new ItemStack(Opal, 1), 40.0F);
    	GameRegistry.addSmelting(SapphireOre, new ItemStack(Sapphire, 1), 25.0F);
    	GameRegistry.addShapelessRecipe(new ItemStack(Dollars, 1), new Object[] {Items.gold_ingot, Items.diamond});
    	GameRegistry.addShapelessRecipe(new ItemStack(Cents, 1), new Object[] {Items.iron_ingot, Items.iron_ingot, Items.iron_ingot});
    	GameRegistry.addShapelessRecipe(new ItemStack(Cents, 6), new Object[] {Blocks.iron_block, Blocks.iron_block});
    	GameRegistry.addShapelessRecipe(new ItemStack(Dollars, 9), new Object[] {PackOfDollars});
    	GameRegistry.addShapelessRecipe(new ItemStack(Wallet, 1), new Object[] {Items.leather, Items.leather, Dollars});
    	GameRegistry.addShapelessRecipe(new ItemStack(Card, 1), new Object[] {PackOfDollars, Blocks.iron_block, Blocks.iron_block});
    	GameRegistry.addShapelessRecipe(new ItemStack(PackOfDollars, 9), new Object[] {MegaPackOfDollars});
    	GameRegistry.addShapelessRecipe(new ItemStack(MegaPackOfDollars, 9), new Object[] {UltraPackOfDollars});
    	GameRegistry.addShapelessRecipe(new ItemStack(OmegaPackOfDollars, 9), new Object[] {MillionPackOfDollars});
    	GameRegistry.addShapelessRecipe(new ItemStack(MegaPackOfDollars, 1), new Object[] {PackOfDollars, PackOfDollars, PackOfDollars, PackOfDollars, PackOfDollars, PackOfDollars, PackOfDollars, PackOfDollars, PackOfDollars,});
    	GameRegistry.addShapelessRecipe(new ItemStack(UltraPackOfDollars, 1), new Object[] {MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars, MegaPackOfDollars,});
    	GameRegistry.addShapelessRecipe(new ItemStack(OmegaPackOfDollars, 1), new Object[] {UltraPackOfDollars, UltraPackOfDollars, UltraPackOfDollars, UltraPackOfDollars, Ruby, Ruby});
    	GameRegistry.addShapelessRecipe(new ItemStack(MillionPackOfDollars, 1), new Object[] {OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars, OmegaPackOfDollars,});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Amethyst, 9), new Object[] {AmethystBlock});
    	GameRegistry.addShapelessRecipe(new ItemStack(Ruby, 9), new Object[] {RubyBlock});
    	GameRegistry.addShapelessRecipe(new ItemStack(RubyBlock, 1), new Object[] {Ruby, Ruby, Ruby, Ruby, Ruby, Ruby, Ruby, Ruby, Ruby,});
    	GameRegistry.addShapelessRecipe(new ItemStack(AmethystBlock, 1), new Object[] {Amethyst, Amethyst, Amethyst, Amethyst, Amethyst, Amethyst, Amethyst, Amethyst, Amethyst,});
    	GameRegistry.addRecipe(new ItemStack(rubySlab, 6),

  			  new Object[]{

  			    "   ", "   ", "###",

  			    ('#'), Ruby

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(amethystSlab, 6),

    			  new Object[]{

    			    "   ", "   ", "###",

    			    ('#'), Amethyst

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(OpalHelmet, 1),

    			  new Object[]{

    			    "###", "# #", "   ",

    			    ('#'), Opal

    			  }

    			);
      	GameRegistry.addRecipe(new ItemStack(SapphireHelmet, 1),

      			  new Object[]{

      			    "###", "# #", "   ",

      			    ('#'), Sapphire

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(OpalChestplate, 1),

    			  new Object[]{

    			    "# #", "###", "###",

    			    ('#'), Opal

    			  }

    			);
      	GameRegistry.addRecipe(new ItemStack(SapphireChestplate, 1),

      			  new Object[]{

      			    "# #", "###", "###",

      			    ('#'), Sapphire

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(OpalPants, 1),

      			  new Object[]{

      			    "###", "# #", "# #",

      			    ('#'), Opal

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(SapphirePants, 1),

    			  new Object[]{

    			    "###", "# #", "# #",

    			    ('#'), Sapphire

    			  }

    			);
      	GameRegistry.addRecipe(new ItemStack(OpalBoots, 1),

    			  new Object[]{

    			    "   ", "# #", "# #",

    			    ('#'), Opal

    			  }

    			);
      	GameRegistry.addRecipe(new ItemStack(OpalBoots, 1),

      			  new Object[]{

      			    "# #", "# #", "   ",

      			    ('#'), Opal

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(SapphireBoots, 1),

    			  new Object[]{

    			    "# #", "# #", "   ",

    			    ('#'), Sapphire

    			  }

    			);
      	GameRegistry.addRecipe(new ItemStack(SapphireBoots, 1),

      			  new Object[]{

      			    "   ", "# #", "# #",

      			    ('#'), Sapphire

      			  }

      			);
    	GameRegistry.addRecipe(new ItemStack(SapphirePickaxe, 1),

    			  new Object[]{

    			    "###", " X ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Sapphire

    			  }

    			);
      	GameRegistry.addRecipe(new ItemStack(OpalPickaxe, 1),

      			  new Object[]{

      			    "###", " X ", " X ",

      			    ('X'), Items.stick,
      			    ('#'), Opal

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(SapphireAxe, 1),

      			  new Object[]{

      			    "## ", "#X ", " X ",

      			    ('X'), Items.stick,
      			    ('#'), Sapphire

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(OpalAxe, 1),

      			  new Object[]{

      				"## ", "#X ", " X ",

      			    ('X'), Items.stick,
      			    ('#'), Opal

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(SapphireShovel, 1),

      			  new Object[]{

      			    " # ", " X ", " X ",

      			    ('X'), Items.stick,
      			    ('#'), Sapphire

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(OpalShovel, 1),

      			  new Object[]{

      			    " # ", " X ", " X ",

      			    ('X'), Items.stick,
      			    ('#'), Opal

      			  }

      			);
      	GameRegistry.addRecipe(new ItemStack(SapphireSword, 1),

    			  new Object[]{

    			    " # ", " # ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Sapphire

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(OpalSword, 1),

    			  new Object[]{

    			    " # ", " # ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Opal

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(OpalBlock, 1),

  			  new Object[]{

  			    "XXX", "XXX", "XXX",

  			    ('X'), Opal

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(SapphireBlock, 1),

    			  new Object[]{

    			    "XXX", "XXX", "XXX",

    			    ('X'), Sapphire

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(safe, 1),

    			  new Object[]{

    			    "XXX", "X#X", "XXX",

    			    ('X'), ReinforcedBlock,
    			    ('#'), Blocks.ender_chest

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(ReinforcedAmethyst, 1),

  			  new Object[]{

  			    "XXX", " # ", "XXX",

  			    ('X'), Items.iron_ingot,
  			    ('#'), Amethyst

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(ReinforcedBlock, 1),

    			  new Object[]{

    			    "XZX", "X#X", "XZX",

    			    ('X'), Blocks.iron_block,
    			    ('#'), ReinforcedAmethyst,
    			    ('Z'), Blocks.obsidian

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(ReinforcedGlass, 1),

  			  new Object[]{

  			    "ZXZ", "X#X", "ZXZ",

  			    ('X'), ReinforcedBlock,
  			    ('#'), Ruby,
			    ('Z'), Blocks.glass

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(AmethystArrows, 1),

    			  new Object[]{

    			    " # ", " X ", " Z ",

    			    ('X'), Items.stick,
    			    ('#'), Amethyst,
    			    ('Z'), Items.feather

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(RubyArrows, 1),

  			  new Object[]{

  			    " # ", " X ", " Z ",

  			    ('X'), Items.stick,
  			    ('#'), Ruby,
  			    ('Z'), Items.feather

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(AmethystBow, 1),

    			  new Object[]{

    			    "#X ", "#ZX", "#X ",

    			    ('X'), Items.stick,
    			    ('#'), Items.string,
    			    ('Z'), Test.Amethyst

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystBow, 1),

  			  new Object[]{

  			    " X#", "XZ#", " X#",

  			    ('X'), Items.stick,
  			    ('#'), Items.string,
  			    ('Z'), Test.Amethyst

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(RubyBow, 1),

  			  new Object[]{

  			    "#X ", "#ZX", "#X ",

  			    ('X'), Items.stick,
  			    ('#'), Items.string,
  			    ('Z'), Test.Ruby

  			  }

  			);
  	GameRegistry.addRecipe(new ItemStack(RubyBow, 1),

			  new Object[]{

			    " X#", "XZ#", " X#",

			    ('X'), Items.stick,
			    ('#'), Items.string,
			    ('Z'), Test.Ruby

			  }

			);
    	GameRegistry.addRecipe(new ItemStack(Printer, 1),

    			  new Object[]{

    			    "###", "XXX", "###",

    			    ('X'), PackOfDollars,
    			    ('#'), Blocks.iron_block

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystPickaxe, 1),

  			  new Object[]{

  			    "###", " X ", " X ",

  			    ('X'), Items.stick,
  			    ('#'), Amethyst

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(RubyPickaxe, 1),

    			  new Object[]{

    			    "###", " X ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Ruby

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystAxe, 1),

    			  new Object[]{

    			    "## ", "#X ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Amethyst

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(RubyAxe, 1),

    			  new Object[]{

    				"## ", "#X ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Ruby

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystShovel, 1),

    			  new Object[]{

    			    " # ", " X ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Amethyst

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(RubyShovel, 1),

    			  new Object[]{

    			    " # ", " X ", " X ",

    			    ('X'), Items.stick,
    			    ('#'), Ruby

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystSword, 1),

  			  new Object[]{

  			    " # ", " # ", " X ",

  			    ('X'), Items.stick,
  			    ('#'), Amethyst

  			  }

  			);
  	GameRegistry.addRecipe(new ItemStack(RubySword, 1),

  			  new Object[]{

  			    " # ", " # ", " X ",

  			    ('X'), Items.stick,
  			    ('#'), Ruby

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(MegaPrinter, 1),

  			  new Object[]{

  			    "###", "XXX", "###",

  			    ('X'), MegaPackOfDollars,
  			    ('#'), Blocks.gold_block

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(UltraPrinter, 1),

    			  new Object[]{

    			    "###", "XXX", "###",

    			    ('X'), UltraPackOfDollars,
    			    ('#'), Blocks.diamond_block

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(OmegaPrinter, 1),

    			  new Object[]{

    			    "###", "XXX", "###",

    			    ('X'), OmegaPackOfDollars,
    			    ('#'), AmethystBlock

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(MillionPrinter, 1),

    			  new Object[]{

    			    "###", "XXX", "###",

    			    ('X'), MillionPackOfDollars,
    			    ('#'), RubyBlock


    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(Shop, 1),

  			  new Object[]{

  			    "###", "XXX", "###",

  			    ('X'), Ruby,
  			    ('#'), MegaPackOfDollars


  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(RubyHelmet, 1),

  			  new Object[]{

  			    "###", "# #", "   ",

  			    ('#'), Ruby

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(AmethystHelmet, 1),

    			  new Object[]{

    			    "###", "# #", "   ",

    			    ('#'), Amethyst

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(RubyChestplate, 1),

  			  new Object[]{

  			    "# #", "###", "###",

  			    ('#'), Ruby

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(AmethystChestplate, 1),

    			  new Object[]{

    			    "# #", "###", "###",

    			    ('#'), Amethyst

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(RubyPants, 1),

    			  new Object[]{

    			    "###", "# #", "# #",

    			    ('#'), Ruby

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystPants, 1),

  			  new Object[]{

  			    "###", "# #", "# #",

  			    ('#'), Amethyst

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(RubyBoots, 1),

  			  new Object[]{

  			    "   ", "# #", "# #",

  			    ('#'), Ruby

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(RubyBoots, 1),

    			  new Object[]{

    			    "# #", "# #", "   ",

    			    ('#'), Ruby

    			  }

    			);
    	GameRegistry.addRecipe(new ItemStack(AmethystBoots, 1),

  			  new Object[]{

  			    "# #", "# #", "   ",

  			    ('#'), Amethyst

  			  }

  			);
    	GameRegistry.addRecipe(new ItemStack(AmethystBoots, 1),

    			  new Object[]{

    			    "   ", "# #", "# #",

    			    ('#'), Amethyst

    			  }

    			);
    	GameRegistry.addShapelessRecipe(new ItemStack(PackOfDollars, 1), new Object[] {Dollars,Dollars,Dollars,Dollars,Dollars,Dollars,Dollars,Dollars,Dollars});
    	NetworkRegistry.INSTANCE.registerGuiHandler(Test.MODID, new TMGuiHandler());
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) 
    {
    	BiomeDictionary.registerAllBiomes();
    	BiomeManager.warmBiomes.add(new BiomeEntry(new BiomeGenBank1(138).setBiomeName("City"), 3000));
        proxy.postInit(event);
    }
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    }
    public static void registerEntity(Class entityClass, String name, int primaryColor, int secondaryColor)
    {
      int entityID = EntityRegistry.findGlobalUniqueEntityId();
      long seed = name.hashCode();

      EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
      EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true); //эта строка не нужна(зачем она?)
      EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
    public static final ToolMaterial bat = EnumHelper.addToolMaterial("bat", 3, 25, 2.0F, 5.0F, 30);
    
    public static final ToolMaterial ruby = EnumHelper.addToolMaterial("ruby", 3, 3000, 12.0F, 5.0F, 20);
    public static final ToolMaterial amethyst = EnumHelper.addToolMaterial("amethyst", 3, 1600, 8.0F, 4.0F, 25);
    public static final ToolMaterial rubyAxe = EnumHelper.addToolMaterial("rubyAxe", 3, 3000, 12.0F, 7.0F, 20);
    public static final ToolMaterial amethystAxe = EnumHelper.addToolMaterial("amethystAxe", 3, 1600, 8.0F, 6.0F, 25);
    public static final ToolMaterial rubyShovel = EnumHelper.addToolMaterial("rubyShovel", 3, 3000, 12.0F, 6.0F, 20);
    public static final ToolMaterial amethystShovel = EnumHelper.addToolMaterial("amethystShovel", 3, 1600, 10.0F, 5.0F, 25);
    public static final ToolMaterial rubySword = EnumHelper.addToolMaterial("rubySword", 3, 2800, 2.0F, 10.0F, 30);
    public static final ToolMaterial amethystSword = EnumHelper.addToolMaterial("amethystSword", 3, 1400, 2.0F, 9.0F, 35);
    
    public static final ToolMaterial opalPickAxe = EnumHelper.addToolMaterial("opalPickAxe", 4, 5000, 14.0F, 6.0F, 20);
    public static final ToolMaterial opalAxe = EnumHelper.addToolMaterial("opalAxe", 3, 5000, 16.0F, 8.0F, 20);
    public static final ToolMaterial opalShovel = EnumHelper.addToolMaterial("opalShovel", 3, 5000, 16.0F, 6.0F, 20);
    public static final ToolMaterial opalSword = EnumHelper.addToolMaterial("opalSword", 3, 5000, 2.0F, 13.0F, 30);
    
    public static final ToolMaterial sapphirePickaxe = EnumHelper.addToolMaterial("sapphirePickaxe", 3, 2000, 12.0F, 5.0F, 30);
    public static final ToolMaterial sapphireAxe = EnumHelper.addToolMaterial("sapphireAxe", 3, 2000, 10.0F, 6.0F, 25);
    public static final ToolMaterial sapphireShovel = EnumHelper.addToolMaterial("sapphireShovel", 3, 2000, 10.0F, 5.0F, 25);
    public static final ToolMaterial sapphireSword = EnumHelper.addToolMaterial("sapphireSword", 3, 2000, 2.0F, 8.0F, 35);
    
    public static ArmorMaterial rubyMat = EnumHelper.addArmorMaterial("ruby", 100, new int[] {7, 13, 9, 6}, 30);
    public static ArmorMaterial ametMat = EnumHelper.addArmorMaterial("amethyst",60, new int[] {5, 11, 6, 4}, 30);
    public static ArmorMaterial opalMat = EnumHelper.addArmorMaterial("opal", 500, new int[] {9, 15, 11, 8}, 30);
    public static ArmorMaterial sapphireMat = EnumHelper.addArmorMaterial("sapphire",80, new int[] {6, 12, 7, 5}, 30);
    
    static DamageSource bulletDamage1 = new DamageSource("bullet1").setDamageBypassesArmor();
	@Override
	public boolean matches(InventoryCrafting p_77569_1_, World p_77569_2_) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting p_77572_1_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRecipeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ItemStack getRecipeOutput() {
		// TODO Auto-generated method stub
		return null;
	}
}

