package es_7_java;

import java.util.concurrent.Semaphore;

public class Mercato {
    private int m;
    private int c;
    private int pV = 10;
    private int pA = 12;
    int qPresa;
    int qData;
    private Semaphore sProd, sGros;

    public Mercato(int m) {
        this.m = m;
        c = 50;
        sProd = new Semaphore(5);
        sGros = new Semaphore(10);
        sGros.drainPermits();
    }

    public int compra(Grossista g){
        do {
            qPresa = (int)(Math.random() * 4 + 1);
        } while ((m - qPresa) < 0);
        m -= qPresa;
        c += (qPresa * pA);
        return qPresa;
    }

    public int vendi(Produttore p){
        do {
           qData = (int)(Math.random() * 2 + 1); 
        } while ((c - (qData * pV)) < 0);
        m += qData;
        c -= (qData * pV);
        return qPresa;
    }

    public int getM() {
        return m;
    }

    public int getC() {
        return c;
    }

    public Semaphore getsProd() {
        return sProd;
    }

    public Semaphore getsGros() {
        return sGros;
    }
}
