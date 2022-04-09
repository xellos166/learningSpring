package com.ardent.spring.core.car;

public class Demo {

	public static void main(String[] args) {
		Car c =new Car("Red", "Safari", "Tata");
		System.out.println("Car created "+c);
		
		Engine e=new Engine(3, "Diesel", 1500);
		Car c1=new Car("Blue", "Harrier", e, "Tata");//2nd way of dependency injection 
		
		
		System.out.println(c1);

	}

}
