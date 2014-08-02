package com.sorazodia.eatablesheep;

import java.util.Random;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class InteractEvent{

	World world;
	
	@SubscribeEvent
	 public void EntityInteractEvent(EntityInteractEvent event){
		
		Random rand = new Random();
		 EntityPig pig = new EntityPig(world);
	    	ItemStack var2 = event.entityPlayer.getHeldItem();
	    	int badFood = rand.nextInt(4) + 1;
		 if (!event.entity.worldObj.isRemote &&(event.target instanceof EntityPig || event.target instanceof EntitySheep || event.target instanceof EntityCow || event.target instanceof EntityChicken)){			 	 			
			 if (var2 == null || event.entityPlayer.canEat(false)){
				 if(event.entityLiving.isSneaking()){
			        event.target.setDead();
				    if(event.target instanceof EntityChicken){
				       event.entityPlayer.getFoodStats().addStats(2, 0.3F);
				       }
				  if(((EntityLivingBase) event.target).isChild() && event.target instanceof EntityChicken){
	         			event.entityPlayer.getFoodStats().addStats(1, 0.15F);
	         		}
			      if(((EntityLivingBase) event.target).isChild() && !(event.target instanceof EntityChicken)){  
		         		event.entityPlayer.getFoodStats().addStats(8, 0.3F);		
		         	}
			      if (!((EntityLivingBase) event.target).isChild() && !(event.target instanceof EntityChicken)){	         		
		         		if(event.target instanceof EntityPig){
		         			event.entityPlayer.getFoodStats().addStats(16, 0.8F);
		         		}
		         		else
		         		{
		         		event.entityPlayer.getFoodStats().addStats(20, 0.8F);
		         		} 
		         	}
			      if (badFood <= 2){
			         	if(!(event.target instanceof EntityPig)){		         		
			         		((EntityLivingBase)event.entityPlayer).addPotionEffect(new PotionEffect(Potion.hunger.id, 1400));
			         		}
			         	else{
			         			//nothing happens
			         		}
			         	}
			      if (badFood == 1){
		         		if(!(event.target instanceof EntityChicken)){
		         		((EntityLivingBase)event.entityPlayer).addPotionEffect(new PotionEffect(Potion.poison.id, 1400));
		         		((EntityLivingBase)event.entityPlayer).addPotionEffect(new PotionEffect(Potion.hunger.id, 1400));
		         		}
		         	}   
			      event.entityPlayer.playSound("random.burp", 0.5F, 0.1F + 0.9F);
			  }		         	
		    }
		}
  }	 
	}
