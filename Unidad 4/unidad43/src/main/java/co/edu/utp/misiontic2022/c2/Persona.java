package co.edu.utp.misiontic2022.c2;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Persona")
public class Persona implements Serializable {

    @Id
    private String nombre;
    private Integer edad;

    //region Construtores
    public Persona() {
        // Constructor obligatorio para JPA
    }

    public Persona(String nombre,Integer edad){
        this.nombre=nombre;
        this.edad = edad;
    }
    //endregion

    //region Getters & Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
    //endregion


    @Override
    public String toString() {
        return "" + nombre + "," + edad;
    }
}
