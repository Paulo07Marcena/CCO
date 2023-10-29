package Exercicio02;

public class MediaAritmetica {

    public static void main(String[] args) {

        Double m1 = (8.9 + 7)/2;
        Double m2 = (4.5+6)/2;

        System.out.println("A média entre 8,9 e 7 é igual à: %.2f".formatted(m1));

        System.out.println("A média entre 4,5 e 6 é igual à: %.2f".formatted(m2));

        System.out.println("A soma das médias é igual à: %.2f".formatted(m1 + m2));

        System.out.println("A soma das médias é igual à: %.2f".formatted((m1 + m2)/2));
    }
}
