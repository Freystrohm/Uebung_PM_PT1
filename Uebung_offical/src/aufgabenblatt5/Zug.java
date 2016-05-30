/**
 * PMT/PT1 Praktikum Aufgabenblatt 5.2
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt5;

/**
 * 
 * Zug hat verweis auf die Lok und kann darüber auf den kompletten Zug zugreifen
 *
 */
public class Zug
{
	private Lokomotive lok;

	// Konstruktor-----------------------------------------
	public Zug(int lokLaenge, int lokTyp)
	{
		lok = new Lokomotive(lokLaenge, lokTyp);
	}

	// Methoden---------------------------------------------
	// Getter/Setter
	public Lokomotive getLokomotive()
	{
		return lok;
	}

	// others----------------------------------------------
	/**
	 * fügt einen wagen an den Zug an.
	 * 
	 * @param wagen:
	 *            wagen der hinten angefügt wird.
	 */
	public void wagenHinzufuegen(Eisenbahnwagen wagen)
	{
		if (lok.getErsterWagen() != null)
		{
			Eisenbahnwagen letzterWagen = lok.getErsterWagen();

			while (letzterWagen.getNaechsterWagen() != null)
			{
				letzterWagen = letzterWagen.getNaechsterWagen();
			}

			letzterWagen.setNaechsterWagen(wagen);
		}
		else
		{
			lok.setErsterWagen(wagen);
		}
	}

	/**
	 * hängt den ersten wagen aus und fügt die folgenden an die lok an.
	 * 
	 * @return: der ausgehängte Wagen.
	 */
	public Eisenbahnwagen erstenWagenEntfernen()
	{
		Eisenbahnwagen wagen = null;
		if (lok.getErsterWagen() != null)
		{
			wagen = lok.getErsterWagen();
			lok.setErsterWagen(lok.getErsterWagen().getNaechsterWagen());
			wagen.setNaechsterWagen(null);
		}
		return wagen;
	}

	/**
	 * Hängt alle Wagen eines anderen zuges an diesen zug an und trennt sie von
	 * diesem.
	 * 
	 * @param zug:
	 *            der Zug dessen wagen an diesen angehängt werden soll
	 */
	public void zugAnhaengen(Zug zug)
	{
		
		wagenHinzufuegen(zug.getLokomotive().getErsterWagen());
		zug.getLokomotive().setErsterWagen(null);
	}

	/**
	 * liefert die Anzahl aller wagen.
	 * 
	 * @return: Anzahl der wagen
	 */
	public int getWagenanzahl()
	{
		int wagenzahl = 0;
		Eisenbahnwagen wagen = lok.getErsterWagen();

		while (wagen != null)
		{
			wagen = wagen.getNaechsterWagen();
			wagenzahl++;
		}
		return wagenzahl;
	}

	/**
	 * gibt die gesamte Anzahl der Passagiere in diesem Zug wieder
	 * 
	 * @return: Anzahl der Passagiere
	 */
	public int getKapazitaet()
	{
		int gesamtPassa = 0;

		Eisenbahnwagen wagen = lok.getErsterWagen();
		while (wagen != null)
		{
			gesamtPassa += wagen.getAnzahlPassagiere();
			wagen = wagen.getNaechsterWagen();
		}
		return gesamtPassa;
	}

	/**
	 * gibt die gesamte Laenge des zuges wieder.
	 * 
	 * @return: Laenge des Zuges
	 */
	public int getLaenge()
	{
		int laenge = lok.getLange();
		Eisenbahnwagen wagen = lok.getErsterWagen();

		while (wagen != null)
		{
			laenge += wagen.getLaenge();
			wagen = wagen.getNaechsterWagen();
		}
		return laenge;
	}

	/**
	 * erzeugt einen String zur beschreibung des gesamten Zuges.
	 * 
	 * @return: Beischreibung des Zuges
	 */
	public String toString()
	{   //KAS toString von Wagen und Lok verwenden
		String beschreibung = "Loktyp: " + lok.getTyp() + "\nWagenanzahl: "
				+ getWagenanzahl() + "\nGesamtlaenge: " + getLaenge()
				+ "\nAnzahl der Passagiere: " + getKapazitaet();

		Eisenbahnwagen wagen = lok.getErsterWagen();
		//int zaehler = 1;

		while (wagen != null)
		{
			beschreibung += "\n\n\n" + wagen.toString();
			wagen = wagen.getNaechsterWagen();
			//zaehler++;
		}
		return beschreibung;
	}

}
