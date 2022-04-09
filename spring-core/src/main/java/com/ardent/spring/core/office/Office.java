package com.ardent.spring.core.office;

public class Office {
	
	private Printer printer = new InkJetPrinter();//<--create dependencies inline

	
	public Office(Printer printer) {
		super();
		this.printer = printer;
	}
	public Office() {
		
	}

	@Override
	public String toString() {
		return "Office [printer=" + printer + "]";
	}

}
