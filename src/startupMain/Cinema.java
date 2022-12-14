package startupMain;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * Entity class representing a cinema
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 * 
 */

public class Cinema extends SeatingPlan{
	private String Name;
	private String[][] plan;
	private HashMap<String, ArrayList<String>> cinema;
	private ArrayList<String> movies = new ArrayList<String>();
	
	public Cinema() {
		
	}
	/**
	 * 
	 * @param Name returns the names of the movies in the cinema
	 */
	public Cinema(String Name) {
		this.Name = Name;
		this.getMovies();
	}
	/**
	 * 
	 * @return return the movie name in the txt
	 */
	public String GetName() {
		return this.Name;
	}
	
	private void getMovies() {
		try {
			Path fileName = Path.of("Cinemas.txt");
			ArrayList<String> strList = (ArrayList<String>) Files.readAllLines(fileName);
			for (String line : strList) {
				String[] info = line.split("@");
				if (info[0].equals(this.Name)) {
					
					for (int i = 1; i < info.length ; i++) {
						//System.out.println(info[i]);
						movies.add(info[i]);
					}
				}
			}
		}
		catch (Exception err){
			System.err.println(err);
		}
	}
	/**
	 * 
	 * @return returns the string of movies in the cinema
	 */
	public ArrayList<String> GetMoviesOfCinema() {
		return this.movies;
	}
	
	public void PlanDisplay() {
		System.out.println(this.Name + "Seats: (0) is available, (x) is occupied.");
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j ++) {
				System.out.print(plan[i][j]);
			}
			System.out.println();
		}
	}
	
	public void MovieChoiceDisplay(ArrayList<Movie> movies) {
		System.out.println("Available movies: ");
		int counter = 1;
		for (Movie movie : movies) {
			System.out.println(counter + ". " + movie.getTitle());
			counter += 1;
		}
		System.out.println(counter + ". Exit");
	}

	public void DisplaySeats(String title){

	}
}
