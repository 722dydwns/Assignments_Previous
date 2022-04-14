package z0929_1;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mylab extends JFrame{ //자식 프레임 
	
	public Mylab()	{ //설계도(생성자) 
		JPanel panel = new JPanel(); //패널 객체 생성
		add(panel);//현 프레임에 패널 추가
		
		//현재는 레이아웃을 따로 설정하지 않았기 때문에 default 레이이ㅏ웃으로 설정된다.
		
		//컴포넌트들 객체 생성 
		JLabel label1= new JLabel("화씨 온도는 얼마일까요"); 
		JLabel label2 = new JLabel("섭씨 온도");
		JTextField field1 = new JTextField(15);	
		JTextField field2 = new JTextField(15);
		JButton button = new JButton("반환");
		//패널에 컴포넌트 객체들 add
		panel.add(label1);
		panel.add(field1);
		panel.add(label2);
		panel.add(field2);
		panel.add(button);
		
		//프레임(컨테이너)의 속성 설정 (크기. 설정)
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("온도변환기");
		setVisible(true);//윈도우 창에 위의 내용 설정된 프레임 보여줌
	}

	public static void main(String[] args) {//메인
		new Mylab();//프레임 객체 생성 시켜주면 위의 설계가 실질 작용 

	}

}
