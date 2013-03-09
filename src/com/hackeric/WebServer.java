package com.hackeric;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
	
	private int port = 8080;
	private ServerSocket server = null;
	
	public WebServer() {
		try{
			server = new ServerSocket(port, 5, InetAddress.getByName("127.0.0.1"));
			System.out.println("����������....");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("����������ʧ��....");
		}
	}
	
	public void listen(){
		//������
		while(true){
			Socket socket = null;
			try{
				socket = server.accept();
				System.out.println("����µ�����");
				
				BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter out = new PrintWriter(socket.getOutputStream());

				while(true){
					String line = in.readLine();
					System.out.println("�յ���"+line);
					
					out.println("Has received!");
					out.flush();
					
					if(line.equals("end"))
						break;
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				if(socket != null){
					try{
						socket.close();
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WebServer server = new WebServer();
		server.listen();
	}

}
