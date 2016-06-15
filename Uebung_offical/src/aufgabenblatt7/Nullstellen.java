/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.text.*;

public class Nullstellen implements Comparator<Double>
{
	private double schwellwert;
	private IFunktion funktion;
	private int maxAnzahlInterationen = 10;
	// --------------------------------Konstruktor------------------------------------------------------------
	public Nullstellen(IFunktion funktion, double wert, int exponent)
	{
		this.schwellwert = Math.pow(wert, exponent);
		this.funktion = funktion;
	}
	// ----------------------------------Methoden--------------------------------------------------------------
	/**
	 * 
	 * @param startWert:
	 *            Startwert zur Brechnung der Nullstelle
	 * @return double Nullstelle
	 * @throws NullstellenException
	 * 
	 *             Sucht mit Hilfe des Newtonverfahrens eine Nullstelle heraus.
	 */
	public double findeNullstelle(double startWert) throws NullstellenException
	{
		double nullstelle = startWert;

		// Wieso??????
		// if (startWert == 0)
		// {
		// throw new NullstellenException("Startwert darf nicht 0 sein!");
		//
		// }

		// z.B. Abbruch bei f(x) < 10^-5 Genauigkeit
		for (int i = 0; Math
				.abs(funktion.berechnefVonX(nullstelle)) < schwellwert; i++)
		{
			if (funktion.berechnefVonX(nullstelle) == 0) // eventuell unnötig
			{
				break;
			}
			if (i >= maxAnzahlInterationen)
			{
				throw new NullstellenException("Keine Nullstelle gefunden!");
			}
			if (Math.abs(
					funktion.berechneAbleitungFvonX(nullstelle)) <= schwellwert
					&& !(Math.abs(
							funktion.berechnefVonX(nullstelle)) <= schwellwert))
			{
				throw new NullstellenException(
						"Extrempunkt erreicht keine weiteres konvergieren möglich");
			}
			nullstelle = nullstelle - (funktion.berechnefVonX(nullstelle)
					/ funktion.berechneAbleitungFvonX(nullstelle));
		}

		return nullstelle;
	}
	/**
	 * 
	 * @param min:
	 *            Kleinster Wert des Intervalls
	 * @param max:
	 *            Groeßter Wert des Intervalls
	 * @param anzahlVersuche
	 * @return HashSet <Double> listeNullstellenHashSet
	 * @throws NullstellenException
	 *             durch findeNullstelle() Methode
	 * 
	 *             Speichert mit Hilfe der findeNullstelle() Methode und einer
	 *             randomisierten Zahl aus dem angegebenen Intervall die
	 *             Näherungswerte in eine Arraylist.
	 */
	public List<Double> findeNullstellenRandomisiert(int min, int max,
			int anzahlVersuche) throws NullstellenException
	{
		double zwischenWert;
		HashSet<Double> listeNullstellenHashSet = new HashSet<Double>();
		HashSet<Integer> verwendeteSartwerte = new HashSet<Integer>();
		// for (int i = min; i <= max; i++)
		// {
		// listeIntervall.add(i);
		// }
		double startWert = Math.random() * (max - min) + min;
		for (int i = 0; i < anzahlVersuche; i++)
		{
			while (!verwendeteSartwerte.add((int) startWert))
			{
				startWert = Math.random() * (max - min) + min;
			}

			zwischenWert = findeNullstelle(startWert);
			listeNullstellenHashSet.add(zwischenWert);
		}

		return listeNullstellenSortieren(listeNullstellenHashSet);
	}

	/**
	 * speichert die gefundenen Werte in eine ArrayList und sortiert diese
	 * 
	 */
	public List<Double> listeNullstellenSortieren(
			HashSet<Double> listeNullstellenHashSet)
	{
		List<Double> listeNullstellenArrayList = new ArrayList<Double>();
		Iterator<Double> iter = listeNullstellenHashSet.iterator();
		
		while (iter.hasNext())
		{
			listeNullstellenArrayList.add(iter.next());
		}
		
		Collections.sort(listeNullstellenArrayList);
		iter = listeNullstellenArrayList.iterator();
		DoubleWert wert = new DoubleWert();
		
		int zaehlerInterator = 0;
		while (iter.hasNext())
		{
			zaehlerInterator++;
			if (listeNullstellenArrayList.size() <= 1)
			{
				break;
			}
			if (wert.equals(iter.next(),
					listeNullstellenArrayList.get(zaehlerInterator)))
			{
				iter.remove();
			}
		}

		return listeNullstellenArrayList;
	}

	/**
	 * Gibt die ArrayList aus
	 */
	public String toString()
	{
		DecimalFormat format = new DecimalFormat("#0.00000");
		String ergebnis = "Nullstellen: {";
		Iterator<Double> iter2 = listeNullstellenArrayList.iterator();
		int zaehler = 0;
		while (iter2.hasNext())
		{
			zaehler++;
			if (zaehler == listeNullstellenArrayList.size())
			{
				ergebnis += format.format(iter2.next());
			}
			else
			{
				ergebnis += format.format(iter2.next()) + "| ";
			}
		}
		return ergebnis + "}";
	}
	@Override
	public int compare(Double wert1, Double wert2)
	{
		DoubleWert wert = new DoubleWert();
		if (wert.equals(wert1, wert2) == true)
		{
			return -1;
		}
		return 0;
	}

}
