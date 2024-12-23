/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChatLieu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ultis.DBConnect;


/**
 * @author LAPTOP
 */
public class ChatLieuService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ChatLieuService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<ChatLieu> getAllChatLieu() {
        sql = "select id,ma_chat_lieu,ten_chat_lieu,nguon_goc,mo_ta,ngay_tao,ngay_sua,trang_thai from chat_lieu";
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, nguonGoc, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                nguonGoc = rs.getString(4);
                moTa = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                ChatLieu c = new ChatLieu(id, ma, ten, nguonGoc, moTa, ngayTao, ngaySua, trangThai);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ChatLieu> getAllChatlieu() {
        ArrayList<ChatLieu> list = new ArrayList<>();
        String sql = """
                SELECT [ten_chat_lieu]
                  FROM [dbo].[chat_lieu]  WHERE [trang_thai] = 1
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                String tenchatLieu = rs.getString("ten_chat_lieu");

                ChatLieu chatLieu = new ChatLieu(tenchatLieu);
                list.add(chatLieu);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChatLieu getTenChatLieu(String name) {
        String sql = """
                select [id],[ma_chat_lieu], [ten_chat_lieu], [nguon_goc], [mo_ta], [ngay_tao], [ngay_sua], [trang_thai] from chat_lieu
                   where ten_chat_lieu = ? 
                 """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();

            ChatLieu chatLieu = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maChatLieu = rs.getString("ma_chat_lieu");
                String tenChatLieu = rs.getString("ten_chat_lieu");
                String nguonGoc = rs.getString("nguon_goc");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");

                chatLieu = new ChatLieu(id, maChatLieu, tenChatLieu, nguonGoc, moTa, ngayTao, ngaySua, trangThai);
            }

            return chatLieu;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int insertChatLieu(ChatLieu c) {
        sql = "INSERT INTO [dbo].[chat_lieu] ([ma_chat_lieu], [ten_chat_lieu],[nguon_goc], [mo_ta],[ngay_tao], [trang_thai]) VALUES (?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, c.getMachatLieu());
            pr.setObject(2, c.getTenchatLieu());
            pr.setObject(3, c.getNguonGoc());
            pr.setObject(4, c.getMoTa());
            pr.setObject(5, c.getNgayTao());
            pr.setObject(6, c.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateChatLieu(ChatLieu c, int id) {
        sql = "update [dbo].[chat_lieu] set [ma_chat_lieu]=?, [ten_chat_lieu]=?,[nguon_goc]=?,[mo_ta]=?,[ngay_sua]=?, [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, c.getMachatLieu());
            pr.setObject(2, c.getTenchatLieu());
            pr.setObject(3, c.getNguonGoc());
            pr.setObject(4, c.getMoTa());
            pr.setObject(5, c.getNgaySua());
            pr.setObject(6, c.getTrangThai());
            pr.setObject(7, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<ChatLieu> SearchChatLieu(String tentk) {
        sql = "select id,ma_chat_lieu,ten_chat_lieu,nguon_goc,mo_ta,ngay_tao,ngay_sua,trang_thai from chat_lieu where ten_chat_lieu like ?";
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {

            pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, nguonGoc, moTa;
                java.sql.Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                nguonGoc = rs.getString(4);
                moTa = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);
                ChatLieu c = new ChatLieu(id, ma, ten, nguonGoc, moTa, ngayTao, ngaySua, trangThai);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkTrungMaChatLieu(String maChatLieu) {
        sql = "SELECT COUNT(*) FROM chat_lieu WHERE ma_chat_lieu = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, maChatLieu);
            rs = pr.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Nếu đếm được > 0, có nghĩa là mã đã tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; // Nếu không có trùng mã
    }

    public ArrayList<ChatLieu> LocTrangThai(int status) {
        sql = "SELECT id, ma_chat_lieu, ten_chat_lieu, nguon_goc, mo_ta, ngay_tao, ngay_sua, trang_thai FROM chat_lieu WHERE trang_thai = ?";
        ArrayList<ChatLieu> list = new ArrayList<>();
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, status);  // Bind the status value to the SQL query
            rs = pr.executeQuery();

            while (rs.next()) {
                int id, trangThai;
                String ma, ten, nguonGoc, moTa;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                nguonGoc = rs.getString(4);
                moTa = rs.getString(5);
                ngayTao = rs.getDate(6);
                ngaySua = rs.getDate(7);
                trangThai = rs.getInt(8);

                ChatLieu c = new ChatLieu(id, ma, ten, nguonGoc, moTa, ngayTao, ngaySua, trangThai);
                list.add(c);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
