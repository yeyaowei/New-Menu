package com.rhwteam.yeyaowei.NewMenu;

import java.lang.reflect.Field;

import org.lwjgl.opengl.Display;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Session;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = "NewMenu", name = "New Menu", version = "v1.2")
public class Menu
{
	@Mod.Instance("Menu")
	public static Menu instance;
	@Mod.EventHandler
	@SideOnly(Side.CLIENT)
	public void preInit(FMLPreInitializationEvent e)
	{
		Configuration config = new Configuration(e.getSuggestedConfigurationFile());
		config.load();
		//读取配置文件
		ConfigVar.onlinecheck = config.get("Online", "Check", false).getBoolean();
		ConfigVar.version = config.get("Online", "Version", "v1.0").getString();
		ConfigVar.announcementcheck = config.get("Online", "zAnnouncementCheck", false).getBoolean();
		ConfigVar.url = config.get("Online", "url", "http://127.0.0.1/").getString();
		ConfigVar.IsTwoAddress = config.get("Server", "1sTwoAddress", false).getBoolean();
		ConfigVar.ServerAddress = config.get("Server", "Address1", "127.0.0.1").getString();
		ConfigVar.ServerAddress1 = config.get("Server", "Address2", "127.0.0.1").getString();
		ConfigVar.Captain = config.get("Server", "Captain", "Minecraft 1.7.10").getString();
		ConfigVar.announcement = config.get("Server", "Announcement", "").getString();
		ConfigVar.announcementmove = config.get("Server", "AnnouncementMove", false).getBoolean();
		ConfigVar.debug = config.get("General", "debugMode", false).getBoolean();
		//结束读取
		config.save();
		Display.setTitle(ConfigVar.Captain);
		MinecraftForge.EVENT_BUS.register(NewMenuHandler.instance);
	}
}