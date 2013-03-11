package com.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ServerInfo {
	
	private static InputStream in = null;
	private static Properties p = null;
	
	static{
		final String file = "src/settings.properties";
		try{
			in = new BufferedInputStream(new FileInputStream(file));
			p = new Properties();
			p.load(in);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static String getServerLocation(){
		return p.getProperty("location");
	}
	
	public static int getServerPort(){
		return Integer.parseInt(p.getProperty("port"));
	}
}
