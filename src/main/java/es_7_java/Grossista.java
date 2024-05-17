package es_7_java;

public class Grossista extends Thread{

    Mercato m;
    String nome;
    boolean running = true;

    public Grossista(Mercato m, String nome){
        this.m = m;
        this.nome = nome;
    }

    @Override
    public void run() {
        while (running) {
            try {
                this.sleep(1000);
                m.getsGros().acquire();
                int q = m.compra(this);
                System.out.println(nome + " compra " + q + "quintali---M: " + m.getM() + "---C: " + m.getC());
                m.getsProd().release();
                m.getsGros().release();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }       
        }
    }

    public void shutdown(){
        running = false;
    }
}
