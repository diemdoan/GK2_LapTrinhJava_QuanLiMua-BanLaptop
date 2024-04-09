package gk2_QuanLiMuaBanLaptop;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Storehouse {
	private JFrame frame;
	private JTextField textField_tenLap;
	private JTextField textField_nam;
	private JTextField textField_hang;
	private JTextField textField_cauhinh;
	private JTextField textField_sl;
	private JTextField textField_gia;
	private DefaultTableModel model;

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
		frame.setVisible(true);

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

		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnThem.setBounds(162, 512, 132, 41);
		frame.getContentPane().add(btnThem);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(495, 94, 705, 419);
		frame.getContentPane().add(scrollPane);
		JTable table = new JTable();
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

		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSua.setBounds(934, 546, 132, 41);
		frame.getContentPane().add(btnSua);
		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					Object selectedId = table.getValueAt(selectedRow, 0);

					EditFrame editFrame = new EditFrame(frame, selectedId.toString());

					editFrame.setVisible(true);
					frame.setVisible(false);
				} else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn một hàng để chỉnh sửa.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		// Nút Thêm Ở Đây
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String tenLap = textField_tenLap.getText();
				String namsx = textField_nam.getText();
				String hang = textField_hang.getText();
				String cauHinh = textField_cauhinh.getText();
				String soLuong = textField_sl.getText();
				String gia = textField_gia.getText();

				if (tenLap.isEmpty() || namsx.isEmpty() || hang.isEmpty() || cauHinh.isEmpty() || soLuong.isEmpty()
						|| gia.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						int namSX = Integer.parseInt(namsx);
						int sl = Integer.parseInt(soLuong);
						int price = Integer.parseInt(gia);

						if (namSX > 2023) {
							JOptionPane.showMessageDialog(frame, "Năm xuất bản không được lớn hơn 2024.");
						} else {
							Connection conn = ConnectSQL.getConnection();

							String sql = "INSERT INTO laptop (ten, namsx, hang, cauhinh, soluong, gia) VALUES "
									+ "( ?, ?, ?, ?, ?, ?)";
							PreparedStatement statement = conn.prepareStatement(sql);
							statement.setString(1, tenLap);
							statement.setInt(2, namSX);
							statement.setString(3, hang);
							statement.setString(4, cauHinh);
							statement.setInt(5, sl);
							statement.setLong(6, price);

							int rowsInserted = statement.executeUpdate();
							if (rowsInserted > 0) {
								JOptionPane.showMessageDialog(frame, "Thêm Laptop thành công.");
								searchLaptop();
								;
							}

							statement.close();
							conn.close();
						}
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(frame, "Vui lòng nhập số cho năm sản xuất, giá và số lượng!");
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					searchLaptop();
					;
				}

			}
		});

		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnXoa.setBounds(651, 546, 132, 41);
		frame.getContentPane().add(btnXoa);
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				if (selectedRow >= 0) {
					Object selectedId = table.getValueAt(selectedRow, 0);
					try {
						Connection connection = ConnectSQL.getConnection();
						String deleteQuery = "DELETE FROM laptop WHERE ID_laptop = ?";
						PreparedStatement statement = connection.prepareStatement(deleteQuery);
						statement.setObject(1, selectedId);
						statement.executeUpdate();
						
						statement.close();
						connection.close();

						searchLaptop();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(frame, "Vui lòng chọn một hàng để xóa.", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		});

	}

	// hàm đây để cập nhật lại bảng nè!!!!!!!!!!!!
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
}
