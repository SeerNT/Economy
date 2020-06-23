package seer.money.guihandlers;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.seer.money.Shop;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
import ru.seer.money.Wallet;
import ru.seer.money.safe;
import seer.money.containers.ContainerShop;
import seer.money.containers.ContainerShopCustom;
import seer.money.data.ExtendedPlayer;
import seer.money.rendering.tileentities.PrinterTileEntity;
import seer.money.rendering.tileentities.safeTileEntity;

public class GuiShop extends GuiContainer {
	private final Random field_149955_b = new Random();
	private static final int bookTotalPages = 4;
    private static ResourceLocation[] bookPageTextures = 
            new ResourceLocation[bookTotalPages];
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("money", "textures/blocks/ShopGui.png");
	private ShopTileEntity tileFurnace;
	public World wor;
	public EntityPlayer pla;
	public int x2;
	public int y2;
	public int z2;
	public static IInventory a = Shop.iinventory;
	private EntityItem p_72838_1_;
	private EntityItem p_72838_2_;
	private EntityItem p_72838_3_;
	private EntityItem p_72838_4_;
	private EntityItem p_72838_5_;
	private EntityItem p_72838_6_;
	public static ItemStack item1;
	public static ItemStack item2;
	public static ItemStack item3;
	public static ItemStack item4;
	public static ItemStack item5;
	public static ItemStack item6;
	public static int item1_type_amount = 0;
	public static int item2_type_amount = 0;
	public static int item3_type_amount = 0;
	public static int item4_type_amount = 0;
	public static int item5_type_amount = 0;
	public static int item6_type_amount = 0;
	public static int item7_type_amount = 0;
	public static int item8_type_amount = 0;
	private NextPageButton buttonUp;
    private NextPageButton buttonDown;
    private NextPageButton buttonUp2;
    private NextPageButton buttonDown2;
    private NextPageButton buttonUp3;
    private NextPageButton buttonDown3;
    private NextPageButton buttonUp4;
    private NextPageButton buttonDown4;
    private NextPageButton buttonUp5;
    private NextPageButton buttonDown5;
    private NextPageButton buttonUp6;
    private NextPageButton buttonDown6;
    private NextPageButton buttonUp7;
    private NextPageButton buttonDown7;
    private NextPageButton buttonUp8;
    private NextPageButton buttonDown8;
    private static String[] stringPageText = new String[2];
    private static String[] stringPageText2 = new String[2];
    private static String[] stringPageText3 = new String[2];
    private static String[] stringPageText4 = new String[2];
    private static String[] stringPageText5 = new String[2];
    private static String[] stringPageText6 = new String[2];
    private static String[] stringPageText7 = new String[2];
    private static String[] stringPageText8 = new String[2];
    private int pageNumber = 0;
    private int pageNumber2 = 0;
    private int pageNumber3 = 0;
    private int pageNumber4 = 0;
    private int pageNumber5 = 0;
    private int pageNumber6 = 0;
    private int pageNumber7 = 0;
    private int pageNumber8 = 0;
    private static double item1_price = 9.2;
	private static double item2_price = 0.0;
	private static double item3_price = 0.0;
	private static double item4_price = 0.0;
	private static double item5_price = 0.0;
	private static double item6_price = 0.0;
	private static double item7_price = 0.0;
	private static double item8_price = 0.0;
	private Boolean isEnough = true;
	private double amount;
	public String amountStr;
	static double sumPrice = 0;
	static double sumPrice2 = 0;
	static double sumPrice3 = 0;
	static double sumPrice4 = 0;
	static double sumPrice5 = 0;
	static double sumPrice6 = 0;
	static double sumPrice7 = 0;
	static double sumPrice8 = 0;
	static double sumOfSumPrice;
	public Boolean che = false;
	private int inventoryRows;
	public static boolean isBought = false;
	public static boolean done = false;
	public static boolean isItem1FoundSlot = false;
	public static boolean isItem2FoundSlot = false;
	public static boolean isItem3FoundSlot = false;
	public static boolean isItem4FoundSlot = false;
	public static boolean isItem5FoundSlot = false;
	public static boolean isItem6FoundSlot = false;
	public static boolean isItem7FoundSlot = false;
	public static boolean isItem8FoundSlot = false;
	static String sumPriceStr;
	
