package com.rhwteam.yeyaowei.NewMenu;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;

import cpw.mods.fml.common.FMLLog;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSlot;
import net.minecraft.client.gui.GuiSnooper;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.resources.I18n;

public class GuiChangeLog extends GuiScreen {
	private GuiScreen parentScreen;
	private String changeLog;
	private GuiButton btnUp;
	private GuiButton btnDown;
	private int page = 0;
	private int maxPage;
	private final java.util.List changeLogList = new ArrayList();
	private GuiChangeLog.List changeLogSlot;
	public GuiChangeLog (GuiScreen parent, String Log)
	{
		this.parentScreen = parent;
		this.changeLog = Log;
	}
	public void initGui()
	{
		this.changeLogList.clear();
		this.buttonList.clear();
        this.buttonList.add(new GuiButton(0, this.width / 2 - 150, this.height - 30,300,20, I18n.format("gui.toMenu", new Object[0])));
        /** 分割每一行的记录 */
        String[] lineArray = changeLog.split("\n");
        for(String s : lineArray)
        {
        	
        	changeLogList.add(s);
        }
        this.changeLogSlot = new GuiChangeLog.List();
	}
	public void drawScreen(int par1, int par2, float par3)
	{
		this.drawDefaultBackground();
		this.changeLogSlot.drawScreen(par1, par2, par3);
        this.drawCenteredString(this.fontRendererObj, "更新日志", this.width / 2, this.height / 4 - 50, 16777215);
        super.drawScreen(par1, par2, par3);
	}
    protected void actionPerformed(GuiButton btnId)
    {
        if (btnId.id == 0)
        {
            this.mc.displayGuiScreen(this.parentScreen);
        }
    }
    class List extends GuiSlot
    {
    	public List()
    	{
    		super(GuiChangeLog.this.mc, GuiChangeLog.this.width, GuiChangeLog.this.height, 30, GuiChangeLog.this.height - 45, GuiChangeLog.this.fontRendererObj.FONT_HEIGHT - 1);
    	}

		@Override
		protected int getSize() {
			// TODO Auto-generated method stub
			return GuiChangeLog.this.changeLogList.size();
		}

		@Override
		protected void elementClicked(int p_148144_1_, boolean p_148144_2_, int p_148144_3_, int p_148144_4_) {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected boolean isSelected(int p_148131_1_) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		protected void drawBackground() {
			// TODO Auto-generated method stub
			
		}

		@Override
		protected void drawSlot(int p_148126_1_, int p_148126_2_, int p_148126_3_, int p_148126_4_,
				Tessellator p_148126_5_, int p_148126_6_, int p_148126_7_) {
			// TODO Auto-generated method stub
            GuiChangeLog.this.fontRendererObj.drawString((String)GuiChangeLog.this.changeLogList.get(p_148126_1_), 10, p_148126_3_, 16777215);
			
		}
        protected int getScrollBarX()
        {
            return this.width - 10;
        }
    }
}
