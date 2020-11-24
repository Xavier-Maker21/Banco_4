/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Javier
 */
/*
CREATE TABLE movimiento(
Id int PRIMARY KEY AUTO_INCREMENT,
Descripcion varchar(20),
N_CuentaU_Ori int,
N_CuentaU_Des int,
Fecha DATE,
Monto int,
FOREIGN KEY (N_CuentaU_Ori) REFERENCES usuario(N_Cuenta),
FOREIGN KEY (N_CuentaU_Des) REFERENCES usuario(N_Cuenta)
);
 */
public class Movimiento {

    private int id, n_CuentaU_Ori, n_CuentaU_Des, monto;
    private Date fecha;
    private String descripcion;

    public Movimiento() {
    }

    public Movimiento(int id, int n_CuentaU_Ori, int n_CuentaU_Des, int monto, Date fecha, String descripcion) {
        this.id = id;
        this.n_CuentaU_Ori = n_CuentaU_Ori;
        this.n_CuentaU_Des = n_CuentaU_Des;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN_CuentaU_Ori() {
        return n_CuentaU_Ori;
    }

    public void setN_CuentaU_Ori(int n_CuentaU_Ori) {
        this.n_CuentaU_Ori = n_CuentaU_Ori;
    }

    public int getN_CuentaU_Des() {
        return n_CuentaU_Des;
    }

    public void setN_CuentaU_Des(int n_CuentaU_Des) {
        this.n_CuentaU_Des = n_CuentaU_Des;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
