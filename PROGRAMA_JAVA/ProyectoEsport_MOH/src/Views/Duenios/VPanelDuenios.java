package Views.Duenios;

import Exceptions.CierreVError;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectoesport_moh.Controladora;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class VPanelDuenios extends javax.swing.JFrame {

    private final String tipoVentana;

    /**
     * Creates new form VPanelDuenios
     */
    public VPanelDuenios() {
        this.tipoVentana = "vPanelDuenios";
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMcerrarSesion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMfichar = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMultimaJornada = new javax.swing.JMenuItem();
        jMultimaClasi = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("PANEL DE DUEÑOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Bienvenid@ de nuevo");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/duenios.png"))); // NOI18N

        jMenu1.setText("Archivo");

        jMcerrarSesion.setText("Cerrar Sesión");
        jMcerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMcerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(jMcerrarSesion);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Gestionar");

        jMfichar.setText("Fichajes");
        jMfichar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMficharActionPerformed(evt);
            }
        });
        jMenu3.add(jMfichar);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Visualizar");

        jMultimaJornada.setText("Resultados Última Jornada");
        jMultimaJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMultimaJornadaActionPerformed(evt);
            }
        });
        jMenu4.add(jMultimaJornada);

        jMultimaClasi.setText("Resultados Última Clasificación");
        jMultimaClasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMultimaClasiActionPerformed(evt);
            }
        });
        jMenu4.add(jMultimaClasi);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMficharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMficharActionPerformed
        // ARCHIVO / GESTIONAR / FICHAJES 
        try {
            Controladora.abrirFichajes();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(VPanelDuenios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMficharActionPerformed

    private void jMcerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMcerrarSesionActionPerformed
        // ARCHIVO / CERRAR SESION
        try {
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }
    }//GEN-LAST:event_jMcerrarSesionActionPerformed

    private void jMultimaJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMultimaJornadaActionPerformed
        // ARCHIVO / VISUALIZAR / ULTIMA JORNADA
        try {
            Controladora.abrirUltimaJornada();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(VPanelDuenios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMultimaJornadaActionPerformed

    private void jMultimaClasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMultimaClasiActionPerformed
        // ARCHIVO / VISUALIZAR / ULTIMA CLASIFICACION
        try {
            Controladora.abrirUltimaClasi();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (CierreVError CVE) {
            JOptionPane.showMessageDialog(this, CVE.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(VPanelDuenios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMultimaClasiActionPerformed

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
            java.util.logging.Logger.getLogger(VPanelDuenios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPanelDuenios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPanelDuenios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPanelDuenios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VPanelDuenios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMcerrarSesion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMfichar;
    private javax.swing.JMenuItem jMultimaClasi;
    private javax.swing.JMenuItem jMultimaJornada;
    // End of variables declaration//GEN-END:variables
}
