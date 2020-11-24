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
CREATE TABLE Solicitud(
    Id int PRIMARY KEY AUTO_INCREMENT,
    Motivo int,
    Detalle text,
    N_cuenta int,
    Rut varchar(13),
    FOREIGN KEY (N_cuenta) REFERENCES usuario(N_Cuenta),
    FOREIGN KEY (Rut) REFERENCES trabajador(Rut),
    FOREIGN KEY (Motivo) REFERENCES motivo(Id)
)
*/

public class Solicitud {
    
    private int id, n_CuentaU, motivo;
    private String descripcion, rut_Trabajador;

    public Solicitud() {
    }

    public Solicitud(int id, int n_CuentaU, int motivo, String descripcion, String rut_Trabajador) {
        this.id = id;
        this.n_CuentaU = n_CuentaU;
        this.motivo = motivo;
        this.descripcion = descripcion;
        this.rut_Trabajador = rut_Trabajador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getN_CuentaU() {
        return n_CuentaU;
    }

    public void setN_CuentaU(int n_CuentaU) {
        this.n_CuentaU = n_CuentaU;
    }

    public int getMotivo() {
        return motivo;
    }

    public void setMotivo(int motivo) {
        this.motivo = motivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRut_Trabajador() {
        return rut_Trabajador;
    }

    public void setRut_Trabajador(String rut_Trabajador) {
        this.rut_Trabajador = rut_Trabajador;
    }

    

        
    
}
