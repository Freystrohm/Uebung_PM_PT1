/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;

import java.util.Scanner;
/**
 * 
 * Simulator für 20 Sendungen gleichzeitig
 *
 */
public class Simulator {

	private Adresse.Staedte[] stadt = Adresse.Staedte.values();
	private Adresse[] listeAdressen = new Adresse[40];
	private Person[] listePersonen = new Person[listeAdressen.length];
	private Sendung[] listeSendungen = new Sendung[(listePersonen.length) / 2];
	private int schrittZaehler =0;
	
/**
 * Erstellt eine Liste an Adressen und speichert diese in Array listeAdressen.
 */
	public void adressenErstellen() {
		for (int i = 0; i < listeAdressen.length; i++) {
			Adresse adresse = new Adresse("straße", (int) (Math.random() * 99), (int) (Math.random() * 10000),
					stadt[(int) (Math.random() * stadt.length)]);
			listeAdressen[i] = adresse;
		}
	}

	public Adresse[] getlisteAdressen() {
		return this.listeAdressen;
	}
/**
 * Erstellt eine Liste von Personen und speichert diese in Array ListePersonen
 */
	public void personenErstellen() {
		for (int i = 0; i < listePersonen.length; i++) 
		{
			Person person = new Person(listeAdressen[i]);
			listePersonen[i] = person;
		}

	}

	public Person[] getlistePersonen() {
		return listePersonen;
	}
/**
 * Erstellt eine Liste von Sendungen und speichert diese in Array ListeSendungen
 */
	public void sendungenErstellen() {
		for (int i = 0; i < listeSendungen.length / 2; i++) 
		{
			Sendung brief = new Brief(listePersonen[11 - i], listePersonen[i]);
			listeSendungen[i] = brief;
		}
		for (int j = listeSendungen.length / 2; j < listeSendungen.length; j++) 
		{
			Sendung paket = new Paket(listePersonen[21 - j], listePersonen[20 + j], (int) (Math.random() * 8));
			listeSendungen[29 - j] = paket;
		}

	}
/**
 * 
 * @param zaehler
 * @return Sendungstyp, Sendeort, Empfaengerort, Startzeitpunkt, Transportdauer
 */
	public String toString(int zaehler) {
		String ergebnis = "";
			ergebnis += listeSendungen[zaehler].getSendungsTyp() + " "
					+ listeSendungen[zaehler].getSender().getAdresse().getOrt().toString() + "      \t--->"
					+ listeSendungen[zaehler].getEmpfaenger().getAdresse().getOrt() + "\t(start="+listeSendungen[zaehler].getStartZeitpunkt()+", dauer="
					+ listeSendungen[zaehler].transportDauer + ")";
		return ergebnis;

	}
/**
 * Erechnet den prozentualen Forschritt.
 * @param zaehler
 * @return Porzentangabe für den zurückgelegten Weg.
 */
	public int getProzent(int zaehler) {
		OfflineSendungsdauerSchaetzer offline = new OfflineSendungsdauerSchaetzer();
		int gesamtDauer = offline.getSendungsTransportDauer(listeSendungen[zaehler].getSender().getAdresse().getOrt(),
				listeSendungen[zaehler].getEmpfaenger().getAdresse().getOrt());
		if (gesamtDauer != listeSendungen[zaehler].transportDauer) 
		{
			int aktuelleDauer = listeSendungen[zaehler].transportDauer;
			int fortschritt = gesamtDauer - aktuelleDauer;
			double prozent = (fortschritt * 100) / gesamtDauer;
			return (int) prozent;
		}
		return 0;

	}
	/**
	 * Gibt die Liste an Sendungen auf der Konsole aus.
	 */
	public void listeSendungenAusgeben(){
		for (int i=0;i<listeSendungen.length;i++){
			System.out.println( toString(i)+" erzeugt");
		}
	}
/**
 * Verarbeitet die Benutzereingabe auf der Konsole.
 */
	public void eingabeVerarbeiten() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Bitte Kommando eingeben (SCHRITT oder ENDE)");
		String eingabe = scan.next();
		while (eingabe != "schritt") 
		{
			if (eingabe.equals("SCHRITT") || eingabe.equals("schritt")) 
			{
				schrittZaehler+=60;
				for (int i = 0; i < listeSendungen.length; i++) 
				{
					listeSendungen[i].schritt(60);
				if (listeSendungen[i].istAusgeliefert()==true)//getTransportDauer() <= 0) 
				{
					sendungNeuerstellen(i);
				}
					System.out.println(toString(i)+"bei " + getProzent(i) + "%");
				}
				System.out.println("Bitte Kommando eingeben (SCHRITT oder ENDE)");
				eingabe = scan.next();
			}
			else if (eingabe.equals("ENDE") || eingabe.equals("ende"))
			{
				System.out.println("Das Versenden wurde beendet!");
				break;
			}
			else 
			{
				System.out.println("Falsche Eingabe! Bitte versuchen Sie es erneut!");
				break;
			}
		}
		scan.close();	
	}
	/**
	 * Ersetzt ausgelieferte Sendungen und erstellt eine Neue.
	 * @param zaehler
	 */
	public void sendungNeuerstellen(int zaehler){
		listeSendungen[zaehler].transportDauer=0;
		System.out.println( toString(zaehler)+" ausgeliefert");
		if (listeSendungen[zaehler] instanceof Brief) 
		{
			listeSendungen[zaehler] = new Brief(listePersonen[(int) (Math.random() * 40)],
					listePersonen[(int) (Math.random() * 40)]);
					listeSendungen[zaehler].setStartZeitpunkt(schrittZaehler);
			System.out.println( toString(zaehler)+" erzeugt");
		} 
		else 
		{
			listeSendungen[zaehler] = new Paket(listePersonen[(int) (Math.random() * 40)],
					listePersonen[(int) (Math.random() * 20)], (int) (Math.random() * 8));
				listeSendungen[zaehler].setStartZeitpunkt(schrittZaehler);
			System.out.println( toString(zaehler)+" erzeugt");
		}
	}


	public static void main(String[] args) {
	
		Simulator simulator = new Simulator();
		simulator.adressenErstellen();
		simulator.personenErstellen();
		simulator.sendungenErstellen();
		simulator.listeSendungenAusgeben();
		simulator.eingabeVerarbeiten();
	
	
	}
}
