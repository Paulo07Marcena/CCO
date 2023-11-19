package captura;

import dao.maquina.ProcessoDAO;
import dao.metrica.RegistroDAO;
import model.maquina.Processo;
import model.metrica.Registro;
import com.github.britooo.looca.api.core.Looca;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Captura implements Runnable {
        private Thread worker;
        private final AtomicBoolean running = new AtomicBoolean(false);
        private int interval;
        private Integer idServidor;

        public Captura(int sleepInterval, Integer idServidor) {

                this.interval = sleepInterval;
                this.idServidor = idServidor;
        }

        public void start() {
                worker = new Thread(this);
                worker.start();
        }

        public void stop() {
                running.set(false);
        }

        @Override
        public void run() {
                running.set(true);
                while (running.get()) {
                        try {
                                Thread.sleep(interval);
                        } catch (InterruptedException e){
                                Thread.currentThread().interrupt();
                                System.out.println(
                                        "Essa thread foi interrompida; falha ao completar operação.");
                        }
                        Looca looca = new Looca();
                        RegistroDAO registroDAO = new RegistroDAO();
                        ProcessoDAO processoDAO = new ProcessoDAO();

                        LocalDateTime horaAtual = LocalDateTime.now();
                        DateTimeFormatter formatarHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                        formatarHora.format(horaAtual);

                        String cpuFrequencia;
                        String cpuPorcentagemUso;
                        String redeBytesEnviados;
                        String redeBytesRecebidos;
                        String discoPorcentagemUso;
                        String memoriaPorcentagemUso;
                        List<Processo> processos = new ArrayList<>();


                        // Capturando a frequencia da cpu:
                        cpuFrequencia = String.valueOf(looca.getProcessador().getFrequencia() / 1000000000);

                        // Capturando a porcentagem de uso da cpu:
                        cpuPorcentagemUso = String.valueOf(looca.getProcessador().getUso().shortValue());

                        // Capturando a rede -- Bytes enviados:
                        redeBytesEnviados = String.valueOf(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());

                        // Capturando a rede -- Bytes Recebidos:
                        redeBytesRecebidos = String.valueOf(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());



                        // Capturando a porcentagem de uso do disco:
                        long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                        long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
                        discoPorcentagemUso = String.valueOf((discoTotal - discoDisponivel) * 100 / discoTotal);


                        // Capturando a porcentagem de uso da memória:
                        long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
                        long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;
                        memoriaPorcentagemUso = String.valueOf(memoriaEmUso * 100 / memoriaTotal);


                        // Criando registros:
                        Registro memoriaPorcentagemUsoRegistro = new Registro(2, 2, idServidor, memoriaPorcentagemUso, horaAtual);
                        Registro discoPorcentagemUsoRegistro = new Registro(2, 3, idServidor, discoPorcentagemUso, horaAtual);
                        Registro cpuFrequenciaRegistro = new Registro(4, 1, idServidor, cpuFrequencia, horaAtual);
                        Registro cpuPorcentagemUsoRegistro = new Registro(2, 1, idServidor, cpuPorcentagemUso, horaAtual);
                        Registro redeByteEnviadosRegistro = new Registro(6, 4, idServidor, redeBytesEnviados, horaAtual);
                        Registro redeByteRecebidosRegistro = new Registro(7, 4, idServidor, redeBytesRecebidos, horaAtual);

                        List<com.github.britooo.looca.api.group.processos.Processo> processosLooca = looca.getGrupoDeProcessos().getProcessos();

                        // Insert no banco de dados:
                        registroDAO.insertRegistro(memoriaPorcentagemUsoRegistro);
                        registroDAO.insertRegistro(discoPorcentagemUsoRegistro);
                        registroDAO.insertRegistro(cpuFrequenciaRegistro);
                        registroDAO.insertRegistro(cpuPorcentagemUsoRegistro);
                        registroDAO.insertRegistro(redeByteEnviadosRegistro);
                        registroDAO.insertRegistro(redeByteRecebidosRegistro);

                        for (com.github.britooo.looca.api.group.processos.Processo processo : processosLooca) {
                                processos.add(new Processo(0, processo.getPid(), processo.getNome(), processo.getUsoMemoria(), processo.getUsoCpu())
                                );
                        }
                        processoDAO.insertProcessos(processos, 6);

                }
        }
}
