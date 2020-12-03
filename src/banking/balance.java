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
import javax.swing.JTextField;

public class balance extends JFrame implements ActionListener{

		JLabel lb,lb1,lb2,lb3,lb4,lb5;
		JButton ok,cancel;
		JTextField txta,txtb,txtkq;
		Panel pn,pn1,pn2,pn3;
		Socket socket;
		
		public void GUI() {
			try {
				DataInputStream din = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				String msg = Integer.toString(din.readInt());
				
			lb = new JLabel("Xin chào Võ Hồng Nga",JLabel.CENTER);
			lb5 = new JLabel("Số dư tài khoản",JLabel.CENTER);
			lb1 = new JLabel("Số dư: ");
			
			
			txta = new JTextField(7);
			txta.setText(msg);
			
			cancel = new JButton("Huỷ bỏ giao dịch");
			
			cancel.addActionListener(this);
			
			pn1 = new Panel(new GridLayout(2,1));
			pn2 = new Panel (new GridLayout(1,2));
			pn3 = new Panel(new FlowLayout());
			pn = new Panel (new GridLayout(3,1));
			
			pn1.add(lb);
			pn1.add(lb5);
			
			
			pn2.add(lb1);
			pn2.add(txta);
			

			
			pn3.add(cancel);
			
			pn.add(pn1);
			pn.add(pn2);
			pn.add(pn3);
			add(pn);
			setSize(400,300);
			setVisible(true);
			}catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==cancel) {
				System.exit(0);
			}
		}
		
		public balance(String st,Socket socket) {
			super(st);
			this.socket = socket;
			GUI();
		}
		
}
