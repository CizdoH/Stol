/**
 * Razred za prikaz uporabe dedovanja
 * Razširja razred steklenica
 * @author Jakob Hodzic
 * @version Primer 16 - Dedovanje
 */

public class PivskaSteklenica extends Steklenica {
	// Vse lastnosti od nadrazreda se prenesejo
	//Deklariramo dodatne lastnosti, ki so skupne le pivskim steklenicam
	
	/**
	 * Znamka piva
	 */
	private String znamka;
	
	/**
	 * Temperatura v steklenici
	 */
	private double temperatura;
	
	/**
	 * Konstruktor za inicializacijo nove steklenice, ki je polna in zaprta
	 * nosi enak ime kot class in datoteka!!!
	 * Inicializira vse lastnosti
	 * @param k kapaciteta steklenice (ml)
	 * @param z Znamka piva
	 */	
	public PivskaSteklenica(int k, String z) {
		// pokličemo drug konstruktor
		this(k, z, 8.0);
	}	 
	
	/**
	 * Konstruktor za inicializacijo nove steklenice, ki je polna in zaprta
	 * nosi enak ime kot class in datoteka!!!
	 * Inicializira vse lastnosti
	 * @param k kapaciteta steklenice (ml)
	 * @param z Znamka piva
	 * @param t temperatura piva
	 */	
	public PivskaSteklenica(int k, String z, double t) {
		
		// Pokličemo konstruktor nadrazreda - Steklenica, ki bo inicializiral vse lastnosti nadrazreda
		super (k, "Pivo");
		
		// Inicializiramo dodatne lastnosti
		znamka = z;
		temperatura = t;
		
		//Izpišemo podatke o pivu
		System.out.println("Pivska steklenica je znamke " + z + ".");
	}	
}