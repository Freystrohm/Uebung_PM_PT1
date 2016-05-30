/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.1
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt5_1;

public class EdelsteinboxMain {

	public static void main(String[] args) {
		EdelsteinBox edelsteinBox = new EdelsteinBox(Edelsteine.DIAMANT, Edelsteine.DIAMANT, Edelsteine.SMARAGD);
		edelsteinBox.hineinlegen(Edelsteine.DIAMANT, 1);
		edelsteinBox.hineinlegen(Edelsteine.RUBIN, 2);
		edelsteinBox.hineinlegen(Edelsteine.SMARAGD, 3);
		edelsteinBox.umwandeln(Edelsteine.RUBIN, Edelsteine.DIAMANT);
		edelsteinBox.herausnehmen(Edelsteine.DIAMANT, 2);
		// edelsteinBox.leeren();

		edelsteinBox.ausgeben();
	}

}
