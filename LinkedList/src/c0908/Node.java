package c0908;

public class Node { //노드 1개의 내부 구조 구현 클래스 
	//필드(데이터)
	protected String name;
	protected int point;
	protected Node next;
	//생성자
	public Node(String n, int Kp, int Ep, int Mp) { //긱 노드 1개 생성 시 (이름과 성적) 받아서 생성
		this.name = n;
		this.point = Kp + Ep + Mp;
		next = null;
	}
}
