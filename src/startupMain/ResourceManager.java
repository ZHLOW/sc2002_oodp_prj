package startupMain;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ResourceManager {
	
	public static void save(Serializable data, String fileName) throws Exception
	{
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName), StandardOpenOption.APPEND))) {
	oos.writeObject(data);
	oos.close();
}
	}
	
	public static Object load(String fileName) throws Exception{
		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get(fileName)))) {
			return ois.readObject();
		}
	}
}