package pkg;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitorDeInteiros = new Scanner(System.in);
        Scanner leitorDeString = new Scanner(System.in);
        Scanner leitorDeDouble = new Scanner(System.in);

        Carrinho carrinho = new Carrinho();

        Integer escolha = 0;

        for (; escolha != 6;) {

            System.out.print("""
                    1. Adicionar livro
                    2. Adicionar DVD
                    3. Adicionar Servico
                    4. Exibir itens do carrinho
                    5. Exibir total de venda
                    6. Fim
                    
                    Escolha uma opção: """);
            escolha = leitorDeInteiros.nextInt();

            System.out.println("\n");
            switch (escolha){
                case 1:
                    Double precoLivro;
                    String nomeLivro;
                    String autor;
                    String isbn;
                    int codigoLivro;

                    System.out.print("Informe o código do livro: ");
                    codigoLivro = leitorDeInteiros.nextInt();

                    System.out.print("Informe o preço do livro: ");
                    precoLivro = leitorDeDouble.nextDouble();

                    System.out.print("Informe o nome do livro: ");
                    nomeLivro = leitorDeString.nextLine();

                    System.out.print("Informe o autor do livro: ");
                    autor = leitorDeString.nextLine();

                    System.out.print("Informe o ISBN do livro: ");
                    isbn = leitorDeString.nextLine();

                    Livro livro = new Livro(codigoLivro, precoLivro,nomeLivro,autor,isbn);
                    carrinho.adicionarVendavel(livro);
                    System.out.println("\n");

                    break;
                case 2:
                    String nomeDVD;
                    String gravadora;
                    Double precoDVD;
                    int codigoDVD;

                    System.out.print("Informe o código do DVD: ");
                    codigoDVD = leitorDeInteiros.nextInt();

                    System.out.print("Informe o preço do DVD: ");
                    precoDVD = leitorDeDouble.nextDouble();

                    System.out.print("Informe o nome do DVD: ");
                    nomeDVD = leitorDeString.nextLine();

                    System.out.print("Informe a gravadora do DVD: ");
                    gravadora = leitorDeString.nextLine();



                    DVD dvd = new DVD(codigoDVD , precoDVD, nomeDVD, gravadora);
                    carrinho.adicionarVendavel(dvd);
                    System.out.println("\n");

                    break;
                case 3:
                    String descricao;
                    int codigo;
                    int quantHoras;
                    Double valorHora;

                    System.out.print("Informe a descrição do serviço: ");
                    descricao = leitorDeString.nextLine();

                    System.out.print("Informe o código do serviço: ");
                    codigo = leitorDeInteiros.nextInt();

                    System.out.print("Informe o código do serviço: ");
                    quantHoras = leitorDeInteiros.nextInt();

                    System.out.print("Informe o código do serviço: ");
                    valorHora = leitorDeDouble.nextDouble();


                    Servico servico = new Servico(descricao, codigo ,quantHoras, valorHora);
                    carrinho.adicionarVendavel(servico);
                    System.out.println("\n");

                    break;
                case 4:
                    carrinho.exibirItensCarrinho();
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.print("Total do carrinho: ");
                    System.out.println(carrinho.calculaTotalVenda());
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("Encerrando programa!");
                    System.out.println("\n");
                    break;

            }

        }
    }
}
