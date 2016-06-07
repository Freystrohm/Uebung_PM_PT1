/**
 * PMT/PT1 Praktikum Aufgabenblatt 
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt7;

public class Nullstellen
{
	IFunktion funktion;
	double schwellwert;

	public Nullstellen(IFunktion funktion, double stelleAbbruch)
	{
		this.funktion = funktion;
		schwellwert = 0.9 * Math.pow(10, -stelleAbbruch);
	}

	public double findeNulstelle(double startwert) throws NullstellenException
	{
		double x = startwert;
		while (Math.abs(funktion.berechenFvonX(x)) >= schwellwert)
		{
			if (funktion.berechneAblvonX(x) < schwellwert && !(funktion.berechenFvonX(x) < schwellwert))
			{

				throw new NullstellenException();
			}
			else
			{
				x = x - (funktion.berechenFvonX(x)
						/ funktion.berechneAblvonX(x));
				System.out.println(x);
			}
		}
		return x;
	}

	public static void main(String[] args)
	{
		QuadratischeFunktion funktion = new QuadratischeFunktion(1, 0, 2);
		Nullstellen nullstellen = new Nullstellen(funktion, 6);

		try
		{
			System.out.println(nullstellen.findeNulstelle(3));
		}
		catch (NullstellenException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
