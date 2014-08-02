package com.sorazodia.eatablesheep;

import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Lampchop.MODID, name = "Eatable Sheep", version = Lampchop.VERSION)

public class Lampchop{

	public static final String MODID = "eatable_sheep";
	public static final String VERSION = "3.4";
	
	public static ItemFood lampchopraw;
	public static ItemFood lampchopcooked;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event){		
	   lampchopraw = (ItemFood) new ItemLampchopFood(4, 0.3F, true).setUnlocalizedName("lampchopraw").setTextureName("eatable_sheep:lampchopraw");
	   lampchopcooked = (ItemFood) new ItemLampchopFood(8, 0.8F, true).setUnlocalizedName("lampchopcooked").setTextureName("eatable_sheep:lampchopcooked");
		
	   FMLLog.info("Eatable_Livestock: Registering Raw Lampchop and Cooked Lampchop");
		GameRegistry.registerItem(lampchopraw, "lampchopraw", Lampchop.MODID);
		GameRegistry.registerItem(lampchopcooked, "lampchopcooked", Lampchop.MODID);
		GameRegistry.addSmelting(lampchopraw, new ItemStack(lampchopcooked), 0.3F);
		FMLLog.info("Eatable_Livestock: Item Registeration Finished");
		FMLLog.info("Eatable_Livestock: Registering Interaction and Drop Event");
		MinecraftForge.EVENT_BUS.register(new LivingDropEvent());
		MinecraftForge.EVENT_BUS.register(new InteractEvent());
		FMLLog.info("Eatable_Livestock: Event Registeration Finished, Mod should be loaded");

	}

}
