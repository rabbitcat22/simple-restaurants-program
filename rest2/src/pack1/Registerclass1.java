package pack1;
//로그인창
import java.awt.*;
import javax.swing.*;

public class Registerclass1 extends JFrame {//picture
	public Registerclass1(){
		JPanel p = new JPanel();
		add(p);
		setSize(550, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("OK !!");
		setVisible(true);
	}
	
	public void paint(Graphics g)
	{
		g.drawRect(30, 50, 460, 440);//20 and 40
		g.drawRect(110,390,300,50);
		g.drawRect(240,190,50,150);
		g.drawOval(140,80,50,50);
		g.drawOval(330,80,50,50);
		g.fillOval(160, 90, 30, 30);
		g.fillOval(330, 90, 30, 30);
	}
	
}
