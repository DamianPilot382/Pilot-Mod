package com.pilotcraftmc.pilotmod.item;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item.ToolMaterial;

public class PickaxeSapphire extends ItemPickaxe
{
public PickaxeSapphire(ToolMaterial material)
{
super(material);
this.setCreativeTab(PilotMod.tabPilotMod);
}
public Item getItemDropped(int par1, Random random, int par2)
        {
                return PilotMod.pickaxeSapphire;
        }
}


