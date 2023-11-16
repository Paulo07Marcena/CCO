import java.io.FileInputStream;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        Existem dois tipos de anormalidades no Java -> Throwable
//        Execption , Error

//        Top 3 Excepitons:
//        NullPointException
//        IndexOutBounds
//        fileNotFound

//        Top 3 Errors:
//        StackOverFlowError
//        2°
//        3°

        Scanner leitor = new Scanner(System.in);

        try {
            System.out.print("Digite um número: ");
            Integer number = leitor.nextInt();

            if (number < 0 || number > 10){
                throw new NumeroForaDoIntervaloException("São aceitos apenas entre 0 e 10!");
            }

            System.out.print("Digite outro número: ");
            Integer number2 = leitor.nextInt();

            if (number2 < 0 || number2 > 100){
                throw new NumeroForaDoIntervaloException("São aceitos apenas entre 0 e 100!");

            }

            Integer divisao = number / number2;

            System.out.println("Divisão: %d".formatted(divisao));

        } catch (InputMismatchException | NumeroForaDoIntervaloException e){
            System.out.println("Número inválido");

            if (e.getMessage() != null){

                System.out.println(e.getMessage());
            }
        } catch (ArithmeticException e){
            System.out.println("Operação invalida, divisão por 0 não existe!");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado!");
        }


//        Checked exceptions e Unchecked

//        InputStream input = new FileInputStream("Arquivo.txt");

    }
}