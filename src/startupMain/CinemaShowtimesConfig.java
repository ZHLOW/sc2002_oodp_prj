package startupMain;

import java.util.ArrayList;
import java.util.Scanner;

public class CinemaShowtimesConfig {

//		Create/Update/Remove cinema showtimes and the movies to be shown
//		Configuring “End of Showing” date and the movie should not be listed for 
//		booking

	private static Scanner sc = new Scanner(System.in);
	
	private int choice;
	
	public void csConfigOptions() {
		
		while (true) {
			System.out.println("\nSelect an option:\n"
					 + "1. Create/Update/Remove a Cinema Showing\n"
					 + "2. View all Cinema Showings\n"
					 + "3. Return to Staff Menu\n");
			
			choice = sc.nextInt();
			
			switch (choice) {
				case 1: createUpdateRemoveCinemaShowing();
						break;
				case 2: viewCinemaShowing();
						break;
				case 3: System.out.println("\nReturning to Staff Menu...\n");
						return;
				default: System.out.println("\nInvalid Option.\n");
			}
		}
	}

	private void createUpdateRemoveCinemaShowing() {
		// TODO Append to corresponding cinema
		//select movie, change from - to date and time
		ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
		movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
		System.out.print("\nSelect movie to be showed: ");
		for (int i=1; i<=movieList.size(); i++) //To iterate through the movieListArray from the txt file
		{
			System.out.print("Movie " + i + ": ");
			movieList.get(i).viewimportantMovieDetails(); //To show only the important details of the file 
			System.out.print("\n");
		}
		int choice = sc.nextInt();
		movieList.get(choice).getCinemaShowtime();
		movieList.get(choice).setCinemaShowtime();
		ResourceManager.addmovieList(movieList); //add the movie arraylist back into txt file
	}
	
	private void viewCinemaShowing() {
		// TODO Read from Cinemas.txt
		ArrayList<Movie> movieList = new ArrayList<>(); //Create arraylist to store movie objects from txt
		movieList = ResourceManager.getmovieList(movieList); //to take objects from txt and store into movieList array
		//for Cinema 1, 2, 3
		for (int i=0; i<3; i++) {
			System.out.println("\nMovie Showings in Cinema " + (i+1) + ": ");
			for (int j=0; j<movieList.size(); j++) {
				Movie currentMovie = movieList.get(j);
				//if currently accessed movie's showing status!=End of Showing and has valid Cinema 1 showtime
				if (!currentMovie.getShowingStatus().equals("End of Showing") && !currentMovie.getCinemaShowtime()[i].equals("-")) {
					System.out.println(currentMovie.getTitle() + " " + currentMovie.getCinemaShowtime()[i]);
				}
			}
		}

	}

}
