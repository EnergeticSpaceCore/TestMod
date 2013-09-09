package energeticspacecore.testmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.Mod.Init;
//import cpw.mods.fml.common.Mod.PostInit;
//import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import energeticspacecore.testmod.block.TestBlock;
import energeticspacecore.testmod.lib.Reference;

@Mod( modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired=true)
public class TestMod {

	public final static Block testDirt = new TestBlock(500, Material.ground).setHardness(0.5F).setStepSound(Block.soundGravelFootstep).setUnlocalizedName("testDirt").setCreativeTab(CreativeTabs.tabBlock);
	
	@Instance(value = "TestMod")
	public static TestMod instance;
	
	@SidedProxy(clientSide="energeticspacecore.testmod.client.ClientProxy",serverSide="energeticspacecore.testmod.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public void load(FMLInitializationEvent event) {
		LanguageRegistry.addName(testDirt, "Test Dirt");
		MinecraftForge.setBlockHarvestLevel(testDirt, "shovel", 0);
		GameRegistry.registerBlock(testDirt, "testDirt");
		
		proxy.registerRenderers();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}