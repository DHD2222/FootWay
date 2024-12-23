/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Views;

import Model.Brand;
import Model.ChatLieu;
import Model.NhaCungCap;
import Model.QLSP;
import Service.BrandService;
import Service.ChatLieuService;
import Service.NhaCCService;
import Service.QLSPService;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 * @author LAPTOP
 */
public final class ViewSanPham extends javax.swing.JPanel {

    private QLSPService service = new QLSPService();
    private DefaultTableModel mol = new DefaultTableModel();
    private int currentPage = 1;
    private int numberPage;
    private int limit = 5;
    private int i = -1;
    private int check;
    private BrandService servicebrand = new BrandService();
    private ChatLieuService serviceChatLieu = new ChatLieuService();
    private NhaCCService serviceNhaCC = new NhaCCService();
    String duongdananh = "D:\\QuanLyBanGiay\\src\\icons\\anh1";

    /**
     * Creates new form SanPhamView
     */
    public ViewSanPham() {
        initComponents();
        fillTable(currentPage);
        findComboboxBrand();
        findComboboxChatlieu();
        findComboboxNhaCC();
        tblSP.setRowHeight(24);

    }

    void getPage(List<QLSP> list) {
        if (list.size() % limit == 0) {
            numberPage = list.size() / limit;
        } else {
            numberPage = (list.size() / limit) + 1;
        }
        lblnumberPage.setText("1");
    }

    void fillTable(int page) {
        ArrayList<QLSP> list = service.getAllSanPham(page);
        this.getPage(list);
        mol = (DefaultTableModel) tblSP.getModel();
        mol.setRowCount(0);
        for (QLSP sanPham : list) {
            mol.addRow(sanPham.toDataRow());
        }

    }

    void showData(int i) {
        lblid.setText(tblSP.getValueAt(i, 0).toString());
        txtMasp.setText(tblSP.getValueAt(i, 1).toString());
        txtTensp.setText(tblSP.getValueAt(i, 2).toString());
        txtMota.setText(tblSP.getValueAt(i, 3).toString());
        lblanh.setText(tblSP.getValueAt(i, 4).toString());
        if (tblSP.getValueAt(i, 5).toString().equalsIgnoreCase("Đang bán")) {
            rdoDangBan.setSelected(true);
        } else {
            rdoNgungban.setSelected(true);
        }
        cboBrand.setSelectedItem(tblSP.getValueAt(i, 8));
        cboChatlieu.setSelectedItem(tblSP.getValueAt(i, 9));
        cboNhacungcap.setSelectedItem(tblSP.getValueAt(i, 10));

    }

