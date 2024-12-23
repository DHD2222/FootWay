/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.LoaiDeGiay;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ultis.DBConnect;

/**
 * @author LAPTOP
 */
public class LoaiDeGiayService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<LoaiDeGiay> getAllLoaiDeGiay() {
        ArrayList<LoaiDeGiay> list = new ArrayList<>();
        String sql = """
                SELECT [ten_de_giay]
                  FROM [dbo].[loai_de_giay]  WHERE [trang_thai] = 1
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String tenDegiay = rs.getString("ten_de_giay");
                LoaiDeGiay deGiay = new LoaiDeGiay(tenDegiay);
                list.add(deGiay);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public LoaiDeGiay getTenDeGiay(String name) {
        String sql = """
                SELECT [id]
                      ,[ma_de_giay]
                      ,[ten_de_giay]
                      ,[chieu_cao]
                      ,[ngay_tao]
                      ,[ngay_sua]
                      ,[trang_thai]
                  FROM [dbo].loai_de_giay
                  where ten_de_giay = ? 
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();
            LoaiDeGiay deGiay = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maDegiay = rs.getString("ma_de_giay");
                String tenDeGiay = rs.getString("ten_de_giay");
                Float chieuCaoDe = rs.getFloat("chieu_cao");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                deGiay = new LoaiDeGiay(id, maDegiay, tenDeGiay, chieuCaoDe, ngayTao, ngaySua, trangThai);
            }
            return deGiay;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public LoaiDeGiayService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<LoaiDeGiay> getALLLoaiDeGiay() {
        sql = "select id,ma_de_giay,ten_de_giay,chieu_cao,ngay_tao,ngay_sua,trang_thai from loai_de_giay";
        ArrayList<LoaiDeGiay> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten;
                float chieuCao;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                chieuCao = rs.getFloat(4);
                ngayTao = rs.getDate(5);
                ngaySua = rs.getDate(6);
                trangThai = rs.getInt(7);
                LoaiDeGiay l = new LoaiDeGiay(id, ma, ten, chieuCao, ngayTao, ngaySua, trangThai);
                list.add(l);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addLoaiDeGiay(LoaiDeGiay l) {
        sql = "INSERT INTO [dbo].[loai_de_giay] ([ma_de_giay], [ten_de_giay],[chieu_cao], [ngay_tao], [trang_thai]) VALUES (?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, l.getMaLoaiDeGiay());
            pr.setObject(2, l.getTenLoaiDeGiay());
            pr.setObject(3, l.getChieuCaoDe());
            pr.setObject(4, l.getNgayTao());
            pr.setObject(5, l.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateLoaiDeGiay(LoaiDeGiay l, int id) {
        sql = "update [dbo].[loai_de_giay] set [ma_de_giay]=?, [ten_de_giay]=?,[chieu_cao]=?,[ngay_sua]=?, [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, l.getMaLoaiDeGiay());
            pr.setObject(2, l.getTenLoaiDeGiay());
            pr.setObject(3, l.getChieuCaoDe());
            pr.setObject(4, l.getNgaySua());
            pr.setObject(5, l.getTrangThai());
            pr.setObject(6, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<LoaiDeGiay> SearchLoaiDeGiay(String tentk) {
        sql = "select id,ma_de_giay,ten_de_giay,chieu_cao,ngay_tao,ngay_sua,trang_thai from loai_de_giay where ten_de_giay like ?";
        ArrayList<LoaiDeGiay> list = new ArrayList<>();
        try {

            pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten;
                float chieuCao;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                chieuCao = rs.getFloat(4);
                ngayTao = rs.getDate(5);
                ngaySua = rs.getDate(6);
                trangThai = rs.getInt(7);
                LoaiDeGiay l = new LoaiDeGiay(id, ma, ten, chieuCao, ngayTao, ngaySua, trangThai);
                list.add(l);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkTrungMa(String maDeGiay) {
        sql = "SELECT COUNT(*) FROM [dbo].[loai_de_giay] WHERE ma_de_giay = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, maDeGiay);
            rs = pr.executeQuery();

            if (rs.next()) {

                return rs.getInt(1) > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    

    public ArrayList<LoaiDeGiay> LocTrangThai(int status) {
        sql = "SELECT id, ma_de_giay, ten_de_giay, chieu_cao, ngay_tao, ngay_sua, trang_thai FROM loai_de_giay WHERE trang_thai = ?";
        ArrayList<LoaiDeGiay> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, status); 
            rs = pr.executeQuery();

            while (rs.next()) {
                int id, trangThai;
                String ma, ten;
                float chieuCao;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                chieuCao = rs.getFloat(4);
                ngayTao = rs.getDate(5);
                ngaySua = rs.getDate(6);
                trangThai = rs.getInt(7);

                LoaiDeGiay l = new LoaiDeGiay(id, ma, ten, chieuCao, ngayTao, ngaySua, trangThai);
                list.add(l);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
