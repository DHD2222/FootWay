/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.ThongKe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ultis.DBConnect;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ThongKeService {

    private java.sql.Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ThongKeService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<ThongKe> selectAll() {
        ArrayList<ThongKe> list = new ArrayList<>();
        String sql = """
                     SELECT 
                        dbo.hoa_don.ma_hoa_don, 
                        dbo.hoa_don.ngay_tao, 
                        dbo.hoa_don.thanh_toan, 
                         
                        dbo.nhan_vien.ten_nhan_vien AS ten_nhan_vien, 
                        CASE WHEN dbo.hoa_don.id_khach_hang IS NOT NULL THEN dbo.khach_hang.ten_khach_hang ELSE NULL END AS ten_khach_hang, 
                        CASE WHEN dbo.hoa_don.id_khach_hang IS NOT NULL THEN dbo.khach_hang.so_dien_thoai ELSE NULL END AS SDT, 
                        CASE WHEN dbo.hoa_don.id_voucher IS NOT NULL THEN dbo.voucher.ma_voucher ELSE NULL END AS ma_voucher, 
                        dbo.hoa_don.trang_thai
                    FROM 
                        dbo.hoa_don 
                    INNER JOIN 
                        dbo.nhan_vien ON dbo.hoa_don.id_nhan_vien = dbo.nhan_vien.id 
                    LEFT JOIN 
                        dbo.khach_hang ON dbo.hoa_don.id_khach_hang = dbo.khach_hang.id 
                    LEFT JOIN 
                        dbo.voucher ON dbo.hoa_don.id_voucher = dbo.voucher.id
                    
                     """;

        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                tk.setMaHoaDon(rs.getString("ma_hoa_don"));
                tk.setNgayTao(rs.getDate("ngay_tao"));
                tk.setTongTien(rs.getDouble("thanh_toan"));
                tk.setTenNhanVien(rs.getString("ten_nhan_vien"));
                tk.setTenKhachHang(rs.getString("ten_khach_hang"));
                tk.setSdt(rs.getString("SDT"));
                tk.setMaVoucher(rs.getString("ma_voucher"));
                tk.setTrangThai(rs.getInt("trang_thai"));
                list.add(tk);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<ThongKe> TimKiemKhoangTG(Date startDate, Date endDate) {
        ArrayList<ThongKe> list = new ArrayList<>();
        String sql = """
                     SELECT 
                        dbo.hoa_don.ma_hoa_don, 
                        dbo.hoa_don.ngay_tao, 
                        dbo.hoa_don.thanh_toan, 
                        dbo.nhan_vien.ten_nhan_vien AS ten_nhan_vien, 
                        CASE WHEN dbo.hoa_don.id_khach_hang IS NOT NULL THEN dbo.khach_hang.ten_khach_hang ELSE NULL END AS ten_khach_hang, 
                        CASE WHEN dbo.hoa_don.id_khach_hang IS NOT NULL THEN dbo.khach_hang.so_dien_thoai ELSE NULL END AS SDT, 
                        CASE WHEN dbo.hoa_don.id_voucher IS NOT NULL THEN dbo.voucher.ma_voucher ELSE NULL END AS ma_voucher, 
                        dbo.hoa_don.trang_thai
                    FROM 
                        dbo.hoa_don 
                    INNER JOIN 
                        dbo.nhan_vien ON dbo.hoa_don.id_nhan_vien = dbo.nhan_vien.id 
                    LEFT JOIN 
                        dbo.khach_hang ON dbo.hoa_don.id_khach_hang = dbo.khach_hang.id 
                    LEFT JOIN 
                        dbo.voucher ON dbo.hoa_don.id_voucher = dbo.voucher.id
                    WHERE 
                        dbo.hoa_don.ngay_tao BETWEEN ? AND ?
                     """;
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setDate(1, startDate);
            pr.setDate(2, endDate);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    ThongKe tk = new ThongKe();
                    tk.setMaHoaDon(rs.getString("ma_hoa_don"));
                    tk.setNgayTao(rs.getDate("ngay_tao"));
                    tk.setTongTien(rs.getDouble("thanh_toan"));
                    tk.setTenNhanVien(rs.getString("ten_nhan_vien"));
                    tk.setTenKhachHang(rs.getString("ten_khach_hang"));
                    tk.setSdt(rs.getString("SDT"));
                    tk.setMaVoucher(rs.getString("ma_voucher"));
                    tk.setTrangThai(rs.getInt("trang_thai"));
                    list.add(tk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Integer> getYears() {
        List<Integer> years = new ArrayList<>();
        String sql = "SELECT DISTINCT YEAR(ngay_tao) AS nam FROM dbo.hoa_don ORDER BY nam DESC";
        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            while (rs.next()) {
                int year = rs.getInt("nam");
                years.add(year);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return years;
    }

    public List<ThongKe> selectByYear(int year) {
        List<ThongKe> list = new ArrayList<>();
        String sql = """
                 SELECT 
                    dbo.hoa_don.ma_hoa_don, 
                    dbo.hoa_don.ngay_tao, 
                    dbo.hoa_don.thanh_toan, 
                    dbo.nhan_vien.ten_nhan_vien AS ten_nhan_vien, 
                    CASE WHEN dbo.hoa_don.id_khach_hang IS NOT NULL THEN dbo.khach_hang.ten_khach_hang ELSE NULL END AS ten_khach_hang, 
                    CASE WHEN dbo.hoa_don.id_khach_hang IS NOT NULL THEN dbo.khach_hang.so_dien_thoai ELSE NULL END AS SDT, 
                    CASE WHEN dbo.hoa_don.id_voucher IS NOT NULL THEN dbo.voucher.ma_voucher ELSE NULL END AS ma_voucher, 
                    dbo.hoa_don.trang_thai
                FROM 
                    dbo.hoa_don 
                INNER JOIN 
                    dbo.nhan_vien ON dbo.hoa_don.id_nhan_vien = dbo.nhan_vien.id 
                LEFT JOIN 
                    dbo.khach_hang ON dbo.hoa_don.id_khach_hang = dbo.khach_hang.id 
                LEFT JOIN 
                    dbo.voucher ON dbo.hoa_don.id_voucher = dbo.voucher.id
                WHERE 
                    YEAR(dbo.hoa_don.ngay_tao) = ?
                 """;

        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, year);
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    ThongKe tk = new ThongKe();
                    tk.setMaHoaDon(rs.getString("ma_hoa_don"));
                    tk.setNgayTao(rs.getDate("ngay_tao"));
                    tk.setTongTien(rs.getDouble("thanh_toan"));
                    tk.setTenNhanVien(rs.getString("ten_nhan_vien"));
                    tk.setTenKhachHang(rs.getString("ten_khach_hang"));
                    tk.setSdt(rs.getString("SDT"));
                    tk.setMaVoucher(rs.getString("ma_voucher"));
                    tk.setTrangThai(rs.getInt("trang_thai"));
                    list.add(tk);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
