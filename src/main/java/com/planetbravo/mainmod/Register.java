package com.planetbravo.mainmod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
	
public final class Register {
	
    public static String modid = Main.MODID;
    
    //Place your items and blocks here.
    public static Block blockOne;
    public static Item itemOne;
    
    
    public static void addRecipes(){
    	GameRegistry.addRecipe(new ItemStack(Items.diamond, 64), new Object[] {
    			"DDD",
    			"DDD",
    			"DDD",
    			'D', new ItemStack(Blocks.wool, 1, 15)
    	});
    	
    	GameRegistry.addSmelting(Blocks.dirt, new ItemStack(Items.diamond, 64), 0.1f);
    }
	
	public static void addBlocks(){
		GameRegistry.registerBlock(blockOne = new BlockOne("blockOne"), "blockOne");
	}
	
	public static void addItems(){
    	GameRegistry.registerItem(itemOne = new ItemOne("itemOne"), "itemOne");
	}
	
	public static void addRegisters(){
		reg(itemOne);
		reg(blockOne);
	}
    
    
	public static void reg(Block block) {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(modid + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
    public static void reg(Item item) {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(modid + ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }

}
