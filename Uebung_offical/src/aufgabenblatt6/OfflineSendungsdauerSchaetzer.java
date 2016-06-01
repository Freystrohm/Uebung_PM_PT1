/**
 * PMT/PM1 Praktikum Aufgabenblatt 6
 * @author Johannes Kruber, Michel Gerlach
 */
package aufgabenblatt6;

import java.io.FileReader;

import aufgabenblatt6.Adresse.Staedte;

public class OfflineSendungsdauerSchaetzer implements SendungsdauerSchaetzer{
	private Adresse.Staedte[] listeStaedte= Adresse.Staedte.values();
	private int [][] listeStaedtekombinationen = new int[listeStaedte.length][listeStaedte.length];
	private int [] listeSendedauer = {0,173,322,334,311,355,325,285,306,227,170,0,426,250,284,376,234,200,214,77,321,425,0,326,234,141,355,346,365,409,331,249,325,
			0,119,215,42,70,63,190,312,284,232,118,0,131,147,141,158,261,354,376,145,215,132,0,244,247,255,360,325,237,353,42,147,243,0,56,35,178,284,202,347,72,
			142,247,55,0,31,144,307,217,365,62,158,254,35,34,0,158,227,79,411,194,265,362,178,144,158,0};//Für 10 Staedte

	
 
    //Konstruktor-------------------------------------------------------


	public void listeZeitenErstellen(){
		GoogleSendungsdauerSchaetzer google= new GoogleSendungsdauerSchaetzer();
		for (int i=0;i<listeStaedte.length;i++){
			for (int j=0;j<listeStaedte.length;j++){
				listeStaedtekombinationen[listeStaedte[i].ordinal()][listeStaedte[j].ordinal()]=google.getSendungsTransportDauer(listeStaedte[i], listeStaedte[j]);
				System.out.println(listeStaedtekombinationen[i][j]);
			}
		}
	}
	
	@Override
	public int getSendungsTransportDauer(Staedte senderOrt, Staedte empfaengerOrt) {
		int offlineTransportDauer;
		int stelleOfflineTransportdauerliste = senderOrt.ordinal()+empfaengerOrt.ordinal();
		offlineTransportDauer=listeSendedauer[stelleOfflineTransportdauerliste];
		
		return offlineTransportDauer;
	}
	
	public static void main(String[]args){
		
			//offline.listeZeitenErstellen();
	}

}
