public class App {

    public static void main(String[] args) {

        Heroi homemAranha = new Heroi("Peter Parker", "Homem aranha");
        homemAranha.adicionarPoder("Força", 100);
        homemAranha.adicionarPoder("Geração de teias", 100);
        homemAranha.adicionarPoder("Reflexo aranha", 100);

        Vilao DoendeVerde = new Vilao("Norman Osborn", "Doende verde");
        DoendeVerde.adicionarPoder("Inteligência", 100);
        DoendeVerde.adicionarPoder("Armamento", 100);
        DoendeVerde.adicionarPoder("Força", 80);
        DoendeVerde.adicionarPoder("Dinheiro", 65);




        Heroi homemDeFerro = new Heroi("Tony Stark", "Homem de Ferro");
        homemDeFerro.adicionarPoder("Inteligência", 80);
        homemDeFerro.adicionarPoder("Dinheiro", 100);
        homemDeFerro.adicionarPoder("Armadura", 100);

        Vilao chicoteNegro = new Vilao("Ivan Vanko", "Chicote Negro");
        chicoteNegro.adicionarPoder("Inteligência", 70);
        chicoteNegro.adicionarPoder("Armamento", 100);
        chicoteNegro.adicionarPoder("Força", 80);




        Heroi capitaoAmerica = new Heroi("Steve Rogers", "Capitão América");
        capitaoAmerica.adicionarPoder("Força", 90);
        capitaoAmerica.adicionarPoder("Agilidade", 80);
        capitaoAmerica.adicionarPoder("Escudo Indestrutível", 100);

        Vilao caveiraVermelha = new Vilao("Johann Schmidt", "Caveira Vermelha");
        caveiraVermelha.adicionarPoder("Inteligência", 90);
        caveiraVermelha.adicionarPoder("Habilidades de Combate", 70);
        caveiraVermelha.adicionarPoder("Artefatos Místicos", 100);
        caveiraVermelha.adicionarPoder("Exercíto", 100);


        //Lutas
        Confronto confrontos = new Confronto();

        // Testando empate:
        confrontos.lutar(homemAranha, DoendeVerde);

        // Testando vitória do heroi:
        confrontos.lutar(homemDeFerro, chicoteNegro);

        // Testando vitória do vilão:
        confrontos.lutar(capitaoAmerica, caveiraVermelha);

    }
}
