package co.edu.utp.misontic2022.c2;

public class Coche extends Vehiculo {

    private Integer cilindrada;


    //#region Constructor
    public Coche(){}

    public Coche(String color,Integer numSerie,Integer cilindrada) {
        super(color,numSerie);
        this.cilindrada=cilindrada;
    }
    //#endregion


    //#region Getter and Setter
    public Integer getCilindrada() {
        return this.cilindrada;
    }
   
    public void setCilindrada(Integer cilindrada) {
        this.cilindrada = cilindrada;
    }
    //#endregion
    
}


