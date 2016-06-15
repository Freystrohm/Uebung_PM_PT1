/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7;
/**
 * Vergleich von zwei Zahlen auf numerische Gleicheit anhand eines Schwellwertes. 
 * @author Daexel
 *
 */
public class DoubleWert {
public static final double SCHWELLWERT = Math.pow(10, -5);
/**
 * 
 * @param wert1: erste Double-Zahl
 * @param wert2: zweite Double-Zahl
 * @return Boolean 
 * 
 * Prüft zwei double Zahlen auf numerische Gleichheit anhand des Schwellwertes
 * jeweils für positive und negative Werte.
 */
public boolean equals(double wert1, double wert2){
	if(wert2<=0)
	{
		double negativesErgebnis =Math.abs(wert1-wert2);
		if (negativesErgebnis==0)
			{
			return false;
			}
		if  (negativesErgebnis<SCHWELLWERT){
			return true;
			}
	}
	else{
	double positivesErgebnis =Math.abs(wert1-wert2);
		if (positivesErgebnis==0)
		{
			return false;
		}
		if  (positivesErgebnis>SCHWELLWERT)
		{
		return false;
		}
	}
	return true;
}
public int hashCode(){
	return 0;
}
}
