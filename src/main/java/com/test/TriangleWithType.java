package com.test;

public class TriangleWithType {
	
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public void draw() {
		System.out.println("Triangle With Type "+ this.type);
	}

}
