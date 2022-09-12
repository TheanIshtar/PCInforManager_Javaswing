/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_model;
/**
 *
 * @author  TRẦN HỮU ĐANG

 */
public class Account {
    public String tenNguoiDung;
    public String tenDangNhap;
    public String maKhau;
    public String email;
    public String chucVu;
    public boolean trangThai;
    public String qrCode;

    public Account(String tenNguoiDung, String tenDangNhap, String maKhau, String chucVu, boolean trangThai) {
        this.tenNguoiDung = tenNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.maKhau = maKhau;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public Account(String tenNguoiDung, String tenDangNhap, String maKhau, String email, String chucVu, boolean trangThai, String qrCode) {
        this.tenNguoiDung = tenNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.maKhau = maKhau;
        this.email = email;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.qrCode = qrCode;
    }

    public Account(String tenDangNhap, String email, boolean trangThai) {
        this.tenDangNhap = tenDangNhap;
        this.email = email;
        this.trangThai = trangThai;
    }
    
    

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }
    
    

    public Account(String tenNguoiDung, String tenDangNhap, String maKhau, String email, String chucVu, boolean trangThai) {
        this.tenNguoiDung = tenNguoiDung;
        this.tenDangNhap = tenDangNhap;
        this.maKhau = maKhau;
        this.email = email;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMaKhau() {
        return maKhau;
    }

    public void setMaKhau(String maKhau) {
        this.maKhau = maKhau;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    

    
    
    
}
