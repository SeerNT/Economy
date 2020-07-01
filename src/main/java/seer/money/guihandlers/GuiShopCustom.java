package seer.money.guihandlers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
import ru.seer.money.safe;
import seer.money.containers.ContainerShop;
import seer.money.containers.ContainerShopCustom;

public class GuiShopCustom extends GuiContainer {
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation("money", "textures/gui/CustomGui.png");
	private static ResourceLocation[] bookPageTextures = 
            new ResourceLocation[4];
	private ShopTileEntity tileFurnace;
	public World wor;
	public EntityPlayer pla;
	public int x2;
	public int y2;
	public int z2;
	public static Boolean ck = false;
	public static String time;
	// Для слотов
	public static Boolean amethystIs = true;
	public static Boolean rubyIs = false;
	public static Boolean blocksIs = false;
	public static Boolean decorIs = false;
	public static Boolean mobsIs = false;
	public static Boolean uniqueIs = false;
	public static Item item1 = Test.Amethyst;
	public static Item item2 = Test.Amethyst;
	public static Item item3 = Test.Amethyst;
	public static Item item4 = Test.Amethyst;
	public static Item item5 = Test.Amethyst;
	public static Item item6 = Test.Amethyst;
	public static Item item7 = Test.Amethyst;
	public static Item item8 = Test.Amethyst;
	public static boolean isItem1FoundSlot = false;
	public static boolean isItem2FoundSlot = false;
	public static boolean isItem3FoundSlot = false;
	public static boolean isItem4FoundSlot = false;
	public static boolean isItem5FoundSlot = false;
	public static boolean isItem6FoundSlot = false;
	public static boolean isItem7FoundSlot = false;
	public static boolean isItem8FoundSlot = false;
	private PlusButton button1;
	private PlusButton button2;
	private PlusButton button3;
	private PlusButton button4;
	private PlusButton button5;
	private PlusButton button6;
	private PlusButton button7;
	private PlusButton button8;
	private PlusButton button9;
	private PlusButton button10;
	private PlusButton button11;
	private PlusButton button12;
	private PlusButton button13;
	private PlusButton button14;
	private PlusButton button15;
	private PlusButton button16;
	private PlusButton button17;
	private PlusButton button18;
	private PlusButton button19;
	private PlusButton button20;
	private PlusButton button21;
	private PlusButton button22;
	private PlusButton button23;
	private PlusButton button24;
	private PlusButton button25;
	private PlusButton button26;
	private PlusButton button27;
	private PlusButton button28;
	private PlusButton button29;
	private PlusButton button30;
	public static double item1_price = 0.0;
	public static double item2_price = 0.0;
	public static double item3_price = 0.0;
	public static double item4_price = 0.0;
	public static double item5_price = 0.0;
	public static double item6_price = 0.0;
	public static double item7_price = 0.0;
	public static double item8_price = 0.0;
	public static Item customItem1;
	public static Item customItem2;
	public static Item customItem3;
	public static Item customItem4;
	public static Item customItem5;
	public static Item customItem6;
	public static Item customItem7;
	public static Item customItem8;
	
	
	public GuiShopCustom(InventoryPlayer inventory, ShopTileEntity tileEntityTestContainer, World world, EntityPlayer player, int x, int y, int z) {
		super(new ContainerShopCustom(inventory, tileEntityTestContainer));
		bookPageTextures[1] = new ResourceLocation(
        		"money:textures/gui/PlusButton.png");
		this.tileFurnace = tileEntityTestContainer;
		this.width = sr.getScaledWidth();
		this.height = sr.getScaledHeight();
		customItem1 = Test.Amethyst;
		customItem2 = Test.Amethyst;
		customItem3 = Test.Amethyst;
		customItem4 = Test.Amethyst;
		customItem5 = Test.Amethyst;
		customItem6 = Test.Amethyst;
		customItem7 = Test.Amethyst;
		customItem8 = Test.Amethyst;
		wor = world;
		pla = player;
		x2 = x;
		y2 = y;
		z2 = z;
	}
	@SideOnly(Side.CLIENT)
    static class PlusButton extends GuiButton
    {
        private final boolean isNextButton;

