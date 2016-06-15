/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7.Tests;

import org.junit.*;
import aufgabenblatt7.DoubleWert;
import static org.junit.Assert.*;

public class DoubleWertTest {
	
@Test
public void equals(){
	DoubleWert wert = new DoubleWert();
	assertFalse(wert.equals(1.5, 1.54));
	assertTrue(wert.equals(1.5, 1.500000004));
}

}
