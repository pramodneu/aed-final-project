/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.entity.PrisonPatientEntity;
import com.repositories.PatientRepositoryPrison;
import com.repositories.PatientVitalRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
 
@Controller(value = "ViewPrisonPatientPanel")
public class ViewPrisonPatientPanel extends javax.swing.JPanel {

    PatientRepositoryPrison patientRepository;
    PatientVitalRepository patientVitalRepository;

    /**
     * Creates new form ViewPatientPanel
     */
    public ViewPrisonPatientPanel(PatientVitalRepository patientVitalRepository,
            PatientRepositoryPrison patientRepository,
            ApplicationContext applicationContext) {
        this.patientVitalRepository = applicationContext.getBean(PatientVitalRepository.class);
        this.patientRepository = applicationContext.getBean(PatientRepositoryPrison.class);
        initComponents();
        loadPatients();

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        panelLb = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        mainImage1 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setMaximumSize(new java.awt.Dimension(1050, 700));
        setMinimumSize(new java.awt.Dimension(1050, 700));
        setPreferredSize(new java.awt.Dimension(1050, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl1.setBackground(new java.awt.Color(51, 51, 51));
        tbl1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tbl1.setForeground(new java.awt.Color(255, 102, 0));
        tbl1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRISONER  ID", "PRISONER NAME", "AGE", "GENDER", "STATUS"
            }
        ));
        tbl1.setRowHeight(30);
        tbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 990, 450));

        jButton1.setBackground(new java.awt.Color(0, 153, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setText("SEND TO COUNCELOR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, 410, 70));

        panelLb.setText("Prisoners in JAIL");
        add(panelLb, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 140, -1));

        jButton3.setBackground(new java.awt.Color(204, 204, 0));
        jButton3.setText("RELOAD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 480, 100, 30));

        mainImage1.setBackground(new java.awt.Color(41, 46, 64));
        mainImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Mentally Healthy Communities .jpg"))); // NOI18N
        mainImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170), 2));
        mainImage1.setMaximumSize(new java.awt.Dimension(728, 410));
        mainImage1.setMinimumSize(new java.awt.Dimension(728, 410));
        mainImage1.setOpaque(true);
        mainImage1.setPreferredSize(new java.awt.Dimension(728, 410));
        add(mainImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));
    }// </editor-fold>//GEN-END:initComponents

    private void tbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl1MouseClicked

    }//GEN-LAST:event_tbl1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        loadPatients();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
        if (model.getRowCount() != 0) {
            String id = model.getValueAt(tbl1.getSelectedRow(), 0).toString();
            PrisonPatientEntity finddetailById = patientRepository.finddetailById(Integer.parseInt(id));
            if (null != finddetailById) {
                finddetailById.setStatus("Sent to Councelor");
                patientRepository.save(finddetailById);
                
                 JOptionPane.showMessageDialog(this, "Prisoner details sent to Counselor for Examine!!");
                
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mainImage1;
    private javax.swing.JLabel panelLb;
    private javax.swing.JTable tbl1;
    // End of variables declaration//GEN-END:variables

    private void loadPatients() {
        DefaultTableModel model = (DefaultTableModel) tbl1.getModel();
        model.setRowCount(0);
        List<PrisonPatientEntity> findAll = patientRepository.findAll();
        for (PrisonPatientEntity entity : findAll) {
            if (entity.getStatus().equals("PENDING")) {
                Object[] data = {entity.getId(),
                    entity.getName(), entity.getAge(), entity.getGender(), entity.getStatus()};

                model.addRow(data);
            }

        }
    }
}