        public PlusButton(int parButtonId, int parPosX, int parPosY, 
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
		player.openGui(Test.instance, 1, world, x, y, z);
		return true;
	}
	 @Override
	 public void initGui()
	 {
	  int centeredX = this.width / 2 - 35 / 2;
	  int centeredY = this.height / 2 - 19 / 2;
	  super.initGui();
	  this.buttonList.add(new GuiButton( 1, centeredX - 3, centeredY + 94, 38, 20, "Continue"));
	  this.buttonList.add(button1 = new PlusButton( 2, centeredX - 62, centeredY - 29, false));
	  this.buttonList.add(button2 = new PlusButton( 3, centeredX - 36, centeredY - 29, false));
	  this.buttonList.add(button3 = new PlusButton( 4, centeredX - 9, centeredY - 29, false));
	  this.buttonList.add(button4 = new PlusButton( 5, centeredX + 17, centeredY - 29, false));
	  this.buttonList.add(button5 = new PlusButton( 6, centeredX + 43, centeredY - 29, false));
	  this.buttonList.add(button6 = new PlusButton( 7, centeredX + 69, centeredY - 29, false));
	  
	  this.buttonList.add(button7 = new PlusButton( 8, centeredX - 62, centeredY - 59, false));
	  this.buttonList.add(button8 = new PlusButton( 9, centeredX - 36, centeredY - 59, false));
	  this.buttonList.add(button9 = new PlusButton( 10, centeredX - 9, centeredY - 59, false));
	  this.buttonList.add(button10 = new PlusButton( 11, centeredX + 17, centeredY - 59, false));
	  this.buttonList.add(button11 = new PlusButton( 12, centeredX + 43, centeredY - 59, false));
	  this.buttonList.add(button12 = new PlusButton( 13, centeredX + 69, centeredY - 59, false));
	  
	  this.buttonList.add(button13 = new PlusButton( 14, centeredX - 62, centeredY + 1, false));
	  this.buttonList.add(button14 = new PlusButton( 15, centeredX - 36, centeredY + 1, false));
	  this.buttonList.add(button15 = new PlusButton( 16, centeredX - 9, centeredY + 1, false));
	  this.buttonList.add(button16 = new PlusButton( 17, centeredX + 17, centeredY + 1, false));
	  this.buttonList.add(button17 = new PlusButton( 18, centeredX + 43, centeredY + 1, false));
	  this.buttonList.add(button18 = new PlusButton( 19, centeredX + 69, centeredY + 1, false));
	  
	  this.buttonList.add(button19 = new PlusButton( 20, centeredX - 62, centeredY + 30, false));
	  this.buttonList.add(button20 = new PlusButton( 21, centeredX - 36, centeredY + 30, false));
	  this.buttonList.add(button21 = new PlusButton( 22, centeredX - 9, centeredY + 30, false));
	  this.buttonList.add(button22 = new PlusButton( 23, centeredX + 17, centeredY + 30, false));
	  this.buttonList.add(button23 = new PlusButton( 24, centeredX + 43, centeredY + 30, false));
	  this.buttonList.add(button24 = new PlusButton( 25, centeredX + 69, centeredY + 30, false));
	  
	  this.buttonList.add(button25 = new PlusButton( 26, centeredX - 62, centeredY + 59, false));
	  this.buttonList.add(button26 = new PlusButton( 27, centeredX - 36, centeredY + 59, false));
	  this.buttonList.add(button27 = new PlusButton( 28, centeredX - 9, centeredY + 59, false));
	  this.buttonList.add(button28 = new PlusButton( 29, centeredX + 17, centeredY + 59, false));
	  this.buttonList.add(button29 = new PlusButton( 30, centeredX + 43, centeredY + 59, false));
	  this.buttonList.add(button30 = new PlusButton( 31, centeredX + 69, centeredY + 59, false));
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
	 public static double getCost(ItemStack item) {
		 int item_length = item.stackSize;
		 if (item.getItem() == new ItemStack(Items.diamond).getItem()) {
			 return 6.4 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.emerald).getItem()) {
			 return 7.4 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Test.Amethyst).getItem()) {
			 return 9.2 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Test.Ruby).getItem()) {
			 return 22.2 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.RubyHelmet).getItem()) {
			 return 111 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.RubyChestplate).getItem()) {
			 return 177.6 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.RubyPants).getItem()) {
			 return 155.4 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.RubyBoots).getItem()) {
			 return 88.8 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.RubyPickaxe).getItem()) {
			 return 67 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Test.Sapphire).getItem()) {
			 return 16.2 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Test.Opal).getItem()) {
			 return 36.2 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.OpalHelmet).getItem()) {
			 return 181 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.OpalChestplate).getItem()) {
			 return 289.6 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.OpalPants).getItem()) {
			 return 253.4 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.OpalBoots).getItem()) {
			 return 144.8 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.ender_eye).getItem()) {
			 return 21 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.experience_bottle).getItem()) {
			 return 20 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.nether_star).getItem()) {
			 return 45 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.saddle).getItem()) {
			 return 16 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.skull).getItem()) {
			 return 28 * item_length;
		 }
		 if (item.getItem() == new ItemStack(Items.magma_cream).getItem()) {
			 return 7 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystHelmet).getItem()) {
			 return 44 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystChestplate).getItem()) {
			 return 73.2 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystPants).getItem()) {
			 return 64.2 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystBoots).getItem()) {
			 return 36.4 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.AmethystPickaxe).getItem()) {
			 return 28 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.ReinforcedAmethyst).getItem()) {
			 return 18 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.ReinforcedDoorItem).getItem()) {
			 return 100 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.Pistol).getItem()) {
			 return 85 * item_length;
		 }
		 if(item.getItem() == new ItemStack(Test.pistBullet).getItem()) {
			 return 2 * item_length;
		 }
		 return 0.0;
		 
		 
		 
	 }
	 protected void actionPerformed(GuiButton B)
	 {
		 if(B.id == 1)
		 {
			 changeGui(wor,x2,y2,z2,pla);
		 }
		 if(B.id == 2) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.AmethystHelmet;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiAmHelmet.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 3) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.AmethystChestplate;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiAmChestplate.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 4) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.AmethystPants;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiAmPants.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 5) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.AmethystBoots;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiAmBoots.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 6) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.AmethystPickaxe;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiAmPickaxe.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 7) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.ReinforcedAmethyst;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiAmReinforced.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 8) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.Amethyst;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/blocks/ShopGui.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 9) {
			 if(isItem2FoundSlot == false) {
				 item1 = Test.Ruby;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiRuby.png");
				 //isItem2FoundSlot = true;
			 }
		 }
		 if(B.id == 10) {
			 if(isItem3FoundSlot == false) {
				 item1 = Test.Sapphire;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiSapphire.png");
				 //isItem3FoundSlot = true;
			 }
		 }
		 if(B.id == 11) {
			 if(isItem4FoundSlot == false) {
				 item1 = Test.Opal;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiOpal.png");
				 //isItem4FoundSlot = true;
			 }
		 }
		 if(B.id == 12) {
			 if(isItem5FoundSlot == false) {
				 item1 = Test.Pistol;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiPistol.png");
				 //isItem5FoundSlot = true;
			 }
		 }
		 if(B.id == 13) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.pistBullet;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiBullet.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 14) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.RubyHelmet;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiRuHelmet.png");
				 //isItem6FoundSlot = true;
			 }
			 
		 }
		 if(B.id == 15) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.RubyChestplate;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiRuChestplate.png");
				 //isItem1FoundSlot = true;
			 }
			 
		 }
		 if(B.id == 16) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.RubyPants;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiRuPants.png");
				 //isItem1FoundSlot = true;
			 }
			 
		 }
		 if(B.id == 17) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.RubyBoots;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiRuBoots.png");
				 //isItem1FoundSlot = true;
			 }
			 
		 }
		 if(B.id == 18) {
			 if(isItem1FoundSlot == false) {
				 
				 item1 = Test.RubyPickaxe;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiRuPickaxe.png");
				 //isItem1FoundSlot = true;
			 }
			 
		 }
		 if(B.id == 19) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.ReinforcedDoorItem;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiDoorReinforced.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 20) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.OpalHelmet;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiOpHelmet.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 21) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.OpalChestplate;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiOpChestplater.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 22) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.OpalPants;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiOpPants.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 23) {
			 if(isItem1FoundSlot == false) {
				 item1 = Test.OpalBoots;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiOpBoots.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 24) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.diamond;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiDiamond.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 25) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.emerald;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiEmerald.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 26) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.ender_eye;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiEnderEye.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 27) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.experience_bottle;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiExp.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 28) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.nether_star;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiNetherStar.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 29) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.saddle;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiSaddles.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 30) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.skull;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiWitherHead.png");
				 //isItem1FoundSlot = true;
			 }
		 }
		 if(B.id == 31) {
			 if(isItem1FoundSlot == false) {
				 item1 = Items.magma_cream;
				 GuiShop.furnaceGuiTextures = new ResourceLocation(
			        		"money:textures/gui/ShopGuiMagma.png");
				 //isItem1FoundSlot = true;
			 }
		 }
	 }
	 
	ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayWidth);
	protected void drawGuiContainerForegroundLayer(int par1, int par2){}

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
