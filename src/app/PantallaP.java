/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import bd.DAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Correo;

import model.Movimiento;
import model.Usuario;

/**
 *
 * @author Javier
 */
public class PantallaP extends javax.swing.JFrame {

    public String rutUsuario;
    DAO oDao;
    //public Usuario rut;

    DefaultTableModel oModeloTabla = new DefaultTableModel();
    //TableCellRenderer oTableCellRenderer=new DefaultTableCellRenderer();

    /**
     * Creates new form PantallaP
     *
     * @param rutString
     */
    public PantallaP(String rutString) {
        initComponents();
        setTitle("BancoFunaoApp");
        this.setLocationRelativeTo(null);
        cerrarSesion();
        //Agregar Columnas

        oModeloTabla.addColumn("Fecha");
        oModeloTabla.addColumn("Cuenta Origen");
        oModeloTabla.addColumn("Cuenta Destino");
        oModeloTabla.addColumn("Descripcion");
        oModeloTabla.addColumn("Monto");

        //Agregar columnas a la tabla
        tblMovimientos.setModel(oModeloTabla);

        //oTableCellRenderer.getTableCellRendererComponent(tblMovimientos, this, rootPaneCheckingEnabled, rootPaneCheckingEnabled, ERROR, NORMAL)
        //Cargar datos usuario
        System.out.println(rutString);
        getUsuario(rutString);

        rutUsuario = rutString;

        //Cargar datos en la tabla
        //cargarTabla(Integer.parseInt(txtN_dao.getText()));
        cargarTabla();
//        int n=Integer.parseInt(txtN_dao.getText());
//        int nu=n%30;
//        System.out.println(nu);
        /*
        DELIMITER //
        CREATE PROCEDURE transferencia(IN n_cuenta_ori int, IN  n_cuenta_des int, IN montoT int)
        BEGIN

            INSERT INTO movimiento VALUES(null,"Transferencia a 3eros",n_cuenta_ori,n_cuenta_des,montoT);

            UPDATE usuario
            SET saldo=saldo-montoT
            WHERE n_cuenta=n_cuenta_ori;

            UPDATE usuario
            SET saldo=saldo+monto
            WHERE n_cuenta=n_cuenta_des;
        END//
        DELIMITER ;
    
    
         */

    }

