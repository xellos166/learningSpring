package com.ardent.spring.core.office;

public class OfficeDemo {

	public static void main(String[] args) {
		Office o=new Office();
		System.out.println(o);
		
		
		Printer p =new LeaserPrinter();
		Office o1=new Office(p);
		System.out.println(o1);
		

	}

}
