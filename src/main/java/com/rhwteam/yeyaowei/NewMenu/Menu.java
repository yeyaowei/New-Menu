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
		ConfigVar.onlinecheck = config.get("Online", "Check", true).getBoolean();
		ConfigVar.version = config.get("Online", "Version", "v4.0").getString();
		ConfigVar.announcementcheck = config.get("Online", "zAnnouncementCheck", true).getBoolean();
		ConfigVar.url = "http://www.rhw-team.com/SimpleCloud/Files/";
		ConfigVar.IsTwoAddress = config.get("Server", "1sTwoAddress", false).getBoolean();
		ConfigVar.ServerAddress = config.get("Server", "Address1", "f1.suteidc.com:26966").getString();
		ConfigVar.ServerAddress1 = config.get("Server", "Address2", "f1.suteidc.com:26966").getString();
		ConfigVar.Captain = config.get("Server", "Captain", "羁绊服务器客户端 " + ConfigVar.version).getString();
		ConfigVar.announcement = config.get("Server", "Announcement", "").getString();
		ConfigVar.announcementmove = config.get("Server", "AnnouncementMove", false).getBoolean();
		ConfigVar.debug = config.get("General", "debugMode", false).getBoolean();
		//结束读取
		config.save();
		Display.setTitle(ConfigVar.Captain);
		MinecraftForge.EVENT_BUS.register(NewMenuHandler.instance);
	}
}