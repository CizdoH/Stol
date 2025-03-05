// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Vnesite material stola:");
            String material = scanner.nextLine();
            System.out.println("Vnesite maksimalno nosilnost stola:");
            int maxTeza = scanner.nextInt();
            scanner.nextLine();

            Stol stol = new Stol(material, maxTeza);
            try {
                stol.sediNaStol();
                System.out.println("Vnesite težo osebe za preverjanje nosilnosti:");
                int teza = scanner.nextInt();
                scanner.nextLine();
                stol.preveriNosilnost(teza);
                stol.vstaniIzStola();
            } catch (StolZasedenException | PrevelikaTezaException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Napaka pri vnosu podatkov.");
        }

        try {
            System.out.println("Vnesite material pisarniškega stola:");
            String materialPisarniski = scanner.nextLine();
            System.out.println("Vnesite maksimalno nosilnost pisarniškega stola:");
            int maxTezaPisarniski = scanner.nextInt();
            System.out.println("Ali ima stol nastavljivo višino? (true/false):");
            boolean nastavljivaVisina = scanner.nextBoolean();
            scanner.nextLine();

            PisarniskiStol pisarniski = new PisarniskiStol(materialPisarniski, maxTezaPisarniski, nastavljivaVisina);
            try {
                pisarniski.sediNaStol();
                pisarniski.nastaviVisino();
                pisarniski.vstaniIzStola();
            } catch (StolZasedenException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Napaka pri vnosu podatkov.");
        }

        try {
            System.out.println("Vnesite material barskega stola:");
            String materialBarski = scanner.nextLine();
            System.out.println("Vnesite maksimalno nosilnost barskega stola:");
            int maxTezaBarski = scanner.nextInt();
            System.out.println("Vnesite višino barskega stola v cm:");
            double visina = scanner.nextDouble();
            scanner.nextLine();

            BarskiStol barski = new BarskiStol(materialBarski, maxTezaBarski, visina);
            try {
                barski.sediNaStol();
                barski.prikaziVisino();
                barski.vstaniIzStola();
            } catch (StolZasedenException e) {
                System.out.println(e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Napaka pri vnosu podatkov.");
        }

        scanner.close();
    }
}