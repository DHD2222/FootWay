/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ultis.DBConnect;

/**
 * @author Admin
 */
public class ServiceLoGin {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;
    private String loggedInFullName;
    private int loggedInUserId;
    private String loggedInRole;

    public int login(String username, String password) {
        String sql = "SELECT id, trang_thai, ten_nhan_vien,vai_tro FROM nhan_vien WHERE ten_dang_nhap = ? AND mat_khau = ?";
        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
            pr.setString(1, username);
            pr.setString(2, password);
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    int status = rs.getInt("trang_thai");
                    String role = rs.getString("vai_tro");
                    if (status == 1) {
                        loggedInUserId = rs.getInt("id");
                        loggedInFullName = rs.getString("ten_nhan_vien");
                        loggedInRole = role;
                        return 1;
                    } else {
                        return 2;
                    }
                } else {
                    return 3;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 4;
        }
    }

    public String getLoggedInRole() {
        return loggedInRole;
    }

    public int getLoggedInUserId() {
        return loggedInUserId;
    }

    public String getLoggedInFullName() {
        return loggedInFullName;
    }
}
