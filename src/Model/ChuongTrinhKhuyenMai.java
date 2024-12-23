/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author Duong
 */
public class ChuongTrinhKhuyenMai {
    private int id;
    private String maChuongTrinh;
    private String tenChuongTrinh;
    private String moTaChuongTrinh;
    private Date ngayBatDauChuongTrinh;
    private Date ngayKetThucChuongTrinh;
    private int giamGiaChuongTrinh;
    private Date ngayTaoChuongTrinh;
    private Date ngaySuaChuongTrinh;
    private int trangThaiChuongTrinh;

    public ChuongTrinhKhuyenMai() {
    }

    public ChuongTrinhKhuyenMai(String tenChuongTrinh) {

        this.tenChuongTrinh = tenChuongTrinh;

    }

    public ChuongTrinhKhuyenMai(int id, String maChuongTrinh, String tenChuongTrinh, String moTaChuongTrinh, Date ngayBatDauChuongTrinh, Date ngayKetThucChuongTrinh, int giamGiaChuongTrinh, Date ngayTaoChuongTrinh, Date ngaySuaChuongTrinh, int trangThaiChuongTrinh) {
        this.id = id;
        this.maChuongTrinh = maChuongTrinh;
        this.tenChuongTrinh = tenChuongTrinh;
        this.moTaChuongTrinh = moTaChuongTrinh;
        this.ngayBatDauChuongTrinh = ngayBatDauChuongTrinh;
        this.ngayKetThucChuongTrinh = ngayKetThucChuongTrinh;
        this.giamGiaChuongTrinh = giamGiaChuongTrinh;
        this.ngayTaoChuongTrinh = ngayTaoChuongTrinh;
        this.ngaySuaChuongTrinh = ngaySuaChuongTrinh;
        this.trangThaiChuongTrinh = trangThaiChuongTrinh;
    }

    public ChuongTrinhKhuyenMai(String maChuongTrinh, String tenChuongTrinh, String moTaChuongTrinh, Date ngayBatDauChuongTrinh, Date ngayKetThucChuongTrinh, int giamGiaChuongTrinh, Date ngayTaoChuongTrinh, int trangThaiChuongTrinh) {
        this.maChuongTrinh = maChuongTrinh;
        this.tenChuongTrinh = tenChuongTrinh;
        this.moTaChuongTrinh = moTaChuongTrinh;
        this.ngayBatDauChuongTrinh = ngayBatDauChuongTrinh;
        this.ngayKetThucChuongTrinh = ngayKetThucChuongTrinh;
        this.giamGiaChuongTrinh = giamGiaChuongTrinh;
        this.ngayTaoChuongTrinh = ngayTaoChuongTrinh;
        this.trangThaiChuongTrinh = trangThaiChuongTrinh;
    }

    public ChuongTrinhKhuyenMai(String maChuongTrinh, String tenChuongTrinh, String moTaChuongTrinh, Date ngayBatDauChuongTrinh, Date ngayKetThucChuongTrinh, int giamGiaChuongTrinh, int trangThaiChuongTrinh, Date ngaySuaChuongTrinh) {
        this.maChuongTrinh = maChuongTrinh;
        this.tenChuongTrinh = tenChuongTrinh;
        this.moTaChuongTrinh = moTaChuongTrinh;
        this.ngayBatDauChuongTrinh = ngayBatDauChuongTrinh;
        this.ngayKetThucChuongTrinh = ngayKetThucChuongTrinh;
        this.giamGiaChuongTrinh = giamGiaChuongTrinh;
        this.ngaySuaChuongTrinh = ngaySuaChuongTrinh;
        this.trangThaiChuongTrinh = trangThaiChuongTrinh;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaChuongTrinh() {
        return maChuongTrinh;
    }

    public void setMaChuongTrinh(String maChuongTrinh) {
        this.maChuongTrinh = maChuongTrinh;
    }

    public String getTenChuongTrinh() {
        return tenChuongTrinh;
    }

    public void setTenChuongTrinh(String tenChuongTrinh) {
        this.tenChuongTrinh = tenChuongTrinh;
    }

    public String getMoTaChuongTrinh() {
        return moTaChuongTrinh;
    }

    public void setMoTaChuongTrinh(String moTaChuongTrinh) {
        this.moTaChuongTrinh = moTaChuongTrinh;
    }

    public Date getNgayBatDauChuongTrinh() {
        return ngayBatDauChuongTrinh;
    }

    public void setNgayBatDauChuongTrinh(Date ngayBatDauChuongTrinh) {
        this.ngayBatDauChuongTrinh = ngayBatDauChuongTrinh;
    }

    public Date getNgayKetThucChuongTrinh() {
        return ngayKetThucChuongTrinh;
    }

    public void setNgayKetThucChuongTrinh(Date ngayKetThucChuongTrinh) {
        this.ngayKetThucChuongTrinh = ngayKetThucChuongTrinh;
    }

    public int getGiamGiaChuongTrinh() {
        return giamGiaChuongTrinh;
    }

    public void setGiamGiaChuongTrinh(int giamGiaChuongTrinh) {
        this.giamGiaChuongTrinh = giamGiaChuongTrinh;
    }

    public Date getNgayTaoChuongTrinh() {
        return ngayTaoChuongTrinh;
    }

    public void setNgayTaoChuongTrinh(Date ngayTaoChuongTrinh) {
        this.ngayTaoChuongTrinh = ngayTaoChuongTrinh;
    }

    public Date getNgaySuaChuongTrinh() {
        return ngaySuaChuongTrinh;
    }

    public void setNgaySuaChuongTrinh(Date ngaySuaChuongTrinh) {
        this.ngaySuaChuongTrinh = ngaySuaChuongTrinh;
    }

    public int getTrangThaiChuongTrinh() {
        return trangThaiChuongTrinh;
    }

    public void setTrangThaiChuongTrinh(int trangThaiChuongTrinh) {
        this.trangThaiChuongTrinh = trangThaiChuongTrinh;
    }

    public Object[] toDataRow() {
        return new Object[]{
                this.id,
                this.maChuongTrinh,
                this.tenChuongTrinh,
                this.moTaChuongTrinh,
                this.ngayBatDauChuongTrinh,
                this.ngayKetThucChuongTrinh,
                this.giamGiaChuongTrinh,
                this.ngayTaoChuongTrinh,
                this.ngaySuaChuongTrinh,
                this.trangThaiChuongTrinh == 1 ? "Hoat dong" : "Khong hoat dong"
        };
    }


}
