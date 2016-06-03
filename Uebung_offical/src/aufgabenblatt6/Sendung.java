/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;
/**
 * 
 * Abstrakte Basisklasse für die Sendungen.
 *
 */
public abstract class Sendung {
	// Objektvariablen------------------------------------
	protected Person sender;
	protected Person empfaenger;
	protected int sendungsNummer;
	protected int startZeitpunkt;
	protected int transportDauer;
	protected static int SENDUNGSNUMMERZAEHLER=0;

	// Konstruktor-----------------------------------------
	public Sendung(Person sender, Person empfaenger, int startZeitpunkt, int transportDauer) {
		this.sender = sender;
		this.empfaenger = empfaenger;
		this.transportDauer=transportDauer;
		this.startZeitpunkt=startZeitpunkt;
		SENDUNGSNUMMERZAEHLER++;
		sendungsNummer= SENDUNGSNUMMERZAEHLER;
	}

	// Methoden---------------------------------------------
	// Getter
	public Person getSender(){
		return sender;
	}
	public Person getEmpfaenger(){
		return empfaenger;
	}
	public int getSendungsnummer() {
		return sendungsNummer;
	}

	public int getTransportDauer() {
		/**
		 * Online Sendungsdauerschaetzer
		 */
		//GoogleSendungsdauerSchaetzer google=new GoogleSendungsdauerSchaetzer();
		//transportDauer=google.getSendungsTransportDauer(sender.getAdresse().getOrt(), empfaenger.getAdresse().getOrt());
		/**
		 * Offline Sendungsdauerschaetzer
		 */
		//OfflineSendungsdauerSchaetzer offline=new OfflineSendungsdauerSchaetzer();
		//transportDauer=offline.getSendungsTransportDauer(sender.getAdresse().getOrt(), empfaenger.getAdresse().getOrt());
		
		return transportDauer;
	}

	public int getStartZeitpunkt() {
		return startZeitpunkt;
	}
	/**
	 * Setzt den Startpunkt der Sendung auf die aktuelle Schrittzahl
	 * 
	 * @param schritt Übergabewert Schritt festgelegt als 15min bzw. 60
	 * @return neuen startZeitpunkt
	 */
	public int setStartZeitpunkt(int schritt){
		startZeitpunkt+=schritt;
		return startZeitpunkt;
	}

	public String toString() {
		String ausgabe = "Sender: " + sender + "\nEmpfaenger: " + empfaenger + "\nSendenummer: " + sendungsNummer
				+ "\nStartzeitpunkt: " + startZeitpunkt + "\nTransportdauer: " + transportDauer;
		return ausgabe;
	}
	public abstract String getSendungsTyp();
	public abstract boolean istAusgeliefert();

	public abstract void aktualisiereZeitpunkt(int aktuelleZeit);
}
