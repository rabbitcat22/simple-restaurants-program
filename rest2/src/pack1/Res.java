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
	// ������ ����
	JFrame jFrame = new JFrame("����");

	// Swing������ �ؽ�Ʈ ���� ��ũ�ѹٰ� �������� �ʴ´�.
	JTextArea textArea = new JTextArea("����ð� �Է��ϼ���.", 5, 10);// ��ũ�ѹ� ����

	// Swing���� ��ũ�ѹٸ� �ֱ� ���� �Ʒ��� ���� ����Ѵ�.
	JScrollPane jp = new JScrollPane(textArea);// ��Ŭ�ѹ� �����

	// �޴� ����
	JMenuBar menuBar = new JMenuBar();
	JMenu fileMenu = new JMenu("�ٽ� ����");

	public Res() {
		// ���� �޴� ����

		// fileMenu.add(new JMenuItem("�ٽ� ����"));
		// fileMenu.getItem(0).setAccelerator(KeyStroke.getKeyStroke('N',
		// InputEvent.CTRL_MASK ^ InputEvent.ALT_MASK)); // ����Ű����
		// fileMenu.add(new JMenuItem("����"));
		// fileMenu.add(new JMenuItem("����"));

		fileMenu.addSeparator(); // ���м� �߰�
		fileMenu.add(new JMenuItem("����"));

		// ���� �޴� ����

		// �޴��� �޴��ٿ� ���
		// menuBar.add(fileMenu);
		JMenuBar m = new JMenuBar();
		jFrame.setJMenuBar(m);

		JMenu m_file = new JMenu("�޴�");
		m.add(m_file);

		JMenuItem i_save = new JMenuItem("����");

		m.add(i_save);

		// �޴��� �߰�
		jFrame.setJMenuBar(m);

		// �ؽ�Ʈ ���� �߰�
		jFrame.add(jp, "Center");

		// ������ ũ�� ����
		jFrame.setSize(300, 300);

		// ������ ���̱�
		jFrame.setVisible(true);

		// swing���� �ִ� X��ư Ŭ���� ����
		// jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/*
		 * JMenu m_file = new JMenu("�޴�"); jFrame.add(m_file);
		 * 
		 * JMenuItem i_save = new JMenuItem("����");
		 * 
		 * jFrame.add(i_save);
		 */
		i_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(textArea, "����Ǿ����ϴ�.");
			}
		});

		// JOptionPane.showMessageDialog(textArea, "����Ǿ����ϴ�.");

	}

	public static void main(String[] args) {
		// ����
		new Res();
	}
}
