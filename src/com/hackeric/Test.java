package com.hackeric;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("a:"+System.getProperty("user.dir") + File.separator + "a");
		
		System.out.println("----");
		
		try{
			InputStream in = new BufferedInputStream(new FileInputStream("src/settings.properties"));
			Properties p = new Properties();
			p.load(in);
			
			System.out.println(p.getProperty("location")+":"+p.getProperty("port"));
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
