/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Brand;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ultis.DBConnect;


/**
 * @author LAPTOP
 */
public class BrandService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<Brand> getAllBrand() {
        ArrayList<Brand> list = new ArrayList<>();
        String sql = """
                SELECT [ten_nhan_hieu]
                  FROM [dbo].[nhan_hieu]  WHERE [trang_thai] = 1
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                String tenNhanHieu = rs.getString("ten_nhan_hieu");
                Brand brand = new Brand(tenNhanHieu);
                list.add(brand);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Brand getTenBrand(String name) {
        String sql = """
                select [id],[ma_nhan_hieu],[ten_nhan_hieu], [ten_cong_ty], [mo_ta], [ngay_tao], [ngay_sua], [trang_thai] from nhan_hieu
                   where ten_nhan_hieu = ? 
                 """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();

            Brand brand = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maNhanHieu = rs.getString("ma_nhan_hieu");
                String tenNhanHieu = rs.getString("ten_nhan_hieu");
                String tenCongty = rs.getString("ten_cong_ty");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");

                brand = new Brand(id, maNhanHieu, tenNhanHieu, tenCongty, moTa, ngayTao, ngaySua, trangThai);
            }

            return brand;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public BrandService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Brand> getAllNhanHieu() {
        sql = "select id,ma_nhan_hieu,ten_nhan_hieu,ten_cong_ty,mo_ta,ngay_tao,ngay_sua,trang_thai from nhan_hieu";
        ArrayList<Brand> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, tenct, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                tenct = rs.getString(4);
                moTa = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                Brand n = new Brand(id, ma, ten, tenct, moTa, ngayTao, ngaySua, trangThai);
                list.add(n);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addNhanHieu(Brand n) {
        sql = "INSERT INTO [dbo].[nhan_hieu] ([ma_nhan_hieu], [ten_nhan_hieu],[ten_cong_ty], [mo_ta],[ngay_tao], [trang_thai]) VALUES (?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, n.getManhanhieu());
            pr.setObject(2, n.getTennhanHieu());
            pr.setObject(3, n.getTencongty());
            pr.setObject(4, n.getMoTa());
            pr.setObject(5, n.getNgayTao());
            pr.setObject(6, n.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateNhanHieu(Brand n, int id) {
        sql = "update [dbo].[nhan_hieu] set [ma_nhan_hieu]=?, [ten_nhan_hieu]=?,[ten_cong_ty]=?,[mo_ta]=?,[ngay_sua]=?, [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, n.getManhanhieu());
            pr.setObject(2, n.getTennhanHieu());
            pr.setObject(3, n.getTencongty());
            pr.setObject(4, n.getMoTa());
            pr.setObject(5, n.getNgaySua());
            pr.setObject(6, n.getTrangThai());
            pr.setObject(7, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<Brand> SearchNhanHieu(String tentk) {
        sql = "select id,ma_nhan_hieu,ten_nhan_hieu,ten_cong_ty,mo_ta,ngay_tao,ngay_sua,trang_thai from nhan_hieu where ten_nhan_hieu like ?";
        ArrayList<Brand> list = new ArrayList<>();
        try {

            pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, tenct, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                tenct = rs.getString(4);
                moTa = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                Brand n = new Brand(id, ma, ten, tenct, moTa, ngayTao, ngaySua, trangThai);
                list.add(n);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkTrungMa(String maNhanHieu) {
        String sql = "SELECT COUNT(*) FROM nhan_hieu WHERE ma_nhan_hieu = ?";

        try (Connection con = DBConnect.getConnection();
             PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setString(1, maNhanHieu);  // Gán mã nhãn hiệu cần kiểm tra

            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public ArrayList<Brand> LocTrangThai(int status) {
        sql = "SELECT id, ma_nhan_hieu, ten_nhan_hieu, ten_cong_ty, mo_ta, ngay_tao, ngay_sua, trang_thai FROM nhan_hieu WHERE trang_thai = ?";
        ArrayList<Brand> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, status);  // Set the status to filter by
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, tenct, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                tenct = rs.getString(4);
                moTa = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                Brand n = new Brand(id, ma, ten, tenct, moTa, ngayTao, ngaySua, trangThai);
                list.add(n);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
