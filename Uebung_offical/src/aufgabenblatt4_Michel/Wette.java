/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.3
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt4_Michel;

public class Wette {
private String fahrerin;
private int wettEinsatz;
private String spieler;
//Konstruktor
public Wette(String fahrerin, int wettEinsatz, String spieler){
	this.fahrerin=fahrerin;
	this.wettEinsatz=wettEinsatz;
	this.spieler=spieler;
}
public String getFahrerin(){
	return this.fahrerin;
}
public int getWettEinsatz(){
	return this.wettEinsatz;
}
public String getSpieler(){
	return this.spieler;
}
/**
 * Ausgabe der jeweiligen Wetten
 */
public void ausgeben() {
	System.out.format("Fahrername: "+fahrerin+ "\nWetteinsatz: "+wettEinsatz+
			"\nSpieler: "+spieler);
}

}
