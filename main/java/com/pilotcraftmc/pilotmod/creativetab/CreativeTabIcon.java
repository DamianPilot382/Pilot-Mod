package com.pilotcraftmc.pilotmod.creativetab;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.item.Item;

public class CreativeTabIcon extends Item{

public CreativeTabIcon() {
}


public Item getItemDropped(int par1, Random random, int par2)
        {
                return PilotMod.creativeTabIcon;
        }
}


