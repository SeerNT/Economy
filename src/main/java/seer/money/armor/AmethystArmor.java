package seer.money.armor;



import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import ru.seer.money.Test;

public class AmethystArmor extends ItemArmor {
	public AmethystArmor(int id, int armorType) {
	  super(Test.ametMat, id, armorType);
	  this.setCreativeTab(Test.combat);
	  this.setMaxStackSize(1);
	}



	public String getArmorTexture(ItemStack itemstack, Entity entity, int slot, String type){
		if (this.armorType == 2) {
			return "money:textures/models/armor/amethyst_layer_2.png";
		}
		return "money:textures/models/armor/amethyst_layer_1.png";
	}
}
