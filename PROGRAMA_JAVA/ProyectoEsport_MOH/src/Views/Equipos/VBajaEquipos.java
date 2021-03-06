package Views.Equipos;

import proyectoesport_moh.Controladora;
import Exceptions.*;
import Views.Equipos.*;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author MIGUEL OLMO HERNANDO
 */
public class VBajaEquipos extends javax.swing.JFrame {

    private final String tipoVentana;

    /**
     * Creates new form VBajaEquipos
     */
    public VBajaEquipos() {
        initComponents();
        this.tipoVentana = "VBajaEquipos";
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        configPredeterminadaVentana();
        this.getContentPane().setBackground(Color.CYAN);

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
        jBbaja = new javax.swing.JButton();
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("BAJA EQUIPOS");

        jLabel2.setText("Nombre");

        jLabel3.setText("Año de su Fundación");

        jLabel4.setText("Ciudad");

        jBbaja.setBackground(new java.awt.Color(153, 0, 0));
        jBbaja.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBbaja.setForeground(new java.awt.Color(255, 255, 255));
        jBbaja.setText("DAR DE BAJA");
        jBbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBbajaActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jBconsultar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(jBbaja))
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
                                    .addComponent(jTanioFundacion, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(jTestadio)
                                    .addComponent(jTpresupuesto)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBretroceder)
                        .addGap(128, 128, 128)
                        .addComponent(jBreset)))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTestadio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTpresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBconsultar)
                    .addComponent(jBbaja))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBreset)
                    .addComponent(jBretroceder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBbajaActionPerformed
        // ACTION ELIMINAR
        int preguntaSalida = JOptionPane.showConfirmDialog(this, "¿Realmente deseas eliminar"
                + "\na este Equipo?");

        if (preguntaSalida == JOptionPane.YES_OPTION) {
            //try {
                //Controladora.eliminarEquipoDelaBD(jTnombre.getText());
                JOptionPane.showMessageDialog(this, "El Equipo ha sido "
                        + "\ndado de baja correctamente");
                resetearCamposParaConsultarDeNuevo();
            //} catch (SQLException | ConexionProblemas EX) {
             //   Logger.getLogger(VBajaEquipos.class.getName()).log(Level.SEVERE, null, EX);
           //}
        }

    }//GEN-LAST:event_jBbajaActionPerformed

    private void jBconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconsultarActionPerformed
        // ACTION PARA BUSCAR ADMIN PRIMERO EN LA BD Y ELIMINAR DESPUES SI SE QUIERE
        try {
            if (jTnombre.getText().isEmpty()) {
                throw new CampoNombreVacio();
            } else {
                Controladora.localizarEquipoEnBD(tipoVentana, jTnombre.getText());
            }
        } catch (CampoNombreVacio CNV) {
            JOptionPane.showMessageDialog(this, CNV.getMensaje());
        } catch (EquipoNoExiste ENE) {
            JOptionPane.showMessageDialog(this, ENE.getMensaje());
        } catch (DuenioCRUDError ECRUDE) {
            JOptionPane.showMessageDialog(this, ECRUDE.getMensaje());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
        }
    }//GEN-LAST:event_jBconsultarActionPerformed

    // ACTION RETROCEDER
    private void jBretrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBretrocederActionPerformed
        try {
            Controladora.abreTipoVentanas(tipoVentana);
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
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
            java.util.logging.Logger.getLogger(VBajaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VBajaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VBajaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VBajaEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VBajaEquipos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBbaja;
    private javax.swing.JButton jBconsultar;
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
   
    /**
     * FUNCIONES PROPIAS DE LA VISTA
     * 
     * @param nombre
     * @param presupuesto
     * @param anioFundacion
     * @param ciudad
     * @param nombreEstadio 
     */
    public void rellenarCamposVentana(String nombre, Double presupuesto, String anioFundacion, String ciudad, String nombreEstadio) {
        jTnombre.setText(nombre);
        jTpresupuesto.setText(presupuesto.toString());
        jTanioFundacion.setText(anioFundacion);
        jTciudad.setText(ciudad);
        jTestadio.setText(nombreEstadio);
        jBbaja.setEnabled(true);
    }

    public void configPredeterminadaVentana() {
        jTpresupuesto.setEnabled(false);
        jTanioFundacion.setEnabled(false);
        jTciudad.setEnabled(false);
        jTestadio.setEnabled(false);
        jBbaja.setEnabled(false);

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
