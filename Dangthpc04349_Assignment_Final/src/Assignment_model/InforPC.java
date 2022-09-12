/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_model;

/**
 *
 * @author dangt
 */
public class InforPC {
    String maSP;
    
    String maHang;
    String tenSP;
    String hinhAnh;
    String heDieuHanh;
    String cpu;
    String doHoa;
    String pin;
    Float khoiLuong;
    String manHinh;
    String ram;
    String oDia;
    Integer soLuong;
    Integer gia;
    String noiSanXuat;
    String mauSac;
    String tenHang;
    String tenNguoiDung;

    public InforPC(String maSP, String maHang, String tenSP, String hinhAnh, String heDieuHanh, String cpu, String doHoa, String pin, Float khoiLuong, String manHinh, String ram, String oDia, Integer soLuong, Integer gia, String noiSanXuat, String mauSac, String tenHang, String tenNguoiDung) {
        this.maSP = maSP;
        this.maHang = maHang;
        this.tenSP = tenSP;
        this.hinhAnh = hinhAnh;
        this.heDieuHanh = heDieuHanh;
        this.cpu = cpu;
        this.doHoa = doHoa;
        this.pin = pin;
        this.khoiLuong = khoiLuong;
        this.manHinh = manHinh;
        this.ram = ram;
        this.oDia = oDia;
        this.soLuong = soLuong;
        this.gia = gia;
        this.noiSanXuat = noiSanXuat;
        this.mauSac = mauSac;
        this.tenHang = tenHang;
        this.tenNguoiDung = tenNguoiDung;
    }
    
    

    public InforPC(String maSP, String maHang, String tenSP, String hinhAnh, String heDieuHanh, String cpu, String doHoa, String pin, Float khoiLuong, String manHinh, String ram, String oDia, Integer soLuong, Integer gia, String noiSanXuat, String mauSac) {
        this.maSP = maSP;
        this.maHang = maHang;
        this.tenSP = tenSP;
        this.hinhAnh = hinhAnh;
        this.heDieuHanh = heDieuHanh;
        this.cpu = cpu;
        this.doHoa = doHoa;
        this.pin = pin;
        this.khoiLuong = khoiLuong;
        this.manHinh = manHinh;
        this.ram = ram;
        this.oDia = oDia;
        this.soLuong = soLuong;
        this.gia = gia;
        this.noiSanXuat = noiSanXuat;
        this.mauSac = mauSac;
    }

//    public InforPC(String MASANPHAM, String MAHANG, String TENSANPHAM, String HINHANH, String HEDIEUHANH, String CPU, String CARDDOHOA, String PIN, Float TRONGLUONG, String MANHINH, String RAM, String ODIA, Integer SOLUONG, Float GIA, String NOISANXUAT, String MAUSAC) {
//        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public InforPC(String maSP, String maHang, String tenSP, String hinhAnh, String heDieuHanh, String cpu, String doHoa, String pin, Float khoiLuong, String manHinh, String ram, String oDia, Integer soLuong, Integer gia, String noiSanXuat, String mauSac, String tenHang) {
        this.maSP = maSP;
        this.maHang = maHang;
        this.tenSP = tenSP;
        this.hinhAnh = hinhAnh;
        this.heDieuHanh = heDieuHanh;
        this.cpu = cpu;
        this.doHoa = doHoa;
        this.pin = pin;
        this.khoiLuong = khoiLuong;
        this.manHinh = manHinh;
        this.ram = ram;
        this.oDia = oDia;
        this.soLuong = soLuong;
        this.gia = gia;
        this.noiSanXuat = noiSanXuat;
        this.mauSac = mauSac;
        this.tenHang = tenHang;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    
    
    

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDoHoa() {
        return doHoa;
    }

    public void setDoHoa(String doHoa) {
        this.doHoa = doHoa;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Float getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(Float khoiLuong) {
        this.khoiLuong = khoiLuong;
    }

    public String getManHinh() {
        return manHinh;
    }

    public void setManHinh(String manHinh) {
        this.manHinh = manHinh;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getoDia() {
        return oDia;
    }

    public void setoDia(String oDia) {
        this.oDia = oDia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public void setNoiSanXuat(String noiSanXuat) {
        this.noiSanXuat = noiSanXuat;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }
    
    
}
