package ch_11;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;


//�ִϸ��̼� �ۼ��ϱ� �׷��� �̿� 
class MyPanel extends JPanel implements ActionListener{
	
	//�ʵ� 
	private final int WIDTH = 500; //private ����� ���� 
	private final int HEIGHT = 300;
	private final int START_X = 0; 
	private final int START_Y = 250;
	
	private BufferedImage image;
	private Timer timer;
	private int x,y;

	
	//������ 
	public MyPanel() {
		setBackground(Color.BLACK);
		setPreferredSize(new Dimension(WIDTH, HEIGHT)); 
		setDoubleBuffered(true);
		
		File input = new File("ship.jpg");
		try {
			image = ImageIO.read(input);
		}catch(IOException e){
			e.printStackTrace();
				
		}
		
		x = START_X;
		y = START_Y;
	
	}
	
	
	//�׸��� �޼ҵ� ������ (JPanel �� �޼ҵ�)
	@Override
	protected void paintComponent(Graphics g) {
		// TODO �ڵ� ������ �޼ҵ� ����
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	//�̺�Ʈ �޼ҵ� ������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �ڵ� ������ �޼ҵ� ����
		x += 1;
		y -= 1;
		if(x>WIDTH) {
			x = START_X;
			y = START_Y;
		}
		repaint();
	}
}
public class MyFrame extends JFrame{

	//MyFrame ������ 
	public MyFrame() {
		add(new MyPanel());
		setTitle("�ִϸ��̼� �׽�Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		setVisible(true);
	}
	//main()
	public static void main(String[] args) {
		
	}

}
