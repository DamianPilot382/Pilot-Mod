package com.pilotcraftmc.pilotmod.block;
 
import java.util.Random;

import com.pilotcraftmc.pilotmod.main.PilotMod;
 
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;
 
public class BlockSapphireOreGenerator implements IWorldGenerator {
    
@Override
public void generate(Random random, int chunkX, int chunkZ, World world,
IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.dimensionId){
        case -1: generateNether(world, random, chunkX*16,
 
                     chunkZ*16);
        case 0: generateSurface(world, random, chunkX*16,
 
                     chunkZ*16);
        case 1: generateEnd(world, random, chunkX*16,
 
                     chunkZ*16);
        }
    }
    
    private void generateSurface(World world, Random random,
 
            int x, int z) {
        this.addOreSpawn(PilotMod.blockSapphireOre, world,
 
                 random, x, z, 16, 16, 16, 128, 15, 160);
    }
 
    private void generateEnd(World world, Random random, int x,
 
        int z) {
        // add a call here to spawn in the End
    }
 
    private void generateNether(World world, Random random, int x,
 
        int z) {
        // add a call here to spawn in the Nether
    }
 
    public void addOreSpawn(Block block, World world,
 
            Random random, int blockXPos, int blockZPos,
 
            int maxX, int maxZ, int minVeinSize, 
 
            int chancesToSpawn, int minY, int maxY)
    {
        int maxPossY = minY + (maxY - 1);
        int diffBtwnMinMaxY = maxY - minY;
        for(int x = 0; x < chancesToSpawn; x++)
        {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(diffBtwnMinMaxY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(PilotMod.blockSapphireOre, 
                minVeinSize)).generate(world, random,
 
                posX, posY, posZ);
        }
    }
}
