/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Equipos;

import proyectoesport_moh.Controladora;
import Exceptions.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MIGUEL
 */
public class VEditarEquipos extends javax.swing.JFrame {

    private final String tipoVentana;

    /**
     * Creates new form VAltaAdmin
     */
    public VEditarEquipos() {
        initComponents();
        this.tipoVentana = "VEditarEquipos";
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configPredeterminadaVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jBeditar = new javax.swing.JButton();
        jTnombre = new javax.swing.JTextField();
        jTanioFundacion = new javax.swing.JTextField();
        jTciudad = new javax.swing.JTextField();
        jBconsultar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTestadio = new javax.swing.JTextField();
        jTpresupuesto = new javax.swing.JTextField();
        jBreset = new javax.swing.JButton();
        jBretroceder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 24)); // NOI18N
        jLabel1.setText("EDITAR EQUIPOS");

        jLabel2.setText("Nombre");

        jLabel3.setText("Año de su Fundación");

        jLabel4.setText("Ciudad");

        jBeditar.setBackground(new java.awt.Color(153, 0, 0));
        jBeditar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBeditar.setForeground(new java.awt.Color(255, 255, 255));
        jBeditar.setText("EDITAR");
        jBeditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBeditarActionPerformed(evt);
            }
        });

        jBconsultar.setBackground(new java.awt.Color(0, 153, 51));
        jBconsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBconsultar.setForeground(new java.awt.Color(255, 255, 255));
        jBconsultar.setText("CONSULTAR");
        jBconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBconsultarActionPerformed(evt);
            }
        });

        jLabel5.setText("Nombre de su Estadio");

        jLabel6.setText("Presupuesto");

        jBreset.setBackground(new java.awt.Color(0, 0, 153));
        jBreset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBreset.setForeground(new java.awt.Color(255, 255, 255));
        jBreset.setText("RESET");
        jBreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBresetActionPerformed(evt);
            }
        });

        jBretroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/retroceder.png"))); // NOI18N
        jBretroceder.setBorder(null);
        jBretroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBretrocederActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBretroceder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBreset)
                .addGap(173, 173, 173))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBconsultar)
                                .addGap(70, 70, 70)
                                .addComponent(jBeditar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTnombre)
                                    .addComponent(jTciudad)
                                    .addComponent(jTanioFundacion)
                                    .addComponent(jTestadio)
                                    .addComponent(jTpresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel1)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTanioFundacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addComponent(jTciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTestadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTpresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBretroceder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBconsultar)
                            .addComponent(jBeditar))
                        .addGap(18, 18, 18)
                        .addComponent(jBreset)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBeditarActionPerformed
    // ACTION BOTON EDITAR
        try {
            if (jTciudad.getText().isEmpty() | jTestadio.getText().isEmpty()) {
                throw new DuenioPassVacia();
            } else {
                Controladora.pedirActualizarEquipo(jTnombre.getText(),jTciudad.getText(), jTestadio.getText());
                JOptionPane.showMessageDialog(this, "El Equipo ha sido "
                        + "\neditado correctamente");
                resetearCamposParaConsultarDeNuevo();
            }
        } catch (DuenioPassVacia DNV) {
            JOptionPane.showMessageDialog(this, DNV.getMensaje());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
        }
    }//GEN-LAST:event_jBeditarActionPerformed

    private void jBconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconsultarActionPerformed
        // ACTION PARA CONSULTAR EL EQUIPO EN LA BD
        try {
            if (jTnombre.getText().isEmpty()) {
                throw new CampoDniVacio();
            } else {
                Controladora.localizarEquipoEnBD(tipoVentana, jTnombre.getText());
            }
        } catch (CampoDniVacio CDV) {
            JOptionPane.showMessageDialog(this, CDV.getMensaje());
        } catch (EquipoNoExiste ENE) {
            JOptionPane.showMessageDialog(this, ENE.getMensaje());
        } catch (DuenioCRUDError ECRUDE) {
            JOptionPane.showMessageDialog(this, ECRUDE.getMensaje());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
        }

    }//GEN-LAST:event_jBconsultarActionPerformed

    private void jBretrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBretrocederActionPerformed
        // ACTION BOTON RETROCEDER      
        try {
            Controladora.abreTipoVentanas(tipoVentana);
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception E) {
            Logger.getLogger(VPanelCrudEquipos.class.getName()).log(Level.SEVERE, null, E);
        }
    }//GEN-LAST:event_jBretrocederActionPerformed

    private void jBresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBresetActionPerformed
        // ACTION BOTON RESET
        resetearCamposParaConsultarDeNuevo();
    }//GEN-LAST:event_jBresetActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VEditarEquipos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VEditarEquipos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VEditarEquipos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VEditarEquipos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VEditarEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBconsultar;
    private javax.swing.JButton jBeditar;
    private javax.swing.JButton jBreset;
    private javax.swing.JButton jBretroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTanioFundacion;
    private javax.swing.JTextField jTciudad;
    private javax.swing.JTextField jTestadio;
    private javax.swing.JTextField jTnombre;
    private javax.swing.JTextField jTpresupuesto;
    // End of variables declaration//GEN-END:variables

// FUNCIONES PROPIAS DE LA VISTA
    public void rellenarCamposVentana(String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        jTnombre.setEnabled(false);
        jTnombre.setText(nombre);
        jTpresupuesto.setText(presupuesto.toString());
        jTanioFundacion.setText(anioFundacion);
        jTciudad.setEnabled(true);
        jTciudad.setText(ciudad);
        jTestadio.setEnabled(true);
        jTestadio.setText(nombreEstadio);
        jBeditar.setEnabled(true);

    }

    public void configPredeterminadaVentana() {
        jTpresupuesto.setEnabled(false);
        jTanioFundacion.setEnabled(false);
        jTciudad.setEnabled(false);
        jTestadio.setEnabled(false);
        jBeditar.setEnabled(false);
    }

    public void resetearCamposParaConsultarDeNuevo() {
        jTnombre.setText(null);
        jTpresupuesto.setText(null);
        jTanioFundacion.setText(null);
        jTciudad.setText(null);
        jTestadio.setText(null);
        jTnombre.setEnabled(true);
        configPredeterminadaVentana();
    }

}
