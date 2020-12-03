package banking;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.*;

class giaodien extends JFrame implements ActionListener {
	JLabel lb,lb1,lb2,lb3,lb4;
	JButton add,trans,check,cancel,sub;
	Panel pn,pn1,pn2;
	
	public void GUI() {
		lb = new JLabel("Xin chao Vo Hong Nga");
		lb1 = new JLabel("");
		lb2 = new JLabel("");
		lb3 = new JLabel("");
		lb4 = new JLabel("");
		
		
		add = new JButton("Nạp tiền vào tài khoản");
		trans = new JButton("Chuyển tiền");
		sub = new JButton("Rút tiền");
		check = new JButton("Kiểm tra tài khoản");
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
		if(e.getSource()==add) {
			
		}
		if(e.getSource()==sub) {
			
		}
		if(e.getSource()==trans) {
			
		}
		if(e.getSource()==check) {
			
		}
		
		if(e.getSource()==cancel) {
			System.exit(0);
		}
	}
	public void display() {
		GUI();
	}
}
	class thread extends Thread{
		Socket socket = null;
		giaodien g;
		
		thread(giaodien g){
			this.g = g;
			
		}
		public void run()
		{
			g.display();
		}
	}
	public class gui{
		public static void main (String [] args) {
			giaodien g = new giaodien();
			thread t = new thread(g);
			t.start();
		}
	}
	

