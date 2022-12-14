package startupMain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Entity class representing a movie
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class Movie implements Serializable{

	/**
	 * To implement Serializable
	 */
	private static final long serialVersionUID = -4611176189600089207L;
	
	private static Scanner sc = new Scanner(System.in);
	
	private String title;
	private String type; //e.g. Blockbuster PG13
	private ArrayList<String>[] cinemaShowtime; //array of arrayLists -> [ [cinema 1:...], [cinema 2:...], [cinema 3:...] ]
	private int showingStatus;
	private String synopsis;
	private String director;
	private ArrayList<String> cast;
	private String overallReviewerRating; //1 to 5
	private ArrayList<String[]> reviewsAndRatings; //stored as (String review, String rating) as one array element
	private int ticketSales;
	
	public Movie() {
		title = "";
		type = "";
		cinemaShowtime = new ArrayList[3];// {cinemaDateTime1, cinemaDateTime2, cinemaDateTime3};
		cinemaShowtime[0] = new ArrayList<String>();
		cinemaShowtime[1] = new ArrayList<String>();
		cinemaShowtime[2] = new ArrayList<String>();
		showingStatus = 0;
		synopsis = "";
		director = "";
		cast = new ArrayList<String>();
		overallReviewerRating = "";
		reviewsAndRatings = new ArrayList<String[]>();
		ticketSales = 0;
	}

	//Collection of all getter methods to display movie attributes
	public void viewallMovieDetails() {
		System.out.println("\nMovie Title: " + this.getTitle());
		System.out.println("Movie Type: " + this.getType());
		printCinemaShowtime();
		System.out.println("Showing Status: " + this.getShowingStatus());
		System.out.println("Movie Synopsis: " + this.getSynopsis());
		System.out.println("Movie Director: " + this.getDirector());
		System.out.println("Movie Casts: " + this.getCast());
		System.out.println("Movie Overall Rating: " + this.getOverallReviewerRating());
		printReviewsAndRatings();
		System.out.println("Ticket Sales: " + this.getTicketSales());
	}
	
	public void viewimportantMovieDetails()
	{
		System.out.print("Title: " + this.getTitle() + " | Showing Status: " + this.getShowingStatus() + 
				" | Movie Overall Rating: " + this.getOverallReviewerRating() + " | Ticket Sales: " + this.getTicketSales());
	}
	
	//Collection of all setter methods to create movie except overallReviewerRating and ticketSales
	public void createMovie() {
		setTitle();
		setType();
		setCinemaShowtime();
		setShowingStatus();
		setSynopsis();
		setDirector();
		setCast();
		setOverallReviewerRating();
	}
	/**
	 * 
	 * @return return title
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle() {
		System.out.print("\nEnter Movie Title: ");
		title = sc.nextLine();
	}
	/**
	 * 
	 * @return return type of movie
	 */
	public String getType() {
		return type;
	}

	public void setType() {
		System.out.print("\nEnter Movie Type (e.g. Blockbuster PG13): ");
		type = sc.nextLine();
	}
	
	public void printCinemaShowtime() {
		System.out.print("Cinema Showtimes: ");
		for (int i=0; i<3; i++) {
			if (!cinemaShowtime[i].isEmpty()) {
				System.out.print("Cinema " + (i+1) + ": ");
				for (int j=0; j<cinemaShowtime[i].size(); j++) {
					if (cinemaShowtime[i].get(j) != "") {
						System.out.print(cinemaShowtime[i].get(j) + "||");
					}
				}
			}
		}
		System.out.print("\n");
	}
	/**
	 * 
	 * @return display cinema showtime
	 */
	public ArrayList<String>[] getCinemaShowtime() {
		return cinemaShowtime;
	}

	public void setCinemaShowtime() {
		while (true) {
			System.out.println("\nChoose option:\n" +
							 "1. Create a showtime\n" +
							 "2. Remove a showtime\n" +
							 "3. Return\n");
			int createOrRemove = sc.nextInt();
			if (createOrRemove == 3) break;
			System.out.println("\nChoose Cinema Number:\n" +
							 "1. Cinema 1\n" + 
							 "2. Cinema 2\n" +
							 "3. Cinema 3\n" +
							 "4. Return\n");
			int choice = sc.nextInt();
			if (choice == 4) break;
			sc.nextLine(); //fix sc.nextLine() problem
			
			if (createOrRemove == 1) {
				System.out.print("\nEnter Cinema Showtimes (e.g. \"Sun 13/11 1300H\"): ");
				switch (choice) {
					case 1: cinemaShowtime[0].add(sc.nextLine()); System.out.println("Added!"); break;
					case 2: cinemaShowtime[1].add(sc.nextLine()); System.out.println("Added!"); break;
					case 3: cinemaShowtime[2].add(sc.nextLine()); System.out.println("Added!"); break;
					default: System.out.println("Invalid Input");
				}
			}
			
			else if (createOrRemove == 2) {
				System.out.println("\nChoose showtime to be removed:");
				for (int i=0; i<cinemaShowtime[choice-1].size(); i++) {
					System.out.println((i+1) + ". " + cinemaShowtime[choice-1].get(i));
				}
				System.out.println();
				cinemaShowtime[choice-1].remove(sc.nextInt()-1);
				System.out.println("Removed!");
			}
			
			else {
				System.out.println("Invalid Input");
				continue;
			}
		}
	}
	/**
	 * 
	 * @return status of the movie
	 */
	public String getShowingStatus() {
		switch(showingStatus) 
		{
			case 1: return "Coming Soon";
			case 2: return "Preview";
			case 3: return "Now Showing";
			case 4: return "End of Showing";
		}
		return "test";
	}

	//4 OPTIONS TO CHOOSE (0=Coming Soon, 1=Preview, 2=Now Showing, 3=End of Showing)
	public void setShowingStatus() {
		System.out.println("\nEnter Showing Status:\n"
						  + "1: Coming Soon\n"
						  + "2: Preview\n"
						  + "3: Now Showing\n"
						  + "4: End of Showing\n");
		showingStatus = sc.nextInt();
		sc.nextLine(); //to fix nextLine() issue
	}
/**
 * 
 * @return synopsis of movie
 */
	public String getSynopsis() {
		return synopsis;
	}
/**
 * @param sets the synopsis 
 */
	public void setSynopsis() {
		System.out.print("\nEnter Synopsis: ");
		synopsis = sc.nextLine();
	}
/**
 * 
 * @return director of movie
 */
	public String getDirector() {
		return director;
	}

	public void setDirector() {
		System.out.print("\nEnter Director: ");
		director = sc.nextLine();
	}
/**
 * 
 * @return shows the cast for the movie
 */
	public String getCast() {
		String stringCast = "";
		for (int i=0; i<cast.size()-1; i++) {
			stringCast += cast.get(i) + ", ";
		}
		//Print last cast member without comma afterwards
		stringCast += cast.get(cast.size()-1);
		return stringCast;
	}

	public void setCast() {
		cast.clear(); //empty the entire cast arrayList
		System.out.print("\nEnter No. of Cast Members (at least 2): ");
		int numCast = sc.nextInt();
		sc.nextLine(); //to fix nextLine() issue
		for (int i=1; i<=numCast; i++) {
			System.out.print("Enter Cast Member " + i + ": ");
			cast.add(sc.nextLine());
		}
	}
/**
 * 
 * @return reviews that the movie has gotten
 */
	public String getOverallReviewerRating() {
		return overallReviewerRating;
	}

	public void setOverallReviewerRating() {
		//"NA" if no existing ratings
		if (reviewsAndRatings.size() == 0) overallReviewerRating = "NA";

		else {
			//calculate average of all ratings stored in reviewsAndRatings arrayList
			double averageRating = 0;
			for (int i=0; i<reviewsAndRatings.size(); i++) {
				//convert rating from String to int and sum them
				averageRating += Integer.parseInt(reviewsAndRatings.get(i)[0]);
			}
			//divide the sum of all ratings by number of ratings to get average
			averageRating /= reviewsAndRatings.size();
			//convert from double to string
			overallReviewerRating = Double.toString(averageRating);
		}
	}
	
	public void printReviewsAndRatings() {
		System.out.print("Reviews and Ratings: ");
		if (reviewsAndRatings.size() == 0) {
			System.out.println("0");
		}
		else {
			for (int i=0; i<reviewsAndRatings.size(); i++) {
				System.out.print(reviewsAndRatings.get(i)[0] + "-"+ reviewsAndRatings.get(i)[1] + "/"); //rating and review
			}
			System.out.println();
		}
	}

	//Store rating as string and convert to int later to calculate overallReviewerRating
	public void addReviewsAndRatings() {
		System.out.print("\nEnter Rating (1 to 5): ");
		String newRating = sc.nextLine();
		System.out.print("\nEnter Review: ");
		String newReview = sc.nextLine();
		String[] newReviewAndRating = new String[]{newRating, newReview};
		reviewsAndRatings.add(newReviewAndRating);
		setOverallReviewerRating();
		System.out.println("\nRating and Review Added!\n");
	}
	/**
	 * 
	 * @return amount of ticket sold for that movie
	 */
	public String getTicketSales() {
		return Integer.toString(this.ticketSales);
	}
	
	public void addTicketSales() {
		 this.ticketSales += 1;
	}

}