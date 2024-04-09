package gk2_QuanLiMuaBanLaptop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EditFrame extends JFrame {
    private String selectedId;

    private JTextField idTextField;
    private JTextField tenTextField;
    private JTextField namsxTextField;
    private JTextField hangTextField;
    private JTextField cauhinhTextField;
    private JTextField soluongTextField;
    private JTextField giaTextField;

    public EditFrame(JFrame parentFrame, String selectedId) {
        this.selectedId = selectedId;

        setTitle("Edit Laptop");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 614);

        // Layout
        getContentPane().setLayout(new GridLayout(8, 2));
        setLocationRelativeTo(null);
		setResizable(false);

        // Components
        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 23));
        idTextField = new JTextField();
        idTextField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        idTextField.setEditable(false);
        JLabel tenLabel = new JLabel("Tên:");
        tenLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        tenTextField = new JTextField();
        tenTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
        JLabel namsxLabel = new JLabel("Năm sản xuất:");
        namsxLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        namsxTextField = new JTextField();
        namsxTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
        JLabel hangLabel = new JLabel("Hãng:");
        hangLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        hangTextField = new JTextField();
        hangTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
        JLabel cauhinhLabel = new JLabel("Cấu hình:");
        cauhinhLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        cauhinhTextField = new JTextField();
        cauhinhTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
        JLabel soluongLabel = new JLabel("Số lượng:");
        soluongLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        soluongTextField = new JTextField();
        soluongTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));
        JLabel giaLabel = new JLabel("Giá:");
        giaLabel.setFont(new Font("Tahoma", Font.PLAIN, 21));
        giaTextField = new JTextField();
        giaTextField.setFont(new Font("Tahoma", Font.PLAIN, 21));

        JButton btnTho = new JButton("Thoát");
        btnTho.setFont(new Font("Tahoma", Font.BOLD, 23));
        

        // Add components to the frame
        getContentPane().add(idLabel);
        getContentPane().add(idTextField);
        getContentPane().add(tenLabel);
        getContentPane().add(tenTextField);
        getContentPane().add(namsxLabel);
        getContentPane().add(namsxTextField);
        getContentPane().add(hangLabel);
        getContentPane().add(hangTextField);
        getContentPane().add(cauhinhLabel);
        getContentPane().add(cauhinhTextField);
        getContentPane().add(soluongLabel);
        getContentPane().add(soluongTextField);
        getContentPane().add(giaLabel);
        getContentPane().add(giaTextField);
        getContentPane().add(btnTho);
        
        JButton saveButton = new JButton("Lưu");
        saveButton.setFont(new Font("Tahoma", Font.BOLD, 22));
        getContentPane().add(saveButton);
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveData();
            }
        });
        loadData(); // Load existing data

        setVisible(true);
    }

    private void loadData() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectSQL.getConnection();
            String selectQuery = "SELECT * FROM laptop WHERE ID_laptop = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setString(1, selectedId);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("ID_laptop");
                String ten = resultSet.getString("ten");
                String namsx = resultSet.getString("namsx");
                String hang = resultSet.getString("hang");
                String cauhinh = resultSet.getString("cauhinh");
                String soluong = resultSet.getString("soluong");
                String gia = resultSet.getString("gia");

                idTextField.setText(String.valueOf(id));
                tenTextField.setText(ten);
                namsxTextField.setText(namsx);
                hangTextField.setText(hang);
                cauhinhTextField.setText(cauhinh);
                soluongTextField.setText(soluong);
                giaTextField.setText(gia);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void saveData() {
        int id = Integer.parseInt(idTextField.getText());
        String ten = tenTextField.getText();
        String namsx = namsxTextField.getText();
        String hang = hangTextField.getText();
        String cauhinh = cauhinhTextField.getText();
        String soluong = soluongTextField.getText();
        String gia = giaTextField.getText();

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectSQL.getConnection();
            String updateQuery = "UPDATE laptop SET ten = ?, namsx = ?, hang = ?, cauhinh = ?, soluong = ?, gia = ? WHERE ID_laptop = ?";
            statement = connection.prepareStatement(updateQuery);
            statement.setString(1, ten);
            statement.setString(2, namsx);
            statement.setString(3, hang);
            statement.setString(4, cauhinh);
            statement.setString(5, soluong);
            statement.setString(6, gia);
            statement.setInt(7, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Thông tin đã được cập nhật");;
                setVisible(false);
                new Storehouse();
            }
            else {
            	JOptionPane.showMessageDialog(null, "Cập nhật thất bại");;
                setVisible(false);
                new Storehouse();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}