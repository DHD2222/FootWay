/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * @author Admin
 */
public class HoaDonChiTiet {

    private int id;
    private String maHoaDon;
    private String maSPCT;
    private String tenSanPham;
    private String tenMauSac;
    private String tenKichThuoc;
    private String tenDeGiay;
    private int soLuong;
    private float giaBan;
    private float thanhTien;
    private int idSanPham;
    private int idHoaDon;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int id, String maHoaDon, String maSPCT, String tenSanPham, String tenMauSac, String tenKichThuoc, String tenDeGiay, int soLuong, float giaBan, float thanhTien) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.maSPCT = maSPCT;
        this.tenSanPham = tenSanPham;
        this.tenMauSac = tenMauSac;
        this.tenKichThuoc = tenKichThuoc;
        this.tenDeGiay = tenDeGiay;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public HoaDonChiTiet(int id, int soLuong) {
        this.id = id;
        this.soLuong = soLuong;
    }

    public HoaDonChiTiet(int id, String maHoaDon, String maSPCT, String tenSanPham, int soLuong, float giaBan, float thanhTien) {
        this.id = id;
        this.maHoaDon = maHoaDon;
        this.maSPCT = maSPCT;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public HoaDonChiTiet(String maHoaDon, String maSPCT, String tenSanPham, int soLuong, float giaBan, float thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maSPCT = maSPCT;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public HoaDonChiTiet(int idHoaDon, int idSanPham, String tenSanPham, int soLuong, float giaBan, float thanhTien) {
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
        this.idSanPham = idSanPham;
        this.idHoaDon = idHoaDon;
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

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getTenKichThuoc() {
        return tenKichThuoc;
    }

    public void setTenKichThuoc(String tenKichThuoc) {
        this.tenKichThuoc = tenKichThuoc;
    }

    public String getTenDeGiay() {
        return tenDeGiay;
    }

    public void setTenDeGiay(String tenDeGiay) {
        this.tenDeGiay = tenDeGiay;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Object[] toDataRow() {
        return new Object[]{
                this.id,
                this.maHoaDon,
                this.maSPCT,
                this.tenSanPham,
                this.soLuong,
                this.giaBan,
                this.thanhTien,};
    }

    public Object[] toDataRowdanhsach() {
        return new Object[]{
                this.id,
                this.maHoaDon,
                this.maSPCT,
                this.tenSanPham,
                this.tenMauSac,
                this.tenKichThuoc,
                this.tenDeGiay,
                this.soLuong,
                this.giaBan,
                this.thanhTien
        };
    }
}
