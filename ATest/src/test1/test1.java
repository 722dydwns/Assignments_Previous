package test1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener { 
				//JFrame ��Ӱ� ActionListener�� ������ MyFrame() Ŭ������ ����

	//�ʵ�
	private JButton zero, one, clear, change; 
	private JTextField text;
	private JPanel panel;
	
	
	//������
	public MyFrame() {
		setSize(350, 300); //������ ũ�� ����
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�ڹ� ����");
		setLayout(new BorderLayout()); 
		
		panel = new JPanel(); //�г� ��ü ���� 
		
		
		//�Է� ��µ� text ����
		text = new JTextField(20);
		text.setEditable(false);//����ڰ� ���� ���� �Ұ���
		
		//��ȯ ��ư ���� 
		change = new JButton("��ȯ");
		change.addActionListener(this); //�̺�Ʈ ���� 
		
		//0 ��ư ���� 
		zero = new JButton("0");
		zero.addActionListener(this);
		
		//1��ư ���� 
		one = new JButton("1");
		one.addActionListener(this);
		
		//clear ��ư ����
		clear = new JButton("clear");
		clear.addActionListener(this);
		
		panel.add(text);
		panel.add(change);
		panel.add(zero);
		panel.add(one);
		panel.add(clear);
		
		add(panel);
		

		setVisible(true);
	}
	
	
	//(�̺�Ʈ ����) ActionListener�� �޼ҵ� ������
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �ڵ� ������ �޼ҵ� ����
		if(e.getSource() == zero) {// 0 ������ 
			String a = text.getText(); //������ text���� String���� �����صΰ�
			
			text.setText("" + a + "" + 0 ); //���� text �ڿ� 0 �� �̾����
		}
		
		if(e.getSource() == one) { // 1 ������
			String a = text.getText(); //������ text���� String���� �����صΰ�
			
			text.setText("" + a + "" + 1); //���� text �ڿ� 1 ���̱�
		}
		
		if(e.getSource() == clear) { //clear ��ư ������
			text.setText(""); //textâ ����α�
		}
		
		if(e.getSource() == change) { //��ȯ ��ư ������ 
			
			String tmp = text.getText(); //�ԷµǾ��ִ� text�� String���� ���� ��,
			int num = Integer.parseInt(tmp, 2); //Integer.parseInt(string, 2)�� �̿� -> 
									//2������ �Էµ� string������ 10������ �ٲ��ش�.
			
			text.setText("" + num); //��ȯ�� 10������ �ٽ� text�� �������ش�.
		}
	
	}
		
	
}

public class test1 {

	public static void main(String[] args) {
		// TODO �ڵ� ������ �޼ҵ� ����
		
		new MyFrame(); 

	}

}
