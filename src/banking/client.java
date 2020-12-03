package banking;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class client extends JFrame implements ActionListener{
		 JLabel lb,lb1,lb2,lb3,lb4;
		JButton add,trans,check,cancel,sub;
		Panel pn,pn1,pn2;
		
		public void GUI() {
			lb = new JLabel("Xin chao Vo Hong Nga",JLabel.CENTER);
			lb1 = new JLabel("");
			lb2 = new JLabel("");
			lb3 = new JLabel("");
			lb4 = new JLabel("");
			
			
			add = new JButton("Nạp tiền");
			trans = new JButton("Chuyển tiền");
			sub = new JButton("Rút tiền");
			check = new JButton("Số dư");
			cancel = new JButton("Huỷ bỏ giao dịch");
			
			

			add.addActionListener(this);
			sub.addActionListener(this);
			trans.addActionListener(this);
			check.addActionListener(this);
			cancel.addActionListener(this);
			
			pn1 = new Panel(new FlowLayout());
			pn2 = new Panel (new GridLayout(3,3));
			pn = new Panel (new GridLayout(2,1));
			
			pn1.add(lb);
			pn2.add(add);
			pn2.add(lb1);
			pn2.add(sub);
			
			pn2.add(trans);
			pn2.add(lb2);
			pn2.add(check);
			
			pn2.add(cancel);
			pn2.add(lb3);
			pn2.add(lb4);
			
			
			pn.add(pn1);
			pn.add(pn2);
			add(pn);
			setSize(400,300);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Socket client;
			try {
				client = new Socket("localhost",9001);
				DataInputStream din = new DataInputStream(client.getInputStream());
				DataOutputStream dos = new DataOutputStream(client.getOutputStream());
				if(e.getSource()==add) {
					dos.writeUTF("add");	
					new add("ANBANKING",client);
				}
				if(e.getSource()==sub) {					 
					 dos.writeUTF("sub");	
					 new withdraw("ANBANKING",client);
				}
				if(e.getSource()==trans) {			
					dos.writeUTF("trans");	
					new trans("ANBANKING",client);
				}
				if(e.getSource()==check) {					
					dos.writeUTF("check");
					new balance("ANBANKING",client);
				}
				
				if(e.getSource()==cancel) {					
					dos.writeUTF("exit");					
					System.exit(0);				
				}
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				
					
		}
		public client(String st) {
			super(st);
			GUI();
		}
	public static void main(String args[]) throws ClassNotFoundException, UnknownHostException, IOException
	{
		
		client c = new client("ANBANKING");
		c.setVisible(true);
		
	}
	
}
