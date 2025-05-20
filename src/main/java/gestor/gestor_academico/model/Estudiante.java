package gestor.gestor_academico.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cedula")
    private String cedula;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "cantidadFaltas")
    private Integer cantidadFaltas =0;


    // Relación inversa opcional con Nota
    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Nota> notas;

    // Relación inversa opcional con Matricula
    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Matricula> matriculas;


    //Constructor vacio
    public Estudiante(){

    }

    //Getter y Setters

    public Long getId() {
        return id;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public Integer getCantidadFaltas(){
        return cantidadFaltas;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void setCantidadFaltas(Integer cantidadFaltas) {
        this.cantidadFaltas = cantidadFaltas;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

}
