package com.rhwteam.yeyaowei.NewMenu.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.rhwteam.yeyaowei.NewMenu.ConfigVar;
public class InternetUtil {
	public static String LoadText(String strURL)
	{
		if(ConfigVar.onlinecheck)
		{	
			try {
				return getNetContent(strURL);
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	public static String getNetContent(String url) throws IOException {
		URL u = new URL(url);
		return getStreamContent(u.openStream());
	}
	
	public static String getStreamContent(InputStream is) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		String c = "", line;
		while((line = reader.readLine()) != null)
			c += "\n" + line;
		return c.substring(1);
	}
	
	public static void writeToStream(OutputStream os, String content) throws IOException {
		OutputStreamWriter writer = new OutputStreamWriter(os);
		writer.write(content);
		writer.flush(); writer.close();
	}
	
	public static String post(String url, String content) throws IOException {
		URL u = new URL(url);
		URLConnection c = u.openConnection();
		c.setDoOutput(true);
		writeToStream(c.getOutputStream(), content);
		return getStreamContent(c.getInputStream());
	}
}
