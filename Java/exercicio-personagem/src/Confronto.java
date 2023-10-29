import java.util.Random;

public class Confronto {

    public static void lutar(Heroi heroi, Vilao vilao){
        Double poderHeroi = heroi.getForcaTotal();
        Double poderVilao = vilao.getForcaTotal();

        if (poderHeroi > poderVilao){
            System.out.println("""
                    O bem venceu o mal mais uma vez!
                    %s venceu %s!
                    
                    """.formatted(heroi.getCodinome(), vilao.getCodinome()));
        } else if (poderVilao > poderHeroi) {
            System.out.println("""
                    Hoje a história foi diferente!
                    %s venceu %s!
                    
                    """.formatted(vilao.getCodinome(), heroi.getCodinome()));
        } else {
            System.out.print("""
                    A luta no tempo normal acabou em empate!
                    Vamos para o round de desempate...
                    """);

            Random random = new Random();
            Integer sorteio = random.nextInt(11);


            if (sorteio % 2 == 0){
                System.out.println("""
                        No round de desempate, %s levou a melhor!
                        """.formatted(heroi.getCodinome()));
            } else {
                System.out.println("""
                        No round de desempate, %s levou a melhor!
                        """.formatted(vilao.getCodinome()));
            }

        }
    }
}
