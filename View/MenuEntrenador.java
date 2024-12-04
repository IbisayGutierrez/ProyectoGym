/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import View.FrmEntrenador;
import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Student
 */
public class MenuEntrenador extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuEntrenador() {
        initComponents();
        actualizarFecha();
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
        JPanelMenu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jClientes2 = new javax.swing.JButton();
        jClasePersonalizada2 = new javax.swing.JButton();
        jMostrar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jFecha = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        JPanelMenu.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ATLAS FITNESS");

        jClientes2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jClientes2.setText("Clientes");
        jClientes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientes2ActionPerformed(evt);
            }
        });

        jClasePersonalizada2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jClasePersonalizada2.setText("Clase Peronalizada");
        jClasePersonalizada2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClasePersonalizada2ActionPerformed(evt);
            }
        });

        jMostrar.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jMostrarLayout = new javax.swing.GroupLayout(jMostrar);
        jMostrar.setLayout(jMostrarLayout);
        jMostrarLayout.setHorizontalGroup(
            jMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jMostrarLayout.setVerticalGroup(
            jMostrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 434, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jFecha.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jFecha.setForeground(new java.awt.Color(255, 255, 255));
        jFecha.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(410, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout JPanelMenuLayout = new javax.swing.GroupLayout(JPanelMenu);
        JPanelMenu.setLayout(JPanelMenuLayout);
        JPanelMenuLayout.setHorizontalGroup(
            JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jClasePersonalizada2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jClientes2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addComponent(jMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPanelMenuLayout.setVerticalGroup(
            JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addComponent(jClientes2)
                        .addGap(42, 42, 42)
                        .addComponent(jClasePersonalizada2))
                    .addComponent(jMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jClientes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClientes2ActionPerformed
       jMostrar.removeAll();
    jMostrar.repaint();
    jMostrar.revalidate();
    
    
    FrmCliente frmCliente = new FrmCliente();
    jMostrar.add(frmCliente);
    frmCliente.setBounds(0, 0, jMostrar.getWidth(), jMostrar.getHeight());
    frmCliente.setVisible(true);
    
    
    jMostrar.repaint();
    jMostrar.revalidate();
    
    }//GEN-LAST:event_jClientes2ActionPerformed

    private void jClasePersonalizada2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClasePersonalizada2ActionPerformed
       jMostrar.removeAll();
    jMostrar.repaint();
    jMostrar.revalidate();
    
        
        FrmClasePersonalizada ClasePersonalizada = new FrmClasePersonalizada();
    jMostrar.add(ClasePersonalizada);
    ClasePersonalizada.setBounds(0, 0, jMostrar.getWidth(), jMostrar.getHeight());
    ClasePersonalizada.setVisible(true);
    
    
    jMostrar.repaint();
    jMostrar.revalidate();
    }//GEN-LAST:event_jClasePersonalizada2ActionPerformed

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
            java.util.logging.Logger.getLogger(MenuEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuEntrenador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuEntrenador().setVisible(true);
               
            }     
        });
    }
private void actualizarFecha(){
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        String fechaFormateada = sdf.format(fechaActual);
        jFecha.setText("Hoy es : " + fechaFormateada);
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jClasePersonalizada2;
    private javax.swing.JButton jClientes2;
    private javax.swing.JLabel jFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jMostrar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
