package serialize;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization{
	
	public static < E > void Update(ArrayList< E > array, String file) throws Exception{
		try {
			FileOutputStream fileOut = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			 
			out.writeObject(array); 
			out.close();
			fileOut.close();

		} catch(IOException e) {
			System.out.println("Update Serialization\n");
			e.printStackTrace();
		} 
	}
}
