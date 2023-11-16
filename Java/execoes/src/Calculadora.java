public class Calculadora {

    private int n1;
    private int n2;

    public Calculadora(int n1, int n2) {
        this.n1 = n1;
        this.n2 = n2;
    }


    public Integer dividir(Integer n1, Integer n2){
        try{
        return (n1 / n2);
        } catch (ArithmeticException e ){
            return 0;
        }
    }
}
