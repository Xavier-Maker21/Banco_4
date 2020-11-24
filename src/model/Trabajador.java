/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Javier
 */

/*
CREATE TABLE trabajador(
Rut varchar(13) PRIMARY KEY,
Nombre varchar(60),
Apellidos varchar(50),
Cargo varchar(30),
Seccion varchar(30),
Clave varchar(10)
);
*/

public class Trabajador {

    private String rut, nombre, apellido, cargo, clave;

    public Trabajador() {
    }

    public Trabajador(String rut, String nombre, String apellido, String cargo, String clave) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.clave = clave;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
}
