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

public class LoaiDeGiay {

    private int id;
    private String maLoaiDeGiay;
    private String tenLoaiDeGiay;
    private Float chieuCaoDe;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public LoaiDeGiay(String tenLoaiDeGiay) {

        this.tenLoaiDeGiay = tenLoaiDeGiay;

    }

    public LoaiDeGiay(int id, String maLoaiDeGiay, String tenLoaiDeGiay, Float chieuCaoDe, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.maLoaiDeGiay = maLoaiDeGiay;
        this.tenLoaiDeGiay = tenLoaiDeGiay;
        this.chieuCaoDe = chieuCaoDe;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public LoaiDeGiay(String maLoaiDeGiay, String tenLoaiDeGiay, float chieuCao, Date ngayTao, int trangThai) {
        this.maLoaiDeGiay = maLoaiDeGiay;
        this.tenLoaiDeGiay = tenLoaiDeGiay;
        this.chieuCaoDe = chieuCao;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public LoaiDeGiay(String maLoaiDeGiay, String tenLoaiDeGiay, float chieuCao, int trangThai, Date ngaySua) {
        this.maLoaiDeGiay = maLoaiDeGiay;
        this.tenLoaiDeGiay = tenLoaiDeGiay;
        this.chieuCaoDe = chieuCao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLoaiDeGiay() {
        return maLoaiDeGiay;
    }

    public void setMaLoaiDeGiay(String maLoaiDeGiay) {
        this.maLoaiDeGiay = maLoaiDeGiay;
    }

    public String getTenLoaiDeGiay() {
        return tenLoaiDeGiay;
    }

    public void setTenLoaiDeGiay(String tenLoaiDeGiay) {
        this.tenLoaiDeGiay = tenLoaiDeGiay;
    }

    public Float getChieuCaoDe() {
        return chieuCaoDe;
    }

    public void setChieuCaoDe(Float chieuCaoDe) {
        this.chieuCaoDe = chieuCaoDe;
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
