import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su nombre : ");
        String nom = sc.nextLine();
        */


        // Condiciones con IF
        if ("7"  == "7") {
            System.out.println("Es correcto!");
        } else {
            System.out.println("No es correcto"); 
        }
        
        if ("a" != "a") {
            System.out.println("Es correcto!");
        } else {
            System.out.println("No es correcto");
        }

        // Condiciones con Switch

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese su valor : ");
        int valor_entero = sc.nextInt();
        String valor_texto = sc.nextLine();
        String respuesta = "";

        switch (valor_entero){
            case 1:
                // operacion
                respuesta = "caso 1 correcto";
                break;
            case 2:
                // operacion
                respuesta = "caso 2 correcto";
                break;
            default:
                // operacion
                respuesta = "ninguna de las anteriores";
        }

        System.out.println(respuesta);


        /*
            if (1 == 1){
                System.out.println("Verdadero");
            }
        */

    }
}