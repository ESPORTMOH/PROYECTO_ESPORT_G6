package Views.Clasificacion;

import Views.Jornada.*;
import Exceptions.CierreVError;

import proyectoesport_moh.Controladora;
import Exceptions.*;
import Views.Usuarios.VPanelCrudUsuarios;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MIGUEL
 */
public class VConsultaClasificacion extends javax.swing.JFrame {

    private final String tipoVentana;

    /**
     * Creates new form VAltaClasificacion
     */
    public VConsultaClasificacion() {
        initComponents();
        this.tipoVentana = "VConsultarClasificacion";
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
        jBconsultar = new javax.swing.JButton();
        jTnumeroTemporada = new javax.swing.JTextField();
        jBreset = new javax.swing.JButton();
        jBretroceder = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("CONSULTAR CLASIFICACIÓN");

        jLabel2.setText("Nº Temporada");

        jBconsultar.setBackground(new java.awt.Color(0, 153, 51));
        jBconsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBconsultar.setForeground(new java.awt.Color(255, 255, 255));
        jBconsultar.setText("ACEPTAR");
        jBconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBconsultarActionPerformed(evt);
            }
        });

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

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane2.setViewportView(jTextArea2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTnumeroTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jBretroceder)
                            .addGap(45, 45, 45)
                            .addComponent(jBconsultar)
                            .addGap(35, 35, 35)
                            .addComponent(jBreset))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnumeroTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBretroceder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBconsultar)
                        .addComponent(jBreset)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jBconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBconsultarActionPerformed
        // ACTION PARA CONSULTAR LA JORNADA EN LA BD
        try {
            if (jTnumeroTemporada.getText().isEmpty()) {
                throw new CampoNumTemporadaVacio();
            } else {
                Controladora.pedirLocalizarTemporada(tipoVentana, jTnumeroTemporada.getText());
            }
        } catch (CampoNumTemporadaVacio CNTV) {
            JOptionPane.showMessageDialog(this, CNTV.getMensaje());
        } catch (TemporadaNoExiste TNE) {
            JOptionPane.showMessageDialog(this, TNE.getMensaje());
        } catch (Exception E) {
            JOptionPane.showMessageDialog(this, E.getMessage());
        }
    }//GEN-LAST:event_jBconsultarActionPerformed

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
            java.util.logging.Logger.getLogger(VConsultaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VConsultaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VConsultaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VConsultaClasificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VConsultaClasificacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBconsultar;
    private javax.swing.JButton jBreset;
    private javax.swing.JButton jBretroceder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTnumeroTemporada;
    // End of variables declaration//GEN-END:variables

    // FUNCIONES PROPIAS DE LA VISTA


    public void configPredeterminadaVentana() {
        jTnumeroTemporada.setEnabled(true);
    }
    
    public void resetearCamposParaConsultarDeNuevo() {
        jTnumeroTemporada.setText(null);
        configPredeterminadaVentana();
    }
}
