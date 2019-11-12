package com.sat.tv.enums;

/**
 * 
 * @author Akhil.Singla
 *
 */
public enum Services{
	
	LEARN_ENGLISH("LearnEnglish",200D),
	LEARN_COOKING("LearnCooking",100D);
	
	private String name;
	private Double price;
	
	Services(String name, Double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

}
