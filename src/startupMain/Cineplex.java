package startupMain;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Entity class representing a cineplex
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class Cineplex{
	private String Name;
	HashMap<String, ArrayList<String>> cineplex = new HashMap<String, ArrayList<String>>();
	public Cineplex() {
		this.InitialiseCineplexes();
	}
	
	public String getName() {
		return this.Name;
	}
	/**
	 * 
	 * @param Name name of the cinemas in cineplex
	 * @return returns the name of cinemas
	 */
	public ArrayList<String> GetCinemasOfCineplex(String Name){
		return this.cineplex.get(Name);
	}
	
	private void InitialiseCineplexes() {
		try {
			Path fileName = Path.of("Cineplexes.txt");
			ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(fileName);
			for (String line : strList) {
//				System.out.println(line);
				String[] info = line.split("@");
//				for (String temp : info) {
//					System.out.println(temp);
//				}
				ArrayList<String> cinemas = new ArrayList<String>();
				for (int i = 1; i < info.length ; i++) {
					cinemas.add(info[i]);
				}
				cineplex.put(info[0], cinemas);
			}
		}
		catch (Exception err){
			System.err.println(err);
		}
	}
	
	public void CineplexChoiceDisplay() {
		System.out.println("Choose a cineplex near you");
		int counter = 1;
		for (Map.Entry m : this.cineplex.entrySet()) {
			System.out.println(counter + ". " + m.getKey() + " cineplex");
			counter += 1;
		}
		System.out.println("4. Exit");
	}
	
	public void CinemaChoiceDisplay(ArrayList<String> cinemas) {
		System.out.println("Cinemas in cineplex: ");
		int counter = 1;
		for (String name : cinemas) {
			System.out.println(counter + ". " + name);
			counter += 1;
		}
		System.out.println(counter + ". Exit");
	}
}
