/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author Duong
 */
public class KhachHang {
    private int id;
    private String ma;
    private String ten;
    private boolean gioiTinh;
    private String diaChi;
    private String sdt;
    private String email;
    private String ghiChu;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public KhachHang() {
    }

    public KhachHang(int id, String ma, String ten, boolean gioiTinh, String diaChi, String sdt, String email, String ghiChu, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public KhachHang(int id, String ten, String sdt, int trangThai) {
        this.id = id;
        this.ten = ten;
        this.sdt = sdt;
        this.trangThai = trangThai;
    }


    public KhachHang(String ma, String ten, boolean gioiTinh, String diaChi, String sdt, String email, String ghiChu, Date ngayTao, int trangThai) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.ghiChu = ghiChu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public KhachHang(String ma, String ten, boolean gioiTinh, String diaChi, String sdt, String email, String ghiChu, int trangThai, Date ngaySua) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.email = email;
        this.ghiChu = ghiChu;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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
                this.ma,
                this.ten,
                this.gioiTinh ? "Nam" : "Nữ",
                this.diaChi,
                this.sdt,
                this.email,
                this.ghiChu,
                this.ngayTao,
                this.ngaySua,
                this.trangThai == 1 ? "Hoat Dong" : "Khong Hoat Dong"
        };
    }

}
