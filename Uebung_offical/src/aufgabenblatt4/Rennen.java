/**
 * PMT/PT1 Praktikum Aufgabenblatt 4
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt4;
/**
 * Klasse für ein Rennen-Objekt zum durchführen eines Rennens an dem mehrere
 * Rennauto-Objekte teilnehmen können und auf das Wetten abgeschlossen werden
 * können.
 * 
 * @author Johannes Kruber
 *
 */
public class Rennen
{
	private int anzahlRennauto;
	private Rennauto[] rennautos;
	private double streckenlaenge;

	// Konstruktor
	public Rennen(double streckenlaenge)
	{
		this.streckenlaenge = streckenlaenge;
		rennautos = new Rennauto[1];
		rennautos[0] = null;
		anzahlRennauto = 0;
	}

	// Methoden
	// Getter
	/**
	 * 
	 * @return Liste der Teilnehmer des Rennens
	 */
	public Rennauto[] getTeilnehmer()
	{
		return rennautos;
	}

	// Other
	/**
	 * fügt ein Rennauto hinzu und verdoppelt die Arraygroeße falls nötig
	 * 
	 * @param auto:
	 *            Teilnehmer der dem Rennen hinzugefügt werden soll.
	 */
//	public void addRennauto(Rennauto auto)
//	{
//		Rennauto[] tmp;
//		if (rennautos[rennautos.length - 1] != null)
//		{
//			tmp = new Rennauto[rennautos.length * 2];
//			System.arraycopy(rennautos, 0, tmp, 0, rennautos.length);
//			rennautos = tmp;
//		}
//
//		
//		for (int i = 0; i < rennautos.length; i++)
//		{
//			if (rennautos[i] == null)
//			{
//				rennautos[i] = auto;
//				break;
//			}
//		}
//		anzahlRennauto++;
//	}
	
	public void addRennauto(Rennauto auto)
	{
		Rennauto[] tmp;
		if (rennautos.length <= anzahlRennauto)
		{
			tmp = new Rennauto[rennautos.length * 2];
			System.arraycopy(rennautos, 0, tmp, 0, rennautos.length);
			rennautos = tmp;
		}
		rennautos[anzahlRennauto] = auto;
			
		anzahlRennauto++;
	}

	/**
	 * Ermittelt ob ein Auto schon die komplette Strecke zurueckgelegt hat.
	 * 
	 * @return Sieger des Rennens oder null wenn noch kein Sieger feststeht
	 */
	private Rennauto ermittleSieger()
	{
		Rennauto sieger = null;
		for (int i = 0; i < anzahlRennauto; i++)
		{
			if (rennautos[i].getGefahreneStrecke() >= streckenlaenge)
			{
				sieger = rennautos[i];
				break;
			}
		}
		return sieger;
	}

	/**
	 * Laesst alle autos einen Schritt fahren.
	 */
	private void schritt()
	{
		for (int i = 0; i < anzahlRennauto; i++)
		{
			rennautos[i].fahren();
		}
	}

	/**
	 * fuehrt ein komplettes Rennen durch und gibt den Sieger zurueck
	 * 
	 * @return sieger des Rennens
	 */
//	public Rennauto durchfuehren()
//	{
//		boolean fertig = false;
//		Rennauto sieger = null;
//		while (!fertig)
//		{
//			schritt();
//			sieger = ermittleSieger();
//			if (sieger != null)
//			{
//				fertig = true;
//			}
//		}
//
//		return sieger;
//	}
	
	public Rennauto durchfuehren()
	{
		Rennauto sieger = null;
		while (sieger != null)
		{
			schritt();
			sieger = ermittleSieger();
			
		}
		return sieger;
	}
}
