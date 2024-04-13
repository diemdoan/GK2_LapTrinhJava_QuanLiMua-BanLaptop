package gk2_QuanLiMuaBanLaptop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bill {
	
	private JFrame frame;
	private JTextArea textArea_Bill;
	
	public static void main(String[] args) {
		Bill window = new Bill();
		window.frame.setVisible(true);

	}

	public Bill(){
		frame = new JFrame();
		frame.setBounds(100, 100, 1025, 792);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Chi tiết đơn hàng:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(52, 88, 192, 38);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(457, 690, 145, 38);
		frame.getContentPane().add(btnNewButton);
		
		textArea_Bill = new JTextArea();
		textArea_Bill.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea_Bill.setEditable(false);
		textArea_Bill.setBounds(52, 150, 921, 490);
		frame.getContentPane().add(textArea_Bill);
		
		//Đoạn ni xuất từ file
		//Trước khi chạy nhớ đổi đường dẫn
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\NAM\\Desktop\\Hóa Đơn\\Bill.txt"));
			String line;
			
			StringBuilder billText = new StringBuilder();
			
			while ((line = reader.readLine()) != null) {
				billText.append(line);
				billText.append("\n");
			}
			
			textArea_Bill.setText(billText.toString());
			
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}