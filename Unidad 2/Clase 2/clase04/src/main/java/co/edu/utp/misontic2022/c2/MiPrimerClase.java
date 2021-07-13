package co.edu.utp.misontic2022.c2;

import javax.swing.plaf.synth.Region;

public class MiPrimerClase {

    private Integer contador;

    //#region Constructor
    public MiPrimerClase() {
        this.contador = 0;
    }

    public MiPrimerClase(int contador) {
        this.contador = contador;
    }
    //#endregion

    //#region Getter and Setter
    public Integer getContador() {
        return this.contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    //#endregion
}
