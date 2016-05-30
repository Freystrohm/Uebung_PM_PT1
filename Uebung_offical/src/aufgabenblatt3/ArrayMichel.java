//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 3.3

package aufgabenblatt3;

/**
//Verarbeitung einer Temperaturreihe von aufeinander folgenden Tagen zur ermittlung 
//der maximalen und minimalen Temperatur, des maximalen Temperaturunterschiedes und Ausgabe der Reihe
*/
public class ArrayMichel {
	public static void main(String[] args) {

		int[][] tagtemp = { { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 },
				{ 12, 14, 9, 12, 15, 16, 15, 15, 11, 8, 13, 13, 15, 12 } };
		double durchschnitt = 0;
		int max = 0;
		int min = 0;
		int dif = 0;
		int tag1 = 0;
		int tag2 = 0;
		// for (int i=0;i<tagtemp.length;i++){

		for (int j = 0; j < tagtemp[1].length; j++) {

			durchschnitt = durchschnitt + tagtemp[1][j];
		}
		durchschnitt = durchschnitt / tagtemp[1].length;

		System.out.println("Die durschnittliche Temperatur beträgt: " + durchschnitt + " Grad Celcius");
		
		max=tagtemp[1][0];
		for (int j = 0; j < tagtemp[1].length; j++) {

			if (tagtemp[1][j] > max) {
				max = tagtemp[1][j];
			}

		}
		System.out.println("Die höchste Temperatur beträgt: " + max + " Grad Celcius");
		min = tagtemp[1][0];
		for (int j = 0; j < tagtemp[1].length; j++) {

			
			if (tagtemp[1][j] < min) {

				min = tagtemp[1][j];
			}
		}
		System.out.println("Die niedrigste Temperatur beträgt: " + min + " Grad Celcius");

		for (int j = 0; j < tagtemp[1].length - 1; j++) {

			if (tagtemp[1][j] - tagtemp[1][j + 1] > dif) {

				dif = tagtemp[1][j] - tagtemp[1][j + 1];

				tag1 = tagtemp[0][j];
				tag2 = tagtemp[0][j + 1];
			}
		}
		System.out.println("Der größte Temperaturschwung an Tag " + tag1 + " und Tag " + tag2 + " beträgt: " + dif
				+ " Grad Celcius\n");

		for (int[] zeile : tagtemp) {
			for (int wert : zeile) {

				System.out.format("%4d", wert);

			}

			System.out.println();

		}

	}
}
