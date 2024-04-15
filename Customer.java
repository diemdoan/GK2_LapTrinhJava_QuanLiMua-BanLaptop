package gk2_QuanLiMuaBanLaptop;

import java.awt.EventQueue;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Customer {

	private JFrame frame;
	private JTextField tf_sdt;
	private JTextField tf_diachi;
	private JTextField textField_ten;
	private JTextField tf_email;
	private JTextField tf_ngaysinh;
	private JTextField tf_soluongmaymua;

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

	public Customer() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		JLabel lblNewLabel = new JLabel("Điền Thông Tin Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(236, 43, 525, 53);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(139, 136, 196, 53);
		frame.getContentPane().add(lblNewLabel_1);

		textField_ten = new JTextField();
		textField_ten.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_ten.setColumns(10);
		textField_ten.setBounds(333, 146, 472, 34);
		frame.getContentPane().add(textField_ten);

		JLabel lblNewLabel_1_1 = new JLabel("Số điện thoại: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(139, 200, 160, 40);
		frame.getContentPane().add(lblNewLabel_1_1);

		tf_sdt = new JTextField();
		tf_sdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_sdt.setColumns(10);
		tf_sdt.setBounds(333, 204, 472, 34);
		frame.getContentPane().add(tf_sdt);

		JLabel lblNewLabel_1_1_1 = new JLabel("Địa chỉ: ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1.setBounds(139, 314, 91, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		tf_diachi = new JTextField();
		tf_diachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_diachi.setColumns(10);
		tf_diachi.setBounds(334, 318, 471, 34);
		frame.getContentPane().add(tf_diachi);

		JButton btnNewButton = new JButton("Xuất hóa đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(647, 495, 207, 40);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				writeToFile();
				writeDataToDatabase();
				new Bill();
				frame.dispose();
			}
		});

		JButton btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBounds(139, 495, 207, 40);
		frame.getContentPane().add(btnHy);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Email: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1_1.setBounds(139, 263, 91, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		tf_email = new JTextField();
		tf_email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_email.setColumns(10);
		tf_email.setBounds(333, 267, 471, 34);
		frame.getContentPane().add(tf_email);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Ngày sinh:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1_2.setBounds(139, 365, 131, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1_2);

		tf_ngaysinh = new JTextField();
		tf_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_ngaysinh.setColumns(10);
		tf_ngaysinh.setBounds(333, 363, 471, 34);
		frame.getContentPane().add(tf_ngaysinh);

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Số lượng máy mua: ");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1_1_2_1.setBounds(139, 417, 237, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1_2_1);

		tf_soluongmaymua = new JTextField();
		tf_soluongmaymua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_soluongmaymua.setColumns(10);
		tf_soluongmaymua.setBounds(386, 423, 196, 34);
		frame.getContentPane().add(tf_soluongmaymua);

		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
			}
		});

	}

	// Hàm viết vô file
	// Đổi đường dẫn trước khi chạy
	public void writeToFile() {
		String tenKH = textField_ten.getText();
		String sdt = tf_sdt.getText();
		String diachi = tf_diachi.getText();
		String email = tf_email.getText();
		String ngaysinh = tf_ngaysinh.getText();
		String soluongmaymua = tf_soluongmaymua.getText();

		String filePath = "C:\\Users\\NAM\\Desktop\\Hóa Đơn\\Bill.txt";

		try {
			FileWriter writer = new FileWriter(filePath, true);

			writer.write("Thông tin khách hàng:\n");
			writer.write("Tên khách hàng: " + tenKH + "\n");
			writer.write("Số điện thoại: " + sdt + "\n");
			writer.write("Email: " + email + "\n");
			writer.write("Địa chỉ: " + diachi + "\n");
			writer.write("Ngày Sinh: " + ngaysinh + "\n");
			writer.write("Số lượng máy mua: " + soluongmaymua + "\n");
			writer.write("\n");
			writer.close();

			JOptionPane.showMessageDialog(frame, "Ghi dữ liệu vào file thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Lỗi khi ghi dữ liệu vào file!");
		}
	}

	public void writeDataToDatabase() {
		String tenKH = textField_ten.getText();
		String sdt = tf_sdt.getText();
		String diachi = tf_diachi.getText();
		String email = tf_email.getText();
		String ngaysinh = tf_ngaysinh.getText();
		String soluongmaymua = tf_soluongmaymua.getText();

		try (Connection conn = ConnectSQL.getConnection()) {
			// Tạo câu lệnh SQL để chèn dữ liệu vào bảng khachhang
			String sql = "INSERT INTO khachhang (tenkhachhang, sdt, diachi, email, ngaysinh, soluongmaymua) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = conn.prepareStatement(sql);
			
			// Đặt các giá trị tham số cho câu lệnh SQL

			statement.setString(1, tenKH);
			statement.setString(2, sdt);
			statement.setString(3, diachi);
			statement.setString(4, email);
			statement.setString(5, ngaysinh);
			statement.setString(6, soluongmaymua);

			// Thực thi câu lệnh SQL để chèn dữ liệu
			statement.executeUpdate();

			

			JOptionPane.showMessageDialog(frame, "Ghi dữ liệu vào cơ sở dữ liệu thành công!");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frame, "Lỗi khi ghi dữ liệu vào cơ sở dữ liệu!");
		}
	}
}
