//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 2

package aufgabenblatt2;//import java.io.InputStreamReader;

import java.util.Scanner;

// Sprechende Variablennamen
// engl. vs. deutsch
// magic numbers -> unveränderliche Variablen (GROSSBUCHSTABEN)
// Anwenderinteraktion: alle relevante Infomation
// Header

/**
 * Umrechnung einer Satellitenzeit in Sekunden, auf das Format Tage,
 * Stunden:Minuten:Sekunden
 */
public class Satellitetime {
	public static void main(String[] args) {

		final int SECONDS_PER_MINUTE = 60, MINUTES_PER_HOUR = 60,
				HOURS_PER_DAY = 24;

		int seconds, days, hours, minutes;

		Scanner scan = new Scanner(System.in);
		System.out.println("Gebe die Satellitenzeit in Sekunden ein: ");
		seconds = scan.nextInt();
		// System.out.println(seconds);

		minutes = seconds / SECONDS_PER_MINUTE;
		seconds -= minutes * SECONDS_PER_MINUTE;
		hours = minutes / MINUTES_PER_HOUR;
		minutes -= hours * MINUTES_PER_HOUR;
		days = hours / HOURS_PER_DAY;
		hours -= days * HOURS_PER_DAY;

		System.out.println(
				"Die empfangene Satellitenzeit entspricht (Format: Tage, Stunden:Minute:Sekunden): "
						+ days + " Tage " + hours + ":" + minutes + ":"
						+ seconds);

		scan.close();
	}

}
