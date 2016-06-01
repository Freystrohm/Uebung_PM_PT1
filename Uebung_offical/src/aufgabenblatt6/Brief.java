/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;
/**
 * Erstellt eine Sendung als Brief
 *
 */
public class Brief extends Sendung
{
	private boolean istEinschreiben;
	private boolean istAusgeliefert;
	// -----------------------------Konstruktor--------------------------------------------------------------------
	public Brief(Person sender, Person empfaenger, int startZeitpunkt,
			int transportDauer)
	{
		this(sender, empfaenger, startZeitpunkt, transportDauer, false);
	}

	public Brief(Person sender, Person empfaenger, int startZeitpunkt,
			int transportDauer, boolean istEinschreiben)
	{
		super(sender, empfaenger, startZeitpunkt, transportDauer);
		this.istEinschreiben = istEinschreiben;
		istAusgeliefert = false;
	}
	/**
	 * Gibt den Typ der Sendung als String wieder.
	 */
	public String getSendungsTyp()
	{

		return "Brief";
	}
	/**
	 * Nicht benötigt?!?!?!
	 */
	public boolean istEinEinschreiben()
	{
		return istEinschreiben;
	}

	/**
	 * Gibt zurück ob die Sendung ausgeliefert wurde oder nicht.
	 */
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
	 * Reduziert die Transportdauer nach jedem Schritt um eine Schrittweite.
	 */
	@Override
	public void schritt(int schrittweite)
	{
		super.transportDauer -= schrittweite;
		if (transportDauer <= 0)
		{
			istAusgeliefert = true;
		}
	}
}
