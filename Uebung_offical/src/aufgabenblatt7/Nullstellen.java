/**
 * PMT/PM1 Praktikum Aufgabenblatt 7
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt7;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.text.*;

public class Nullstellen implements Comparator<Double>  {
	private double schwellwert;
	private Funktion funktion;
	HashSet<Double>listeNullstellenHashSet;
	List<Double>listeNullstellenArrayList;
	private int maxAnzahlInterationen=10;
//--------------------------------Konstruktor------------------------------------------------------------
	public Nullstellen(Funktion funktion,double wert, int exponent)
	{
		this.schwellwert=Math.pow(wert, exponent);
		this.funktion=funktion;
		this.listeNullstellenHashSet = new HashSet<Double>();
		this.listeNullstellenArrayList = new ArrayList<Double>();
	}
//----------------------------------Methoden--------------------------------------------------------------
/**
 * 
 * @param startWert: Startwert zur Brechnung der Nullstelle
 * @return double Nullstelle
 * @throws NullstellenException
 * 
 * Sucht mit Hilfe des Newtonverfahrens eine Nullstelle heraus.
 */
	public double findeNullstelle (double startWert)throws NullstellenException{
		double nullstelle =startWert;
		
		
		if (startWert==0){
		throw new NullstellenException("Startwert darf nicht 0 sein!");
		
		}
		nullstelle = nullstelle-(funktion.berechnefVonX(startWert)/funktion.berechneAbleitungFvonX(startWert));

		int zaehler=0;
		if (startWert>0)
		{
		while (funktion.berechnefVonX(nullstelle)>=nullstelle*schwellwert)//Abbruch bei f(x) < 10^-5 Genauigkeit
			{
			if (funktion.berechnefVonX(nullstelle)==0){
				break;
			}
			zaehler++;
			if(zaehler>=maxAnzahlInterationen)
				{
					throw new NullstellenException("Keine Nullstelle gefunden!");
				}
				nullstelle = nullstelle-(funktion.berechnefVonX(nullstelle)/funktion.berechneAbleitungFvonX(nullstelle));
				}
		}
		else 
		{
		while (funktion.berechnefVonX(nullstelle)>=-(nullstelle*schwellwert)){
			zaehler++;
			if(zaehler>=10)
				{
					throw new NullstellenException("Keine Nullstelle gefunden!");
				}
				nullstelle = nullstelle-(funktion.berechnefVonX(nullstelle)/funktion.berechneAbleitungFvonX(nullstelle));
				//System.out.println(nullstelle);
				}
			}
		return nullstelle;
	}
	/**
	 * 
	 * @param min: Kleinster Wert des Intervalls
	 * @param max: Groeﬂter Wert des Intervalls
	 * @param anzahlVersuche
	 * @return HashSet <Double> listeNullstellenHashSet
	 * @throws NullstellenException durch findeNullstelle() Methode
	 * 
	 * Speichert mit Hilfe der findeNullstelle() Methode und einer randomisierten Zahl aus dem angegebenen 
	 * Intervall die N‰herungswerte in eine Arraylist. 
	 */
	public HashSet<Double> findeNullstellenRandomisiert(int min, int max, int anzahlVersuche)throws NullstellenException
	{
		
		double zwischenWert=0;

		List<Integer> listeIntervall=new ArrayList<Integer>();
		
		for (int i=min;i<=max;i++){
				 listeIntervall.add(i);
					}
				
		for (int i=0;i<anzahlVersuche;i++){
			double startWert=listeIntervall.get((int)(Math.random()*(listeIntervall.size())));
			if (startWert!=0)
			{
				zwischenWert=findeNullstelle(startWert);
				listeNullstellenHashSet.add(zwischenWert);
			}
		}
		listeNullstellensortieren();
		return listeNullstellenHashSet; 
	}
	
	/**
	 * speichert die gefundenen Werte in eine ArrayList und sortiert diese
	 * 	
	 */
	public void listeNullstellensortieren(){
		Iterator <Double> iter= listeNullstellenHashSet.iterator();
		for(int i=0;i<listeNullstellenHashSet.size();i++){
			if (iter.hasNext()){
				listeNullstellenArrayList.add(iter.next());
			}
			else{
				continue;
			}
		}
		Collections.sort(listeNullstellenArrayList);
		Iterator <Double> iter2= listeNullstellenArrayList.iterator();
		DoubleWert wert = new DoubleWert();

		while (iter2.hasNext()){
			int zaehlerInterator=0;
			zaehlerInterator++;
			if(listeNullstellenArrayList.size()<=1){
			break;
			}
				if(wert.equals(iter2.next(),listeNullstellenArrayList.get(zaehlerInterator))){
				iter2.remove();
				}
				}
				}
	/**
	 * Gibt die ArrayList aus
	 */
	public String toString(){
		DecimalFormat format = new DecimalFormat("#0.00000"); 
		String ergebnis="Nullstellen: {";
		Iterator <Double> iter2= listeNullstellenArrayList.iterator();
		int zaehler = 0;
		while(iter2.hasNext()){
			zaehler++;
			if(zaehler == listeNullstellenArrayList.size()){
				ergebnis+= format.format(iter2.next());
				}
			else{
			ergebnis += format.format(iter2.next())+"| ";
			}
		}
			return ergebnis+"}";	
	}
	@Override
	public int compare(Double wert1, Double wert2) {
		DoubleWert wert =new DoubleWert();
		if(wert.equals(wert1, wert2)==true){
		return -1;
		}
		return 0;
	}


}
