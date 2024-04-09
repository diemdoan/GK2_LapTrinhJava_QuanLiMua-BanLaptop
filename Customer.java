package gk2_QuanLiMuaBanLaptop;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer {

	private JFrame frame;
	private JTextField tf_sdt;
	private JTextField tf_diachi;
	private JTextField textField_ten;

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
		lblNewLabel_1_1_1.setBounds(139, 264, 91, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1);

		tf_diachi = new JTextField();
		tf_diachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tf_diachi.setColumns(10);
		tf_diachi.setBounds(333, 268, 471, 34);
		frame.getContentPane().add(tf_diachi);

		JButton btnNewButton = new JButton("Xuất hóa đơn");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(647, 495, 207, 40);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Bill();
				frame.dispose();
			}
		});

		JButton btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBounds(139, 495, 207, 40);
		frame.getContentPane().add(btnHy);

		btnHy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChooseLaptop();
				frame.dispose();
			}
		});

	}
}
