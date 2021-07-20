package co.edu.utp.misontic2022.c2;

import co.edu.utp.misontic2022.c2.enumeraciones.Color;

public class Coche extends Vehiculo {
    private Integer numRuedas;

    public Coche(){ 
        super();       
    }

    public Coche(Color color,Integer numSerie, Integer numRuedas){ 
        super(color,numSerie);
        this.numRuedas = numRuedas;
    }

    public Integer getNumRuedas(){
        return numRuedas;
    }

    public void setNumRuedas(Integer numRuedas){
        this.numRuedas = numRuedas;
    }

}
