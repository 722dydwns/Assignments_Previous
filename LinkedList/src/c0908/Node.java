package c0908;

public class Node { //��� 1���� ���� ���� ���� Ŭ���� 
	//�ʵ�(������)
	protected String name;
	protected int point;
	protected Node next;
	//������
	public Node(String n, int Kp, int Ep, int Mp) { //�� ��� 1�� ���� �� (�̸��� ����) �޾Ƽ� ����
		this.name = n;
		this.point = Kp + Ep + Mp;
		next = null;
	}
}
