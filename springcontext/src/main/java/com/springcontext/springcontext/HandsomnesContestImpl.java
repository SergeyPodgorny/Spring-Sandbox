package com.springcontext.springcontext;

@ShowTransaction
public class HandsomnesContestImpl implements HandsomnesContest{

	
	
	private Cat firstCat;
	
	private Cat secondCat;
	
	
	
	@Override
	public void evaluateHandsomnes() {
		
		System.out.println("first cat: "+ firstCat.getName());
		System.out.println("second cat: "+ secondCat.getName());
		
		
		if(firstCat.getHandsomnes() > secondCat.getHandsomnes()) {
			System.out.println("The winner is :" + firstCat.getName()+ " with cutines: " + firstCat.getHandsomnes());
		} else if (firstCat.getHandsomnes() < secondCat.getHandsomnes()){
			System.out.println("The winner is :" + secondCat.getName()+ " with cutines: " + secondCat.getHandsomnes());
		} else {
			System.out.println("Both cats are cute!");
		}
		
		
	}



	public Cat getFirstCat() {
		return firstCat;
	}



	public void setFirstCat(Cat firstCat) {
		this.firstCat = firstCat;
	}



	public Cat getSecondCat() {
		return secondCat;
	}



	public void setSecondCat(Cat secondCat) {
		this.secondCat = secondCat;
	}
	
	
	
	
	
	
}
