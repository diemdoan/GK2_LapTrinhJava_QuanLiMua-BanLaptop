package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ChooseLaptop {

	private JFrame frame;

	public static void main(String[] args) {
		ChooseLaptop window = new ChooseLaptop();
		window.frame.setVisible(true);
	}

	public ChooseLaptop() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1272, 765);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Shop Laptop Điềm và Nam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setBounds(307, 10, 648, 50);
		frame.getContentPane().add(lblNewLabel);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JButton btnNewButton = new JButton("Thanh toán");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton.setBounds(505, 668, 223, 50);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Customer();
				frame.dispose();
			}
		});

		JButton btnChn = new JButton("Chọn");
		btnChn.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnChn.setBounds(533, 399, 161, 43);
		frame.getContentPane().add(btnChn);

		JButton btnNewButton_1 = new JButton("Đăng xuất");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		btnNewButton_1.setBounds(39, 27, 161, 37);
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login();

			}
		});

		JButton btnNewButton_1_1 = new JButton("Vào kho Laptop");
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 23));
		btnNewButton_1_1.setBounds(1006, 20, 232, 50);
		frame.getContentPane().add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Storehouse();
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}

}
