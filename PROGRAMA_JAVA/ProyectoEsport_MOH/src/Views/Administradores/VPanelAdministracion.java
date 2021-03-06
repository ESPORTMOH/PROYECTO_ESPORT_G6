package Views.Administradores;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectoesport_moh.Controladora;

/**
 * @author MIGUEL OLMO HERNANDO
 */
public class VPanelAdministracion extends javax.swing.JFrame {

    private final String tipoVentana;

    /**
     * Creates new form VPanelAdministracion
     */
    public VPanelAdministracion() {
        this.tipoVentana = "VPanelAdmins";
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMcerrarSesion = new javax.swing.JMenuItem();
        jMCRUDadmin = new javax.swing.JMenu();
        jMadministradores = new javax.swing.JMenuItem();
        jMCRUDduenios = new javax.swing.JMenuItem();
        jMCRUDjugadores = new javax.swing.JMenuItem();
        jMCRUDusuarios = new javax.swing.JMenuItem();
        jMCRUDequipos = new javax.swing.JMenuItem();
        jMpartidos = new javax.swing.JMenu();
        jMcalendario = new javax.swing.JMenuItem();
        jMclasificacion = new javax.swing.JMenuItem();
        jMresultados = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(new java.awt.Dimension(436, 388));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 24)); // NOI18N
        jLabel1.setText("PANEL DE ADMINISTRADORES");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Bienvenid@ de nuevo");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/admins.png"))); // NOI18N

        jMenu1.setText("Archivo");

        jMcerrarSesion.setText("Cerrar Sesión");
        jMcerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMcerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(jMcerrarSesion);

        jMenuBar1.add(jMenu1);

        jMCRUDadmin.setText("Administrar");

        jMadministradores.setText("CRUD Administradores");
        jMadministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMadministradoresActionPerformed(evt);
            }
        });
        jMCRUDadmin.add(jMadministradores);

        jMCRUDduenios.setText("CRUD Duenios");
        jMCRUDduenios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCRUDdueniosActionPerformed(evt);
            }
        });
        jMCRUDadmin.add(jMCRUDduenios);

        jMCRUDjugadores.setText("CRUD Jugadores");
        jMCRUDjugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCRUDjugadoresActionPerformed(evt);
            }
        });
        jMCRUDadmin.add(jMCRUDjugadores);

        jMCRUDusuarios.setText("CRUD Usuarios");
        jMCRUDusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCRUDusuariosActionPerformed(evt);
            }
        });
        jMCRUDadmin.add(jMCRUDusuarios);

        jMCRUDequipos.setText("CRUD Equipos");
        jMCRUDequipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMCRUDequiposActionPerformed(evt);
            }
        });
        jMCRUDadmin.add(jMCRUDequipos);

        jMenuBar1.add(jMCRUDadmin);

        jMpartidos.setText("Gestionar");

        jMcalendario.setText("Temporadas");
        jMcalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMcalendarioActionPerformed(evt);
            }
        });
        jMpartidos.add(jMcalendario);

        jMclasificacion.setText("Clasificaciones");
        jMclasificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMclasificacionActionPerformed(evt);
            }
        });
        jMpartidos.add(jMclasificacion);

        jMresultados.setText("Partidos");
        jMresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMresultadosActionPerformed(evt);
            }
        });
        jMpartidos.add(jMresultados);

        jMenuBar1.add(jMpartidos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // APERTURAS DE LAS VISTAS CRUD / ADMINISTRADORES / USUARIOS / DUENOS / JUGADORES / EQUIPOS
    private void jMadministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMadministradoresActionPerformed
        // ACTION CRUD ADMINISTRADORES
        try {
            Controladora.abrirCrudAdministradores();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }

    }//GEN-LAST:event_jMadministradoresActionPerformed

    private void jMCRUDjugadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCRUDjugadoresActionPerformed
        // ACTION CRUD JUGADORES
        try {
            Controladora.abrirCrudJugadores();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }

    }//GEN-LAST:event_jMCRUDjugadoresActionPerformed

    private void jMCRUDdueniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCRUDdueniosActionPerformed
        // ACTION CRUD DUENIOS
        try {
            Controladora.abrirCrudDuenios();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }

    }//GEN-LAST:event_jMCRUDdueniosActionPerformed

    private void jMCRUDusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCRUDusuariosActionPerformed
        // ACTION CRUD USUARIOS
        try {
            Controladora.abrirCrudUsuarios();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }

    }//GEN-LAST:event_jMCRUDusuariosActionPerformed

    private void jMcerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMcerrarSesionActionPerformed
        // ARCHIVO / CERRAR SESION
        try {
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }
    }//GEN-LAST:event_jMcerrarSesionActionPerformed

    private void jMcalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMcalendarioActionPerformed
        // ARCHIVO / GESTION / JORNADAS
        try {
            Controladora.abrirCrudJornadas();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception EX) {
            JOptionPane.showMessageDialog(this, EX.getMessage());
        }
    }//GEN-LAST:event_jMcalendarioActionPerformed

    private void jMCRUDequiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMCRUDequiposActionPerformed
        // ACTION CRUD EQUIPOS 
        try {
            Controladora.abrirCrudEquipos();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception ex) {
            Logger.getLogger(VPanelAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMCRUDequiposActionPerformed

    private void jMresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMresultadosActionPerformed
        // ACTION REGISTRAR RESULTADOS DE LOS PARTIDOS
        try {
            Controladora.abrirPanelPartidosPuntos();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception ex) {
            Logger.getLogger(VPanelAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMresultadosActionPerformed

    private void jMclasificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMclasificacionActionPerformed
        // ACTION REGISTRAR CLASIFICACION
        try {
            Controladora.abrirPanelClasificacion();
            Controladora.cierraTipoVentanas(tipoVentana);
        } catch (Exception ex) {
            Logger.getLogger(VPanelAdministracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMclasificacionActionPerformed

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
            java.util.logging.Logger.getLogger(VPanelAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VPanelAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VPanelAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VPanelAdministracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VPanelAdministracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMCRUDadmin;
    private javax.swing.JMenuItem jMCRUDduenios;
    private javax.swing.JMenuItem jMCRUDequipos;
    private javax.swing.JMenuItem jMCRUDjugadores;
    private javax.swing.JMenuItem jMCRUDusuarios;
    private javax.swing.JMenuItem jMadministradores;
    private javax.swing.JMenuItem jMcalendario;
    private javax.swing.JMenuItem jMcerrarSesion;
    private javax.swing.JMenuItem jMclasificacion;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMpartidos;
    private javax.swing.JMenuItem jMresultados;
    // End of variables declaration//GEN-END:variables
}
