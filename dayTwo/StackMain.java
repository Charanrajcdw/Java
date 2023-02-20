package dayTwo;

class Stack{
	int[] stack;
	int size;
	int top;
	
	public Stack(int size) {
		stack=new int[size];
		this.size=size;
		top=-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}
	
	public boolean isFull() {
		return top==size-1;
	}
	
	public void push(int n) {
		if(isFull()) {
			System.out.println("Stack overflow!!!");
			return;
		}
		stack[++top]=n;
		System.out.println(n+" pushed into stack");
	}
	
	public int pop() {
		if(isEmpty()) {
			System.out.println("Stack underflow!!!");
			return Integer.MIN_VALUE;
		}
		return stack[top--];
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("No elements in stack!!!");
			return Integer.MIN_VALUE;
		}
		return stack[top];
	}
	
	public void display() {
		if(isEmpty()) {
			System.out.println("No elements in stack!!!");
			return;
		}
		System.out.println("The elements in stack are");
		for(int i=top;i>=0;i--)
			System.out.println(stack[i]);
	}
}

public class StackMain {
	public static void main(String[] args) {
		Stack stack=new Stack(3);
		int val;
		val=stack.pop();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.display();
		System.out.println("The top element is "+stack.peek());
		val=stack.pop();
		System.out.println("The popped element is "+val);
		val=stack.pop();
		System.out.println("The popped element is "+val);
		val=stack.pop();
		System.out.println("The popped element is "+val);
		stack.display();
	}	
}
