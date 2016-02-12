package com.rhwteam.yeyaowei.NewMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class HttpLoad {
	public static String LoadText(String strURL)
	{
	    StringBuilder contentBuf = new StringBuilder();  
		if(ConfigVar.onlinecheck)
		{
			try
			{
			    URL url = new URL(strURL);  
			    HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();  
			    InputStreamReader input = new InputStreamReader(httpConn  
			            .getInputStream(), "utf-8");  
			    BufferedReader bufReader = new BufferedReader(input);  
			    String line = "";  
			    while ((line = bufReader.readLine()) != null) {  
			        contentBuf.append(line).append("\n");
			    }
			}
			catch(final MalformedURLException e)
			{
				e.printStackTrace();
				return "offline";
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return "offline";
			} catch (IOException e) {
				e.printStackTrace();
				return "offline";
			}
		    String buf = contentBuf.toString();
		    System.out.println(buf);
			return buf;
		}
		return "offline";
	}
}
