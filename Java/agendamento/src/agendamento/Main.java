package agendamento;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {

        //Scanner
        Scanner leitor = new Scanner(System.in);

        System.out.print("Mensagem para rotina: ");
        String msg = leitor.nextLine();

        System.out.println("Para sair pressione qualquer tecla");

        //Agendador
        Timer agendador = new Timer();

        // TimerTask --> Tarefas com periodo

// -----> Funciona, mas não é reaproveitado
//        TimerTask tarefa1 = new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println("Olá");
//            }
//        };


        //Expressão CRON


        ExibirMensagemTask tarefa1 = new ExibirMensagemTask(msg, 1000, 5000);

        agendador.schedule(tarefa1, tarefa1.getDelay(), tarefa1.getPeriodo());





        leitor.nextLine();



// -----> Método funcional, mas ruim.
//        while(true){
//            System.out.println("Repetição");
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e ){
//                throw new RuntimeException(e);
//            }
//        }





    }
}
