package co.edu.utp.misiontic2022.c2;

public class MiPrimerClase {

    private static final double PI = 3.14;
    private Integer contador = 0;

    public void incrementarContador() {
        contador += contador;
    }

    public Integer getContador(){
        return contador;
    }

    public void setContador(Integer valor){
        contador = valor;
    }
}
