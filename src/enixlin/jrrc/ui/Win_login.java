package enixlin.jrrc.ui;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.message.BufferedHeader;

import enixlin.jrrc.net.http_request;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.security.auth.login.LoginContext;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
/**
 * 用户登录
 * @author linzhenhuan
 *1\返回cookie sessionid等服务器信息
 *2\通过/oa/message/message_move.jsp返回的html代码中定位用户id
 *3\通过获取全行机构树 用户id定位用户名和所在的机构
 */
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
					UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
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
	
				String loginName = textField.getText();
				String passWord = textField_1.getText();
				try {
					passWord = new BASE64Encoder().encode(passWord.getBytes("utf-8"));
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ArrayList<BasicNameValuePair> params = new ArrayList<>();
				params.add(new BasicNameValuePair("loginName", loginName));
				params.add(new BasicNameValuePair("passWord", passWord));
				URI url = null;
				try {
					url = new URI("http://www.126.com");
				} catch (URISyntaxException e) {
					e.printStackTrace();
					//
				}
				login(url, params);
			}
		});

		btnNewButton.setBounds(131, 153, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScriptEngineManager manager = new ScriptEngineManager();  
				 ScriptEngine engine = manager.getEngineByName("javascript");
				
				 String script="function NodeData(type,name,level,id,departmentid){this.type=type;this.name=name;this.level=level;this.id=id;this.departmentid=departmentid;}  "
				 		+ " var d0=new NodeData(0,'广东省农村信用社','d','0'); var d1=new NodeData(1,'省联社',1,'2579',d0);var d2=new NodeData(2,'省联社领导',1,'2079',d1);var d9=new NodeData(9,'顾问',1,'9226',d1);var d11=new NodeData(11,'主任助理',1,'3081',d1);var d13=new NodeData(13,'专家',1,'9442',d1);var d16=new NodeData(16,'调研员',1,'6529',d1);var d17=new NodeData(17,'巡视组',1,'9656',d1);var d19=new NodeData(19,'办公室',1,'2080',d1);var d20=new NodeData(20,'主任室',1,'10280',d19);var d22=new NodeData(22,'综合室',1,'10277',d19);var d27=new NodeData(27,'秘书室',1,'10278',d19);var d32=new NodeData(32,'文印室',1,'10279',d19);var d38=new NodeData(38,'基建',1,'10281',d19);var d62=new NodeData(62,'人力资源部',1,'2081',d1);var d85=new NodeData(85,'改革与战略研究部',1,'2085',d1);var d92=new NodeData(92,'计划资金财务部',1,'2083',d1);var d107=new NodeData(107,'资金调剂营运中心',1,'7597',d1);var d108=new NodeData(108,'总经理室',1,'8031',d107);var d112=new NodeData(112,'投资业务室',1,'8032',d107);var d120=new NodeData(120,'风险控制室',1,'8033',d107);var d125=new NodeData(125,'资金清算室',1,'8034',d107);var d131=new NodeData(131,'理财服务室(理财服务中心)',1,'8035',d107);";
				 
				 
			        try {
						engine.eval(script);
					} catch (ScriptException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}   
			        Object obj = engine.get("d1");   
			        System.out.println(obj);
			}
		});
		btnNewButton_1.setBounds(234, 153, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	private void login(URI url, ArrayList<BasicNameValuePair> params) {
		CloseableHttpClient client = HttpClients.createDefault();
		try {
			HttpPost post = new HttpPost(url);
			// 请求参数
			post.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			CloseableHttpResponse response = client.execute(post);
			HttpEntity entity = response.getEntity();
			InputStream is = entity.getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));

			String row = "";
			String content = "";
			while ((row = reader.readLine()) != null) {
				content = content + row;
			}

			System.out.println(content);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