	public GuiShop(InventoryPlayer invPlayer, ShopTileEntity tile, World world, EntityPlayer player, int x, int y, int z) {
		super(new ContainerShop(invPlayer, tile, player));
		bookPageTextures[1] = new ResourceLocation(
        		"money:textures/gui/book.png");
		stringPageText[0]="x0";
		stringPageText2[0]="x0";
		stringPageText3[0]="x0";
		stringPageText4[0]="x0";
		stringPageText5[0]="x0";
		stringPageText6[0]="x0";
		stringPageText7[0]="x0";
		this.inventoryRows = invPlayer.getSizeInventory() / 9;
		stringPageText8[0]="x0";
	    ExtendedPlayer props = ExtendedPlayer.get(player);	
	    amount = props.currentMoney;
		wor = world;
		pla = player;
		x2 = x;
		y2 = y;
		z2 = z;
		this.tileFurnace = tile;
		this.width = sr.getScaledWidth();
		this.height = sr.getScaledHeight();
		
	}
	@SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, 
              boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= xPosition 
                      && parY >= yPosition 
                      && parX < xPosition + width 
                      && parY < yPosition + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed)
                {
                    textureX += 23;
                }

                if (!isNextButton)
                {
                    textureY += 13;
                }

                drawTexturedModalRect(xPosition, yPosition, 
                      textureX, textureY, 
                      23, 13);
            }
        }
    }
	public boolean changeGui(World world, int x, int y, int z, EntityPlayer player) {
		if (che == false) {
			player.openGui(Test.instance, 2, world, x, y, z);
		}else {
			player.openGui(Test.instance, 1, world, x, y, z);
			che = false;
			ContainerShop.isClear = false;
		}
		
		return true;
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
	 @Override
	 public void initGui()
	 {
		 
		 sumPrice = 0.0;
		 int centeredX = this.width / 2 - 35 / 2;
		 int centeredY = this.height / 2 - 19 / 2;
		 super.initGui();
		 // 131
		 // 88
		 String colorText = EnumChatFormatting.RED + "Apply";
		 this.buttonList.add(new GuiButton( 1, centeredX - 64, centeredY - 10, 35, 18, "Apply"));
		 this.buttonList.add(new GuiButton( 2, centeredX + 64, centeredY - 10, 35, 18, "Open..."));
		 this.buttonList.add(buttonUp= new NextPageButton(3, centeredX + 28, centeredY - 60, true));
		 this.buttonList.add(buttonUp2= new NextPageButton(4, centeredX + 28, centeredY - 72, false));
		 this.buttonList.add(buttonUp3= new NextPageButton(5, centeredX + 2, centeredY - 60, true));
		 this.buttonList.add(buttonUp4= new NextPageButton(6, centeredX + 2, centeredY - 72, false));
		 this.buttonList.add(buttonUp5= new NextPageButton(7, centeredX + 55, centeredY - 60, true));
		 this.buttonList.add(buttonUp6= new NextPageButton(8, centeredX + 55, centeredY - 72, false));
		 this.buttonList.add(buttonUp7= new NextPageButton(9, centeredX + 81, centeredY - 60, true));
		 this.buttonList.add(buttonUp8= new NextPageButton(10, centeredX + 81, centeredY - 72, false));
		 
		 this.buttonList.add(buttonDown= new NextPageButton(11, centeredX + 28, centeredY - 31, true));
		 this.buttonList.add(buttonDown2= new NextPageButton(12, centeredX + 28, centeredY - 43, false));
		 this.buttonList.add(buttonDown3= new NextPageButton(13, centeredX + 2, centeredY - 31, true));
		 this.buttonList.add(buttonDown4= new NextPageButton(14, centeredX + 2, centeredY - 43, false));
		 this.buttonList.add(buttonDown5= new NextPageButton(15, centeredX + 55, centeredY - 31, true));
		 this.buttonList.add(buttonDown6= new NextPageButton(16, centeredX + 55, centeredY - 43, false));
		 this.buttonList.add(buttonDown7= new NextPageButton(17, centeredX + 81, centeredY - 31, true));
		 this.buttonList.add(buttonDown8= new NextPageButton(18, centeredX + 81, centeredY - 43, false));
	 }
	 /**
	     * Called when the screen is unloaded. Used to disable keyboard repeat 
	     * events
	     */
	    @Override
	    public void onGuiClosed() 
	    {
	    	//ContainerShop.slot3.inventory.setInventorySlotContents(0, null);
			//ContainerShop.slot3.inventory.setInventorySlotContents(1, null);
			//ContainerShop.slot3.inventory.setInventorySlotContents(2, null);
			//ContainerShop.slot3.inventory.setInventorySlotContents(3, null);
			//ContainerShop.slot3.inventory.setInventorySlotContents(4, null);
			//ContainerShop.slot3.inventory.setInventorySlotContents(5, null);
			item1_price = 0.0;
	    	item2_price = 0.0;
	    	item3_price = 0.0;
	    	item4_price = 0.0;
	    	item5_price = 0.0;
	    	item6_price = 0.0;
	    	item7_price = 0.0;
	    	item8_price = 0.0;
	    	item1_type_amount = 0;
	    	item2_type_amount = 0;
	    	item3_type_amount = 0;
	    	item4_type_amount = 0;
	    	item5_type_amount = 0;
	    	item6_type_amount = 0;
	    	item7_type_amount = 0;
	    	item8_type_amount = 0;
			sumPrice = 0.0;
			sumPrice2 = 0.0;
			sumPrice3 = 0.0;
			sumPrice4 = 0.0;
			sumPrice5 = 0.0;
			sumPrice6 = 0.0;
			sumPrice7 = 0.0;
			sumPrice8 = 0.0;
			sumOfSumPrice = 0.0;
			sumPriceStr = "0.0";
			ContainerShop.isSlotNull1 = true;
			ContainerShop.isSlotNull2 = true;
			ContainerShop.isSlotNull3 = true;
			ContainerShop.isSlotNull4 = true;
			ContainerShop.isSlotNull5 = true;
			ContainerShop.isSlotNull6 = true;
			GuiShopCustom.item1 = null;
			GuiShopCustom.item1IsNull = true;
			GuiShopCustom.item2 = null;
			GuiShopCustom.item2IsNull = true;
			GuiShopCustom.item3 = null;
	 		GuiShopCustom.item3IsNull = true;
	 		GuiShopCustom.item4 = null;
	 		GuiShopCustom.item4IsNull = true;
	 		GuiShopCustom.item5 = null;
	 		GuiShopCustom.item5IsNull = true;
	 		GuiShopCustom.item6 = null;
	 		GuiShopCustom.item6IsNull = true;
	 	   ContainerShopCustom.isCreated = false;
	    }
	 public boolean isAllSlotsInSafeAreNotNull() {
		 if(safe.isOpened == false) {
			 return false;
		 }else {
			 int f = 0;
			 for(int i = 0; i <= 27; i ++) {
				 if(safe.iinventory.getStackInSlot(i) != null) {
					 f++;
				 }
			 }
			 if(f >= 27) {
				 return true;
			 }else {
				 return false;
			 }
		 }
	 }
	 public boolean putItemInSlot(ItemStack item1, ItemStack item2, ItemStack item3, ItemStack item4, ItemStack item5, ItemStack item6, ItemStack item7, ItemStack item8) {
		 if(isAllSlotsInSafeAreNotNull() == true) {
			 sumPriceStr = "NOT ENOUGH";
			 int centeredX = this.width / 2 - 35 / 2;
			 int centeredY = this.height / 2 - 19 / 2;
			 String colorText = EnumChatFormatting.RED + "Apply";
			 this.buttonList.add(new GuiButton(19, centeredX - 64, centeredY - 10, 35, 18, colorText));
			 return false;
		 }else {
			 if(safe.isOpened == false) {
				 return false;
			 }else {
				 if(safe.iinventory.getStackInSlot(0) == null) {
					 if(item1 != null) {
						 safe.iinventory.setInventorySlotContents(0, item1);
						 isItem1FoundSlot = true;
					 }
				 }
				 if(safe.iinventory.getStackInSlot(1) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(1, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(1, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(2) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(2, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(2, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(2, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(3) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(3, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(3, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(3, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(3, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(4) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(4, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(4, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(4, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(4, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(4, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(5) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(5, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(5, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(5, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(5, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(5, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(5, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(6) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(6, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(6, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(6, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(6, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(6, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(6, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(6, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(7) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(7, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(7, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(7, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(7, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(7, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(7, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(7, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(7, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(8) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(8, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(8, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(8, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(8, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(8, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(8, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(8, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(8, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(9) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(9, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(9, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(9, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(9, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(9, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(9, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(9, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(9, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(10) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(10, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(10, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(10, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(10, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(10, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(10, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(10, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(10, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(11) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(11, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(11, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(11, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(11, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(11, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(11, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(11, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(11, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(12) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(12, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(12, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(12, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(12, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(12, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(12, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(12, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(12, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(13) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(13, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(13, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(13, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(13, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(13, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(13, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(13, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(13, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(14) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(14, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(14, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(14, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(14, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(14, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(14, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(14, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(14, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(15) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(15, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(15, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(15, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(15, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(15, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(15, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(15, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(15, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(16) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(16, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(16, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(16, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(16, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(16, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(16, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(16, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(16, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(17) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(17, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(17, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(17, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(17, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(17, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(17, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(17, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(17, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(18) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(18, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(18, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(18, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(18, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(18, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(15, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(18, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(18, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(19) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(19, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(19, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(19, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(19, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(19, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(19, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(19, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(19, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(20) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(20, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(20, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(20, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(20, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(20, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(20, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(20, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(20, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(21) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(21, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(21, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(21, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(21, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(21, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(21, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(21, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(21, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(22) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(22, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(22, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(22, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(22, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(22, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(22, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(22, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(22, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(23) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(23, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(23, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(23, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(23, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(23, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(23, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(23, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(23, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(24) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(24, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(24, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(24, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(24, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(24, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(24, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(24, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(24, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(25) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(25, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(25, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(25, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(25, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(25, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(25, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(25, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(25, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(26) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(26, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(26, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(26, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(26, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(26, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(26, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(26, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(26, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 if(safe.iinventory.getStackInSlot(27) == null) {
					 if(isItem1FoundSlot == false) {
						 if(item1 != null) {
							 safe.iinventory.setInventorySlotContents(27, item1);
							 isItem1FoundSlot = true;
						 } 
					 }
					 else if(isItem2FoundSlot == false) {
						 if(item2 != null) {
							 safe.iinventory.setInventorySlotContents(27, item2);
							 isItem2FoundSlot = true;
						 } 
					 }
					 else if(isItem3FoundSlot == false) {
						 if(item3 != null) {
							 safe.iinventory.setInventorySlotContents(27, item3);
							 isItem3FoundSlot = true;
						 } 
					 }
					 else if(isItem4FoundSlot == false) {
						 if(item4 != null) {
							 safe.iinventory.setInventorySlotContents(27, item4);
							 isItem4FoundSlot = true;
						 } 
					 }
					 else if(isItem5FoundSlot == false) {
						 if(item5 != null) {
							 safe.iinventory.setInventorySlotContents(27, item5);
							 isItem5FoundSlot = true;
						 } 
					 }
					 else if(isItem6FoundSlot == false) {
						 if(item6 != null) {
							 safe.iinventory.setInventorySlotContents(27, item6);
							 isItem6FoundSlot = true;
						 } 
					 }
					 else if(isItem7FoundSlot == false) {
						 if(item7 != null) {
							 safe.iinventory.setInventorySlotContents(27, item7);
							 isItem7FoundSlot = true;
						 } 
					 }
					 else if(isItem8FoundSlot == false) {
						 if(item8 != null) {
							 safe.iinventory.setInventorySlotContents(27, item8);
							 isItem8FoundSlot = true;
						 } 
					 }
					 
				 }
				 return true;
			 }
		 }
		 
	 }
	 protected void actionPerformed(GuiButton B)
	 {
		 if(B.id == 1)
		 {
			 //if item_amount == null then item == null hehe
			 putItemInSlot(new ItemStack(Test.Amethyst,item1_type_amount),new ItemStack(Test.Amethyst,item2_type_amount),new ItemStack(Test.Amethyst,item3_type_amount),new ItemStack(Test.Amethyst,item4_type_amount),new ItemStack(Test.Amethyst,item5_type_amount),new ItemStack(Test.Amethyst,item6_type_amount),new ItemStack(Test.Amethyst,item7_type_amount),new ItemStack(Test.Amethyst,item8_type_amount));
			 isItem1FoundSlot = false;
			 isItem2FoundSlot = false;
			 isItem3FoundSlot = false;
			 isItem4FoundSlot = false;
			 isItem5FoundSlot = false;
			 isItem6FoundSlot = false;
			 isItem7FoundSlot = false;
			 isItem8FoundSlot = false;
			 
			 float f = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
             float f1 = this.field_149955_b.nextFloat() * 0.8F + 0.1F;
             // Not enough money -> dont give money
             
			 if (amount < sumOfSumPrice) {
				 sumPriceStr = "NOT ENOUGH";
				 int centeredX = this.width / 2 - 35 / 2;
				 int centeredY = this.height / 2 - 19 / 2;
				 String colorText = EnumChatFormatting.RED + "Apply";
				 this.buttonList.add(new GuiButton(19, centeredX - 64, centeredY - 10, 35, 18, colorText));
				 this.updateScreen();
				 isBought = false;
				 
			 }else {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);
				     double value = props.currentMoney;
				     value = value - sumOfSumPrice;
				     round(value,2);
				     props.currentMoney = value;
				     isBought = true;
				 this.updateScreen();
				
			 }
			 
	    	 this.updateScreen();
		 }
		 if(B.id == 2) 
		 {
			 /*
			ContainerShop.slot3.inventory.setInventorySlotContents(0, null);
			ContainerShop.slot3.inventory.setInventorySlotContents(1, null);
			ContainerShop.slot3.inventory.setInventorySlotContents(2, null);
			ContainerShop.slot3.inventory.setInventorySlotContents(3, null);
			ContainerShop.slot3.inventory.setInventorySlotContents(4, null);
			ContainerShop.slot3.inventory.setInventorySlotContents(5, null);
			ContainerShop.isSlotNull1 = true;
			ContainerShop.isSlotNull2 = true;
			ContainerShop.isSlotNull3 = true;
			ContainerShop.isSlotNull4 = true;
			ContainerShop.isSlotNull5 = true;
			ContainerShop.isSlotNull6 = true;
			GuiShopCustom.item1 = null;
			GuiShopCustom.item1IsNull = true;
			GuiShopCustom.item2 = null;
			GuiShopCustom.item2IsNull = true;
			GuiShopCustom.item3 = null;
	 		GuiShopCustom.item3IsNull = true;
	 		GuiShopCustom.item4 = null;
	 		GuiShopCustom.item4IsNull = true;
	 		GuiShopCustom.item5 = null;
	 		GuiShopCustom.item5IsNull = true;
	 		GuiShopCustom.item6 = null;
	 		GuiShopCustom.item6IsNull = true;
			changeGui(wor,x2,y2,z2,pla);
			*/
		 }
		 // First ButtonCollection
		 if (B == buttonUp3)
	     {	
			 	item1_price = 9.2;
	        	--pageNumber;
	        	--item1_type_amount;
	        	if (pageNumber < 0) {
	        		pageNumber = 64;
	        		item1_type_amount = 64;
	        	}
	        	if(pageNumber > 64) {
	        		pageNumber = 0;
	        		item1_type_amount = 0;
	        	}
	        	sumPrice = item1_price * item1_type_amount;
	        	item1_price = 0.0;
	        	stringPageText[0]="x" + String.valueOf(pageNumber);
	        	this.updateScreen();
	     }
	     else if (B == buttonUp4)
	     {
	    	 	item1_price = 9.2;
	        	++pageNumber;
	        	++item1_type_amount;
	        	if (pageNumber < 0) {
	        		pageNumber = 64;
	        		item1_type_amount = 64;
	        	}
	        	if(pageNumber > 64) {
	        		pageNumber = 0;
	        		item1_type_amount = 0;
	        	}
	        	sumPrice = item1_price * item1_type_amount;
	        	item1_price = 0.0;
	            stringPageText[0]="x" +String.valueOf(pageNumber);
	            this.updateScreen();
	     }
		 // Second ButtonCollection
	     else if (B == buttonUp)
	     {	
	        	item2_price = 9.2;
	        	--pageNumber2;
	        	--item2_type_amount;
	        	if (pageNumber2 < 0) {
	        		pageNumber2 = 64;
	        		item2_type_amount = 64;
	        	}
	        	if(pageNumber2 > 64) {
	        		pageNumber2 = 0;
	        		item2_type_amount = 0;
	        	}
	        	sumPrice2 = item2_price * item2_type_amount;
	        	item2_price = 0.0;
	        	stringPageText2[0]="x" + String.valueOf(pageNumber2);
	        	this.updateScreen();
	     }
	     else if (B == buttonUp2)
	     {
	    	    item2_price = 9.2;
	        	++pageNumber2;
	        	++item2_type_amount;
	        	if (pageNumber2 < 0) {
	        		pageNumber2 = 64;
	        		item2_type_amount = 64;
	        	}
	        	if(pageNumber2 > 64) {
	        		pageNumber2 = 0;
	        		item2_type_amount = 0;
	        	}
	        	sumPrice2 = item2_price * item2_type_amount;
	        	item2_price = 0.0;
	        	stringPageText2[0]="x" + String.valueOf(pageNumber2);
	        	this.updateScreen();
	     }
		 // Third ButtonCollection
	     else if (B == buttonUp5)
	     {	
	    	    item3_price = 9.2;
	        	--pageNumber3;
	        	--item3_type_amount;
	        	if (pageNumber3 < 0) {
	        		pageNumber3 = 64;
	        		item3_type_amount = 64;
	        	}
	        	if(pageNumber3 > 64) {
	        		pageNumber3 = 0;
	        		item3_type_amount = 0;
	        	}
	        	sumPrice3 = item3_price * item3_type_amount;
	        	item3_price = 0.0;
	        	stringPageText3[0]="x" + String.valueOf(pageNumber3);
	        	this.updateScreen();
	     }
	     else if (B == buttonUp6)
	     {
	    	    item3_price = 9.2;
	        	++pageNumber3;
	        	++item3_type_amount;
	        	if (pageNumber3 < 0) {
	        		pageNumber3 = 64;
	        		item3_type_amount = 64;
	        	}
	        	if(pageNumber3 > 64) {
	        		pageNumber3 = 0;
	        		item3_type_amount = 0;
	        	}
	        	sumPrice3 = item3_price * item3_type_amount;
	        	item3_price = 0.0;
	        	stringPageText3[0]="x" + String.valueOf(pageNumber3);
	        	this.updateScreen();
	     }
		 // Fourth ButtonCollection
	     else if (B == buttonUp7)
	     {	
	    	    item4_price = 9.2;
	        	--pageNumber4;
	        	--item4_type_amount;
	        	if (pageNumber4 < 0) {
	        		pageNumber4 = 64;
	        		item4_type_amount = 64;
	        	}
	        	if(pageNumber4 > 64) {
	        		pageNumber4 = 0;
	        		item4_type_amount = 0;
	        	}
	        	sumPrice4 = item4_price * item4_type_amount;
	        	item4_price = 0.0;
	        	stringPageText4[0]="x" + String.valueOf(pageNumber4);
	        	this.updateScreen();
	     }
	     else if (B == buttonUp8)
	     {
	    	    item4_price = 9.2;
	        	++pageNumber4;
	        	++item4_type_amount;
	        	if (pageNumber4 < 0) {
	        		pageNumber4 = 64;
	        		item4_type_amount = 64;
	        	}
	        	if(pageNumber4 > 64) {
	        		pageNumber4 = 0;
	        		item4_type_amount = 0;
	        	}
	        	sumPrice4 = item4_price * item4_type_amount;
	        	item4_price = 0.0;
	        	stringPageText4[0]="x" + String.valueOf(pageNumber4);
	        	this.updateScreen();
	     }
		 
		 // 5 ButtonCollection
				 if (B == buttonDown3)
			     {	
					    item5_price = 9.2;
			        	--pageNumber5;
			        	--item5_type_amount;
			        	if (pageNumber5 < 0) {
			        		pageNumber5 = 64;
			        		item5_type_amount = 64;
			        	}
			        	if(pageNumber5 > 64) {
			        		pageNumber5= 0;
			        		item5_type_amount = 0;
			        	}
			        	sumPrice5 = item5_price * item5_type_amount;
			        	item5_price = 0.0;
			        	stringPageText5[0]="x" + String.valueOf(pageNumber5);
			        	this.updateScreen();
			     }
			     else if (B == buttonDown4)
			     {
			    	    item5_price = 9.2;
			        	++pageNumber5;
			        	++item5_type_amount;
			        	if (pageNumber5 < 0) {
			        		pageNumber5 = 64;
			        		item5_type_amount = 64;
			        	}
			        	if(pageNumber5 > 64) {
			        		pageNumber5= 0;
			        		item5_type_amount = 0;
			        	}
			        	sumPrice5 = item5_price * item5_type_amount;
			        	item5_price = 0.0;
			        	stringPageText5[0]="x" + String.valueOf(pageNumber5);
			        	this.updateScreen();
			     }
				 // 6 ButtonCollection
			     else if (B == buttonDown)
			     {	
			    	    item6_price = 9.2;
			        	--pageNumber6;
			        	--item6_type_amount;
			        	if (pageNumber6 < 0) {
			        		pageNumber6 = 64;
			        		item6_type_amount = 64;
			        	}
			        	if(pageNumber6 > 64) {
			        		pageNumber6= 0;
			        		item6_type_amount = 0;
			        	}
			        	sumPrice6 = item6_price * item6_type_amount;
			        	item6_price = 0.0;
			        	stringPageText6[0]="x" + String.valueOf(pageNumber6);
			        	this.updateScreen();
			     }
			     else if (B == buttonDown2)
			     {
			    	 item6_price = 9.2;
			        	++pageNumber6;
			        	++item6_type_amount;
			        	if (pageNumber6 < 0) {
			        		pageNumber6 = 64;
			        		item6_type_amount = 64;
			        	}
			        	if(pageNumber6 > 64) {
			        		pageNumber6= 0;
			        		item6_type_amount = 0;
			        	}
			        	sumPrice6 = item6_price * item6_type_amount;
			        	item6_price = 0.0;
			        	stringPageText6[0]="x" + String.valueOf(pageNumber6);
			        	this.updateScreen();
			     }
				 // 7 ButtonCollection
			     else if (B == buttonDown5)
			     {	
			    	 item7_price = 9.2;
			        	--pageNumber7;
			        	--item7_type_amount;
			        	if (pageNumber7 < 0) {
			        		pageNumber7 = 64;
			        		item7_type_amount = 64;
			        	}
			        	if(pageNumber7 > 64) {
			        		pageNumber7= 0;
			        		item7_type_amount = 0;
			        	}
			        	sumPrice7 = item7_price * item7_type_amount;
			        	item7_price = 0.0;
			        	stringPageText7[0]="x" + String.valueOf(pageNumber7);
			        	this.updateScreen();
			     }
			     else if (B == buttonDown6)
			     {
			    	 item7_price = 9.2;
			        	++pageNumber7;
			        	++item7_type_amount;
			        	if (pageNumber7 < 0) {
			        		pageNumber7 = 64;
			        		item7_type_amount = 64;
			        	}
			        	if(pageNumber7 > 64) {
			        		pageNumber7= 0;
			        		item7_type_amount = 0;
			        	}
			        	sumPrice7 = item7_price * item7_type_amount;
			        	item7_price = 0.0;
			        	stringPageText7[0]="x" + String.valueOf(pageNumber7);
			        	this.updateScreen();
			     }
				 // 8 ButtonCollection
			     else if (B == buttonDown7)
			     {	
			    	 item8_price = 9.2;
			        	--pageNumber8;
			        	--item8_type_amount;
			        	if (pageNumber8 < 0) {
			        		pageNumber8 = 64;
			        		item8_type_amount = 64;
			        	}
			        	if(pageNumber8 > 64) {
			        		pageNumber8= 0;
			        		item8_type_amount = 0;
			        	}
			        	sumPrice8 = item8_price * item8_type_amount;
			        	item8_price = 0.0;
			        	stringPageText8[0]="x" + String.valueOf(pageNumber8);
			        	this.updateScreen();
			     }
			     else if (B == buttonDown8)
			     {
			    	 item8_price = 9.2;
			        	++pageNumber8;
			        	++item8_type_amount;
			        	if (pageNumber8 < 0) {
			        		pageNumber8 = 64;
			        		item8_type_amount = 64;
			        	}
			        	if(pageNumber8 > 64) {
			        		pageNumber8= 0;
			        		item8_type_amount = 0;
			        	}
			        	sumPrice8 = item8_price * item8_type_amount;
			        	item8_price = 0.0;
			        	stringPageText8[0]="x" + String.valueOf(pageNumber8);
			        	this.updateScreen();
			     }
		 this.updateScreen();
			    
		 
	 }
	 
	ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth);
	
	

    
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		mc.getTextureManager().bindTexture(bookPageTextures[1]);
		sumPrice = round(sumPrice,2);
		sumOfSumPrice = sumPrice + sumPrice2 + sumPrice3 + sumPrice4 + sumPrice5 + sumPrice6 + sumPrice7 + sumPrice8;
		sumOfSumPrice = round(sumOfSumPrice,2);
	    amountStr = Double.toString(amount);
	    sumPriceStr = Double.toString(sumOfSumPrice);
	    this.fontRendererObj.drawString("Balance", 6, this.ySize - 145, 4210752);
		this.fontRendererObj.drawString(amountStr, 7, this.ySize - 153, 4210752);
		this.fontRendererObj.drawString("Price", 6, this.ySize - 110, 4210752);
		this.fontRendererObj.drawString(sumPriceStr, 7, this.ySize - 118, 4210752);	
		this.fontRendererObj.drawString(stringPageText[0], 69, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText2[0], 95, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText3[0], 121, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText4[0], 147, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText5[0], 69, this.ySize - 112, 4210752);	
		this.fontRendererObj.drawString(stringPageText6[0], 95, this.ySize - 112, 4210752);	
		this.fontRendererObj.drawString(stringPageText7[0], 121, this.ySize - 112, 4210752);	
		this.fontRendererObj.drawString(stringPageText8[0], 147, this.ySize - 112, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		mc.getTextureManager().bindTexture(bookPageTextures[1]);
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	        int i1;     
	}
}
