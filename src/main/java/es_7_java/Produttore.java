package es_7_java;

public class Produttore extends Thread{

    Mercato m;
    String nome;
    boolean running = true;

    public Produttore(Mercato m, String nome){
        this.m = m;
        this.nome = nome;
    }

    @Override
    public void run() {
        while (running) {
            try {
                m.getsProd().acquire();
                int q = m.vendi(this);
                System.out.println(nome + " vende " + q + " quintali---M: " + m.getM() + "---C: " + m.getC());
                this.sleep(1000);
                //m.getsGros().release(2);
                m.getsProd().release();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }

    public void shutdown(){
        running = false;
    }
}
