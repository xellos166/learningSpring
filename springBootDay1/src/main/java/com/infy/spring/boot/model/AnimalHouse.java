package com.infy.spring.boot.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class AnimalHouse {
	@Autowired
//	@Qualifier("cat")
	private Animal dog;
	//Below is an example of constructor injection using @Qualifier
//	@Autowired
//	public AnimalHouse(@Qualifier("cat") Animal animal) {
//		super();
//		this.animal = animal;
//	}
	

	public void printAnimalHouse() {
		dog.animalCall();
	}


	public Animal getAnimal() {
		return dog;
	}
	//Below is an example of setter injection using @Qualifier
//	@Autowired
//	public void setAnimal(@Qualifier("cat") Animal animal) {
//		this.animal = animal;
//	}

}
