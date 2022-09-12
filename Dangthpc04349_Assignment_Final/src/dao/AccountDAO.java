package dao;

import Assignment_model.Account;
import Assignment_model.Standardization;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author TRẦN HỮU ĐANG
 */
public class AccountDAO {

    //List<Account> list = new ArrayList<>();
    String name;
    String user = "sa";
    String pass = "pc04349";
    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=qlpc;encrypt=false;";
    
    public List<Account> getAll() {
        List<Account> list = new ArrayList<>();
        list.clear();
//        list.add(new Account("Trần Hữu Đang", "admin", "123", "dangthpc04349@fpt.edu.vn", "Quản lí", true));
//        list.add(new Account("Trần Thị Mỹ Duyên", "duyenttm12", "duyen123", "duyenttmpc05508@fpt.edu.vn", "Nhân viên", true));
//        list.add(new Account("Nguyễn Thị Diễm Ngân", "nganmayy", "ngan123", "", "Nhân viên", true));
//        list.add(new Account("Đoàn Hiệp Sỹ", "hiepsylon", "123", "sydhpc@fpt.edu.vn", "Nhân viên", false));
//        list.add(new Account("Phùng Quốc Vinh", "vinhpq", "123", "vinhpqpc@fpt.edu.vn", "Nhân viên", true));
//        list.add(new Account("Lê thị Ngọc Hân", "hannah", "han123", "", "Nhân viên", true));
//        list.add(new Account("Nguyễn Khánh Đan", "danthoilai", "123", "dannkpc@fpt.edu.vn", "Nhân viên", false));
//        list.add(new Account("Lê Bích Vi", "bichve", "123", "vilbpc@fpt.edu.vn", "Nhân viên", false));
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsinhvien";

            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select * from TAIKHOAN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                /*
                String TENTAIKHOAN = rs.getString("TENTAIKHOAN");
                String TENDANGNHAP = rs.getString("TENDANGNHAP");
                String MATKHAU = rs.getString("MATKHAU");
                String EMAIL = rs.getString("EMAIL");
                String CHUCVU = rs.getString("CHUCVU");
                boolean TRANGTHAI = rs.getBoolean("TRANGTHAI");
                String QRCODE = rs.getString("QRCODE");
                 */
                String TENTAIKHOAN = rs.getString(1);
                String TENDANGNHAP = rs.getString(2);
                String MATKHAU = rs.getString(3);
                String EMAIL = rs.getString(4);
                String CHUCVU = rs.getString(5);
                boolean TRANGTHAI = rs.getBoolean(6);
                String QRCODE = rs.getString(7);
                //System.out.println(TENTAIKHOAN);
                list.add(new Account(TENTAIKHOAN, TENDANGNHAP, MATKHAU, EMAIL, CHUCVU, TRANGTHAI, QRCODE));
            }
            rs.close();
            con.close();
            //System.out.println(list.get(0).email);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Account> getEmail() {
        List<Account> list = new ArrayList<>();
        list.clear();
//        list.add(new Account("Trần Hữu Đang", "admin", "123", "dangthpc04349@fpt.edu.vn", "Quản lí", true));
//        list.add(new Account("Trần Thị Mỹ Duyên", "duyenttm12", "duyen123", "duyenttmpc05508@fpt.edu.vn", "Nhân viên", true));
//        list.add(new Account("Nguyễn Thị Diễm Ngân", "nganmayy", "ngan123", "", "Nhân viên", true));
//        list.add(new Account("Đoàn Hiệp Sỹ", "hiepsylon", "123", "sydhpc@fpt.edu.vn", "Nhân viên", false));
//        list.add(new Account("Phùng Quốc Vinh", "vinhpq", "123", "vinhpqpc@fpt.edu.vn", "Nhân viên", true));
//        list.add(new Account("Lê thị Ngọc Hân", "hannah", "han123", "", "Nhân viên", true));
//        list.add(new Account("Nguyễn Khánh Đan", "danthoilai", "123", "dannkpc@fpt.edu.vn", "Nhân viên", false));
//        list.add(new Account("Lê Bích Vi", "bichve", "123", "vilbpc@fpt.edu.vn", "Nhân viên", false));
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //String url = "jdbc:sqlserver://localhost:1433;databaseName=qlsinhvien";

            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select tendangnhap,email,trangthai from TAIKHOAN";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                /*
                String TENTAIKHOAN = rs.getString("TENTAIKHOAN");
                String TENDANGNHAP = rs.getString("TENDANGNHAP");
                String MATKHAU = rs.getString("MATKHAU");
                String EMAIL = rs.getString("EMAIL");
                String CHUCVU = rs.getString("CHUCVU");
                boolean TRANGTHAI = rs.getBoolean("TRANGTHAI");
                String QRCODE = rs.getString("QRCODE");
                */
                
