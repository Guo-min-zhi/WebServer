package com.hackeric;

public class Request {
	
	private String content = null;

	public Request(String content){
		this.content = content;
	}
	
	public String parse(){
		String uri = null;
		String[] lines = content.split("\n");
		if(lines.length > 0){
			String[] tokens = lines[0].split(" ");
			if(tokens.length > 1){
				uri = tokens[1].substring(1);
			}
		}
		return uri;
	}
}
