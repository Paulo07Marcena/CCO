package Exercicio01;

import java.util.Scanner;

public class Idade {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.println("Seja bem-vindo(a) a calculadora de dias!");

        System.out.print("Informe quantos anos você tem?\nR: ");
        Integer anos = leitor.nextInt();
        System.out.println("\n");

        System.out.print("Agora informe quandos mesês completos já se passaram do seu ultimo aniversário!\nR: ");
        Integer meses = leitor.nextInt();
        System.out.println("\n");

        System.out.print("Por ultimo informe que dia é hoje\nR: ");
        Integer dias = leitor.nextInt();
        System.out.println("\n");

        Integer diasTotais = (anos * 365) + (meses * 30) + dias;
        System.out.println("Você possui %d dias de vida!".formatted(diasTotais));

    }
}
