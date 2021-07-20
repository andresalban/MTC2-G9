package co.edu.utp.misontic2022.c2;

public class ImpresoraTinta implements Impresora {

    private int velocidad;

    public ImpresoraTinta(int velocidad) {
        this.velocidad = velocidad;
    }

    @Override
    public void imprimir(String texto) {
        // TODO Auto-generated method stub
        System.out.println("la impresora de tinta imprime: " + texto);
    }

    @Override
    public int getVelocidad() {
        // TODO Auto-generated method stub
        return velocidad;
    }

}