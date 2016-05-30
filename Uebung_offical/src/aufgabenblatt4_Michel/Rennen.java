/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.3
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt4_Michel;

import java.util.Scanner;

public class Rennen {

	private int anzahlRennautos = 0;
	private double streckenlaenge;
	private Rennauto[] listeRennautos;
	Rennauto[] zwischenspeicher;

	// Konstruktor
	public Rennen(double streckenlaenge) {
		listeRennautos = new Rennauto[1];
		this.anzahlRennautos = 0;
		this.streckenlaenge = streckenlaenge;
	}

	// Methoden
/**
 * Benutzereingabe zum Namen, Typ und Maximalgeschwindigkeit der Fahrerin bzw Rennautos.
 * Anschlieﬂend ‹bergabe der Parameter an die Methode addRennauto
 * @param autoanzahl
 * @param scan
 */
	public void eingabeRennen(int autoanzahl, Scanner scan) {

		String fahrername;
		String fahrzeugtyp;
		double maxgeschwindigkeit;
		
		for (int i = 0; i < autoanzahl; i++) {
			System.out.println("Angaben zu der Fahrerin bzw. des Rennautos mit der Nummer "+(i+1)+"\n");
			System.out.println("Name der Fahrerin: ");
			fahrername = scan.next();
			System.out.println("Typ des Fahrzeugs: ");
			fahrzeugtyp = scan.next();
			System.out.println("Maximalgeschwindigkeit des Fahrzeugs: ");
			maxgeschwindigkeit = scan.nextDouble();
			Rennauto auto = new Rennauto(fahrername, fahrzeugtyp, maxgeschwindigkeit);
			addRennauto (auto);
		}

	}
public Rennauto[] getRennauto(){
	return this.listeRennautos;
}
public double getStreckenlaenge(){
	return this.streckenlaenge;
}
/**
 * Speichern der Rennautos in das Array listeRennautos & Verdopplung der Grˆﬂe des Arrays, falls diese zu klein wird.
 * @param rennauto
 */
	public void addRennauto(Rennauto rennauto) {
		if (listeRennautos[listeRennautos.length - 1] != null) {
			zwischenspeicher = new Rennauto[listeRennautos.length * 2];
			System.arraycopy(listeRennautos, 0, zwischenspeicher, 0, listeRennautos.length);
			listeRennautos = zwischenspeicher;
		}

		for (int i = 0; i < listeRennautos.length; i++) {
			if (listeRennautos[i] == null) {
				listeRennautos[i] = rennauto;
				break;
			}

		}
		anzahlRennautos++;
	}
/**
 * Ermitteln des Rennsiegers duch vergleich der gefahrenen Strecke und der Streckenlaenge des Rennens.
 * R¸ckgabe des Autos aus dem Array listeRennautos. 
 * Falls kein Sieger ermittelt werden kˆnnte wird null zur¸ckgegeben.
 * @return
 */
	public Rennauto ermittleSieger() {
		for (int i = 0; i < anzahlRennautos; i++) {
			if (this.streckenlaenge <= listeRennautos[i].fahrstrecke) {
				return listeRennautos[i];
			}
		}
		return null;

	}

/**
 * Alle Autos in der listeRennautos werden mit der Methode fahren() einen Schritt weitergesetzt.
 */
	public void schritt() {
		for (int i = 0; i < anzahlRennautos; i++) {
			listeRennautos[i].fahren(streckenlaenge);
		}
	}
	/**
	 * Methode zum durchfuehren des Rennens. Solange boolean sieger false ist wird die Methode schritt() ausgef¸hrt
	 * und anschlieﬂend in entscheider der mˆgliche Sieger durch die Methode ermittleSieger abgelegt.
	 * Falls durch die Methode ermittleSieger ein Sieger ermittelt werden konnte, wird sieger auf true
	 * umgestellt und das Objekt entscheider vm Typ Rennauto zur¸ckgegeben.
	 * 
	 * @return Der Gewinner des Rennens wird zur¸ckgegeben
	 */
	public Rennauto durchfuehren() {
		// Es wird so lange schritt() aufgerufen, bis ein Sieger des Rennens
		// gefunden wurde.
		boolean sieger = false;
		Rennauto entscheider = null;
		while (sieger==false) {
			schritt();
			entscheider = ermittleSieger();
			if (entscheider != null) {
				sieger = true;
			}
		}
		return entscheider;
	}

}
