package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class ThongKe {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		ThongKe window = new ThongKe();
		window.frame.setVisible(true);

	}

	public ThongKe() {
		frame = new JFrame();
		frame.setBounds(100, 100, 856, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		JButton btnTrLi = new JButton("Trở lại");
		btnTrLi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTrLi.setBounds(21, 23, 111, 29);
		frame.getContentPane().add(btnTrLi);

		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChooseLaptop();
				frame.dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Thống kê");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel.setBounds(345, 10, 141, 46);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nhập tỉnh cần thống kê");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(96, 103, 177, 29);
		frame.getContentPane().add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(223, 152, 204, 29);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Số lượng máy được mua:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(96, 271, 204, 29);
		frame.getContentPane().add(lblNewLabel_1_1);

		JButton btnNewButton = new JButton("Thống kê");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(480, 150, 120, 29);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Connection conn = ConnectSQL.getConnection();
		            Statement statement = conn.createStatement();

		            String diachi = textField.getText(); // Lấy dữ liệu từ textField

		            String query = "SELECT soluongmaymua FROM shoplaptop.khachhang WHERE diachi = ?";
		            PreparedStatement preparedStatement = conn.prepareStatement(query);
		            preparedStatement.setString(1, diachi);

		            ResultSet resultSet = preparedStatement.executeQuery();
		            if (resultSet.next()) {
		                int soluongmaymua = resultSet.getInt("soluongmaymua");
		                textField_1.setText(String.valueOf(soluongmaymua));
		            } else {
		                textField_1.setText("Không tìm thấy dữ liệu");
		            }

		            conn.close();
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(332, 271, 167, 29);
		frame.getContentPane().add(textField_1);
	}

}
