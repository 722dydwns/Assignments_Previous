package home_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//MyFrame 클래스 내부에서 이벤트를 처리하도록 ActionListener도 함께 구현했다.
class MyFrame extends JFrame implements ActionListener{ 
	//필드
	private JButton plus, minus; 
	private JLabel label;
	
	//생성자 
	public MyFrame() {
		this.setSize(350, 300); //프레임 크기 지정
		this.setLocationRelativeTo(null); //윈도우 창 정 가운데에 창 띄움
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창 종료시 프로그램도 함께 종료 설정
		this.getContentPane().setLayout(null); 
		//절대위치로 설정하기 위해서 배치관리자 null로 설정하고 추가한 텀포넌트 위치와 크기 설정 직접 setBounds()로 설정했다.
		this.setTitle("자바 과제 1"); 
	
		plus = new JButton("+"); //+ 버튼 생성 
		minus = new JButton("-"); //- 버튼 생성
		label = new JLabel("10"); //출력 레이블 생성
		
		//컴포넌트 위치 크기, 설정 (절대위치로 직접 setBounds() 메소드로 설정)
		plus.setBounds(30, 170, 122, 30);
		minus.setBounds(182, 170, 122, 30);
		label.setBounds(120, 50, 90, 50); 
		label.setHorizontalAlignment(JLabel.CENTER); //레이블 가운데 정렬 시킴
		
		//+, - 버튼에 MyFrame() 클래스 속에 소속된 이벤트리스너를 등록한다.
		plus.addActionListener(this);
		minus.addActionListener(this);
		
		//프레임에 +, -, 레이블 컴포넌트를 등록한다.  
		add(plus);
		add(minus);
		add(label);

		//화면에 보이도록 설정
		this.setVisible(true);

	}
	
	//이벤트 처리
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == plus) { //plus 버튼 눌렀을 경우 
			int i;
			int num = Integer.parseInt(label.getText()); //현재의 레이블 텍스트 얻어와서, 문자열->int 변환 시켜 num변수에 저장시킴
			num++; //일단 현재의 num보다는 큰 소수여야 하므로 ++처리
		
			for(i=2; i <= num; i++) { 
				if(num%i == 0) {//num을 나누는 i 중에서 
					if(i == num) { //오직 num == i 인 경우에 한해서 (소수)
						label.setText(String.valueOf(i)); //레이블을 현재의 i값으로 세팅
						break; //찾았으면 탈출  
					}
					num++; //못찾았으면 다음 num++에 대해서 for문 처리 
				}
				
			}	
		}
		
		if(e.getSource() == minus) { //minus 버튼 눌렀을 경우 
			int i;
			int num = Integer.parseInt(label.getText());//현재의 레이블 텍스트 얻어와서, 문자열->int 변환 시켜 num변수에 저장시킴
			num--;//일단 현재의 num보다는 작은 소수여야 하므로 --처리
			
			for(i=2; i<=num; i++) { 
				
				if(num%i == 0) { //num을 나누는 i 중에서
					if(i == num) { // 오직 num == i인 경우에 한해서 (소수)
						label.setText(String.valueOf(i)); //레이블을 현재의 i값으로 세팅
						break;//찾았으면 탈출 
					}
					num--; //못찾았으면 다음 num--에 대해서 for문 처리 
				}
			}
			
		}
	}
	
}

public class home_1 { 

	public static void main(String[] args) {
		
		new MyFrame(); //main()에서 위의 기능 구현할 수 있도록 객체 생성시킴

	}

}
