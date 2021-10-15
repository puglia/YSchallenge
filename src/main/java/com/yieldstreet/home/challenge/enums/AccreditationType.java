package com.yieldstreet.home.challenge.enums;

public enum AccreditationType {
	
	BY_INCOME("by_income"),
	NETWORTH("networth"),
	CERTIFICATION("professional_certification"),
	OTHER("other");
	
	private String name;
	
	AccreditationType(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

}
