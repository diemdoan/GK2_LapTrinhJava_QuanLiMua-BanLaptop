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
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		ImageIcon backgroundImage = new ImageIcon("C:\\Users\\NAM\\Downloads\\laptop.jpg");
		JLabel backgroundLabel = new JLabel(backgroundImage);
		backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
		frame.setContentPane(backgroundLabel);

		JLabel lblNewLabel = new JLabel("Shop Laptop Điềm và Nam");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 49));
		lblNewLabel.setBounds(307, 10, 648, 50);
		frame.getContentPane().add(lblNewLabel);		
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);

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
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		

		JLabel lblNewLabel_2 = new JLabel("Tên Laptop");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(36, 495, 93, 24);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setOpaque(true);

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
		lblNewLabel_2_1.setBackground(Color.WHITE);
		lblNewLabel_2_1.setOpaque(true);

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
		lblNewLabel_2_1_1.setBackground(Color.WHITE);
		lblNewLabel_2_1_1.setOpaque(true);

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
					String selectedID = (String) table.getValueAt(selectedRow, 0);
					try {
						Connection conn = ConnectSQL.getConnection();
						Statement statement = conn.createStatement();
						String selectQuery = "SELECT ten, gia, soluong FROM laptop WHERE ID_laptop = " + selectedID;
						ResultSet resultSet = statement.executeQuery(selectQuery);
						if (resultSet.next()) {
							String tenLaptop = resultSet.getString("ten");
							double giaLaptop = resultSet.getDouble("gia");

							boolean isExist = false;
							int currentRow = -1;
							for (int i = 0; i < model_tt.getRowCount(); i++) {
								String id = (String) model_tt.getValueAt(i, 0);
								if (id.equals(selectedID)) {
									isExist = true;
									currentRow = i;
									break;
								}
							}

							if (isExist) {
								int currentSoLuong = (int) model_tt.getValueAt(currentRow, 2);
								double currentGia = (double) model_tt.getValueAt(currentRow, 3);
								model_tt.setValueAt(currentSoLuong + 1, currentRow, 2);
								model_tt.setValueAt(currentGia + giaLaptop, currentRow, 3);
							} else {
								model_tt.addRow(new Object[] { selectedID, tenLaptop, 1, giaLaptop });
							}

							String updateQuery = "UPDATE laptop SET SoLuong = SoLuong - 1 WHERE ID_laptop = "
									+ selectedID;
							statement.executeUpdate(updateQuery);

						}
						resultSet.close();
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
		model_tt.addColumn("ID");
		model_tt.addColumn("Tên Laptop");
		model_tt.addColumn("Số lượng");
		model_tt.addColumn("Giá");
		table_tt.setModel(model_tt);

		JButton btnNewButton = new JButton("Thanh toán");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(1092, 498, 134, 33);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totalPrice = 0;
				for (int i = 0; i < model_tt.getRowCount(); i++) {
					double gia = (double) model_tt.getValueAt(i, 3);
					int soLuong = (int) model_tt.getValueAt(i, 2);
					totalPrice += gia * soLuong;
				}
				textField_tong.setText(String.valueOf(totalPrice));
			}
		});

		textField_tong = new JTextField();
		textField_tong.setColumns(10);
		textField_tong.setBounds(1077, 567, 171, 27);
		frame.getContentPane().add(textField_tong);

		JLabel lblNewLabel_1_1 = new JLabel("Tổng tiền");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel_1_1.setBounds(1109, 529, 111, 39);
		frame.getContentPane().add(lblNewLabel_1_1);
		lblNewLabel_1_1.setBackground(Color.WHITE);
		lblNewLabel_1_1.setOpaque(true);

//		JButton btninThngTin = new JButton("Điền thông tin ");
//		btninThngTin.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		btninThngTin.setBounds(1080, 628, 168, 50);
//		frame.getContentPane().add(btninThngTin);
//		btninThngTin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				new Customer();
//				frame.dispose();
//			}
//		});

		JButton btn_rfr = new JButton("Refresh");
		btn_rfr.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_rfr.setBounds(169, 628, 93, 27);
		frame.getContentPane().add(btn_rfr);
		btn_rfr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchLaptop();
			}
		});

		JButton btn_xoa = new JButton("Xóa");
		btn_xoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_xoa.setBounds(574, 455, 84, 27);
		frame.getContentPane().add(btn_xoa);

		btn_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table_tt.getSelectedRow();
				if (selectedRow >= 0) {
					Object selectedId = table_tt.getValueAt(selectedRow, 0);

					try {
						Connection connection = ConnectSQL.getConnection();
						String selectQuery = "SELECT soluong FROM laptop WHERE ID_laptop = " + selectedId;
						PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
						ResultSet resultSet = selectStatement.executeQuery();

						if (resultSet.next()) {
							Object soluongFromDB = resultSet.getObject("soluong");
							Object soluongFromTable = table_tt.getValueAt(selectedRow, 2);

							int slFromDB = (soluongFromDB != null) ? (int) soluongFromDB : 0;
							int slFromTable = (soluongFromTable != null) ? (int) soluongFromTable : 0;

							int sl = slFromDB + slFromTable;
							String sql = "UPDATE laptop SET soluong = ? WHERE ID_laptop = ?";
							PreparedStatement statement = connection.prepareStatement(sql);
							statement.setInt(1, sl);
							statement.setObject(2, selectedId);
							statement.executeUpdate();
							statement.close();
						}

						resultSet.close();
						selectStatement.close();

						connection.close();

						searchLaptop();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					DefaultTableModel model = (DefaultTableModel) table_tt.getModel();
					model.removeRow(selectedRow);

				} else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn một hàng để xóa.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
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

				model.addRow(new Object[] { ID, ten, nam, hang, ch, soluong, gia + " VND" });
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
