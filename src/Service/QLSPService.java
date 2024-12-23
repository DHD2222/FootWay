/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.QLSP;

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
public class QLSPService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<QLSP> getAllSanPham(int page) {
        ArrayList<QLSP> sanPhamList = new ArrayList<>();
        int pageSize = 5;
        int offset = (page - 1) * pageSize;
        String sql = "SELECT sp.id, sp.ma_san_pham, sp.ten_san_pham, sp.mo_ta, sp.anh, sp.trang_thai, sp.ngay_tao, sp.ngay_sua, "
                + "nh.ten_nhan_hieu, cl.ten_chat_lieu, ncc.ten_nha_cung_cap "
                + "FROM san_pham sp "
                + "JOIN nhan_hieu nh ON sp.id_nhan_hieu = nh.id "
                + "JOIN chat_lieu cl ON sp.id_chat_lieu = cl.id "
                + "JOIN nha_cung_cap ncc ON sp.id_nha_cung_cap = ncc.id "
                + "ORDER BY sp.id "
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, offset);
            pr.setInt(2, pageSize);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPham = rs.getString("ma_san_pham");
                String tenSanPham = rs.getString("ten_san_pham");
                String moTa = rs.getString("mo_ta");
                String anh = rs.getString("anh");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                String tenNhanHieu = rs.getString("ten_nhan_hieu");
                String tenChatLieu = rs.getString("ten_chat_lieu");
                String tenNhaCungCap = rs.getString("ten_nha_cung_cap");
                QLSP sanPham = new QLSP(id, maSanPham, tenSanPham, moTa, anh, trangThai, ngayTao, ngaySua, tenNhanHieu, tenChatLieu, tenNhaCungCap);
                sanPhamList.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public int TongSoTrang() {
        int TongSanPham = 0;
        String sql = "SELECT COUNT(*) FROM san_pham";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql); ResultSet rs = pr.executeQuery()) {
            if (rs.next()) {
                TongSanPham = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int pageSize = 5;
        return (int) Math.ceil((double) TongSanPham / pageSize);
    }

    public void addSanPham(QLSP sp) {
        if (sp != null) {
            String sql = """
                    INSERT INTO [dbo].[san_pham]
                               ([ma_san_pham]
                               ,[ten_san_pham]
                               ,[mo_ta]
                               ,ngay_tao
                               ,ngay_sua
                               ,[id_nhan_hieu]
                               ,[id_chat_lieu]
                               ,[id_nha_cung_cap]
                               ,[anh]
                               ,[trang_thai])
                         VALUES
                               (?,?,?,?,?,?,?,?,?,?)
                    """;
            try {
                con = DBConnect.getConnection();
                pr = con.prepareStatement(sql);
                pr.setObject(1, sp.getMaSanPham());
                pr.setObject(2, sp.getTenSanPham());
                pr.setObject(3, sp.getMoTa());
                pr.setObject(4, sp.getNgayTao());
                pr.setObject(5, sp.getNgaySua());
                pr.setObject(6, sp.getIdnhanHieu());
                pr.setObject(7, sp.getIdChatLieu());
                pr.setObject(8, sp.getIdNhaCC());
                pr.setObject(9, sp.getAnh());
                pr.setObject(10, sp.getTrangThai());
                pr.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void updateSanPham(QLSP sp, Integer id) {
        if (sp != null) {
            String sql = """
                    UPDATE [dbo].[san_pham]
                                   SET [ma_san_pham] = ?
                                      ,[ten_san_pham] =?
                                      ,[mo_ta] = ?
                                      ,[id_nhan_hieu] =? 
                                      ,[id_chat_lieu] = ?
                                      ,[id_nha_cung_cap] =? 
                                      ,[anh]=?
                                      ,[ngay_sua] = ?
                                      ,[trang_thai] =? 
                                      
                                      WHERE id = ?
                     """;
            try {
                con = DBConnect.getConnection();
                pr = con.prepareStatement(sql);
                pr.setObject(1, sp.getMaSanPham());
                pr.setObject(2, sp.getTenSanPham());
                pr.setObject(3, sp.getMoTa());
                pr.setObject(4, sp.getIdnhanHieu());
                pr.setObject(5, sp.getIdChatLieu());
                pr.setObject(6, sp.getIdNhaCC());
                pr.setObject(7, sp.getAnh());
                pr.setObject(8, sp.getNgaySua());
                pr.setObject(9, sp.getTrangThai());
                pr.setObject(10, id);
                pr.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public boolean checkTrungMa(String maSP) {
        String sql = "SELECT COUNT(*) FROM san_pham WHERE ma_san_pham = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, maSP);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<QLSP> searchByTenSanPham(String tenSanPhamtk) {
        List<QLSP> sanPhamList = new ArrayList<>();
        String sql = "SELECT sp.id, sp.ma_san_pham, sp.ten_san_pham, sp.mo_ta, sp.anh, sp.trang_thai, sp.ngay_tao, sp.ngay_sua, "
                + "nh.ten_nhan_hieu, cl.ten_chat_lieu, ncc.ten_nha_cung_cap "
                + "FROM san_pham sp "
                + "JOIN nhan_hieu nh ON sp.id_nhan_hieu = nh.id "
                + "JOIN chat_lieu cl ON sp.id_chat_lieu = cl.id "
                + "JOIN nha_cung_cap ncc ON sp.id_nha_cung_cap = ncc.id "
                + "WHERE sp.ten_san_pham LIKE ?";  // Tìm kiếm theo mã sản phẩm
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, "%" + tenSanPhamtk + "%");
            try (ResultSet rs = pr.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String maSP = rs.getString("ma_san_pham");
                    String tenSanPham = rs.getString("ten_san_pham");
                    String moTa = rs.getString("mo_ta");
                    String anh = rs.getString("anh");
                    int trangThai = rs.getInt("trang_thai");
                    Date ngayTao = rs.getDate("ngay_tao");
                    Date ngaySua = rs.getDate("ngay_sua");
                    String tenNhanHieu = rs.getString("ten_nhan_hieu");
                    String tenChatLieu = rs.getString("ten_chat_lieu");
                    String tenNhaCungCap = rs.getString("ten_nha_cung_cap");
                    QLSP sanPham = new QLSP(id, maSP, tenSanPham, moTa, anh, trangThai, ngayTao, ngaySua, tenNhanHieu, tenChatLieu, tenNhaCungCap);
                    sanPhamList.add(sanPham);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }

    public List<QLSP> LocTrangThai(int trangThai) {
        List<QLSP> productList = new ArrayList<>();
        String sql = "SELECT sp.id, sp.ma_san_pham, sp.ten_san_pham, sp.mo_ta, sp.anh, sp.trang_thai, sp.ngay_tao, sp.ngay_sua, "
                + "nh.ten_nhan_hieu, cl.ten_chat_lieu, ncc.ten_nha_cung_cap "
                + "FROM san_pham sp "
                + "JOIN nhan_hieu nh ON sp.id_nhan_hieu = nh.id "
                + "JOIN chat_lieu cl ON sp.id_chat_lieu = cl.id "
                + "JOIN nha_cung_cap ncc ON sp.id_nha_cung_cap = ncc.id "
                + "WHERE sp.trang_thai = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, trangThai);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                QLSP product = new QLSP();
                product.setId(rs.getInt("id"));
                product.setMaSanPham(rs.getString("ma_san_pham"));
                product.setTenSanPham(rs.getString("ten_san_pham"));
                product.setMoTa(rs.getString("mo_ta"));
                product.setAnh(rs.getString("anh"));
                product.setTrangThai(rs.getInt("trang_thai"));
                product.setNgayTao(rs.getDate("ngay_tao"));
                product.setNgaySua(rs.getDate("ngay_sua"));
                product.setTenNhanHieu(rs.getString("ten_nhan_hieu"));
                product.setTenChatLieu(rs.getString("ten_chat_lieu"));
                product.setTenNhaCungCap(rs.getString("ten_nha_cung_cap"));
                productList.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productList;
    }

    public QLSP getSanPhamsById(Integer id) {
        String sql = "SELECT sp.id, sp.ma_san_pham, sp.ten_san_pham, sp.mo_ta, sp.anh, sp.trang_thai, sp.ngay_tao, sp.ngay_sua, "
                + "nh.ten_nhan_hieu, cl.ten_chat_lieu, ncc.ten_nha_cung_cap "
                + "FROM san_pham sp "
                + "JOIN nhan_hieu nh ON sp.id_nhan_hieu = nh.id "
                + "JOIN chat_lieu cl ON sp.id_chat_lieu = cl.id "
                + "JOIN nha_cung_cap ncc ON sp.id_nha_cung_cap = ncc.id "
                + "WHERE sp.id = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            QLSP product = new QLSP();
            while (rs.next()) {
                product.setId(rs.getInt("id"));
                product.setMaSanPham(rs.getString("ma_san_pham"));
                product.setTenSanPham(rs.getString("ten_san_pham"));
                product.setMoTa(rs.getString("mo_ta"));
                product.setAnh(rs.getString("anh"));
                product.setTrangThai(rs.getInt("trang_thai"));
                product.setNgayTao(rs.getDate("ngay_tao"));
                product.setNgaySua(rs.getDate("ngay_sua"));
                product.setTenNhanHieu(rs.getString("ten_nhan_hieu"));
                product.setTenChatLieu(rs.getString("ten_chat_lieu"));
                product.setTenNhaCungCap(rs.getString("ten_nha_cung_cap"));
            }
            return product;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
