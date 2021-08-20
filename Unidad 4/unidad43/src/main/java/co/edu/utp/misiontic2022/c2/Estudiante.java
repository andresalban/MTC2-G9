package co.edu.utp.misiontic2022.c2;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="Estudiante")
public class Estudiante  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    @Column(name ="id")
    private Integer id;
    
    @Column(name ="nombres")
    private String nombres;
    
    @Column(name ="apellidos")
    private String apellidos;
    
    @Column(name ="telefono")
    private String telefono;

    //region Constructores
    public Estudiante(){}

//endregion

    //region Getter & Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
     //endregion

}
