package seer.money.guihandlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
import seer.money.containers.ContainerShop;
import seer.money.containers.ContainerShopCustom;

public class GuiShopCustom extends GuiContainer {
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("money", "textures/blocks/customize.png");
	private ShopTileEntity tileFurnace;
	public World wor;
	public EntityPlayer pla;
	public int x2;
	public int y2;
	public int z2;
	private String timeD;
	private String curTime;
	private long first;
	private String remainingTime;
	private long second;
	public static String userTime;
	public static Boolean ck = false;
	public static String time;
	// Для слотов
	public static Boolean amethystIs = true;
	public static Boolean rubyIs = false;
	public static Boolean blocksIs = false;
	public static Boolean decorIs = false;
	public static Boolean mobsIs = false;
	public static Boolean uniqueIs = false;
	public static Boolean item1IsNull = true;
	public static Boolean item2IsNull = true;
	public static Boolean item3IsNull = true;
	public static Boolean item4IsNull = true;
	public static Boolean item5IsNull = true;
	public static Boolean item6IsNull = true;
	public static ItemStack item1;
	public static ItemStack item2;
	public static ItemStack item3;
	public static ItemStack item4;
	public static ItemStack item5;
	public static ItemStack item6;
	public static double item1_price = 0.0;
	public static double item2_price = 0.0;
	public static double item3_price = 0.0;
	public static double item4_price = 0.0;
	public static double item5_price = 0.0;
	public static double item6_price = 0.0;
	public static int clicks = 0;
	
	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public GuiShopCustom(InventoryPlayer inventory, ShopTileEntity tileEntityTestContainer, World world, EntityPlayer player, int x, int y, int z) {
		super(new ContainerShopCustom(inventory, tileEntityTestContainer));
		// Дата	
	    Date dateNow = new Date();
	    SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd kk:mm:ss");
	    SimpleDateFormat formatForDateNow2 = new SimpleDateFormat("kk:mm:ss");
	    timeD = formatForDateNow.format(dateNow);
	    userTime =  formatForDateNow2.format(dateNow);
	    first = dateNow.getTime();
		this.tileFurnace = tileEntityTestContainer;
		this.width = sr.getScaledWidth();
		this.height = sr.getScaledHeight();
		wor = world;
		pla = player;
		x2 = x;
		y2 = y;
		z2 = z;
		final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
	    executorService.scheduleAtFixedRate(new Runnable() {
	        	@Override
	        	public void run() 
	        	{
	            myTask();
	        	}
	    	}, 0, 1, TimeUnit.SECONDS);
	}
	public void myTask() {
		Date dateNow = new Date();
		second = dateNow.getTime();
	    SimpleDateFormat formatForDateNow2 = new SimpleDateFormat("kk:mm:ss");
	    curTime =  formatForDateNow2.format(dateNow);
	    remainingTimeLong = remainingTimeLong - 1 ;
	    remainingTime = Integer.toString(remainingTimeSeconds);
	    remainingTimeLongMin = Math.round(remainingTimeLong / 60);
	    remainingTimeSeconds = remainingTimeSeconds - 1;
	    if (remainingTimeSeconds == 0) {
	    	remainingTimeSeconds = 59;
	    }
		remainingTimeMin = Integer.toString(remainingTimeLongMin);
	    if ((first + 3600000) <= second) {
				int rand = getRandomNumberInRange(1,6);
				if(amethystIs == true) {
					if (rand == 2) {
						amethystIs = false;
			    		rubyIs = true;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
			    	if (rand == 3) {
			    		amethystIs = true;
			    		rubyIs = false;
			    		blocksIs = true;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
			    	if (rand == 4) {
			    		amethystIs = false;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = true;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
			    	if (rand == 5) {
			    		amethystIs = false;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = true;
			    		uniqueIs = false;
			    	}
			    	if (rand == 6) {
			    		amethystIs = false;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = true;
			    	}
			    	amethystIs = false;
				}else {
					if (rand == 1) {
			    		amethystIs = true;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
					if (rand == 2) {
						amethystIs = false;
			    		rubyIs = true;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
			    	if (rand == 3) {
			    		amethystIs = true;
			    		rubyIs = false;
			    		blocksIs = true;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
			    	if (rand == 4) {
			    		amethystIs = true;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = true;
			    		mobsIs = false;
			    		uniqueIs = false;
			    	}
			    	if (rand == 5) {
			    		amethystIs = true;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = true;
			    		uniqueIs = false;
			    	}
			    	if (rand == 6) {
			    		amethystIs = true;
			    		rubyIs = false;
			    		blocksIs = false;
			    		decorIs = false;
			    		mobsIs = false;
			    		uniqueIs = true;
			    	}
				}
				
	    	}
	    	
	    }
	public boolean changeGui(World world, int x, int y, int z, EntityPlayer player) {
		player.openGui(Test.instance, 1, world, x, y, z);
		return true;
	}
	 @Override
	 public void initGui()
	 {
	  int centeredX = this.width / 2 - 35 / 2;
	  int centeredY = this.height / 2 - 19 / 2;
	  super.initGui();
	  this.buttonList.add(new GuiButton( 1, centeredX + 5, centeredY + 94, 25, 20, "Add"));
	 }
	 /**
	     * Called when the screen is unloaded. Used to disable keyboard repeat 
	     * events
	     */
	    @Override
	    public void onGuiClosed() 
	    {
	    	
			GuiShop.sumPrice = 0.0;
			GuiShop.sumPriceStr = "0.0";
	 	    ContainerShopCustom.isCreated = false;
	    }
	 public double getCost(ItemStack item) {
		 int item_length = item.stackSize;
		 if (item.getItem() == new ItemStack(Test.Amethyst).getItem()) {
			 return 10 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystHelmet).getItem()) {
			 return 90.25 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystChestplate).getItem()) {
			 return 73.6 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystPants).getItem()) {
			 return 64.4 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystBoots).getItem()) {
			 return 36.8 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystSword).getItem()) {
			 return 18.65 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystBow).getItem()) {
			 return 28.25 * item_length;
		 }
		 return 0.0;
		 
		 
		 
	 }
	 protected void actionPerformed(GuiButton B)
	 {
		 if(B.id == 1)
		 {
			 if (ContainerShop.isClear == false) {
				 if (ContainerShopCustom.slot1.getStack() != null) {
					 item1 = ContainerShopCustom.slot1.getStack();
					 item1_price = getCost(item1);
					 item1IsNull = false;
				 }
				 else {
				 		item1 = ContainerShopCustom.slot1.getStack();
				 		item1 = null;
				 		item1IsNull = true;
				 }
				 if (ContainerShopCustom.slot2.getStack() != null) {
					 item2 = ContainerShopCustom.slot2.getStack();
					 item2_price = getCost(item2);
					 item2IsNull = false;
					 
				 }
				 else {
				 		item2 = ContainerShopCustom.slot2.getStack();
				 		item2 = null;
				 		item2IsNull = true;
				 }
				 if (ContainerShopCustom.slot3.getStack() != null) {
					 item3 = ContainerShopCustom.slot3.getStack();
					 item3_price = getCost(item3);
					 item3IsNull = false;
				 }
				 else {
				 		item3 = ContainerShopCustom.slot3.getStack();
				 		item3 = null;
				 		item3IsNull = true;
				 }
				 if (ContainerShopCustom.slot4.getStack() != null) {
					 item4 = ContainerShopCustom.slot4.getStack();
					 item4_price = getCost(item4);
					 item4IsNull = false;
				 }
				 else {
				 		item4 = ContainerShopCustom.slot4.getStack();
				 		item4 = null;
				 		item4IsNull = true;
				 }
				 if (ContainerShopCustom.slot5.getStack() != null) {
					 item5 = ContainerShopCustom.slot5.getStack();
					 item5_price = getCost(item5);
					 item5IsNull = false;
				 }
				 else {
				 		item5 = ContainerShopCustom.slot5.getStack();
				 		item5 = null;
				 		item5IsNull = true;
				 }
				 if (ContainerShopCustom.slot6.getStack() != null) {
					 item6 = ContainerShopCustom.slot6.getStack();
					 item6_price = getCost(item6);
					 item6IsNull = false;
				 }
				 else {
				 		item6 = ContainerShopCustom.slot6.getStack();
				 		item6 = null;
				 		item6IsNull = true;
				 }
			 	 }

				 
				 ContainerShopCustom.chosen = true;
				 changeGui(wor,x2,y2,z2,pla);
		 }
	 }
	 
	ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth);
	private int remainingTimeLong = 3600;
	private int remainingTimeSeconds = 59;
	private int remainingTimeLongMin;
	private String remainingTimeMin;

    
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		
		this.fontRendererObj.drawString(remainingTimeMin + ":" + remainingTime , 143, this.ySize - 150, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l - 11, 0, 0, this.xSize, this.ySize + 110);
	        int i1;     
	}
	
}
