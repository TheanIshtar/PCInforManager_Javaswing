/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Assignment_model.InforPC;
import Assignment_model.PCModel;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;
import java.util.List;
import Assignment_model.Account;
import Assignment_model.Standardization;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dangt
 */
public class InforPCDAO {

    String user = "sa";
    String pass = "pc04349";
    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=qlpc;encrypt=false;";

    public boolean validateProductCode(String code) {
        InforPCDAO pc = new InforPCDAO();
        for (InforPC index : pc.getAll()) {

            if (code.equalsIgnoreCase(index.getMaSP())) {
                return false;
            }
        }
        return true;
    }

    public boolean validateModelCode(String code) {
        PCModelDAO model = new PCModelDAO();
        for (PCModel index : model.getAll()) {
            if (code.equalsIgnoreCase(index.getMaHang())) {
                return true;
            }
        }
        return false;
    }

    public void addInforAccount(String maSP, String maHang, String tenSP, String hinhAnh, String heDieuHanh, String cpu, String doHoa,
            String pin, Float khoiLuong, String manHinh, String ram, String oDia, Integer soLuong, Integer gia, String noiSanXuat, String mauSac,String tenNguoiDung) {
        InforPCDAO pc = new InforPCDAO();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "insert into SANPHAM values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maSP);
            st.setString(2, maHang);
            st.setString(3, tenSP);
            st.setString(4, hinhAnh);
            st.setString(5, heDieuHanh);
            st.setString(6, cpu);
            st.setString(7, doHoa);
            st.setString(8, pin);
            st.setFloat(9, khoiLuong);
            st.setString(10, manHinh);
            st.setString(11, ram);
            st.setString(12, oDia);
            st.setInt(13, soLuong);
            st.setInt(14, gia);
            st.setString(15, noiSanXuat);
            st.setString(16, mauSac);
            st.setString(17, tenNguoiDung);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Thêm thành công!");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updateInforAccount(String maSP, String maHang, String tenSP, String hinhAnh, String heDieuHanh, String cpu, String doHoa,
            String pin, Float khoiLuong, String manHinh, String ram, String oDia, Integer soLuong, Integer gia, String noiSanXuat, String mauSac, String tenNguoiDung) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "update SANPHAM set MAHANG=?,TENSANPHAM=?,HINHANH=?,HEDIEUHANH=?,CPU=?,CARDDOHOA=?,PIN=?,TRONGLUONG=?,MANHINH=?,RAM=?,"
                    + " ODIA=?,SOLUONG=?,GIA=?,NOISANXUAT=?,MAUSAC=?, TENNGUOIDUNG =? where MASANPHAM = ?";
            PreparedStatement st = con.prepareStatement(sql);
            //st.setString(1, maSP);
            st.setString(1, maHang);
            st.setString(2, tenSP);
            st.setString(3, hinhAnh);
            st.setString(4, heDieuHanh);
            st.setString(5, cpu);
            st.setString(6, doHoa);
            st.setString(7, pin);
            st.setFloat(8, khoiLuong);
            st.setString(9, manHinh);
            st.setString(10, ram);
            st.setString(11, oDia);
            st.setInt(12, soLuong);
            st.setInt(13, gia);
            st.setString(14, noiSanXuat);
            st.setString(15, mauSac);
            st.setString(16, maSP);
            st.setString(17, tenNguoiDung);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Update thành công!");
            con.close();
            //LoadDataToArray();
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, "Error");
        }
    }
    
    public void deleteInforPC(String maSP) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "delete from SANPHAM where MASANPHAM = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maSP);
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

    //List<InforPC> list = new ArrayList<>();
    /*
    public List<InforPC> getAll(){
        List<InforPC> list = new ArrayList<>();
        //list.clear();
        list.add(new InforPC("PC001", "DELL Latutade 354", "DELL", "", "Windows 10 Pro", "Intel Core i5, 2.70 GHz, 12MB", "Card rời - NVIDIA GeForce RTX3050, 4 GB", "3-cell Li-ion, 56 Wh", (float) 2.81, "15.6 inch, Full HD (1920 x 1080)", "DDR4, 32GB", "256 GB SSD NVMe PCIe", 320, 29000000, "Nhật bản", "đỏ-đen"));
        list.add(new InforPC("PC002", "DELL Gaming G15", "DELL", "", "Windows 10 Pro", "Intel Core i7, 2.70 GHz, 12MB", "Card rời - NVIDIA GeForce RTX3050, 4 GB", "3-cell Li-ion, 40 Wh", (float) 3.2, "15.6 inch, Full HD (1920 x 1080)", "DDR4, 32GB", "256 GB SSD NVMe PCIe", 150, 32000000, "Trung quốc", "xanh-đen"));
        list.add(new InforPC("PC003", "Lenovo legion 5 ", "LENOVO", "", "Windows 10 Home", "Intel Core i5, 2.70 GHz, 12MB", "Card rời - NVIDIA GeForce RTX3050, 4 GB", "3-cell Li-ion, 34 Wh", (float) 2.81, "15.6 inch, Full HD (1920 x 1080)", "DDR4, 32GB", "256 GB SSD NVMe PCIe", 320, 29000000, "Nhật bản", "đỏ-đen"));
        list.add(new InforPC("PC004", "DELL Dell Gaming G15", "DELL", "", "Windows 10 Pro", "Intel Core i7, 2.70 GHz, 12MB", "Card rời - NVIDIA GeForce RTX3050, 4 GB", "3-cell Li-ion, 56 Wh", (float) 1.7, "15.6 inch, Full HD (1920 x 1080)", "DDR4, 32GB", "256 GB SSD NVMe PCIe", 150, 32000000, "Việt nam", "đen"));
        list.add(new InforPC("PC005", "HP envy 13", "HP", "", "Windows 10 Home", "Intel Core i5, 2.70 GHz, 12MB", "NIKLYZ GeForce RTX3050, 4 GB", "3-cell Li-ion, 50 Wh", (float) 2.81, "15.6 inch, Full HD (1920 x 1080)", "DDR4, 32GB", "256 GB SSD NVMe PCIe", 320, 29000000, "Nhật bản", "đỏ-đen"));
        list.add(new InforPC("PC006", "ASUS Gaming G15", "ASUS", "", "Windows 10 Home", "Intel Core i7, 2.70 GHz, 12MB", "Card rời - NVIDIA GeForce RTX3050, 4 GB", "3-cell Li-ion, 72 Wh", (float) 2.81, "15.6 inch, Full HD (1920 x 1080)", "DDR4, 32GB", "256 GB SSD NVMe PCIe", 150, 32000000, "Trung quốc", "xanh-đen"));
        return list;
    }
     */
    public List<InforPC> getAll() {
        List<InforPC> list = new ArrayList<>();
        //list.clear();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select a.*, b.TENHANG from SANPHAM a, HANG b where a.MAHANG = b.MAHANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MASANPHAM = rs.getString(1);
                String MAHANG = rs.getString(2);
                String TENSANPHAM = rs.getString(3);
                String HINHANH = rs.getString(4);
                String HEDIEUHANH = rs.getString(5);
                String CPU = rs.getString(6);
                String CARDDOHOA = rs.getString(7);
                String PIN = rs.getString(8);
                Float TRONGLUONG = rs.getFloat(9);
                String MANHINH = rs.getString(10);
                String RAM = rs.getString(11);
                String ODIA = rs.getString(12);
                Integer SOLUONG = rs.getInt(13);
                Integer GIA = rs.getInt(14);
                String NOISANXUAT = rs.getString(15);
                String MAUSAC = rs.getString(16);
                String TENTAIKHOAN = rs.getString(17);
                String TENHANG = rs.getString(18);
                //System.out.println(TENSANPHAM);
                //list.add(new PCModel(MAHANG, TENHANG));
                list.add(new InforPC(MASANPHAM, MAHANG, TENSANPHAM, HINHANH, HEDIEUHANH, CPU, CARDDOHOA, PIN, TRONGLUONG, MANHINH, RAM, ODIA, SOLUONG, GIA, NOISANXUAT, MAUSAC, TENHANG,TENTAIKHOAN));
            }
            rs.close();
            con.close();
            //System.out.println(list.get(0).email);
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }

    public List<InforPC> findByName(String name) {
        name = name.toLowerCase();
        List<InforPC> list = new ArrayList<>();
        InforPCDAO inforPCDAO = new InforPCDAO();
        for (InforPC index : inforPCDAO.getAll()) {
            String temp = index.getTenSP().toLowerCase();
            if (temp.contains(name)) {
                list.add(index);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        InforPCDAO pc = new InforPCDAO();
        //pc.addInforAccount("ab", "d03", "Dell", "", "window", "cpu", "ih", "iujh", Float.valueOf(45), "yh", "hh", "uj", 4, 5, "iuj", "ujh");
    }

//    private void addInforAccount(String ab, String d03, String dell, String string, String window, String cpu, String ih, String iujh, int i, String yh, String hh, String uj, int i0, int i1, String iuj, String ujh) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
