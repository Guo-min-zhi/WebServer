package com.hackeric;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			Socket socket = new Socket("127.0.0.1", 8080);
			System.out.println("连接主机....");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			
			while(true){
				String line = read.readLine();
				out.println(line);
				out.flush();
				
				System.out.println(in.readLine());
				
				if(line.equals("end"))
					break;
			}
			System.out.println("关闭...");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
