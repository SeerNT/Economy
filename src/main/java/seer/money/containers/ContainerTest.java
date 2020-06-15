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
   * ¬ аргументы указываетс€ инвентарь игрока и TileEntity, который мы открыли
   */
    public ContainerTest(InventoryPlayer player, PrinterTileEntity testTile) {
    /* Ќазначаем локальный TileEntity на тот, откуда открываетс€ контейнер. Ќужно дл€ методов,
    что требуют TileEntity. */
    tile = testTile;
        //ѕеременна€, отвечающа€ за id слота, да, они не должны повтор€тс€.
    int i = 0;
    /* ћетод, отвечающий за добавление слота, дл€ конструктора обычного слота используетс€:
    IInventory (“ут - инвентарь TileEntity), id слота (будет использовать getStackInSlot, или как его там),
    два целых числа, обозначающие местонахождение слота. */
        addSlotToContainer(new Slot(testTile, i++, 8, 38));
    //¬торой слот инвентар€
        addSlotToContainer(new Slot(testTile, i++, 44, 21));
    /* ƒва цикла, отвечающие за добавление инвентар€ игрока (второй - его хотбар) в привычные места
    интерфейса (и контейнера). ƒа, just copy paste. */
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
   * ћетод, который выполн€етс€ до открыти€ контейнера и GUI, обычно используетс€ дл€ проверки рассто€ни€
   * между игроком и TileEntity (и отмены открыти€, если оно слишком большое).
   */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return ((IInventory) tile).isUseableByPlayer(player);
    }
}