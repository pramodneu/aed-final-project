/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalEnterpriseAdmin;

import com.repositories.LoginDetailDetailRepository;
import com.view.CounselorPage;
import com.view.DoctorPage;
import com.view.LegalAdvisorPage;
import com.view.PatiendRegistration;
import com.view.PharmacyPage;
import com.view.PolicePage;
import com.view.Prisinorpage;
import com.view.PsychWardPage;
import com.view.RehabPage;
import com.view.SignUp;
import com.view.SystemAdminJFrame;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

/**
 *
 * @author ajitpatil
 */
@Controller(value = "HospitalAdminJFrame")
public class HospitalAdminJFrame extends javax.swing.JFrame {

    SystemAdminJFrame mainAdmin;
    PharmacyPage pharmacyPage;
    RehabPage rehabPage;
    LegalAdvisorPage legalAdvisorPage;
    PolicePage policePage;
    PsychWardPage psychWardPage;
    DoctorPage doctorPage;
    Prisinorpage prisinorpage;
    CounselorPage counselorPage;
    PatiendRegistration patiendRegistration;
    SignUp signUp;
    private LoginDetailDetailRepository loginDetailDetailRepository;

    /**
     * Creates new form Homepage
     */
    public HospitalAdminJFrame(SystemAdminJFrame mainAdmin,
            PharmacyPage pharmacyPage,
            RehabPage rehabPage,
            LegalAdvisorPage legalAdvisorPage,
            PolicePage policePage,
            PsychWardPage psychWardPage,
            DoctorPage doctorPage,
            Prisinorpage prisinorpage, CounselorPage counselorPage, PatiendRegistration patiendRegistration,
            SignUp signUp,
            LoginDetailDetailRepository loginDetailDetailRepository,
            ApplicationContext applicationContext) {
        this.mainAdmin = applicationContext.getBean(SystemAdminJFrame.class);
        this.pharmacyPage = applicationContext.getBean(PharmacyPage.class);
        this.rehabPage = applicationContext.getBean(RehabPage.class);
        this.legalAdvisorPage = applicationContext.getBean(LegalAdvisorPage.class);
        this.policePage = applicationContext.getBean(PolicePage.class);
        this.psychWardPage = applicationContext.getBean(PsychWardPage.class);
        this.doctorPage = applicationContext.getBean(DoctorPage.class);
        this.prisinorpage = applicationContext.getBean(Prisinorpage.class);
        this.counselorPage = applicationContext.getBean(CounselorPage.class);
        this.patiendRegistration = applicationContext.getBean(PatiendRegistration.class);
        this.signUp = applicationContext.getBean(SignUp.class);
        this.loginDetailDetailRepository = applicationContext.getBean(LoginDetailDetailRepository.class);

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

        doctorViewBtn = new javax.swing.JButton();
        rehabViewBtn = new javax.swing.JButton();
        pharmacyViewBtn = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        CounselorViewBtn = new javax.swing.JButton();
        mainImage1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctorViewBtn.setBackground(new java.awt.Color(255, 153, 0));
        doctorViewBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        doctorViewBtn.setText("DoctorView");
        doctorViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorViewBtnActionPerformed(evt);
            }
        });
        getContentPane().add(doctorViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 90, 330, 123));

        rehabViewBtn.setBackground(new java.awt.Color(255, 153, 0));
        rehabViewBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        rehabViewBtn.setText("Rehab View");
        rehabViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rehabViewBtnActionPerformed(evt);
            }
        });
        getContentPane().add(rehabViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 330, 123));

        pharmacyViewBtn.setBackground(new java.awt.Color(255, 153, 0));
        pharmacyViewBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        pharmacyViewBtn.setText("PharmacyView");
        pharmacyViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pharmacyViewBtnActionPerformed(evt);
            }
        });
        getContentPane().add(pharmacyViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 330, 123));

        jButton3.setBackground(new java.awt.Color(255, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 160, 40));

        CounselorViewBtn.setBackground(new java.awt.Color(255, 153, 0));
        CounselorViewBtn.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        CounselorViewBtn.setText("CounselorView");
        CounselorViewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CounselorViewBtnActionPerformed(evt);
            }
        });
        getContentPane().add(CounselorViewBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 330, 123));

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

    private void CounselorViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CounselorViewBtnActionPerformed
        counselorPage.setVisible(true);
    }//GEN-LAST:event_CounselorViewBtnActionPerformed

    private void doctorViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorViewBtnActionPerformed
        doctorPage.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_doctorViewBtnActionPerformed

    private void pharmacyViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pharmacyViewBtnActionPerformed
        pharmacyPage.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_pharmacyViewBtnActionPerformed

    private void rehabViewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rehabViewBtnActionPerformed
        rehabPage.setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_rehabViewBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HospitalAdminJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CounselorViewBtn;
    private javax.swing.JButton doctorViewBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel mainImage1;
    private javax.swing.JButton pharmacyViewBtn;
    private javax.swing.JButton rehabViewBtn;
    // End of variables declaration//GEN-END:variables
}
