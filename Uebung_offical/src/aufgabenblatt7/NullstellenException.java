/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7;
/**
 * Klasse zum Auffangen von Exceptions der Klasse Nullstellen.
 */

@SuppressWarnings("serial")
public class NullstellenException extends Exception {
	public NullstellenException(String s){
		super(s);
	}

}
