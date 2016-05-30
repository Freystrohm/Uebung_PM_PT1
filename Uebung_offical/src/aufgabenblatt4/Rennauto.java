/**
 * PMT/PT1 Praktikum Aufgabenblatt 4
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt4;

/**
 * Klasse zum erstellen eines Rennauto-Objekts welches an Renne teilnehmen kann
 * 
 *
 */
public class Rennauto
{
	private String fahrername, fahrzeugtyp;
	private int maxgeschw;
	private double gefahreneStrecke;

	// Konstruktor
	public Rennauto(String fahrername, String fahrzeugtyp, int maxgeschw)
	{
		this.fahrername = fahrername;
		this.fahrzeugtyp = fahrzeugtyp;
		this.maxgeschw = maxgeschw;
		gefahreneStrecke = 0;
	}

	// Methoden
	// Getter
	public double getGefahreneStrecke()
	{
		return gefahreneStrecke;
	}
	/**
	 * 
	 * @return Name des Fahrers des jeweiligen Objektes
	 */
	public String getFahrer()
	{
		return fahrername;
	}

	// Other
	/**
	 * Das Rennauto feahrt in einem Zeitschritt eine Strecke abhängig von der
	 * maxgeschw und einem zufälligen Skalierungsfaktor
	 */
	public void fahren()
	{
		gefahreneStrecke = gefahreneStrecke + maxgeschw * Math.random();
	}

	/**
	 * gibt alle Objektvariablen des Objektes auf der Konsole aus
	 */
	public void ausgeben()
	{
		System.out.println(toString());
	}
	
	public String toString()
	{
		String ausgabe ="Fahrer: " + fahrername + "\nFahrzeug: "
				+ fahrzeugtyp + "\nMaximale Geschwindigkeit: " + maxgeschw
				+ "\nGefahrene Strecke: " + gefahreneStrecke;
		return ausgabe;
	}

	/**
	 * gibt an ob dieses Objekt mit einem andere Rennauto Objekt identisch ist
	 * 
	 * @param auto
	 * @return ist true wenn die Objektvariablen der 2 Objekte identisch sind
	 */
	public boolean rennautoEqual(Rennauto auto)
	{
		if (this.fahrername.equals(auto.fahrername)
				&& this.fahrzeugtyp.equals(auto.fahrzeugtyp)
				&& this.maxgeschw == auto.maxgeschw)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
