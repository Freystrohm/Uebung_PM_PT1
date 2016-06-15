/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7;

public interface Funktion {
	public double berechnefVonX(double xWert) throws NullstellenException;
	public double berechneAbleitungFvonX(double xWert) throws NullstellenException;

}
