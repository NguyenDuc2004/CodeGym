package com.hotel.controller;

import com.hotel.model.User;
import com.hotel.repository.DataStorage;
import com.hotel.view.QLYTAIKHOANFrame; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class QLYTAIKHOANController {
    private QLYTAIKHOANFrame view;
    private DataStorage storage;

    public QLYTAIKHOANController(QLYTAIKHOANFrame view) {
        this.view = view;
        this.storage = DataStorage.getInstance();

        view.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);

        loadDataToTable();
        initEvents();

        view.tbUsers.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                displaySelectedUser();
            }
        });
    }

    private void initEvents() {
        view.btnThem.addActionListener(e -> handleAddUser());
        view.btnSua.addActionListener(e -> handleUpdateUser());
        view.btnXoa.addActionListener(e -> handleDeleteUser());
        view.btnLamMoi.addActionListener(e -> handleRefresh());
    }

    private void handleAddUser() {
        String user = view.txtUsername.getText().trim();
        String pass = view.txtPassword.getText().trim();
        String role = view.cbRole.getSelectedItem().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Không được để trống tài khoản/mật khẩu!");
            return;
        }

   
        for (User u : storage.getListUsers()) {
            if (u.getUserName().equalsIgnoreCase(user)) {
                JOptionPane.showMessageDialog(view, "Tên tài khoản đã tồn tại!");
                return;
            }
        }

        storage.addUser(new User(user, pass, role));
        loadDataToTable();
        handleRefresh();
        JOptionPane.showMessageDialog(view, "Thêm tài khoản thành công!");
    }

    private void handleUpdateUser() {
        String user = view.txtUsername.getText().trim();
        String pass = view.txtPassword.getText().trim();
        String role = view.cbRole.getSelectedItem().toString();

        if (storage.updateUser(new User(user, pass, role))) {
            loadDataToTable();
            JOptionPane.showMessageDialog(view, "Cập nhật thành công!");
        }
    }

    private void handleDeleteUser() {
        String user = view.txtUsername.getText().trim();
        if (storage.deleteUser(user)) {
            loadDataToTable();
            handleRefresh();
            JOptionPane.showMessageDialog(view, "Đã xóa tài khoản!");
        } else {
            JOptionPane.showMessageDialog(view, "Không thể xóa tài khoản này!");
        }
    }

    private void loadDataToTable() {
        DefaultTableModel model = (DefaultTableModel) view.tbUsers.getModel();
        model.setRowCount(0);
        for (User u : storage.getListUsers()) {
            model.addRow(new Object[]{u.getUserName(), "******", u.getRole()});
        }
    }

    private void handleRefresh() {
        view.txtUsername.setText("");
        view.txtPassword.setText("");
        view.cbRole.setSelectedIndex(0);
        view.txtUsername.setEditable(true); 
    }

    private void displaySelectedUser() {
        int row = view.tbUsers.getSelectedRow();
        if (row == -1) return;
        
        String username = view.tbUsers.getValueAt(row, 0).toString();
        for (User u : storage.getListUsers()) {
            if (u.getUserName().equals(username)) {
                view.txtUsername.setText(u.getUserName());
                view.txtUsername.setEditable(false);
                view.txtPassword.setText(u.getPassWord());
                view.cbRole.setSelectedItem(u.getRole());
                break;
            }
        }
    }
}