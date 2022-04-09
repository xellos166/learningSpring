package com.ardent.spring.core.car;

public class Engine {
	
	private int hp;
	private String type;
	private float cc;
	
	public Engine(int hp, String type, float cc) {
		super();
		this.hp = hp;
		this.type = type;
		this.cc = cc;
	}

	@Override
	public String toString() {
		return "Engine [hp=" + hp + ", type=" + type + ", cc=" + cc + "]";
	}
	
	

}
