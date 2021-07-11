package co.edu.utp.misiontic2022.c2;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        MiPrimerClase mpc = new MiPrimerClase();

        System.out.println("Valor del contador: " + mpc.getContador());
        mpc.setContador(10);

        System.out.println("Valor del contador: " + mpc.getContador());


    }
}
