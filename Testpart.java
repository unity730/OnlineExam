import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author HP
 */
public class Testpart extends javax.swing.JFrame {

     PreparedStatement stm;
    Connection con;
    ResultSet rs;
    Statement statem=null;
    String correctAnswer;
    static int  mark=0;
    int checkanswer=0;
    String answer=null;
    int currentQuestionIndex=0;
    
    public Testpart() throws SQLException {
        initComponents();
         connect();
        loadQuestion(currentQuestionIndex);
       
    }
public boolean answercheck(){
String givenanswer="";
   if(jRadioButton1.isSelected()){
   givenanswer=jRadioButton1.getText();
   
   }
   else if(jRadioButton2.isSelected()){
   givenanswer=jRadioButton2.getText();
   }
   else if(jRadioButton3.isSelected()){
   givenanswer=jRadioButton3.getText();
   }
   else if(jRadioButton4.isSelected()){
   givenanswer=jRadioButton4.getText();
   }
   if(givenanswer.equals(correctAnswer))//&&(givenanswer == null || givenanswer.equals(correctAnswer)))
   {
   
   mark=mark+1;
   jLabel4.setText(String.valueOf(mark));
   }
   else if(!givenanswer.equals(correctAnswer)|| givenanswer!=null||givenanswer!=null){
       if(mark>0){
       mark=mark;
       }
       jLabel4.setText(String.valueOf(mark));
   }
   if(!givenanswer.equals("")){
     String query1="update QuestionTable set GivenAnswer=? where Question=?";
    try {
        stm=con.prepareStatement(query1);
        
        stm.setString(1, givenanswer);
        stm.setString(2, jLabel2.getText());
        stm.execute();
    } catch (SQLException ex) {
        Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
    }
     return true;
   }
    return false;
}
public void nullGivenAnswer(){
     String query1="update QuestionTable set GivenAnswer=? ";
         try {
             stm=con.prepareStatement(query1);
             stm.setString(1, null);
             stm.execute();
         } catch (SQLException ex) {
             Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
         }

}
public boolean AlreadyAnswered(){
      String query="select GivenAnswer from QuestionTable where Question='"+jLabel2.getText()+"'";
      
         try {
             stm=con.prepareStatement(query);
             
             rs=statem.executeQuery(query);
             
             while(rs.next()){
             answer=rs.getString("GivenAnswer");
             if(answer==null){
             return false;
             }
             break;
             }
             if(jRadioButton1.getText().equals(answer)){
             jRadioButton1.setSelected(true);
             }
             else if(jRadioButton2.getText().equals(answer)){
             jRadioButton2.setSelected(true);
             
             }
             else if(jRadioButton3.getText().equals(answer)){
             jRadioButton3.setSelected(true);
             
             }
          else if(jRadioButton4.getText().equals(answer)){
             jRadioButton4.setSelected(true);
             
             }

         } catch (SQLException ex) {
             Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
         }
    return true;  
}




    public void connect() throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/online_exam", "desu", "desu123");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(user.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public void loadQuestion(int index){
    String query = "SELECT * FROM QuestionTable LIMIT 1 OFFSET " + index;
    
         try {
             statem=con.createStatement();
             rs=statem.executeQuery(query);
             
             while(rs.next()){
                 jLabel3.setText(rs.getString(1));
                  courseidtf.setText(rs.getString(2));
                  jLabel2.setText(rs.getString(3));
                  jRadioButton1.setText(rs.getString(4));
                  jRadioButton2.setText(rs.getString(5));
                  jRadioButton3.setText(rs.getString(6));
                  jRadioButton4.setText(rs.getString(7));
                  correctAnswer=(rs.getString(7));
                  //load first question
                  break;
             }
         } catch (SQLException ex) {
             Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        previousbtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Loginoutbtn = new javax.swing.JButton();
        Submitbtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Useridtf = new javax.swing.JTextField();
        courseidtf = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Online Exam");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton1.setText("jRadioButton1");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton2.setText("jRadioButton2");

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton3.setText("jRadioButton3");

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButton4.setText("jRadioButton4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton4)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton1))
                .addContainerGap(474, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jRadioButton1)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton2)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton3)
                .addGap(18, 18, 18)
                .addComponent(jRadioButton4)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Question");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("No");

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        previousbtn.setBackground(new java.awt.Color(204, 255, 255));
        previousbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        previousbtn.setText("Previous");
        previousbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousbtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mark");

        Loginoutbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Loginoutbtn.setText("LoginOut");
        Loginoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginoutbtnActionPerformed(evt);
            }
        });

        Submitbtn.setBackground(new java.awt.Color(0, 255, 153));
        Submitbtn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Submitbtn.setText("Submit");
        Submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitbtnActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Course Id");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("User Id");

        Useridtf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        courseidtf.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        courseidtf.setText("jLabel7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Useridtf, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseidtf))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(courseidtf))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Useridtf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 0, 0));
        jLabel7.setText("Enter your ID number ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 0, 0));
        jLabel8.setText("Before submit your ");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Answer");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(previousbtn)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Loginoutbtn))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(Submitbtn)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel9)))))
                .addGap(469, 469, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Submitbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Loginoutbtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(previousbtn)
                        .addComponent(jLabel4)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(answercheck()){
            currentQuestionIndex++; // Move to the next question
        loadQuestion(currentQuestionIndex); // Load the next question
            try {
                if(rs.next()){
                    
                  jLabel2.setText(rs.getString("Question"));
                  jRadioButton1.setText(rs.getString(3));
                  jRadioButton2.setText(rs.getString(4));
                  jRadioButton3.setText(rs.getString(5));
                  jRadioButton4.setText(rs.getString(6));
                    
                  correctAnswer=rs.getString(7);
                  
                  if(!AlreadyAnswered()){
                  buttonGroup1.clearSelection();
                  }
                } 
                else{
                //JOptionPane.showMessageDialog(this, "No more questions available");
                }
            
            } catch (SQLException ex) {
                Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void LoginoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginoutbtnActionPerformed
        // TODO add your handling code here:
        
         try {
             Login L = new Login();
              L.setVisible(true);
              this.setVisible(false);
         } catch (SQLException ex) {
             Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
         }
            
    }//GEN-LAST:event_LoginoutbtnActionPerformed

    private void SubmitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitbtnActionPerformed
        // TODO add your handling code here:
          // Calculate the score and determine the grade
    int score = mark; // Assuming 'mark' holds the total score
    String grade = calculateGrade(score); // Method to determine grade based on score
    
    // Record the results in the database
    recordResults(score, grade);
}                                         

private String calculateGrade(int score) {
    // Example grading logic
    if (score >= 90) {
        return "A+";
    } else if (score >= 80) {
        return "A";
    } else if (score >= 70) {
        return "B";
    } else if (score >= 60) {
        return "C";
    } else if (score >= 50) {
        return "D";
    } else {
        return "F";
    }
}

private void recordResults(int score, String grade) {
    String query = "INSERT INTO Results (Uid, Cid, score, grade) VALUES (?, ?, ?, ?)";
    try {
        // Assuming you have access to the user ID and course ID
        String userId = Useridtf.getText(); // Replace with actual user ID
        String courseId = courseidtf.getText(); // Replace with actual course ID

        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, userId);
        pstmt.setString(2, courseId);
        pstmt.setInt(3, score);
        pstmt.setString(4, grade);
        
        // Execute the insert statement
        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Results recorded successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to record results.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(this, "Error recording results.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_SubmitbtnActionPerformed

    private void previousbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousbtnActionPerformed
        // TODO add your handling code here:
         if (currentQuestionIndex > 0) {
        // Decrease the index to load the previous question
        currentQuestionIndex--;
        
        // Load the previous question
        loadQuestion(currentQuestionIndex);
        
        // Clear any previously selected answers
        buttonGroup1.clearSelection();
        
        // Check if the previous answer was already given and set the radio buttons accordingly
        AlreadyAnswered();
    } else {
        // Show a message if there are no previous questions
        JOptionPane.showMessageDialog(this, "This is the first question. No previous question available.", "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_previousbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Testpart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Testpart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Testpart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Testpart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Testpart().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Testpart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Loginoutbtn;
    private javax.swing.JButton Submitbtn;
    private javax.swing.JTextField Useridtf;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel courseidtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JButton previousbtn;
    // End of variables declaration//GEN-END:variables
}
