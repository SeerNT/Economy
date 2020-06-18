package ru.seer.money;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;
<<<<<<< HEAD
=======
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemCraftedEvent;
>>>>>>> Recovery,achievments and other fixes
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import seer.money.data.ExtendedPlayer;

public class EventsHandler{
<<<<<<< HEAD
	@SubscribeEvent
	public void onKeyInputEvent(InputEvent.KeyInputEvent event) {
		System.out.println("Нажато что-то");
		if (Keyboard.isKeyDown(Keyboard.KEY_0)) {//Это простой способ, но он не полон.
			System.out.println("Нажато");
		}
	}
=======
	public static Boolean sh = false;
	public boolean opalDone = false;
	private int luxuryCounter = 0;
	private boolean sapDone = false;

>>>>>>> Recovery,achievments and other fixes
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
    public void onJoin(EntityJoinWorldEvent e)
    {
		if (e.entity instanceof EntityPlayer)
	    {
<<<<<<< HEAD
	              ((EntityPlayer) e.entity).addStat(CommonProxy.achievementStart, 1);
	    }
    }
	 
=======
			
	              ((EntityPlayer) e.entity).addStat(CommonProxy.achievementStart, 1);
	    }
    }
>>>>>>> Recovery,achievments and other fixes
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
		if (ev.block == Test.Printer) {
			ev.player.addStat(CommonProxy.achievementPrinter, 1);
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
<<<<<<< HEAD
=======
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
>>>>>>> Recovery,achievments and other fixes
		
    }
	
}
