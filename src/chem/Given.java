package chem;

import java.util.ArrayList;
import java.util.Scanner;

public class Given {
	
	static ArrayList<Integer> mole = new ArrayList<Integer>();
	static ArrayList<Double> value= new ArrayList<Double>();
	
	@SuppressWarnings("resource")
	public static void given() {
		
		System.out.print("Enter Given (H first): ");
		
		Scanner scan = new Scanner(System.in);
		String Givens = scan.nextLine();
		String[] split = Givens.split("\\s+");
		
		
		for (int i = 0; i < split.length; i++) {
			mole.add(Integer.parseInt(split[i]));
			value.add(Double.parseDouble(split[i+1]));
			i++;
		}
		
	}
	
	public static ArrayList<Integer> mole() {
		
		return mole;
	}
	
	public static ArrayList<Double> value() {
		
		return value;
	}

}
