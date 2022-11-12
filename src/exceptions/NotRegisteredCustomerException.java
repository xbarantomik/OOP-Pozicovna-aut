package exceptions;

public class NotRegisteredCustomerException extends Exception{
	

	private static final long serialVersionUID = -9030319234718976316L;

	public NotRegisteredCustomerException(String errorMessage) {
		super(errorMessage);
		System.out.println(errorMessage);
	}

}
