package enixlin.jrrc.ui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enixlin.jrrc.net.http_request;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Win_login {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Win_login window = new Win_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Win_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u878D\u548C\u519C\u5546\u94F6\u884C\u90AE\u4EF6\u5DE5\u5177");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setBounds(44, 73, 54, 15);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setBounds(44, 111, 54, 15);
		frame.getContentPane().add(label_1);

		textField = new JTextField();
		textField.setBounds(108, 70, 156, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(108, 108, 156, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
//
		// 登录按键按下
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Win_main win_main=new Win_main();
				win_main.main(null);
				
				// 检查用户名和密码是否填好
				// String strLoginName=textField.getText();
				// String strPassWord=textField_1.getText();
				// if (strLoginName=="" || strPassWord=="") {
				//
				// }else{
				//
				// }
				// //生成新的HttpClient
				// http_request http_request=new http_request();
				
			}
		});

		btnNewButton.setBounds(171, 154, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
