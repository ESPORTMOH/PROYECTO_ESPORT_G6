/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Clasificacion;

import Views.Jornada.*;
import Exceptions.CampoTempVacio;
import Exceptions.CierreVError;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.border.Border;
import proyectoesport_moh.Controladora;

/**
 *
 * @author pcwin
 */
public class VAltaClasificacion extends javax.swing.JFrame {

    private final String tipoVentana;

    /**
     * Creates new form VGeneradorClasificacion
     */
    public VAltaClasificacion() {
        initComponents();
        this.tipoVentana = "VAltaClasificacion";
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

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jBgenerarTemporada = new javax.swing.JButton();
        jTntemporada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jBretroceder = new javax.swing.JButton();
        jProgressBarT = new javax.swing.JProgressBar();
        jLaviso = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("GENERAR CLASIFICACIÓN");

        jBgenerarTemporada.setBackground(new java.awt.Color(0, 153, 51));
        jBgenerarTemporada.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBgenerarTemporada.setForeground(new java.awt.Color(255, 255, 255));
        jBgenerarTemporada.setText("GENERAR");
        jBgenerarTemporada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBgenerarTemporadaActionPerformed(evt);
            }
        });

        jLabel2.setText("Nº Temporada");

        jBretroceder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/retroceder.png"))); // NOI18N
        jBretroceder.setBorder(null);
        jBretroceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBretrocederActionPerformed(evt);
            }
        });

        jLaviso.setText("Generando, espere un momento...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBretroceder)
                        .addGap(81, 81, 81)
                        .addComponent(jBgenerarTemporada)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 80, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(32, 32, 32)
                        .addComponent(jTntemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLaviso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jProgressBarT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTntemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addComponent(jLaviso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jProgressBarT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBgenerarTemporada)
                    .addComponent(jBretroceder))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBgenerarTemporadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBgenerarTemporadaActionPerformed
        try {
            // GENERAR TEMPORADA
            if (jTntemporada.getText().isEmpty()) {
                throw new CampoTempVacio();
            } else {
                //JProgressBar jProg = Controladora.generaBarraProgreso(jProgressBarT);
                Controladora.generarJornadas(jTntemporada.getText());

            }
        } catch (CampoTempVacio CTV) {
            JOptionPane.showMessageDialog(this, CTV.getMensaje());
        } catch (Exception ex) {
            Logger.getLogger(VAltaClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBgenerarTemporadaActionPerformed

    private void jBretrocederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBretrocederActionPerformed
        // ACTION BOTON RETROCEDER      
        try {
            Controladora.abreTipoVentanas(tipoVentana);
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception E) {
            Logger.getLogger(VPanelClasificacion.class.getName()).log(Level.SEVERE, null, E);
        }
    }//GEN-LAST:event_jBretrocederActionPerformed

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
            java.util.logging.Logger.getLogger(VAltaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VAltaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VAltaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VAltaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VAltaClasificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBgenerarTemporada;
    private javax.swing.JButton jBretroceder;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLaviso;
    private javax.swing.JProgressBar jProgressBarT;
    private javax.swing.JTextField jTntemporada;
    // End of variables declaration//GEN-END:variables

    // FUNCIONES PROPIAS DE LA VISTA
    private void configPredeterminadaVentana() {
        jProgressBarT.setVisible(false);
        jLaviso.setVisible(false);
    }
    
    private void cargarAvisoBarra(){
        jProgressBarT.setVisible(true);
        jLaviso.setVisible(true);
    }

}
