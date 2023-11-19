import captura.Captura;
import dao.negocio.UsuarioDAO;
import model.negocio.Usuario;
import com.github.britooo.looca.api.core.Looca;
import com.github.britooo.looca.api.group.processos.ProcessoGrupo;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    // Projeto individual da segunda sprint
    private static Integer escolhadoDoMenu = 0;
    private static final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        String email;
        String senha;
        Usuario login;

        System.out.print("""                                                                                                               
                API de captura de dados de máquina via Java, utilizando o Locca e conectando a um banco do MySQL
                """);

        do {
            System.out.print("Login: ");
            email = leitor.nextLine();

            System.out.print("Senha: ");
            senha = leitor.nextLine();

            login = usuarioDAO.getUsuarioPorEmailSenha(email, senha);

            if (Objects.isNull(login)) {
                System.out.println("Usuário não encontrado!\n");
            }
        } while (Objects.isNull(login));
        Captura threadCaptura = new Captura(8000, 6);
        threadCaptura.start();
        Looca looca = new Looca();

        System.out.printf("\n\n\nOlá %s |", login.getNome());

        Looca Sistema = new Looca();
        System.out.print("Sistema operacional: ");
        System.out.println(Sistema.getSistema().getSistemaOperacional() + "\n\n");

        do {
            System.out.println("""
                    Escolha uma opção:
                    1. Disco
                    2. Memoria
                    3. Rede
                    4. CPU
                    5. Todos os Componentes
                    6. Processos
                    7. Sair
                    """);
            System.out.print("Escolha: ");
            escolhadoDoMenu = leitor.nextInt();

            switch (escolhadoDoMenu) {
                case 1 -> {
                    System.out.println("Opção (Disco) escolhida!");
                    long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                    long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
                    System.out.print("Porcentagem de uso: ");
                    System.out.print((discoTotal - discoDisponivel) * 100 / discoTotal);
                    System.out.println(" %");
                }
                case 2 -> {
                    System.out.println("Opção (Memória) escolhida! ");
                    long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
                    long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;
                    System.out.print("Porcentagem de uso: ");
                    System.out.print(memoriaEmUso * 100 / memoriaTotal);
                    System.out.println(" %");
                }
                case 3 -> {
                    System.out.println("Opção (Rede) escolhida! ");
                    System.out.print("Bytes enviados: ");
                    System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());
                    System.out.println(" bytes");
                    System.out.print("Bytes recebidos: ");
                    System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());
                    System.out.println(" bytes");
                }
                case 4 -> {
                    System.out.println("Opção (CPU) escolhida!");
                    System.out.print("Frequência de CPU: ");
                    System.out.print(looca.getProcessador().getFrequencia() / 1000000000);
                    System.out.println(" Hz");
                }
                case 5 -> {
                    System.out.println("Opção (Todos) escolhida! ");
                    long discoTotal = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
                    long discoDisponivel = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
                    System.out.print("Porcentagem de uso do disco: ");
                    System.out.print((discoTotal - discoDisponivel) * 100 / discoTotal);
                    System.out.println(" %");
                    long memoriaTotal = looca.getMemoria().getTotal() / 100000000;
                    long memoriaEmUso = looca.getMemoria().getEmUso() / 100000000;
                    System.out.print("Porcentagem de uso da memória: ");
                    System.out.print(memoriaEmUso * 100 / memoriaTotal);
                    System.out.println(" %");
                    System.out.print("Bytes enviados: ");
                    System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesEnviados());
                    System.out.println(" bytes");
                    System.out.print("Bytes recebidos: ");
                    System.out.print(looca.getRede().getGrupoDeInterfaces().getInterfaces().get(0).getBytesRecebidos());
                    System.out.println(" bytes");
                    System.out.print("Frequência de CPU: ");
                    System.out.print(looca.getProcessador().getFrequencia() / 1000000000);
                    System.out.println(" Hz");
                }
                case 6 -> {
                    System.out.println("Nome Processo; PID; % Uso CPU; % Uso RAM; MB utilizados; VRAM Utilizada");
                    ProcessoGrupo prcs = looca.getGrupoDeProcessos();
                    for (com.github.britooo.looca.api.group.processos.Processo processo : prcs.getProcessos()) {
                        System.out.printf("%s; %d; %.1f; %.1f; %.1f; %.1f\n",
                                processo.getNome(),
                                processo.getPid(),
                                processo.getUsoCpu(),
                                processo.getUsoMemoria(),
                                processo.getBytesUtilizados() / Math.pow(10, 6),
                                processo.getMemoriaVirtualUtilizada() / Math.pow(10, 6)
                        );
                    }
                }
                case 7 -> {
                    System.out.println("Até mais!");
                    leitor.close();
                    threadCaptura.stop();
                }
                default -> System.out.println("Escolha inválida!");
            }
        } while (escolhadoDoMenu != 7);
    }
}


