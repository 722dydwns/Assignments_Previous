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
	//�ʵ�
	private JPanel panel;
	private JButton cal;
	private JTextArea input;
	private JTextField output;
	
	//������ 
	public MyFrame() {
		this.setSize(350, 300); //������ ũ�� ����
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â ����� ���α׷��� �Բ� ���� ����
		this.setTitle("�ڹ� ���� 2"); 
		setLayout(new BorderLayout());
		
		panel = new JPanel();
		
		//input �ؽ�Ʈ 
		input = new JTextArea(10, 30);

		//output �ؽ�Ʈ 
		output = new JTextField(10);
		output.setEditable(false); //����ڰ� ���� �Ұ��� 
		
		//��� ��ư 
		cal = new JButton("���");
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
			String text[] = str.split(" "); //���� ���� ���ڿ� �ڸ� ��, String[] �迭�� �� ���ڿ� ����
			
			
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
