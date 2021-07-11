package co.edu.utp.misontic2022.c2;

public class Vehiculo {

    String color;
    int numSerie;


    public Vehiculo(){}
    
    public Vehiculo (String color,int numSerie){
        this.color = color;
        this.numSerie = numSerie;
    }

    public Integer getNumSerie(){
        return this.numSerie;

    }

    
}
