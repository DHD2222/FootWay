/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author Admin
 */
public class HoaDon {
    private int id;
    private String maHoaDon;
    private String tenNhanVien;
    private String tenKhachHang;
    private int idNhanVien;
    private int idKhachHang;
    private Date ngayTao;
    private int trangThai;

    public HoaDon() {
    }


    public HoaDon(int id, String maHoaDon, String tenNhanVien, String tenKhachHang, Date ngayTao, int trangThai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon(String maHoaDon, int idNhanVien, int idKhachHang, Date ngayTao, int trangThai) {
        this.maHoaDon = maHoaDon;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }


    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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
                this.maHoaDon,
                this.tenNhanVien,
                this.tenKhachHang,
                this.ngayTao,
                switch (this.trangThai) {   // Sử dụng switch case để kiểm tra trạng thái
                    case 1 -> "Đã thanh toán";
                    case 0 -> "Chờ thanh toán";
                    case 3 -> "Hủy thanh toán";
                    default -> "Không xác định";  // Trạng thái mặc định nếu không phải 0, 1, 3
                }
        };
    }
}
