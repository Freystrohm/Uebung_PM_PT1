/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;

/**
 * 
 * Simulator für 20 Sendungen gleichzeitig
 *
 */
public class Simulator
{
	private Staedte[] stadt;
	private Sendung[] listeSendungen = new Sendung[20];
	private OfflineSendungsdauerSchaetzer schaetzer;
	private int aktuellerZeitpunkt;
	// private int schrittZaehler = 0;

	// Konstruktor-------------------------------------------
	public Simulator()
	{
		schaetzer = new OfflineSendungsdauerSchaetzer();
		aktuellerZeitpunkt = 0;
		stadt = Staedte.values();
		for (int i = 0; i < listeSendungen.length; i++)
		{
			listeSendungen[i] = sendungErstellen(
					stadt[(int) (stadt.length * Math.random())],
					stadt[(int) (stadt.length * Math.random())]);
		}

	}

	/**
	 * private Funktionen zur Erstellung ein zufällig generierten Sendun.
	 * 
	 * @param senderOrt
	 * @param empfaengerOrt
	 * @return
	 */
	private Sendung sendungErstellen(Staedte senderOrt, Staedte empfaengerOrt)
	{
		Sendung sendung;
		if (Math.random() > 0.5)
		{
			sendung = paketErstellen(senderOrt, empfaengerOrt);
		}
		else
		{
			sendung = briefErstellen(senderOrt, empfaengerOrt);
		}

		System.out.println(
				"Neue Sendung erstellt:\n" + sendung.toString() + "\n\n\n");
		return sendung;
	}

	private Brief briefErstellen(Staedte senderOrt, Staedte empfaengerOrt)
	{
		return new Brief(personErstellen(), personErstellen(),
				aktuellerZeitpunkt,
				schaetzer.getSendungsTransportDauer(senderOrt, empfaengerOrt));
	}

	private Paket paketErstellen(Staedte senderOrt, Staedte empfaengerOrt)
	{
		return new Paket(personErstellen(), personErstellen(),
				(int) (100 * Math.random()), aktuellerZeitpunkt,
				schaetzer.getSendungsTransportDauer(senderOrt, empfaengerOrt));
	}

	private Person personErstellen()
	{
		return new Person(new Adresse("Straße", (int) (100 * Math.random()),
				(int) (30000 + Math.random()),
				stadt[(int) (Math.random() * stadt.length)]));
	}

	/**
	 * Macht in dem Simulator einen Zeitschrit in der übergebenen Schrittweite.
	 * 
	 * @param schrittweite
	 */
	public void zeitSchritt(int schrittweite)
	{
		aktuellerZeitpunkt += schrittweite;
		for (int i = 0; i < listeSendungen.length; i++)
		{
			listeSendungen[i].aktualisiereZeitpunkt(aktuellerZeitpunkt);

			if (listeSendungen[i].istAusgeliefert())
			{
				System.out.println("Sendung ausgeliefert: \n"
						+ listeSendungen[i].toString() + "\n\n\n");
				listeSendungen[i] = sendungErstellen(
						stadt[(int) (stadt.length * Math.random())],
						stadt[(int) (stadt.length * Math.random())]);
			}

			System.out.println("Sendung:\n" + listeSendungen[i].toString()
					+ "\n\nist bei " + getProzent(i) + " Prozent\n\n\n");
		}
	}
	// Michel--------------------------------------------------------------------------------------

	/**
	 * 
	 * @param zaehler
	 * @return Sendungstyp, Sendeort, Empfaengerort, Startzeitpunkt,
	 *         Transportdauer
	 */
	public String toString(int zaehler)
	{
		String ergebnis = "";
		ergebnis += listeSendungen[zaehler].getSendungsTyp() + " "
				+ listeSendungen[zaehler].getSender().getAdresse().getOrt()
						.toString()
				+ "      \t--->"
				+ listeSendungen[zaehler].getEmpfaenger().getAdresse().getOrt()
				+ "\t(start=" + listeSendungen[zaehler].getStartZeitpunkt()
				+ ", dauer=" + listeSendungen[zaehler].transportDauer + ")";
		return ergebnis;

	}
	/**
	 * Erechnet den prozentualen Forschritt.
	 * 
	 * @param zaehler
	 * @return Porzentangabe für den zurückgelegten Weg.
	 */
	public double getProzent(int zaehler)
	{

		int verbleibendeZeit = listeSendungen[zaehler].getTransportDauer()
				- (aktuellerZeitpunkt
						- listeSendungen[zaehler].getStartZeitpunkt());
		double prozent = ((double) verbleibendeZeit * 100)
				/ listeSendungen[zaehler].getTransportDauer();
		return prozent;
	}

	/**
	 * Gibt die Liste an Sendungen auf der Konsole aus.
	 */
	public void listeSendungenAusgeben()
	{
		for (int i = 0; i < listeSendungen.length; i++)
		{
			System.out.println(toString(i) + " erzeugt");
		}
	}
}
