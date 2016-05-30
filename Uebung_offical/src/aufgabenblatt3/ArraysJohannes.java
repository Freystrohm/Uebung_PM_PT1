//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 3.3

package aufgabenblatt3;
/**
//Verarbeitung einer Temperaturreihe von aufeinander folgenden Tagen zur ermittlung 
//der maximalen und minimalen Temperatur, des maximalen Temperaturunterschiedes und Ausgabe der Reihe
*/
public class ArraysJohannes
{

	public static void main(String[] args)
	{

		int[] temperatur =
		{12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12};
		double summetemperatur = 0;
		int temperaturmin = 0, temperaturmax = 0, tag1 = 0, tag2 = 0, diff = 0;

		for (int ele : temperatur)
		{
			summetemperatur += ele;
		}

		System.out.println("b) Die Durchschnittstemperatur betraegt: "
				+ summetemperatur / temperatur.length);

		temperaturmin = temperatur[1];
		for (int i = 0; i < temperatur.length; i++)
		{
			if (temperatur[i] < temperaturmin)
			{
				temperaturmin = temperatur[i];
			}
		}

		temperaturmax = temperatur[1];
		for (int i = 0; i < temperatur.length; i++)
		{
			if (temperatur[i] > temperaturmax)
			{
				temperaturmax = temperatur[i];
			}
		}

		System.out.println("c) Die Minimale Temperatur ist: " + temperaturmin
				+ "  Die Maximale Temperatur ist: " + temperaturmax);

		for (int i = 0; i < temperatur.length - 1; i++)
		{
			if (Math.abs(temperatur[i] - temperatur[i + 1]) > diff)
			{
				diff = Math.abs(temperatur[i] - temperatur[i + 1]);
				tag1 = i + 1;
				tag2 = i + 2;
			}
		}
		
		System.out.println("d) der Groeßte Temperaturunterschied ist " + diff
				+ " und ist an den Tagen: " + tag1 + " und " + tag2
				+ " gegeben");
		System.out.print("Tag:\t\t");
		
		for (int i = 0; i < temperatur.length - 1; i++)
		{
			if(Math.abs(temperatur[i] - temperatur[i + 1]) == diff && tag1!=i+1 && tag2!=i+2)
			{
				System.out.println("d) der Groeßte Temperaturunterschied ist " + Math.abs(temperatur[i] - temperatur[i + 1])
						+ " und ist an den Tagen: " + i+1 + " und " + i+2
						+ " gegeben");
				System.out.print("Tag:\t\t");
			}
		}
		
		for (int i = 0; i < temperatur.length; i++)
		{
			System.out.print((i + 1) + "\t");
		}
		System.out.print("\nTemperatur:\t");
		for (int i = 0; i < temperatur.length; i++)
		{
			System.out.print(temperatur[i] + "\t");
		}

	}

}
