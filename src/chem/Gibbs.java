package chem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Gibbs {

	public static void gibbs() {
		
		int temp = Pick.Temperature();
		double hFinal = Entalphy.HFinal();
		double sFinal = Entropy.SFinal();

		double multiply = temp * sFinal;
		BigDecimal bd = new BigDecimal(multiply).setScale(2, RoundingMode.HALF_UP);
		multiply = bd.doubleValue();
		System.out.println("+==--Gibbs-------------==+  ");
		System.out.println("  " + hFinal + "J - (" + temp + "K)(" + sFinal+ "J/K)");
		System.out.println("  " + hFinal + "J - (" + multiply + "J)");
		
		double finale = hFinal - multiply; 
		BigDecimal bd1 = new BigDecimal(finale).setScale(2, RoundingMode.HALF_UP);
		finale = bd1.doubleValue();
		System.out.println("  " + finale + "J");
		
		if (finale < 0 ) {
			System.out.println("  Spontaneous Reaction");
		} else if (finale > 0) {
			System.out.println("  Nonspontaneous Reaction");
		}
		System.out.println("+==--------------------==+  ");

		//double gibbs = hFinal - (temp * sFinal);	}
	}
}
