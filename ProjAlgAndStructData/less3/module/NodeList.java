package ProjAlgAndStructData.less3.module;

public class NodeList {
    private Node head;
	private Node last;

	public void append(Node node) {
		if (head.getNext() == null) {
			head.setNext(node);
			node.setPre(head);
		} else {
			head.getNext().append(node);
		}	
	}
	public String toString() {
		Node curr = head;
		StringBuilder sBuilder = new StringBuilder();
		while (curr != null) {
			sBuilder.append(curr.getData()).append(curr.hasNext() ? "->" : "");
			curr = curr.getNext();
		}
		return sBuilder.toString();
	}
	public String reverse() {
		Node curr = head;
		Node newHead = null;
		Node newLast = null;
		while (curr != null) {
			Node pre = curr.getPre();
			Node next = curr.getNext();
			if (pre == null) 
                newLast = curr; 
			if (next == null) 
                newHead = curr; 
			curr.setNext (pre); 
			curr.setPre (next); 
			curr = curr.getPre (); 
		}
		head = newHead; 
		last = newLast; 
		return this.toString();
	}
    public void addData(int idElement, int data){
        Node node = new Node(data);
		if (idElement == 0) {
		    head = node;
		} else {
			head.append(node);
		}
		last = node;
    }
    public Node getHead(){
        return head;
    }
    public Node getLast(){
        return last;
    }
}
