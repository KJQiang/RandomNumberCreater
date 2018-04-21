package ui_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomNumber {
	static boolean dci = false;
	static int ac = 0, bir = 0;
	public static void main(String[] args) {
		JFrame window = new JFrame("Create Random Number");
		window.setSize(350,200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		window.add(panel);
		addmypanel(panel);
		window.setVisible(true);
	}
	private static void addmypanel(JPanel newpanel) {
		newpanel.setLayout(null);
		JLabel text1 = new JLabel("Enter the area of random number 0-x");
		text1.setBounds(50,10, 250, 25);
		newpanel.add(text1);
		JTextField enternum = new JTextField(20);
		enternum.setBounds(50, 50, 100, 50);
		newpanel.add(enternum);
		JButton begin = new JButton("Start");
		begin.setBounds(200, 55, 50, 40);
		newpanel.add(begin);
		JButton end = new JButton("Stop");
		end.setBounds(250, 55, 50, 40);
		newpanel.add(end);
		begin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numin;
				dci = true;
				numin = enternum.getText();
				bir = Integer.parseInt(numin);
				new Thread(new Runnable() { //start a new thread or the programm will be stopped here.
					public void run() {
						while(dci) {
							Mathnum rn = new Mathnum(bir);
							ac = rn.createNum();
							enternum.setText(ac+"");
							try {
								Thread.currentThread();
								Thread.sleep(100);
							}
							catch(Exception d) {}
						}
					}
				}).start();
			}
		});
		end.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dci = false;
				enternum.setText(bir+"");
			}
		});
	}
}
