package com.pilotcraftmc.pilotmod.main;

//import
import java.util.Random;

import com.pilotcraftmc.pilotmod.armor.LuigiHat;
import com.pilotcraftmc.pilotmod.armor.SapphireArmor;
import com.pilotcraftmc.pilotmod.block.BlockBlueSapphire;
import com.pilotcraftmc.pilotmod.block.BlockBlueSapphireOre;
import com.pilotcraftmc.pilotmod.block.BlockSapphire;
import com.pilotcraftmc.pilotmod.block.BlockSapphireOre;
import com.pilotcraftmc.pilotmod.block.BlockSapphireOreGenerator;
import com.pilotcraftmc.pilotmod.creativetab.CreativeTabIcon;
import com.pilotcraftmc.pilotmod.creativetab.CreativeTabsPilotMod;
import com.pilotcraftmc.pilotmod.entity.EntityJorge;
import com.pilotcraftmc.pilotmod.entity.EntityLuigi;
import com.pilotcraftmc.pilotmod.entity.EntityMajo;
import com.pilotcraftmc.pilotmod.entity.EntityPagui;
import com.pilotcraftmc.pilotmod.entity.EntityPilot;
import com.pilotcraftmc.pilotmod.entity.EntitySebas;
import com.pilotcraftmc.pilotmod.entity.RenderJorge;
import com.pilotcraftmc.pilotmod.entity.RenderLuigi;
import com.pilotcraftmc.pilotmod.entity.RenderMajo;
import com.pilotcraftmc.pilotmod.entity.RenderPagui;
import com.pilotcraftmc.pilotmod.entity.RenderPilot;
import com.pilotcraftmc.pilotmod.entity.RenderSebas;
import com.pilotcraftmc.pilotmod.item.AxeSapphire;
import com.pilotcraftmc.pilotmod.item.FoodBurrito;
import com.pilotcraftmc.pilotmod.item.FoodCereal;
import com.pilotcraftmc.pilotmod.item.FoodSoda;
import com.pilotcraftmc.pilotmod.item.FoodStrawberry;
import com.pilotcraftmc.pilotmod.item.HoeSapphire;
import com.pilotcraftmc.pilotmod.item.ItemBlueSapphireIngot;
import com.pilotcraftmc.pilotmod.item.ItemSapphire;
import com.pilotcraftmc.pilotmod.item.PickaxeSapphire;
import com.pilotcraftmc.pilotmod.item.ShovelSapphire;
import com.pilotcraftmc.pilotmod.item.SwordSapphire;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelHorse;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = PilotMod.MODID, version = PilotMod.VERSION)


