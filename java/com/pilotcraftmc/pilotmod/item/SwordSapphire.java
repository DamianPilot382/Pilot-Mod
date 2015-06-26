package com.pilotcraftmc.pilotmod.item;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;

public class SwordSapphire extends ItemSword
{
public SwordSapphire(ToolMaterial material)
{
super(material);
this.setCreativeTab(PilotMod.tabPilotMod);
}
public Item getItemDropped(int par1, Random random, int par2)
        {
                return PilotMod.swordSapphire;
        }
}


