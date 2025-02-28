public class Cronometre extends Thread {
    private String nom;
    private int durada;

    public Cronometre(String nom, int durada) {
        this.nom = nom;
        this.durada = durada;
    }

    @Override
    public void run() {
        try {
            for (int i = durada; i > 0; i--) {
                System.out.println(nom + " - Temps restant: " + i + " segons");
                Thread.sleep(1000); // Pausa d'1 segon
            }
            System.out.println(nom + " ha finalitzat.");
        } catch (InterruptedException e) {
            System.err.println(nom + " interromput.");
        }
    }
}
