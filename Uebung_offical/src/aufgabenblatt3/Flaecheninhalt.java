//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 3.1

package aufgabenblatt3;

import java.util.Scanner;

// Sechseck: Rechnung

/**
 * Aufgabenblatt3.1 implementiert mit if-else(). Berrechnung des
 * Flaecheninhaltes eines Kreises, Quadrates und Sechsecks Mithilfe des Radius
 * bzw. der Seitenlänge in beliebiger Einheit. Einheit ist abhaengig von der
 * Eingabe
 */

public class Flaecheninhalt {
	public static void main(String[] args) {
		final double PI = 3.14159;
		double eingabe = 0;
		double ergebnis = 0;
		int i = 0;

		
		Scanner scan = new Scanner(System.in);

		while (i != 4) {
			System.out.println(
					"Brechnen des Flächeninhaltes von\n1 einem Kreis\n2 "
							+ "einem Quadrat\n3 einem Sechseck\n4 Beenden des Programms");
			System.out.print(
					"Waehle was du berechnen willst, durch Eingabe der jeweiligen Indexzahl: ");
			i = scan.nextInt();

			if (i < 4) {
				System.out.print(
						"Wie gross ist die Seitelänge bzw. der Radius der zur berechnenden Figur?: ");
				eingabe = scan.nextDouble();
			}

			if (i == 1) {
				ergebnis = PI * (eingabe * eingabe);
			} else if (i == 2) {
				ergebnis = eingabe * eingabe;
			} else if (i == 3) {
				ergebnis = (eingabe * eingabe) * (3.0 / 2) * Math.sqrt(3);//(Math.pow(seitenlaengesechseck, 2)*(3*Math.sqrt(3)))/2
			} else if (i == 4) {
				System.out.println("Programm wird beendet\n\n");
				scan.close();
				continue;
			} else {
				ergebnis = -1;
				System.out.println("Dein Ergebnis ist:" + ergebnis
						+ "/nFalsche Eingabe \nTRY AGAIN\n\n");
				continue;
			}
			System.out.println("Dein Ergebnis ist: " + ergebnis);
		}

	}
}
