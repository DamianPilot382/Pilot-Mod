package com.pilotcraftmc.pilotmod.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.pilotcraftmc.pilotmod.main.PilotMod;

public class SapphireArmor extends ItemArmor{
	public SapphireArmor(ArmorMaterial material, int id, int placement){
		super(material, id, placement);
		this.setCreativeTab(PilotMod.tabPilotMod);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(stack.getItem() == PilotMod.sapphireHelmet || stack.getItem() == PilotMod.sapphireChestplate || stack.getItem() == PilotMod.sapphireBoots){
			return PilotMod.MODID + ":textures/models/armor/sapphireArmor_1.png";
		}
		if(stack.getItem() == PilotMod.sapphireLeggings){
			return PilotMod.MODID + ":textures/models/armor/sapphireArmor_2.png";
		}else{
			return null;
		}
	}

}
