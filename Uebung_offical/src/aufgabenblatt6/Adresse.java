/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;

public class Adresse 
{
	private String strasse;
	private int hausnummer;
	private int postleitzahl;
	public Staedte ort;

	public Adresse (String strasse, int hausnummer,int postleitzahl, Staedte ort){
		this.strasse=strasse;
		this.hausnummer=hausnummer;
		this.postleitzahl=postleitzahl;
		this.ort=ort;
	}

	
	public String getStrasse() {
		return strasse;
	}

	public int getHausnummer() {
		return hausnummer;
	}

	public int getPostleitzahl() {
		return postleitzahl;
	}
	public Staedte getOrt(){
		return ort;
	}
	
	public String toString()
	{
		return strasse + " " + hausnummer + "\n"
				+ postleitzahl + " " + ort.toString();
	}

}