    private void findComboboxBrand() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboBrand.getModel();
        boxModel.removeAllElements();
        List<Brand> bs = servicebrand.getAllBrand();
        for (Brand brand : bs) {
            boxModel.addElement(brand.getTennhanHieu());
        }
    }

    private void findComboboxChatlieu() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboChatlieu.getModel();
        boxModel.removeAllElements();
        List<ChatLieu> chatLieu = serviceChatLieu.getAllChatlieu();
        for (ChatLieu lieu : chatLieu) {
            boxModel.addElement(lieu.getTenchatLieu());
        }
    }

    private void findComboboxNhaCC() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboNhacungcap.getModel();
        boxModel.removeAllElements();
        List<NhaCungCap> nhaCungCap = serviceNhaCC.getAllNhaCC();
        for (NhaCungCap cungCap : nhaCungCap) {
            boxModel.addElement(cungCap.getTenNCC());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtMasp = new javax.swing.JTextField();
        txtTensp = new javax.swing.JTextField();
        rdoDangBan = new javax.swing.JRadioButton();
        rdoNgungban = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cboBrand = new javax.swing.JComboBox<>();
        cboChatlieu = new javax.swing.JComboBox<>();
        cboNhacungcap = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        lblnumberPage = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        prev = new javax.swing.JButton();
        next = new javax.swing.JButton();
        end = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        btnresettimkiem = new javax.swing.JButton();
        btnxemchitiet = new javax.swing.JButton();
        rdodangban = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        lblanh = new javax.swing.JLabel();
        btnchonanh = new javax.swing.JButton();
        lblid = new javax.swing.JLabel();
        btnthembrand = new javax.swing.JButton();
        btnthemchatlieu = new javax.swing.JButton();
        btnthemnhacungcap = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản Lý Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        setPreferredSize(new java.awt.Dimension(1094, 641));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(1094, 641));

        jLabel13.setText("Id sản phẩm:");

        jLabel14.setText("Mã sản phẩm:");

        jLabel15.setText("Tên sản phẩm:");

        jLabel16.setText("Trạng thái:");

        jLabel17.setText("Mô tả:");

        buttonGroup1.add(rdoDangBan);
        rdoDangBan.setSelected(true);
        rdoDangBan.setText("Đang bán");
        rdoDangBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDangBanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNgungban);
        rdoNgungban.setText("Ngừng bán");
        rdoNgungban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNgungbanActionPerformed(evt);
            }
        });

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane3.setViewportView(txtMota);

        jLabel18.setText("Nhãn Hiệu:");

        jLabel20.setText("Chất liệu:");

        jLabel21.setText("Nhà cung cấp:");

        cboBrand.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboBrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboBrandActionPerformed(evt);
            }
        });

        cboChatlieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboChatlieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboChatlieuActionPerformed(evt);
            }
        });

        cboNhacungcap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNhacungcap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhacungcapActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThem.setBackground(new java.awt.Color(0, 102, 102));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(0, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLammoi.setBackground(new java.awt.Color(0, 102, 102));
        btnLammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLammoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLammoi.setText("Làm mới");
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 16))); // NOI18N
        jPanel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel9MouseClicked(evt);
            }
        });

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id sản phẩm", "Mã sản phẩm", "Tên sản phẩm", "Mô tả", "Ảnh", "Trạng thái", "Ngày tạo", "Ngày sửa", "Brand", "Chất liệu", "Nhà cung cấp"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblSP);

        lblnumberPage.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblnumberPage.setText("Số trang sản phẩm");

        start.setBackground(new java.awt.Color(0, 102, 102));
        start.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        start.setForeground(new java.awt.Color(255, 255, 255));
        start.setText("|<");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        prev.setBackground(new java.awt.Color(0, 102, 102));
        prev.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        prev.setForeground(new java.awt.Color(255, 255, 255));
        prev.setText("<");
        prev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevActionPerformed(evt);
            }
        });

        next.setBackground(new java.awt.Color(0, 102, 102));
        next.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        next.setForeground(new java.awt.Color(255, 255, 255));
        next.setText(">");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        end.setBackground(new java.awt.Color(0, 102, 102));
        end.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        end.setForeground(new java.awt.Color(255, 255, 255));
        end.setText(">|");
        end.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endActionPerformed(evt);
            }
        });

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        btntimkiem.setBackground(new java.awt.Color(0, 102, 102));
        btntimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntimkiem.setForeground(new java.awt.Color(255, 255, 255));
        btntimkiem.setText("Tìm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        btnresettimkiem.setBackground(new java.awt.Color(0, 102, 102));
        btnresettimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnresettimkiem.setForeground(new java.awt.Color(255, 255, 255));
        btnresettimkiem.setText("Reset");
        btnresettimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresettimkiemActionPerformed(evt);
            }
        });

        btnxemchitiet.setBackground(new java.awt.Color(0, 102, 102));
        btnxemchitiet.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnxemchitiet.setForeground(new java.awt.Color(255, 255, 255));
        btnxemchitiet.setText("Xem Chi Tiết");
        btnxemchitiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxemchitietActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdodangban);
        rdodangban.setSelected(true);
        rdodangban.setText("Đang bán");
        rdodangban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdodangbanActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButton2);
        jRadioButton2.setText("Ngừng bán");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(start)
                        .addGap(18, 18, 18)
                        .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lblnumberPage)
                        .addGap(6, 6, 6)
                        .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(end)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(rdodangban)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton2)
                        .addGap(285, 285, 285)
                        .addComponent(btnxemchitiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btntimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnresettimkiem)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnxemchitiet)
                        .addComponent(rdodangban)
                        .addComponent(jRadioButton2))
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btntimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnresettimkiem)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prev, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblnumberPage))
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblanh.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnchonanh.setBackground(new java.awt.Color(0, 102, 102));
        btnchonanh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnchonanh.setForeground(new java.awt.Color(255, 255, 255));
        btnchonanh.setText("Chọn ảnh");
        btnchonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonanhActionPerformed(evt);
            }
        });

        lblid.setText("id");

        btnthembrand.setBackground(new java.awt.Color(0, 102, 102));
        btnthembrand.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthembrand.setForeground(new java.awt.Color(255, 255, 255));
        btnthembrand.setText("+");
        btnthembrand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthembrandActionPerformed(evt);
            }
        });

        btnthemchatlieu.setBackground(new java.awt.Color(0, 102, 102));
        btnthemchatlieu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthemchatlieu.setForeground(new java.awt.Color(255, 255, 255));
        btnthemchatlieu.setText("+");
        btnthemchatlieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemchatlieuActionPerformed(evt);
            }
        });

        btnthemnhacungcap.setBackground(new java.awt.Color(0, 102, 102));
        btnthemnhacungcap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthemnhacungcap.setForeground(new java.awt.Color(255, 255, 255));
        btnthemnhacungcap.setText("+");
        btnthemnhacungcap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemnhacungcapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnchonanh)))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(rdoDangBan)
                            .addGap(18, 18, 18)
                            .addComponent(rdoNgungban))
                        .addComponent(txtMasp)
                        .addComponent(txtTensp)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(lblid))
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnthembrand, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnthemchatlieu, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(btnthemnhacungcap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboNhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(cboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))
                            .addComponent(cboChatlieu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(lblanh, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnchonanh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18)
                            .addComponent(cboBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblid)
                            .addComponent(btnthembrand))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(cboChatlieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthemchatlieu))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(cboNhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthemnhacungcap))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(rdoDangBan)
                            .addComponent(rdoNgungban))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
        int totalPages = service.TongSoTrang();
        if (currentPage < totalPages) {
            currentPage++;
            fillTable(currentPage);
            lblnumberPage.setText("" + currentPage);
        }
    }//GEN-LAST:event_nextActionPerformed

    private void prevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevActionPerformed
        // TODO add your handling code here:
        if (currentPage > 1) {
            currentPage--;
            fillTable(currentPage);
            lblnumberPage.setText("" + currentPage);
        }

    }//GEN-LAST:event_prevActionPerformed

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
        // TODO add your handling code here:
        currentPage = 1;
        fillTable(currentPage);
        lblnumberPage.setText("" + currentPage);
    }//GEN-LAST:event_startActionPerformed

    private void endActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endActionPerformed
        // TODO add your handling code here:
        int totalPages = service.TongSoTrang();
        currentPage = totalPages;
        fillTable(currentPage);
        lblnumberPage.setText("" + currentPage);
    }//GEN-LAST:event_endActionPerformed

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        // TODO add your handling code here:
        int rowIndex = tblSP.getSelectedRow();
        if (rowIndex >= 0) {
            String imagePath = tblSP.getValueAt(rowIndex, 4).toString();
            lblanh.setIcon(ResizeImage(imagePath));
            showData(rowIndex);
            txtMasp.setEnabled(false);
        }
    }//GEN-LAST:event_tblSPMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.Update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        lblid.setText("");
        txtMasp.setText("");
        txtTensp.setText("");
        txtMota.setText("");
        rdoDangBan.setSelected(true);
        cboBrand.setSelectedIndex(0);
        cboChatlieu.setSelectedIndex(0);
        cboNhacungcap.setSelectedIndex(0);
        lblanh.setText("");
        lblanh.setIcon(null);
        txtMasp.setEnabled(true);
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        // TODO add your handling code here:
        String tenSanPham = txttimkiem.getText().trim();
        if (tenSanPham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm để tìm kiếm.");
            return;
        }
        List<QLSP> result = service.searchByTenSanPham(tenSanPham);
        if (result.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm với tên: " + tenSanPham);
        } else {
            DefaultTableModel model = (DefaultTableModel) tblSP.getModel();
            model.setRowCount(0);
            for (QLSP sp : result) {
                model.addRow(sp.toDataRow());
            }
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void btnresettimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresettimkiemActionPerformed
        // TODO add your handling code here:
        fillTable(currentPage);
        rdoDangBan.setSelected(true);

    }//GEN-LAST:event_btnresettimkiemActionPerformed

    private void btnchonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonanhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser f = new JFileChooser();
            f.setDialogTitle("Mở file");
            int result = f.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File ftenanh = f.getSelectedFile();
                duongdananh = ftenanh.getAbsolutePath();
                lblanh.setIcon(ResizeImage(duongdananh));
                System.out.println("Đường dẫn ảnh: " + duongdananh);
            }
        } catch (Exception e) {
            System.out.println("Chưa chọn ảnh");
        }
    }//GEN-LAST:event_btnchonanhActionPerformed

    private void rdoDangBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDangBanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rdoDangBanActionPerformed

    private void rdoNgungbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNgungbanActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_rdoNgungbanActionPerformed

    private void cboBrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboBrandActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboBrandActionPerformed

    private void cboChatlieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboChatlieuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboChatlieuActionPerformed

    private void cboNhacungcapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhacungcapActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cboNhacungcapActionPerformed

    private void btnthembrandActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthembrandActionPerformed
        // TODO add your handling code here:
        ViewNhanHieu nh = new ViewNhanHieu();
        nh.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                findComboboxBrand();
            }
        });
        nh.setVisible(true);
        nh.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnthembrandActionPerformed

    private void btnthemchatlieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemchatlieuActionPerformed
        // TODO add your handling code here:
        VewChatLieu cl = new VewChatLieu();
        cl.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                findComboboxChatlieu();
            }
        });
        cl.setVisible(true);
        cl.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnthemchatlieuActionPerformed

    private void btnthemnhacungcapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemnhacungcapActionPerformed
        // TODO add your handling code here:
        ViewNhaCungCap cc = new ViewNhaCungCap();
        cc.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                findComboboxNhaCC();
            }
        });
        cc.setVisible(true);
        cc.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnthemnhacungcapActionPerformed

    private void jPanel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel9MouseClicked

    private void btnxemchitietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxemchitietActionPerformed
        // TODO add your handling code here:
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        if (frame != null) {
            if (tblSP == null) {
                JOptionPane.showMessageDialog(this, "Bảng sản phẩm chưa được khởi tạo.");
                return;
            }
            this.i = tblSP.getSelectedRow();
            if (i < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm.");
                return;
            }
            Integer idSP = (Integer) tblSP.getValueAt(i, 0);
            if (idSP == null) {
                JOptionPane.showMessageDialog(this, "Không thể lấy ID sản phẩm.");
                return;
            }
            System.out.println(idSP);
            new ViewSanPhamChiTiet(frame, true, idSP).setVisible(true);
        }

    }//GEN-LAST:event_btnxemchitietActionPerformed

    private void rdodangbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdodangbanActionPerformed
        // TODO add your handling code here:
        LocTrangThai(1);
    }//GEN-LAST:event_rdodangbanActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        LocTrangThai(0);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void LocTrangThai (int trangThai) {
        List<QLSP> products = service.LocTrangThai(trangThai);
        mol.setRowCount(0);
        for (QLSP product : products) {
            mol.addRow(product.toDataRow());
        }
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(lblanh.getWidth(), lblanh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private boolean validateInput() {
        String masanpham = txtMasp.getText().trim();
        String tensanpham = txtTensp.getText().trim();
        String mota = txtMota.getText().trim();
        String anh = lblanh.getText().trim();

        if (masanpham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm không được để trống.");
            txtMasp.requestFocus();
            return false;
        }
        if (tensanpham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không được để trống.");
            txtTensp.requestFocus();
            return false;
        }
        if (mota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mô tả sản phẩm không được để trống.");
            txtMota.requestFocus();
            return false;
        }
        if (cboBrand.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn thương hiệu.");
            cboBrand.requestFocus();
            return false;
        }
        if (cboChatlieu.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn chất liệu.");
            cboChatlieu.requestFocus();
            return false;
        }
        if (cboNhacungcap.getSelectedIndex() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhà cung cấp.");
            cboNhacungcap.requestFocus();
            return false;
        }
        if (lblanh.getIcon() == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh sản phẩm.");
            lblanh.requestFocus();
            return false;
        }
        return true;
    }

    private QLSP getDataInsert() {
        if (!validateInput()) {
            return null;
        }
        String masanpham = txtMasp.getText();
        String tensanpham = txtTensp.getText();
        String mota = txtMota.getText();
        LocalDateTime ldt = LocalDateTime.now();
        Date ngayTao = java.sql.Timestamp.valueOf(ldt);
        String tennhanhieu = (String) cboBrand.getSelectedItem();
        Brand b = servicebrand.getTenBrand(tennhanhieu);
        int idBrand = b.getId();
        String tenchatlieu = (String) cboChatlieu.getSelectedItem();
        ChatLieu chatLieu = serviceChatLieu.getTenChatLieu(tenchatlieu);
        int idChatLieu = chatLieu.getId();
        String tennhaCC = (String) cboNhacungcap.getSelectedItem();
        NhaCungCap cungCap = serviceNhaCC.getTenNCC(tennhaCC);
        int idNhaCungCap = cungCap.getId();
        String anh = duongdananh;
        Integer trangThai = rdoDangBan.isSelected() ? 1 : 0;
        return new QLSP(masanpham, tensanpham, mota, anh, trangThai, ngayTao, idBrand, idChatLieu, idNhaCungCap);
    }

    private QLSP getDataUpdate() {
        if (!validateInput()) {
            return null;
        }
        String masanpham = txtMasp.getText();
        String tensanpham = txtTensp.getText();
        String mota = txtMota.getText();
        LocalDateTime ldt = LocalDateTime.now();
        Date ngaySua = java.sql.Timestamp.valueOf(ldt);
        String tennhanhieu = (String) cboBrand.getSelectedItem();
        Brand b = servicebrand.getTenBrand(tennhanhieu);
        int idBrand = b.getId();
        String tenchatlieu = (String) cboChatlieu.getSelectedItem();
        ChatLieu chatLieu = serviceChatLieu.getTenChatLieu(tenchatlieu);
        int idChatLieu = chatLieu.getId();
        String tennhaCC = (String) cboNhacungcap.getSelectedItem();
        NhaCungCap cungCap = serviceNhaCC.getTenNCC(tennhaCC);
        int idNhaCungCap = cungCap.getId();
        String anh = duongdananh;
        if (duongdananh == null || duongdananh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ảnh sản phẩm.");
            return null;
        }
        Integer trangThai = rdoDangBan.isSelected() ? 1 : 0;
        return new QLSP(masanpham, tensanpham, mota, anh, trangThai, idBrand, idChatLieu, idNhaCungCap, ngaySua);
    }

    private void insert() {
         int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn thêm sản phẩm này không?",
                    "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
        try {
            QLSP sp = this.getDataInsert();
            if (sp == null) {
                return;
            }
            if (service.checkTrungMa(sp.getMaSanPham())) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm đã tồn tại, vui lòng nhập mã khác!");
                return;
            }
            service.addSanPham(sp);
            this.fillTable(currentPage);
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
            }else {
                JOptionPane.showMessageDialog(this, "Thêm sản phẩm bị huỷ.");
            }
    }

    private void Update() {
       int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn sửa sản phẩm này không?",
                    "Xác nhận", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
        try {
            QLSP sp = this.getDataUpdate();
            if (sp == null) {
                return;
            }
            Integer id = Integer.valueOf(lblid.getText());
            service.updateSanPham(getDataUpdate(), id);
            this.fillTable(currentPage);
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
        } else {
                JOptionPane.showMessageDialog(this, "sửa sản phẩm bị huỷ.");
            }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnchonanh;
    private javax.swing.JButton btnresettimkiem;
    private javax.swing.JButton btnthembrand;
    private javax.swing.JButton btnthemchatlieu;
    private javax.swing.JButton btnthemnhacungcap;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton btnxemchitiet;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cboBrand;
    private javax.swing.JComboBox<String> cboChatlieu;
    private javax.swing.JComboBox<String> cboNhacungcap;
    private javax.swing.JButton end;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblanh;
    private javax.swing.JLabel lblid;
    private javax.swing.JLabel lblnumberPage;
    private javax.swing.JButton next;
    private javax.swing.JButton prev;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoNgungban;
    private javax.swing.JRadioButton rdodangban;
    private javax.swing.JButton start;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtTensp;
    private javax.swing.JTextField txttimkiem;
    // End of variables declaration//GEN-END:variables
}