                //String TENTAIKHOAN = rs.getString(1);
                String TENDANGNHAP = rs.getString(1);
                //String MATKHAU = rs.getString(3);
                String EMAIL = rs.getString(2);
                //String CHUCVU = rs.getString(5);
                boolean TRANGTHAI = rs.getBoolean(3);
                //String QRCODE = rs.getString(7);
                //System.out.println(TENTAIKHOAN);
                list.add(new Account(TENDANGNHAP, EMAIL, TRANGTHAI));
            }
            rs.close();
            con.close();
            //System.out.println(list.get(0).email);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    /*
    public addAccountDAO() {
        list.add(new Account("Trần Hữu Đang", "123", "123", "Quản lí", true));
        list.add(new Account("Trần Thị Mỹ Duyên", "duyenttm12", "duyen123", "Nhân viên", true));
        list.add(new Account("Đoàn Hiệp Sỹ", "king", "123", "Nhân viên", false));
        list.add(new Account("Nguyễn Thị Diễm Ngân", "nganntd09", "ngan123", "Nhân viên", true));
        list.add(new Account("Lê thị Ngọc Hân", "hanltn26", "han123", "Nhân viên", true));
        list.add(new Account("Nguyễn Khánh Đan", "dannk", "123", "Nhân viên", true));
        list.add(new Account("Phùng Quốc Vinh", "vinhpq", "123", "Nhân viênadmin", true));
        list.add(new Account("Lê Bích Vi", "vilb", "123", "Nhân viên", false));
    }*/
    public String checkLoginFirts(String username, String password) {
        AccountDAO accDAO = new AccountDAO();
        //chỉ return về "nhan vien" hoặc "quan li"
        for (Account account : accDAO.getAll()) {
            if (account.isTrangThai()) {
                if (account.getTenDangNhap().equals(username) && account.getMaKhau().equals(password)) {
                    if (account.getChucVu().equalsIgnoreCase("Quản lí")) {
                        return "quan li";
                    }
                    if (account.getChucVu().equalsIgnoreCase("Nhân viên")) {
                        return "nhan vien";
                    }
                }
            }
        }
        return "";
    }
    
    public String checkLogin(String username, String password) {
        AccountDAO accDAO = new AccountDAO();
        for (Account acc : accDAO.getAll()) {
            if (acc.getTenDangNhap().equalsIgnoreCase(username) && acc.getMaKhau().equals(password)) {
                if (acc.isTrangThai()) {
                    return acc.getChucVu().trim();
                }
            }
        }
        return "";
    }
    
    public String checkQR(String code) {
        AccountDAO accDAO = new AccountDAO();
        for (Account acc : accDAO.getAll()) {
            if (acc.getQrCode().equals(code)) {
                if (acc.isTrangThai()) {
                    return acc.getChucVu().trim();
                } else {
                    return "tài khoản không khả dụng!";
                }
            }
        }
        return "";
    }
    
    public void addAccount(String tenNguoiDung, String tenDangNhap, String matKhau, String email, String chucVu, boolean trangThai, String qrCode) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "insert into TAIKHOAN values(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenNguoiDung);
            st.setString(2, tenDangNhap);
            st.setString(3, matKhau);
            st.setString(4, email);
            st.setString(5, chucVu);
            st.setBoolean(6, trangThai);
            st.setString(7, qrCode);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Thêm thành công!");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void deleteAccount(String tenDangNhap) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "delete from TAIKHOAN where TENDANGNHAP = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenDangNhap);
            st.execute();
            //JOptionPane.showMessageDialog(this, "Delete thành công!");
            con.close();
            //return "";
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, "Error");
            //return String.valueOf(e);
        }
    }
    
    public void updateAccount(String tenNguoiDung, String tenDangNhap, String matKhau, String email, String chucVu, boolean trangThai) {
        AccountDAO accDAO = new AccountDAO();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "update TAIKHOAN set tentaikhoan=?,tendangnhap=?,matkhau =?,email=?,chucvu=?, trangthai=?  where tendangnhap = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenNguoiDung);
            st.setString(2, tenDangNhap);
            st.setString(3, matKhau);
            st.setString(4, email);
            st.setString(5, chucVu);
            st.setBoolean(6, trangThai);
            st.setString(7, tenDangNhap);
//            st.setString(7, qrCode);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Update thành công!");
            con.close();
            //LoadDataToArray();
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, "Error");
        }
    }
    
    public void updatePasswordAccount(String email, String matKhau) {
        AccountDAO accDAO = new AccountDAO();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "update TAIKHOAN set matkhau = ? where email = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, matKhau);
            st.setString(2, email);
//            st.setString(7, qrCode);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Update thành công!");
            con.close();
            //LoadDataToArray();
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, "Error");
        }
    }
    
    public List<Account> findByName(String name) {
        name = name.toLowerCase();
        List<Account> list = new ArrayList<>();
        AccountDAO accDAO = new AccountDAO();
        
        for (Account index : accDAO.getAll()) {
            String temp = index.getTenNguoiDung().toLowerCase();
            if (temp.contains(name)) {
                list.add(index);
            }
        }
        return list;
    }
    
    public String name(String username, String password) {
        AccountDAO accDAO = new AccountDAO();
        //return về tên tài khoản
        for (Account account : accDAO.getAll()) {
            if (account.isTrangThai()) {
                if (account.getTenDangNhap().equalsIgnoreCase(username) && account.getMaKhau().equals(password)) {
                    return account.getTenNguoiDung();
                }
            }
        }
        return "";
    }
    
    public String nameQR(String code) {
        AccountDAO accDAO = new AccountDAO();
        //return về tên tài khoản
        for (Account account : accDAO.getAll()) {
            if (account.isTrangThai()) {
                if (account.getQrCode().equals(code)) {
                    return account.getTenNguoiDung().trim();
                }
            }
        }
        return "";
    }
    
    public boolean checkMail(String email) {
        String reEmail = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        if (email.matches(reEmail)) {
            return true;
        }
        return false;
    }
    
    public String validate(String tenNguoiDung, String tenDangNhap, String matKhau, String email, String chucVu) {
        AccountDAO accDAO = new AccountDAO();
        Standardization std = new Standardization();
        for (Account account : accDAO.getAll()) {
            if (account.getTenDangNhap().equals(tenDangNhap)) {
                return "Tên đăng nhập đã tồn tại vui lòng dùng tên khác!";
            }
        }
        if (!std.hoTen(tenNguoiDung).equalsIgnoreCase(tenNguoiDung) || tenNguoiDung.equals("")) {
            return "Tên người dùng không hợp lệ!";
        }
        if (tenDangNhap.length() < 3 || tenDangNhap.length() > 15) {
            return "Tên đăng nhập phải từ 3-15 ký tự!";
        }
        if (matKhau.length() < 3 || matKhau.length() > 15) {
            return "Mật khẩu phải từ 3-15 kí tự";
        }
        if (!accDAO.checkMail(email)) {
            return "Email không hợp lệ!";
        }
        if(chucVu.equalsIgnoreCase("Quản trị")){
            return "Bạn không thể thao tác với tài khoản quản trị!";
        }
        //if (chucVu.equalsIgnoreCase("Quản lí") || chucVu.equalsIgnoreCase("Nhân viên"))

        return "";
    }
    
    public static void main(String[] args) {
        AccountDAO t = new AccountDAO();
        //System.out.println(t.getAll());
        //t.getAll();
        t.deleteAccount("bichvedfgh");
        //System.out.println(t.deleteAccount("bichvedfgh"));
        //System.out.println(t.checkLogin("admin", "123"));
    }
}
