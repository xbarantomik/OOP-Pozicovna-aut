package exceptions;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EmptyComboBoxException extends Exception{
	

	private static final long serialVersionUID = 345923122551546941L;
	public static final Logger LOGGER = Logger.getLogger(EmptyComboBoxException.class.getName());

	public EmptyComboBoxException(String errorMessage) {
		super(errorMessage);
		LOGGER.log(Level.SEVERE, errorMessage);
	}
}
