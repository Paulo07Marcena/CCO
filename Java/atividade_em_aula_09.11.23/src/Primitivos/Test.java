package Primitivos;

public class Test {

    //private int integerNumber;
    //private double realNumber;
    //private boolean status;

    public static String name;
    public static final String NOME_COMPLETO = "Paulo Reis";

    public static int sum(int number1, int number2){
        return number1 + number2;
    }


    // Static é um atributo de classe -- seta o mesmo valor para todas as suas instancias
    // Static e Final usam o macro case
    // Tipos de variáveis que não são tão utlizadas
    // Big
    // char
    // Long
    // Character
    // String vetor de caracteres
    // Float, semelhante ao Double mas tem uma capacidade menor e precisão inferiror
    // String sempre com aspas duplas ("") pois as simples ('') o Java ler como character
    // String é um objeto com um conjunto de character -- Não exite String primitivo
    // Variáveis primitivas não aceitam valores nulos, possuem um valor default
    //Enum == Objeto constante


    public static String getNome() {
        return name;
    }

    public static void setNome(String nome) {
        Test.name = nome;
    }
}
