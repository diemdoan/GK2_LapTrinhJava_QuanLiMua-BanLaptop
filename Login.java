package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Login {
	private JFrame frame;
	private JTextField textField_tenDn;
	private JPasswordField textField_mk;

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

		ImageIcon backgroundImage = new ImageIcon("C:\\Users\\NAM\\Downloads\\laptop.jpg");
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.setContentPane(backgroundLabel);

		JLabel lblNewLabel = new JLabel("Shop Laptop Điềm và Nam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setBounds(179, 10, 664, 66);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);

		JLabel lblNewLabel_1 = new JLabel("Tên đăng nhập:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1.setBounds(167, 136, 211, 47);
		frame.getContentPane().add(lblNewLabel_1);

		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		textField_tenDn = new JTextField();
		textField_tenDn.setFont(new Font("Tahoma", Font.PLAIN, 27));
		textField_tenDn.setBounds(447, 138, 415, 52);
		frame.getContentPane().add(textField_tenDn);
		textField_tenDn.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel_1_1.setBounds(167, 225, 211, 47);
		frame.getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_1_1.setBackground(Color.white);
		lblNewLabel_1_1.setOpaque(true);

		textField_mk = new JPasswordField();
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
					String mk = new String(textField_mk.getPassword());

					Connection connection = ConnectSQL.getConnection();
					String sql = "SELECT * FROM nhanvien WHERE tendangnhap = ? AND matkhau = ?";
					PreparedStatement statement = connection.prepareStatement(sql);
					statement.setString(1, tk);
					statement.setString(2, mk);
					ResultSet resultSet = statement.executeQuery();
					if (tk.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không để trống tên đăng nhập", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (mk.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không để trống mật khẩu", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					if (resultSet.next()) {
						new ChooseLaptop();
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không chính xác", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(frame, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JLabel lblNewLabel_1_1_1 = new JLabel("Bạn là nhân viên mới?");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel_1_1_1.setBounds(179, 415, 281, 46);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1.setOpaque(true);

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
		lblNewLabel_1_1_1_1.setBounds(179, 471, 281, 46);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		lblNewLabel_1_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1_1_1.setOpaque(true);

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
