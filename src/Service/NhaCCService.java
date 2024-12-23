/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhaCungCap;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ultis.DBConnect;


/**
 * @author LAPTOP
 */
public class NhaCCService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<NhaCungCap> getAllNhaCC() {
        ArrayList<NhaCungCap> list = new ArrayList<>();
        String sql = """
                SELECT [ten_nha_cung_cap]
                  FROM [dbo].[nha_cung_cap]  WHERE [trang_thai] = 1
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                String tenNhaCC = rs.getString("ten_nha_cung_cap");
                NhaCungCap cungCap = new NhaCungCap(tenNhaCC);
                list.add(cungCap);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhaCungCap getTenNCC(String name) {
        String sql = """
                select [id],[ma_nha_cung_cap], [ten_nha_cung_cap], [dia_chi], [mo_ta], [ngay_tao], [ngay_sua], [trang_thai] from nha_cung_cap
                   where ten_nha_cung_cap = ? 
                 """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();

            NhaCungCap cungCap = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maNhaCC = rs.getString("ma_nha_cung_cap");
                String tenNhaCC = rs.getString("ten_nha_cung_cap");
                String diaChi = rs.getString("dia_chi");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");


                cungCap = new NhaCungCap(id, maNhaCC, tenNhaCC, diaChi, moTa, ngayTao, ngaySua, trangThai);
            }

            return cungCap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public NhaCCService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        sql = "select id,ma_nha_cung_cap,ten_nha_cung_cap,mo_ta,dia_chi,ngay_tao,ngay_sua,trang_thai from nha_cung_cap";
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, diaChi, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                moTa = rs.getString(4);
                diaChi = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                NhaCungCap n = new NhaCungCap(id, ma, ten, moTa, diaChi, ngayTao, ngaySua, trangThai);
                list.add(n);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addNhaCungCap(NhaCungCap n) {
        sql = "INSERT INTO [dbo].[nha_cung_cap] ([ma_nha_cung_cap], [ten_nha_cung_cap], [mo_ta],[dia_chi],[ngay_tao], [trang_thai]) VALUES (?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, n.getManhaCC());
            pr.setObject(2, n.getTenNCC());
            pr.setObject(3, n.getMoTa());
            pr.setObject(4, n.getDiaChi());
            pr.setObject(5, n.getNgayTao());
            pr.setObject(6, n.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateNhaCungCap(NhaCungCap n, int id) {
        sql = "update [dbo].[nha_cung_cap] set [ma_nha_cung_cap]=?, [ten_nha_cung_cap]=?,[mo_ta]=?,[dia_chi]=?,[ngay_sua]=?, [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, n.getManhaCC());
            pr.setObject(2, n.getTenNCC());
            pr.setObject(3, n.getMoTa());
            pr.setObject(4, n.getDiaChi());
            pr.setObject(5, n.getNgaySua());
            pr.setObject(6, n.getTrangThai());
            pr.setObject(7, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<NhaCungCap> SearchNhaCungCap(String tentk) {
        sql = "select id,ma_nha_cung_cap,ten_nha_cung_cap,mo_ta,dia_chi,ngay_tao,ngay_sua,trang_thai from nha_cung_cap where ten_nha_cung_cap like ?";
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {

            pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, diaChi, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                moTa = rs.getString(4);
                diaChi = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                NhaCungCap n = new NhaCungCap(id, ma, ten, moTa, diaChi, ngayTao, ngaySua, trangThai);
                list.add(n);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkTrungMa(String maNhaCC) {
        sql = "SELECT COUNT(*) FROM nha_cung_cap WHERE ma_nha_cung_cap = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, maNhaCC);
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

    public ArrayList<NhaCungCap> LocTrangThai(int status) {
        sql = "SELECT * FROM nha_cung_cap WHERE trang_thai = ?";
        ArrayList<NhaCungCap> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, status);  // Bind the status to the query
            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String moTa = rs.getString(4);
                String diaChi = rs.getString(5);
                Date ngayTao = rs.getDate(6);
                Date ngaySua = rs.getDate(7);
                int trangThai = rs.getInt(8);
                NhaCungCap n = new NhaCungCap(id, ma, ten, moTa, diaChi, ngayTao, ngaySua, trangThai);
                list.add(n);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
