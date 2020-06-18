package seer.money.guihandlers;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.seer.money.Cents;
import ru.seer.money.Dollars;
import ru.seer.money.Shop;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
import ru.seer.money.Wallet;
import scala.Int;
import seer.money.containers.ContainerCashMachine;
import seer.money.containers.ContainerShop;
import seer.money.containers.ContainerShopCustom;
import seer.money.data.ExtendedPlayer;
import seer.money.guihandlers.GuiCashMachine.NextPageButton;
import seer.money.inventory.ContainerItem;
import seer.money.inventory.InventoryItem;
import seer.money.inventory.SlotItemInv;
import seer.money.rendering.tileentities.Cash_MachineTileEntity;
import seer.money.rendering.tileentities.safeTileEntity;

@SideOnly(Side.CLIENT)
public class GuiCashMachine extends GuiContainer {
	private final Random field_149955_b = new Random();
	private static final int bookTotalPages = 4;
    private static ResourceLocation[] bookPageTextures = 
            new ResourceLocation[bookTotalPages];
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("money", "textures/blocks/CashMachine.png");
	private Cash_MachineTileEntity tileFurnace;
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
	private Boolean isEnough = true;
	public static double amount;
	private double fee;
	private double result;
	public String amountStr;
	public String feeStr;
	public String resultStr;
	static double sumPrice;
	public Boolean che = false;
	private int inventoryRows;
	private double finalBalance;
	private ItemStack stack1;
	private ItemStack stack2;
	private ItemStack spstack1;
	private ItemStack spstack2;
	private ItemStack spstack3;
	private ItemStack spstack4;
	private ItemStack spstack5;
	private ItemStack spstack6;
	private ItemStack spstack7;
	private ItemStack spstack8;
	private ItemStack spstack9;
	private ItemStack spstack10;
	private ItemStack spstack11;
	private ItemStack spstack12;
	public static boolean isBought = false;
	public static boolean done = false;
	public static boolean opened = false;
	public static boolean isDeleted1 = false;
	private int counter = 0;
	private boolean allOk = false;
	static String sumPriceStr;
	
