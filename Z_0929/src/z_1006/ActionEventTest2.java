package z_1006;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


class MyFrame extends JFrame{
		private JButton button;
		private JLabel label;
		private int count = 1;
		
		public MyFrame() {
			this.setSize(300,200);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setTitle("이벤트 예제");
			JPanel panel = new JPanel();
			button = new JButton("버튼을 누르시오");
			label = new JLabel("아직 버튼이 눌리지 않았습니다.");
			button.addActionListener(new MyListener());
			panel.add(button);
			panel.add(label);
			this.add(panel);
			this.setVisible(true);
		}
		
		private class MyListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button) { //버튼이 눌리면 
					label.setText(count + "번 버튼이 눌러졌습니다.");
					count++;
			}
		}
	}
		
}

public class ActionEventTest2 {

	public static void main(String[] args) {
		
		MyFrame t = new MyFrame();
	}

}

