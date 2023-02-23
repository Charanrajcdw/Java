package dayFour;

abstract class InputHandler{
	public abstract void handle(NegativeNumberException nne);
	public abstract void handle(OutOfRangeException ore); 
}

class InputHandlerImpl extends InputHandler{
	@Override
	public void handle(NegativeNumberException nne) {
		System.out.println("Enter a positive number...");
	}
	@Override
	public void handle(OutOfRangeException ore) {
		System.out.println("Enter a number between 1 and 100...");
	}
}

public abstract class InputException extends Exception{
	public InputException(String msg) {
		super(msg);
	}
	public abstract void visit();
}

class NegativeNumberException extends InputException{
	String msg;
	public NegativeNumberException(String msg) {
		super(msg);
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		new InputHandlerImpl().handle(this);
	}
}

class OutOfRangeException extends InputException{
	String msg;
	public OutOfRangeException(String msg) {
		super(msg);
		this.msg=msg;
	}
	@Override
	public String toString() {
		return msg;
	}	
	@Override
	public void visit() {
		new InputHandlerImpl().handle(this);
	}
}