import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// import java.io.*;

public class App {

    /**
     * Sintaxis del lenguaje de Java.
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        // int i = 1;

        // Es un comentario para una línea de código
        /*
            este es un comentario para un bloque del código
            Comentar varias líneas de codigo.
        */

        int x = 214748664;
        String nombre = "Angel";
        double a = 3.4;
        boolean bNuevo = true;
        int[] datos;

        var ejemplo = "ejemplo";


        /*
        System.out.println("Hola, \t mundo");
        System.out.println("Hola, \b mundo");
        System.out.println("Hola, \n mundo");
        System.out.println("Hola, \r mundo");
        System.out.println("Hola, \f mundo");
        System.out.println("\'Hola, mundo\'");
        */
        var anho_nacimiento = 45;
        // var public = 1

        Scanner sc = new Scanner(System.in);
        System.out.println("Por favor ingrese su nombre");
        String nombreEntrada = sc.nextLine();
        System.out.println("Su nombre es " + nombreEntrada);


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese su nombre ");
        String nombre_br = br.readLine();
        System.out.println("Su nombre es : " + nombre_br);

    }
}