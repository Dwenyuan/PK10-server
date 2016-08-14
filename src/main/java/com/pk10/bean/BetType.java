package com.pk10.bean;

public enum BetType {
	NUMBER("数字"), SINGLE_OR_DOUBLE("单双"), BIG_OR_SMALL("大小");
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private BetType(String name) {
		this.name = name;
	}
}
