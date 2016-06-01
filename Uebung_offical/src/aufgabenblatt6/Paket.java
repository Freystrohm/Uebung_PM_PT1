/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;
/**
 * Erstellt eine Sendung als Paket.
 *
 */
public class Paket extends Sendung
{
	private int paketGewicht;
	private boolean istAusgeliefert;
	// -----------------------------Konstruktor--------------------------------------------------------------------
	public Paket(Person sender, Person empfaenger, int paketGewicht,
			int startZeitpunkt, int transportDauer)
	{
		super(sender, empfaenger, startZeitpunkt, transportDauer);
		this.paketGewicht = paketGewicht;
		istAusgeliefert = false;
	}
	/**
	 * Gibt zurück ob die Sendung ausgeliefert wurde oder nicht.
	 */
	@Override
	public boolean istAusgeliefert()
	{
		return istAusgeliefert;
	}
	/**
	 * Aktualisiert den Startzeitpunkt der Sendung.
	 */
	@Override
	public void aktualisiereZeitpunkt(int aktuelleZeit)
	{
		if (startZeitpunkt + transportDauer <= aktuelleZeit)
		{
			istAusgeliefert = true;
		}


	}
	/**
	 * Gibt den Typ der Sendung als String wieder.
	 */
	@Override
	public String getSendungsTyp()
	{
		return "Paket";
	}

	public int getGewicht()
	{
		return paketGewicht;
	}
	/**
	 * Reduziert die Transportdauer nach jedem Schritt um eine Schrittweite.
	 */
	public void schritt(int schrittweite)
	{
		transportDauer -= schrittweite;
		if (transportDauer <= 0)
		{
			istAusgeliefert = true;
		}
	}

}
