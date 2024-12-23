/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SPCT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ultis.DBConnect;

/**
 * @author LAPTOP
 */
public class SPCTService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<SPCT> getAllSanPhamCT(int page, int idSp) {
        ArrayList<SPCT> spctList = new ArrayList<>();
        int pageSize = 5;
        int offset = (page - 1) * pageSize;

        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
                + "spct.don_gia, spct.mo_ta, spct.trang_thai, spct.ngay_tao, spct.ngay_sua, "
                + "ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
                + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.ten_chuong_trinh_khuyen_mai ELSE NULL END AS ten_khuyen_mai, "
                + "sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id " // Join color table
                + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id " // Join size table
                + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id " // Join shoe type table
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id " // Join promotion table
                + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id " // Join product table
                + "WHERE spct.id_san_pham = ? "
                + "ORDER BY spct.id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, idSp);
            pr.setInt(2, offset);
            pr.setInt(3, pageSize);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                String tenChuongTinhKM = rs.getString("ten_khuyen_mai");
                String tenSanPham = rs.getString("ten_san_pham");
                SPCT spct = new SPCT(id, maSanPhamCT, soLuong, donGia, moTa, trangThai, ngayTao, ngaySua, tenMauSac, tenKichThuoc, tenLoaiDG, tenChuongTinhKM, tenSanPham);
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spctList;
    }

    public ArrayList<SPCT> getAllSanPhamCTbanhang() {
        ArrayList<SPCT> spctList = new ArrayList<>();
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
                + "spct.don_gia, ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
                + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.giam_gia ELSE NULL END AS giam_gia, "
                + "sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "
                + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "
                + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id "
                + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE spct.trang_thai = 1";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                Integer giamGia = rs.getObject("giam_gia") != null ? rs.getInt("giam_gia") : 0;
                String tenSanPham = rs.getString("ten_san_pham");
                SPCT spct = new SPCT(giamGia, id, maSanPhamCT, soLuong, donGia, tenMauSac, tenKichThuoc, tenLoaiDG, tenSanPham);
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spctList;
    }

    public SPCT findById(int id) {
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, spct.don_gia, spct.mo_ta, spct.trang_thai, spct.ngay_tao, spct.ngay_sua, "
                + "ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, km.ten_chuong_trinh_khuyen_mai, sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "inner JOIN mau_sac ms ON spct.id_mau_sac = ms.id " // Join color table
                + "inner JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id " // Join size table
                + "inner JOIN loai_de_giay dg ON spct.id_de_giay = dg.id " // Join shoe type table
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id " // Join promotion table
                + "inner JOIN san_pham sp ON spct.id_san_pham = sp.id " // Join product table
                + "where spct.id = ?";
        SPCT spct = null;
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int idpct = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                String tenChuongTinhKM = rs.getString("ten_chuong_trinh_khuyen_mai");
                String tenSanPham = rs.getString("ten_san_pham");
                spct = new SPCT(idpct, maSanPhamCT, soLuong, donGia, moTa, trangThai, ngayTao, ngaySua, tenMauSac, tenKichThuoc, tenLoaiDG, tenChuongTinhKM, tenSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spct;
    }

    public int TongSoTrang(int id) {
        int TongSanPhamCT = 0;
        String sql = "SELECT COUNT(*) FROM san_pham_chi_tiet WHERE id_san_pham = ?";  // Sửa lại tên cột nếu cần
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, id);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    TongSanPhamCT = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageSize = 5;
        return (int) Math.ceil((double) TongSanPhamCT / pageSize);
    }

    public void addSanPhamCT(SPCT spct) {
        if (spct != null) {
            String sql = """
                    INSERT INTO [dbo].[san_pham_chi_tiet]
                               ([ma_san_pham_chi_tiet]
                               ,[so_luong]
                               ,[don_gia]
                               ,[mo_ta]
                               ,[id_mau_sac]
                               ,[id_kich_thuoc]
                               ,[id_de_giay]
                               ,[id_chuong_trinh_khuyen_mai]
                               ,[id_san_pham]
                               ,[ngay_tao]
                               ,[ngay_sua]
                               ,[trang_thai])
                         VALUES
                               (?,?,?,?,?,?,?,?,?,?,?,?)
                    """;
            try {
                con = DBConnect.getConnection();
                pr = con.prepareStatement(sql);
                pr.setObject(1, spct.getMaSPCT());
                pr.setObject(2, spct.getSoLuong());
                pr.setObject(3, spct.getDonGia());
                pr.setObject(4, spct.getMoTa());
                pr.setObject(5, spct.getIdMauSac());
                pr.setObject(6, spct.getIdKichThuoc());
                pr.setObject(7, spct.getIdDegiay());
                pr.setObject(8, spct.getIdChuongTrinhKM());
                pr.setObject(9, spct.getIdSanPham());
                pr.setObject(10, spct.getNgayTao());
                pr.setObject(11, spct.getNgaySua());
                pr.setObject(12, spct.getTrangThai());
                pr.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public String TaoMaSPCT() {
        String getMaxMaSQL = "SELECT MAX(CAST(SUBSTRING(ma_san_pham_chi_tiet, 5, LEN(ma_san_pham_chi_tiet)) AS INT)) AS maxMa "
                + "FROM san_pham_chi_tiet "
                + "WHERE ISNUMERIC(SUBSTRING(ma_san_pham_chi_tiet, 5, LEN(ma_san_pham_chi_tiet))) = 1";
        try (Connection con = DBConnect.getConnection(); PreparedStatement prMax = con.prepareStatement(getMaxMaSQL); ResultSet rs = prMax.executeQuery()) {
            String newMaSPCT = "SPCT001";
            if (rs.next() && rs.getString("maxMa") != null) {
                int maxMa = rs.getInt("maxMa");
                newMaSPCT = "SPCT" + String.format("%03d", maxMa + 1);
            }
            return newMaSPCT;
        } catch (Exception e) {
            e.printStackTrace();
            return "SPCT001";
        }
    }

    public void updateSanPhamCT(SPCT spct, Integer id) {
        if (spct != null) {
            String sql = """
                    UPDATE [dbo].[san_pham_chi_tiet]
                       SET [ma_san_pham_chi_tiet] = ?
                          ,[so_luong] = ?
                          ,[don_gia] = ?
                          ,[mo_ta] = ?
                          ,[id_mau_sac] =? 
                          ,[id_kich_thuoc] = ?
                          ,[id_de_giay] = ?
                          ,[id_chuong_trinh_khuyen_mai] = ?
                          ,[id_san_pham] = ?
                          ,[ngay_sua] = ?
                          ,[trang_thai] = ?
                     WHERE id = ?
                     """;

            try {
                con = DBConnect.getConnection();
                pr = con.prepareStatement(sql);
                pr.setObject(1, spct.getMaSPCT());
                pr.setObject(2, spct.getSoLuong());
                pr.setObject(3, spct.getDonGia());
                pr.setObject(4, spct.getMoTa());
                pr.setObject(5, spct.getIdMauSac());
                pr.setObject(6, spct.getIdKichThuoc());
                pr.setObject(7, spct.getIdDegiay());
                pr.setObject(8, spct.getIdChuongTrinhKM());
                pr.setObject(9, spct.getIdSanPham());
                pr.setObject(10, spct.getNgaySua());
                pr.setObject(11, spct.getTrangThai());
                pr.setObject(12, id);
                pr.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public boolean checktrungma(String maSanPhamCT) {
        String sql = "SELECT COUNT(*) FROM san_pham_chi_tiet WHERE ma_san_pham_chi_tiet = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, maSanPhamCT);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<SPCT> getSPCTByTrangThai(int trangThai) {
        List<SPCT> spctList = new ArrayList<>();
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
                + "spct.don_gia, spct.mo_ta, spct.trang_thai, spct.ngay_tao, spct.ngay_sua, "
                + "ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
                + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.ten_chuong_trinh_khuyen_mai ELSE NULL END AS ten_khuyen_mai, "
                + "sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "
                + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "
                + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id "
                + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE spct.trang_thai = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setInt(1, trangThai);

            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                SPCT spct = new SPCT(
                        rs.getInt("id"),
                        rs.getString("ma_san_pham_chi_tiet"),
                        rs.getInt("so_luong"),
                        rs.getFloat("don_gia"),
                        rs.getString("mo_ta"),
                        rs.getInt("trang_thai"),
                        rs.getDate("ngay_tao"),
                        rs.getDate("ngay_sua"),
                        rs.getString("ten_mau"),
                        rs.getString("ten_kich_thuoc"),
                        rs.getString("ten_de_giay"),
                        rs.getString("ten_khuyen_mai"),
                        rs.getString("ten_san_pham")
                );
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return spctList;
    }

    public void updateSoLuong(int idSPCT, int newQuantity) {
        String sql = "UPDATE san_pham_chi_tiet SET so_luong = ? WHERE id = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, newQuantity);
            pst.setInt(2, idSPCT);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật số lượng thành công cho sản phẩm chi tiết ID: " + idSPCT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SPCT SearchMaSPCT(String ma) {
        String sql = "SELECT * FROM san_pham_chi_tiet WHERE ma_san_pham_chi_tiet = ?";
        SPCT spct = null;
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, ma);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    spct = new SPCT(
                            rs.getInt("id"),
                            rs.getString("ma_san_pham_chi_tiet"),
                            rs.getInt("so_luong"),
                            rs.getFloat("don_gia"),
                            rs.getString("mo_ta"),
                            rs.getInt("trang_thai"),
                            rs.getDate("ngay_tao"),
                            rs.getDate("ngay_sua"),
                            null, null, null, null, null
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (spct == null) {
            System.out.println("Không tìm thấy sản phẩm chi tiết với mã: " + ma);
        }
        return spct;
    }

    public SPCTService() {
        con = DBConnect.getConnection();
    }

    public boolean addSPCTBanHang(int idHoaDon, int idSPCT, int soLuongThem, float giaBanSauKhuyenMai) {
        if (idHoaDon <= 0 || idSPCT <= 0 || soLuongThem <= 0 || giaBanSauKhuyenMai <= 0) {
            System.err.println("Dữ liệu đầu vào không hợp lệ: idHoaDon = " + idHoaDon + ", idSPCT = " + idSPCT + ", soLuongThem = " + soLuongThem + ", giaBanSauKhuyenMai = " + giaBanSauKhuyenMai);
            return false;
        }
        String selectQuery = "SELECT id, so_luong, gia_ban FROM hoa_don_chi_tiet WHERE id_hoa_don = ? AND id_san_pham_chi_tiet = ?";
        String updateQuery = "UPDATE hoa_don_chi_tiet SET so_luong = ?, thanh_tien = ?, ngay_sua = GETDATE() WHERE id = ?";
        String insertQuery = "INSERT INTO hoa_don_chi_tiet (id_hoa_don, id_san_pham_chi_tiet, so_luong, gia_ban, thanh_tien, ngay_tao, trang_thai) VALUES (?, ?, ?, ?, ?, GETDATE(), 1)";
        try (Connection con = DBConnect.getConnection(); PreparedStatement selectStmt = con.prepareStatement(selectQuery)) {
            selectStmt.setInt(1, idHoaDon);
            selectStmt.setInt(2, idSPCT);
            try (ResultSet rs = selectStmt.executeQuery()) {
                if (rs.next()) {
                    int IdBanDau = rs.getInt("id");
                    int QuantityBanDau = rs.getInt("so_luong");
                    int newQuantity = QuantityBanDau + soLuongThem;
                    float newThanhTien = newQuantity * giaBanSauKhuyenMai;
                    try (PreparedStatement update = con.prepareStatement(updateQuery)) {
                        update.setInt(1, newQuantity);
                        update.setFloat(2, newThanhTien);
                        update.setInt(3,IdBanDau);
                        update.executeUpdate();
                    }
                    return true;
                } else {

                    try (PreparedStatement insert = con.prepareStatement(insertQuery)) {
                        insert.setInt(1, idHoaDon);
                        insert.setInt(2, idSPCT);
                        insert.setInt(3, soLuongThem);
                        insert.setFloat(4, giaBanSauKhuyenMai);
                        insert.setFloat(5, soLuongThem * giaBanSauKhuyenMai);
                        insert.executeUpdate();
                    }
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public SPCT getSPCTById(String maspct) {
        String sql = "SELECT * FROM san_pham_chi_tiet WHERE ma_san_pham_chi_tiet= ?";

        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, maspct);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                int idspct = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                int idMauSac = rs.getInt("id_mau_sac");
                int idKichThuoc = rs.getInt("id_kich_thuoc");
                int idLoaiDG = rs.getInt("id_de_giay");
                int idChuongTrinhKM = rs.getInt("id_chuong_trinh_khuyen_mai");
                int idSanPham = rs.getInt("id_san_pham");
                SPCT spct = new SPCT(idspct, maSanPhamCT, soLuong, donGia, moTa, ngayTao, trangThai, ngaySua, idMauSac, idKichThuoc, idLoaiDG, idChuongTrinhKM, idSanPham);
                return spct;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<SPCT> getAllSanPhamCTByTen(String ten) {
        ArrayList<SPCT> spctList = new ArrayList<>();
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
                + "spct.don_gia, ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
                + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.giam_gia ELSE NULL END AS giam_gia, "
                + "sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "
                + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "
                + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id "
                + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE sp.ten_san_pham like ?";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + ten + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                Integer giamGia = rs.getObject("giam_gia") != null ? rs.getInt("giam_gia") : 0;
                String tenSanPham = rs.getString("ten_san_pham");
                SPCT spct = new SPCT(giamGia, id, maSanPhamCT, soLuong, donGia, tenMauSac, tenKichThuoc, tenLoaiDG, tenSanPham);
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spctList;
    }

    public ArrayList<SPCT> getAllSanPhamCTByTenMauSac(String ten) {
        ArrayList<SPCT> spctList = new ArrayList<>();
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
                + "spct.don_gia, ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
                + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.giam_gia ELSE NULL END AS giam_gia, "
                + "sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "
                + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "
                + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id "
                + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE ms.ten_mau like ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + ten + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                Integer giamGia = rs.getObject("giam_gia") != null ? rs.getInt("giam_gia") : 0;
                String tenSanPham = rs.getString("ten_san_pham");
                SPCT spct = new SPCT(giamGia, id, maSanPhamCT, soLuong, donGia, tenMauSac, tenKichThuoc, tenLoaiDG, tenSanPham);
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spctList;
    }

    public ArrayList<SPCT> getAllSanPhamCTByTenKichThuoc(String ten) {
        ArrayList<SPCT> spctList = new ArrayList<>();
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
                + "spct.don_gia, ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
                + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.giam_gia ELSE NULL END AS giam_gia, "
                + "sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "
                + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "
                + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id "
                + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "
                + "WHERE kt.ten_kich_thuoc like ?";

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, "%" + ten + "%");
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                Integer giamGia = rs.getObject("giam_gia") != null ? rs.getInt("giam_gia") : 0;
                String tenSanPham = rs.getString("ten_san_pham");
                SPCT spct = new SPCT(giamGia, id, maSanPhamCT, soLuong, donGia, tenMauSac, tenKichThuoc, tenLoaiDG, tenSanPham);
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spctList;
    }
}
