package z0929_1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mylab extends JFrame{ //�ڽ� ������ 
	
	public Mylab()	{ //���赵(������) 
		JPanel panel = new JPanel(); //�г� ��ü ����
		add(panel);//�� �����ӿ� �г� �߰�
		
		//����� ���̾ƿ��� ���� �������� �ʾұ� ������ default �����̤������� �����ȴ�.
		
		//������Ʈ�� ��ü ���� 
		JLabel label1= new JLabel("ȭ�� �µ��� ���ϱ��"); 
		JLabel label2 = new JLabel("���� �µ�");
		JTextField field1 = new JTextField(15);	
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("��ȯ");
		//�гο� ������Ʈ ��ü�� add
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
		
		//������(�����̳�)�� �Ӽ� ���� (ũ��. ����)
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�µ���ȯ��");
		setVisible(true);//������ â�� ���� ���� ������ ������ ������
	}

	public static void main(String[] args) {//����
		new Mylab();//������ ��ü ���� �����ָ� ���� ���谡 ���� �ۿ� 

	}

}
