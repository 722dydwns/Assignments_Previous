package realLink;

public class Node {

	//�ʵ�
	private String name;
	private int pointSum;
	private Node next;
	
	//������
	public Node(String n, int pointMath, int pointKorean, int pointEnglish) {
		this.name = n;
		this.pointSum = pointEnglish + pointKorean + pointMath;
		next = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPointSum() {
		return pointSum;
	}

	public void setPointSum(int pointSum) {
		this.pointSum = pointSum;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
}
