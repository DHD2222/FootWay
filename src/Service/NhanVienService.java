/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.NhanVien;

import java.sql.*;
import java.util.ArrayList;

import ultis.DBConnect;

/**
 * @author Admin
 */
public class NhanVienService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public NhanVienService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<NhanVien> getAllNhanVien(int page) {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();

        int pageSize = 5;
        int offset = (page - 1) * pageSize;

        sql = "SELECT id, ma_nhan_vien, ten_nhan_vien, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, "
                + "ten_dang_nhap, mat_khau, vai_tro, anh, ngay_tao, ngay_sua, trang_thai "
                + "FROM nhan_vien "
                + "ORDER BY id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, offset);
            pr.setInt(2, pageSize);

            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maNhanVien = rs.getString("ma_nhan_vien");
                String tenNhanVien = rs.getString("ten_nhan_vien");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                Date ngaySinh = rs.getDate("ngay_sinh");
                String diaChi = rs.getString("dia_chi");
                String soDienThoai = rs.getString("so_dien_thoai");
                String tenDangNhap = rs.getString("ten_dang_nhap");
                String matKhau = rs.getString("mat_khau");
                String vaiTro = rs.getString("vai_tro");
                String anh = rs.getString("anh");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                NhanVien nv = new NhanVien(id, maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, soDienThoai,
                        tenDangNhap, matKhau, vaiTro, anh, ngayTao, ngaySua, trangThai);
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    public int TongSoTrang() {
        int TongNhanVien = 0;
        sql = "SELECT COUNT(*) FROM nhan_vien";

        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            if (rs.next()) {
                TongNhanVien = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int pageSize = 5;
        return (int) Math.ceil((double) TongNhanVien / pageSize);
    }

    public int addNhanVien(NhanVien nv) {
        sql = "INSERT INTO nhan_vien (ma_nhan_vien, ten_nhan_vien, gioi_tinh, ngay_sinh, dia_chi, "
                + "so_dien_thoai, ten_dang_nhap, mat_khau, vai_tro, anh, ngay_tao, trang_thai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            pr = con.prepareStatement(sql);

            pr.setString(1, nv.getMaNhanVien());
            pr.setString(2, nv.getTenNhanVien());
            pr.setBoolean(3, nv.isGioiTinh());
            pr.setDate(4, new java.sql.Date(nv.getNgaySinh().getTime()));
            pr.setString(5, nv.getDiaChi());
            pr.setString(6, nv.getSoDienThoai());
            pr.setString(7, nv.getTenDangNhap());
            pr.setString(8, nv.getMatKhau());
            pr.setString(9, nv.getVaiTro());
            pr.setString(10, nv.getAnh());
            pr.setDate(11, new java.sql.Date(nv.getNgayTao().getTime()));  // Set the ngay_tao
            pr.setInt(12, nv.getTrangThai());

            return pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateNhanVien(NhanVien nv, int id) {
        sql = "UPDATE [dbo].[nhan_vien] SET [ma_nhan_vien] = ?, [ten_nhan_vien] = ?, [gioi_tinh] = ?, [ngay_sinh] = ?, "
                + "[dia_chi] = ?, [so_dien_thoai] = ?, [ten_dang_nhap] = ?, [mat_khau] = ?, [vai_tro] = ?, [anh] = ?, "
                + "[ngay_sua] = ?, [trang_thai] = ? WHERE [id] = ?";

        try {
            pr = con.prepareStatement(sql);

            pr.setObject(1, nv.getMaNhanVien());
            pr.setString(2, nv.getTenNhanVien());
            pr.setObject(3, nv.isGioiTinh());
            pr.setObject(4, nv.getNgaySinh());
            pr.setObject(5, nv.getDiaChi());
            pr.setObject(6, nv.getSoDienThoai());
            pr.setObject(7, nv.getTenDangNhap());
            pr.setObject(8, nv.getMatKhau());
            pr.setObject(9, nv.getVaiTro());
            pr.setObject(10, nv.getAnh());
            pr.setObject(11, nv.getNgaySua());
            pr.setObject(12, nv.getTrangThai());
            pr.setObject(13, id);

            return pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<NhanVien> searchNhanVienByMa(String MaNhanVien) {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();

        sql = "SELECT id, ma_nhan_vien, ten_nhan_vien, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, "
                + "ten_dang_nhap, mat_khau, vai_tro, anh, ngay_tao, ngay_sua, trang_thai "
                + "FROM nhan_vien "
                + "WHERE ma_nhan_vien LIKE ?";

        try {
            pr = con.prepareStatement(sql);
            pr.setString(1, "%" + MaNhanVien + "%");

            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maNhanVien = rs.getString("ma_nhan_vien");
                String name = rs.getString("ten_nhan_vien");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                Date ngaySinh = rs.getDate("ngay_sinh");
                String diaChi = rs.getString("dia_chi");
                String soDienThoai = rs.getString("so_dien_thoai");
                String tenDangNhap = rs.getString("ten_dang_nhap");
                String matKhau = rs.getString("mat_khau");
                String vaiTro = rs.getString("vai_tro");
                String anh = rs.getString("anh");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThai = rs.getInt("trang_thai");

                NhanVien nv = new NhanVien(id, maNhanVien, name, gioiTinh, ngaySinh, diaChi, soDienThoai,
                        tenDangNhap, matKhau, vaiTro, anh, ngayTao, ngaySua, trangThai);
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    public boolean checktrungma(String maNhanVien) {
        boolean exists = false;
        String sql = "SELECT COUNT(*) FROM nhan_vien WHERE ma_nhan_vien = ?";

        try (PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, maNhanVien);

            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    if (count > 0) {
                        exists = true;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }

    public ArrayList<NhanVien> checktrangthai(int trangThai) {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        sql = "SELECT id, ma_nhan_vien, ten_nhan_vien, gioi_tinh, ngay_sinh, dia_chi, so_dien_thoai, "
                + "ten_dang_nhap, mat_khau, vai_tro, anh, ngay_tao, ngay_sua, trang_thai "
                + "FROM nhan_vien "
                + "WHERE trang_thai = ?";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, trangThai);

            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maNhanVien = rs.getString("ma_nhan_vien");
                String tenNhanVien = rs.getString("ten_nhan_vien");
                boolean gioiTinh = rs.getBoolean("gioi_tinh");
                Date ngaySinh = rs.getDate("ngay_sinh");
                String diaChi = rs.getString("dia_chi");
                String soDienThoai = rs.getString("so_dien_thoai");
                String tenDangNhap = rs.getString("ten_dang_nhap");
                String matKhau = rs.getString("mat_khau");
                String vaiTro = rs.getString("vai_tro");
                String anh = rs.getString("anh");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int trangThaiValue = rs.getInt("trang_thai");

                NhanVien nv = new NhanVien(id, maNhanVien, tenNhanVien, gioiTinh, ngaySinh, diaChi, soDienThoai,
                        tenDangNhap, matKhau, vaiTro, anh, ngayTao, ngaySua, trangThaiValue);
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    public boolean checktrungsodienthoai(String phoneNumber) {

        String sql = "SELECT COUNT(*) FROM nhan_vien WHERE so_dien_thoai = ?";

        try (
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phoneNumber);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }
}
