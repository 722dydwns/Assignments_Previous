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


//애니메이션 작성하기 그래픽 이용 
class MyPanel extends JPanel implements ActionListener{
	
	//필드 
	private final int WIDTH = 500; //private 상수로 선언 
	private final int HEIGHT = 300;
	private final int START_X = 0; 
	private final int START_Y = 250;
	
	private BufferedImage image;
	private Timer timer;
	private int x,y;

	
	//생성자 
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
	
	
	//그리기 메소드 재정의 (JPanel 의 메소드)
	@Override
	protected void paintComponent(Graphics g) {
		// TODO 자동 생성된 메소드 스텁
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}
	//이벤트 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
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

	//MyFrame 생성자 
	public MyFrame() {
		add(new MyPanel());
		setTitle("애니메이션 테스트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,300);
		setVisible(true);
	}
	//main()
	public static void main(String[] args) {
		
	}

}
