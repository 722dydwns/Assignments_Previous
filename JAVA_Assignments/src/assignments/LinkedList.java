package assignments;

public class LinkedList {
    //필드
    private Node head; 
    //생성자
    public LinkedList() {
        head = null;
    } 
    //연결리스트 속 head노드 반환 getter 메소드 
    public Node getHead() {
        return head;
    }
   //-----<기능 추가 과제>-------  
    //기능 추가(1)_성적반환: 학생 이름 받아서 해당 학생의 성적 반환하는 메소드 
    public int getPoint(String name) {
        Node currentNode = head;
        
        int Point = -1; // 반환할 성적 변수 -1 초기화
        
        if (currentNode != null) { 
            while (currentNode != null) { 
                if (currentNode.getName().equals(name)) {
                    Point = currentNode.getPointSum();
                    break;
                }
               currentNode = currentNode.getNext();  						
            }
        }
        return Point;
    }
    //기능 추가(2)_삽입: 학생 성적 순으로 삽입 메소드 
    public void insertByPoint(Node node) { 
      
        Node currentNode = this.head; 
        if (currentNode != null) { 
            while (currentNode != null) { 
                if (currentNode.getPointSum() <= node.getPointSum()) { 
                    if (currentNode.equals(this.head)) {
                        this.head = node; 
                        node.setNext(currentNode); 
                    }else { 	
                        int position = getIndex(currentNode.getPointSum()); 
                        Node prevNodeNotHead = this.head;  
                        for (int i = 0; i < position - 1; i++) { 
                            prevNodeNotHead = prevNodeNotHead.getNext(); 
                        }
                        prevNodeNotHead.setNext(node); //앞 연결 
                        node.setNext(currentNode);//뒤 연결 
                    }
                    break;
                }                
                currentNode = currentNode.getNext();//next 따라 다음 노드로 이동  
            }
            //while문 탈출 : 삽입할 node 성적합이 가장 작아 null되어 탈출 
            if (currentNode == null) { 
                currentNode = findLastNode(); //currentNode <- 마지막 노드 지칭
                currentNode.setNext(node); //currentNode.next = 삽입할 node 연결 
            }
        }    
       else { 
            insertLast(node); //현재 node를 마지막 노드로 삽입 
        }
    }
    //기능 추가(3)_삭제: 학생 이름 입력받은 후 해당 학생 노드 삭제 메소드
    public int deleteNode(String name) {
        if (this.head.getName().equals(name)) { 
            this.head = this.head.getNext();  
            return 0; //종료 
        }
        Node currentNode = this.head;
        int deletedIndex = -1; //삭제 위치 지정 변수 -1 초기화
        if (currentNode != null) { 
            while (currentNode != null) { 
                if (currentNode.getName().equals(name)) {
                    deletedIndex = getIndex(name);
                    Node prevNode = this.head; 
                    for (int i = 0; i < deletedIndex - 1; i++) { 
                        prevNode = prevNode.getNext(); 
                    }
                    //for문 탈출 후, 삭제 직전 위치 지칭 중인 prevNode 
                    prevNode.setNext(currentNode.getNext());        
                    break;
                }
                currentNode = currentNode.getNext();
            }
        }
        return deletedIndex; 
    }
    //마지막 노드 삽입 위치 탐색 메소드
    public Node findLastNode() {
        Node n = head; //head부터 순회할 노드 n  
        if (n != null) { 
            while (n.getNext() != null) {  
                n = n.getNext();  
            }
        }
        return n;
    }
    //중간 노드 삽입: 점수 기준으로 삽입 위치 직전 노드 탐색 메소드 
    public Node findPrevNode(int point) { 
        if (head.getPointSum() < point)  return null;
        
        Node n = head, prev = null;
        while (n != null) {  
            if (n.getPointSum() < point) {
                prev = n; 
                n = n.getNext();
            }
        }
        return prev; 
    }





   //마지막 노드로 삽입 메소드 
    public void insertLast(Node n) { 
        if (head == null)  head = n; 
        else {
            Node node = findLastNode(); 
            node.setNext(n); 
        }
    }
   //중간 노드로 삽입 메소드 
    public void insertMiddle(Node n) { 
        Node node = findPrevNode(n.getPointSum()); 
        if (node == null) {  
            n.setNext(head); 
            head = n; 
        }else { 
            n.setNext(node.getNext()); //뒤 연결 
            node.setNext(n);//앞 연결 
        }
    }
    //"point값 기준" -> 위치 반환 메소드 
    public int getIndex(int point) { 
        Node currentNode = this.head; 
        int counter = 0; //위치 카운터 변수
        while (currentNode != null) { 
            if (currentNode.getPointSum() == point) { 
                break; 
            }
            currentNode = currentNode.getNext();
            counter++; 
        }
        return counter; //성적합 기준으로 찾은 노드 인덱스 위치 반환 
    }
    //"name값 기준" -> 위치 반환 메소드 
    public int getIndex(String name) {
        Node currentNode = this.head; 
        int counter = 0; //위치 카운터 변수
        while (currentNode != null) {  
            if (currentNode.getName().equals(name)) { 
                break;
            }
            currentNode = currentNode.getNext();
            counter++; 
        }
        return counter; //이름값 기준으로 찾은 노드 인덱스 위치 반환
    } 
   //전체 순회하며 리스트 전체 출력 메소드 
    public void showAll() {
        if (head == null) System.out.println("연결리스트 내부에 node 객체 없는 상태");
        else {
            Node n = head; 
            do {
                System.out.print("(" + n.getName() + "," + n.getPointSum() + ") -> ");
                n = n.getNext();
            }while (n != null); 
        }
    }
      


    //실행 main메소드 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertByPoint(new Node("김", 95, 38, 79));
        list.insertByPoint(new Node("서", 91, 90, 43));
        list.insertByPoint(new Node("이", 88, 84, 99));
        list.insertByPoint(new Node("황", 62, 49, 82));
        list.insertByPoint(new Node("주", 26, 40, 65));
        list.insertByPoint(new Node("정", 83, 93, 95));
        list.insertByPoint(new Node("구", 69, 47, 81));
        list.insertByPoint(new Node("강", 5, 84, 13));
        list.insertByPoint(new Node("선", 27, 54, 28));
        list.insertByPoint(new Node("우", 45, 4, 13));
        
        System.out.println("\n\n----삽입 완료된 상태 출력----\n\n");
        list.showAll();
        
        System.out.println("\n\n '서 학생' 삭제 후 출력 ");
        list.deleteNode("서");
        System.out.println("\n");
        list.showAll();
        
        System.out.println("\n\n '이 학생' 삭제 후 출력 ");
        list.deleteNode("이");
        System.out.println("\n");
        list.showAll();
        
        System.out.println("\n\n '김 학생' 삭제 후 출력 ");
        list.deleteNode("김");
        System.out.println("\n");
        list.showAll();     
    }

}
