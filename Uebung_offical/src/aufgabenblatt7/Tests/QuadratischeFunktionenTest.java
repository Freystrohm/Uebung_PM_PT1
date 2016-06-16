/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7.Tests;
import org.junit.*;

import aufgabenblatt7.NullstellenException;
import aufgabenblatt7.QuadratischeFunktionen;

import static org.junit.Assert.*;

public class QuadratischeFunktionenTest
{

	@Test
	public void equals() throws NullstellenException
	{
		QuadratischeFunktionen funktion = new QuadratischeFunktionen(1, 2, 3);
		assertEquals("Der Wert Stimmt nicht mit dem erwarteten überein.", 18,
				funktion.berechnefVonX(3), Math.pow(10, -5));
		assertEquals("Der Wert Stimmt nicht mit dem erwarteten überein.", 8,
				funktion.berechneAbleitungFvonX(3), Math.pow(10, -5));
	}

}
