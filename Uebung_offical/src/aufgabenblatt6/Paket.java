/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;
/**
 * Erstellt eine Sendung als Paket.
 *
 */
public class Paket extends Sendung {
	private int paketGewicht;
	//-----------------------------Konstruktor--------------------------------------------------------------------
	public Paket(Person sender,Person empfaenger,int paketGewicht){
		super(sender,empfaenger);
		this.paketGewicht=paketGewicht;
	}
	/**
	 * Gibt zurück ob die Sendung ausgeliefert wurde oder nicht.
	 */
	@Override
	public boolean istAusgeliefert() {
		if (getTransportDauer()<=0){
			return true;
		}
		return false;
	}
	/**
	 * Aktualisiert den Startzeitpunkt der Sendung.
	 */
	@Override
	public void aktualisiereZeitpunkt(int zeit) {
		super.transportDauer=zeit;
		
	}
	/**
	 * Gibt den Typ der Sendung als String wieder.
	 */
	@Override
	public String getSendungsTyp() {
		return "Paket";
	}
	/**
	 * Reduziert die Transportdauer nach jedem Schritt um eine Schrittweite.
	 */
	public void schritt (int schrittweite){
		super.transportDauer-=schrittweite;
	}
	
}