//Class Start
public class PilotMod {
	
//unique ID's for Armor
public static int sapphireHelmetID;
public static int sapphireChestplateID;
public static int sapphireLeggingsID;
public static int sapphireBootsID;
public static int luigiHatID;
	
//Mod Info
public static final String MODID = "PilotMod";
public static final String VERSION = "0.1";


//Ore Manager Declaration
private BlockSapphireOreGenerator BlockSapphireOreGenerator= new BlockSapphireOreGenerator();


//Block Declaration
public static Block blockSapphireOre;
public static Block blockSapphire;
public static Block blockBlueSapphireOre;
public static Block blockBlueSapphire;


//Item Declaration
public static Item itemSapphire;
public static Item axeSapphire;
public static Item hoeSapphire;
public static Item pickaxeSapphire;
public static Item shovelSapphire;
public static Item foodStrawberry;
public static Item foodBurrito;
public static Item foodCereal;
public static Item foodSoda;
public static Item swordSapphire;
public static Item creativeTabIcon;
public static Item itemBlueSapphireIngot;

//Armor Declaration
public static Item sapphireHelmet;
public static Item sapphireChestplate;
public static Item sapphireLeggings;
public static Item sapphireBoots;

//Luigi's Hat Declaration
public static Item luigiHat;

//Creative Tabs
public static CreativeTabs tabPilotMod = new CreativeTabsPilotMod("PilotMod");


//registerEntity Method
public static void registerEntity(Class entityClass, String name)
{
int entityID = EntityRegistry.findGlobalUniqueEntityId();
long seed = name.hashCode();
Random rand = new Random(seed);
int primaryColor = rand.nextInt() * 16777215;
int secondaryColor = rand.nextInt() * 16777215;

EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
EntityRegistry.registerModEntity(entityClass, name, entityID, instance, 64, 1, true);
EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
}

//registerRenderers Method
public void registerRenderers() {
RenderingRegistry.registerEntityRenderingHandler(EntityPilot.class, new RenderPilot(new ModelBiped(), 0.5F));
RenderingRegistry.registerEntityRenderingHandler(EntityJorge.class, new RenderJorge(new ModelBiped(), 0.5F));
RenderingRegistry.registerEntityRenderingHandler(EntityLuigi.class, new RenderLuigi(new ModelBiped(), 0.5F));
RenderingRegistry.registerEntityRenderingHandler(EntitySebas.class, new RenderSebas(new ModelBiped(), 0.5F));
RenderingRegistry.registerEntityRenderingHandler(EntityPagui.class, new RenderPagui(new ModelBiped(), 0.5F));
RenderingRegistry.registerEntityRenderingHandler(EntityMajo.class, new RenderMajo(new ModelBiped(), 0.5F));
}


@Instance(MODID)
public static PilotMod instance;

//preInit
@EventHandler
public void preInit(FMLPreInitializationEvent event) 
{
	
	//Register Ore Managers
	GameRegistry.registerWorldGenerator(BlockSapphireOreGenerator, 0);
	
	
	//Block Name and Textures
	blockSapphireOre = new BlockSapphireOre().setBlockName("blockSapphireOre").setBlockTextureName(PilotMod.MODID + ":" + "sapphire_ore");
	blockSapphire = new BlockSapphire().setBlockName("blockSapphire").setBlockTextureName(PilotMod.MODID + ":" + "sapphireblock");
	blockBlueSapphire = new BlockBlueSapphire().setBlockName("blockBlueSapphire").setBlockTextureName(PilotMod.MODID + ":" + "bluesapphireblock");
	blockBlueSapphireOre = new BlockBlueSapphireOre().setBlockName("blockBlueSapphireOre").setBlockTextureName(PilotMod.MODID + ":" + "bluesapphire_ore");
		
	
	//Item Name and Textures
	itemSapphire = new ItemSapphire().setUnlocalizedName("itemSapphire").setTextureName(PilotMod.MODID + ":" + "sapphire");
	axeSapphire = new AxeSapphire(ToolMaterial.EMERALD).setUnlocalizedName("axeSapphire").setTextureName(PilotMod.MODID + ":" + "hatchetSapphire");
	hoeSapphire = new HoeSapphire(ToolMaterial.EMERALD).setUnlocalizedName("hoeSapphire").setTextureName(PilotMod.MODID + ":" + "hoeSapphire");
	pickaxeSapphire = new PickaxeSapphire(ToolMaterial.EMERALD).setUnlocalizedName("pickaxeSapphire").setTextureName(PilotMod.MODID + ":" + "pickaxeSapphire");
	shovelSapphire = new ShovelSapphire(ToolMaterial.EMERALD).setUnlocalizedName("shovelSapphire").setTextureName(PilotMod.MODID + ":" + "shovelSapphire");
	foodStrawberry = new FoodStrawberry(4001, 2, true).setUnlocalizedName("foodStrawberry").setTextureName(PilotMod.MODID + ":" + "Strawberry");
	foodBurrito = new FoodBurrito(4001, 2, true).setUnlocalizedName("foodBurrito").setTextureName(PilotMod.MODID + ":" + "burrito");
	foodCereal = new FoodCereal(4001, 2, true).setUnlocalizedName("foodCereal").setTextureName(PilotMod.MODID + ":" + "cereal");
	foodSoda = new FoodSoda(4001, 2, true).setUnlocalizedName("foodSoda").setTextureName(PilotMod.MODID + ":" + "soda");
	swordSapphire = new SwordSapphire(ToolMaterial.EMERALD).setUnlocalizedName("swordSapphire").setTextureName(PilotMod.MODID + ":" + "swordSapphire");
	creativeTabIcon = new CreativeTabIcon().setUnlocalizedName("creativeTabIcon").setTextureName(PilotMod.MODID + ":" + "icon");
	itemBlueSapphireIngot = new ItemBlueSapphireIngot().setUnlocalizedName("itemBlueSapphireIngot").setTextureName(PilotMod.MODID + ":" + "blueSapphireIngot");
	
	//Armor
	sapphireHelmet = new SapphireArmor(ArmorMaterial.DIAMOND, sapphireHelmetID, 0).setUnlocalizedName("sapphireHelmet").setTextureName(PilotMod.MODID + ":" + "helmetSapphire");
	sapphireChestplate = new SapphireArmor(ArmorMaterial.DIAMOND, sapphireChestplateID, 1).setUnlocalizedName("sapphireChestplate").setTextureName(PilotMod.MODID + ":" + "chestplateSapphire");
	sapphireLeggings = new SapphireArmor(ArmorMaterial.DIAMOND, sapphireLeggingsID, 2).setUnlocalizedName("sapphireLeggings").setTextureName(PilotMod.MODID + ":" + "legsSapphire");
	sapphireBoots = new SapphireArmor(ArmorMaterial.DIAMOND, sapphireBootsID, 3).setUnlocalizedName("sapphireBoots").setTextureName(PilotMod.MODID + ":" + "bootsSapphire");

	//Luigi's Hat
	luigiHat = new LuigiHat(ArmorMaterial.DIAMOND, luigiHatID, 0).setUnlocalizedName("luigiHat").setTextureName(PilotMod.MODID + ":" + "luigiHatIcon");
	
	//Block Register
	GameRegistry.registerBlock(blockSapphireOre, blockSapphireOre.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockSapphire, blockSapphire.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockBlueSapphireOre, blockBlueSapphireOre.getUnlocalizedName().substring(5));
	GameRegistry.registerBlock(blockBlueSapphire, blockBlueSapphire.getUnlocalizedName().substring(5));
	
	//Item Register
    GameRegistry.registerItem(itemSapphire, itemSapphire.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(axeSapphire, axeSapphire.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(hoeSapphire, hoeSapphire.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(pickaxeSapphire, pickaxeSapphire.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(shovelSapphire, shovelSapphire.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(foodStrawberry, foodStrawberry.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(foodBurrito, foodBurrito.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(foodCereal, foodCereal.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(foodSoda, foodSoda.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(swordSapphire, swordSapphire.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(creativeTabIcon, creativeTabIcon.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(itemBlueSapphireIngot, itemBlueSapphireIngot.getUnlocalizedName().substring(5));
    
    //Armor
    GameRegistry.registerItem(sapphireHelmet, sapphireHelmet.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(sapphireChestplate, sapphireChestplate.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(sapphireLeggings, sapphireLeggings.getUnlocalizedName().substring(5));
    GameRegistry.registerItem(sapphireBoots, sapphireBoots.getUnlocalizedName().substring(5));
    
    //Luigi's Hat registry
    GameRegistry.registerItem(luigiHat, luigiHat.getUnlocalizedName().substring(5));
    
    //Entity Register
	registerEntity(EntityPilot.class, "entityPilot");
	registerEntity(EntityJorge.class, "entityJorge");
	registerEntity(EntityLuigi.class, "entityLuigi");
	registerEntity(EntitySebas.class, "entitySebas");
	registerEntity(EntityPagui.class, "entityPagui");
	registerEntity(EntityMajo.class, "entityMajo");
	registerRenderers();
    
    //Smelting
	GameRegistry.addSmelting(new ItemStack(this.blockSapphireOre), new ItemStack(this.itemSapphire), 5);
	GameRegistry.addSmelting(new ItemStack(this.blockBlueSapphireOre), new ItemStack(this.itemBlueSapphireIngot), 5);
	
    //Recipes
	
	
	//blockSapphire
	/*GameRegistry.addRecipe(new ItemStack(blockSapphire,1), new Object[]{
        "SSS",
        "SSS",
        "SSS",
        'S', this.itemSapphire 
    });*/
	BlockSapphire.getRecipe();
	
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "S  ",
        "   ",
        "   ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        " S ",
        "   ",
        "   ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "  S",
        "   ",
        "   ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "   ",
        "S  ",
        "   ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "   ",
        " S ",
        "   ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "   ",
        "  S",
        "   ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "   ",
        "   ",
        "S  ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "   ",
        "   ",
        " S ",
        'S', this.blockSapphire 
    });
	//itemSapphire
	GameRegistry.addRecipe(new ItemStack(itemSapphire,9), new Object[]{
        "   ",
        "   ",
        "  S",
        'S', this.blockSapphire 
    });
	
	//hoeSapphire
    GameRegistry.addRecipe(new ItemStack(hoeSapphire,1), new Object[]{
	       " SS",
	       " * ",
	       " * ",
	       'S', this.itemSapphire,
	       '*', Items.stick
	});
	//hoeSapphire
    GameRegistry.addRecipe(new ItemStack(hoeSapphire,1), new Object[]{
	       "SS ",
	       " * ",
	       " * ",
	       'S', this.itemSapphire,
	       '*', Items.stick
	});
    
	//pickaxeSapphire
    GameRegistry.addRecipe(new ItemStack(pickaxeSapphire,1), new Object[]{
	       "SSS",
	       " * ",
	       " * ",
	       'S', this.itemSapphire, 
	       '*', Items.stick
	});
    
    //axeSapphire
    GameRegistry.addRecipe(new ItemStack(axeSapphire,1), new Object[]{
	       " SS",
	       " *S",
	       " * ",
	       'S', this.itemSapphire, 
	       '*', Items.stick
	});
    //axeSapphire
    GameRegistry.addRecipe(new ItemStack(axeSapphire,1), new Object[]{
	       "SS ",
	       "S* ",
	       " * ",
	       'S', this.itemSapphire, 
	       '*', Items.stick
	});
    
    //shovelSapphire
    GameRegistry.addRecipe(new ItemStack(shovelSapphire,1), new Object[]{
	       "S  ",
	       "*  ",
	       "*  ",
	       'S', this.itemSapphire, 
	       '*', Items.stick
	});
    //shovelSapphire
    GameRegistry.addRecipe(new ItemStack(shovelSapphire,1), new Object[]{
	       " S ",
	       " * ",
	       " * ",
	       'S', this.itemSapphire, 
	       '*', Items.stick
	});
    //shovelSapphire
    GameRegistry.addRecipe(new ItemStack(shovelSapphire,1), new Object[]{
	       "  S",
	       "  *",
	       "  *",
	       'S', this.itemSapphire, 
	       '*', Items.stick
	});
    
    //swordSapphire
    GameRegistry.addRecipe(new ItemStack(swordSapphire,1), new Object[]{
	       "S  ",
	       "S  ",
	       "*  ",
	       'S', this.itemSapphire,
	       '*', Items.stick
	});
    //swordSapphire
    GameRegistry.addRecipe(new ItemStack(swordSapphire,1), new Object[]{
	       " S ",
	       " S ",
	       " * ",
	       'S', this.itemSapphire,
	       '*', Items.stick
	});
    //swordSapphire
    GameRegistry.addRecipe(new ItemStack(swordSapphire,1), new Object[]{
	       "  S",
	       "  S",
	       "  *",
	       'S', this.itemSapphire,
	       '*', Items.stick
	});
    
    //sapphireHelmet
    GameRegistry.addRecipe(new ItemStack(sapphireHelmet,1), new Object[]{
	       "SSS",
	       "S S",
	       "   ",
	       'S', this.itemSapphire
	});
    //sapphireHelmet
    GameRegistry.addRecipe(new ItemStack(sapphireHelmet,1), new Object[]{
	       "   ",
	       "SSS",
	       "S S",
	       'S', this.itemSapphire
	});
    
    //sapphireChestplate
    GameRegistry.addRecipe(new ItemStack(sapphireChestplate,1), new Object[]{
	       "S S",
	       "SSS",
	       "SSS",
	       'S', this.itemSapphire
	});
    
    //sapphireLeggings
    GameRegistry.addRecipe(new ItemStack(sapphireLeggings,1), new Object[]{
	       "SSS",
	       "S S",
	       "S S",
	       'S', this.itemSapphire
	});
    
    //sapphireBoots
    GameRegistry.addRecipe(new ItemStack(sapphireBoots,1), new Object[]{
	       "S S",
	       "S S",
	       "   ",
	       'S', this.itemSapphire
	});
    //sapphireBoots
    GameRegistry.addRecipe(new ItemStack(sapphireHelmet,1), new Object[]{
	       "   ",
	       "S S",
	       "S S",
	       'S', this.itemSapphire
	});
    
	//blockBlueSapphire
	GameRegistry.addRecipe(new ItemStack(blockBlueSapphire,1), new Object[]{
        "SSS",
        "SSS",
        "SSS",
        'S', this.itemBlueSapphireIngot 
    });
	
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "S  ",
        "   ",
        "   ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        " S ",
        "   ",
        "   ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "  S",
        "   ",
        "   ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "   ",
        "S  ",
        "   ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "   ",
        " S ",
        "   ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "   ",
        "  S",
        "   ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "   ",
        "   ",
        "S  ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "   ",
        "   ",
        " S ",
        'S', this.blockBlueSapphire 
    });
	//itemBlueSapphireIngot
	GameRegistry.addRecipe(new ItemStack(itemBlueSapphireIngot,9), new Object[]{
        "   ",
        "   ",
        "  S",
        'S', this.blockBlueSapphire 
    });
//preInit-END	
}
//Class-END
}

