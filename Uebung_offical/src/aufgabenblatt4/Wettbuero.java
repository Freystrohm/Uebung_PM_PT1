/**
 * PMT/PT1 Praktikum Aufgabenblatt 4
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt4;

/**
 * Klasse zum zusammen verwalten von Wetten für ein bestimmtes Rennen.
 * 
 * @author Johannes Kruber
 *
 */
public class Wettbuero
{
	private Rennen rennen;
	public Wette[] wetten;
	private final double FAKTOR;
	private int anzahlWetten;

	// Konstruktor
	public Wettbuero(Rennen rennen, double faktor)
	{
		this.rennen = rennen;
		this.FAKTOR = faktor;
		wetten = new Wette[1];
		anzahlWetten = 0;
	}

	// Methoden
	/**
	 * prüft ob ein Fahrer am Rennen teilnimmt
	 * 
	 * @param fahrer:
	 *            Rennauto-Objekt das überprüft werden soll
	 * @return
	 */
	private boolean nimmtFahrerTeil(Rennauto fahrer)
	{
		for (Rennauto ele : rennen.getTeilnehmer())
		{
			if (ele.rennautoEqual(fahrer))
			{
				return true;
			}
		}

		return false;
	}

	/**
	 * nimmt eine Wette entgegen und speichert sie im wetten array
	 * 
	 * @param fahrer:
	 *            Rennauto-Objekt auf das gewettet wird.
	 * @param wetteinsatz:
	 *            Der getätigte Wetteinsatz.
	 * @param spieler:
	 *            Der Spieler der die Wette tätigt
	 * @return war die Annahme der Wette erfolgreich.
	 */
	public boolean wetteAnnehmen(Rennauto fahrer, int wetteinsatz,
			String spieler)
	{
		Wette[] tmp;
		if (!nimmtFahrerTeil(fahrer))
		{
			return false;
		}
		else
		{
			if (wetten[wetten.length - 1] != null)
			{
				tmp = new Wette[wetten.length + 1];
				System.arraycopy(wetten, 0, tmp, 0, wetten.length);
				wetten = tmp;
			}

			for (int i = 0; i < anzahlWetten + 1; i++)
			{
				if (wetten[i] == null)
				{
					wetten[i] = new Wette(fahrer, wetteinsatz, spieler);
				}
			}
			anzahlWetten++;
			return true;
		}
	}

	public boolean wetteAnnehmen(Wette wette)
	{
		return wetteAnnehmen(wette.getRennauto(), wette.getWetteinsatz(),
				wette.getSpieler());
	}

	/**
	 * prüft ob und welche Spieler mit ihrer Wette und wie viel sie gewonnen
	 * haben
	 * 
	 * @param sieger:
	 *            der Sieger des Rennens
	 * @return Liste der Spieler die mit ihre Wette gewonnen haben
	 */
	public String[] auswerten(Rennauto sieger)
	{
		String[] wettsieger = new String[0], tmp;
		for (int i = 0; i < anzahlWetten; i++)
		{
			if (sieger.getFahrer().equals(wetten[i].getRennauto().getFahrer()))
			{
				if (wettsieger.length == 0)
				{
					wettsieger = new String[1];
				}
				else
				{
					tmp = new String[wettsieger.length + 1];
					System.arraycopy(wettsieger, 0, tmp, 0, wettsieger.length);
					wettsieger = tmp;
				}
				wettsieger[wettsieger.length - 1] = wetten[i].getRennauto()
						.getFahrer().concat("  Gewinn:"
								+ wetten[i].getWetteinsatz() * FAKTOR);
			}
		}
		return wettsieger;
	}
}
