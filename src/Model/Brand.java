/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author LAPTOP
 */

public class Brand {

    private int id;
    private String manhanhieu;
    private String tennhanHieu;
    private String tencongty;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public Brand() {

    }

    public Brand(int id, String manhanhieu, String tennhanHieu, String tencongty, String moTa, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.manhanhieu = manhanhieu;
        this.tennhanHieu = tennhanHieu;
        this.tencongty = tencongty;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Brand(String manhanhieu, String tennhanHieu, String tencongty, String moTa, Date ngayTao, int trangThai) {
        this.manhanhieu = manhanhieu;
        this.tennhanHieu = tennhanHieu;
        this.tencongty = tencongty;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public Brand(String manhanhieu, String tennhanHieu, String tencongty, String moTa, int trangThai, Date ngaySua) {
        this.manhanhieu = manhanhieu;
        this.tennhanHieu = tennhanHieu;
        this.tencongty = tencongty;
        this.moTa = moTa;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Brand(String tennhanHieu) {

        this.tennhanHieu = tennhanHieu;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManhanhieu() {
        return manhanhieu;
    }

    public void setManhanhieu(String manhanhieu) {
        this.manhanhieu = manhanhieu;
    }

    public String getTennhanHieu() {
        return tennhanHieu;
    }

    public void setTennhanHieu(String tennhanHieu) {
        this.tennhanHieu = tennhanHieu;
    }

    public String getTencongty() {
        return tencongty;
    }

    public void setTencongty(String tencongty) {
        this.tencongty = tencongty;
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

    @Override
    public String toString() {
        return "Brand{" + "id=" + id + ", manhanhieu=" + manhanhieu + ", tennhanHieu=" + tennhanHieu + ", tencongty=" + tencongty + ", moTa=" + moTa + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", trangThai=" + trangThai + '}';
    }


}
