package com.infy.spring.boot.model;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Dog implements Animal {

	@Override
	public void animalCall() {
		System.out.println("Dog is barking..");
	}

}
