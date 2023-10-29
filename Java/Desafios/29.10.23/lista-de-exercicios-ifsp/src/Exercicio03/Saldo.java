package Exercicio03;

import java.util.Scanner;

public class Saldo {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe um valor:\nR: ");
        Double valor = leitor.nextDouble();
        System.out.println("Valor com 1% de reajuste: " + valor * 1.01);
    }

}
