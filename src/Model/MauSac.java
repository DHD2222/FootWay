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

public class MauSac {

    private int id;
    private String maMauSac;
    private String tenMauSac;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public MauSac(String tenMauSac) {

        this.tenMauSac = tenMauSac;

    }

    public MauSac(int id, String maMauSac, String tenMauSac, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public MauSac(String maMauSac, String tenMauSac, Date ngayTao, int trangThai) {
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public MauSac(String maMauSac, String tenMauSac, int trangThai, Date ngaySua) {
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
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
