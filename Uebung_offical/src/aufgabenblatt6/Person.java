/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;

public class Person
{
	private Adresse adresse;

	public Person(Adresse adresse)
	{
		this.adresse = adresse;
	}
	public Adresse getAdresse()
	{
		return adresse;
	}

	public String toString()
	{
		return adresse.getStrasse() + " " + adresse.getHausnummer() + "\n"
				+ adresse.getPostleitzahl() + " " + adresse.getOrt();
	}

}
