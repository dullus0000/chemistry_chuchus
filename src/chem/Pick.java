package chem;

import java.util.Scanner;

public class Pick {
	
	static String s = "";
	static String[] tempType;
	@SuppressWarnings("resource")
	public static void pick() {
		
		System.out.print("Which process? (H, S, G): ");
		Scanner scan = new Scanner(System.in);
		s = scan.nextLine();
		
		if (s.equals("H") || s.equals("h")) {
			System.out.println("-- You picked Entalphy --");
			Entalphy.entalphy();
		} else if (s.equals("S") || s.equals("s")) {
			
			Scanner scan1 = new Scanner(System.in);
			System.out.print("Enter Temperature: ");
			tempType = scan1.nextLine().split("\\s+");
			
			if (Given.mole().size() < 5) {
				System.out.println("-- Ewwor --");
				System.exit(0);
			} else {
				System.out.println("-- You picked Entropy --");
				Entropy.entropy();
				Entalphy.entalphy();
				UnivEntropy.surr();
			}
			
		} else if (s.equals("G") || s.equals("g")) {
			
			Scanner scan1 = new Scanner(System.in);
			System.out.print("Enter Temperature: ");
			tempType = scan1.nextLine().split("\\s+");
			
			if (Given.mole().size() < 5) {
				System.out.println("-- Ewwor --");
				System.exit(0);
			} else {
				System.out.println("-- You picked Gibbs Free Energy --");
				Entropy.entropy();
				Entalphy.entalphy();
				Gibbs.gibbs();
			}
			
		} else if (s.isEmpty()){ 
			System.out.println("-- Ewwor --");
			pick();
		}
		
	}
	
	public static String ifEntropy() {
		
		return s;
	}
	
	public static Integer Temperature() {

		int temp = 0;
		if (tempType[1].equals("C")) {
			temp = Integer.parseInt(tempType[0]) + 273; 
		} else if (tempType[1].equals("K")) {
			temp = Integer.parseInt(tempType[0]);
		}
			
		return temp;
	}
}
