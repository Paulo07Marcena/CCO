package org.exemplo2;

public class ExemploThread2 {
    static int contador =0;
    public static void incrementaContador(String nome) {
        contador++;
        System.out.println("Contador atual é " + contador + ", incrementado por " + nome);
    }

    public static Runnable tarefa1= new Runnable() {
        @Override
        public void run() {
            try {
                for (int i=0; i<5; i++) {
                    incrementaContador("tarefa1");
                }
            } catch (Exception e) {
                System.out.println("Exception: "+e);
            }

        }
    };

    public static Runnable tarefa2= new Runnable() {
        @Override
        public void run() {
            try {
                for (int i=0; i<5; i++) {
                    incrementaContador("tarefa2");
                }
            } catch (Exception e) {
                System.out.println("Exception: "+e);
            }

        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Thread(tarefa1).start();
        new Thread(tarefa2).start();
    }

}
