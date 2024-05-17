package es_7_java;

public class Main extends Thread{
    public static void main(String[] args) {
        int M = 0;
        Grossista[] g = new Grossista[10];
        Produttore[] p = new Produttore[5];
        Mercato m = new Mercato(M);

        for (int i = 0; i < g.length; i++) {
            g[i] = new Grossista(m, "Grossista-" + (i+1));
        }
        for (int i = 0; i < p.length; i++) {
            p[i] = new Produttore(m, "Produttore-" + (i+1));
        }
        for (int i = 0; i < g.length; i++) {
            g[i].start();
        }
        for (int i = 0; i < p.length; i++) {
            p[i].start();
        }

        try {
            sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for (int i = 0; i < g.length; i++) {
            g[i].shutdown();
        }
        for (int i = 0; i < p.length; i++) {
            p[i].shutdown();
        }
    }
}