package pack1;
//가입창2
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Registerclass2 extends JFrame {// if clicked Modified
	public Registerclass2() {
		JPanel p = new JPanel();
		p.setLayout(null);
		Label l1 = new Label("Name");
		Label l2 = new Label("ID");
		Label l3 = new Label("password");
		Label l4 = new Label("address");
		Label l5 = new Label("details");
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		TextField t1 = new TextField();
		TextField t2 = new TextField();
		TextField t3 = new TextField();
		TextField t4 = new TextField();
		TextField t5 = new TextField();
		t3.setEchoChar('*'); // password
		add(t1);
		add(t2);
		add(t3);
		add(t4);
		add(t5);
		t1.setEditable(false);
		t2.setEditable(false);
		t3.setEditable(false);
		JButton j1 = new JButton("Modifi");
		JButton j2 = new JButton("Cancel");
		add(j1);
		add(j2);
		l1.setBounds(40, 10, 40, 40);
		l2.setBounds(40, 50, 40, 40);
		l3.setBounds(40, 90, 60, 40);
		l4.setBounds(40, 130, 40, 40);
		l5.setBounds(40, 170, 60, 40);
		t1.setBounds(120, 10, 200, 30);
		t2.setBounds(120, 50, 200, 30);
		t3.setBounds(120, 90, 200, 30);
		t4.setBounds(120, 130, 280, 30);
		t5.setBounds(120, 180, 280, 120);
		j1.setBounds(125, 330, 80, 30);
		j2.setBounds(240, 330, 80, 30);
		add(p);
		setSize(500, 500);
		setTitle("Modified ~_~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		try { // update member info
			String s;
			String[] array;
			BufferedReader br = new BufferedReader(new FileReader("회원창고.txt"));
			while ((s = br.readLine()) != null) {
				array = s.split("/");
				t1.setText(array[0]);
				t2.setText(array[1]);
				t3.setText(array[2]);
				t4.setText("");
				t5.setText("");
			}
			br.close();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		j1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e77) {// saving modified info
				try {
					BufferedWriter bo = new BufferedWriter(new FileWriter("회원창고.txt"));
					bo.write(t1.getText() + "/");
					bo.write(t2.getText() + "/");
					bo.write(t3.getText() + "/");
					bo.write(t4.getText() + "/");
					bo.write(t5.getText() + "\r\n");
					bo.close();
					JOptionPane.showMessageDialog(null, "Saved :3.");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Save FAIL..T_T");
				}
			}
		});

		j2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
	}
}
