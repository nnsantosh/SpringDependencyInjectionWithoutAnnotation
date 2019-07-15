package com.test;

import java.util.List;

public class TriangleWithListOfPoints {
	
	private List<Point> points;

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
	
	public void draw() {
		points.forEach((point) -> {
			System.out.println("TriangleWithListOfPoints.draw() X: "+point.getX() + " Y: " +point.getY());
		});
	}
	
	

}
