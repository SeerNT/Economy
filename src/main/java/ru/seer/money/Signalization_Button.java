package ru.seer.money;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.sound.SoundEvent;

public class Signalization_Button extends BlockButton {
	 @SideOnly(Side.CLIENT)
	 public IIcon[] icons = new IIcon[1];
	 public static Boolean isPressed = false;
	 public static int playTimes = 0;
	 protected Signalization_Button()
	 {
	        super(true);
	        this.setCreativeTab(Test.tools);
	        this.setBlockTextureName("money:Signalization_Button");
	        this.setBlockName("Signalization_Button");
	 }
	 @SideOnly(Side.CLIENT)
	 public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		    return this.icons[0];
	 }
	 @Override
	 public void registerBlockIcons(IIconRegister reg) {
	         this.icons[0] = reg.registerIcon("money:Signalization_Button");
	 }
	 public boolean onBlockActivated(World world2, int x, int y, int z, EntityPlayer player2, int par6, float par7, float par8, float par9) {
		 player2.addStat(CommonProxy.achievementRob, 1);   
		 if(isPressed == false) {
			 final EntityPlayer player = player2;
			 final World world = world2;
			 String coloredText = EnumChatFormatting.RED + "WARNING! INTRUDERS! THE POLICE WILL COME IN A FEW MINUTES";
			 player.addChatMessage(new ChatComponentText(coloredText));
			 final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
			    executorService.scheduleAtFixedRate(new Runnable() {
			        	@Override
			        	public void run() 
			        	{
			        		if(playTimes == 5 || playTimes == 10 || playTimes == 15 || playTimes == 20 || playTimes == 25 || playTimes == 30) {
			        			isPressed = false;
			        			
			        			myTask();
			        		}else {
			        			myTask();
			        		}
			        		if(playTimes >= 50) {
			        			executorService.shutdown();
			        		}
			        	}
			        	
						private void myTask() {
							playTimes = playTimes + 1;
							if (isPressed == false) {
								world.playSound(player.posX, player.posY, player.posZ, "money:siren", 3.0F, 0.6F, false);
								isPressed = true;
							}else {
								
							}	
						}
			    	}, 0, 10, TimeUnit.SECONDS);
			 
			 
			 return true;
		 }else {
			 return true;
		 }		    
	}
	
}
