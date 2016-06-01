package aufgabenblatt6;

public class SendungMain {

	public static void main(String[]args){
		Adresse adresse1 = new Adresse("Petkumstraﬂe",13,22085,Adresse.Staedte.BERLIN);
		Adresse adresse2 = new Adresse("Finkenweg",8,23847,Adresse.Staedte.HAMBURG);
		Person sender = new Person(adresse1);
		Person empfaenger=new Person(adresse2);
		Sendung sendung1 = new Brief(sender,empfaenger);
		
		OfflineSendungsdauerSchaetzer offline = new OfflineSendungsdauerSchaetzer();
		System.out.println(offline.getSendungsTransportDauer(sender.getAdresse().getOrt(), empfaenger.getAdresse().getOrt()));
		
		GoogleSendungsdauerSchaetzer google = new GoogleSendungsdauerSchaetzer();
		System.out.println(google.getSendungsTransportDauer(sender.getAdresse().getOrt(),empfaenger.getAdresse().getOrt()));
		
		
		
	}

}
