package co.edu.utp.misiontic2022.c2;

public class MiPrimerClase {

    private static final double PI = 3.1416;
    private Integer contador = 0;

    public void incrementarContador(Integer cantidad) {
        contador += cantidad;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer valor) {
        contador = valor;
    }
}
