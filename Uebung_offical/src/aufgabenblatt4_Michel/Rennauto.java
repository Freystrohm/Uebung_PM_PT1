/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.3
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt4_Michel;

public class Rennauto {

	double maxgeschwindigkeit;
	public double fahrstrecke;
	private String fahrername;
	private String fahrzeugtyp;
//Konstruktor
	public Rennauto(String fahrername, String fahrzeugtyp, double maxgeschwindigkeit) {

		this.fahrername = fahrername;
		this.fahrzeugtyp = fahrzeugtyp;
		this.maxgeschwindigkeit = maxgeschwindigkeit;
		this.fahrstrecke = 0;
		}
//Methoden
	/**
	 * Ermittelt die gefahrene Strecke der Rennautos in Abhängigkeit von der jeweiligen Maxialgeschwindigkeit
	 * @param fahrstecke Gesamtfahrstrecke des Rennens
	 */
	public void fahren(double fahrstecke) {
		fahrstrecke = fahrstrecke+ Math.random() * maxgeschwindigkeit;
		}
	/**
	 * Ausgabe der Teilnehmer des Rennens
	 */
	public void listeAusgeben(){
		System.out.format("Fahrername:\t\t"+fahrername+ "\nFahrzeugtyp:\t\t"+fahrzeugtyp+
				"\nMaximalgeschwindigkeit:\t"+maxgeschwindigkeit+"Km\\h\n");
	}
	/**
	 * Ausgabe des Gewinners des Rennens
	 */
	public void ausgeben() {
		System.out.format("Die Gewinnerin des Rennens lautet:\nFahrername:\t\t"+fahrername+ "\nFahrzeugtyp:\t\t"+fahrzeugtyp+
				"\nMaximalgeschwindigkeit:\t"+maxgeschwindigkeit+"\nFahrstecke:\t\t%.2f ",fahrstrecke);
	}
	/**
	 * public String toString(){
	 
		String irgendwas="";
		return irgendwas;
	}
	public double getGefahreneStrecke(){
		int zahl = 0;
		return zahl;
	}
	*/
	public String getFahrername(){
		return this.fahrername;
	}
	
}


