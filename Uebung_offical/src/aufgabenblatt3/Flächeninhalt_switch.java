//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 3.1

package aufgabenblatt3;

import java.util.Scanner;

/**
 * Aufgabenblatt3.1 implementiert mit switch().
 * Berrechnung des Flaecheninhaltes eines Kreises, Quadrates und Sechsecks
 * Mithilfe des Radius bzw. der Seitenl‰nge in beliebiger Einheit. Einheit ist abhaengig von der Eingabe 
 */

public class Fl‰cheninhalt_switch {
	public static void main(String [] args){
	
	Scanner scanner = new Scanner(System.in);

	System.out.println("Was moechten Sie berechnen:\n1 Kreis\n2 Ouadrat\n3 Sechseck\n"
			+ "Druecken Sie die entsprechende Ziffer auf ihrer Tastatur!");

	int eingabe = scanner.nextInt();

	
	switch (eingabe){
	
	case 1:
		System.out.println("Wie groﬂ soll der Radius sein?"); 
		double radius = scanner.nextDouble();
		double kreis = Math.PI*Math.pow(radius, 2);
		System.out.println("Die Flaeche des Kreises ergibt: "+kreis);
	break;
	
	case 2:
		System.out.println("Welche Seitenlaenge soll die Figur haben?"); 
		double seitenlaengequadrat = scanner.nextDouble();
		double quadrat = Math.pow(seitenlaengequadrat, 2);
		System.out.println("Die Flaeche des Quadrats ergibt: "+quadrat);
	break;
	
	case 3:
		System.out.println("Welche Seitenlaenge soll die Figur haben?"); 
		double seitenlaengesechseck = scanner.nextDouble();
		
		double sechseck = (Math.pow(seitenlaengesechseck, 2)*(3*Math.sqrt(3)))/2;
		System.out.println("Die Flaeche des Sechsecks ergibt: "+sechseck);
	break;
	
	default: System.out.println("Falsche Eingabe! Das Ergebnis lautet: -1");
	
	}
	
	
	scanner.close();
	
	}
	
}
