/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.1
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt5_1;

public enum Edelsteine {
 DIAMANT("D"),RUBIN("R"),SMARAGD("S");
 
 private String typ;
 
 private Edelsteine(String aTyp) {
		typ = aTyp;
 }
 
 public String toString() {
	 return typ;
 }
}
