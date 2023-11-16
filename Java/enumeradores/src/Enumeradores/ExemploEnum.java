package Enumeradores;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ExemploEnum {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);


        String nomeEnumerador = DiasDaSemanaEnum.QUINTA.name();

        DiasDaSemanaEnum[] valoresPossiveis = DiasDaSemanaEnum.values();

        System.out.println("Escolha uma das possibilidades abaixo: ");

        for ( DiasDaSemanaEnum enumerador: valoresPossiveis) {
            System.out.println(enumerador);
            System.out.println(enumerador.getDescricao());
        }

        System.out.print("Escolha: ");

        String escolha = in.nextLine();

        DiasDaSemanaEnum enumEncontrado = DiasDaSemanaEnum.valueOf(escolha);

        System.out.println("\n");
        System.out.print("Você escolheu o enum: ");
        System.out.println(enumEncontrado);


        System.out.println(DiasDaSemanaEnum.QUINTA);
        System.out.println(nomeEnumerador);
    }
}
