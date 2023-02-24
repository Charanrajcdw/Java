package dayThree;

interface Stack{
	public void push(int n);
	public int pop();
	public int peek();
	public void display();
}

class StackClass implements Stack{
	int[] stack;
	int size;
	int top;
	
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

class FixedStack extends StackClass{
	public FixedStack() {
		System.out.println("Fixed stack object created...");
		stack=new int[3];
		size=3;
		top=-1;
	}
}

class DynamicStack extends StackClass{
	public DynamicStack(int size) {
		System.out.println("Dynamic stack object created...");
		stack=new int[size];
		this.size=size;
		top=-1;
	}
}

public class StackMain {
	public static void main(String[] args) {
		FixedStack fstack=new FixedStack();
		fstack.push(1);
		fstack.push(2);
		fstack.push(3);
		fstack.push(4);
		fstack.display();
		System.out.println("The top element is "+fstack.peek());
		System.out.println();
		DynamicStack dstack=new DynamicStack(3);
		dstack.push(1);
		dstack.push(2);
		dstack.push(3);
		dstack.push(4);
		dstack.display();
		System.out.println("The top element is "+dstack.peek());
	}	
}
