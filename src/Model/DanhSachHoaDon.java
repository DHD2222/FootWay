/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author Admin
 */
public class DanhSachHoaDon {
    private int id;
    private String maHoaDon;
    private String tenSanPham;
    private String tenNhanVien;
    private String tenKhachHang;
    private float tongTien;
    private String voucher;
    private float tongTienTruocVoucher;
    private Date ngayTao;
    private int idVoucher;
    private int trangThai;

    public int getIdVoucher() {
        return idVoucher;
    }

    public void setIdVoucher(int idVoucher) {
        this.idVoucher = idVoucher;
    }


    public DanhSachHoaDon() {
    }

    public DanhSachHoaDon(int id, String maHoaDon, String tenSanPham, String tenNhanVien, String tenKhachHang, float tongTien, String voucher, float tongTienTruocVoucher, Date ngayTao, int idVoucher, int trangThai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.tenSanPham = tenSanPham;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.tongTien = tongTien;
        this.voucher = voucher;
        this.tongTienTruocVoucher = tongTienTruocVoucher;
        this.ngayTao = ngayTao;
        this.idVoucher = idVoucher;
        this.trangThai = trangThai;
    }


    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public float getTongTienTruocVoucher() {
        return tongTienTruocVoucher;
    }

    public void setTongTienTruocVoucher(float tongTienTruocVoucher) {
        this.tongTienTruocVoucher = tongTienTruocVoucher;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
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

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
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
                this.tongTienTruocVoucher,
                this.voucher,
                this.tongTien,
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
