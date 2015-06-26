package com.pilotcraftmc.pilotmod.item;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class FoodStrawberry extends ItemFood{

public FoodStrawberry(int i,int j,boolean b){
  super(j,b);
this.setCreativeTab(PilotMod.tabPilotMod);
}


public Item getItemDropped(int par1, Random random, int par2)
        {
                return PilotMod.foodStrawberry;
        }
}