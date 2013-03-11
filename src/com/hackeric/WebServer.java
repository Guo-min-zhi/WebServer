package com.hackeric;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.utils.ServerInfo;

public class WebServer {
	
	private int port ;
	private String location = null;
	private ServerSocket server = null;
	
	public WebServer() {
		try{
			//read the ip and port from setting file
			port = ServerInfo.getServerPort();
			location = ServerInfo.getServerLocation();
			server = new ServerSocket(port, 5, InetAddress.getByName(location));
			System.out.println("服务器启动...");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("服务器启动失败....");
		}
	}
	
	public void listen(){
		//多用户
		while(true){
			Socket socket = null;
			try{
				socket = server.accept();
				System.out.println("获得一个链接....");
				
				InputStream input = socket.getInputStream();
				OutputStream output = socket.getOutputStream();
				
				StringBuffer str = new StringBuffer(2048);
				byte[] b = new byte[2048];
				int len = input.read(b);
				int j;
				for(j=0; j<len; j++){
					str.append((char)b[j]);
				}
				//将收到的信息进行解析
				Request request = new Request(str.toString());
				String uri = request.parse();
				
				//将获得的uri发送给请求方
				if(uri != null){
					Response response = new Response(output);
					response.sendURIResource(uri);
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
