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
	private JTextField tf_id_nv;
	private JTextField tf_tennhanvien;
	private JTextField tf_idlaptop;
	private JTextField tf_tenlaptop;
	private JTextField textField;

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

		JLabel lblNewLabel = new JLabel("Điền Thông Tin Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel.setBounds(236, 43, 525, 53);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên khách hàng: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(139, 136, 196, 53);
		frame.getContentPane().add(lblNewLabel_1);

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

		JButton btnHy = new JButton("Hủy");
		btnHy.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHy.setBounds(139, 495, 207, 40);
		frame.getContentPane().add(btnHy);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setColumns(10);
		textField.setBounds(333, 146, 472, 34);
		frame.getContentPane().add(textField);
		btnHy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ChooseLaptop();
				frame.dispose();
			}
		});
		frame.setVisible(true);
	}
}
