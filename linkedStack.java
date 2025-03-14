 
package datastructure_programmingassignment;
 
public class linkedStack<T> implements Stack<T> {
	private Node<T> top;

	public linkedStack() {
		top = null;
	}
        
	public boolean empty(){
		return top == null;
	}
	
	
	public void push(T e){
		Node<T> tmp = new Node<T>(e);
		tmp.next = top;
		top = tmp;
	}
	public T pop(){
		T e = top.data;
		top = top.next;
		return e;
	}

    @Override
    public boolean full() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



public class Node<T>{
	public T data;
	public Node<T> next;
        
	public Node() {
		data=null;
		next=null;
	}
	public Node(T val) {
		data=val;
		next=null;
	}
} 



} 