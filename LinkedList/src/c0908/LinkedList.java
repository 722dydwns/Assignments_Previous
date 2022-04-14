package c0908;

public class LinkedList {  //노드 저장될 연결자료구조의 내부 구조 구현 클래스 
	//필드
	Node head;
	//생성자
	public LinkedList() {
		head = null;
	}
	//탐색 기능 메소드 
	public Node findLastNode() {
		//if (head == null) return null; //첫 노드가 null이면 내부 빈상태
		Node n= head; //노트 참조타입변수를 head에 놓아서
		while (n.next != null) {//전체 순회 (마지막 노드 찾을때까지)
			n = n.next;//다음 노드 이동 
		}
		return n; //마지막 노드 찾아서 반환
	}
	
	//중간 삽입 위치: 직전 노드를 찾는 탐색 메소드 
	public Node findPrevNode(int point) {
		if (head.point < point) return null;
		Node n = head, prev = null;
		while (n != null) {
			if (n.point < point) {
			    prev = n;
			    n = n.next;
			}
		}
		return prev;
	}
	
	//마지막 삽입 기능 메소드 
	public void insertLast (Node n) {
		if (head == null) head = n;
		else {
			Node node = findLastNode();
			node.next = n;
		}
	}
	
	//중간 삽입 메소드
	public void insertMiddle(Node n) {
		Node node = findPrevNode(n.point);
		if (node == null) {
			n.next = head;
			head = n;
		}
		else {
			n.next = node.next;
			node.next = n;
		}
	}
	
	
	//전체 순회하여 출력하는 메소드
	public void showAll() {
		if(head == null) System.out.println("There is no node in Linked List;");
		else {
			Node n = head;
			do {
				System.out.print( "(" + n.name + "," + n.point + ") -> " );
				n = n.next;
			}while (n != null);
		}
	}	
	//
	
	
	//메인메소드
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertLast(new Node("Kim", 90,30,20)); //140
		list.insertLast(new Node("OK", 100,20,100)); //220
		list.insertLast(new Node("lee", 80, 40, 30)); //150
		System.out.println("\n\n----삽입 완료된 상태 출력----\n\n");
		list.showAll();

		

	}

}
