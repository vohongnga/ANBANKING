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
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class trans extends JFrame implements ActionListener{

		JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6;
		JButton ok,cancel;
		JTextField txta,txtb,txtkq;
		Panel pn,pn1,pn2,pn3;
		Socket socket;
		
		public void GUI() {
			lb = new JLabel("Xin chao Vo Hong Nga",JLabel.CENTER);
			lb5 = new JLabel("Chuyển tiền",JLabel.CENTER);
			lb6 = new JLabel("");
			lb1 = new JLabel("Số tài khoản đích: ");
			lb2 = new JLabel("Số tiền muốn chuyển: ");
			
			txta = new JTextField(7);
			txtb = new JTextField(7);
			
			cancel = new JButton("Huỷ bỏ giao dịch");
			ok = new JButton("OK");
			
			cancel.addActionListener(this);
			ok.addActionListener(this);
			
			pn1 = new Panel(new GridLayout(3,1));
			pn2 = new Panel (new GridLayout(2,2));
			pn3 = new Panel(new GridLayout(1,2));
			pn = new Panel (new GridLayout(3,1));
			
			pn1.add(lb);
			pn1.add(lb5);
			pn1.add(lb6);
			
			pn2.add(lb1);
			pn2.add(txta);
			
			pn2.add(lb2);
			pn2.add(txtb);
			
			pn3.add(ok);
			pn3.add(cancel);
			
			pn.add(pn1);
			pn.add(pn2);
			pn.add(pn3);
			add(pn);
			setSize(400,300);
			setVisible(true);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
			DataInputStream din = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			if(e.getSource()==ok) {
				int n = Integer.parseInt(txtb.getText());
				dos.writeInt(n);
				String st = din.readUTF();
				lb6.setText(st);
			}
			if(e.getSource()==cancel) {
				System.exit(0);
			}
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		public  trans(String st,Socket socket) {
			super(st);
			this.socket = socket;
			GUI();
		}
}
