package yose;

import java.util.List;


public class Decomposition {
	
	private int number;
	private List decomposition;
	private String number2;
	private String error;
	
	public Decomposition(int number, List<Integer> arr){
		this.number = number;
		this.decomposition = arr;
	}
	
	public Decomposition(String number, String error){
		this.number2 = number;
		this.error = error;
	}
	
}
