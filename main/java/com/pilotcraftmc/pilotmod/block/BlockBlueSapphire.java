package com.pilotcraftmc.pilotmod.block;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockBlueSapphire extends Block {

public BlockBlueSapphire() {
super(Material.ground);
setStepSound(soundTypePiston);
setHardness(3.0F);
setResistance(3.0F);
setHarvestLevel("pickaxe", 2);
this.setCreativeTab(PilotMod.tabPilotMod);
}
@Override
public Item getItemDropped(int par1, Random random, int par2)
    {
            return Item.getItemFromBlock(PilotMod.blockSapphire);
    }

}