package com.pilotcraftmc.pilotmod.entity;

import org.lwjgl.opengl.GL11;

import com.pilotcraftmc.pilotmod.main.PilotMod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderHorse;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderJorge extends RenderBiped{

private static final ResourceLocation textureLocation = new ResourceLocation(PilotMod.MODID + ":" + "textures/models/jorge.png");
protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
{
	float scale = 1.0F;
    GL11.glScalef(scale, scale, scale);
}
public RenderJorge(ModelBiped model, float shadowSize) {
super(model, shadowSize);
}

@Override
protected ResourceLocation getEntityTexture(Entity par1Entity)
{
return textureLocation;
}
}