    private PantallaP() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        btnTransferir = new javax.swing.JButton();
        btnCambioClave = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMovimientos = new javax.swing.JTable();
        txtN_Cuenta = new javax.swing.JTextField();
        txtSaldoCuenta = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnTransferir.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnTransferir.setText("Transferencia");
        btnTransferir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferirActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnTransferir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 205, -1, -1));

        btnCambioClave.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnCambioClave.setText("Cambiar Clave");
        btnCambioClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioClaveActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnCambioClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 205, -1, -1));

        tblMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblMovimientos.setEnabled(false);
        jScrollPane1.setViewportView(tblMovimientos);

        panelPrincipal.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 102, 541, 97));

        txtN_Cuenta.setEditable(false);
        txtN_Cuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelPrincipal.add(txtN_Cuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 11, 62, -1));

        txtSaldoCuenta.setEditable(false);
        txtSaldoCuenta.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtSaldoCuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        panelPrincipal.add(txtSaldoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 49, 170, 42));

        btnCerrar.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnCerrar.setText("Cerrar Sesión");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 205, -1, -1));

        btnEstado.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        btnEstado.setText("Desactivar Cuenta");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        panelPrincipal.add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 205, -1, -1));

        txtNombre.setEditable(false);
        panelPrincipal.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 141, -1));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel1.setText("Bienvenido/a:");
        panelPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 14, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Cuáles-son-los-colores-pasteles-300x300 (1).jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        panelPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 260));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 258, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTransferirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferirActionPerformed
        // TODO add your handling code here:
        Transferir oTransferir = new Transferir(Integer.parseInt(txtN_Cuenta.getText()));
        oTransferir.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferirActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        Login oLogin = new Login();
        oLogin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnCambioClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioClaveActionPerformed
        // TODO add your handling code here:

        CambioClave oCambioClave = new CambioClave(rutUsuario);
        oCambioClave.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCambioClaveActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        try {
            // TODO add your handling code here:
            oDao = new DAO();
            Usuario oUsuario=oDao.getUserRegisted(Integer.parseInt(txtN_Cuenta.getText()));
            //JOptionPane.showConfirmDialog(null, "¿Estas Seguro?","Alerta!",JOptionPane.YES_NO_OPTION);
            int res = JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            //System.out.println(JOptionPane.showConfirmDialog(null, "¿Estas Seguro?", "Alerta!", JOptionPane.YES_NO_OPTION));
            
            if (res == 0) {
                String res2=JOptionPane.showInputDialog(null,"¿Dejanos el porque desacctivas tu cuenta","Alerta!");
                Correo oCorreo=new Correo();
                oCorreo.enviarCorreo(oUsuario.getCorreo(), "Desactivacion de cuenta", ""
                        + "Hemos notado que ha desactivado su cuenta ya que "+res2+
                        ". Para poder activarla otra vez, dirijase a servicio al cliente");
                oDao.estadoCuenta(Integer.parseInt(txtN_Cuenta.getText()), 0);
                JOptionPane.showMessageDialog(rootPane, "Su cuenta ha sido desactivada,\n para activarla acuda a servicio al cliente");
                Login oLogin = new Login();
                oLogin.setVisible(true);
                this.dispose();
            } else {

            }
            /*
            CREATE VIEW vistaSolicitud AS SELECT trabajador.Rut, solicitud.Detalle, Motivo.Detalle AS 'Motivo', solicitud.N_cuenta, usuario.Nombre
            FROM solicitud
            INNER JOIN trabajador ON trabajador.Rut=solicitud.Rut
            INNER JOIN Motivo ON Motivo.Id=solicitud.Motivo
            INNER JOIN usuario ON usuario.N_Cuenta=solicitud.N_cuenta
             */

        } catch (SQLException ex) {
            Logger.getLogger(PantallaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PantallaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new PantallaP().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambioClave;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEstado;
    private javax.swing.JButton btnTransferir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel panelPrincipal;
    private javax.swing.JTable tblMovimientos;
    public javax.swing.JTextField txtN_Cuenta;
    private javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtSaldoCuenta;
    // End of variables declaration//GEN-END:variables

    private void getUsuario(String r_Usuario) {

        try {
            oDao = new DAO();
            Usuario oUsuario;
            oUsuario = oDao.getUserRegisted(r_Usuario);
            if (oUsuario != null) {
                txtNombre.setText(oUsuario.getNombre());
                txtSaldoCuenta.setText(String.valueOf(oUsuario.getSaldo()));
                txtN_Cuenta.setText(String.valueOf(oUsuario.getN_cuenta()));
                System.out.println(oUsuario.getClave());
            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallaP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void cargarTabla() {
        oModeloTabla.setRowCount(0);

        try {
            oDao = new DAO();
            //Movimiento oMovimiento=oDao.hayMovimientos();
            //Movimiento[] movimientos=new Movimiento[oModeloTabla.getColumnCount()];
            String[] movimientos = new String[oModeloTabla.getColumnCount()];
            for (Movimiento oMovimiento : oDao.mostrarMovimiento()) {

                if (txtN_Cuenta.getText().equalsIgnoreCase(String.valueOf(oMovimiento.getN_CuentaU_Ori()))) {
                    movimientos[0] = "" + oMovimiento.getFecha();
                    movimientos[1] = "" + oMovimiento.getN_CuentaU_Ori();
                    movimientos[2] = "" + oMovimiento.getN_CuentaU_Des();
                    movimientos[3] = oMovimiento.getDescripcion();
                    movimientos[4] = "-" + oMovimiento.getMonto();
                    oModeloTabla.addRow(movimientos);
                } else if (txtN_Cuenta.getText().equalsIgnoreCase(String.valueOf(oMovimiento.getN_CuentaU_Des()))) {
                    movimientos[0] = "" + oMovimiento.getFecha();
                    movimientos[1] = "" + oMovimiento.getN_CuentaU_Ori();
                    movimientos[2] = "" + oMovimiento.getN_CuentaU_Des();
                    movimientos[3] = oMovimiento.getDescripcion();
                    movimientos[4] = "+" + oMovimiento.getMonto();
                    oModeloTabla.addRow(movimientos);
                } else {
                    System.out.println("No ha realizado ninguna transaccion");
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(PantallaP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void cerrarSesion(){
        TimerTask oTimerTask=new TimerTask() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(rootPane, 
                        "Hemos cerrado su sesion por inactividad",
                        "Cierre Sesión",
                        JOptionPane.WARNING_MESSAGE);
                Login oLogin=new Login();
                oLogin.setVisible(true);
                dispose();
            }
        };
        Timer oTimer=new Timer();
        oTimer.scheduleAtFixedRate(oTimerTask, 10000, 1000);
    }
}