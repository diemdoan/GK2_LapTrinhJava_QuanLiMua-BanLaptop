package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login {
	private JFrame frame;
	private JTextField textField_tenDn;
	private JTextField textField_mk;

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

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(167, 136, 211, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_tenDn = new JTextField();
		textField_tenDn.setFont(new Font("Tahoma", Font.PLAIN, 27));
		textField_tenDn.setBounds(447, 138, 415, 52);
		frame.getContentPane().add(textField_tenDn);
		textField_tenDn.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(167, 225, 211, 52);
		frame.getContentPane().add(lblNewLabel_1_1);

		textField_mk = new JTextField();
		textField_mk.setFont(new Font("Tahoma", Font.PLAIN, 27));
		textField_mk.setColumns(10);
		textField_mk.setBounds(447, 227, 415, 52);
		frame.getContentPane().add(textField_mk);

		JButton btnNewButton = new JButton("Đăng nhập");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnNewButton.setBounds(389, 325, 188, 45);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String tk = textField_tenDn.getText();
					String mk = textField_mk.getText();
					if (tk.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không được để trống tài khoản", "Lỗi",
								JOptionPane.OK_CANCEL_OPTION);
						return;
					}
					if (mk.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không được để trống mật khẩu", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					new ChooseLaptop();
					frame.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JLabel lblNewLabel_1_1_1 = new JLabel("Bạn là nhân viên mới?");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1_1_1.setBounds(179, 415, 314, 52);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		JButton btnngK = new JButton("Đăng kí ");
		btnngK.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnngK.setBounds(508, 448, 162, 48);
		frame.getContentPane().add(btnngK);
		btnngK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new CreateNewAccount();
			}
		});

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Đăng kí tài khoản mới");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 26));
		lblNewLabel_1_1_1_1.setBounds(179, 471, 314, 52);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);

		JButton btnThot = new JButton("Thoát");
		btnThot.setFont(new Font("Tahoma", Font.PLAIN, 29));
		btnThot.setBounds(793, 559, 162, 33);
		frame.getContentPane().add(btnThot);
		btnThot.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}

}
