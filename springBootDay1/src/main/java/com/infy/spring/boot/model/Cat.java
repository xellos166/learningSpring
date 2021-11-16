package com.infy.spring.boot.model;

import org.springframework.stereotype.Component;

@Component

public class Cat implements Animal {

	@Override
	public void animalCall() {
		System.out.println("Cat does meow...");
		}

	}


