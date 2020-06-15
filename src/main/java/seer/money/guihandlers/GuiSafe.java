package seer.money.guihandlers;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import ru.seer.money.safe;

public class GuiSafe extends GuiScreen {
	private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 4;
    private static ResourceLocation[] bookPageTextures = 
          new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private static String[] stringPageText2 = new String[bookTotalPages];
    private static String[] stringPageText3 = new String[bookTotalPages];
    private static String[] stringPageText4 = new String[bookTotalPages];
    private GuiButton buttonDone;
    private GuiButton changePass;
    private NextPageButton buttonUp;
    private NextPageButton buttonDown;
    private NextPageButton buttonUp2;
    private NextPageButton buttonDown2;
    private NextPageButton buttonUp3;
    private NextPageButton buttonDown3;
    private NextPageButton buttonUp4;
    private NextPageButton buttonDown4;
    private int pageNumber = 0;
    private int pageNumber2 = 0;
    private int pageNumber3= 0;
    private int pageNumber4 = 0;
	private String defaultCodeText = "Default code is 2 7 1 6";
    private int[] password = new int[4];
	private boolean accessChange = false;
	private boolean passWasChanged = false;
	private boolean wantToChangePass = false;
	
    public GuiSafe()
    {
        bookPageTextures[1] = new ResourceLocation(
        		"money:textures/gui/book.png");
        bookPageTextures[2] = new ResourceLocation(
              "money:textures/gui/book.png");
        stringPageText[0]="0";
        stringPageText[1]="0";
        stringPageText[2]="0";
        stringPageText[3]="0";
        password[0] = safe.password[0];
        password[1] = safe.password[1];
        password[2] = safe.password[2];
        password[3] = safe.password[3];
        
        
 }	

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight, 
              98, 20, I18n.format("gui.done", new Object[0]));
        changePass = new GuiButton(1, 102, 4 + bookImageHeight, 
                98, 20, "Change Code");
        buttonList.add(changePass);
        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonUp= new NextPageButton(1, 
              offsetFromScreenLeft + 35, 110, true));
        buttonList.add(buttonDown = new NextPageButton(2, 
              offsetFromScreenLeft + 35, 50, false));
        buttonList.add(buttonUp2= new NextPageButton(1, 
                offsetFromScreenLeft + 65, 110, true));
        buttonList.add(buttonDown2 = new NextPageButton(2, 
                offsetFromScreenLeft + 65, 50, false));
        buttonList.add(buttonUp3= new NextPageButton(1, 
                  offsetFromScreenLeft + 95, 110, true));
        buttonList.add(buttonDown3 = new NextPageButton(2, 
                  offsetFromScreenLeft + 95, 50, false));
        buttonList.add(buttonUp4= new NextPageButton(1, 
                offsetFromScreenLeft + 125,110, true));
        buttonList.add(buttonDown4 = new NextPageButton(2, 
                offsetFromScreenLeft + 125, 50, false));
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
    	changePass.visible = true;
        buttonDone.visible = true;
        buttonUp.visible = true;
        buttonDown.visible = true;
        buttonUp2.visible = true;
        buttonDown2.visible = true;
        buttonUp3.visible = true;
        buttonDown3.visible = true;
        buttonUp4.visible = true;
        buttonDown4.visible = true;
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (currPage == 0)
     {
         mc.getTextureManager().bindTexture(bookPageTextures[1]);
     }
        else
        {
         mc.getTextureManager().bindTexture(bookPageTextures[1]);
        }
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, 
              bookImageHeight);
        fontRendererObj.drawSplitString(stringPageText[0], 
              offsetFromScreenLeft + 44, 84, 226, 0);
        fontRendererObj.drawSplitString(stringPageText[1], 
                offsetFromScreenLeft + 74, 84, 226, 0);
        fontRendererObj.drawSplitString(stringPageText[2], 
                offsetFromScreenLeft + 104, 84, 226, 0);
        fontRendererObj.drawSplitString(stringPageText[3], 
                offsetFromScreenLeft + 134, 84, 226, 0);
        fontRendererObj.drawSplitString(defaultCodeText , 
                offsetFromScreenLeft + 24, 37, 226, 50);
        super.drawScreen(parWidth, parHeight, p_73863_3_);

    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. 
     * Parameters are : mouseX, mouseY, lastButtonClicked & 
     * timeSinceMouseClick.
     */
    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, 
          int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
     
    }

    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
    	if (parButton == changePass)
        {
    		defaultCodeText = "Enter a current password";
    		 if (wantToChangePass == true) {
    			 password[0] = pageNumber;
        		 password[1] = pageNumber2;
        		 password[2] = pageNumber3;
        		 password[3] = pageNumber4;
        		 safe.password[0] = password[0];
        		 safe.password[1] = password[1];
        		 safe.password[2] = password[2];
        		 safe.password[3] = password[3];
        		 accessChange = false;
        		 passWasChanged = true;
        		 wantToChangePass = false;
        		 defaultCodeText = "Password was changed!";
    		 }
    		 else if (pageNumber == password[0] && pageNumber2 == password[1] && pageNumber3 == password[2] && pageNumber4 == password[3]) {
    			 accessChange  = true;
    			 wantToChangePass = true;
    			 defaultCodeText = "Now enter a new password";
        	 }else {
        		 accessChange = false;
        		 defaultCodeText = "Wrong password";
        		 //System.out.println(password[0]);
        		 //System.out.println(password[1]);
        		 //System.out.println(password[2]);
        		 //System.out.println(password[3]);
        	 }
        }
     if (parButton == buttonDone)
     {
         // You can send a packet to server here if you need server to do 
         // something 2 7 1 6
    	 if (accessChange == true) {
    		 password[0] = pageNumber;
    		 password[1] = pageNumber2;
    		 password[2] = pageNumber3;
    		 password[3] = pageNumber4;
    		 accessChange = false;
    		 passWasChanged = true;
    		 mc.displayGuiScreen((GuiScreen)null);
    	 }
    	 if (pageNumber == password[0] && pageNumber2 == password[1] && pageNumber3 == password[2] && pageNumber4 == password[3]) {
    		 safe.accessOpen = true;
    		 mc.displayGuiScreen((GuiScreen)null);
    	 }else {
    		 mc.displayGuiScreen((GuiScreen)null);
    	 }
         
     }
        else if (parButton == buttonUp)
        {	
        	--pageNumber;
        	if (pageNumber < 0) {
        		pageNumber = 9;
        	}
        	if(pageNumber > 9) {
        		pageNumber = 0;
        	}
        	stringPageText[0]=String.valueOf(pageNumber);
        }
        else if (parButton == buttonDown)
        {
        	++pageNumber;
        	if (pageNumber < 0) {
        		pageNumber = 9;
        	}
        	if(pageNumber > 9) {
        		pageNumber = 0;
        	}
            stringPageText[0]=String.valueOf(pageNumber);
        }
        else if (parButton == buttonUp2)
        {
        	--pageNumber2;
        	if (pageNumber2 < 0) {
        		pageNumber2 = 9;
        	}
        	if(pageNumber2 > 9) {
        		pageNumber2 = 0;
        	}
        	stringPageText[1]=String.valueOf(pageNumber2);
        }
        else if (parButton == buttonDown2)
        {
        	++pageNumber2;
        	if (pageNumber2 < 0) {
        		pageNumber2 = 9;
        	}
        	if(pageNumber2 > 9) {
        		pageNumber2 = 0;
        	}
            stringPageText[1]=String.valueOf(pageNumber2);
        }
        else if (parButton == buttonUp3)
        {
        	--pageNumber3;
        	if (pageNumber3 < 0) {
        		pageNumber3 = 9;
        	}
        	if(pageNumber3 > 9) {
        		pageNumber3 = 0;
        	}
        	stringPageText[2]=String.valueOf(pageNumber3);
        }
        else if (parButton == buttonDown3)
        {
        	++pageNumber3;
        	if (pageNumber3 < 0) {
        		pageNumber3 = 9;
        	}
        	if(pageNumber3 > 9) {
        		pageNumber3 = 0;
        	}
            stringPageText[2]=String.valueOf(pageNumber3);
        }
        else if (parButton == buttonUp4)
        {
        	--pageNumber4;
        	if (pageNumber4 < 0) {
        		pageNumber4 = 9;
        	}
        	if(pageNumber4 > 9) {
        		pageNumber4 = 0;
        	}
        	stringPageText[3]=String.valueOf(pageNumber4);
        }
        else if (parButton == buttonDown4)
        {
        	++pageNumber4;
        	if (pageNumber4 < 0) {
        		pageNumber4 = 9;
        	}
        	if(pageNumber4 > 9) {
        		pageNumber4 = 0;
        	}
            stringPageText[3]=String.valueOf(pageNumber4);
        }
   }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat 
     * events
     */
    @Override
    public void onGuiClosed() 
    {
     
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in 
     * single-player
     */
    @Override
    public boolean doesGuiPauseGame()
    {
        return true;
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
}
