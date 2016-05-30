/**
 * PMT/PT1 Praktikum Aufgabenblatt 5.2
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt5;

/**
 * 
 * Jeder Eisenbahnwagen kennt seinen folgenden Wagen ist kein 
 * folgender Wagen vorhanden ist naechsterWagen null
 *
 */

public class Eisenbahnwagen
{
	private final int LAENGE, ANZAHLPASSAGIERE, WAGENNUMMER;
	private Eisenbahnwagen naechsterWagen;
	private static int anzahlWagen=0;

	// Konstruktor-----------------------------------------
	public Eisenbahnwagen(int laenge, int anzahlPassagiere)
	{
		LAENGE = laenge;
		ANZAHLPASSAGIERE = anzahlPassagiere;
		anzahlWagen++;
		WAGENNUMMER=anzahlWagen;
	}

	// Methoden---------------------------------------------
	// Getter/Setter
	public int getLaenge()
	{
		return LAENGE;
	}

	public int getAnzahlPassagiere()
	{
		return ANZAHLPASSAGIERE;
	}

	public Eisenbahnwagen getNaechsterWagen()
	{
		return naechsterWagen;
	}
	
	public int getWagennummer()
	{
		return WAGENNUMMER;
	}

	public void setNaechsterWagen(Eisenbahnwagen naechsterWagen)
	{
		this.naechsterWagen = naechsterWagen;
	}
	//KAS toString
	
	public String toString()
	{
		return "Wagennummer: " + getWagennummer() + "\nWagenlaenge: "
				+ getLaenge() + "\nWagenkapazitaet: "
				+ getAnzahlPassagiere();
	}
}

	
