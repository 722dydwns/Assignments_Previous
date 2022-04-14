package c0908;

public class LinkedList {  //��� ����� �����ڷᱸ���� ���� ���� ���� Ŭ���� 
	//�ʵ�
	Node head;
	//������
	public LinkedList() {
		head = null;
	}
	//Ž�� ��� �޼ҵ� 
	public Node findLastNode() {
		//if (head == null) return null; //ù ��尡 null�̸� ���� �����
		Node n= head; //��Ʈ ����Ÿ�Ժ����� head�� ���Ƽ�
		while (n.next != null) {//��ü ��ȸ (������ ��� ã��������)
			n = n.next;//���� ��� �̵� 
		}
		return n; //������ ��� ã�Ƽ� ��ȯ
	}
	
	//�߰� ���� ��ġ: ���� ��带 ã�� Ž�� �޼ҵ� 
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
	
	//������ ���� ��� �޼ҵ� 
	public void insertLast (Node n) {
		if (head == null) head = n;
		else {
			Node node = findLastNode();
			node.next = n;
		}
	}
	
	//�߰� ���� �޼ҵ�
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
	
	
	//��ü ��ȸ�Ͽ� ����ϴ� �޼ҵ�
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
	
	
	//���θ޼ҵ�
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.insertLast(new Node("Kim", 90,30,20)); //140
		list.insertLast(new Node("OK", 100,20,100)); //220
		list.insertLast(new Node("lee", 80, 40, 30)); //150
		System.out.println("\n\n----���� �Ϸ�� ���� ���----\n\n");
		list.showAll();

		

	}

}
