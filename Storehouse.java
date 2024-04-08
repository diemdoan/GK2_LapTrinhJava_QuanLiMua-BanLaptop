package gk2_QuanLiMuaBanLaptop;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Storehouse {
	private JFrame frame;
	private JTextField textField_tenLap;
	private JTextField textField_nam;
	private JTextField textField_hang;
	private JTextField textField_cauhinh;
	private JTextField textField_sl;
	private JTextField textField_gia;

	public static void main(String[] args) {
		Storehouse window = new Storehouse();
		window.frame.setVisible(true);
	}

	public Storehouse() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1226, 659);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JLabel lblNewLabel = new JLabel("Kho Laptop");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setBounds(469, 10, 289, 73);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Thêm Laptop mới");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_1.setBounds(115, 106, 253, 32);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên Laptop:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(48, 161, 144, 32);
		frame.getContentPane().add(lblNewLabel_2);

		textField_tenLap = new JTextField();
		textField_tenLap.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_tenLap.setBounds(203, 161, 268, 29);
		frame.getContentPane().add(textField_tenLap);
		textField_tenLap.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Năm sản xuất:");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(48, 216, 144, 32);
		frame.getContentPane().add(lblNewLabel_2_1);

		textField_nam = new JTextField();
		textField_nam.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_nam.setColumns(10);
		textField_nam.setBounds(202, 219, 268, 29);
		frame.getContentPane().add(textField_nam);

		JLabel lblNewLabel_2_2 = new JLabel("Hãng:");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_2.setBounds(48, 271, 144, 32);
		frame.getContentPane().add(lblNewLabel_2_2);

		textField_hang = new JTextField();
		textField_hang.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_hang.setColumns(10);
		textField_hang.setBounds(203, 274, 268, 29);
		frame.getContentPane().add(textField_hang);

		JLabel lblNewLabel_2_3 = new JLabel("Cấu hình:");
		lblNewLabel_2_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_3.setBounds(48, 326, 144, 32);
		frame.getContentPane().add(lblNewLabel_2_3);

		textField_cauhinh = new JTextField();
		textField_cauhinh.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_cauhinh.setColumns(10);
		textField_cauhinh.setBounds(203, 329, 268, 29);
		frame.getContentPane().add(textField_cauhinh);

		JLabel lblNewLabel_2_4 = new JLabel("Số Lượng:");
		lblNewLabel_2_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_4.setBounds(48, 381, 144, 32);
		frame.getContentPane().add(lblNewLabel_2_4);

		textField_sl = new JTextField();
		textField_sl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_sl.setColumns(10);
		textField_sl.setBounds(202, 384, 268, 29);
		frame.getContentPane().add(textField_sl);

		JLabel lblNewLabel_2_5 = new JLabel("Giá:");
		lblNewLabel_2_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_5.setBounds(48, 436, 144, 32);
		frame.getContentPane().add(lblNewLabel_2_5);

		textField_gia = new JTextField();
		textField_gia.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textField_gia.setColumns(10);
		textField_gia.setBounds(202, 439, 268, 29);
		frame.getContentPane().add(textField_gia);

		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(162, 512, 132, 41);
		frame.getContentPane().add(btnNewButton);

		JButton btnTrLi = new JButton("Trở lại");
		btnTrLi.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTrLi.setBounds(26, 22, 144, 32);
		frame.getContentPane().add(btnTrLi);
		btnTrLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ChooseLaptop();
				frame.dispose();
			}
		});
		frame.setVisible(true);

	}

}
