/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author Duong
 */
public class Voucher {
    private int id;
    private String maVoucher;
    private String tenVocher;
    private String moTa;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int giamGia;
    private int giamToiDa;
    private int donToiThieu;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public Voucher() {
    }

    public Voucher(String maVoucher, String tenVocher, String moTa, Date ngayBatDau, Date ngayKetThuc, int giamGia, int giamToiDa, int donToiThieu, int trangThai, Date ngaySua) {
        this.maVoucher = maVoucher;
        this.tenVocher = tenVocher;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giamGia = giamGia;
        this.giamToiDa = giamToiDa;
        this.donToiThieu = donToiThieu;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Voucher(String tenVocher) {

        this.tenVocher = tenVocher;

    }

    public Voucher(int id, String maVoucher, String tenVocher, String moTa, Date ngayBatDau, Date ngayKetThuc, int giamGia, int giamToiDa, int donToiThieu, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.maVoucher = maVoucher;
        this.tenVocher = tenVocher;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giamGia = giamGia;
        this.giamToiDa = giamToiDa;
        this.donToiThieu = donToiThieu;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Voucher(String maVoucher, String tenVocher, String moTa, Date ngayBatDau, Date ngayKetThuc, int giamGia, int giamToiDa, int donToiThieu, Date ngayTao, int trangThai) {
        this.maVoucher = maVoucher;
        this.tenVocher = tenVocher;
        this.moTa = moTa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giamGia = giamGia;
        this.giamToiDa = giamToiDa;
        this.donToiThieu = donToiThieu;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getTenVocher() {
        return tenVocher;
    }

    public void setTenVocher(String tenVocher) {
        this.tenVocher = tenVocher;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public int getGiamToiDa() {
        return giamToiDa;
    }

    public void setGiamToiDa(int giamToiDa) {
        this.giamToiDa = giamToiDa;
    }

    public int getDonToiThieu() {
        return donToiThieu;
    }

    public void setDonToiThieu(int donToiThieu) {
        this.donToiThieu = donToiThieu;
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
                this.maVoucher,
                this.tenVocher,
                this.moTa,
                this.ngayBatDau,
                this.ngayKetThuc,
                this.giamGia,
                this.giamToiDa,
                this.donToiThieu,
                this.ngayTao,
                this.ngaySua,
                this.trangThai == 1 ? "Hoat dong" : "Khong hoat dong"
        };
    }
}
