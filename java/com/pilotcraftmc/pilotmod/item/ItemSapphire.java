package com.pilotcraftmc.pilotmod.item;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.item.Item;

public class ItemSapphire extends Item{

public ItemSapphire() {
this.setCreativeTab(PilotMod.tabPilotMod);
}


public Item getItemDropped(int par1, Random random, int par2)
        {
                return PilotMod.itemSapphire;
        }
}


