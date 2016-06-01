/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;
/**
 * Erstellt eine Sendung als Brief
 *
 */
public class Brief extends Sendung{
private boolean istEinschreiben;
private boolean istAusgeliefert;
//-----------------------------Konstruktor--------------------------------------------------------------------
public Brief(Person sender,Person empfaenger){
	super(sender,empfaenger);
/**
 * Gibt den Typ der Sendung als String wieder.
 */
}
public String getSendungsTyp(){

	return "Brief";
}
/**
 * Nicht benötigt?!?!?!
 */
public void istEinEinschreiben(){
}

/**
 * Gibt zurück ob die Sendung ausgeliefert wurde oder nicht.
 */
public boolean istAusgeliefert(){
	if (getTransportDauer()<=0){
		return true;
	}
	return false;	
}
/**
 * Aktualisiert den Startzeitpunkt der Sendung.
 */
@Override
public void aktualisiereZeitpunkt(int zeit) {
	startZeitpunkt+=zeit;
	}
/**
 * Reduziert die Transportdauer nach jedem Schritt um eine Schrittweite.
 */
@Override
public void schritt (int schrittweite){
	super.transportDauer-=schrittweite;
}
}
