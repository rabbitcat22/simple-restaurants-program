package pack1;
//정산
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Status {
	int count = 0;
	String show = "";

	public Status() {

		// 디자인단
		// 프레임 설정단
		JFrame frame = new JFrame("정산");
		frame.setBounds(0, 0, 625, 1000);
		frame.setBackground(Color.black);

		// 폰트
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
		Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);

		// 북쪽
		Panel pNorth = new Panel();
		pNorth.setBackground(new Color(255, 255, 215));
		pNorth.setLayout(null);
		pNorth.setSize(0, 500);
		pNorth.setFont(font);

		// 배열 설정 부분
		String menu[] = { "등심 스테이크", "안심 스테이크", "크림 파스타", "토마토 파스타", "고르곤졸라피자", "마르게리따피자", "골든멀렛퓨리", "블랙타워아이스로제" };
		int price[] = { 39000, 46000, 23000, 22000, 21000, 21000, 45000, 40000 };
		JButton bt[] = new JButton[menu.length];
		TextField suja[] = new TextField[menu.length];
		Button minus[] = new Button[menu.length];
		Button plus[] = new Button[menu.length];
		JButton ok[] = new JButton[menu.length];
		Label l[] = new Label[menu.length];
		ImageIcon icon[] = new ImageIcon[menu.length];

		// 버튼 설정 부분
		for (int i = 0; i < menu.length; i++) {

			// 햄버거 버튼
			bt[i] = new JButton(menu[i]);
			if (i < 4) {
				bt[i].setBounds(25 + i * 200, 50, 150, 100);
			} else {
				bt[i].setBounds(25 + (i - 4) * 200, 300, 150, 100);
			}
			icon[i] = new ImageIcon(i + ".png");
			bt[i].setIcon(icon[i]);

			// 숫자 txt 버튼
			suja[i] = new TextField("0");
			suja[i].setBackground(Color.white);
			suja[i].setEditable(false);
			suja[i].setBounds(bt[i].getX() + 30, bt[i].getY() + 130, 40, 20);

			// "-" 버튼
			minus[i] = new Button("-");
			minus[i].setBounds(bt[i].getX(), suja[i].getY(), 20, 20);
			minus[i].setEnabled(false);

			// "+" 버튼
			plus[i] = new Button("+");
			plus[i].setBounds(bt[i].getX() + (100 - 20), suja[i].getY(), 20, 20);
			plus[i].setEnabled(false);

			// 가격
			l[i] = new Label(price[i] + "원");
			l[i].setBounds(bt[i].getX() + 20, suja[i].getY() - 25, 100, 20);

			// 확인 버튼
			ok[i] = new JButton("확인");
			ok[i].setBounds(bt[i].getX(), suja[i].getY() + 30, 100, 20);
			ok[i].setEnabled(false);

			pNorth.add(bt[i]);
			pNorth.add(suja[i]);
			pNorth.add(minus[i]);
			pNorth.add(plus[i]);
			pNorth.add(l[i]);
			pNorth.add(ok[i]);
		}

		// 중앙
		TextArea ta = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
		ta.setText("   상품명        단가        수량        합계\n\n");
		ta.setBackground(Color.white);
		ta.setEditable(false);
		ta.setFont(font1);

		// 남쪽
		Panel pSouth = new Panel();
		pSouth.setFont(font);
		pSouth.setBackground(new Color(255, 255, 215));

		Button bt1 = new Button("주문");
		Button bt2 = new Button("초기화");
		Button bt3 = new Button("닫기");
		Button bt4 = new Button("예약");
		pSouth.add(bt1);
		pSouth.add(bt2);
		pSouth.add(bt3);
		pSouth.add(bt4);

		// 주문버튼
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, ta.getText() + " 주문되었습니다. \n이용해주셔서 감사합니다.");
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");

				}
			}
		});

		// 초기화 버튼
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < menu.length; i++) {
					bt[i].setEnabled(true);
					minus[i].setEnabled(false);
					plus[i].setEnabled(false);
					suja[i].setText("0");
					ta.setText("   상품명        단가        수량        합계\n\n");

				}
			}
		});

		// bt3 닫기버튼

		bt3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//예약버튼
		
		bt4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//new Quest();
				new Res();
				//new Input1();
			}
		});

		// 컴포넌트
		frame.add(pNorth, BorderLayout.NORTH);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(pSouth, BorderLayout.SOUTH);
		frame.setVisible(true);

		// 이벤트단
		for (int i = 0; i < menu.length; i++) {
			int j = i;

			// 햄버그 버튼 이벤트
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					minus[j].setEnabled(true);
					plus[j].setEnabled(true);
					bt[j].setEnabled(false);
					ok[j].setEnabled(true);

					count = 0;
				}
			});

			// "-" 버튼 이벤트
			minus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (count > 0) {
						count = count - 1;
						suja[j].setText(count + "");
						ok[j].setEnabled(true);
					} else {
						minus[j].setEnabled(false);
					}
				}
			});

			// "+" 버튼 이벤트
			plus[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					count = count + 1;
					suja[j].setText(count + "");
					ok[j].setEnabled(true);
					if (count > 0) {
						minus[j].setEnabled(true);
					}
				}
			});

			// 확인 버튼 이벤트
			ok[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					show = bt[j].getActionCommand();
					ta.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
							+ "원" + "\n");
					ok[j].setEnabled(false);
				}
			});

		}

		// 끄기
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	// 메인
	public static void main(String[] args) {
		new Status();
	}

}
//