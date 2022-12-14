/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import com.entity.PatientDiagnoseEntity;
import com.entity.PatientEntity;
import com.entity.PatientVitalEntity;
import com.repositories.PatientDiagnoseRepository;
import com.repositories.PatientRepository;
import com.repositories.PatientVitalRepository;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

@Controller(value = "RehabPage")
public class RehabPage extends javax.swing.JFrame {

    PatientDiagnoseRepository diagnoseRepository;
    PatientVitalRepository patientVitalRepository;
    PatientRepository patientRepository;

    /**
     * Creates new form RehabPage
     */
    public RehabPage(PatientDiagnoseRepository diagnoseRepository,
            PatientRepository patientRepository,
            PatientVitalRepository patientVitalRepository,
            ApplicationContext applicationContext) {
        this.diagnoseRepository = applicationContext.getBean(PatientDiagnoseRepository.class);
        this.patientVitalRepository = applicationContext.getBean(PatientVitalRepository.class);
        this.patientRepository = applicationContext.getBean(PatientRepository.class);
        initComponents();
        setLocationRelativeTo(null);
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPatient = new javax.swing.JTable();
        dichargeBtn = new javax.swing.JButton();
        admitBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        reloadBtn = new javax.swing.JButton();
        mainImage1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("VIEW REHAB PATIENTS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 660, 30));

        tblPatient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PATIENT ID", "NAME", "PRESCRIPTION", "CASE SERVERITY", "REHAB REQUIRED", "DOCTOR COMMENTS", "PATIENT STATUS"
            }
        ));
        tblPatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPatientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPatient);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1240, 490));

        dichargeBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dichargeBtn.setText("DISCHARGE");
        dichargeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dichargeBtnActionPerformed(evt);
            }
        });
        getContentPane().add(dichargeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 280, 60));

        admitBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        admitBtn.setText("ADMIT");
        admitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                admitBtnActionPerformed(evt);
            }
        });
        getContentPane().add(admitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 280, 60));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 10, 200, 40));

        reloadBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reloadBtn.setText("Reload");
        reloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reloadBtnActionPerformed(evt);
            }
        });
        getContentPane().add(reloadBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 570, -1, -1));

        mainImage1.setBackground(new java.awt.Color(41, 46, 64));
        mainImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/Mentally Healthy Communities .jpg"))); // NOI18N
        mainImage1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(170, 170, 170), 2));
        mainImage1.setMaximumSize(new java.awt.Dimension(728, 410));
        mainImage1.setMinimumSize(new java.awt.Dimension(728, 410));
        mainImage1.setOpaque(true);
        mainImage1.setPreferredSize(new java.awt.Dimension(728, 410));
        getContentPane().add(mainImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPatientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPatientMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblPatientMouseClicked

    private void admitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_admitBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPatient.getModel();
        if (model.getRowCount() != 0) {
            String id = model.getValueAt(tblPatient.getSelectedRow(), 0).toString();
            PatientEntity finddetailById = patientRepository.finddetailById(Integer.parseInt(id));
            if (null != finddetailById) {
                finddetailById.setStatus("Addmitted to rehab");
                patientRepository.save(finddetailById);
                loadPatients();
                 JOptionPane.showMessageDialog(this ,"Admitted to rehab");
            }
        }
    }//GEN-LAST:event_admitBtnActionPerformed

    private void dichargeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dichargeBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblPatient.getModel();
        if (model.getRowCount() != 0) {
            String id = model.getValueAt(tblPatient.getSelectedRow(), 0).toString();
            PatientEntity finddetailById = patientRepository.finddetailById(Integer.parseInt(id));
            if (null != finddetailById) {
                finddetailById.setStatus("Discharge");
                patientRepository.save(finddetailById);
                loadPatients();
                JOptionPane.showMessageDialog(this ,"Discharged from Rehab");
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_dichargeBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void reloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reloadBtnActionPerformed
        loadPatients();// TODO add your handling code here:
    }//GEN-LAST:event_reloadBtnActionPerformed

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
            java.util.logging.Logger.getLogger(RehabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RehabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RehabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RehabPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton admitBtn;
    private javax.swing.JButton dichargeBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mainImage1;
    private javax.swing.JButton reloadBtn;
    private javax.swing.JTable tblPatient;
    // End of variables declaration//GEN-END:variables
private void loadPatients() {
        DefaultTableModel model = (DefaultTableModel) tblPatient.getModel();
        model.setRowCount(0);
        List<PatientEntity> findAll = patientRepository.findAll();
        for (PatientEntity entity : findAll) {
           // System.out.println(entity.getStatus());
            if (entity.getStatus().equals("Sent to Rehab")||entity.getStatus().equals("Ready to Discharge")) {
                //PatientVitalEntity finddetailById = patientVitalRepository.finddetailById(Integer.toString(entity.getId()));
                PatientVitalEntity finddetailById = patientVitalRepository.finddetailById(entity.getId());
                //PatientDiagnoseEntity diagnoseEntity = diagnoseRepository.finddetailById(Integer.toString(entity.getId()));
                PatientDiagnoseEntity diagnoseEntity = diagnoseRepository.finddetailById(entity.getId());
                if (null != finddetailById) {
                    Object[] data = {entity.getId(),
                        entity.getName(), diagnoseEntity.getPrescription(),
                        diagnoseEntity.getCaseSer(),
                        diagnoseEntity.getSetRehab(),
                        diagnoseEntity.getComments(),
                        entity.getStatus()};

                    model.addRow(data);
                }
            }

        }
    }
}
