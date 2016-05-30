/**
 * PMT/PM1 Praktikum Aufgabenblatt 5.1
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt5_1;

/**
 * 
 * Klasse zum Verwalten von dem Inhalt einer Edelsteinbox
 *
 */

public class EdelsteinBox {
	int[] edelsteine;
	
	//KAS
	//int Array mit Variabler Anzahl 
	//Anzahl ist Edelstein.values().legth

	public EdelsteinBox(Edelsteine... sorte) {//Edelstein Array
	edelsteine =  new int[Edelsteine.values().length];//Int Array
	for (int i=0; i<sorte.length;i++){
		edelsteine[sorte[i].ordinal()]++;
		}
	}
		
	/**
	 * Getter Methode um die Anzahl der jeweiligen Edelsteinsorten
	 * zurückzugeben.
	 * 
	 * @param sorte:
	 *            Übergeben der Sorte des Edelsteins
	 * @return Gibt -1 zurück wenn keine der vohandenen Sorten eingeben wurden.
	 */
	public int getAnzahl(Edelsteine sorte) {
		return edelsteine[sorte.ordinal()];
		
	}

	/**
	 * speichert die Anzahl der jeweiligen Edelsteine zusammengesetz als String
	 * in ergebnis aus D=Diamant,R=Rubin,S=Smaragd return ergebnis
	 */
	public String toString() {
		//KAS Vorschlag hier über EdelStein.values() iterieren
		String ergebnis = "";
		Edelsteine[] edelsteinArray = Edelsteine.values(); 
		for(int i=0;i<edelsteinArray.length;i++){
			for(int j=0; j<edelsteine[i]; j++)
			{
				ergebnis += edelsteinArray[i].toString();
			}
		}
		return ergebnis;
	}

	/**
	 * Gibt den String ergebnis auf der Konsole aus
	 */
	public void ausgeben() {
		System.out.println(toString());
	
	}

	/**
	 * Fügt die jeweilige Anzahl der jeweiligen Edelsteinsorte hinzu.
	 * 
	 * Prüft die letzte Stelle des Arrays ob was enthalten ist und verdoppelt
	 * es. Anschließend wird je nach sorte die Anzahl der Edelsteine in das
	 * Array gepackt!
	 * 
	 * @param sorte: Sorte des Edelsteins
	 * @param anzahlEdelsteine: Anzahl der Edelsteine je Sorte
	 */
	public EdelsteinBox hineinlegen(Edelsteine sorte, int anzahlEdelsteine) {
		edelsteine[sorte.ordinal()]+=anzahlEdelsteine;
		return this;
	}

	/**
	 * Entnimmt die jeweilige Anzahl der jeweiligen Edelsteinsorte. Falls die
	 * entnehmende Anzahl größer ist als die vorhandene, wird die jeweilige
	 * Edelsteinsorte zu 0.
	 * 
	 * @param sorte:
	 *            Sorte des Edelsteins
	 * @param anzahlEdelsteine
	 */
	public EdelsteinBox herausnehmen(Edelsteine sorte, int anzahlEdelsteine) {
		if(edelsteine[sorte.ordinal()]>=anzahlEdelsteine)
		{
		edelsteine[sorte.ordinal()]-=anzahlEdelsteine;
		}
		else
		{
			edelsteine[sorte.ordinal()]=0;	
		}
		return this;
	}

	/**
	 * Addiert die Anzahl einer Sorte Edelsteine auf eine andere und setzt die
	 * addierte Sorte danach auf 0
	 * 
	 * @param vonSorte:
	 *            Edelsteinsorte die zu einer anderen werden soll.
	 * @param zuSorte:
	 *            Edelsteinsorte auf die draufaddiert wird.
	 */
	public EdelsteinBox umwandeln(Edelsteine vonSorte, Edelsteine zuSorte) {
	
		edelsteine[zuSorte.ordinal()]+=edelsteine[vonSorte.ordinal()];
		edelsteine[vonSorte.ordinal()]=0;
		return this;
	}

	/**
	 * Leeren der Schatzkiste indem die Edelsteinsorten auf 0 gesetzt werden.
	 */
	public EdelsteinBox leeren() {
		for (int i=0;i<edelsteine.length;i++){
			edelsteine[i]=0;
		}
		return this;
	}
}