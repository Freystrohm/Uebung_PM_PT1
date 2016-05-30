/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.3
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt4_Michel;
import java.util.Scanner;

public class Wettbuero {
private  int anzahlWetten;
private final double gewinnFaktor;
Rennen[] listeRennen;
Wette [] listeWetten;
Wette [] zwischenspeicher;

/**
 * Konstruktor zur Initialisierung des gewinnFaktors, listeRennen und listeWetten
 * @param rennen
 * @param wetten
 */
public Wettbuero(Rennen rennen, double wetten){
	//this.anzahlWetten=anzahlWetten;
	gewinnFaktor = 2;
	this.listeRennen = new Rennen[1];
	this.listeWetten = new Wette[1];
	
}
/**
 * Ausgabe der listeRennautos mit hinzufügen des Indizes 
 * @param rennen
 * @param anzahlwetten
 */
public  void ausgabeListeRennautos(Rennen rennen, int anzahlwetten){
		
		Rennauto listeRennautos[] = rennen.getRennauto();
		for (int j=0; j < listeRennautos.length;j++){
			if(listeRennautos[j]!=null){
			System.out.println("\n("+j+")");
			listeRennautos[j].listeAusgeben();
			}
			else {
				break;
				}
			
			}}
/**
 * Aufnehmen der jeweiligen Wetten anhand des eingebenen Indizes. 
 * Eingabe des Wettbetrags und den Namen des Wettenden.
 * fahrerin, wetteinsatz und spieler als Übergabeparameter für Methode wetteAnnehmen 
 * @param anzahlWetten
 * @param scan
 * @param rennen
 */
public void eingabeWette(int anzahlWetten, Scanner scan,Rennen rennen){
	String fahrerin;
	int wettEinsatz;
	String spieler;
	Rennauto listeRennautos[]=rennen.getRennauto();
	
	for (int i=0; i<anzahlWetten;i++){
		ausgabeListeRennautos(rennen, anzahlWetten);
		System.out.println();
		System.out.println("Geben Sie den Index der Fahrerin ein, auf die Sie wetten wollen: ");
		int index = scan.nextInt();
		fahrerin = listeRennautos[index].getFahrername();
		System.out.println("Geben Sie ihren Wetteinsatz in Euro ein, der verdoppelt werden soll (ohne Centbeträge): ");
		wettEinsatz = scan.nextInt();
		System.out.println("Geben Sie ihren Namen ein: ");
		spieler = scan.next();
		wetteAnnehmen (fahrerin,wettEinsatz,spieler);
	}
}
/**
 * Verdopplung des Arrays listeWetten, falls der Platz für die Wetten nicht ausreicht.
 * @param fahrerin
 * @param wettEinsatz
 * @param spieler
 */
public void wetteAnnehmen(String fahrerin,int wettEinsatz,String spieler){
	Wette wette = new Wette(fahrerin,wettEinsatz,spieler);
	if (listeWetten[listeWetten.length-1]!=null){
		zwischenspeicher = new Wette[listeWetten.length * 2];
		System.arraycopy(listeWetten, 0, zwischenspeicher, 0, listeWetten.length);
		listeWetten = zwischenspeicher;
	}
	for (int i = 0; i < listeWetten.length; i++) {
		if (listeWetten[i] == null) {
			listeWetten[i] = wette;
			break;
		}
	}
	anzahlWetten++;
}
/**
 * Auswerten der Wettsieger über Übergabeparameter auto3 und wette.
 * Ausgabe sowohl der Sieger als auch der Verlierer.
 * @param auto3
 * @param wette
 */
public void auswerten(Rennauto auto3,Wette wette) {
		for (int j = 0; j <anzahlWetten; j++) {
			
			if (listeWetten[j].getFahrerin().equals(auto3.getFahrername())){
				double gewinn = listeWetten[j].getWettEinsatz()* gewinnFaktor;
				System.out.println("\n\nGLÜCKWUNSCH!\n"+listeWetten[j].getSpieler()+ " hat seine Wette gewonnen!\n"
						+ "Die ausgezahlte Summe beträgt "+gewinn+"€");
			}
			if (!listeWetten[j].getFahrerin().equals(auto3.getFahrername())){
				System.out.println("\n\nKein Gewinn für:\n"+listeWetten[j].getSpieler());
			}
		}
	}
	
}


	
