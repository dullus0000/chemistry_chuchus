package chem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class UnivEntropy {
	
	public static void surr() {
		
		int temp = Pick.Temperature();
		double hFinal = Entalphy.HFinal();
		double sFinal = Entropy.SFinal();
		double surrFinal = -(hFinal)/temp;
		BigDecimal bd = new BigDecimal(surrFinal).setScale(2, RoundingMode.HALF_UP);
		surrFinal = bd.doubleValue();
		System.out.println(" +==--Surr--------------==+  ");
		System.out.println("  -(" + hFinal + "J)/" + temp + "K");
		System.out.println("  " + surrFinal + "J/K");
	    
		univ(sFinal, surrFinal);
	}
	
	private static void univ(double sys, double surr) {
		double univ = sys + surr;
		BigDecimal bd = new BigDecimal(univ).setScale(2, RoundingMode.HALF_UP);
		univ = bd.doubleValue();
		
		System.out.println(" +==--Univ--------------==+  ");
		System.out.println("  (" + sys + "J/K) + (" + surr + "J/K)");
		System.out.println("  " + univ + "J/K");
		
		if (univ > 0 ) {
			System.out.println("  Spontaneous Reaction");
		} else if (univ < 0) {
			System.out.println("  Nonspontaneous Reaction");
		}
		
		System.out.println(" +==--------------------==+  ");
	}

}
