//PMT/PT1 Praktikum Johannes Kruber, Michel Gerlach Aufgabenblatt 3.2

package aufgabenblatt3;
import java.util.Scanner;

// While-Schleife
// Obere Grenze


/**
 * Berechnen der Fibonacczahlen abhängig von der Benutzereingabe 
 */
public class FibonacciZahlen {

	public static void main(String[] args) {
		int fib1 = 0, fib2 = 1, eingabe, temp = 0, z =0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Welche Fibonacci-Zahl soll berechnet werden (nicht groesser 47)? :");
		eingabe = scan.nextInt();

		
		while (z < eingabe) 
		{
			if (z == 0)
			{
				if (eingabe == 1) 
				{
					fib2 = fib1;
				}
			} 
			else 
			{
				if (z == 1) 
				{

				}
				else 
				{
					fib1 += fib2;
					temp = fib1;
					fib1 = fib2;
					fib2 = temp;
				}
			}
			z++;		
		}

		System.out.println("Das Ergebnis für die " + eingabe + "te Fibbonacci-Zahl ist: " + fib2);

		scan.close();
	}

}
