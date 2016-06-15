/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7;

/**
 * Erstellt eine Quadratische Funktion zweiten Grades
 *
 */

public class QuadratischeFunktionen implements IFunktion
{
	private double a, b, c;
	public QuadratischeFunktionen(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}

	/**
	 * Berechnet den Wert der Funktion anhand des Übergabewertes. return:
	 * ergebnis
	 */
	@Override
	public double berechnefVonX(double xWert)
	{
		double ergebnis = a * (xWert*xWert) + b * xWert + c;// 2x²+3x-2
		return ergebnis;
	}
	/**
	 * Berechnet den Wert der abgeleiteten Funktion anhand des Übergabewertes.
	 * return: ergebnis
	 */
	@Override
	public double berechneAbleitungFvonX(double xWert)
	{
		double ergebnis = (2 * a) * xWert + b;// 4x+3
		return ergebnis;
	}

	public String toString()
	{
		return "Funktion: (" + a + ")*x²+(" + b + ")*x+" + "(" + c + ")";
	}

}
