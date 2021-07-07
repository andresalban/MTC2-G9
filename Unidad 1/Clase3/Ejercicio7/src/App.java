import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese un numero entero: ");
        var numero = sc.nextInt();
        System.out.println(par_impar(numero));

    }

    public static String par_impar(int num) {

        return (num % 2 == 0 ? num + " Es par" : num + " Es impar");
    }
}