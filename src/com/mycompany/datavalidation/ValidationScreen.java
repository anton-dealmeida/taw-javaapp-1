package com.mycompany.datavalidation;

// import com.mycompany.datavalidation.*;
import javax.swing.JOptionPane;

public class ValidationScreen extends javax.swing.JFrame {

    public ValidationScreen() {
        initComponents();
    }

    private void initComponents() {

        lblEmail = new javax.swing.JLabel();
        lblHeadline = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtDate = new com.github.lgooddatepicker.components.DatePicker();
        lblDate = new javax.swing.JLabel();
        chkKeepSignedIn = new javax.swing.JRadioButton();
        bnConfirm = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        lblErrorEmail = new javax.swing.JLabel();
        lblErrorPassword = new javax.swing.JLabel();
        lblErrorDate = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblPassword1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEmail.setText("Email:");

        lblHeadline.setText("BridgeHouse Account");

        lblPassword.setText("Password:");

        lblDate.setText("Date:");

        chkKeepSignedIn.setText("Keep me singed in ");

        bnConfirm.setText("Confirm");
        bnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnConfirmActionPerformed(evt);
            }
        });

        lblPassword1.setText("Confirm Password:");

        // Layout-related code
        // ...
    }

    private void bnConfirmActionPerformed(java.awt.event.ActionEvent evt) {
        String email = txtEmail.getText();
        String password = new String(txtPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        String date = txtDate.getText();
        boolean keepSignedIn = chkKeepSignedIn.isSelected();

        boolean isValidEmail = DataValidation.validateEmail(email);
        boolean isValidPassword = DataValidation.validatePassword(password, confirmPassword);
        boolean isValidDate = DataValidation.validateDate(date);

        if (isValidEmail && isValidPassword && isValidDate) {
            JOptionPane.showMessageDialog(this, "All fields are valid.");
            if (keepSignedIn) {
                JOptionPane.showMessageDialog(this, "User selected 'Keep me signed in'.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "One or more fields are invalid.");
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ValidationScreen().setVisible(true);
            }
        });
    }

    // Variables declaration
    private javax.swing.JButton bnConfirm;
    private javax.swing.JRadioButton chkKeepSignedIn;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblErrorDate;
    private javax.swing.JLabel lblErrorEmail;
    private javax.swing.JLabel lblErrorPassword;
    private javax.swing.JLabel lblHeadline;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblPassword1;
    private javax.swing.JPasswordField txtConfirmPassword;
    private com.github.lgooddatepicker.components.DatePicker txtDate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration
}
