/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Control.PrincipalController;

/**
 *
 * @author douglas.alarcon
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bMenuAnimales = new javax.swing.JButton();
        bMenuPlanes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bMenuVentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        bMenuAnimales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoAdministrar.PNG"))); // NOI18N
        bMenuAnimales.setBorderPainted(false);
        bMenuAnimales.setContentAreaFilled(false);
        bMenuAnimales.setFocusPainted(false);
        bMenuAnimales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuAnimalesActionPerformed(evt);
            }
        });

        bMenuPlanes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoPlanes.PNG"))); // NOI18N
        bMenuPlanes.setBorderPainted(false);
        bMenuPlanes.setContentAreaFilled(false);
        bMenuPlanes.setFocusPainted(false);
        bMenuPlanes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuPlanesActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoBienvenida.PNG"))); // NOI18N

        bMenuVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logoVentas.PNG"))); // NOI18N
        bMenuVentas.setBorderPainted(false);
        bMenuVentas.setContentAreaFilled(false);
        bMenuVentas.setFocusPainted(false);
        bMenuVentas.setFocusable(false);
        bMenuVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMenuVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(bMenuAnimales, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bMenuPlanes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(bMenuVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(bMenuPlanes))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(bMenuAnimales))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(bMenuVentas)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bMenuAnimalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuAnimalesActionPerformed
    PrincipalController.botonAnimal();
    }//GEN-LAST:event_bMenuAnimalesActionPerformed

    private void bMenuVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuVentasActionPerformed
    PrincipalController.botonVenta();
    }//GEN-LAST:event_bMenuVentasActionPerformed

    private void bMenuPlanesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMenuPlanesActionPerformed
    PrincipalController.botonPlan();
    }//GEN-LAST:event_bMenuPlanesActionPerformed

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bMenuAnimales;
    private javax.swing.JButton bMenuPlanes;
    private javax.swing.JButton bMenuVentas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
