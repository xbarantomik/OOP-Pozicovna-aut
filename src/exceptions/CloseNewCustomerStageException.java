package exceptions;

public class CloseNewCustomerStageException  extends Exception{


	private static final long serialVersionUID = 7960956199365817363L;

	public CloseNewCustomerStageException(String errorMessage) {
		super(errorMessage);
		System.out.println(errorMessage);
	}
}
