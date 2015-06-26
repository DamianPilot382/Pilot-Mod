package com.pilotcraftmc.pilotmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.pilotcraftmc.pilotmod.main.PilotMod;

public class LuigiHat extends ItemArmor{
	public LuigiHat(ArmorMaterial material, int id, int placement){
		super(material, id, placement);
		this.setCreativeTab(PilotMod.tabPilotMod);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(stack.getItem() == PilotMod.luigiHat){
			return PilotMod.MODID + ":textures/models/armor/luigiHat.png";
		}else{
			return null;
		}
	}

}
