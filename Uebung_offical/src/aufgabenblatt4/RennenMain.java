/**
 * PMT/PT1 Praktikum Aufgabenblatt 4
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt4;

public class RennenMain
{

	public static void main(String[] args)
	{
		boolean test;
		//String wettergebniss[];
		Rennauto auto1 = new Rennauto("Johannes", "audi", 120);
		Rennauto auto2 = new Rennauto("Michel", "audi", 120);
		Rennauto sieger;

		Rennen rennen = new Rennen(12000);

		Wettbuero buero = new Wettbuero(rennen, 1.6);

		auto1.ausgeben();
		auto2.ausgeben();

		rennen.addRennauto(auto1);
		rennen.addRennauto(auto2);
		
		//System.out.println("Wetten werden angenommen:");
		test=buero.wetteAnnehmen(auto1, 500, "WetteJohannes");
		System.out.println("WetteJohannes" + test);
		test= buero.wetteAnnehmen(auto2, 600, "WetteMichel");
		System.out.println("WetteMichel" + test);		
		//System.out.println(buero.wetten[0].getSpieler()+"   "+ buero.wetten[1].getSpieler());
		
		sieger = rennen.durchfuehren();
		
		System.out.println("Der Sieger ist:\n\n\n");
		sieger.ausgeben();
		
		System.out.println("Ihre Wette gewonnen haben:\n\n\n");
		for(String ele : buero.auswerten(sieger))
		{
			System.out.println(ele);
		}
	}

}
