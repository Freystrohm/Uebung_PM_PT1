//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 2

package aufgabenblatt2;

import java.util.Scanner;

// Ganzzahlen umrechnen -> Runden
// Abfrage -> Einheiten

/**
 * Berechnen des BMI's aus Groesse und Gewicht 
 *
 */

public class BodyMassIndex {
	public static void main (String [] args){
		
		double groesse;
		double gewicht;
		double bmi;
		int bmigerundet;
		
		Scanner scan =new Scanner(System.in);
		
		System.out.println("Wieviel wiegen Sie in Kilogramm?: ");
		
		gewicht = scan.nextDouble();
		
		System.out.println("Wie groﬂ sind Sie in Metern?: ");
		
		groesse = scan.nextDouble();
		
		bmi = gewicht / (groesse*groesse);
		
		System.out.println ("Ihr BMI liegt bei: " + bmi);
		
		//Math.round()
		
		bmigerundet = (int) (bmi+0.5);
		
		System.out.println ("Ihr BMI liegt gerundet bei: " + bmigerundet);
		
		scan.close();		
	}

}
