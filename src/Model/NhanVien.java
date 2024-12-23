/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author Admin
 */
public class NhanVien {

    private int id;
    private String maNhanVien;
    private String tenNhanVien;
    private boolean gioiTinh;
    private Date ngaySinh;
    private String diaChi;
    private String soDienThoai;
    private String tenDangNhap;
    private String matKhau;
    private String vaiTro;
    private String anh;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    // Constructors
    public NhanVien() {
    }

    public NhanVien(int id, String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh,
                    String diaChi, String soDienThoai, String tenDangNhap, String matKhau,
                    String vaiTro, String anh, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.anh = anh;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh,
                    String diaChi, String soDienThoai, String tenDangNhap, String matKhau,
                    String vaiTro, String anh, Date ngayTao, int trangThai) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.anh = anh;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public NhanVien(String maNhanVien, String tenNhanVien, boolean gioiTinh, Date ngaySinh,
                    String diaChi, String soDienThoai, String tenDangNhap, String matKhau,
                    String vaiTro, String anh, int trangThai, Date ngaySua) {

        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.vaiTro = vaiTro;
        this.anh = anh;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(String vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] toDataRow() {
        return new Object[]{
                this.id,
                this.maNhanVien,
                this.tenNhanVien,
                this.gioiTinh ? "Nam" : "Nu",
                this.ngaySinh,
                this.diaChi,
                this.soDienThoai,
                this.tenDangNhap,
                this.matKhau,
                this.vaiTro,
                this.anh,
                this.ngayTao,
                this.ngaySua,
                this.trangThai == 1 ? "Hoat Dong" : "Khong Hoat Dong"
        };
    }

}
