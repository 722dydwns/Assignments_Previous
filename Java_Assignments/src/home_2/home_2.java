package home_2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener{ 
	//필드
	private JPanel panel;
	private JButton cal;
	private JTextArea input;
	private JTextField output;
	
	//생성자 
	public MyFrame() {
		this.setSize(350, 300); //프레임 크기 지정
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 종료시 프로그램도 함께 종료 설정
		this.setTitle("자바 과제 2"); 
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		
		//input 텍스트 
		input = new JTextArea(10, 30);

		//output 텍스트 
		output = new JTextField(10);
		output.setEditable(false); //사용자가 편집 불가능 
		
		//계산 버튼 
		cal = new JButton("계산");
		cal.addActionListener(this);
		
		panel.add(cal);
		panel.add(output);
		
		add(input, BorderLayout.NORTH);
		add(panel, BorderLayout.CENTER);
		
		pack();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cal ) { 
			String str = input.getText();
			String text[] = str.split(" "); //공백 기준 문자열 자른 후, String[] 배열에 각 문자열 저장
			
			
			int sum = 0;
			for(int i=0; i<=text.length; i++) {
				int answer = 0;
				for(char x : text[i].toCharArray()) {
					if(x>=48 && x <= 57) { 
						answer = answer*10+(x-48);
					}	
				}
				sum += answer;
				output.setText("" + sum);
			}
		
		}
	}
}
public class home_2 {

	public static void main(String[] args) {
		
		new MyFrame();
	}

}
