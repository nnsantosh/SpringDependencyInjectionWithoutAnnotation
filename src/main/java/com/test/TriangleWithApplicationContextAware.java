package com.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//Let us assume we have prototype beans as dependency
//In such a case this 
public class TriangleWithApplicationContextAware implements ApplicationContextAware{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext context;

	public Point getPointA() {
		return (Point)context.getBean("pointA");
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return (Point)context.getBean("pointB");
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return (Point)context.getBean("pointC");
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
		
	}
	
	public void draw() {
		System.out.println("TriangleWithApplicationContextAware.draw() A: "+this.pointA + " B: " +this.pointB+ " C: " +this.pointC);
	}

}
