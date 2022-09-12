package com.library.Extensisons;

import Assignment_model.Standardization;
import com.GUI.Login;
import com.GUI.PCManager;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import dao.AccountDAO;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JOptionPane;

public class ReadQR extends javax.swing.JFrame implements Runnable, ThreadFactory {

    private WebcamPanel panel = null;
    private Webcam webcam = null;

    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);

    public ReadQR() {
        initComponents();
        initWebcam();
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jlbUserName = new javax.swing.JLabel();
        btnClose = new javax.swing.JButton();
        btnClose1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lấy lại mật khẩu");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(85, 65, 118));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(250, 250, 250));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(230, 230, 230)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 470, 300));

        jlbUserName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlbUserName.setForeground(new java.awt.Color(57, 113, 177));
        jlbUserName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/library/icon/id-card.png"))); // NOI18N
        jlbUserName.setText("Đưa mã QR trước camera");
        jlbUserName.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                jlbUserNameComponentMoved(evt);
            }
        });
        jPanel1.add(jlbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 270, 40));

        btnClose.setBackground(new java.awt.Color(126, 87, 194));
        btnClose.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClose.setForeground(new java.awt.Color(204, 0, 0));
        btnClose.setText("Thoát");
        btnClose.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 150, 30));

        btnClose1.setBackground(new java.awt.Color(126, 87, 194));
        btnClose1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClose1.setForeground(new java.awt.Color(204, 0, 0));
        btnClose1.setText("Đăng nhập bằng mật khẩu");
        btnClose1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClose1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClose1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnClose1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 250, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 440));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlbUserNameComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jlbUserNameComponentMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbUserNameComponentMoved

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        webcam.close();
        this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnClose1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClose1ActionPerformed
       Login login = new Login();
       login.setVisible(true);
       webcam.close();
       this.dispose();
    }//GEN-LAST:event_btnClose1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadQR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ReadQR().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnClose1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlbUserName;
    // End of variables declaration//GEN-END:variables

    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
        webcam = Webcam.getWebcams().get(0); //0 is default webcam
        webcam.setViewSize(size);

        panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        panel.setFPSDisplayed(true);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 300));

        executor.execute(this);
    }

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Result result = null;
            BufferedImage image = null;

            if (webcam.isOpen()) {
                if ((image = webcam.getImage()) == null) {
                    continue;
                }
            }
            
            if(!webcam.isOpen()){
                return;
            }
            
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            try {
                result = new MultiFormatReader().decode(bitmap);
            } catch (NotFoundException e) {
                //System.out.println("");
            }

            if (result != null) {
                System.out.println(result.getText());
                //result_field.setText(result.getText());
                AccountDAO accDAO = new AccountDAO();
                Standardization std = new Standardization();
                String ketQua = accDAO.checkQR(result.getText());
                System.out.println(ketQua);
                if (ketQua.equals("Nhân viên")) {
                    PCManager pc = new PCManager(false,false, std.hightlingtName(accDAO.nameQR(result.getText())));
                    
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!\n"+"Xin chào: \t"+std.hightlingtName(accDAO.nameQR(result.getText())));
                    this.dispose();
                    pc.setVisible(true);
                    webcam.close();
                    return;
                } else if (ketQua.equals("Quản lí")) {
                    //JOptionPane.showMessageDialog(this, "Đăng nhập thành công với vai trò quản lí!");
                    PCManager pc = new PCManager(false,true, std.hightlingtName(accDAO.nameQR(result.getText())) );
                    
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!\n"+"Xin chào: \t"+std.hightlingtName(accDAO.nameQR(result.getText())));
                    this.dispose();
                    pc.setVisible(true);
                    webcam.close();
                    return;
                }else if (ketQua.equals("Quản trị")) {
                    //JOptionPane.showMessageDialog(this, "Đăng nhập thành công với vai trò quản lí!");
                    PCManager pc = new PCManager(true,true, std.hightlingtName(accDAO.nameQR(result.getText())) );
                    
                    JOptionPane.showMessageDialog(this, "Đăng nhập thành công!\n"+"Xin chào: \t"+std.hightlingtName(accDAO.nameQR(result.getText())));
                    this.dispose();
                    pc.setVisible(true);
                    webcam.close();
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Mã không hợp lệ hoặc tài khoản đã bị khóa!");
                    JOptionPane.showMessageDialog(this,std.hightlingtName(accDAO.nameQR(result.getText())));
                }
                //JOptionPane.showMessageDialog(this, "Đăng nhập thành công!\n"+"Xin chào: \t"+std.hightlingtName(accDAO.nameQR(result.getText())));
            }
        } while (true);
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "My Thread");
        t.setDaemon(true);
        return t;
    }
}
