/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataCollection.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author shubhangisrivastava
 */
public class DCPersonDemographics extends javax.swing.JPanel {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    PreparedStatement pst2 = null;
    ResultSet rs2 = null;
    public DCPersonDemographics() {
        initComponents();
        fetch();
    }
    
       public void fetch(){
    try{
        String query = "select * from searchclient order by id desc limit 1;";
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/finalproject", "root", "Kidwainagar@1221");
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if(rs.next()){
        String curr_client = rs.getString("client_id");
        lblClientID2.setText(curr_client);
        
        int id = Integer.parseInt(lblClientID2.getText());
                 String query2 ="select * from person where client_id=?";
                 pst2 = con.prepareStatement(query2);
                 pst2.setInt(1, id);
                 rs2 = pst2.executeQuery();
                 if(rs2.next()){
                    String copy_client = rs2.getString("fname");
                    lblFName1.setText(copy_client);}
        
        }
    }catch(Exception ex){
    JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblFName = new javax.swing.JLabel();
        lblDocType = new javax.swing.JLabel();
        lblVerify = new javax.swing.JLabel();
        lblCitizen = new javax.swing.JLabel();
        comboIdentity = new javax.swing.JComboBox<>();
        comboVerify = new javax.swing.JComboBox<>();
        comboCitizenship = new javax.swing.JComboBox<>();
        lblMA = new javax.swing.JLabel();
        comboMA = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        lblVerify2 = new javax.swing.JLabel();
        comboVerify2 = new javax.swing.JComboBox<>();
        lblClientID1 = new javax.swing.JLabel();
        lblClientID2 = new javax.swing.JLabel();
        lblFName1 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        jSplitPane1.setBackground(new java.awt.Color(102, 204, 255));
        jSplitPane1.setDividerLocation(145);
        jSplitPane1.setDividerSize(0);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(0, 642));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 143, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Collection - Person Demographics");

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        lblFName.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblFName.setText("First Name:");

        lblDocType.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblDocType.setText("Identity Document Type:");

        lblVerify.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblVerify.setText("Verification:");

        lblCitizen.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblCitizen.setText("Citizenship:");

        comboIdentity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "US Passport", "Driver's License" }));

        comboVerify.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hard Copy", "Pending" }));

        comboCitizenship.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "US Citizen", "US National", "Alien" }));

        lblMA.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblMA.setText("Is this person living in MA?");
        lblMA.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        comboMA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Yes", "No" }));

        btnSave.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnNext.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        lblVerify2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblVerify2.setText("Verification:");

        comboVerify2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hard Copy", "Pending" }));

        lblClientID1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lblClientID1.setText("Client ID:");

        lblClientID2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblClientID2.setText("Client ID:");

        lblFName1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblFName1.setText("First Name:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClientID1)
                    .addComponent(lblFName)
                    .addComponent(lblDocType)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblCitizen)
                        .addComponent(lblVerify))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblVerify2)
                            .addComponent(lblMA))))
                .addGap(140, 140, 140)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblClientID2)
                    .addComponent(lblFName1)
                    .addComponent(comboIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboVerify, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMA, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboVerify2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSave)
                .addGap(63, 63, 63)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboCitizenship, comboIdentity, comboMA, comboVerify, comboVerify2, lblClientID2, lblFName1});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnNext, btnSave});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClientID1)
                    .addComponent(lblClientID2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFName)
                            .addComponent(lblFName1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboIdentity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDocType))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVerify)
                            .addComponent(comboVerify, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCitizen)
                            .addComponent(comboCitizenship, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMA)
                            .addComponent(comboMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblVerify2)
                            .addComponent(comboVerify2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnNext))
                        .addGap(94, 94, 94))))
        );

        btnBack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 778, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnBack)))
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBack)
                .addContainerGap(92, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
       
         try{
                SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");
                int id = Integer.parseInt(lblClientID2.getText());
                String query = "INSERT into person_demo " + " (client_id,fname,ident_doc_type,verification1,citizenship,person_living_ma,verification2)" + " values (?, ?, ?, ?, ?, ?, ?)";
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/finalproject", "root", "Kidwainagar@1221");
                pst = con.prepareStatement(query);
                pst.setInt(1, id);      
                pst.setString(2, lblFName1.getText());
                pst.setString(3, String.valueOf(comboIdentity.getSelectedItem()));
                pst.setString(4, String.valueOf(comboVerify.getSelectedItem()));
                pst.setString(5, String.valueOf(comboCitizenship.getSelectedItem()));
                pst.setString(6, String.valueOf(comboMA.getSelectedItem()));
                pst.setString(7, String.valueOf(comboVerify2.getSelectedItem()));
                pst.executeUpdate();
                 
        
            
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
         DCDisability dh = new DCDisability();
        jSplitPane1.setRightComponent(dh);
                                           
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        DCLivingArrangement dh = new DCLivingArrangement();
        jSplitPane1.setRightComponent(dh);
    }//GEN-LAST:event_btnBackActionPerformed
//public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DCPersonDemographics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DCPersonDemographics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DCPersonDemographics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DCPersonDemographics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new DCPersonDemographics().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comboCitizenship;
    private javax.swing.JComboBox<String> comboIdentity;
    private javax.swing.JComboBox<String> comboMA;
    private javax.swing.JComboBox<String> comboVerify;
    private javax.swing.JComboBox<String> comboVerify2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblCitizen;
    private javax.swing.JLabel lblClientID1;
    private javax.swing.JLabel lblClientID2;
    private javax.swing.JLabel lblDocType;
    private javax.swing.JLabel lblFName;
    private javax.swing.JLabel lblFName1;
    private javax.swing.JLabel lblMA;
    private javax.swing.JLabel lblVerify;
    private javax.swing.JLabel lblVerify2;
    // End of variables declaration//GEN-END:variables
}
