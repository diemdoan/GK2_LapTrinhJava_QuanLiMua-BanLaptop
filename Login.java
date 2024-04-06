package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login {
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		Login logwindow = new Login();
		logwindow.frame.setVisible(true);
	}

	public Login() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Shop Laptop Điềm và Nam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setBounds(179, 10, 664, 66);
		frame.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 27));
		textField.setBounds(447, 138, 415, 52);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(167, 136, 211, 52);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(167, 225, 211, 52);
		frame.getContentPane().add(lblNewLabel_1_1);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		textField_1.setColumns(10);
		textField_1.setBounds(447, 227, 415, 52);
		frame.getContentPane().add(textField_1);

		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.setBounds(389, 325, 188, 45);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel_1_1_1 = new JLabel("Bạn là nhân viên mới?");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1_1_1.setBounds(179, 415, 314, 52);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnngK = new JButton("Đăng kí ");
		btnngK.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnngK.setBounds(508, 448, 162, 48);
		frame.getContentPane().add(btnngK);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Đăng kí tài khoản mới");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 26));
		lblNewLabel_1_1_1_1.setBounds(179, 471, 314, 52);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		JButton btnThot = new JButton("Thoát");
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnThot.setBounds(793, 559, 162, 33);
		frame.getContentPane().add(btnThot);
	}

}
