package Exercicio06;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Numeros {

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe um número: ");
        Integer numero = leitor.nextInt();
        System.out.println("Seu antecessor é: " + (numero - 1));
        System.out.println("Seu sucessor é: " + (numero + 1));
    }
}
