/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Student
 */
public class MenuAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuAdministrador() {
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
        jClientes = new javax.swing.JButton();
        jEntrenadores = new javax.swing.JButton();
        jClasePersonalizada = new javax.swing.JButton();
        jPago = new javax.swing.JButton();
        jMostrar1 = new javax.swing.JPanel();
        jFecha1 = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        JPanelMenu.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("        GYM NUEVO");

        jClientes.setText("Clientes");
        jClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClientesActionPerformed(evt);
            }
        });

        jEntrenadores.setText("Entrenadores");
        jEntrenadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntrenadoresActionPerformed(evt);
            }
        });

        jClasePersonalizada.setText("Clase Peronalizada");
        jClasePersonalizada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jClasePersonalizadaActionPerformed(evt);
            }
        });

        jPago.setText("Pago");
        jPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPagoActionPerformed(evt);
            }
        });

        jMostrar1.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jMostrar1Layout = new javax.swing.GroupLayout(jMostrar1);
        jMostrar1.setLayout(jMostrar1Layout);
        jMostrar1Layout.setHorizontalGroup(
            jMostrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jMostrar1Layout.setVerticalGroup(
            jMostrar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jFecha1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jFecha1.setForeground(new java.awt.Color(255, 255, 255));
        jFecha1.setText("jLabel2");

        javax.swing.GroupLayout JPanelMenuLayout = new javax.swing.GroupLayout(JPanelMenu);
        JPanelMenu.setLayout(JPanelMenuLayout);
        JPanelMenuLayout.setHorizontalGroup(
            JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jClasePersonalizada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jEntrenadores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jMostrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jFecha1)
                        .addContainerGap(241, Short.MAX_VALUE))))
        );
        JPanelMenuLayout.setVerticalGroup(
            JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFecha1)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(JPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuLayout.createSequentialGroup()
                        .addComponent(jClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jEntrenadores)
                        .addGap(26, 26, 26)
                        .addComponent(jClasePersonalizada)
                        .addGap(18, 18, 18)
                        .addComponent(jPago)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelMenuLayout.createSequentialGroup()
                        .addComponent(jMostrar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClientesActionPerformed
  jMostrar1.removeAll();
    jMostrar1.repaint();
    jMostrar1.revalidate();
    
    
    FrmCliente frmCliente = new FrmCliente();
    jMostrar1.add(frmCliente);
    frmCliente.setBounds(0, 0, jMostrar1.getWidth(), jMostrar1.getHeight());
    frmCliente.setVisible(true);
    
    
    jMostrar1.repaint();
    jMostrar1.revalidate();       
   
    }//GEN-LAST:event_jClientesActionPerformed

    private void jEntrenadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntrenadoresActionPerformed
    jMostrar1.removeAll();
    jMostrar1.repaint();
    jMostrar1.revalidate();
    
    
    FrmEntrenador frmEntrenador = new FrmEntrenador();
    jMostrar1.add(frmEntrenador);
    frmEntrenador.setBounds(0, 0, jMostrar1.getWidth(), jMostrar1.getHeight());
    frmEntrenador.setVisible(true);
    
    
    jMostrar1.repaint();
    jMostrar1.revalidate();
    }//GEN-LAST:event_jEntrenadoresActionPerformed

    private void jClasePersonalizadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jClasePersonalizadaActionPerformed
       jMostrar1.removeAll();
    jMostrar1.repaint();
    jMostrar1.revalidate();
    
    FrmClasePersonalizada frmClasePersonalizada = new FrmClasePersonalizada();
    jMostrar1.add(frmClasePersonalizada);
    frmClasePersonalizada.setBounds(0, 0, jMostrar1.getWidth(), jMostrar1.getHeight());
    frmClasePersonalizada.setVisible(true);
    
    jMostrar1.repaint();
    jMostrar1.revalidate();
    }//GEN-LAST:event_jClasePersonalizadaActionPerformed

    private void jPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPagoActionPerformed
   jMostrar1.removeAll();
    jMostrar1.repaint();
    jMostrar1.revalidate();
    
    FrmPago frmPago = new FrmPago();
    jMostrar1.add(frmPago);
    
        
    frmPago.setVisible(true);
    
    
    jMostrar1.repaint();
    jMostrar1.revalidate();
    }//GEN-LAST:event_jPagoActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdministrador().setVisible(true);
            }
        });
    }
    
    private void actualizarFecha(){
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        String fechaFormateada = sdf.format(fechaActual);
        jFecha1.setText("Hoy es : " + fechaFormateada);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jClasePersonalizada;
    private javax.swing.JButton jClientes;
    private javax.swing.JButton jEntrenadores;
    private javax.swing.JLabel jFecha1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jMostrar1;
    private javax.swing.JButton jPago;
    // End of variables declaration//GEN-END:variables
}
