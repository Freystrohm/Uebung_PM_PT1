/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.3
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt4_Michel;

import java.util.Scanner;

public class MainRennauto {
public static void main(String[]args){
	/**
	 * Anzahl der Autos für die Benutzereingabe initialisiert mit 0
	 */
	int anzahlAutos=0; 
	/**
	 * Anzahl der Wetten für die Benutzereingabe initialisiert mit 0
	 */
	int anzahlWetten=0;
	
	double streckenlaenge; //Hilfsvariable
	//String spieler;
	//int wettEinsatz;
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Geben Sie die Streckenlaenge in Kilometer an: ");
	streckenlaenge = scan.nextDouble();
	/**
	 * Erstellen eines Rennes mit der zuvor ausgelesenen streckenlaenge
	 */
	Rennen rennen = new Rennen(streckenlaenge);
	System.out.println("Wieviele Autos sollen an dem Rennen Teilnehmen?");
	anzahlAutos = scan.nextInt();
	System.out.println("Wieviele Wetten möchten Sie aufgeben?: ");
	anzahlWetten = scan.nextInt();
	/**
	 * Erstellen eines Objektes wettBuero von Typ Wettbuero mit Parameter (rennen und anzahlWetten)
	 */
	Wettbuero wettBuero = new Wettbuero(rennen,anzahlWetten);
	/**
	 * erstellen eines auto3 von Typ Rennauto um den ermittelten Sieger darin abzuspeichern
	 */
	Rennauto auto3;
	Wette wette = null;
	
	rennen.eingabeRennen(anzahlAutos,scan);
	wettBuero.eingabeWette(anzahlWetten,scan,rennen);
	
	auto3=rennen.durchfuehren();
	auto3.ausgeben();
	/**
	 * Übergabe des Siegers als auto3 und die eingebene Wette an das wettbuero zu Auswertung der Sieger der Wetten.
	 */
	wettBuero.auswerten(auto3, wette);
}
	
	
}
