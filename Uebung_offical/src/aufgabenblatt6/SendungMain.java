package aufgabenblatt6;

import java.util.Scanner;

public class SendungMain
{

	public static void main(String[] args)
	{
		Simulator simulator = new Simulator();
		Scanner scan = new Scanner(System.in);
		boolean ende = false;
		int i = 0;
		while (!ende)
		{
			System.out.println("Was willst du tun?:\n"
					+ "1. einen Zeitschritt von 60 ausführen\n"
					+ "2. Programm beenden\n");

			System.out.println("waehle: ");
			i = scan.nextInt();
			switch (i)
			{
				case 1 :
					simulator.zeitSchritt(60);
					break;
				case 2 :
					ende = true;
					break;
				default :
					System.out.println("ungueltige Eingabe try again!!!!\n\n");
			}
		}
		scan.close();
	}

}
