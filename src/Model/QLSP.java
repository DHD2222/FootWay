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
public class QLSP {

    private int id;
    private String maSanPham;
    private String tenSanPham;
    private String moTa;
    private String anh;
    private int trangThai;
    private Date ngayTao;
    private Date ngaySua;
    private String tenNhanHieu;
    private String tenChatLieu;
    private String tenNhaCungCap;
    private Integer idnhanHieu;
    private Integer idChatLieu;
    private Integer idNhaCC;


    public QLSP(String maSanPham, String tenSanPham, String moTa, String anh, int trangThai, Date ngayTao, Integer idnhanHieu, Integer idChatLieu, Integer idNhaCC) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.anh = anh;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;

        this.idnhanHieu = idnhanHieu;
        this.idChatLieu = idChatLieu;
        this.idNhaCC = idNhaCC;
    }

    public QLSP(String maSanPham, String tenSanPham, String moTa, String anh, int trangThai, Integer idnhanHieu, Integer idChatLieu, Integer idNhaCC, Date ngaySua) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.anh = anh;
        this.trangThai = trangThai;
        this.ngaySua = ngaySua;

        this.idnhanHieu = idnhanHieu;
        this.idChatLieu = idChatLieu;
        this.idNhaCC = idNhaCC;
    }


    public QLSP(int id, String maSanPham, String tenSanPham, String moTa, String anh, int trangThai, Date ngayTao, Date ngaySua, String tenNhanHieu, String tenChatLieu, String tenNhaCungCap) {
        this.id = id;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.anh = anh;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.tenNhanHieu = tenNhanHieu;
        this.tenChatLieu = tenChatLieu;
        this.tenNhaCungCap = tenNhaCungCap;
    }

    public Object[] toDataRow() {
        return new Object[]{
                this.id,
                this.maSanPham,
                this.tenSanPham,
                this.moTa,
                this.anh,
                this.trangThai == 1 ? "Đang bán" : "Ngừng bán", // Giả sử trangThai là 1 cho "Còn hàng" và 0 cho "Hết hàng"
                this.ngayTao,
                this.ngaySua,
                this.tenNhanHieu,
                this.tenChatLieu,
                this.tenNhaCungCap

        };
    }


}
