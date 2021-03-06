/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Notices;
import ApplicationRegistration.ui.NewJFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Transport;
import javax.swing.JOptionPane;
/**
 *
 * @author shubhangisrivastava
 */
public class AuthorizationNotice extends javax.swing.JPanel {
 Connection con = null;
    PreparedStatement pst = null;
    PreparedStatement pst2 = null;
    ResultSet rs = null;
    ResultSet rs2 = null;
    public AuthorizationNotice() {
        initComponents();
         fetch();
         
         btnLogout.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                int a = JOptionPane.showConfirmDialog(btnLogout, "Are you sure?");
                if(a==JOptionPane.YES_OPTION){
                   
                    NewJFrame nj = new NewJFrame();
                     nj.dispose();
                    nj.setVisible(true);
                }
                
                NewJFrame nj = new NewJFrame();
                 nj.dispose();
                nj.setVisible(true);
            }

//            private void dispose() {
//                
//               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        });
    }
     public void fetch(){
    try{
        String query = "select * from searchclientnotice order by id desc limit 1;";
        con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/finalproject", "root", "Kidwainagar@1221");
        pst = con.prepareStatement(query);
        rs = pst.executeQuery();
        if(rs.next()){
        String curr_client_id = rs.getString("client_id");
        jLabel6.setText(curr_client_id);
        }
       
       String query2 = "select * from eligibility e join person p on p.client_id=e.client_id where e.client_id=? and days_left=90;";
        pst2 = con.prepareStatement(query2);
        pst2.setString(1, jLabel6.getText());
        rs2 = pst2.executeQuery();
        if(rs2.next()== true){
            jLabel1.setText("Client Authorization Notice For ");
        }else{
        jLabel1.setText("Client Reviewing Notice For Client Id");
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

        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtToEmail = new javax.swing.JTextField();
        txtFromEmail = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        txtMessage = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEmail = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 204, 255));

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("To:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("From:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Subject:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Message:");

        txtToEmail.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N

        txtFromEmail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        txtFromEmail.setText("shubhangishrivastavahb13@gmail.com");
        txtFromEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFromEmailActionPerformed(evt);
            }
        });

        txtSubject.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N

        txtMessage.setFont(new java.awt.Font("Lucida Grande", 1, 20)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(76, 76, 76))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(69, 69, 69)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSubject, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFromEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .addComponent(txtToEmail, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMessage))))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtToEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtFromEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSubject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Notice name");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEmail.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnEmail.setText("Send mail");
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel6.setText("clientid");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogout)
                                .addGap(247, 247, 247)
                                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(jLabel6)))
                .addContainerGap(368, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEmail, btnLogout});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEmail, btnLogout});

    }// </editor-fold>//GEN-END:initComponents

    private void txtFromEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFromEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFromEmailActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed

        String toEmail = txtToEmail.getText();
        String fromEmail = txtFromEmail.getText(); //shubhangishrivastavahb13@gmail.com
        String FromEmailPassword = "Kidwainagar@1221"; //your email id passsowrd
        String host = "localhost";
        //String subject = txtSubject.getText();

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);

        properties.put("mail.smtp.port", 587);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.user", fromEmail);

        properties.put("mail.password", FromEmailPassword);

        //        Properties properties = new Properties();
        //        properties.put("mail.smtp.auth","true");
        //        properties.put("mail.smtp.starttls.enable","true");
        //        properties.put("mail.smtp.host","smtp.gmail.com");
        //        properties.put("mail.smtp.port","465");
        //

        Authenticator auth = new Authenticator()
        {
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromEmail, FromEmailPassword);
            }
        };
        Session session = Session.getInstance(properties, auth);

        // Session session = Session.getDefaultInstance(properties,new javax.mail.Authenticator() {

            //            protected PasswordAuthentication getPasswordAuthentication() {
                //                 return new PasswordAuthentication(fromEmail, FromEmailPassword);
                //            }
            //
            //        });

    try{
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(fromEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject("This is subject");
        message.setText("this is actual text");
        Transport.send(message);
        System.out.println("Sent message successfully....");
        }catch(Exception ex) {
            System.out.println(""+ex);
        }
    
    JOptionPane.showMessageDialog(null, "Message sent!!");
    }//GEN-LAST:event_btnEmailActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtFromEmail;
    private javax.swing.JTextField txtMessage;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtToEmail;
    // End of variables declaration//GEN-END:variables
}
