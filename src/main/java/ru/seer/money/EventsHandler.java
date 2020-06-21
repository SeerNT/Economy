package ru.seer.money;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import seer.money.data.ExtendedPlayer;
import seer.money.gen.WorldGenBankStructure;

public class EventsHandler{
	public static Boolean sh = false;
	public boolean opalDone = false;
	private int luxuryCounter = 0;
	private boolean sapDone = false;
	private boolean readyToRevenge = false;
	public static boolean isPlayerDead = false;
	private int printerCounter = 0;
	private boolean printerDone1 = false;
	private boolean printerDone2= false;
	private boolean printerDone3 = false;
	private boolean printerDone4 = false;
	private boolean printerDone5 = false;

	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onJoin(EntityJoinWorldEvent e)
    {
		if (e.entity instanceof EntityPlayer)
	    {
	              ((EntityPlayer) e.entity).addStat(CommonProxy.achievementStart, 1);
	    }
    }
    @SubscribeEvent
    public void onLive(LivingUpdateEvent e)
    {
		if (e.entity instanceof EntityPlayer)
	    {
			if(WorldGenBankStructure.biome_player == BiomeGenBank1.getBiome(138)) {
				((EntityPlayer) e.entity).addStat(CommonProxy.achievementCiv, 1);
			}
	              
	              
	    }
    }
    @SubscribeEvent
    public void onDeath(LivingDeathEvent e)
    {
		if (e.entity instanceof PoliceMan || e.entity instanceof PoliceManGirl || e.entity instanceof PoliceManGunner || e.entity instanceof PoliceManGirlGunner)
	    {
			World world = e.entity.worldObj;
		    EntityPlayer player = world.getClosestPlayerToEntity(e.entity,40);
		    if(player != null) {
		    	player.addStat(CommonProxy.achievementPolice, 1);   
		    }
		    
		    if (readyToRevenge == true) {
		    	 player.addStat(CommonProxy.achievementRevenge, 1);   
		    }
	    }
		if(e.entity instanceof EntityPlayer) {
			isPlayerDead = true;
			if(e.source == Test.bulletDamage1) {
				readyToRevenge  = true;
			}
		}
    }
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event)
	{
		/*
		Be sure to check if the entity being constructed is the correct type
		for the extended properties you're about to add!
		The null check may not be necessary - I only use it to make sure
		properties are only registered once per entity
		*/
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null)
			// This is how extended properties are registered using our convenient method from earlier
			ExtendedPlayer.register((EntityPlayer) event.entity);
			// That will call the constructor as well as cause the init() method
			// to be called automatically
		
		// If you didn't make the two convenient methods from earlier, your code would be
		// much uglier:
		if (event.entity instanceof EntityPlayer && event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME) == null)
			event.entity.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer((EntityPlayer) event.entity));
	}
	@SubscribeEvent(priority=EventPriority.HIGH, receiveCanceled=true)
	public void onEvent(PlaceEvent ev)
    {
		
		if (ev.block == Test.PackOfDollars) {
			ev.player.addStat(CommonProxy.achievementFirstPackOfDollars, 1);
		}
		if(ev.block == Test.Shop) {
			ev.player.addStat(CommonProxy.achievementShopping, 1);
		}
		if(ev.block == Test.Cash_Machine) {
			ev.player.addStat(CommonProxy.achievementCashMachine, 1);
		}
		if (ev.block == Test.Printer) {
			ev.player.addStat(CommonProxy.achievementPrinter, 1);
			if(printerDone1 == false) {
				printerCounter += 1;
				printerDone1 = true;
			}
			if(printerCounter >= 5) {
				ev.player.addStat(CommonProxy.achievementPrinterMan, 1);
			}
			
		}
		if (ev.block == Test.MegaPrinter) {
			if(printerDone2 == false) {
				printerCounter += 1;
				printerDone2 = true;
			}
			if(printerCounter >= 5) {
				ev.player.addStat(CommonProxy.achievementPrinterMan, 1);
			}
			
		}
		if (ev.block == Test.UltraPrinter) {
			if(printerDone3 == false) {
				printerCounter += 1;
				printerDone3 = true;
			}
			if(printerCounter >= 5) {
				ev.player.addStat(CommonProxy.achievementPrinterMan, 1);
			}
			
		}
		if (ev.block == Test.OmegaPrinter) {
			if(printerDone4 == false) {
				printerCounter += 1;
				printerDone4 = true;
			}
			if(printerCounter >= 5) {
				ev.player.addStat(CommonProxy.achievementPrinterMan, 1);
			}
			
		}
		if (ev.block == Test.MillionPrinter) {
			if(printerDone5 == false) {
				printerCounter += 1;
				printerDone5 = true;
			}
			if(printerCounter >= 5) {
				ev.player.addStat(CommonProxy.achievementPrinterMan, 1);
			}
			
		}
		
    }
	@SubscribeEvent(priority=EventPriority.HIGH, receiveCanceled=true)
	public void onBreak(BreakEvent ev)
    {
		if (ev.block == Test.RubyOre) {
			ev.getPlayer().addStat(CommonProxy.achievementRuby, 1);
		}
		if (ev.block == Test.AmethystOre) {
			ev.getPlayer().addStat(CommonProxy.achievementAmethyst, 1);
		}
		if(ev.block == Test.OpalOre && opalDone == false) {
			 luxuryCounter  += 1;
			 opalDone = true;
		}
		if(ev.block == Test.SapphireOre && sapDone == false) {
			 luxuryCounter  += 1;
			 sapDone = true;
		}
		if(luxuryCounter >= 2) {
			ev.getPlayer().addStat(CommonProxy.achievementLuxury, 1);
		}
		
    }
	
}
