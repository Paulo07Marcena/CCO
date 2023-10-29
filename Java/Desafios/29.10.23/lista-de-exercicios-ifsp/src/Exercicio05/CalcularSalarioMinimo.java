package Exercicio05;

import java.util.Scanner;

public class CalcularSalarioMinimo {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe o seu salário:\nSalário: ");
        Double salario = leitor.nextDouble();

        System.out.println("Você recebe aproximadamente %.0f salários minímos".formatted(salario/788.00));
    }
}
