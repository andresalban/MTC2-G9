package co.edu.utp.misontic2022.c2;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        MiPrimerClase mpc = new MiPrimerClase();
        MiPrimerClase mpc1 = new MiPrimerClase(50);

        System.out.println("valor del contador: " + mpc.getContador());
        System.out.println("valor del contador: " + mpc1.getContador());

        mpc1.setContador(100);
        System.out.println("Valor del contador: " +mpc1.getContador());

        Vehiculo vehiculo = new Vehiculo();

        Coche coche = new Coche("Rojo",111,100);
        System.out.println("Color:"+coche.getColor()+" - Numero de serie:"+coche.getNumSerie()+" - Cilindrada:"+coche.getCilindrada());

        

    }
}
