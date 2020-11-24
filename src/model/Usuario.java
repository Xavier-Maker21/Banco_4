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

/*CREATE TABLE usuario(
N_Cuenta int PRIMARY KEY,
Rut varchar(13) UNIQUE,
Nombre varchar(60),
Apellido_Paterno varchar(50),
Apellido_Materno varchar(50),
Correo varchar(30),
Clave int(4),
Saldo int
);*/
public class Usuario {

    private int n_cuenta, saldo;
    private String rut, nombre, apellido_paterno, apellido_materno, correo, clave;
    private boolean estado;

    public Usuario() {
    }

    public Usuario(int n_cuenta, int saldo, String rut, String nombre, String apellido_paterno, String apellido_materno, String correo, String clave, boolean estado) {
        this.n_cuenta = n_cuenta;
        this.saldo = saldo;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.correo = correo;
        this.clave = clave;
        this.estado = estado;
    }

    public int getN_cuenta() {
        return n_cuenta;
    }

    public void setN_cuenta(int n_cuenta) {
        this.n_cuenta = n_cuenta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
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

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    

}
