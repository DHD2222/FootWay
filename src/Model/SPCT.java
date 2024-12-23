/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author LAPTOP
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SPCT {
    private int giamGia;

    public SPCT(int giamGia, int id, String maSPCT, int soLuong, float donGia, String tenMau, String tenkichThuoc, String tendeGiay, String tenSanPham) {
        this.giamGia = giamGia;
        this.id = id;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tenMau = tenMau;
        this.tenkichThuoc = tenkichThuoc;
        this.tendeGiay = tendeGiay;
        this.tenSanPham = tenSanPham;
    }

    private int id;
    private String maSPCT;
    private int soLuong;
    private float donGia;
    private String moTa;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;
    private String tenMau;
    private String tenkichThuoc;
    private String tendeGiay;
    private String tenCTKM;
    private String tenSanPham;
    private Integer idMauSac;
    private Integer idKichThuoc;
    private Integer idDegiay;
    private Integer idChuongTrinhKM;
    private Integer idSanPham;

    public SPCT(int id) {
        this.id = id;
    }

    public SPCT(String maSPCT, int soLuong, float donGia, String moTa, int trangThai, Date ngayTao, Date ngaySua, Integer idMauSac, Integer idKichThuoc, Integer idDegiay, Integer idChuongTrinhKM, Integer idSanPham) {
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.idMauSac = idMauSac;
        this.idKichThuoc = idKichThuoc;
        this.idDegiay = idDegiay;
        this.idChuongTrinhKM = idChuongTrinhKM;
        this.idSanPham = idSanPham;
    }

    public SPCT(int id, String maSPCT, int soLuong, float donGia, String moTa, Date ngayTao, int trangThai, Date ngaySua, Integer idMauSac, Integer idKichThuoc, Integer idDegiay, Integer idChuongTrinhKM, Integer idSanPham) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.idMauSac = idMauSac;
        this.idKichThuoc = idKichThuoc;
        this.idDegiay = idDegiay;
        this.idChuongTrinhKM = idChuongTrinhKM;
        this.idSanPham = idSanPham;
    }

    public SPCT(String maSPCT, int soLuong, float donGia, String moTa, int trangThai, Date ngaySua, Integer idMauSac, Integer idKichThuoc, Integer idDegiay, Integer idChuongTrinhKM, Integer idSanPham) {
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;

        this.ngaySua = ngaySua;
        this.idMauSac = idMauSac;
        this.idKichThuoc = idKichThuoc;
        this.idDegiay = idDegiay;
        this.idChuongTrinhKM = idChuongTrinhKM;
        this.idSanPham = idSanPham;
    }

    public SPCT(int id, String maSPCT, int soLuong, float donGia, String moTa, int trangThai, Date ngayTao, Date ngaySua, String tenMau, String tenkichThuoc, String tendeGiay, String tenCTKM, String tenSanPham) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.tenMau = tenMau;
        this.tenkichThuoc = tenkichThuoc;
        this.tendeGiay = tendeGiay;
        this.tenCTKM = tenCTKM;
        this.tenSanPham = tenSanPham;

    }

    public Object[] toDataRow() {
        return new Object[]{
                this.id,
                this.maSPCT,
                this.tenSanPham,
                this.moTa,
                this.tenMau,
                this.tenkichThuoc,
                this.tendeGiay,
                this.tenCTKM,
                this.soLuong,
                this.donGia,
                this.ngayTao,
                this.ngaySua,
                this.trangThai == 1 ? "Còn hàng" : "Hết hàng",};
    }

    public Object[] toDataRowBanHang() {
        return new Object[]{
                this.id,
                this.maSPCT,
                this.tenSanPham,

                this.tenMau,
                this.tenkichThuoc,
                this.tendeGiay,
                this.giamGia,
                this.soLuong,
                this.donGia,};


    }

    @Override
    public String toString() {
        return "SPCT{" + "id=" + id + ", maSPCT=" + maSPCT + ", soLuong=" + soLuong + ", donGia=" + donGia + ", moTa=" + moTa + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", tenMau=" + tenMau + ", tenkichThuoc=" + tenkichThuoc + ", tendeGiay=" + tendeGiay + ", tenCTKM=" + tenCTKM + ", tenSanPham=" + tenSanPham + ", idMauSac=" + idMauSac + ", idKichThuoc=" + idKichThuoc + ", idDegiay=" + idDegiay + ", idChuongTrinhKM=" + idChuongTrinhKM + ", idSanPham=" + idSanPham + '}';
    }

}
