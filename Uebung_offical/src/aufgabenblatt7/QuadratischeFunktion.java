/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt7;

public class QuadratischeFunktion implements IFunktion
{
	double a, b, c;

	public QuadratischeFunktion(double a, double b, double c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public double berechenFvonX(double x)
	{
		return (a * x * x) + (b * x) + c;
	}

	@Override
	public double berechneAblvonX(double x)
	{
		return 2*a*x + b;
	}

}
