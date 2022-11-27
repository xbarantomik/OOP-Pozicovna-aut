package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CloseNewCustomerStageException  extends Exception{

	private static final long serialVersionUID = 7960956199365817363L;
	public static final Logger LOGGER = Logger.getLogger(CloseNewCustomerStageException.class.getName());

	public CloseNewCustomerStageException(String errorMessage) {
		super(errorMessage);
		LOGGER.log(Level.SEVERE, errorMessage);
	}
}
