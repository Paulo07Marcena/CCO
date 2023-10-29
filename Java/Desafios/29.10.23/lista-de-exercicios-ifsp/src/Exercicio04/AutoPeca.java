package Exercicio04;

import java.util.Scanner;

public class AutoPeca {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Scanner leitor02 = new Scanner(System.in);
        Scanner leitor03 = new Scanner(System.in);

        System.out.print("Informe a porcentagem do IPI:\nR:");
        Double porcetagem = leitor.nextDouble();

        System.out.print("Digite o código da 1° peça: \nCódigo: ");
        leitor02.nextLine();

        System.out.print("Digite o valor unitário da 1° peça: \nValor: ");
        Double valorUnitario = leitor.nextDouble();

        System.out.print("Agora digite a quantidade:\nQuantidade: ");
        Integer qtdPeca01 = leitor03.nextInt();

        System.out.println("\n\n");

        System.out.print("Digite o código da 2° peça: \nCódigo: ");
        leitor02.nextLine();

        System.out.print("Digite o valor unitário da 2° peça: \nValor: ");
        Double valorUnitario02 = leitor.nextDouble();

        System.out.print("Agora digite a quantidade:\nQuantidade: ");
        Integer qtdPeca02 = leitor03.nextInt();

        System.out.println("\n\n");

        Double total = (valorUnitario * qtdPeca01 + valorUnitario02 * qtdPeca02) * (porcetagem/100 + 1);

        System.out.println("Total gasto: %.2f".formatted(total));


    }
}
