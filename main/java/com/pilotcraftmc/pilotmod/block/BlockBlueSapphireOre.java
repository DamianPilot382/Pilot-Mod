package com.pilotcraftmc.pilotmod.block;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockBlueSapphireOre extends Block {

public BlockBlueSapphireOre() {
super(Material.rock);
setStepSound(soundTypePiston);
setHardness(3.0F);
setResistance(3.0F);
setHarvestLevel("pickaxe", 2);
this.setCreativeTab(PilotMod.tabPilotMod);
}

}
