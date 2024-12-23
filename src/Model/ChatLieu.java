/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 * @author LAPTOP
 */
public class ChatLieu {

    private int id;
    private String machatLieu;
    private String tenchatLieu;
    private String nguonGoc;
    private String moTa;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;

    public ChatLieu() {
    }

    public ChatLieu(int id, String machatLieu, String tenchatLieu, String nguonGoc, String moTa, Date ngayTao, Date ngaySua, int trangThai) {
        this.id = id;
        this.machatLieu = machatLieu;
        this.tenchatLieu = tenchatLieu;
        this.nguonGoc = nguonGoc;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public ChatLieu(String machatlieu, String tenchatlieu, String nguonGoc, String moTa, Date ngayTao, int trangThai) {
        this.machatLieu = machatlieu;
        this.tenchatLieu = tenchatlieu;
        this.nguonGoc = nguonGoc;
        this.moTa = moTa;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public ChatLieu(String machatlieu, String tenchatlieu, String nguonGoc, String moTa, int trangThai, Date ngaySua) {
        this.machatLieu = machatlieu;
        this.tenchatLieu = tenchatlieu;
        this.nguonGoc = nguonGoc;
        this.moTa = moTa;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public ChatLieu(String tenchatLieu) {
        this.tenchatLieu = tenchatLieu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMachatLieu() {
        return machatLieu;
    }

    public void setMachatLieu(String machatLieu) {
        this.machatLieu = machatLieu;
    }

    public String getTenchatLieu() {
        return tenchatLieu;
    }

    public void setTenchatLieu(String tenchatLieu) {
        this.tenchatLieu = tenchatLieu;
    }

    public String getNguonGoc() {
        return nguonGoc;
    }

    public void setNguonGoc(String nguonGoc) {
        this.nguonGoc = nguonGoc;
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
