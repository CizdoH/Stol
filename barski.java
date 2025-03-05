// Podrazred BarskiStol
class BarskiStol extends Stol {
    private double visina;

    public BarskiStol(String material, int maxTeza, double visina) {
        super(material, maxTeza);
        this.visina = visina;
    }

    public void prikaziVisino() {
        System.out.println("Barski stol ima višino: " + visina + " cm.");
    }
}