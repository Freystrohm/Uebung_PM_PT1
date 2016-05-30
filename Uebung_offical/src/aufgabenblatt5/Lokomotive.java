/**
 * PMT/PT1 Praktikum Aufgabenblatt 5.2
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt5;

/**
 * 
 * Lokomotive kennt seinen ersten Wagen 
 *
 */

public class Lokomotive {
	private final int LAENGE, TYP;
	private Eisenbahnwagen ersterWagen;

	// Konstruktor----------------------------------------
	public Lokomotive(int laenge, int typ) {
		this.LAENGE = laenge;
		this.TYP = typ;
	}

	// Methoden--------------------------------------------
	// Getter
	public int getLange() {
		return LAENGE;
	}

	public int getTyp() {
		return TYP;
	}

	public Eisenbahnwagen getErsterWagen() {
		return ersterWagen;
	}

	// Setter
	public void setErsterWagen(Eisenbahnwagen wagen) {
		ersterWagen = wagen;
	}
	//KAS toString
}
