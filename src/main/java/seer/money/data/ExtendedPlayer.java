package seer.money.data;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties
{
public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	// I always include the entity to which the properties belong for easy access
	// It's final because we won't be changing which player it is
	private final EntityPlayer player;
	
	// Declare other variables you want to add here
	
	// We're adding mana to the player, so we'll need current and max mana
	public double currentMana;
	public double currentMoney;
	public int[] currentPassword = new int[4];
	public boolean isDestroyed;
	public double maxMana = 500;
	
	/*
	The default constructor takes no arguments, but I put in the Entity
	so I can initialize the above variable 'player'
	
	Also, it's best to initialize any other variables you may have added,
	just like in any constructor.
	*/
	public ExtendedPlayer(EntityPlayer player)
	{
		this.player = player;
		// Start with max mana. Every player starts with the same amount.
		this.currentPassword[0] = 2;
		this.currentPassword[1] = 7;
		this.currentPassword[2] = 1;
		this.currentPassword[3] = 6;
		this.isDestroyed = true;
		this.currentMana = 0.0;
		this.currentMoney = 0.0;
	}
	
	/**
	 * Used to register these extended properties for the player during EntityConstructing event
	 * This method is for convenience only; it will make your code look nicer
	 */
	public static final void register(EntityPlayer player)
	{
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
	}
	
	/**
	 * Returns ExtendedPlayer properties for player
	 * This method is for convenience only; it will make your code look nicer
	 */
	public static final ExtendedPlayer get(EntityPlayer player)
	{
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	// Save any custom data that needs saving here
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		// We need to create a new tag compound that will save everything for our Extended Properties
		NBTTagCompound properties = new NBTTagCompound();
		// We only have 2 variables currently; save them both to the new tag
		properties.setDouble("CurrentMoney", this.currentMoney);
		properties.setDouble("CurrentMana", this.currentMana);
		properties.setInteger("CurrentPassword1", this.currentPassword[0]);
		properties.setInteger("CurrentPassword2", this.currentPassword[1]);
		properties.setInteger("CurrentPassword3", this.currentPassword[2]);
		properties.setInteger("CurrentPassword4", this.currentPassword[3]);
		properties.setBoolean("isDestroyed", this.isDestroyed);
		properties.setDouble("MaxMana", this.maxMana);
		
		// Now add our custom tag to the player's tag with a unique name (our property's name)
		// This will allow you to save multiple types of properties and distinguish between them
		// If you only have one type, it isn't as important, but it will still avoid conflicts between
		// your tag names and vanilla tag names. For instance, if you add some "Items" tag,
		// that will conflict with vanilla. Not good. So just use a unique tag name.
		compound.setTag(EXT_PROP_NAME, properties);
		
	}

	// Load whatever data you saved
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		// Here we fetch the unique tag compound we set for this class of Extended Properties
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		// Get our data from the custom tag compound
		this.currentMoney = properties.getDouble("CurrentMoney");
		this.currentMana = properties.getDouble("CurrentMana");
		this.currentPassword[0] = properties.getInteger("CurrentPassword1");
		this.currentPassword[1] = properties.getInteger("CurrentPassword2");
		this.currentPassword[2] = properties.getInteger("CurrentPassword3");
		this.currentPassword[3] = properties.getInteger("CurrentPassword4");
		this.isDestroyed = properties.getBoolean("isDestroyed");
		this.maxMana = properties.getDouble("MaxMana");
		// Just so you know it's working, add this line:

	}
	
	/*
	I personally have yet to find a use for this method. If you know of any,
	please let me know and I'll add it in! 
	*/
	@Override
	public void init(Entity entity, World world)
	{
	}
	
	/*
	That's it for the IExtendedEntityProperties methods, but we need to add
	a few of our own in order to interact with our new variables. For now,
	let's make one method to consume mana and one to replenish it.
	 */
	
	/**
	 * Returns true if the amount of mana was consumed or false
	 * if the player's current mana was insufficient
	 */
	public boolean consumeMana(int amount)
	{
		// Does the player have enough mana?
		boolean sufficient = amount <= this.currentMana;
		// Consume the amount anyway; if it's more than the player's current mana,
		// mana will be set to 0
		this.currentMana -= (amount < this.currentMana ? amount : this.currentMana);
		// Return if the player had enough mana
		return sufficient;
	}
	

}