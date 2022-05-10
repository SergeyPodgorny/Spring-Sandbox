package com.springcontext.springcontext;

public class Cat {
	
	
	private String name;
	
	
	@CalculateHandsomnes(minHandsomnes = 2, maxHandsomnes = 5)
	private int handsomnes;


	public Cat() {
		// TODO Auto-generated constructor stub
	}


	public Cat(String name, int handsomnes) {
		this.name = name;
		this.handsomnes = handsomnes;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHandsomnes() {
		return handsomnes;
	}


	public void setHandsomnes(int handsomnes) {
		this.handsomnes = handsomnes;
	}

	
	
	
	
	
	
	

}
