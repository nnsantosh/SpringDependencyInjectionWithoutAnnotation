package com.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApplication {
	
	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//Instantiation Using BeanFactory
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/spring.xml"));
		Triangle triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();
		
		//Instantiation using ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle1 = (Triangle) context.getBean("triangle");
		triangle1.draw();
		
		//Example of setter injection with properties
		TriangleWithType triangle2 = (TriangleWithType) context.getBean("triangleWithType");
		triangle2.draw();
		
		//Example of constructor injection
		TriangleWithTypeInConstructor triangle3 = (TriangleWithTypeInConstructor) context.getBean("triangleWithTypeInConstruct");
		triangle3.draw();
		
		//Example of setter injection with object injected as dependencies
		TriangleWithPoints triangle4 = (TriangleWithPoints) context.getBean("triangleWithPoints");
		triangle4.draw();
		Point pointA = triangle4.getPointA();
		Point pointA1 = triangle4.getPointA();
		boolean sameObject = pointA == pointA1;
		System.out.println("pointA11 == pointA12 single singleton objects"+sameObject);
		
		//Example of setter inject with Collections object
		TriangleWithListOfPoints triangle5 = (TriangleWithListOfPoints) context.getBean("triangleWithListOfPoints");
		triangle5.draw();
		
		//Example of setter injection with object injected as dependencies
		TriangleWithPointsAutowire triangleWithPointsAutowire = (TriangleWithPointsAutowire) context.getBean("triangleWithPointsAutoWire");
		triangleWithPointsAutowire.draw();
		
		//Instantiation using ApplicationContext and inner beans
		ApplicationContext context1 = new ClassPathXmlApplicationContext("springWithInnerBeans.xml");
		TriangleWithPoints triangle6 = (TriangleWithPoints) context1.getBean("triangleWithPointsInner");
		triangle6.draw();
		
		
		//Instantiation using ApplicationContext Aware Bean and prototype implementation
		ApplicationContext context2 = new ClassPathXmlApplicationContext("springWithPrototypes.xml");
		TriangleWithApplicationContextAware triangleWithApplicationContextAware = (TriangleWithApplicationContextAware) context2.getBean("triangleWithApplicationContextAware");
		Point pointA11 = triangleWithApplicationContextAware.getPointA();
		Point pointA12 = triangleWithApplicationContextAware.getPointA();
		boolean sameObject1 = pointA11 == pointA12;
		System.out.println("pointA11 != pointA12 since prototype objects"+sameObject1);
		
		//Instantiation using bean definition inheritance
		ApplicationContext context3 = new ClassPathXmlApplicationContext("springWithBeanDefinitionInheritance.xml");
		TriangleWithPoints triangle1WithInheritance = (TriangleWithPoints) context3.getBean("triangle1");
		triangle1WithInheritance.draw();
		
	}

}
