package mouse;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

//�簢�� ȭ�鿡 �׸����
class Rectangle {
	int x, y, w, h;
}
class MyPanel extends JPanel{
	BufferedImage img = null;
	int img_x = 0, img_y = 0;
	Rectangle [] array = new Rectangle[100];
	int index = 0;
	
	public MyPanel() {
		this.addMouseListener(new MyMouseAdapter());
	}
		
	class MyMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO �ڵ� ������ �޼ҵ� ����
			if(index > 100) return;
			array[index] = new Rectangle();
			array[index].x = e.getX();
			array[index].y = e.getY();
			array[index].w = 50;
			array[index].h = 50;
			index++;
			repaint();
			}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Rectangle r : array) 
			if(r != null) 
				g.drawRect(r.x, r.y, r.w, r.h);
	}


}

public class MouseEventTest extends JFrame{

	public MouseEventTest() {
		setSize(300, 300);
		setTitle("���콺�� �簢�� �׸���");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MyPanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		MouseEventTest s = new MouseEventTest();

	}

}
