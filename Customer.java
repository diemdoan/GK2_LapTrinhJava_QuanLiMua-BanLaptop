package gk2_QuanLiMuaBanLaptop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class Customer {

	private JFrame frame;
	private JTextField tf_tenkhachhang;
	private JTextField tf_sdt;
	private JTextField tf_diachi;
	private JTextField tf_id_nv;
	private JTextField tf_tennhanvien;
	private JTextField tf_idlaptop;
	private JTextField tf_tenlaptop;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer window = new Customer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Customer() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Điền Thông Tin Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(243, 43, 525, 53);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(139, 136, 200, 40);
		frame.getContentPane().add(lblNewLabel_1);

		tf_tenkhachhang = new JTextField();
		tf_tenkhachhang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_tenkhachhang.setBounds(320, 140, 422, 34);
		frame.getContentPane().add(tf_tenkhachhang);
		tf_tenkhachhang.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(168, 200, 160, 40);
		frame.getContentPane().add(lblNewLabel_1_1);

		tf_sdt = new JTextField();
		tf_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(320, 204, 370, 34);
		frame.getContentPane().add(tf_sdt);

		JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1.setBounds(237, 264, 91, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		tf_diachi = new JTextField();
		tf_diachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_diachi.setColumns(10);
		tf_diachi.setBounds(321, 268, 402, 34);
		frame.getContentPane().add(tf_diachi);

		tf_id_nv = new JTextField("*Id nhân viên");
		tf_id_nv.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_id_nv.setColumns(10);
		tf_id_nv.setBounds(165, 336, 140, 34);
		frame.getContentPane().add(tf_id_nv);

		tf_id_nv.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String currentText = tf_id_nv.getText();
				String defaultText = "*Id nhân viên";

				if (currentText.equals(defaultText)) {
					tf_id_nv.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				String currentText = tf_id_nv.getText();

				if (currentText.isEmpty()) {
					tf_id_nv.setText("*Id nhân viên");
				}
			}
		});

		tf_tennhanvien = new JTextField("*Tên nhân viên thực hiện");
		tf_tennhanvien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_tennhanvien.setColumns(10);
		tf_tennhanvien.setBounds(371, 336, 496, 34);
		frame.getContentPane().add(tf_tennhanvien);

		tf_tennhanvien.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String currentText = tf_tennhanvien.getText();
				String defaultText = "*Tên nhân viên thực hiện";

				if (currentText.equals(defaultText)) {
					tf_tennhanvien.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				String currentText = tf_tennhanvien.getText();

				if (currentText.isEmpty()) {
					tf_tennhanvien.setText("*Tên nhân viên thực hiện");
				}
			}
		});

		tf_idlaptop = new JTextField("*Id laptop");
		tf_idlaptop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_idlaptop.setColumns(10);
		tf_idlaptop.setBounds(165, 419, 140, 34);
		frame.getContentPane().add(tf_idlaptop);

		tf_idlaptop.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String currentText = tf_idlaptop.getText();
				String defaultText = "*Id laptop";

				if (currentText.equals(defaultText)) {
					tf_idlaptop.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				String currentText = tf_idlaptop.getText();

				if (currentText.isEmpty()) {
					tf_idlaptop.setText("*Id laptop");
				}
			}
		});

		tf_tenlaptop = new JTextField("*Tên Laptop");
		tf_tenlaptop.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_tenlaptop.setColumns(10);
		tf_tenlaptop.setBounds(371, 419, 415, 34);
		frame.getContentPane().add(tf_tenlaptop);

		tf_tenlaptop.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				String currentText = tf_tenlaptop.getText();
				String defaultText = "*Tên Laptop";

				if (currentText.equals(defaultText)) {
					tf_tenlaptop.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				String currentText = tf_tenlaptop.getText();

				if (currentText.isEmpty()) {
					tf_tenlaptop.setText("*Tên Laptop");
				}
			}
		});

		JButton btnNewButton = new JButton("Xuất hóa đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(647, 495, 207, 40);
		frame.getContentPane().add(btnNewButton);

		JButton btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBounds(139, 495, 207, 40);
		frame.getContentPane().add(btnHy);
	}

}
