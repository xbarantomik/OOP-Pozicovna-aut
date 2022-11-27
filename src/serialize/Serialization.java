package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serialization{

	public static final Logger LOGGER = Logger.getLogger(Serialization.class.getName());

	public static < E > void Update(ArrayList< E > array, String file) throws Exception {
		try (
				FileOutputStream fileOut = new FileOutputStream(file);
				ObjectOutputStream out = new ObjectOutputStream(fileOut);
		) {
			out.writeObject(array);
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Update Serialization\n", e);
		}
	}
}
