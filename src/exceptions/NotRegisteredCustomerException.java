package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NotRegisteredCustomerException extends Exception{
	

	private static final long serialVersionUID = -9030319234718976316L;
	public static final Logger LOGGER = Logger.getLogger(NotRegisteredCustomerException.class.getName());

	public NotRegisteredCustomerException(String errorMessage) {
		super(errorMessage);
		LOGGER.log(Level.SEVERE, errorMessage);
	}
}
