package com.hackeric;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Response {

	private OutputStream out = null;
	
	public Response(OutputStream out){
		this.out = out;
	}
	
	public void sendURIResource(String uri){
		String pathname = System.getProperty("user.dir") + File.separator + uri;
		
		try{
			File file = new File(pathname);
			if(file.exists()){
				InputStream in = new BufferedInputStream(new FileInputStream(file));
				int b;
				while((b = in.read()) != -1){
					out.write(b);
				}
			}else{
				out.write("your url is incorrect, please make sure.".getBytes());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
