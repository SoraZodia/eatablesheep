package com.sorazodia.eatablesheep;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLampchopFood extends ItemFood{
	
	public ItemLampchopFood(int FoodLevel, float Staturation, boolean WolfFood)
    {
        super(FoodLevel, Staturation, WolfFood);
    }

}
