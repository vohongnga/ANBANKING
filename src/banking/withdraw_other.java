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

public class withdraw_other extends JFrame implements ActionListener{

		JLabel lb,lb1,lb2,lb3,lb4,lb5,lb6;
		JButton ok,cancel;
		JTextField txta,txtb,txtkq;
		Panel pn,pn1,pn2,pn3;
		Socket socket;
		
		public void GUI() {
			lb = new JLabel("Xin chao Vo Hong Nga",JLabel.CENTER);
			lb5 = new JLabel("Rút tiền",JLabel.CENTER);
			lb6 = new JLabel("");
			lb1 = new JLabel("Số tiền: ");
			
			
			txta = new JTextField(7);
			
			cancel = new JButton("Huỷ bỏ giao dịch");
			ok = new JButton("OK");
			
			ok.addActionListener(this);
			cancel.addActionListener(this);
			
			pn1 = new Panel(new GridLayout(3,1));
			pn2 = new Panel (new GridLayout(1,2));
			pn3 = new Panel(new FlowLayout());
			pn = new Panel (new GridLayout(3,1));
			
			pn1.add(lb);
			pn1.add(lb5);
			pn1.add(lb6);
			
			pn2.add(lb1);
			pn2.add(txta);

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
					int a = Integer.parseInt(txta.getText());
//					Locale localeVN = new Locale("vi", "VN");
//				    NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
//				    String str1 = currencyVN.format(a);
					dos.writeInt(a);
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
		public  withdraw_other(String st,Socket socket) {
			super(st);
			this.socket = socket;
			GUI();
		}
}
