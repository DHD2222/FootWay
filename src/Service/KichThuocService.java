/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KichThuoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ultis.DBConnect;

/**
 * @author LAPTOP
 */
public class KichThuocService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<KichThuoc> getAllKichThuoc() {
        ArrayList<KichThuoc> list = new ArrayList<>();
        String sql = """
                SELECT [ten_kich_thuoc]
                  FROM [dbo].[kich_thuoc] WHERE [trang_thai] = 1
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String tenKichthuoc = rs.getString("ten_kich_thuoc");
                KichThuoc kichThuoc = new KichThuoc(tenKichthuoc);
                list.add(kichThuoc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KichThuoc getTenKichThuoc(String name) {
        String sql = """
                SELECT [id]
                      ,[ma_kich_thuoc]
                      ,[ten_kich_thuoc]
                      ,[ngay_tao]
                      ,[ngay_sua]
                      ,[trang_thai]
                  FROM [dbo].kich_thuoc
                  where ten_kich_thuoc = ? 
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();

            KichThuoc kichThuoc = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maKichThuoc = rs.getString("ma_kich_thuoc");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                kichThuoc = new KichThuoc(id, maKichThuoc, tenKichThuoc, ngayTao, ngaySua, trangThai);

            }

            return kichThuoc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public KichThuocService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<KichThuoc> getALLKichThuoc() {
        sql = "select id,ma_kich_thuoc,ten_kich_thuoc,ngay_tao,ngay_sua,trang_thai from kich_thuoc";
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                ngayTao = rs.getDate(4);
                ngaySua = rs.getDate(5);
                trangThai = rs.getInt(6);
                KichThuoc k = new KichThuoc(id, ma, ten, ngayTao, ngaySua, trangThai);
                listKichThuoc.add(k);
            }
            return listKichThuoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addKichThuoc(KichThuoc k) {
        sql = "INSERT INTO [dbo].[kich_thuoc] ([ma_kich_thuoc], [ten_kich_thuoc], [ngay_tao], [trang_thai]) VALUES (?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, k.getMaKichThuoc());
            pr.setObject(2, k.getTenKichThuoc());
            pr.setObject(3, k.getNgayTao());
            pr.setObject(4, k.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateKichThuoc(KichThuoc k, int id) {
        sql = "update [dbo].[kich_thuoc] set [ma_kich_thuoc]=?, [ten_kich_thuoc]=?,[ngay_sua]=?, [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, k.getMaKichThuoc());
            pr.setObject(2, k.getTenKichThuoc());
            pr.setObject(3, k.getNgaySua());
            pr.setObject(4, k.getTrangThai());
            pr.setObject(5, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<KichThuoc> SearchKichThuoc(String tentk) {
        sql = "select id,ma_kich_thuoc,ten_kich_thuoc,ngay_tao,ngay_sua,trang_thai from kich_thuoc where ten_kich_thuoc like ?";
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        try {

            pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                ngayTao = rs.getDate(4);
                ngaySua = rs.getDate(5);
                trangThai = rs.getInt(6);
                KichThuoc k = new KichThuoc(id, ma, ten, ngayTao, ngaySua, trangThai);
                listKichThuoc.add(k);
            }
            return listKichThuoc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkTrungMa(String maKichThuoc) {
        String sql = "SELECT COUNT(*) FROM kich_thuoc WHERE ma_kich_thuoc = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, maKichThuoc);
            rs = pr.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkTrungTen(String tenKichThuoc) {
        String sql = "SELECT COUNT(*) FROM kich_thuoc WHERE ten_kich_thuoc = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, tenKichThuoc);
            rs = pr.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<KichThuoc> LocTrangThai(int trangthai) {
        sql = "SELECT * FROM kich_thuoc WHERE trang_thai = ?";
        ArrayList<KichThuoc> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, trangthai);  // Bind the status parameter to filter by trang_thai
            rs = pr.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("ma_kich_thuoc");
                String ten = rs.getString("ten_kich_thuoc");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                KichThuoc k = new KichThuoc(id, ma, ten, ngayTao, ngaySua, trangThai);
                list.add(k);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
