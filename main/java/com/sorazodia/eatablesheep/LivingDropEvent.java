package com.sorazodia.eatablesheep;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingDropEvent{
 
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		 EntityLivingBase entityLiving;
		 Random rand = new Random();
			int drop = rand.nextInt(3)+1;
			
                 if (event.entityLiving instanceof EntitySheep) {
                	 if (event.entityLiving.isBurning()) {
                		 event.entityLiving.dropItem(Lampchop.lampchopcooked, drop);
                	 }
                	 else{
                     event.entityLiving.dropItem(Lampchop.lampchopraw, drop);
                     }
                 }
                 

     }
	 
	 
}

