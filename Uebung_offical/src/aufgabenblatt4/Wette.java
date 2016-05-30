/**
 * PMT/PT1 Praktikum Aufgabenblatt 4
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt4;

public class Wette
{
	private Rennauto fahrer;
	private String spieler;
	private int wetteinsatz;
	
	//Konstruktor
	public Wette(Rennauto fahrer, int wetteinsatz, String spieler)
	{
		this.fahrer=fahrer;
		this.wetteinsatz=wetteinsatz;
		this.spieler=spieler;
	}
	
	//Methoden
	//Getter
	public Rennauto getRennauto()
	{
		return fahrer;
	}
	
	public int getWetteinsatz()
	{
		return wetteinsatz;
	}
	
	public String getSpieler()
	{
		return spieler;
	}
}
