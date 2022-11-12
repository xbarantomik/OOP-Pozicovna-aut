package exceptions;

public class EmptyComboBoxException extends Exception{
	

	private static final long serialVersionUID = 345923122551546941L;

	public EmptyComboBoxException(String errorMessage) {
		super(errorMessage);
		System.out.println(errorMessage);
	}
	
}
