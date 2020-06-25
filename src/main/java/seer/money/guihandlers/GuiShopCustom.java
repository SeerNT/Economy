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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.Test;
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
	
	
	public GuiShopCustom(InventoryPlayer inventory, ShopTileEntity tileEntityTestContainer, World world, EntityPlayer player, int x, int y, int z) {
		super(new ContainerShopCustom(inventory, tileEntityTestContainer));
		bookPageTextures[1] = new ResourceLocation(
        		"money:textures/gui/PlusButton.png");
		this.tileFurnace = tileEntityTestContainer;
		this.width = sr.getScaledWidth();
		this.height = sr.getScaledHeight();
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
	  this.buttonList.add(new GuiButton( 1, centeredX - 10, centeredY + 94, 38, 20, "Continue"));
	  this.buttonList.add(button1 = new PlusButton( 2, centeredX - 62, centeredY - 29, false));
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
			 changeGui(wor,x2,y2,z2,pla);
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
