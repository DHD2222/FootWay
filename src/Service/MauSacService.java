/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.MauSac;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ultis.DBConnect;

/**
 * @author LAPTOP
 */
public class MauSacService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<MauSac> getAllMauSac() {
        ArrayList<MauSac> list = new ArrayList<>();
        String sql = """
                SELECT [ten_mau]
                  FROM [dbo].[mau_sac]  WHERE [trang_thai] = 1
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String tenMausac = rs.getString("ten_mau");
                MauSac mauSac = new MauSac(tenMausac);
                list.add(mauSac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MauSac getTenMauSac(String name) {
        String sql = """
                SELECT [id]
                      ,[ma_mau]
                      ,[ten_mau]
                      ,[ngay_tao]
                      ,[ngay_sua]
                      ,[trang_thai]
                  FROM [dbo].mau_sac
                  where ten_mau = ? 
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();

            MauSac mauSac = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maMau = rs.getString("ma_mau");
                String tenMau = rs.getString("ten_mau");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                mauSac = new MauSac(id, maMau, tenMau, ngayTao, ngaySua, trangThai);

            }

            return mauSac;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public MauSacService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<MauSac> getALLMauSac() {
        sql = "select id,ma_mau,ten_mau,ngay_tao,ngay_sua,trang_thai from mau_sac";
        ArrayList<MauSac> listMauSac = new ArrayList<>();
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
                MauSac m = new MauSac(id, ma, ten, ngayTao, ngaySua, trangThai);
                listMauSac.add(m);
            }
            return listMauSac;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addMauSac(MauSac m) {
        sql = "INSERT INTO [dbo].[mau_sac] ([ma_mau], [ten_mau], [ngay_tao], [trang_thai]) VALUES (?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, m.getMaMauSac());
            pr.setObject(2, m.getTenMauSac());
            pr.setObject(3, m.getNgayTao());
            pr.setObject(4, m.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateMauSac(MauSac m, int id) {
        sql = "update [dbo].[mau_sac] set [ma_mau]=?, [ten_mau]=?, [trang_thai]=?,[ngay_sua]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, m.getMaMauSac());
            pr.setObject(2, m.getTenMauSac());
            pr.setObject(3, m.getTrangThai());
            pr.setObject(4, m.getNgaySua());
            pr.setObject(5, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<MauSac> SearchMauSac(String tentk) {
        sql = "select id,ma_mau,ten_mau,ngay_tao,ngay_sua,trang_thai from mau_sac where ten_mau like ?";
        ArrayList<MauSac> listMauSac = new ArrayList<>();
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
                MauSac m = new MauSac(id, ma, ten, ngayTao, ngaySua, trangThai);
                listMauSac.add(m);
            }
            return listMauSac;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkTrungMa(String maMauSac) {
        sql = "SELECT COUNT(*) FROM [dbo].[mau_sac] WHERE ma_mau = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, maMauSac);
            rs = pr.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkTrungTen(String tenMauSac) {
        sql = "SELECT COUNT(*) FROM [dbo].[mau_sac] WHERE ten_mau = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, tenMauSac);
            rs = pr.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<MauSac> LocTrangThai(int status) {
        sql = "SELECT id, ma_mau, ten_mau, ngay_tao, ngay_sua, trang_thai FROM mau_sac WHERE trang_thai = ?";
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, status);  // Bind the status parameter to the SQL query
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

                MauSac m = new MauSac(id, ma, ten, ngayTao, ngaySua, trangThai);
                listMauSac.add(m);
            }
            return listMauSac;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
