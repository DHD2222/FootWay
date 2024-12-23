/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author LAPTOP
 */
public class NhaCungCap {

    private int id;
    private String manhaCC;
    private String tenNCC;
    private String diaChi;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public NhaCungCap() {
    }

    public NhaCungCap(int id, String manhaCC, String tenNCC, String diaChi, String moTa, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.manhaCC = manhaCC;
        this.tenNCC = tenNCC;
        this.diaChi = diaChi;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public NhaCungCap(String manhaCC, String tenNCC, String moTa, String diaChi, Date ngayTao, int trangThai) {
        this.manhaCC = manhaCC;
        this.tenNCC = tenNCC;
        this.moTa = moTa;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public NhaCungCap(String manhaCC, String tenNCC, String moTa, String diaChi, int trangThai, Date ngaySua) {
        this.manhaCC = manhaCC;
        this.tenNCC = tenNCC;
        this.moTa = moTa;
        this.diaChi = diaChi;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public NhaCungCap(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManhaCC() {
        return manhaCC;
    }

    public void setManhaCC(String manhaCC) {
        this.manhaCC = manhaCC;
    }

    public String getTenNCC() {
        return tenNCC;
    }

    public void setTenNCC(String tenNCC) {
        this.tenNCC = tenNCC;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

}
