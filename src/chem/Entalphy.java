package chem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Entalphy {
	
	static BigDecimal bd1;
	
	public static void entalphy() {
		
		ArrayList<Integer> mole = Given.mole();
		ArrayList<Double> value = Given.value();
		
		System.out.println(" +==--Entalphy-------------------------------------------------------------------------------==+");
		System.out.println("  [" + mole.get(0) + "mol(" + value.get(0) + "KJ/mol)" + " + " + mole.get(1) + "mol(" + value.get(1) + "KJ/mol)] - [" + mole.get(2) + "mol(" + value.get(2) + "KJ/mol)" + " + " + mole.get(3) + "mol(" + value.get(3) + "KJ/mol)]");
		
		ArrayList<Double> multiply = new ArrayList<Double>();
		for (int i = 0; i < 4; i++) {
			double n = mole.get(i) * value.get(i);
			multiply.add(n);
		}
		
		System.out.println("  [(" + multiply.get(0) + "KJ) + (" + multiply.get(1) + "KJ)] - [(" + multiply.get(2) + "KJ) + (" + multiply.get(3) + "KJ)]" );
		
		ArrayList<Double> addition = new ArrayList<Double>();
		for (int i = 0; i < 4; i++) {
			double n = multiply.get(i) + multiply.get(i+1);
			addition.add(n);
			i++;
		}
		
		System.out.println("  [(" + addition.get(0) + "KJ) - (" + addition.get(1) + "KJ)]" );
		
		double minus = addition.get(0) - addition.get(1);
		BigDecimal bd = new BigDecimal(minus).setScale(2, RoundingMode.HALF_UP);
		double finale = bd.doubleValue();
		
		if (Pick.ifEntropy().equals("s") || Pick.ifEntropy().equals("S") || Pick.ifEntropy().equals("g") || Pick.ifEntropy().equals("G")) {
			double finaleJoules = finale * 1000;
			bd1 = new BigDecimal(finaleJoules).setScale(0, RoundingMode.HALF_UP);
			System.out.println("  " + finale + "KJ × 1000J/1KJ = " + bd1 + "J");
		} else if (Pick.ifEntropy().equals("h") || Pick.ifEntropy().equals("H")) {
			System.out.println("  " + finale + "KJ  ");
		} else { System.out.println(Pick.ifEntropy()); }
		
		System.out.println(" +==-----------------------------------------------------------------------------------------==+");
		
	}
	
	public static Double HFinal() {
		
		double hJoules = bd1.doubleValue();
		return hJoules;
	}
}
