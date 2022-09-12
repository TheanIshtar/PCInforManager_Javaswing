package com.GUI;

import Assignment_model.Account;
import dao.AccountDAO;
import Assignment_model.Standardization;
import com.library.Extensisons.ReadQR;
import com.library.QRMail.ReadQRCode;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import javax.swing.ImageIcon;

/**
 *
 * @author dangt
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public boolean loading = false;
    List<Account> listAccount = new ArrayList<>();
    AccountDAO accDAO = new AccountDAO();
    
    public void layLaiMatKhau() {

        return;
    }
    
    public void cloneEmailAccount(){
        listAccount.clear();
        for(Account index: accDAO.getEmail()){
            listAccount.add(index);
        }
    }
    
    public int checkAccountEmail(String email){
        for(Account index:listAccount){
            if(index.getEmail().equalsIgnoreCase(email)){
                if(index.isTrangThai()){
                    return 1;
                }
                return 2;
            }
        }
        return 0;
    }
    
    public String getMailAccount(String tendangnhap){
        for(Account index:listAccount){
            if(index.getTenDangNhap().equalsIgnoreCase(tendangnhap)){
                return index.getEmail();
            }
        }
        return "";
    }
    
    public void changePassword() throws IOException{
        if(txtUsername.equals(""))
            return;
        int checkAccount = checkAccountEmail(getMailAccount(txtUsername.getText()));
        if(checkAccount==0){
            JOptionPane.showMessageDialog(this, "Tài khoản này chưa được đăng ký!");
        } else if(checkAccount==2){
            JOptionPane.showMessageDialog(this, "Tài khoản này tạm thời bị khóa\nVui lòng liên hệ quản lí để được mở!");
        } else {
            String mail = getMailAccount(txtUsername.getText());
            int ketQua = JOptionPane.showConfirmDialog(this, mail+"\nĐịa chỉ Email này có phải của bạn không?", "Xác nhận email", JOptionPane.YES_OPTION);
            if (ketQua == JOptionPane.YES_OPTION) {
                ReadQRCode readQR = new ReadQRCode(mail);
                JOptionPane.showMessageDialog(this, "Mã xác nhận đã được gửi tới email của bạn\nVui lòng kiểm tra lại email...!");
                readQR.setVisible(true);
                this.dispose();
                /*
                SendQR qr = new SendQR();
                qr.sendcode(mail);
                Changepassword change = new Changepassword(mail);
                change.setVisible(true);
                */
            }
            
        }
    }

    public void checkLogin() {
        if (txtPassword.getText().equals("")) {
            //JOptionPane.showMessageDialog(this, "Vui lòng nhập Password!");
            //txtUsername.setBackground(Color.white);
            //txtPassword.setBackground(Color.pink);
            //txtErrorPassWord.setText("Required field");
            //txtErrorUserName.setText("");
            txtErrorPassWord.setVisible(true);
            txtPassword.requestFocus();
        }
        if (txtUsername.getText().equals("")) {
            txtErrorUserName.setVisible(true);
            txtUsername.requestFocus();
        } else {
            txtErrorUserName.setVisible(false);
            txtErrorPassWord.setVisible(false);
            AccountDAO accDAO = new AccountDAO();
            Standardization std = new Standardization();
            String ketQua = accDAO.checkLogin(txtUsername.getText(), txtPassword.getText());
            if (ketQua.equalsIgnoreCase("Nhân viên")) {
                PCManager pc = new PCManager(false,false, std.hightlingtName(accDAO.name(txtUsername.getText(), txtPassword.getText())));
                pc.setVisible(true);
                this.dispose();
                return;
            } else if (ketQua.endsWith("Quản lí")) {
                PCManager pc = new PCManager(false,true, std.hightlingtName(accDAO.name(txtUsername.getText(), txtPassword.getText())));
                pc.setVisible(true);
                this.dispose();
                return;
            } else if (ketQua.equalsIgnoreCase("Quản trị")) {
                PCManager pc = new PCManager(true,true, std.hightlingtName(accDAO.name(txtUsername.getText(), txtPassword.getText())));
                pc.setVisible(true);
                this.dispose();
                return;
            }else {
                JOptionPane.showMessageDialog(this, "Tên đăng nhập hoặc Mật khẩu không chính xác!");
                txtUsername.requestFocus();
                return;
            }
        }
    }

    public Login() {
        initComponents();
        runFont();
        txtErrorPassWord.setVisible(false);
        txtErrorUserName.setVisible(false);
        echoPassword();
        lblCapslock.setText("");
        cloneEmailAccount();
    }

    public void runFont() {
        Thread threadl = new Thread() {
            @Override
            public void run() {
                String txt = " " + jblRun.getText() + " ";
                while (true) {
                    txt = txt.substring(1, txt.length()) + txt.charAt(0);
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    jblRun.setText(txt);
                }
            }

        };
        threadl.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jplMain = new javax.swing.JPanel();
        jplLose = new javax.swing.JPanel();
        jlbClose = new javax.swing.JLabel();
        jplLogin = new javax.swing.JPanel();
        jblLogin = new javax.swing.JLabel();
        jlbHide = new javax.swing.JLabel();
        jlbShow = new javax.swing.JLabel();
        jlbUserName = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtErrorUserName = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jlbPassWord = new javax.swing.JLabel();
        txtErrorPassWord = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jplState = new javax.swing.JPanel();
        jlbState = new javax.swing.JLabel();
        lblCapslock = new javax.swing.JLabel();
        jplContainer = new javax.swing.JPanel();
        jblImage = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jblRun = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jplMain.setBackground(new java.awt.Color(64, 43, 100));
        jplMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jplLose.setBackground(new java.awt.Color(85, 65, 118));
        jplLose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jplLoseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jplLoseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jplLoseMouseExited(evt);
            }
        });
        jplLose.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbClose.setFont(new java.awt.Font("Segoe UI Semilight", 1, 18)); // NOI18N
        jlbClose.setForeground(new java.awt.Color(255, 255, 255));
        jlbClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbClose.setText(" X");
        jlbClose.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jlbCloseFocusGained(evt);
            }
        });
        jlbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbCloseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbCloseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbCloseMouseExited(evt);
            }
        });
        jplLose.add(jlbClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 30));

        jplMain.add(jplLose, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 0, 60, -1));

        jplLogin.setBackground(new java.awt.Color(85, 65, 118));
        jplLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblLogin.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jblLogin.setForeground(new java.awt.Color(57, 113, 177));
        jblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/businessman.png"))); // NOI18N
        jblLogin.setText("Đăng nhập");
        jplLogin.add(jblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 290, -1));

        jlbHide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/hide.png"))); // NOI18N
        jlbHide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbHideMouseClicked(evt);
            }
        });
        jplLogin.add(jlbHide, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        jlbShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/show.png"))); // NOI18N
        jlbShow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbShowMouseClicked(evt);
            }
        });
        jplLogin.add(jlbShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, -1, -1));

        jlbUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbUserName.setForeground(new java.awt.Color(57, 113, 177));
        jlbUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/id-card.png"))); // NOI18N
        jlbUserName.setText("Tên đăng nhập");
        jlbUserName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jlbUserNameComponentMoved(evt);
            }
        });
        jplLogin.add(jlbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 220, 40));

        txtUsername.setBackground(new java.awt.Color(85, 65, 118));
        txtUsername.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(255, 255, 255));
        txtUsername.setBorder(null);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
        });
        txtUsername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtUsernameMouseClicked(evt);
            }
        });
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        txtUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsernameKeyPressed(evt);
            }
        });
        jplLogin.add(txtUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 340, 30));
        jplLogin.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 340, 10));

        txtErrorUserName.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        txtErrorUserName.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorUserName.setText("Không hợp lệ");
        jplLogin.add(txtErrorUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 120, 17));

        txtPassword.setBackground(new java.awt.Color(85, 65, 118));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setBorder(null);
        txtPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPasswordMouseClicked(evt);
            }
        });
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jplLogin.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 310, 30));

        jlbPassWord.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbPassWord.setForeground(new java.awt.Color(102, 102, 102));
        jlbPassWord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/password.png"))); // NOI18N
        jlbPassWord.setText("Mật khẩu");
        jplLogin.add(jlbPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 140, 30));

        txtErrorPassWord.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        txtErrorPassWord.setForeground(new java.awt.Color(255, 0, 0));
        txtErrorPassWord.setText("Không hợp lệ");
        jplLogin.add(txtErrorPassWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 180, 17));

        btnLogin.setBackground(new java.awt.Color(126, 87, 194));
        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jplLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 130, 30));
        jplLogin.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 340, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bạn quên mật khẩu? Click để lấy lại mật khẩu");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jplLogin.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 480, 300, 20));

        btnHelp.setBackground(new java.awt.Color(126, 87, 194));
        btnHelp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setText("Đăng nhập với QR");
        btnHelp.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        jplLogin.add(btnHelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 170, 30));

        jplState.setBackground(new java.awt.Color(85, 65, 118));

        jlbState.setFont(new java.awt.Font("Baskerville Old Face", 1, 48)); // NOI18N
        jlbState.setForeground(new java.awt.Color(255, 255, 255));
        jlbState.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbState.setText("-");
        jlbState.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jlbStateFocusGained(evt);
            }
        });
        jlbState.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbStateMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jlbStateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jlbStateMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jplStateLayout = new javax.swing.GroupLayout(jplState);
        jplState.setLayout(jplStateLayout);
        jplStateLayout.setHorizontalGroup(
            jplStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbState, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );
        jplStateLayout.setVerticalGroup(
            jplStateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jplStateLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbState, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jplLogin.add(jplState, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, 60, 30));

        lblCapslock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCapslock.setForeground(new java.awt.Color(0, 153, 0));
        lblCapslock.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblCapslock.setText("jLabel3");
        jplLogin.add(lblCapslock, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, 170, 20));

        jplMain.add(jplLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 580, 550));

        jplContainer.setBackground(new java.awt.Color(64, 43, 100));
        jplContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jblImage.setForeground(new java.awt.Color(255, 255, 255));
        jblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/slogan.png"))); // NOI18N
        jplContainer.add(jblImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 210, 220));

        jLabel2.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 255));
        jLabel2.setText("như yêu vợ bạn !!!");
        jplContainer.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 250, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 255));
        jLabel4.setText("Chúng tôi yêu laptop");
        jplContainer.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 250, 50));

        jblRun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jblRun.setForeground(new java.awt.Color(102, 255, 153));
        jblRun.setText("  Phần mềm bản quyền của Trần Hữu Đang  ");
        jplContainer.add(jblRun, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 290, 20));

        jplMain.add(jplContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jplMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jplLoseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jplLoseMouseExited
        // TODO add your handling code here:
        jplLose.setBackground(new Color(204, 204, 204));
    }//GEN-LAST:event_jplLoseMouseExited

    private void jplLoseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jplLoseMouseEntered
        jplLose.setBackground(Color.red);
        //jlbClose.setForeground(Color.white);
    }//GEN-LAST:event_jplLoseMouseEntered

    private void jplLoseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jplLoseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jplLoseMouseClicked

    private void jlbCloseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCloseMouseExited
        // TODO add your handling code here:
        jplLose.setBackground(new Color(85, 65, 118));
    }//GEN-LAST:event_jlbCloseMouseExited

    private void jlbCloseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCloseMouseEntered
        // TODO add your handling code here:
        jplLose.setBackground(Color.red);
    }//GEN-LAST:event_jlbCloseMouseEntered

    private void jlbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbCloseMouseClicked
        if(!txtUsername.getText().equals("")|| !txtPassword.getText().equals("")){
            int ketQua = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thoát khỏi chương trình?", "Thoát chương trình", JOptionPane.YES_NO_OPTION);
                if (ketQua == JOptionPane.YES_OPTION) {
                   System.exit(0);
                }
        } else {
            System.exit(0);
        }
        
    }//GEN-LAST:event_jlbCloseMouseClicked

    private void jlbCloseFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlbCloseFocusGained
        //jplLose.setBackground(Color.red);
        System.exit(0);
    }//GEN-LAST:event_jlbCloseFocusGained

    private void jlbUserNameComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jlbUserNameComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbUserNameComponentMoved

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        //jlbUsername.setForeground(Color.blue);
        //        jlbUserName.setForeground(new Color(57,113,177));
        //        jlbPassWord.setForeground(new Color(102,102,102));
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsernameMouseClicked
        jlbPassWord.setForeground(new Color(102, 102, 102));
        jlbUserName.setForeground(new Color(57, 113, 177));
        txtErrorUserName.setVisible(false);
    }//GEN-LAST:event_txtUsernameMouseClicked

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        jlbPassWord.setForeground(new Color(102, 102, 102));
        jlbUserName.setForeground(new Color(57, 113, 177));

    }//GEN-LAST:event_txtUsernameActionPerformed

    private void txtUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jlbPassWord.setForeground(new Color(57, 113, 177));
            jlbUserName.setForeground(new Color(102, 102, 102));
            txtPassword.requestFocus();
        }
    }//GEN-LAST:event_txtUsernameKeyPressed

    public void echoPassword(){
        jlbHide.setVisible(true);
        jlbShow.setVisible(false);
        txtPassword.setEchoChar('●');
    }
    
    private void jlbHideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbHideMouseClicked
        //        txtPassword.setVisible(true);
        //        jlbShowPassword.setVisible(false);
        //        //password_temp = txtPassword.getText();
        jlbHide.setVisible(false);
        //        //jlbHidePassword.setVisible(false);
        //        //jlbShowPassword.setVisible(false);
        //        txtPassword.setText(password_temp);
        jlbShow.setVisible(true);
        txtPassword.setEchoChar((char) 0);
        //jlbUserName.setForeground(new Color(102, 102, 102));
        //jlbPassWord.setForeground(new Color(57, 113, 177));
        //txtErrorPassWord.setVisible(false);
        //
        
        
        
    }//GEN-LAST:event_jlbHideMouseClicked

    private void jlbShowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbShowMouseClicked
        
        txtPassword.setEchoChar('●');
        //        password_temp = txtPassword.getText();
        //        txtPassword.setVisible(false);
        //        jlbShowPassword.setText(txtPassword.getText());
        //        jlbShowPassword.setVisible(true);
        //        txtPassword.setText("");
        
        jlbShow.setVisible(false);
        jlbHide.setVisible(true);
        //jlbUserName.setForeground(new Color(102, 102, 102));
        //jlbPassWord.setForeground(new Color(57, 113, 177));
        //txtErrorPassWord.setVisible(false);
        //btnAdd.doClick();
    }//GEN-LAST:event_jlbShowMouseClicked

    private void txtPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPasswordMouseClicked
        // TODO add your handling code here:
        jlbUserName.setForeground(new Color(102, 102, 102));
        jlbPassWord.setForeground(new Color(57, 113, 177));
        txtErrorPassWord.setVisible(false);
    }//GEN-LAST:event_txtPasswordMouseClicked

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        boolean isOn = Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK);
                if (isOn == true) {
                    lblCapslock.setText("Caps lock ON");
                } else {
                    lblCapslock.setText("");
                }
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnLogin.doClick();
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        checkLogin();

    }//GEN-LAST:event_btnLoginActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        try {
            changePassword();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //ReadQRCode newPassword = new ReadQRCode();
        //newPassword.setVisible(true);
        //this.dispose();
        //Register();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        ReadQR frame = new ReadQR();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnHelpActionPerformed

    private void jlbStateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jlbStateFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbStateFocusGained

    private void jlbStateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbStateMouseClicked
        this.setState(1);
    }//GEN-LAST:event_jlbStateMouseClicked

    private void jlbStateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbStateMouseEntered
        jplState.setBackground(new Color(229, 221, 242));
        jlbState.setForeground(Color.black);
    }//GEN-LAST:event_jlbStateMouseEntered

    private void jlbStateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbStateMouseExited
        jplState.setBackground(new Color(85, 65, 118));
        jlbState.setForeground(Color.white);
    }//GEN-LAST:event_jlbStateMouseExited

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel jblImage;
    private javax.swing.JLabel jblLogin;
    private javax.swing.JLabel jblRun;
    private javax.swing.JLabel jlbClose;
    private javax.swing.JLabel jlbHide;
    private javax.swing.JLabel jlbPassWord;
    private javax.swing.JLabel jlbShow;
    private javax.swing.JLabel jlbState;
    private javax.swing.JLabel jlbUserName;
    private javax.swing.JPanel jplContainer;
    private javax.swing.JPanel jplLogin;
    private javax.swing.JPanel jplLose;
    private javax.swing.JPanel jplMain;
    private javax.swing.JPanel jplState;
    private javax.swing.JLabel lblCapslock;
    private javax.swing.JLabel txtErrorPassWord;
    private javax.swing.JLabel txtErrorUserName;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
