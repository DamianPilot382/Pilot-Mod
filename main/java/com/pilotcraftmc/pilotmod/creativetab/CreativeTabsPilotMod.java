package com.pilotcraftmc.pilotmod.creativetab;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabsPilotMod extends CreativeTabs {

public CreativeTabsPilotMod(String tabLabel)
{
super(tabLabel);
}

@Override
@SideOnly(Side.CLIENT)
public Item getTabIconItem()
{
return PilotMod.creativeTabIcon;
}

}