package dayFour;

abstract class InputHandler{
	public abstract void handle(NegativeNumberException exception);
	public abstract void handle(OutOfRangeException exception); 
}

class InputHandlerImpl extends InputHandler{
	@Override
	public void handle(NegativeNumberException exception) {
		System.out.println("Enter a positive number...");
	}
	@Override
	public void handle(OutOfRangeException exception) {
		System.out.println("Enter a number between 1 and 100...");
	}
}

public abstract class InputException extends Exception{
	public InputException(String messageValue) {
		super(messageValue);
	}
	public abstract void visit();
}

class NegativeNumberException extends InputException{
	String messageValue;
	public NegativeNumberException(String messageValue) {
		super(messageValue);
		this.messageValue=messageValue;
	}
	@Override
	public String toString() {
		return messageValue;
	}	
	@Override
	public void visit() {
		new InputHandlerImpl().handle(this);
	}
}

class OutOfRangeException extends InputException{
	String messageValue;
	public OutOfRangeException(String messageValue) {
		super(messageValue);
		this.messageValue=messageValue;
	}
	@Override
	public String toString() {
		return messageValue;
	}	
	@Override
	public void visit() {
		new InputHandlerImpl().handle(this);
	}
}