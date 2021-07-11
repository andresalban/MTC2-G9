package co.edu.utp.misontic2022.c2;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        MiPrimeraClase mpc=new MiPrimeraClase();
        MiPrimeraClase mpc_1=new  MiPrimeraClase(50);
        System.out.println("valor del contador: " + mpc.getContador());
        System.out.println("valor del contador: " + mpc_1.getContador());
        ;

        Vehiculo vehiculo = new Vehiculo();
        Coche coche = new Coche();


    }
}
