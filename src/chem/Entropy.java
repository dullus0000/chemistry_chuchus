package chem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Entropy {
	
	static BigDecimal bd;
	
	public static void entropy() {
		
		ArrayList<Integer> mole = Given.mole();
		ArrayList<Double> value = Given.value();
		
		System.out.println(" +==--Entropy---------------------------------------------------------------------------------==+");
		System.out.println("  [" + mole.get(4) + "mol(" + value.get(4) + "J/mol*K)" + " + " + mole.get(5) + "mol(" + value.get(5) + "J/mol*K)] - [" + mole.get(6) + "mol(" + value.get(6) + "J/mol*K)" + " + " + mole.get(7) + "mol(" + value.get(7) + "J/mol*K)]");
		
		ArrayList<Double> multiply = new ArrayList<Double>();
		for (int i = 0; i < 4; i++) {
			double n = mole.get(i+4) * value.get(i+4);
			multiply.add(n);
		}
		
		System.out.println("  [(" + multiply.get(0) + "J/K) + (" + multiply.get(1) + "J/K)] - [(" + multiply.get(2) + "J/K) + (" + multiply.get(3) + "J/K)]" );
		
		ArrayList<Double> addition = new ArrayList<Double>();
		for (int i = 0; i < 4; i++) {
			double n = multiply.get(i) + multiply.get(i+1);
			addition.add(n);
			i++;
		}
		
		System.out.println("  [(" + addition.get(0) + "J/K) - (" + addition.get(1) + "J/K)]" );
		
		double finale = addition.get(0) - addition.get(1);
		bd = new BigDecimal(finale).setScale(2, RoundingMode.HALF_UP);
		System.out.println("  " + bd + "KJ  ");
		System.out.println(" +==-----------------------------------------------------------------------------------------==+");
		
	}
	
	public static Double SFinal() {
		double sJoules = bd.doubleValue();
		return sJoules;
		
	}
}
