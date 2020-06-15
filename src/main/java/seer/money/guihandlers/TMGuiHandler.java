package seer.money.guihandlers;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import ru.seer.money.MegaTileEntity;
import ru.seer.money.MillionTileEntity;
import ru.seer.money.OmegaTileEntity;
import ru.seer.money.ShopTileEntity;
import ru.seer.money.UltraTileEntity;
import seer.money.containers.ContainerCashMachine;
import seer.money.containers.ContainerShop;
import seer.money.inventory.ContainerItem;
import seer.money.inventory.GuiItemInventory;
import seer.money.inventory.InventoryItem;
import seer.money.rendering.tileentities.Cash_MachineTileEntity;
import seer.money.rendering.tileentities.PrinterTileEntity;

public class TMGuiHandler implements IGuiHandler {

	public TMGuiHandler (){
		
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			PrinterTileEntity tileEntityFurnace = (PrinterTileEntity) world.getTileEntity(x, y, z);
			return new ContainerTutFurnace(player.inventory, tileEntityFurnace);
		}
		if(ID == 1){
			ShopTileEntity tileEntityShop = (ShopTileEntity) world.getTileEntity(x, y, z);
			return new ContainerShop(player.inventory, tileEntityShop, player);
		}
		if(ID == 2){
			ShopTileEntity tileEntityShop = (ShopTileEntity) world.getTileEntity(x, y, z);
			return new ContainerShop(player.inventory, tileEntityShop, player);
		}
		if(ID == 3){
			MegaTileEntity tileEntity = (MegaTileEntity) world.getTileEntity(x, y, z);
			return new ContainerMegaPrinter(player.inventory, tileEntity);
		}
		if(ID == 4){
			UltraTileEntity tileEntity = (UltraTileEntity) world.getTileEntity(x, y, z);
			return new ContainerUltraPrinter(player.inventory, tileEntity);
		}
		if(ID == 5){
			OmegaTileEntity tileEntity = (OmegaTileEntity) world.getTileEntity(x, y, z);
			return new ContainerOmehaPrinter(player.inventory, tileEntity);
		}
		if(ID == 6){
			MillionTileEntity tileEntity = (MillionTileEntity) world.getTileEntity(x, y, z);
			return new ContainerMillionPrinter(player.inventory, tileEntity);
		}
		if(ID == 7){
			Cash_MachineTileEntity tileEntity = (Cash_MachineTileEntity) world.getTileEntity(x, y, z);
			return new ContainerCashMachine(player.inventory, tileEntity,player);
		}
		if(ID == 8) {
			return new ContainerItem(player, player.inventory, new InventoryItem(player.getHeldItem()));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == 0){
			PrinterTileEntity tileEntityTestContainer = (PrinterTileEntity) world.getTileEntity(x, y, z);
			return new GuiTutFurnace(player.inventory, tileEntityTestContainer);
		}
		if(ID == 1){
			ShopTileEntity tileEntityTestContainer = (ShopTileEntity) world.getTileEntity(x, y, z);
			return new GuiShop(player.inventory, tileEntityTestContainer, world, player, x, y, z);
		}
		if(ID == 2){
			ShopTileEntity tileEntityTestContainer = (ShopTileEntity) world.getTileEntity(x, y, z);
			return new GuiShopCustom(player.inventory, tileEntityTestContainer, world, player, x, y, z);
		}
		if(ID == 3){
			MegaTileEntity tileEntityTestContainer = (MegaTileEntity) world.getTileEntity(x, y, z);
			return new GuiMegaPrinter(player.inventory, tileEntityTestContainer);
		}
		if(ID == 4){
			UltraTileEntity tileEntityTestContainer = (UltraTileEntity) world.getTileEntity(x, y, z);
			return new GuiUltraPrinter(player.inventory, tileEntityTestContainer);
		}
		if(ID == 5){
			OmegaTileEntity tileEntityTestContainer = (OmegaTileEntity) world.getTileEntity(x, y, z);
			return new GuiOmegaPrinter(player.inventory, tileEntityTestContainer);
		}
		if(ID == 6){
			MillionTileEntity tileEntityTestContainer = (MillionTileEntity) world.getTileEntity(x, y, z);
			return new GuiMillionPrinter(player.inventory, tileEntityTestContainer);
		}
		if(ID == 7){
			Cash_MachineTileEntity tileEntityTestContainer = (Cash_MachineTileEntity) world.getTileEntity(x, y, z);
			return new GuiCashMachine(player.inventory, tileEntityTestContainer, world, player, x, y, z);
		}
		if(ID == 8) {
			return new GuiItemInventory((ContainerItem) new ContainerItem(player, player.inventory, new InventoryItem(player.getHeldItem())));
		}
		return null;
	}

}