	public GuiCashMachine(InventoryPlayer invPlayer, Cash_MachineTileEntity tile, World world, EntityPlayer player, int x, int y, int z) {
		super(new ContainerCashMachine(invPlayer, tile, player));
		bookPageTextures[1] = new ResourceLocation(
        		"money:textures/gui/book.png");
		opened = true;
		stringPageText[0]="x0";
		stringPageText2[0]="x0";
		stringPageText3[0]="x0";
		stringPageText4[0]="x0";
		stringPageText5[0]="x0";
		stringPageText6[0]="x0";
		stringPageText7[0]="x0";
		this.inventoryRows = invPlayer.getSizeInventory() / 9;
		ExtendedPlayer props = ExtendedPlayer.get(player);	
		amount = props.currentMoney;
		stringPageText8[0]="x0";
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
		/*
		if (che == false) {
			player.openGui(Test.instance, 2, world, x, y, z);
		}else {
			player.openGui(Test.instance, 1, world, x, y, z);
			che = false;
			ContainerShop.isClear = false;
		}
		*/
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
		 opened = true;
		 
		 sumPrice = 0.0;
		 int centeredX = this.width / 2 - 35 / 2;
		 int centeredY = this.height / 2 - 19 / 2;
		 super.initGui();
		 // 131
		 // 88
		 String colorText = EnumChatFormatting.RED + "Apply";
		 
		 this.buttonList.add(new GuiButton( 1, centeredX - 64, centeredY - 10, 35, 18, "Apply"));
		 /*
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
		 */
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
	    	/*
			item1_price = 0.0;
	    	item2_price = 0.0;
	    	item3_price = 0.0;
	    	item4_price = 0.0;
	    	item5_price = 0.0;
	    	item6_price = 0.0;
	    	item1_type_amount = 0;
			sumPrice = 0.0;
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
	 	   */
	    }
	 public double getFinalBalance() {
		 finalBalance = 0.0;
		 for (int i = 0; i < 12; ++i)
		 {
			    boolean testIsNull = isSlotNull(ContainerItem.slotWallet,i);
				if (testIsNull == false) {
					 Wallet.isNull[i] = true;
					 if(i == 0) {
						 Wallet.delete = true;
						 Wallet.adelete = true;
						 Wallet.spdelete = true;
					 }if(i == 1) {
						 Wallet.delete2 = true;
						 Wallet.adelete2 = true;
						 Wallet.spdelete2 = true;
					 } if(i == 2) {
						 Wallet.delete3 = true;
						 Wallet.adelete3 = true;
						 Wallet.spdelete3 = true;
					 } if(i == 3) {
						 Wallet.delete4 = true;
						 Wallet.adelete4 = true;
						 Wallet.spdelete4 = true;
					 } if(i == 4) {
						 Wallet.delete5 = true;
						 Wallet.adelete5 = true;
						 Wallet.spdelete5 = true;
					 } if(i == 5) {
						 Wallet.delete6 = true;
						 Wallet.adelete6 = true;
						 Wallet.spdelete6 = true;
					 } if(i == 6) {
						 Wallet.delete7 = true;
						 Wallet.adelete7 = true;
						 Wallet.spdelete7 = true;
					 } if(i == 7) {
						 Wallet.delete8 = true;
						 Wallet.adelete8 = true;
						 Wallet.spdelete8 = true;
					 } if(i == 8) {
						 Wallet.delete9 = true;
						 Wallet.adelete9 = true;
						 Wallet.spdelete9 = true;
					 } if(i == 9) {
						 Wallet.delete10 = true;
						 Wallet.adelete10 = true;
						 Wallet.spdelete10 = true;
					 } if(i == 10) {
						 Wallet.delete11 = true;
						 Wallet.adelete11 = true;
						 Wallet.spdelete11 = true;
					 }if(i == 11) {
						 Wallet.delete12 = true;
						 Wallet.adelete12 = true;
						 Wallet.spdelete12 = true;
					 }
					Item slotWallet = ContainerItem.slotWallet.inventory.getStackInSlot(i).getItem();
					finalBalance = finalBalance + ContainerItem.slotWallet.inventory.getStackInSlot(i).stackSize;
					allOk  = true;
				}
		 }
		 if(allOk == true) {
			 fee = finalBalance * 0.05;
			 fee = round(fee,1);
			 finalBalance = finalBalance - fee;
			 allOk = false;
		 }
		 return finalBalance;
	 }
	 public boolean isAllSlotsNull(SlotItemInv slot) {
		 Boolean[] isSlotNull = new Boolean[13];
		 boolean check = true;
		 int isSlotNull_size = 0;
		 for (int i = 0; i < 12; ++i)
		 {
			 
			 if(isSlotNull(slot,i) == false) {
				 isSlotNull_size += 1;
			 }
				
		 }
		 if(isSlotNull_size == 0) {
			 check = true;
		 }else {
			 check = false;
		 }
		 return check;
	 }
	 public boolean isSlotNull(SlotItemInv slot, int id) {
		 boolean check = true;
		 ItemStack slotWallet = slot.inventory.getStackInSlot(id);
		 if (slotWallet != null) {
			 if(id == 0 && Wallet.adelete == false) {
				 check = false;
			 }
			 else if(id == 1 && Wallet.adelete2 == false) {
				 check = false;
			 }
			 else if(id == 2 && Wallet.adelete3 == false) {
				 check = false;
			 }
			 else if(id == 3 && Wallet.adelete4 == false) {
				 check = false;
			 }
			 else if(id == 4 && Wallet.adelete5 == false) {
				 check = false;
			 }
			 else if(id == 5 && Wallet.adelete6 == false) {
				 check = false;
			 }
			 else if(id == 6 && Wallet.adelete7 == false) {
				 check = false;
			 }
			 else if(id == 7 && Wallet.adelete8 == false) {
				 check = false;
			 }
			 else if(id == 8 && Wallet.adelete9 == false) {
				 check = false;
			 }
			 else if(id == 9 && Wallet.adelete10 == false) {
				 check = false;
			 }
			 else if(id == 10 && Wallet.adelete11 == false) {
				 check = false;
			 }
			 else if(id == 11 && Wallet.adelete12 == false) {
				 check = false;
			 }
			 
		 }else {
			 check = true;
		 }
		 return check;
	 }
	 protected void actionPerformed(GuiButton B)
	 { 
		 if(B.id == 1)
		 {
			 counter += 1;
			 if (Wallet.open == true) {
				  stack1 = ContainerCashMachine.slot4.inventory.getStackInSlot(0);
				  stack2 = ContainerCashMachine.slot5.inventory.getStackInSlot(1);
				  spstack1 = ContainerItem.slotWallet.inventory.getStackInSlot(0);
				  spstack2 = ContainerItem.slotWallet.inventory.getStackInSlot(1);
				  spstack3 = ContainerItem.slotWallet.inventory.getStackInSlot(2);
				  spstack4 = ContainerItem.slotWallet.inventory.getStackInSlot(3);
				  spstack5 = ContainerItem.slotWallet.inventory.getStackInSlot(4);
				  spstack6 = ContainerItem.slotWallet.inventory.getStackInSlot(5);
				  spstack7 = ContainerItem.slotWallet.inventory.getStackInSlot(6);
				  spstack8 = ContainerItem.slotWallet.inventory.getStackInSlot(7);
				  spstack9 = ContainerItem.slotWallet.inventory.getStackInSlot(8);
				  spstack10 = ContainerItem.slotWallet.inventory.getStackInSlot(9);
				  spstack11= ContainerItem.slotWallet.inventory.getStackInSlot(10);
				  spstack12 = ContainerItem.slotWallet.inventory.getStackInSlot(11);
			 }
			 
			if(stack1 != null && stack2 != null) {
				 if(Wallet.spdelete == false && spstack1 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete = false;
					 }
					 amount = props.currentMoney;
				 }
				 if(Wallet.spdelete2 == false && spstack2 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete2 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete3 == false && spstack3 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete3 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete4 == false && spstack4 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete4 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete5 == false && spstack5 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete5 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete6 == false && spstack6 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete6 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete7 == false && spstack7 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete7 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete8 == false && spstack8 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete8 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete9 == false && spstack9 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete9 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete10 == false && spstack10 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete10 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete11 == false && spstack11 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete11 = false;
					 }
					 amount = props.currentMoney;
				 } if(Wallet.spdelete12 == false && spstack12 != null) {
					 ExtendedPlayer props = ExtendedPlayer.get(pla);	
					 if(ContainerCashMachine.slot4.inventory.getStackInSlot(0).getItem() == Test.Wallet && ContainerCashMachine.slot5.inventory.getStackInSlot(1).getItem() == Test.Card ) {	
						 props.currentMoney += getFinalBalance();
						 finalBalance = 0.0;
						 opened = true;
						 Wallet.adelete12 = false;
						 
					 }
					 amount = props.currentMoney;
				 }
				 
			}
			if(counter < 12) {
				this.actionPerformed(B);
			}else if(counter >= 12) {
				counter = 0;
			}
		 } 
	 }
	 
	ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth);
	
	

    
	protected void drawGuiContainerForegroundLayer(int par1, int par2){
		mc.getTextureManager().bindTexture(bookPageTextures[1]);
		/*
		sumPrice = round(sumPrice,2);
	    
	    sumPriceStr = Double.toString(sumPrice);
	    */
		amount = round(amount,1);
		amountStr = Double.toString(amount);
		feeStr = Double.toString(fee);
	    this.fontRendererObj.drawString(amountStr, 7, this.ySize - 156, 4210752);
	    this.fontRendererObj.drawString("Balance", 7, this.ySize - 149, 4210752);
	    this.fontRendererObj.drawString("Fee", 72, this.ySize - 149, 4210752);
	    this.fontRendererObj.drawString(feeStr, 72, this.ySize - 156, 4210752);
	    /*
		this.fontRendererObj.drawString(amountStr, 7, this.ySize - 160, 4210752);
		this.fontRendererObj.drawString("Price", 6, this.ySize - 113, 4210752);
		this.fontRendererObj.drawString(sumPriceStr, 7, this.ySize - 123, 4210752);	
		this.fontRendererObj.drawString(stringPageText[0], 69, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText2[0], 95, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText3[0], 121, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText4[0], 147, this.ySize - 141, 4210752);	
		this.fontRendererObj.drawString(stringPageText5[0], 69, this.ySize - 112, 4210752);	
		this.fontRendererObj.drawString(stringPageText6[0], 95, this.ySize - 112, 4210752);	
		this.fontRendererObj.drawString(stringPageText7[0], 121, this.ySize - 112, 4210752);	
		this.fontRendererObj.drawString(stringPageText8[0], 147, this.ySize - 112, 4210752);
		*/
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
