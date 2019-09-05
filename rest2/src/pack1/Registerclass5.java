package pack1;

//첫 로그인 화면
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Registerclass5 extends JFrame { // sign main
	Image img = null;

	public Registerclass5() {
		JPanel p = new JPanel();
		p.setLayout(null);
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\rem22\\Desktop\\javalogo\\logo.jpg"));
		add(label);
		Label t1 = new Label("이랏샤이.");
		add(t1);
		Label t2 = new Label("이곳은 아이디를 입력하셔");
		add(t2);
		Label t3 = new Label("야만 사용이 가능합니다!");
		add(t3);
		Label t4 = new Label("아이디입력 후 로그인 버튼을 눌러주세요.");
		add(t4);
		Label b2 = new Label("ID:");
		add(b2);
		Label b3 = new Label("password:");
		add(b3);
		TextField b4 = new TextField();
		add(b4); // 여기서부터 버튼 이벤트 부분
		TextField b5 = new TextField();
		add(b5);
		b5.setEchoChar('*'); // password be *
		JButton b6 = new JButton("Sign IN");
		add(b6);
		JButton b7 = new JButton("회원가입 ");
		add(b7);

		label.setBounds(0, 5, 350, 255);
		t1.setBounds(350, 5, 70, 40);
		t2.setBounds(350, 35, 280, 40);
		t3.setBounds(350, 65, 150, 40);
		t4.setBounds(350, 95, 250, 40);
		b2.setBounds(40, 265, 40, 40);
		b3.setBounds(40, 305, 60, 40);
		b4.setBounds(150, 265, 200, 30);
		b5.setBounds(150, 305, 200, 30);
		b6.setBounds(380, 265, 80, 30);
		b7.setBounds(380, 305, 90, 30);
		add(p);
		setSize(700, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("레스토랑");
		setVisible(true);
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) { // 화면전환(회원가입창으로 이동)
				Registerclass4 f2 = new Registerclass4();
			}
		});
		b6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e2) { // Sign IN 할시
				try {
					String s;
					String[] array;
					BufferedReader bos = new BufferedReader(new FileReader("회원창고.txt"));
					while ((s = bos.readLine()) != null) {
						array = s.split("/");
						if (b4.getText().equals(array[1]) && b5.getText().equals(array[2])) {
							JOptionPane.showMessageDialog(null, "Sign IN O^O");
							Calendar cal = Calendar.getInstance();
							int month = cal.get(Calendar.MONTH) + 1;
							int date = cal.get(Calendar.DATE);
							String j, n, m;
							j = month + "";
							n = date + "";
							m = j + n;
							if (array[4].equals(m)) {
								JOptionPane.showMessageDialog(null, "생일축하드립니다 만원할인쿠폰증정");
							}
							Registerclass3 f3 = new Registerclass3();
						} else {
							JOptionPane.showMessageDialog(null, "Sign IN FAIL..T_T");
						}
					}
					bos.close();
					dispose();
				} catch (IOException E10) {
					E10.printStackTrace();
				}
			}
		});
	}
}