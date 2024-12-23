/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDonChiTiet;
import Model.SPCT;
import com.sun.jdi.connect.spi.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ultis.DBConnect;

/**
 * @author Admin
 */
public class HoaDonChiTietService {

    private java.sql.Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public HoaDonChiTietService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<HoaDonChiTiet> getAllHoaDonChiTiet(int idHoaDon) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT hct.id, hd.ma_hoa_don, spct.ma_san_pham_chi_tiet, sp.ten_san_pham, hct.so_luong, hct.gia_ban, hct.thanh_tien "
                + "FROM hoa_don_chi_tiet hct "
                + "JOIN hoa_don hd ON hct.id_hoa_don = hd.id "
                + "JOIN san_pham_chi_tiet spct ON hct.id_san_pham_chi_tiet = spct.id "
                + "JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE hct.id_hoa_don = ?";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, idHoaDon);
            rs = pr.executeQuery();

            while (rs.next()) {
                HoaDonChiTiet hct = new HoaDonChiTiet();
                hct.setId(rs.getInt("id"));
                hct.setMaHoaDon(rs.getString("ma_hoa_don"));
                hct.setMaSPCT(rs.getString("ma_san_pham_chi_tiet"));
                hct.setTenSanPham(rs.getString("ten_san_pham"));
                hct.setSoLuong(rs.getInt("so_luong"));
                hct.setGiaBan(rs.getFloat("gia_ban"));
                hct.setThanhTien(rs.getFloat("thanh_tien"));

                list.add(hct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveToDatabase(HoaDonChiTiet hdct) {
        String sql = "INSERT INTO hoa_don_chi_tiet (id_hoa_don, id_san_pham_chi_tiet, so_luong, gia_ban, thanh_tien) VALUES (?, ?, ?, ?, ?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, hdct.getIdHoaDon());
            pr.setInt(2, hdct.getIdSanPham());
            pr.setInt(3, hdct.getSoLuong());
            pr.setFloat(4, hdct.getGiaBan());
            pr.setFloat(5, hdct.getThanhTien());
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateSoLuong(int idhoadon, int idSPCT, int soLuongMoi, float thanhTienMoi) {
        String sql = "UPDATE hoa_don_chi_tiet SET so_luong = ?, thanh_tien = ? WHERE id_san_pham_chi_tiet = ? AND id_hoa_don = ?";

        try {

            pr = con.prepareStatement(sql);

            pr.setInt(1, soLuongMoi);
            pr.setFloat(2, thanhTienMoi);
            pr.setInt(3, idSPCT);
            pr.setInt(4, idhoadon);
            pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateHoaDonChiTiet(int idhdct, int soLuongMoi, float thanhTienMoi) {
        String sql = "UPDATE san_pham_chi_tiet "
                + "SET so_luong = ?, thanh_tien = ? "
                + "WHERE id = ?";

        try {
            pr = con.prepareStatement(sql);

            pr.setInt(1, soLuongMoi);
            pr.setFloat(2, thanhTienMoi);
            pr.setInt(3, idhdct);

            int rowsAffected = pr.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void delete(int idHoaDonChiTiet) {
        String sql = "DELETE FROM hoa_don_chi_tiet WHERE id = ?";
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, idHoaDonChiTiet);
            pr.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi xóa hóa đơn chi tiết: " + e.getMessage(), e);
        }
    }

    public HoaDonChiTiet getSuaHoaDon(int idHoaDon) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT hct.id, hd.ma_hoa_don, spct.ma_san_pham_chi_tiet, sp.ten_san_pham, hct.so_luong, hct.gia_ban, hct.thanh_tien "
                + "FROM hoa_don_chi_tiet hct "
                + "JOIN hoa_don hd ON hct.id_hoa_don = hd.id "
                + "JOIN san_pham_chi_tiet spct ON hct.id_san_pham_chi_tiet = spct.id "
                + "JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE hct.id_hoa_don = ?";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, idHoaDon);
            rs = pr.executeQuery();

            while (rs.next()) {
                HoaDonChiTiet hct = new HoaDonChiTiet();
                hct.setId(rs.getInt("id"));
                hct.setMaHoaDon(rs.getString("ma_hoa_don"));
                hct.setMaSPCT(rs.getString("ma_san_pham_chi_tiet"));
                hct.setTenSanPham(rs.getString("ten_san_pham"));
                hct.setSoLuong(rs.getInt("so_luong"));
                hct.setGiaBan(rs.getFloat("gia_ban"));
                hct.setThanhTien(rs.getFloat("thanh_tien"));

                list.add(hct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<HoaDonChiTiet> getAllDanhSachHoaDon(int idHoaDon) {
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        String sql = "SELECT hct.id, hd.ma_hoa_don, spct.ma_san_pham_chi_tiet, sp.ten_san_pham, "
                + "ms.ten_mau AS ten_mau_sac, kt.ten_kich_thuoc AS ten_kich_thuoc, dg.ten_de_giay AS ten_de_giay, "
                + "hct.so_luong, hct.gia_ban, hct.thanh_tien "
                + "FROM hoa_don_chi_tiet hct "
                + "JOIN hoa_don hd ON hct.id_hoa_don = hd.id "
                + "JOIN san_pham_chi_tiet spct ON hct.id_san_pham_chi_tiet = spct.id "
                + "JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "JOIN mau_sac ms ON spct.id_mau_sac = ms.id "
                + "JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "
                + "JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "
                + "WHERE hct.id_hoa_don = ?";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, idHoaDon);
            rs = pr.executeQuery();

            while (rs.next()) {
                HoaDonChiTiet hct = new HoaDonChiTiet(
                        rs.getInt("id"),
                        rs.getString("ma_hoa_don"),
                        rs.getString("ma_san_pham_chi_tiet"),
                        rs.getString("ten_san_pham"),
                        rs.getString("ten_mau_sac"),
                        rs.getString("ten_kich_thuoc"),
                        rs.getString("ten_de_giay"),
                        rs.getInt("so_luong"),
                        rs.getFloat("gia_ban"),
                        rs.getFloat("thanh_tien")
                );
                list.add(hct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public HoaDonChiTiet SearchHoaDonChiTiet(int id) {
        String sql = "SELECT id,so_luong FROM hoa_don_chi_tiet WHERE id = ?";
        HoaDonChiTiet hdct = null;
        try (java.sql.Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, id);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    hdct = new HoaDonChiTiet(
                            rs.getInt("id"),

                            rs.getInt("so_luong")

                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


        return hdct;
    }
}
