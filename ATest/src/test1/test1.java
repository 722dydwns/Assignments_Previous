package test1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class MyFrame extends JFrame implements ActionListener { 
				//JFrame 상속과 ActionListener를 구현한 MyFrame() 클래스로 구현

	//필드
	private JButton zero, one, clear, change; 
	private JTextField text;
	private JPanel panel;
	
	
	//생성자
	public MyFrame() {
		setSize(350, 300); //프레임 크기 설정
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("자바 시험");
		setLayout(new BorderLayout()); 
		
		panel = new JPanel(); //패널 객체 생성 
		
		
		//입력 출력될 text 설정
		text = new JTextField(20);
		text.setEditable(false);//사용자가 직접 편집 불가능
		
		//변환 버튼 설정 
		change = new JButton("변환");
		change.addActionListener(this); //이벤트 연결 
		
		//0 버튼 설정 
		zero = new JButton("0");
		zero.addActionListener(this);
		
		//1버튼 설정 
		one = new JButton("1");
		one.addActionListener(this);
		
		//clear 버튼 설정
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
	
	
	//(이벤트 구현) ActionListener의 메소드 재정의
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 자동 생성된 메소드 스텁
		if(e.getSource() == zero) {// 0 눌리면 
			String a = text.getText(); //현재의 text얻어와 String으로 저장해두고
			
			text.setText("" + a + "" + 0 ); //기존 text 뒤에 0 을 이어붙임
		}
		
		if(e.getSource() == one) { // 1 눌리면
			String a = text.getText(); //현재의 text얻어와 String으로 저장해두고
			
			text.setText("" + a + "" + 1); //기존 text 뒤에 1 붙이기
		}
		
		if(e.getSource() == clear) { //clear 버튼 눌리면
			text.setText(""); //text창 비워두기
		}
		
		if(e.getSource() == change) { //변환 버튼 누르면 
			
			String tmp = text.getText(); //입력되어있는 text를 String으로 받은 뒤,
			int num = Integer.parseInt(tmp, 2); //Integer.parseInt(string, 2)를 이용 -> 
									//2진수로 입력된 string변수를 10진수로 바꿔준다.
			
			text.setText("" + num); //변환된 10진수를 다시 text에 세팅해준다.
		}
	
	}
		
	
}

public class test1 {

	public static void main(String[] args) {
		// TODO 자동 생성된 메소드 스텁
		
		new MyFrame(); 

	}

}
