public class ExecucioFils {
    public static void main(String[] args) {
        Cronometre cronoAlfa = new Cronometre("CronoAlfa", 21);
        Cronometre cronoBravo = new Cronometre("CronoBravo", 15);
        Cronometre cronoCharlie = new Cronometre("CronoCharlie", 12);
        Cronometre cronoDelta = new Cronometre("CronoDelta", 6);
        Cronometre cronoEcho = new Cronometre("CronoEcho", 11);
        Cronometre cronoFoxtrot = new Cronometre("CronoFoxtrot", 4);
        Cronometre cronoGolf = new Cronometre("CronoGolf", 7);

        cronoAlfa.start();
        cronoCharlie.start();
        cronoFoxtrot.start();
        cronoGolf.start();

        synchronized (ExecucioFils.class) {
            cronoBravo.start();
            esperar(4000);
        }

        synchronized (ExecucioFils.class) {
            cronoDelta.start();
            try {
                cronoDelta.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (ExecucioFils.class) {
            cronoEcho.start();
            esperar(8000);
        }
    }

    private static void esperar(int milisegons) {
        try {
            Thread.sleep(milisegons);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
