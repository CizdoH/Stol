import javax.swing.table.*;

/**
 * Razred za prikaz modela steklenice, ki vsebuje tekocino
 *
 * @author Jakob Hodzic
 * @version Primer 20 - Graficni uporabniski vmesnik in dogodki
 */

public class pivskasteklenicatablemodel extends DefaultTablemodel{
	
	/**
	*konstruktr, ki ustvari tabelo steklenic na mizi
	*/
	
	public pivskasteklenicatablemodel() {
	
	
		//poklicemo konstruktor nadrazreda
		super();
		
		//dodamo stolpce v tabelo
		addColumn("Znamka");
		addColumn("Stopnja alkohola");
		
		// Ustvarmio seznam objektov ( nizov) , ki predstavljajo vrstico tabele
		Object[] vrstinca = new Object[] {"Testna znamka", "5.0"};
		
		//vrstico vstavimo v tabelo
		addRow(vrstica);
	
	}
	
	/**
	*javna metoda, ki doda pivsko steklenico v tabelo
	*@param ps objekt, ki ga dodamo v tabelo
	*/
	public void addpivskasteklenica(pivskasteklenica ps) {
		
		// Ustvarmio seznam objektov ( nizov) , ki predstavljajo vrstico tabele
		Object[] vrstinca = new Object[] {ps.getZnamka(), ps.getstopnjaalkohola()};
		
		//vrstico vstavimo v tabelo
		addRow(vrstica);
		
	}
	
}