/**
 * Razred za prikaz modela steklenice, ki vsebuje tekočino
 *
 * @author Jakob Hodzic
 * @version Primer 15b - Razred v Javi
 */
public class Steklenica {
	 //Deklariramo lastnosti
	 
	/**
	 * Kapaciteta steklenice v mililitrih
	 */
	private int kapaciteta;

	/**
	 * Stanje odprtosti:
	 * true = odprta
	 * false = zaprta
	 */	 
	private boolean jeOdprta;
	 
	/**
	 * Trenutna količina
	 */	 
	private int kolicinaVsebine;

	/**
	 * Vrsta vsebine v steklenici
	 */	 
	private String vrstaVsebine;
	
	 
	/**
	 * Konstruktor za inicializacijo nove steklenice, ki je polna in zaprta
	 * nosi enak ime kot class in datoteka!!!
	 * Inicializira vse lastnosti
	 * @param k kapaciteta steklenice (ml)
	 * @param v vsebine v steklenici
	 */	 
	public Steklenica(int k, String v) {
		
		// Inicializiramo vse lastnosti
		this.kapaciteta = k;
		this.jeOdprta = false;
		this.kolicinaVsebine = k;
		this.vrstaVsebine = v;
		
		//Izpišemo podatke o steklenici
		System.out.println("Ustvarjam steklenico " + v + " kapacitete " + k + " ml.");
	}	 

	/**
	 * Metoda, ki odpre steklenico
	 * @return Uspešnost odpiranja
	 * true - prej je bila zaprta
	 * false - prej je bila odprta
	 */	 
	 
	public boolean odpri() {
		
		// če je steklenica že odprta 
		if(jeOdprta) {
			return false;
		}
		// če je steklenica bila zaprta 
		else {
			jeOdprta = true;
			System.out.println("Odpiram steklenico " + vrstaVsebine + ".");
			return true;
		}
	}
	

	/**
	 * Metoda, ki iz stklenice izprazni določeno količino vsebine
	 * @param k Količina vsebine steklenice, ki jo želimo izprazniti (ml)
	 * @return Količina vsebine, ki je ostala v steklenici
	 * @throws Exception, če je steklenica zaprta, ki jo skušamo izprazniti
	 */	 
	 
	public int izprazni(int k) throws Exception {
		
		// če je odprta količino vsebine zmanjšamo za želeno količino
		if(jeOdprta) {
			
			System.out.println("Iz steklenice v kateri je " + kolicinaVsebine + " ml. " + vrstaVsebine + " praznim " + k + " ml.");
			kolicinaVsebine -= k;
			
			//preverimo, če se je kolicinaVsebine preveč zmanjšala
			if(kolicinaVsebine < 0) {
				
				//postavimo kolicino vsebine na 0
				kolicinaVsebine = 0;
				System.out.println("Steklenica " + vrstaVsebine + " je prazna.");
			}	
		}
		
		// če je steklenica zaprta
		else {
			
			//vrže izjemo
			throw new Exception("Ne morem izprazniti steklenice, ker je zaprta.");
		}
		return kolicinaVsebine;
	}
	 
}