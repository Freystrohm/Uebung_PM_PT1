/**
 * PMT/PT1 Praktikum Aufgabenblatt 5.2
 * @author Johannes Kruber
 * @author Michel Gerlach 
 */
package aufgabenblatt5;

public class ZugMain
{

	public static void main(String[] args)
	{
		Eisenbahnwagen[] wagen = new Eisenbahnwagen[20];
		Zug zug1 = new Zug(20, 1), zug2 = new Zug(30, 2);

		for (int i = 0; i < wagen.length; i++)
		{
			wagen[i]=new Eisenbahnwagen((int)(50* Math.random()), (int)(200*Math.random()));
			if(i%2 ==0)
			{
				zug1.wagenHinzufuegen(wagen[i]);
			}
			else
			{
				zug2.wagenHinzufuegen(wagen[i]);
			}
		}
		System.out.println(zug1.toString());
		System.out.println(zug2.toString());
		
		zug1.zugAnhaengen(zug2);
		
		System.out.println(zug1.toString());
		System.out.println(zug2.toString());

	}

}
