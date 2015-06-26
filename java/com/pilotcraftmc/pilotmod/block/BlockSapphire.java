package com.pilotcraftmc.pilotmod.block;

import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;

public class BlockSapphire extends Block {

public BlockSapphire() {
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

public static void getRecipe(){
	GameRegistry.addRecipe(new ItemStack(PilotMod.blockSapphire,1), new Object[]{
        "SSS",
        "SSS",
        "SSS",
        'S', PilotMod.itemSapphire 
    });
	
}

}