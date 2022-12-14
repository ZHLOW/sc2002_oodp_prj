package startupMain;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Entity class representing a booking
 * A booking object is created by Customer when they are making a movie booking
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 * 
 */

public class Booking {
	private String CineplexChoice;
	private Scanner cineplexChoice = new Scanner(System.in);

	private String CinemaChoice;
	private Scanner cinemaChoice = new Scanner(System.in);

	private String MovieChoice;
	private Scanner movieChoice = new Scanner(System.in);

	private String SeatChoice;
	private Scanner seatChoice = new Scanner(System.in);

	public Booking() {

	}
/**
 * 
 * @return cineplexchoice return the choices for the cineplex available
 * @return cinemachoice returns the cinemas available
 * @return moviechoice returns the movies in the txt
 * @return seatchoice returns the seat that is chosen
 * 
 */
	public String getCineplexChoice() {
		return this.CineplexChoice;
	}

	public String getCinemaChoice() {
		return this.CinemaChoice;
	}

	public String getMovieChoice() {
		return this.MovieChoice;
	}

	public String getSeatChoice(){
		return this.SeatChoice;
	}

	public void CineplexChoiceDisplay(Cineplex cp) {
		cp.CineplexChoiceDisplay();
	}

	public void CinemaChoiceDisplay(Cineplex cp, ArrayList<String> cinemas) {
		cp.CinemaChoiceDisplay(cinemas);
	}

	public void MovieChoiceDisplay(Cinema c, ArrayList<Movie> movies) {
		c.MovieChoiceDisplay(movies);
	}

	public void SeatingPlanDisplay(MovieDetails details){

	}

	public void ChooseACineplex() {
		System.out.print("Enter your choice: ");
		int userChoice = cineplexChoice.nextInt();
		if (userChoice == 1) {
			CineplexChoice = "Cathay Cineplexes Lot One";
		}
		else if (userChoice == 2) {
			CineplexChoice = "Cathay Cineplexes Clementi Mall";
		}
		else if (userChoice == 3) {
			CineplexChoice = "Cathay Cineplexes Jewel";
		}
		else if (userChoice == 4){
			CineplexChoice = "Quit";
		}
		else {
			ChooseACineplex();
		}
	}
/**
 * 
 * @return returnt the selected cinema
 */
	public int ChooseACinema() {
		System.out.print("Enter your choice: ");
		int userChoice = cinemaChoice.nextInt();
		if (userChoice == 1) {
			CinemaChoice = "Cinema 1";
		}
		else if (userChoice == 2) {
			CinemaChoice = "Cinema 2";
		}
		else if (userChoice == 3) {
			CinemaChoice = "Cinema 3";
		}
		else if (userChoice == 4){
			CinemaChoice = "Quit";
		}
		else {
			ChooseACineplex();
		}
		return userChoice-1;
	}
/**
 * 
 * @return userchoice returns the selected choice of movie
 */
	//TODO SCAN FROM Movies.txt
	public int ChooseAMovie(){
		System.out.print("Enter your choice: ");
		int userChoice = movieChoice.nextInt();
		ArrayList<Movie> tempMovieList = new ArrayList<Movie>();
		ArrayList<Movie> movieList = ResourceManager.getmovieList(tempMovieList);
		MovieChoice = movieList.get(userChoice-1).getTitle();
		return userChoice-1;
	}
 
	public void ChooseASeat(){
		System.out.println("Enter your choice: (comma',' separated for multiple seats)");
		SeatChoice = seatChoice.next();
		//TODO: please do some input validation here I shall assume that input validation is done
		if (SeatChoice.length() < 2){
			this.ChooseASeat();
		}
	}
}
