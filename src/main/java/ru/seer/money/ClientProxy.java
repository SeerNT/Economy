package ru.seer.money;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import seer.money.rendering.tileentities.AmethystArrow;
import seer.money.rendering.tileentities.Cash_MachineTileEntity;
import seer.money.rendering.tileentities.PrinterTileEntity;
import seer.money.rendering.tileentities.RenderAmArrow;
import seer.money.rendering.tileentities.RenderCashMachine;
import seer.money.rendering.tileentities.RenderMegaPrinter;
import seer.money.rendering.tileentities.RenderMillionPrinter;
import seer.money.rendering.tileentities.RenderOmegaPrinter;
import seer.money.rendering.tileentities.RenderPoliceMan;
import seer.money.rendering.tileentities.RenderPoliceManGirl;
import seer.money.rendering.tileentities.RenderPrinter;
import seer.money.rendering.tileentities.RenderRyArrow;
import seer.money.rendering.tileentities.RenderSafe;
import seer.money.rendering.tileentities.RenderShop;
import seer.money.rendering.tileentities.RenderUltraPrinter;
import seer.money.rendering.tileentities.RubyArrow;
import seer.money.rendering.tileentities.safeItemRender;
import seer.money.rendering.tileentities.safeTileEntity;

public class ClientProxy extends CommonProxy
{
	public static int[] displayList = new int[1];
	
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    }
    @Override
    public void registerRenderers()
    {
      RenderingRegistry.registerEntityRenderingHandler(PoliceMan.class, new RenderPoliceMan(new ModelBiped(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(PoliceManGirl.class, new RenderPoliceManGirl(new ModelBiped(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(PoliceManGunner.class, new RenderPoliceMan(new ModelBiped(), 0.5F));
      RenderingRegistry.registerEntityRenderingHandler(PoliceManGirlGunner.class, new RenderPoliceManGirl(new ModelBiped(), 0.5F));
    }
    @Override
    public void init(FMLInitializationEvent event)
    {
        super.init(event);
        GameRegistry.registerTileEntity(ShopTileEntity.class, "tileShop");
        ClientRegistry.bindTileEntitySpecialRenderer(ShopTileEntity.class, new RenderShop());
        GameRegistry.registerTileEntity(Cash_MachineTileEntity.class, "tileCashMachine");
        ClientRegistry.bindTileEntitySpecialRenderer(Cash_MachineTileEntity.class, new RenderCashMachine());
        GameRegistry.registerTileEntity(PrinterTileEntity.class, "tilePrinter");
        ClientRegistry.bindTileEntitySpecialRenderer(PrinterTileEntity.class, new RenderPrinter());
        GameRegistry.registerTileEntity(MegaTileEntity.class, "tileMegaPrinter");
        ClientRegistry.bindTileEntitySpecialRenderer(MegaTileEntity.class, new RenderMegaPrinter());
        GameRegistry.registerTileEntity(UltraTileEntity.class, "tileUltr	aPrinter");
        ClientRegistry.bindTileEntitySpecialRenderer(UltraTileEntity.class, new RenderUltraPrinter());
        GameRegistry.registerTileEntity(OmegaTileEntity.class, "tileOmegaPrinter");
        ClientRegistry.bindTileEntitySpecialRenderer(OmegaTileEntity.class, new RenderOmegaPrinter());
        GameRegistry.registerTileEntity(MillionTileEntity.class, "tileMillionPrinter");
        ClientRegistry.bindTileEntitySpecialRenderer(MillionTileEntity.class, new RenderMillionPrinter());
        GameRegistry.registerTileEntity(safeTileEntity.class, "tileSafe");
        ClientRegistry.bindTileEntitySpecialRenderer(safeTileEntity.class, new RenderSafe());
        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(Test.safe), new safeItemRender());
        RenderingRegistry.registerEntityRenderingHandler(AmethystArrow.class, new RenderAmArrow());
        RenderingRegistry.registerEntityRenderingHandler(RubyArrow.class, new RenderRyArrow());
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
