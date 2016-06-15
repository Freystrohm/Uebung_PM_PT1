/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7.Tests;
import org.junit.*;

import aufgabenblatt7.NullstellenException;
import aufgabenblatt7.QuadratischeFunktionen;

import static org.junit.Assert.*;

public class QuadratischeFunktionenTest {
	@Test
	public void equals() throws NullstellenException{
		try {
			QuadratischeFunktionen funktion = new QuadratischeFunktionen(0,0,0);
			funktion.berechnefVonX(3);
	        fail(); 
	    } 
	    catch (Exception e) {
	        final String expected = "Hoechstens zwei Werte der Funktion duerfen Null sein!";
	        assertEquals( expected, e.getMessage());
	    }        	
	}

}
