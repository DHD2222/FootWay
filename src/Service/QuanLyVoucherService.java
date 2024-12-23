/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Voucher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ultis.DBConnect;

/**
 * @author Duong
 */
public class QuanLyVoucherService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public QuanLyVoucherService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Voucher> getAllVoucher(int page) {
        ArrayList<Voucher> listVoucher = new ArrayList<>();
        int pageSize = 5;
        int offset = (page - 1) * pageSize;
        sql = "SELECT id, ma_voucher, ten_voucher, mo_ta, ngay_bat_dau, ngay_ket_thuc, giam_gia, giam_toi_da, don_toi_thieu, ngay_tao, ngay_sua, trang_thai "
                + "FROM voucher "
                + "WHERE id > 1 "
                + "ORDER BY id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, offset);
            pr.setInt(2, pageSize);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String moTa = rs.getString(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                int giamGia = rs.getInt(7);
                int giamToiDa = rs.getInt(8);
                int donToiThieu = rs.getInt(9);
                Date ngayTao = rs.getDate(10);
                Date ngaySua = rs.getDate(11);
                int trangThai = rs.getInt(12);
                Voucher v = new Voucher(id, ma, ten, moTa, ngayBatDau, ngayKetThuc, giamGia, giamToiDa, donToiThieu, ngayTao, ngaySua, trangThai);
                listVoucher.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listVoucher;
    }

    public int getTongSoTrang() {
        int TongVoucher = 0;
        sql = "SELECT COUNT(*) FROM voucher";
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            if (rs.next()) {
                TongVoucher = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int pageSize = 5;
        return (int) Math.ceil((double) TongVoucher / pageSize);
    }

    public int addVoucher(Voucher v) {
        sql = "INSERT INTO [dbo].[voucher] ([ma_voucher], [ten_voucher], [mo_ta], [ngay_bat_dau], [ngay_ket_thuc], [giam_gia], [giam_toi_da], [don_toi_thieu], [ngay_tao], [trang_thai]) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, v.getMaVoucher());
            pr.setObject(2, v.getTenVocher());
            pr.setObject(3, v.getMoTa());
            pr.setObject(4, v.getNgayBatDau());
            pr.setObject(5, v.getNgayKetThuc());
            pr.setObject(6, v.getGiamGia());
            pr.setObject(7, v.getGiamToiDa());
            pr.setObject(8, v.getDonToiThieu());
            pr.setObject(9, v.getNgayTao());
            pr.setObject(10, v.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateVoucher(Voucher v, int id) {
        sql = "UPDATE [dbo].[voucher] SET [ma_voucher] = ?, [ten_voucher] = ?, [mo_ta] = ?, "
                + "[ngay_bat_dau] = ?, [ngay_ket_thuc] = ?, [giam_gia] = ?, [giam_toi_da] = ?, "
                + "[don_toi_thieu] = ?, [ngay_sua] = ?, [trang_thai] = ? WHERE [id] = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, v.getMaVoucher());
            pr.setObject(2, v.getTenVocher());
            pr.setObject(3, v.getMoTa());
            pr.setObject(4, v.getNgayBatDau());
            pr.setObject(5, v.getNgayKetThuc());
            pr.setObject(6, v.getGiamGia());
            pr.setObject(7, v.getGiamToiDa());
            pr.setObject(8, v.getDonToiThieu());
            pr.setObject(9, v.getNgaySua());
            pr.setObject(10, v.getTrangThai());
            pr.setObject(11, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean checkTrungMa(String maVoucher) {
        String sql = "SELECT COUNT(*) FROM voucher WHERE ma_voucher = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, maVoucher);
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

    public ArrayList<Voucher> searchVoucherByName(String tenVoucher) {
        ArrayList<Voucher> listVoucher = new ArrayList<>();
        sql = "SELECT id, ma_voucher, ten_voucher, mo_ta, ngay_bat_dau, ngay_ket_thuc, giam_gia, giam_toi_da, don_toi_thieu, ngay_tao, ngay_sua, trang_thai "
                + "FROM voucher "
                + "WHERE ten_voucher LIKE ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, "%" + tenVoucher + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String moTa = rs.getString(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                int giamGia = rs.getInt(7);
                int giamToiDa = rs.getInt(8);
                int donToiThieu = rs.getInt(9);
                Date ngayTao = rs.getDate(10);
                Date ngaySua = rs.getDate(11);
                int trangThai = rs.getInt(12);
                Voucher v = new Voucher(id, ma, ten, moTa, ngayBatDau, ngayKetThuc, giamGia, giamToiDa, donToiThieu, ngayTao, ngaySua, trangThai);
                listVoucher.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listVoucher;
    }

    public ArrayList<Voucher> LocTrangThai(int trangThai) {
        ArrayList<Voucher> listVoucher = new ArrayList<>();
        sql = "SELECT id, ma_voucher, ten_voucher, mo_ta, ngay_bat_dau, ngay_ket_thuc, giam_gia, giam_toi_da, don_toi_thieu, ngay_tao, ngay_sua, trang_thai "
                + "FROM voucher "
                + "WHERE trang_thai = ?";
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, trangThai);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String ma = rs.getString("ma_voucher");
                    String ten = rs.getString("ten_voucher");
                    String moTa = rs.getString("mo_ta");
                    Date ngayBatDau = rs.getDate("ngay_bat_dau");
                    Date ngayKetThuc = rs.getDate("ngay_ket_thuc");
                    int giamGia = rs.getInt("giam_gia");
                    int giamToiDa = rs.getInt("giam_toi_da");
                    int donToiThieu = rs.getInt("don_toi_thieu");
                    Date ngayTao = rs.getDate("ngay_tao");
                    Date ngaySua = rs.getDate("ngay_sua");
                    int trangThaiVoucher = rs.getInt("trang_thai");
                    Voucher v = new Voucher(id, ma, ten, moTa, ngayBatDau, ngayKetThuc, giamGia, giamToiDa, donToiThieu, ngayTao, ngaySua, trangThaiVoucher);
                    listVoucher.add(v);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listVoucher;
    }

    public ArrayList<Voucher> getTenVoucher() {
        ArrayList<Voucher> list = new ArrayList<>();
        String sql = """
                SELECT [ten_voucher]
                  FROM [dbo].[voucher]  WHERE [trang_thai] = 1
                     AND [ngay_bat_dau] <= GETDATE()
                """;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                String tenVoucher = rs.getString("ten_voucher");
                Voucher voucher = new Voucher(tenVoucher);
                list.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Voucher getVoucherByName(String voucherName) {
        String sql = "SELECT * FROM voucher WHERE ten_voucher = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, voucherName);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    return new Voucher(
                            rs.getInt("id"),
                            rs.getString("ma_voucher"),
                            rs.getString("ten_voucher"),
                            rs.getString("mo_ta"),
                            rs.getDate("ngay_bat_dau"),
                            rs.getDate("ngay_ket_thuc"),
                            rs.getInt("giam_gia"),
                            rs.getInt("giam_toi_da"),
                            rs.getInt("don_toi_thieu"),
                            rs.getDate("ngay_tao"),
                            rs.getDate("ngay_sua"),
                            rs.getInt("trang_thai")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
