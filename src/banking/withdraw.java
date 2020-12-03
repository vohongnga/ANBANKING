package banking;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class withdraw extends JFrame implements ActionListener{

		JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6;
		JButton btn1,btn2,btn3,btn4,other,cancel;
		Panel pn,pn1,pn2;
		Socket socket;
		
		public void GUI() {
			lb = new JLabel("Xin chao Vo Hong Nga",JLabel.CENTER);
			lb5 = new JLabel("Rút tiền",JLabel.CENTER);
			lb6 = new JLabel("");
			lb1 = new JLabel("");
			lb2 = new JLabel("");
			lb3 = new JLabel("");
			lb4 = new JLabel("");
			
			
			btn1= new JButton("100000 VNĐ");
			btn2 = new JButton("200000 VNĐ");
			btn3 = new JButton("500000 VNĐ");
			btn4 = new JButton("1000000 VNĐ");
			other = new JButton("Nhập số khác");
			cancel = new JButton("Huỷ bỏ giao dịch");
			
			
			btn1.addActionListener(this);
			btn2.addActionListener(this);
			btn3.addActionListener(this);
			btn4.addActionListener(this);
			cancel.addActionListener(this);
			other.addActionListener(this);
			
			pn1 = new Panel(new GridLayout(3,1));
			pn2 = new Panel (new GridLayout(3,3));
			pn = new Panel (new GridLayout(2,1));
			
			pn1.add(lb);
			pn1.add(lb5);
			pn1.add(lb6);
			
			pn2.add(btn1);
			pn2.add(lb1);
			pn2.add(btn2);
			
			pn2.add(btn3);
			pn2.add(lb2);
			pn2.add(btn4);
			
			pn2.add(other);
			pn2.add(lb3);
			pn2.add(cancel);
			
			
			pn.add(pn1);
			pn.add(pn2);
			add(pn);
			setSize(400,300);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				if(e.getSource()==btn1) {
					dos.writeInt(100000);
					String st = din.readUTF();
					lb6.setText(st);
				}
				if(e.getSource()==btn2) {
					dos.writeInt(200000);
					String st = din.readUTF();
					lb6.setText(st);
				}
				if(e.getSource()==btn3) {
					dos.writeInt(500000);
					String st = din.readUTF();
					lb6.setText(st);
				}
				if(e.getSource()==btn4) {
					dos.writeInt(1000000);
					String st = din.readUTF();
					lb6.setText(st);
				}
				if(e.getSource()==other) {
					new withdraw_other("ANBANKING",socket);
				}
				if(e.getSource()==cancel) {
					System.exit(0);
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
		}
		public  withdraw(String st,Socket socket) {
			super(st);
			this.socket = socket;
			GUI();
		}
}
