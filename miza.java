//Uvozimo razrede za delo z vhodno-izhodnimi operacijami ter pripomocke
import java.util.*;
import java.io.*;
import java.swing.*;
import java.awt.event.*;

/**
 * Razred za prikaz modela steklenice, ki vsebuje tekocino
 *
 * @author Jakob Hodzic
 * @version Primer 20 - Graficni uporabniski vmesnik in dogodki
 */

public class miza extends JFrame implements ActionListener {
	
	//Deklariramo zasebne lastnosti GUI
	private JPanel povrsina;
	private JButton dodajButton;
	private JTextField znamkaTextField;
	private JTextField stopnjaAlkoholaTextField;
	private pivskasteklenicatablemodel modelTabele;
	
	/**
	*Glavna metoda programa. Zazene se vednmo ob zagonu
	*
	*@param args Seznam argumentov iz ukazne vrstice
	*/
	
	public static void main(string[]) args){
		
		//izpisemo zacetek
		System.out.prinln("Zaganjam GUI ...");
		
		//Ustvarimo objekt razreda miza (klicemo konstruktor razreda miza)
		
		miza m = new miza();
	}
	
	/**
	*Konstrukor , ki postavi osnove Lastnosti okna
	*/
	public miza(){
		
		//poklicemo konstruktor
		super("miza s steklenicami");
		
		//Nastavimo obnasanje krizca [x] tako, da konca aplikacijo
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//nastavimo velikost okna
		setSize(800,600);
		
		//Inicializiramo elemente GUI
		povrsina = new JPanel();
		
		//Vnosna polja za dodajanje steklenice
		znamkaTextField = new JTextField(32);
		stopnjaAlkoholaTextField = new JTextField(4);
		
		// dodamo vnosna polja na povrsino
		povrsina.add(new JLabel("Znamka piva"));
		povrsina.add(znamkaTextField);
		
		povrsina.add(new JLabel("Stopnja alkohola"));
		povrsina.add(stopnjaAlkoholaTextField);
		
		//gumb za dodajanje steklenice
		dodajButton.addActionListener(this);
		
		// dodamo gumb na povrsino
		povrsina.add(dodajButton);
		
		//inicializiramo model tabele
		modelTabele = new pivskasteklenicatablemodel ();
		
		//tabelo postavimo na povrsino
		povrsina.add(mew JTable(modelTabele));
		
		//povrsino dodamo na okno
		add(povrsina);
		
		// prikazemo okno
		setVisible(true);
	}
	/**
	*Metoda, ki jo predpisuje vmesnik ActionListener
	* se klice vedno, ko je pritinjen gumb
	*@param je dogodek ob kliku
	*/
	public void actionPerformed(ActionEvent e){
		//izpisemo lastnosti iz vnosnih polja
		System.out.prinln("Dodajam steklenice ...");
		System.out.prinln("Znamka piva: " + znamkaTextField.getText());
		System.out.prinln("Dodajam steklenice " + stopnjaAlkoholaTextField.getText());
	
	
	//spremenljivka za stopnjo alkohola
	double sa = Double.parseDouble(stopnjaAlkoholaTextField.getText());
	
	//ustvarimo nov objekt tipa pivskasteklenica
	PivskaSteklenica nova = new PivskaSteklenica(500, znamkaTextField.getText(), 8.0, sa);
	
	//objekt dodamo v tabelo
	modelTabele.addpivskasteklenica(nova);
}