package co.edu.utp.misiontic2022.c2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import co.edu.utp.misiontic2022.c2.animales.Cat;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // var persona = new Persona();
        Cat cat = new Cat();
        cat.makeSound();

        // Lista de enteros.
        // Puede haber enteros repetidos en la lista:
        List<Integer> listaDeManzanas;

        // Conjunto de enteros.
        // No puede haber enteros repetidos:
        Set<Integer> conjuntoDeNaranjas;

        // Un mapa que asocia a una cadena un entero,
        // como en una lista de notas de un examen:
        // [("Juan Goytisolo", 9.5),
        // ("Pablo Iglesias", 5.0), ...]
        Map<String, Integer> mapaDeNotas;

        // #region lista
        List<Integer> listaEnteros = new ArrayList<>();
        // var listaEnteros = new ArrayList<Integer>();

        listaEnteros.add(4);
        listaEnteros.add(5);
        listaEnteros.add(7);
        listaEnteros.add(2, 6);

        listaEnteros.size(); // 4

        listaEnteros.contains(7); // 'true'
        listaEnteros.contains(8); // 'false'

        listaEnteros.indexOf(6); // 2
        listaEnteros.indexOf(10); // -1

        // var iterador = listaEnteros.iterator();

        Iterator<Integer> iterador = listaEnteros.iterator();
        while (iterador.hasNext()) {
            Integer entero = iterador.next();
            System.out.println(entero);

        }

        System.out.println("-----");
        for (Integer entero_1 : listaEnteros) {
            //System.out.println(entero_1);
        }
        System.out.println("-----");

        listaEnteros.forEach((entero) -> {
            //System.out.println(entero);
        });
        listaEnteros.forEach(System.out::println);

        System.out.println("-----");

        listaEnteros.stream().forEach((entero) -> {
            //System.out.println(entero);
        });
        listaEnteros.stream().forEach(System.out::println);
        // #endregion

        // #region conjunto
        Set<Integer> conjuntoEnteros = new HashSet<>();

        conjuntoEnteros.add(4);
        conjuntoEnteros.add(5);
        conjuntoEnteros.add(7);
        conjuntoEnteros.add(4);

        System.out.println("++++++");
        for (Integer entero: conjuntoEnteros) {
            System.out.println(entero);
            }


        // #endregion
        
        //#region Maps


        //#region
    }
}