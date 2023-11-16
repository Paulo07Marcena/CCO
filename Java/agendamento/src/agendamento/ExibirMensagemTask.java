package agendamento;

import java.util.TimerTask;

public class ExibirMensagemTask extends TimerTask {

    private String mensagem;

    private int delay;

    private int periodo;

    public ExibirMensagemTask(String mensagem, int delay, int periodo) {
        this.mensagem = mensagem;
        this.delay = delay;
        this.periodo = periodo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getDelay() {
        return delay;
    }

    public int getPeriodo() {
        return periodo;
    }

    @Override
    public void run() {
        System.out.println("Mensagem: " + mensagem);
    }
}
