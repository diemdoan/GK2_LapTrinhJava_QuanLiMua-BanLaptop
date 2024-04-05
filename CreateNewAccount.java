package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
		
		JLabel lblNewLabel_1 = new JLabel("Tên nhân viên: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(167, 119, 159, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		tf_tennhanvien = new JTextField();
		tf_tennhanvien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_tennhanvien.setBounds(324, 112, 446, 35);
		frame.getContentPane().add(tf_tennhanvien);
		tf_tennhanvien.setColumns(10);
		
		tf_sdt = new JTextField();
		tf_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(324, 169, 345, 35);
		frame.getContentPane().add(tf_sdt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(177, 176, 159, 20);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("CCCD: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1.setBounds(254, 229, 72, 20);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		tf_cccd = new JTextField();
		tf_cccd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_cccd.setColumns(10);
		tf_cccd.setBounds(324, 222, 345, 35);
		frame.getContentPane().add(tf_cccd);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên đăng nhập: ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_2.setBounds(150, 336, 186, 20);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		tf_tendangnhap = new JTextField();
		tf_tendangnhap.setFont(new Font("Tahoma", Font.PLAIN, 21));
		tf_tendangnhap.setColumns(10);
		tf_tendangnhap.setBounds(324, 329, 446, 35);
		frame.getContentPane().add(tf_tendangnhap);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_2.setBounds(211, 393, 115, 20);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
		JButton bt_dangki = new JButton("Đăng kí");
		bt_dangki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_dangki.setFont(new Font("Tahoma", Font.BOLD, 22));
		bt_dangki.setBounds(606, 470, 159, 35);
		frame.getContentPane().add(bt_dangki);
		
		JButton bt_thoat = new JButton("Thoát");
		bt_thoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		bt_thoat.setFont(new Font("Tahoma", Font.BOLD, 22));
		bt_thoat.setBounds(192, 470, 159, 35);
		frame.getContentPane().add(bt_thoat);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 20));
		passwordField.setBounds(323, 390, 409, 35);
		frame.getContentPane().add(passwordField);
	}
}
