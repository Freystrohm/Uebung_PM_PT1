//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 2

package aufgabenblatt2;

import java.util.Scanner;

// Operator hat mehrere Bedeutungen, abhängig von Kontet -> Fachbegriff

public class Modulo {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int a = 0, b = 0, ergebnisMitOperator = 0, ergebnisMitFormel = 0;

		System.out.println("Erste Zahl: ");
		a = scan.nextInt();
		System.out.println("Zweite Zahl: ");
		b = scan.nextInt();

		ergebnisMitOperator = a % b;
		
		ergebnisMitFormel = a - ((a / b)*b);
		
		System.out.println("Modulo mit Java-Operator: " + ergebnisMitOperator + "\nModulo mit Formel: " + ergebnisMitFormel);

		scan.close();
	}
}
