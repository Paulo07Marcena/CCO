package org.exemplo3;

public class ExemploThread3 {

    public static void main(String[] args) {
        Thread thread1 = new Thread( new PrintTarefa("tarefa1"));
        Thread thread2 = new Thread( new PrintTarefa("tarefa2"));
        Thread thread3 = new Thread( new PrintTarefa("tarefa3"));

        System.out.println("Threads criados, startando as tarefas...");
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("Tarefas startadas, término do main!");
    }


}
