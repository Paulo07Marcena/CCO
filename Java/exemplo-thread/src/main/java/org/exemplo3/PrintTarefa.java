package org.exemplo3;

public class PrintTarefa implements Runnable {
    private final String nomeTarefa;

    public PrintTarefa (String nome) {
        nomeTarefa = nome;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 30; i++) {
            System.out.println(nomeTarefa + ": i=" + i);
        }
        System.out.println(nomeTarefa + " finalizando!");
    }

}

