/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ChuongTrinhKhuyenMai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ultis.DBConnect;

/**
 * @author Duong
 */
public class QuanLyChuongTrinhService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public QuanLyChuongTrinhService() {
        con = DBConnect.getConnection();
    }

    public List<ChuongTrinhKhuyenMai> getAllChuongTrinh(int page) {
        List<ChuongTrinhKhuyenMai> chuongTrinhList = new ArrayList<>();
        int pageSize = 5;
        int offset = (page - 1) * pageSize;
        String sql = "SELECT * FROM chuong_trinh_khuyen_mai "
                + "WHERE id > 1 "
                + "ORDER BY id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, offset);
            pr.setInt(2, pageSize);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String maChuongTrinh = rs.getString("ma_chuong_trinh_khuyen_mai");
                    String tenChuongTrinh = rs.getString("ten_chuong_trinh_khuyen_mai");
                    String moTaChuongTrinh = rs.getString("mo_ta");
                    Date ngayBatDauChuongTrinh = rs.getDate("ngay_bat_dau");
                    Date ngayKetThucChuongTrinh = rs.getDate("ngay_ket_thuc");
                    int giamGiaChuongTrinh = rs.getInt("giam_gia");
                    Date ngayTaoChuongTrinh = rs.getDate("ngay_tao");
                    Date ngaySuaChuongTrinh = rs.getDate("ngay_sua");
                    int trangThaiChuongTrinh = rs.getInt("trang_thai");
                    ChuongTrinhKhuyenMai chuongTrinh = new ChuongTrinhKhuyenMai(
                            id, maChuongTrinh, tenChuongTrinh, moTaChuongTrinh,
                            ngayBatDauChuongTrinh, ngayKetThucChuongTrinh, giamGiaChuongTrinh,
                            ngayTaoChuongTrinh, ngaySuaChuongTrinh, trangThaiChuongTrinh
                    );
                    chuongTrinhList.add(chuongTrinh);
                }
            }
        } catch (SQLException e) {

        }
        return chuongTrinhList;
    }

    public int TongSoTrangChuongTrinh() {
        int TongCT = 0;
        String sql = "SELECT COUNT(*) FROM chuong_trinh_khuyen_mai";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql); ResultSet rs = pr.executeQuery()) {
            if (rs.next()) {
                TongCT = rs.getInt(1);
            }
        } catch (SQLException e) {
        }

        int pageSize = 5;
        return (int) Math.ceil((double) TongCT / pageSize);
    }

    public int addChuongTrinh(ChuongTrinhKhuyenMai ct) {
        sql = "INSERT INTO [dbo].[chuong_trinh_khuyen_mai] ([ma_chuong_trinh_khuyen_mai], [ten_chuong_trinh_khuyen_mai], [mo_ta], [ngay_bat_dau], [ngay_ket_thuc], [giam_gia], [ngay_tao], [trang_thai])VALUES (?,?,?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, ct.getMaChuongTrinh());
            pr.setObject(2, ct.getTenChuongTrinh());
            pr.setObject(3, ct.getMoTaChuongTrinh());
            pr.setObject(4, ct.getNgayBatDauChuongTrinh());
            pr.setObject(5, ct.getNgayKetThucChuongTrinh());
            pr.setObject(6, ct.getGiamGiaChuongTrinh());
            pr.setObject(7, ct.getNgayTaoChuongTrinh());
            pr.setObject(8, ct.getTrangThaiChuongTrinh());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateChuongTrinh(ChuongTrinhKhuyenMai ct, int id) {
        sql = "update [dbo].[chuong_trinh_khuyen_mai] set [ma_chuong_trinh_khuyen_mai]=?, [ten_chuong_trinh_khuyen_mai]=?, [mo_ta]=?, [ngay_bat_dau]=?, [ngay_ket_thuc]=?, [giam_gia]=?, [trang_thai]=?, [ngay_sua]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, ct.getMaChuongTrinh());
            pr.setObject(2, ct.getTenChuongTrinh());
            pr.setObject(3, ct.getMoTaChuongTrinh());
            pr.setObject(4, ct.getNgayBatDauChuongTrinh());
            pr.setObject(5, ct.getNgayKetThucChuongTrinh());
            pr.setObject(6, ct.getGiamGiaChuongTrinh());
            pr.setObject(7, ct.getTrangThaiChuongTrinh());
            pr.setObject(8, ct.getNgaySuaChuongTrinh());
            pr.setObject(9, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<ChuongTrinhKhuyenMai> searchByTenChuongTrinh(String tenChuongTrinhTk) {
        List<ChuongTrinhKhuyenMai> chuongTrinhList = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[chuong_trinh_khuyen_mai] WHERE ten_chuong_trinh_khuyen_mai LIKE ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, "%" + tenChuongTrinhTk + "%");

            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String maChuongTrinh = rs.getString("ma_chuong_trinh_khuyen_mai");
                    String tenChuongTrinh = rs.getString("ten_chuong_trinh_khuyen_mai");
                    String moTaChuongTrinh = rs.getString("mo_ta");
                    Date ngayBatDauChuongTrinh = rs.getDate("ngay_bat_dau");
                    Date ngayKetThucChuongTrinh = rs.getDate("ngay_ket_thuc");
                    int giamGiaChuongTrinh = rs.getInt("giam_gia");
                    Date ngayTaoChuongTrinh = rs.getDate("ngay_tao");
                    Date ngaySuaChuongTrinh = rs.getDate("ngay_sua");
                    int trangThaiChuongTrinh = rs.getInt("trang_thai");
                    ChuongTrinhKhuyenMai chuongTrinh = new ChuongTrinhKhuyenMai(
                            id,
                            maChuongTrinh,
                            tenChuongTrinh,
                            moTaChuongTrinh,
                            ngayBatDauChuongTrinh,
                            ngayKetThucChuongTrinh,
                            giamGiaChuongTrinh,
                            ngayTaoChuongTrinh,
                            ngaySuaChuongTrinh,
                            trangThaiChuongTrinh
                    );
                    chuongTrinhList.add(chuongTrinh);
                }
            }
        } catch (SQLException e) {

        }
        return chuongTrinhList;
    }

    public List<ChuongTrinhKhuyenMai> LocTrangThai(int trangThai) {
        List<ChuongTrinhKhuyenMai> chuongTrinhList = new ArrayList<>();
        String sql = "SELECT * FROM chuong_trinh_khuyen_mai WHERE trang_thai = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, trangThai);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String maChuongTrinh = rs.getString("ma_chuong_trinh_khuyen_mai");
                    String tenChuongTrinh = rs.getString("ten_chuong_trinh_khuyen_mai");
                    String moTaChuongTrinh = rs.getString("mo_ta");
                    Date ngayBatDauChuongTrinh = rs.getDate("ngay_bat_dau");
                    Date ngayKetThucChuongTrinh = rs.getDate("ngay_ket_thuc");
                    int giamGiaChuongTrinh = rs.getInt("giam_gia");
                    Date ngayTaoChuongTrinh = rs.getDate("ngay_tao");
                    Date ngaySuaChuongTrinh = rs.getDate("ngay_sua");
                    int trangThaiChuongTrinh = rs.getInt("trang_thai");
                    ChuongTrinhKhuyenMai chuongTrinh = new ChuongTrinhKhuyenMai(
                            id, maChuongTrinh, tenChuongTrinh, moTaChuongTrinh,
                            ngayBatDauChuongTrinh, ngayKetThucChuongTrinh, giamGiaChuongTrinh,
                            ngayTaoChuongTrinh, ngaySuaChuongTrinh, trangThaiChuongTrinh
                    );
                    chuongTrinhList.add(chuongTrinh);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chuongTrinhList;
    }

    public boolean checkTrungMa(String maChuongTrinh) {
        String sql = "SELECT COUNT(*) FROM chuong_trinh_khuyen_mai WHERE ma_chuong_trinh_khuyen_mai = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, maChuongTrinh);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ChuongTrinhKhuyenMai> getAllChuongTrinhKM() {
        ArrayList<ChuongTrinhKhuyenMai> list = new ArrayList<>();
        String sql = """
                SELECT [ten_chuong_trinh_khuyen_mai]
                  FROM [dbo].[chuong_trinh_khuyen_mai] WHERE trang_thai = 1 AND [ngay_bat_dau] <= GETDATE()
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String tenkhuyenMai = rs.getString("ten_chuong_trinh_khuyen_mai");
                ChuongTrinhKhuyenMai chuongTrinhKM = new ChuongTrinhKhuyenMai(tenkhuyenMai);
                list.add(chuongTrinhKM);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChuongTrinhKhuyenMai getTenChuongTrinhKM(String name) {
        String sql = """
                SELECT [id]
                        ,[ma_chuong_trinh_khuyen_mai]
                        ,[ten_chuong_trinh_khuyen_mai]
                        ,[mo_ta]
                        ,[ngay_bat_dau]
                        ,[ngay_ket_thuc]
                        ,[giam_gia]
                        ,[ngay_tao]
                        ,[ngay_sua]
                        ,[trang_thai]
                    FROM [dbo].[chuong_trinh_khuyen_mai]
                  where ten_chuong_trinh_khuyen_mai = ? 
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, name);
            ResultSet rs = pr.executeQuery();
            ChuongTrinhKhuyenMai ChuongTrinhKhuyenMai = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String maChuongtrinhKM = rs.getString("ma_chuong_trinh_khuyen_mai");
                String tenChuongtrinhKM = rs.getString("ten_chuong_trinh_khuyen_mai");
                String moTa = rs.getString("mo_ta");
                java.util.Date ngayBatdau = rs.getDate("ngay_bat_dau");
                java.util.Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                int giamGia = rs.getInt("giam_gia");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");
                ChuongTrinhKhuyenMai = new ChuongTrinhKhuyenMai(id, maChuongtrinhKM, tenChuongtrinhKM, moTa, ngayBatdau, ngayKetThuc, giamGia, ngayTao, ngaySua, trangThai);
            }

            return ChuongTrinhKhuyenMai;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
