package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ChooseLaptop {

	private JFrame frame;
	private JTextField textField_tenlt;
	private JTextField textField_nsx;
	private JTextField textField_hang;
	private JTable table;
	private DefaultTableModel model;
	private JTable table_tt;
	private DefaultTableModel model_tt;
	private JTextField textField_tong;

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
		frame.setVisible(true);

		JButton btnNewButton = new JButton("Thanh toán");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnNewButton.setBounds(1067, 617, 181, 39);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Customer();
				frame.dispose();
			}
		});

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

		JLabel lblNewLabel_1 = new JLabel("Tra cứu Laptop");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1.setBounds(71, 450, 170, 33);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Tên Laptop");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(36, 495, 93, 24);
		frame.getContentPane().add(lblNewLabel_2);

		textField_tenlt = new JTextField();
		textField_tenlt.setBounds(159, 497, 222, 27);
		frame.getContentPane().add(textField_tenlt);
		textField_tenlt.setColumns(10);

		JButton btn_ten = new JButton("Tra cứu");
		btn_ten.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_ten.setBounds(408, 497, 93, 27);
		frame.getContentPane().add(btn_ten);

		btn_ten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ten = textField_tenlt.getText();
				traCuuTen(ten);
			}
		});

		JLabel lblNewLabel_2_1 = new JLabel("Hãng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(36, 534, 93, 24);
		frame.getContentPane().add(lblNewLabel_2_1);

		textField_hang = new JTextField();
		textField_hang.setColumns(10);
		textField_hang.setBounds(159, 533, 222, 27);
		frame.getContentPane().add(textField_hang);

		JButton btn_hang = new JButton("Tra cứu");
		btn_hang.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_hang.setBounds(408, 536, 93, 27);
		frame.getContentPane().add(btn_hang);

		btn_hang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String hang = textField_hang.getText();
				traCuuHang(hang);
			}
		});

		JLabel lblNewLabel_2_1_1 = new JLabel("Năm sản xuất");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2_1_1.setBounds(36, 570, 111, 24);
		frame.getContentPane().add(lblNewLabel_2_1_1);

		textField_nsx = new JTextField();
		textField_nsx.setColumns(10);
		textField_nsx.setBounds(159, 572, 222, 27);
		frame.getContentPane().add(textField_nsx);

		JButton btn_namsx = new JButton("Tra cứu");
		btn_namsx.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btn_namsx.setBounds(408, 572, 93, 27);
		frame.getContentPane().add(btn_namsx);

		btn_namsx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nam = textField_nsx.getText();
				traCuuNam(nam);
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 94, 1156, 334);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);

		model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("Tên Laptop");
		model.addColumn("Năm sản xuất");
		model.addColumn("Hãng");
		model.addColumn("Cấu hình");
		model.addColumn("Số lượng");
		model.addColumn("Giá");
		table.setModel(model);
		searchLaptop();

		JButton btnChn = new JButton("Chọn");
		btnChn.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btnChn.setBounds(801, 445, 111, 39);
		frame.getContentPane().add(btnChn);

		btnChn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow != -1) {
					String tenLaptop = table.getValueAt(selectedRow, 1).toString();
					double giaLaptop = Double.parseDouble(table.getValueAt(selectedRow, 6).toString());

					int selectedRow_tt = -1;
					for (int i = 0; i < model_tt.getRowCount(); i++) {
						if (model_tt.getValueAt(i, 0).toString().equals(tenLaptop)) {
							selectedRow_tt = i;
							break;
						}
					}
					if (selectedRow_tt == -1) {						
						model_tt.addRow(new Object[] { tenLaptop, 1, giaLaptop }); 
					} else {
						int soLuong = Integer.valueOf(model_tt.getValueAt(selectedRow_tt, 1).toString());
						double gia = Double.valueOf(model_tt.getValueAt(selectedRow_tt, 2).toString());
						model_tt.setValueAt(soLuong + 1, selectedRow_tt, 1); 
						model_tt.setValueAt(gia + giaLaptop, selectedRow_tt, 2); 
					}

					int soLuongLaptop = (int) table.getValueAt(selectedRow, 5);
					table.setValueAt(soLuongLaptop - 1, selectedRow, 5);
					int soLuong = Integer.parseInt(model.getValueAt(selectedRow, 5).toString()) - 1;
					model.setValueAt(soLuong, selectedRow, 5);

					String sqlUpdate = "UPDATE laptop SET soluong = ?";
					try {
						Connection conn = ConnectSQL.getConnection();
						PreparedStatement preparedStatement = conn.prepareStatement(sqlUpdate);
						preparedStatement.setInt(1, soLuong);
						preparedStatement.executeUpdate();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					searchLaptop();
				}
			}
		});

		JScrollPane scrollPane_tt = new JScrollPane();
		scrollPane_tt.setBounds(533, 497, 524, 209);
		frame.getContentPane().add(scrollPane_tt);
		table_tt = new JTable();
		scrollPane_tt.setViewportView(table_tt);

		model_tt = new DefaultTableModel();
		model_tt.addColumn("Tên Laptop");
		model_tt.addColumn("Số lượng");
		model_tt.addColumn("Giá");
		table_tt.setModel(model_tt);

		textField_tong = new JTextField();
		textField_tong.setColumns(10);
		textField_tong.setBounds(1080, 572, 158, 27);
		frame.getContentPane().add(textField_tong);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(1102, 526, 111, 39);
		frame.getContentPane().add(lblNewLabel_1_1);

		JButton btn_rfr = new JButton("Refresh");
		btn_rfr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_rfr.setBounds(169, 628, 93, 27);
		frame.getContentPane().add(btn_rfr);

		btn_rfr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchLaptop();
			}
		});
	}

	public void searchLaptop() {
		model.setRowCount(0);
		try {
			Connection conn = ConnectSQL.getConnection();
			Statement statement = conn.createStatement();

			String query = "SELECT * FROM laptop";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String ID = resultSet.getString("ID_laptop");
				String ten = resultSet.getString("ten");
				String nam = resultSet.getString("namsx");
				String hang = resultSet.getString("hang");
				String ch = resultSet.getString("cauhinh");
				String soluong = resultSet.getString("soluong");
				String gia = resultSet.getString("gia");

				model.addRow(new Object[] { ID, ten, nam, hang, ch, soluong, gia + " VND" });
			}

			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void traCuuTen(String tenlt) {
		if (tenlt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			model.setRowCount(0);
			Connection conn = ConnectSQL.getConnection();
			Statement statement = conn.createStatement();

			String query = "SELECT * FROM laptop WHERE ten LIKE '" + tenlt + "'";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String ID = resultSet.getString("ID_laptop");
				String ten = resultSet.getString("ten");
				String nam = resultSet.getString("namsx");
				String hang = resultSet.getString("hang");
				String ch = resultSet.getString("cauhinh");
				String soluong = resultSet.getString("soluong");
				String gia = resultSet.getString("gia");

				model.addRow(new Object[] { ID, ten, nam, hang, ch, soluong, gia + " VND"});
			}

			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void traCuuHang(String hanglt) {
		if (hanglt.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			model.setRowCount(0);
			Connection conn = ConnectSQL.getConnection();
			Statement statement = conn.createStatement();

			String query = "SELECT * FROM laptop WHERE hang = '" + hanglt + "'";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String ID = resultSet.getString("ID_laptop");
				String ten = resultSet.getString("ten");
				String nam = resultSet.getString("namsx");
				String hang = resultSet.getString("hang");
				String ch = resultSet.getString("cauhinh");
				String soluong = resultSet.getString("soluong");
				String gia = resultSet.getString("gia");

				model.addRow(new Object[] { ID, ten, nam, hang, ch, soluong, gia + " VND" });
			}

			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void traCuuNam(String namsx) {
		if (namsx.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập thông tin.", "Thông báo", JOptionPane.WARNING_MESSAGE);
			return;
		}
		try {
			model.setRowCount(0);
			Connection conn = ConnectSQL.getConnection();
			Statement statement = conn.createStatement();

			String query = "SELECT * FROM laptop WHERE namsx = '" + namsx + "'";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String ID = resultSet.getString("ID_laptop");
				String ten = resultSet.getString("ten");
				String nam = resultSet.getString("namsx");
				String hang = resultSet.getString("hang");
				String ch = resultSet.getString("cauhinh");
				String soluong = resultSet.getString("soluong");
				String gia = resultSet.getString("gia");

				model.addRow(new Object[] { ID, ten, nam, hang, ch, soluong, gia + " VND" });
			}

			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
