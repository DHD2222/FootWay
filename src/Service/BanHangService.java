/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.HoaDon;
import Model.HoaDonChiTiet;
import Model.KhachHang;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.lang.model.util.Types;
import javax.swing.JOptionPane;

import ultis.DBConnect;

/**
 * @author Admin
 */
public class BanHangService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    ServiceLoGin serviceLoGin = new ServiceLoGin();

    public BanHangService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> hoaDonList = new ArrayList<>();
        String sql = "SELECT hd.id, nv.ten_nhan_vien, kh.ten_khach_hang, "
                + "hd.ma_hoa_don, hd.ngay_tao, hd.trang_thai "
                + "FROM hoa_don hd "
                + "JOIN nhan_vien nv ON hd.id_nhan_vien = nv.id "
                + "JOIN khach_hang kh ON hd.id_khach_hang = kh.id "
                + "WHERE hd.trang_thai = 0";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql); ResultSet rs = pr.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String mahd = rs.getString("ma_hoa_don");
                String tenNhanVien = rs.getString("ten_nhan_vien");
                String tenKhachHang = rs.getString("ten_khach_hang");
                Date ngayTao = rs.getDate("ngay_tao");
                int trangThai = rs.getInt("trang_thai");
                HoaDon hoaDon = new HoaDon(id, mahd, tenNhanVien, tenKhachHang, ngayTao, trangThai);
                hoaDonList.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hoaDonList;
    }

    public void addHoaDon(HoaDon hoaDon) {
        try {
            String sql = "INSERT INTO hoa_don (ma_hoa_don, id_nhan_vien, id_khach_hang, ngay_tao, trang_thai) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, hoaDon.getMaHoaDon());
            pst.setInt(2, hoaDon.getIdNhanVien());
            pst.setInt(3, hoaDon.getIdKhachHang());
            pst.setObject(4, hoaDon.getNgayTao());
            pst.setInt(5, hoaDon.getTrangThai());
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Hóa đơn đã được tạo thành công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi tạo hóa đơn!");
        }
    }

    public String TaoMaHoaDon() {
        String getMaxMaSQL = "SELECT MAX(CAST(SUBSTRING(ma_hoa_don, 3, LEN(ma_hoa_don)) AS INT)) AS maxMa "
                + "FROM hoa_don "
                + "WHERE ISNUMERIC(SUBSTRING(ma_hoa_don, 3, LEN(ma_hoa_don))) = 1";
        try (Connection con = DBConnect.getConnection(); PreparedStatement prMax = con.prepareStatement(getMaxMaSQL); ResultSet rs = prMax.executeQuery()) {
            String newMaHD = "HD001";
            if (rs.next() && rs.getString("maxMa") != null) {
                int maxMa = rs.getInt("maxMa");
                newMaHD = "HD" + String.format("%03d", maxMa + 1);
            }
            return newMaHD;
        } catch (Exception e) {
            e.printStackTrace();
            return "HD001";
        }
    }

    public KhachHang SearchKhachHang(String tentk) {
        sql = "SELECT id, ten_khach_hang, so_dien_thoai, trang_thai "
                + "FROM khach_hang "
                + "WHERE so_dien_thoai LIKE ?";

        try {
            KhachHang k = null;
            pr = con.prepareStatement(sql);
            pr.setString(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ten = rs.getString("ten_khach_hang");
                String sdt = rs.getString("so_dien_thoai");
                int trangThai = rs.getInt("trang_thai");
                k = new KhachHang(id, ten, sdt, trangThai);
            }
            return k;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean HuyHoaDon(int invoiceId, double totalBeforeDiscount, double totalAfterDiscount, Integer voucherId) {
        String sql = "UPDATE hoa_don SET tong_tien = ?, thanh_toan = ?, trang_thai = 3, id_voucher = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, totalBeforeDiscount);
            pst.setDouble(2, totalAfterDiscount);
            pst.setInt(3, voucherId);
            pst.setInt(4, invoiceId);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateSoLuong(int idSPCT, int newQuantity) {
        String sql = "UPDATE san_pham_chi_tiet SET so_luong = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, newQuantity);
            pst.setInt(2, idSPCT);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateInvoiceAfterPayment(int invoiceId, double totalAmount, double totalBeforeDiscount, Integer voucherId) {
        String sql = "UPDATE hoa_don SET thanh_toan = ?, tong_tien = ?, trang_thai = 1, id_voucher = ? WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, totalAmount);
            pst.setDouble(2, totalBeforeDiscount);
            if (voucherId != null) {
                pst.setInt(3, voucherId);
            } else {
                pst.setNull(3, java.sql.Types.INTEGER);
            }
            pst.setInt(4, invoiceId);
            int rowsAffected = pst.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getKhachHangIdByHoaDon(int hoadon) {
        String sql = "SELECT id_khach_hang FROM hoa_don WHERE id = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, hoadon);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_khach_hang");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

}
