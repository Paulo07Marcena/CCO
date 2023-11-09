package Primitivos;

public class Main {

    public static void main(String[] args) {

        Test test = new Test();
        Test test1 = new Test();

        test1.setNome("Caio");
        test.setNome("Paulo");

        System.out.println(test.getNome());
        System.out.println(test1.getNome());
        System.out.println(Test.NOME_COMPLETO);

        int result = Test.sum(1,6);

        System.out.println(result);
        System.out.println(DaysOfWeek.MONDAY);

    }

}
