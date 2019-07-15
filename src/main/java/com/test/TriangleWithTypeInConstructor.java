package com.test;

public class TriangleWithTypeInConstructor {
	
	private String type;

	public TriangleWithTypeInConstructor(String type) {
		super();
		this.type = type;
	}
	
	public void draw() {
		System.out.println("TriangleWithTypeInConstructor With Type "+ this.type);
	}

}
