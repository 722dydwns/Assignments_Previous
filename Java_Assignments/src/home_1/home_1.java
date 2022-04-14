package home_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//MyFrame Ŭ���� ���ο��� �̺�Ʈ�� ó���ϵ��� ActionListener�� �Բ� �����ߴ�.
class MyFrame extends JFrame implements ActionListener{ 
	//�ʵ�
	private JButton plus, minus; 
	private JLabel label;
	
	//������ 
	public MyFrame() {
		this.setSize(350, 300); //������ ũ�� ����
		this.setLocationRelativeTo(null); //������ â �� ����� â ���
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â ����� ���α׷��� �Բ� ���� ����
		this.getContentPane().setLayout(null); 
		//������ġ�� �����ϱ� ���ؼ� ��ġ������ null�� �����ϰ� �߰��� ������Ʈ ��ġ�� ũ�� ���� ���� setBounds()�� �����ߴ�.
		this.setTitle("�ڹ� ���� 1"); 
	
		plus = new JButton("+"); //+ ��ư ���� 
		minus = new JButton("-"); //- ��ư ����
		label = new JLabel("10"); //��� ���̺� ����
		
		//������Ʈ ��ġ ũ��, ���� (������ġ�� ���� setBounds() �޼ҵ�� ����)
		plus.setBounds(30, 170, 122, 30);
		minus.setBounds(182, 170, 122, 30);
		label.setBounds(120, 50, 90, 50); 
		label.setHorizontalAlignment(JLabel.CENTER); //���̺� ��� ���� ��Ŵ
		
		//+, - ��ư�� MyFrame() Ŭ���� �ӿ� �Ҽӵ� �̺�Ʈ�����ʸ� ����Ѵ�.
		plus.addActionListener(this);
		minus.addActionListener(this);
		
		//�����ӿ� +, -, ���̺� ������Ʈ�� ����Ѵ�.  
		add(plus);
		add(minus);
		add(label);

		//ȭ�鿡 ���̵��� ����
		this.setVisible(true);

	}
	
	//�̺�Ʈ ó��
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == plus) { //plus ��ư ������ ��� 
			int i;
			int num = Integer.parseInt(label.getText()); //������ ���̺� �ؽ�Ʈ ���ͼ�, ���ڿ�->int ��ȯ ���� num������ �����Ŵ
			num++; //�ϴ� ������ num���ٴ� ū �Ҽ����� �ϹǷ� ++ó��
		
			for(i=2; i <= num; i++) { 
				if(num%i == 0) {//num�� ������ i �߿��� 
					if(i == num) { //���� num == i �� ��쿡 ���ؼ� (�Ҽ�)
						label.setText(String.valueOf(i)); //���̺��� ������ i������ ����
						break; //ã������ Ż��  
					}
					num++; //��ã������ ���� num++�� ���ؼ� for�� ó�� 
				}
				
			}	
		}
		
		if(e.getSource() == minus) { //minus ��ư ������ ��� 
			int i;
			int num = Integer.parseInt(label.getText());//������ ���̺� �ؽ�Ʈ ���ͼ�, ���ڿ�->int ��ȯ ���� num������ �����Ŵ
			num--;//�ϴ� ������ num���ٴ� ���� �Ҽ����� �ϹǷ� --ó��
			
			for(i=2; i<=num; i++) { 
				
				if(num%i == 0) { //num�� ������ i �߿���
					if(i == num) { // ���� num == i�� ��쿡 ���ؼ� (�Ҽ�)
						label.setText(String.valueOf(i)); //���̺��� ������ i������ ����
						break;//ã������ Ż�� 
					}
					num--; //��ã������ ���� num--�� ���ؼ� for�� ó�� 
				}
			}
			
		}
	}
	
}

public class home_1 { 

	public static void main(String[] args) {
		
		new MyFrame(); //main()���� ���� ��� ������ �� �ֵ��� ��ü ������Ŵ

	}

}
