package org.exemplo1;

import java.util.Random;

public class PrintTarefa implements Runnable {
    private final int sleepTime;
    private final String nomeTarefa;
    private final static Random gerador = new Random();

    public PrintTarefa (String nome) {
        nomeTarefa = nome;
        sleepTime = gerador.nextInt(500);
    }

    @Override
    public void run() {
        try {
            System.out.println(nomeTarefa + " vai dormir por " + sleepTime + " segundos.");
            Thread.sleep (sleepTime);
        }
        catch (InterruptedException exception) {
            System.out.println(nomeTarefa + " terminou antes do tempo devido a interrupção.");
        }

        System.out.println(nomeTarefa + " acordou!");
    }

}
