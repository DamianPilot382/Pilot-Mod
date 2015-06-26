package com.pilotcraftmc.pilotmod.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeModContainer;

public class EntityPagui extends EntityMob{

public EntityPagui(World par1World) {
super(par1World);
}

protected void applyEntityAttributes()
{
super.applyEntityAttributes();
this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23000000417232513D);
this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(5.00);
}

}