/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.KhachHang;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ultis.DBConnect;

/**
 * @author Duong
 */
public class QuanLyKhachHangService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public QuanLyKhachHangService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<KhachHang> getAllKhachHang(int page) {
        ArrayList<KhachHang> list = new ArrayList<>();
        int pageSize = 5;
        int offset = (page - 1) * pageSize;
        sql = "SELECT id, ma_khach_hang, ten_khach_hang, gioi_tinh, dia_chi, so_dien_thoai, email, ghi_chu, ngay_tao, ngay_sua, trang_thai "
                + "FROM khach_hang "
                + "WHERE id > 1 "
                + "ORDER BY id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, offset);
            pr.setInt(2, pageSize);
            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("ma_khach_hang");
                String ten = rs.getString("ten_khach_hang");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                String diaChi = rs.getString("dia_chi");
                String sdt = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String ghiChu = rs.getString("ghi_chu");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");
                KhachHang k = new KhachHang(id, ma, ten, gioiTinh, diaChi, sdt, email, ghiChu, ngayTao, ngaySua, trangThai);
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTongSoTrang() {
        int TongKH = 0;
        sql = "SELECT COUNT(*) FROM khach_hang";
        try (PreparedStatement pr = con.prepareStatement(sql); ResultSet rs = pr.executeQuery()) {
            if (rs.next()) {
                TongKH = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageSize = 5;
        return (int) Math.ceil((double) TongKH / pageSize);
    }

    public int addKhachHang(KhachHang k) {
        sql = "INSERT INTO [dbo].[khach_hang] ([ma_khach_hang], [ten_khach_hang],[gioi_tinh],[dia_chi],[so_dien_thoai],[email], [ghi_chu],[ngay_tao], [trang_thai]) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, k.getMa());
            pr.setObject(2, k.getTen());
            pr.setObject(3, k.isGioiTinh());
            pr.setObject(4, k.getDiaChi());
            pr.setObject(5, k.getSdt());
            pr.setObject(6, k.getEmail());
            pr.setObject(7, k.getGhiChu());
            pr.setObject(8, k.getNgayTao());
            pr.setObject(9, k.getTrangThai());
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateKhachHang(KhachHang k, int id) {
        sql = "update [dbo].[khach_hang] set [ma_khach_hang]=?, [ten_khach_hang]=?,[gioi_tinh]=?,[dia_chi]=?,[so_dien_thoai]=?,[email]=?, [ghi_chu]=?,[ngay_sua]=?, [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, k.getMa());
            pr.setObject(2, k.getTen());
            pr.setObject(3, k.isGioiTinh());
            pr.setObject(4, k.getDiaChi());
            pr.setObject(5, k.getSdt());
            pr.setObject(6, k.getEmail());
            pr.setObject(7, k.getGhiChu());
            pr.setObject(8, k.getNgaySua());
            pr.setObject(9, k.getTrangThai());
            pr.setObject(10, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<KhachHang> SearchKhachHang(String tentk) {
        sql = "select id,ma_khach_hang,ten_khach_hang,gioi_tinh,dia_chi,so_dien_thoai,email,ghi_chu,ngay_tao,ngay_sua,trang_thai from khach_hang where ten_khach_hang like ?";
        ArrayList<KhachHang> list = new ArrayList<>();
        try {

            pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + tentk + "%");
            rs = pr.executeQuery();
            while (rs.next()) {
                int id, trangThai;
                String ma, ten, diaChi, sdt, email, ghiChu;
                Boolean gioiTinh;
                Date ngayTao, ngaySua;
                id = rs.getInt(1);
                ma = rs.getString(2);
                ten = rs.getString(3);
                gioiTinh = rs.getBoolean(4);
                diaChi = rs.getString(5);
                sdt = rs.getString(6);
                email = rs.getString(7);
                ghiChu = rs.getString(8);
                ngayTao = rs.getDate(9);
                ngaySua = rs.getDate(10);
                trangThai = rs.getInt(11);
                KhachHang k = new KhachHang(id, ma, ten, gioiTinh, diaChi, sdt, email, ghiChu, ngayTao, ngaySua, trangThai);
                list.add(k);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checktrungma(String maKhachHang) {
        sql = "SELECT COUNT(*) FROM khach_hang WHERE ma_khach_hang = ?";
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, maKhachHang);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false; 
    }

    public ArrayList<KhachHang> LocTrangThai(int status) {
        ArrayList<KhachHang> list = new ArrayList<>();
        sql = "SELECT id, ma_khach_hang, ten_khach_hang, gioi_tinh, dia_chi, so_dien_thoai, email, ghi_chu, ngay_tao, ngay_sua, trang_thai "
                + "FROM khach_hang "
                + "WHERE trang_thai = ? "
                + "ORDER BY id";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, status);
            rs = pr.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("ma_khach_hang");
                String ten = rs.getString("ten_khach_hang");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                String diaChi = rs.getString("dia_chi");
                String sdt = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String ghiChu = rs.getString("ghi_chu");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                KhachHang k = new KhachHang(id, ma, ten, gioiTinh, diaChi, sdt, email, ghiChu, ngayTao, ngaySua, trangThai);
                list.add(k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang getKhachHangById(int idKhachHang) {
        String sql = "SELECT id, ma_khach_hang, ten_khach_hang, gioi_tinh, dia_chi, so_dien_thoai, email, ghi_chu, ngay_tao, ngay_sua, trang_thai FROM khach_hang WHERE id = ?";
        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, idKhachHang);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String ma = rs.getString("ma_khach_hang");
                    String ten = rs.getString("ten_khach_hang");
                    boolean gioiTinh = rs.getBoolean("gioi_tinh");
                    String diaChi = rs.getString("dia_chi");
                    String sdt = rs.getString("so_dien_thoai");
                    String email = rs.getString("email");
                    String ghiChu = rs.getString("ghi_chu");
                    Date ngayTao = rs.getDate("ngay_tao");
                    Date ngaySua = rs.getDate("ngay_sua");
                    int trangThai = rs.getInt("trang_thai");

                    return new KhachHang(id, ma, ten, gioiTinh, diaChi, sdt, email, ghiChu, ngayTao, ngaySua, trangThai);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checktrungsodienthoai(String phoneNumber) {
        String sql = "SELECT COUNT(*) FROM khach_hang WHERE so_dien_thoai = ?";
        try (
            PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
