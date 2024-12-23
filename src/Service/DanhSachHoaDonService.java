/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.DanhSachHoaDon;
import Model.HoaDon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ultis.DBConnect;

/**
 * @author Admin
 */
public class DanhSachHoaDonService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public DanhSachHoaDonService() {
        con = DBConnect.getConnection();
    }

    public List<DanhSachHoaDon> getDanhSachHoaDon() {
        List<DanhSachHoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = """
                SELECT 
                    hd.id AS hoa_don_id,
                    hd.ma_hoa_don,
                    nv.ten_nhan_vien AS nhan_vien,
                    kh.ten_khach_hang AS khach_hang,
                    vc.ten_voucher AS voucher,
                    hd.tong_tien,
                    hd.thanh_toan,
                    hd.ngay_tao AS ngay_tao_hoa_don,
                    hd.trang_thai
                FROM 
                    hoa_don hd
                JOIN 
                    nhan_vien nv ON hd.id_nhan_vien = nv.id
                JOIN 
                    khach_hang kh ON hd.id_khach_hang = kh.id
                LEFT JOIN 
                    voucher vc ON hd.id_voucher = vc.id
                WHERE 
                    hd.trang_thai IN (1, 3); -- Chỉ lấy trạng thái 1 (Đã thanh toán) và 3 (Hủy thanh toán)
                """;

        try (PreparedStatement pr = con.prepareStatement(sql); ResultSet rs = pr.executeQuery()) {
            while (rs.next()) {
                DanhSachHoaDon hoaDon = new DanhSachHoaDon();
                hoaDon.setId(rs.getInt("hoa_don_id"));
                hoaDon.setMaHoaDon(rs.getString("ma_hoa_don"));
                hoaDon.setTenNhanVien(rs.getString("nhan_vien"));
                hoaDon.setTenKhachHang(rs.getString("khach_hang"));
                hoaDon.setVoucher(rs.getString("voucher"));
                hoaDon.setTongTienTruocVoucher(rs.getFloat("tong_tien"));
                hoaDon.setTongTien(rs.getFloat("thanh_toan"));
                hoaDon.setNgayTao(rs.getDate("ngay_tao_hoa_don"));
                hoaDon.setTrangThai(rs.getInt("trang_thai"));
                danhSachHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Có thể thay thế bằng ghi log
        }
        return danhSachHoaDon;
    }

    public List<DanhSachHoaDon> timKiemHoaDonTheoMa(String maHoaDon) {
        List<DanhSachHoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = """
            SELECT 
                hd.id AS hoa_don_id,
                hd.ma_hoa_don,
                nv.ten_nhan_vien AS nhan_vien,
                kh.ten_khach_hang AS khach_hang,
                vc.ten_voucher AS voucher,
                hd.tong_tien,
                hd.thanh_toan,
                hd.ngay_tao AS ngay_tao_hoa_don,
                hd.trang_thai
            FROM 
                hoa_don hd
            JOIN 
                nhan_vien nv ON hd.id_nhan_vien = nv.id
            JOIN 
                khach_hang kh ON hd.id_khach_hang = kh.id
            LEFT JOIN 
                voucher vc ON hd.id_voucher = vc.id
            WHERE 
                hd.ma_hoa_don LIKE ? AND hd.trang_thai IN (1, 3); -- Chỉ lấy trạng thái 1 (Đã thanh toán) và 3 (Hủy thanh toán)
            """;

        try (PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setString(1, "%" + maHoaDon + "%");
            rs = pr.executeQuery();

            while (rs.next()) {
                DanhSachHoaDon hoaDon = new DanhSachHoaDon();
                hoaDon.setId(rs.getInt("hoa_don_id"));
                hoaDon.setMaHoaDon(rs.getString("ma_hoa_don"));
                hoaDon.setTenNhanVien(rs.getString("nhan_vien"));
                hoaDon.setTenKhachHang(rs.getString("khach_hang"));
                hoaDon.setVoucher(rs.getString("voucher"));
                hoaDon.setTongTienTruocVoucher(rs.getFloat("tong_tien"));
                hoaDon.setTongTien(rs.getFloat("thanh_toan"));
                hoaDon.setNgayTao(rs.getDate("ngay_tao_hoa_don"));
                hoaDon.setTrangThai(rs.getInt("trang_thai"));

                danhSachHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return danhSachHoaDon;
    }

    public List<DanhSachHoaDon> LocHoaDonTheoTrangThai(String trangThai) {
        List<DanhSachHoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = """
                SELECT 
                    hd.id AS hoa_don_id,
                    hd.ma_hoa_don,
                    nv.ten_nhan_vien AS nhan_vien,
                    kh.ten_khach_hang AS khach_hang,
                    vc.ten_voucher AS voucher,
                    hd.tong_tien,
                    hd.thanh_toan,
                    hd.ngay_tao AS ngay_tao_hoa_don,
                    hd.trang_thai
                FROM 
                    hoa_don hd
                JOIN 
                    nhan_vien nv ON hd.id_nhan_vien = nv.id
                JOIN 
                    khach_hang kh ON hd.id_khach_hang = kh.id
                LEFT JOIN 
                    voucher vc ON hd.id_voucher = vc.id
                WHERE 
                    hd.trang_thai = ?;
                """;

        try (PreparedStatement pr = con.prepareStatement(sql)) {
            // Kiểm tra trạng thái và truyền vào query tương ứng
            if ("Đã thanh toán".equals(trangThai)) {
                pr.setInt(1, 1);  // Trạng thái "Đã thanh toán" = 1
            } else if ("Hủy thanh toán".equals(trangThai)) {
                pr.setInt(1, 3);  // Trạng thái "Hủy thanh toán" = 3
            } else {
                throw new Exception("Trạng thái không hợp lệ");
            }

            rs = pr.executeQuery();

            while (rs.next()) {
                DanhSachHoaDon hoaDon = new DanhSachHoaDon();
                hoaDon.setId(rs.getInt("hoa_don_id"));
                hoaDon.setMaHoaDon(rs.getString("ma_hoa_don"));
                hoaDon.setTenNhanVien(rs.getString("nhan_vien"));
                hoaDon.setTenKhachHang(rs.getString("khach_hang"));
                hoaDon.setVoucher(rs.getString("voucher"));
                hoaDon.setTongTienTruocVoucher(rs.getFloat("tong_tien"));
                hoaDon.setTongTien(rs.getFloat("thanh_toan"));
                hoaDon.setNgayTao(rs.getDate("ngay_tao_hoa_don"));
                hoaDon.setTrangThai(rs.getInt("trang_thai"));
                danhSachHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }

    public List<DanhSachHoaDon> timKiemHoaDonTheoKhoangTien(String trangThai, double minTien, double maxTien) {
        List<DanhSachHoaDon> danhSachHoaDon = new ArrayList<>();
        String sql = """
                SELECT 
                    hd.id AS hoa_don_id,
                    hd.ma_hoa_don,
                    nv.ten_nhan_vien AS nhan_vien,
                    kh.ten_khach_hang AS khach_hang,
                    vc.ten_voucher AS voucher,
                    hd.tong_tien,
                    hd.thanh_toan,
                    hd.ngay_tao AS ngay_tao_hoa_don,
                    hd.trang_thai
                FROM 
                    hoa_don hd
                JOIN 
                    nhan_vien nv ON hd.id_nhan_vien = nv.id
                JOIN 
                    khach_hang kh ON hd.id_khach_hang = kh.id
                LEFT JOIN 
                    voucher vc ON hd.id_voucher = vc.id
                WHERE 
                    hd.trang_thai = ? AND hd.thanh_toan >= ? AND hd.thanh_toan <= ?
                ORDER BY 
                    hd.ngay_tao DESC;
            """;
        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, trangThai);  
            pr.setDouble(2, minTien);    
            pr.setDouble(3, maxTien);    
            rs = pr.executeQuery();
            while (rs.next()) {
                DanhSachHoaDon hoaDon = new DanhSachHoaDon();
                hoaDon.setId(rs.getInt("hoa_don_id"));
                hoaDon.setMaHoaDon(rs.getString("ma_hoa_don"));
                hoaDon.setTenNhanVien(rs.getString("nhan_vien"));
                hoaDon.setTenKhachHang(rs.getString("khach_hang"));
                hoaDon.setVoucher(rs.getString("voucher"));
                hoaDon.setTongTienTruocVoucher(rs.getFloat("tong_tien"));
                hoaDon.setTongTien(rs.getFloat("thanh_toan"));
                hoaDon.setNgayTao(rs.getDate("ngay_tao_hoa_don"));
                hoaDon.setTrangThai(rs.getInt("trang_thai"));
                danhSachHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }
    
}
