package co.edu.utp.misontic2022.c2;

import co.edu.utp.misontic2022.c2.enumeraciones.Color;
import co.edu.utp.misontic2022.c2.enumeraciones.DiaSemana;

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
        System.out.println("Valor del contador: " + mpc1.getContador());

        //Vehiculo vehiculo = new Vehiculo();

        Coche coche = new Coche();
        Coche coche2 = new Coche(Color.Azul,121212,4);
        
        coche.setColor(Color.Rojo);
        System.out.println("Color del coche es "+ coche.getColor());
        System.out.println("Color del coche es "+ coche2.getColor());


        ImpresoraTinta impresoraTinta = new ImpresoraTinta(60);
        impresoraTinta.imprimir("Copias");


        //Enumeradores
        System.out.println(DiaSemana.Martes);

       
        int[] pEntero;
        pEntero = new int[5];
        int[] intArrat={1,2,3,4,5,6,7,8,9};

        int[] miArray = new int[2];
        miArray[0]=1;
        miArray[1]=2;

       for(int i=0 ; i< miArray.length;i++){
           System.out.println("Elemento en el indice"+i+" : "+miArray[i]);
       }

       Coche[] cocheArray = new Coche[2];
       cocheArray[0]= new Coche(Color.Blanco, 123456, 3);
       cocheArray[1]= new Coche(Color.Rojo, 1226, 6);

       System.out.println("++++++++++");

       for (int i = 0; i < cocheArray.length; i++) {
           System.out.println("Numero de serie del coche es: "+cocheArray[i].getNumSerie()+" tiene "+cocheArray[i].getNumRuedas()+" rueda y su color es "+cocheArray[i].getColor());
       }

    }
}
