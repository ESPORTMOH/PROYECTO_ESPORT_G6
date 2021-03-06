package Views;

import java.awt.Color;
import javax.swing.JOptionPane;
import proyectoesport_moh.Controladora;

/**
 *
 * @author MIGUEL
 */
public class VHome extends javax.swing.JFrame {

    /**
     * Creates new form VHome
     */
    public VHome() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMarchivo = new javax.swing.JMenu();
        jMsalir = new javax.swing.JMenuItem();
        jMlogin = new javax.swing.JMenu();
        jMinicioSesion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/wall.jpg"))); // NOI18N

        jMarchivo.setText("Archivo");

        jMsalir.setText("Salir");
        jMsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMsalirActionPerformed(evt);
            }
        });
        jMarchivo.add(jMsalir);

        jMenuBar1.add(jMarchivo);

        jMlogin.setText("Login");

        jMinicioSesion.setText("Iniciar Sesión");
        jMinicioSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMinicioSesionActionPerformed(evt);
            }
        });
        jMlogin.add(jMinicioSesion);

        jMenuBar1.add(jMlogin);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMsalirActionPerformed
        // ARCHIVO / SALIR
        int preguntaSalida = JOptionPane.showConfirmDialog(this, "¿Realmente deseas Salir de la Aplicacion?");
        if (preguntaSalida == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(this, "_-¡Hasta la Proxima!-_");
            Controladora.salirAplicacion();
        }
        if (preguntaSalida == JOptionPane.NO_OPTION) {
            Controladora.reiniciarVistaLogin();
        }
        if (preguntaSalida == JOptionPane.CANCEL_OPTION) {
            Controladora.reiniciarVistaLogin();
        }
        if (preguntaSalida == JOptionPane.CLOSED_OPTION) {
            Controladora.reiniciarVistaLogin();
        }

    }//GEN-LAST:event_jMsalirActionPerformed

    private void jMinicioSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMinicioSesionActionPerformed
        // LOGIN / INICIAR SESION
        Controladora.reiniciarVistaLogin();
    }//GEN-LAST:event_jMinicioSesionActionPerformed

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
            java.util.logging.Logger.getLogger(VHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMarchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMinicioSesion;
    private javax.swing.JMenu jMlogin;
    private javax.swing.JMenuItem jMsalir;
    // End of variables declaration//GEN-END:variables
}
