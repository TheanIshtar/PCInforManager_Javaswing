/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Assignment_model.PCModel;
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
import javax.swing.JOptionPane;

/**
 *
 * @author dangt
 */
public class PCModelDAO {

    String user = "sa";
    String pass = "pc04349";
    String url = "jdbc:sqlserver://localhost:1433;" + "databaseName=qlpc;encrypt=false;";

    /*public List<PCModel> getAll() {
        List<PCModel> list = new ArrayList<>();
        list.clear();
        list.add(new PCModel("D03", "DELL"));
        list.add(new PCModel("M51", "MSI"));
        list.add(new PCModel("A5U5", "ASUS"));
        list.add(new PCModel("L3N050", "LENOVO"));
        list.add(new PCModel("H10", "HP"));
        list.add(new PCModel("L6", "LG"));
        return list;
    }*/

    public List<PCModel> getAll() {
        List<PCModel> list = new ArrayList<>();
        list.clear();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "select * from HANG";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String MAHANG = rs.getString(1);
                String TENHANG = rs.getString(2);
                //System.out.println(TENTAIKHOAN);
                list.add(new PCModel(MAHANG, TENHANG));
                //System.out.println(MAHANG);
            }
            rs.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<PCModel> findByName(String name) {
        PCModelDAO model = new PCModelDAO();
        name = name.toLowerCase();
        List<PCModel> list = new ArrayList<>();
        for (PCModel index : model.getAll()) {
            String temp = index.getTenHang().toLowerCase();
            if (temp.contains(name)) {
                list.add(index);
            }
        }
        return list;
    }
    
    public boolean validate(String maHangSX){
       // PCModel model = new PCModel();
        PCModelDAO modelDAO = new PCModelDAO();
        for(PCModel index:modelDAO.getAll()){
            if(index.getMaHang().equalsIgnoreCase(maHangSX)){
                return true;
            }
        }
        return false;
    }
    
    public void addPCModel(String maHang, String tenHang) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "insert into HANG values(?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maHang);
            st.setString(2, tenHang);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Thêm thành công!");
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updatePCModel(String maHang, String tenHang) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "update HANG set TENHANG=?  where MAHANG = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, tenHang);
            st.setString(2, maHang);
            st.executeUpdate();
            //JOptionPane.showMessageDialog(this, "Update thành công!");
            con.close();
            //LoadDataToArray();
        } catch (Exception e) {
            System.out.println(e);
            //JOptionPane.showMessageDialog(this, "Error");
        }
    }
    
    public void deletePCModel(String maHang){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(url, user, pass);
            String sql = "delete from HANG where mahang = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, maHang);
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
    
    public static void main(String[] args) {
        PCModelDAO model = new PCModelDAO();
        model.getAll();
    }
}
