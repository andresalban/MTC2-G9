package co.edu.utp.misontic2022.c2;

import co.edu.utp.misontic2022.c2.enumeraciones.Color;

public class Vehiculo {

    private Color color;
    private Integer numSerie=0;
   
    // #region Constructor
    public Vehiculo() {
    }

    public Vehiculo(Color color, Integer numSerie) {
        this.color = color;
        this.numSerie = numSerie;
    }
    // #endregion

    //#region Getter and Setter
    public Color getColor() {
        return this.color;
    }
    public void setColor(Color color) {
        this.color = color;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }
    
    public Integer getNumSerie() {
        return this.numSerie;
    }
    //#endregion

}
