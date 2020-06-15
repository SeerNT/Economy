package seer.money.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import seer.money.rendering.tileentities.PrinterTileEntity;

public class ContainerTest extends Container {
    private PrinterTileEntity tile;

  /**
   * � ��������� ����������� ��������� ������ � TileEntity, ������� �� �������
   */
    public ContainerTest(InventoryPlayer player, PrinterTileEntity testTile) {
    /* ��������� ��������� TileEntity �� ���, ������ ����������� ���������. ����� ��� �������,
    ��� ������� TileEntity. */
    tile = testTile;
        //����������, ���������� �� id �����, ��, ��� �� ������ ����������.
    int i = 0;
    /* �����, ���������� �� ���������� �����, ��� ������������ �������� ����� ������������:
    IInventory (��� - ��������� TileEntity), id ����� (����� ������������ getStackInSlot, ��� ��� ��� ���),
    ��� ����� �����, ������������ ��������������� �����. */
        addSlotToContainer(new Slot(testTile, i++, 8, 38));
    //������ ���� ���������
        addSlotToContainer(new Slot(testTile, i++, 44, 21));
    /* ��� �����, ���������� �� ���������� ��������� ������ (������ - ��� ������) � ��������� �����
    ���������� (� ����������). ��, just copy paste. */
    for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(player, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        for (i = 0; i < 9; ++i) {
            this.addSlotToContainer(new Slot(player, i, 8 + i * 18, 142));
        }
    }

  /**
   * �����, ������� ����������� �� �������� ���������� � GUI, ������ ������������ ��� �������� ����������
   * ����� ������� � TileEntity (� ������ ��������, ���� ��� ������� �������).
   */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return ((IInventory) tile).isUseableByPlayer(player);
    }
}