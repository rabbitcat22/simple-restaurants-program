package pack1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Res {
	// 프레임 선언
	JFrame jFrame = new JFrame("예약");

	// Swing에서의 텍스트 영역 스크롤바가 존재하지 않는다.
	JTextArea textArea = new JTextArea("예약시간 입력하세요.", 5, 10);// 스크롤바 없음

	// Swing에서 스크롤바를 넣기 위해 아래와 같이 사용한다.
	JScrollPane jp = new JScrollPane(textArea);// 스클롤바 만들기

	// 메뉴 선언
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("다시 예약");

	public Res() {
		// 파일 메뉴 생성

		// fileMenu.add(new JMenuItem("다시 예약"));
		// fileMenu.getItem(0).setAccelerator(KeyStroke.getKeyStroke('N',
		// InputEvent.CTRL_MASK ^ InputEvent.ALT_MASK)); // 단축키설정
		// fileMenu.add(new JMenuItem("열기"));
		// fileMenu.add(new JMenuItem("저장"));

		fileMenu.addSeparator(); // 구분선 추가
		fileMenu.add(new JMenuItem("종료"));

		// 도움 메뉴 생성

		// 메뉴를 메뉴바에 등록
		// menuBar.add(fileMenu);
		JMenuBar m = new JMenuBar();
		jFrame.setJMenuBar(m);

		JMenu m_file = new JMenu("메뉴");
		m.add(m_file);

		JMenuItem i_save = new JMenuItem("저장");

		m.add(i_save);

		// 메뉴바 추가
		jFrame.setJMenuBar(m);

		// 텍스트 영역 추가
		jFrame.add(jp, "Center");

		// 프레임 크기 지정
		jFrame.setSize(300, 300);

		// 프레임 보이기
		jFrame.setVisible(true);

		// swing에만 있는 X버튼 클릭시 종료
		// jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * JMenu m_file = new JMenu("메뉴"); jFrame.add(m_file);
		 * 
		 * JMenuItem i_save = new JMenuItem("저장");
		 * 
		 * jFrame.add(i_save);
		 */
		i_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(textArea, "예약되었습니다.");
			}
		});

		// JOptionPane.showMessageDialog(textArea, "예약되었습니다.");

	}

	public static void main(String[] args) {
		// 실행
		new Res();
	}
}
