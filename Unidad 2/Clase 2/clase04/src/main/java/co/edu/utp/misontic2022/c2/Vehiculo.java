package co.edu.utp.misontic2022.c2;

public class Vehiculo {

    String color;
    Integer numSerie;
   
    // #region Constructor
    public Vehiculo() {
    }

    public Vehiculo(String color, int numSerie) {
        this.color = color;
        this.numSerie = numSerie;
    }
    // #endregion

    //#region Getter and Setter
    public String getColor() {
        return this.color;
    }
    
    public Integer getNumSerie() {
        return this.numSerie;
    }
    //#endregion

}
