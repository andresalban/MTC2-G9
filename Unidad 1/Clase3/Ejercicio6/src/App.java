import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        Scanner sc = new Scanner(System.in);
        //Escribe un programa Java que lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número
        System.out.println("Ingrese un numero");
        var numero = sc.nextInt();
        System.out.println("el doble " + numero + " es: " + numeroDoble(numero));
        System.out.println("el triple " + numero + " es: " + numeroTriple(numero));

        // Escribe un programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit. La fórmula es: F = 32 + ( 9 * C / 5)
        System.out.println("Ingrese una cantidad de grados centigrados");
        var grados = sc.nextFloat();
        System.out.println(centigrados_Fahrenheit(grados));

    
        
    }
    //funcion para calcular el doble del numero
    public static int numeroDoble(int num){
        return num*2;
    }
    //funcion para calcular el triple del numero
    public static int numeroTriple(int num){
        return num*3;
    }
    

    // funcion para convertir de C° a F°
    public static float centigrados_Fahrenheit(float grados_c) {
        return (32 + (9 * grados_c / 5));
    }



}
