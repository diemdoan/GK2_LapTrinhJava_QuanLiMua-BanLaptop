package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateNewAccount {

	private JFrame frame;
	private JTextField tf_tennhanvien;
	private JTextField tf_sdt;
	private JTextField tf_cccd;
	private JTextField tf_tendangnhap;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccount window = new CreateNewAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateNewAccount() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Đăng kí tài khoản mới");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(314, 11, 392, 68);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(155, 119, 157, 20);
		frame.getContentPane().add(lblNewLabel_1);

		tf_tennhanvien = new JTextField();
		tf_tennhanvien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_tennhanvien.setBounds(347, 112, 446, 35);
		frame.getContentPane().add(tf_tennhanvien);
		tf_tennhanvien.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(155, 179, 159, 25);
		frame.getContentPane().add(lblNewLabel_1_1);

		tf_sdt = new JTextField();
		tf_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(347, 169, 446, 35);
		frame.getContentPane().add(tf_sdt);

		JLabel lblNewLabel_1_1_1 = new JLabel("CCCD: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1.setBounds(155, 229, 72, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		tf_cccd = new JTextField();
		tf_cccd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_cccd.setColumns(10);
		tf_cccd.setBounds(347, 222, 446, 35);
		frame.getContentPane().add(tf_cccd);

		JLabel lblNewLabel_1_2 = new JLabel("Tên đăng nhập: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_2.setBounds(150, 336, 186, 28);
		frame.getContentPane().add(lblNewLabel_1_2);

		tf_tendangnhap = new JTextField();
		tf_tendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 21));
		tf_tendangnhap.setColumns(10);
		tf_tendangnhap.setBounds(347, 329, 446, 35);
		frame.getContentPane().add(tf_tendangnhap);

		JLabel lblNewLabel_1_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_2.setBounds(150, 397, 115, 28);
		frame.getContentPane().add(lblNewLabel_1_1_2);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(346, 390, 447, 35);
		frame.getContentPane().add(passwordField);
		frame.setVisible(true);

		JButton bt_dangki = new JButton("Đăng kí");
		bt_dangki.setFont(new Font("Tahoma", Font.BOLD, 22));
		bt_dangki.setBounds(645, 496, 159, 35);
		frame.getContentPane().add(bt_dangki);

		bt_dangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fullName = tf_tennhanvien.getText();
				String phone = tf_sdt.getText();
				String cccd = tf_cccd.getText();
				String accName = tf_tendangnhap.getText();
				String pass = new String(passwordField.getPassword());

				if (fullName.isEmpty() || phone.isEmpty() || cccd.isEmpty() || accName.isEmpty() || pass.isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Vui lòng điền đầy đủ thông tin!");
					return;
				}

				try {
					Long.parseLong(cccd);
					if (cccd.length() != 12) {
						JOptionPane.showMessageDialog(frame, "CCCD phải có 12 chữ số!");
						return;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "CCCD phải là số!");
					return;
				}
				try {
					Long.parseLong(phone);
					if (phone.length() != 10) {
						JOptionPane.showMessageDialog(frame, "Số điện thoại phải có 10 chữ số!");
						return;
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(frame, "Số điện thoại phải là số!");
					return;
				}
				try {
					Connection conn = ConnectSQL.getConnection();
					String checkDuplicateSql = "SELECT tennhanvien FROM nhanvien WHERE tennhanvien = ?";
					PreparedStatement checkStatement = conn.prepareStatement(checkDuplicateSql);
					checkStatement.setString(1, accName);
					ResultSet resultSet = checkStatement.executeQuery();
					if (resultSet.next()) {
						JOptionPane.showMessageDialog(frame, "Tên tài khoản đã được sử dụng!");
						checkStatement.close();
						conn.close();
						return;
					}
					checkStatement.close();
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
					return;
				}

				try {
					Connection conn = ConnectSQL.getConnection();
					String sql = "INSERT INTO nhanvien (tennhanvien, sdt, tendangnhap, matkhau, CCCD) VALUES (?, ?, ?, ?, ?)";
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.setString(1, fullName);
					statement.setString(2, phone);
					statement.setString(3, accName);
					statement.setString(4, pass);
					statement.setString(5, cccd);
					statement.executeUpdate();

					statement.close();
					conn.close();
					JOptionPane.showMessageDialog(frame, "Đăng ký thành công!");
					new Login();
					frame.dispose();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.setFont(new Font("Tahoma", Font.BOLD, 22));
		bt_thoat.setBounds(167, 496, 159, 35);
		frame.getContentPane().add(bt_thoat);
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login();
				frame.dispose();
			}
		});

	}
}
