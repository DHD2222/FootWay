/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class ThongKe {
     private int id;
    private String maHoaDon;
    private String tenNhanVien;
    private String tenKhachHang;
    private int idNhanVien;
    private int idKhachHang;
    private Date ngayTao;
    private Integer trangThai;
    private Double tongTien;
    private String sdt;
    private String maVoucher;

    public ThongKe() {
    }

    public ThongKe(int id, String maHoaDon, String tenNhanVien, String tenKhachHang, Date ngayTao, int trangThai) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public ThongKe(String maHoaDon, int idNhanVien, int idKhachHang, Date ngayTao, int trangThai) {
        this.maHoaDon = maHoaDon;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }

   

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    

    public Object[] toDataRow() {
         
        return new Object[]{
           
            this.maHoaDon,
            this.tongTien,
            this.ngayTao,
            this.tenNhanVien,
            this.tenKhachHang,
         
            switch (trangThai) {   // Sử dụng switch case để kiểm tra trạng thái
                case 1 ->
                    "Đã thanh toán";
                case 0 ->
                    "Chờ thanh toán";
                case 3 ->
                    "Hủy thanh toán";
                default ->
                    "Không xác định";  // Trạng thái mặc định nếu không phải 0, 1, 3
            }
        };
    }
    
     public String loadTrangThaiHD() {
        if (trangThai == 1) {
            return "Đã thanh toán";
        } else if (trangThai == 0) {
            return "Chờ thanh toán";
        } else {
            return "Đã hủy";
        }
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", maHoaDon=" + maHoaDon + ", tenNhanVien=" + tenNhanVien + ", tenKhachHang=" + tenKhachHang + ", idNhanVien=" + idNhanVien + ", idKhachHang=" + idKhachHang + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + ", tongTien=" + tongTien + ", sdt=" + sdt + ", maVoucher=" + maVoucher + '}';
    }
}
