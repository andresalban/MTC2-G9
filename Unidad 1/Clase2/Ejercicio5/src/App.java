import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        var sc = new Scanner(System.in);
        System.out.println("Introduzca un numero: ");
        var numero= sc.nextInt();
        var digito= numeroDigito(numero);
        System.out.println("el numero tiene "+ digito+ " 66cifras");


    }

    public static int numeroDigito(int num) {
        var cifras = 0;
        while (num != 0) {
            num /= 10;
            cifras++;
        }
        return cifras;
    }
}
