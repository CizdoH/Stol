// Uvozimo razred za delo z vrsto buffer iz paketa za delo s vhodno-izhodnimi operacijami
//import java.io.BufferedReader;
import java.io.*;
import java.util.*;
/**
 * Razred za prikaz objektno orientiranega pogramiranja
 *
 * @author Jakob Hodzic
 * @version Primer 15 - Hello World v Javi
 */
public class HelloWorld {
	/**
	*Statični atribut/lastnost za branje vhoda iz konzole (tipkovnice)
	*/
	private static BufferedReader in;
	
	
	/**
	* Deklariramo seznam objektov tipa PivskaSteklenica + kot lastnost razreda HelloWorld
	*/
	
	private static ArrayList<PivskaSteklenica> pivskeSteklenice;
	
	
	
	/**
	 * Glavna metoda program. Zažene se vedno ob zagonu.
	 * @param args Seznam argumentov iz ukazne vrstice
	 */
	public static void main(String[] args) {
		// Izpišemo pozdrav v konzolo
		System.out.println("Pozdravljen, svet!");
		
		//Inicializirmao objekt in za zajem podatkov iz tipkovnice preko  konzole
		in = new BufferedReader(new InputStreamReader(System.in));
		
		//inicializiramo seznam pivskih stklenic
		pivskeSteklenice = new ArrayList<>();

		// deklariramo in inicializirmao lastnosti steklenice
		String znamkaPiva = "";
		int velikostSteklenice = 500;
		double temperaturaSteklenice = 4.0;

		//Poskusimo prebrati iz ukazne konzole
		try {
			//Vnos podatkov o pivski steklenici - znamka
			System.out.print("Vnesi znamko piva: ");
			znamkaPiva = in.readLine();
			
			// Če gre za malo pico, nastavimo velikost na 330ml - default=da
			System.out.print("Je pivo veliko (d/n)?");
			
			// in.readLine vrne objekt zato uporabimo metodo equals namesto ==  preverimo ali sta enaka in ne ista
			if(in.readLine().equals("n")) {
				velikostSteklenice = 330;
			}
			
			//Vnos podatkov o pivski steklenici - temperatura
			System.out.print("Vnesi temperaturo piva: ");
			
			// in.readLine vedno vrne niz zato ga moramo pretvorit v double
			temperaturaSteklenice = Double.parseDouble(in.readLine());
		}
		// lovljenje in obravnava izjem pri branju vrstice
		catch(Exception e) {
			System.out.println("Izjema pri branju podatkov o steklenici piva: " + e);
		}
		// Ustvarimo objekt tipa Steklenica
		Steklenica plastenkaVode = new Steklenica(500, "Voda");
		
		//Ustvarimo objekt tipa Pivska steklenica
		PivskaSteklenica mojePivo = new PivskaSteklenica(velikostSteklenice, znamkaPiva, temperaturaSteklenice);
		
		//Objekt dodamo v seznam
		pivskeSteklenice.add(mojePivo);
		
		// V seznam dodamo še nekaj anonimnih objektov
		pivskeSteklenice.add(new PivskaSteklenica(500, "Laško", 3.0));
		pivskeSteklenice.add(new PivskaSteklenica(500, "Union", 3.0));
		pivskeSteklenice.add(new PivskaSteklenica(330, "Tuborg", 3.0));
		
		// Odpremo vse steklenice na seznamu
		for(int c=0; c<pivskeSteklenice.size(); c++) {
			
			//Odpremo trenutno pivsko steklenico
			pivskeSteklenice.get(c).odpri();
		}
		
		
		//Izpišemo število stekleni piva v seznamu
		System.out.println("V seznamu je " + pivskeSteklenice.size() + " steklenic.");
		
		// Izpijemo požirek piva
		try {
			System.out.println("\nPo požirku je v steklenici še " + mojePivo.izprazni(50) + "ml.");
		}
		catch(Exception e) {
			System.out.println("\nIzjema pri praznenju steklenice: " + e);
		}
		// ne moremo piti, če steklenice ne odpremo
		mojePivo.odpri();

		try {
			System.out.println("\nPo požirku je v steklenici še " + mojePivo.izprazni(50) + "ml.");
		
			//Izpijemo požirek vode
			plastenkaVode.odpri();
			System.out.println("\nPo požirku vode je v steklenici še " + plastenkaVode.izprazni(30) + "ml.");
		}
		catch(Exception e) {
			System.out.println("\nIzjema pri praznenju steklenice: " + e);
		}
	}
}