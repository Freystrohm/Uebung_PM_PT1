/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7.Tests;

import org.junit.*;
import static org.junit.Assert.*;
import aufgabenblatt7.Nullstellen;
import aufgabenblatt7.NullstellenException;
import aufgabenblatt7.QuadratischeFunktionen;
/**
 * Testklasse für die Klasse Nullstellen.
 * 
 *@param erwarteteNullstelle: erwartete Nullstelle abhängig von der Funktion
 */
public class NullstellenTest {
	private double erwarteteNullstelle = 1.0;
	private double gerechneteNullstelle;
	private static final double DELTA = 1e-5;
	//private static final double RUNDUNGSEXPONENT =1e+5;

	
@Test
public void testfindeNulstelle() throws NullstellenException{
	QuadratischeFunktionen funktion = new QuadratischeFunktionen(1, 0, -1);
	System.out.println(funktion.toString());
	Nullstellen nullstelle = new Nullstellen(funktion,10,-5);
	gerechneteNullstelle=nullstelle.findeNullstelle(20);
	//gerechneteNullstelle=Math.rint(gerechneteNullstelle*RUNDUNGSEXPONENT)/RUNDUNGSEXPONENT;
	System.out.format("%.5f",gerechneteNullstelle);
	assertEquals("Fehler!",erwarteteNullstelle, gerechneteNullstelle,DELTA);
}


}
