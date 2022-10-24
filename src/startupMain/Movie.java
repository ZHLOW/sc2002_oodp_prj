package startupMain;

import java.util.ArrayList;
import java.util.Scanner;

public class Movie {

	private static Scanner sc = new Scanner(System.in);
	
	private String title;
	private int showingStatus;
	private String synopsis;
	private String director;
	private ArrayList<String> cast = new ArrayList<String>();
	private double overallReviewerRating; //1 to 5
	private ArrayList<String[]> reviewsAndRatings = new ArrayList<String[]>(); //stored as (String review, double rating) as one array element
	private int ticketSales;
	
//	public Movie() {
//		title = "";
//		showingStatus = 0; // 0 = Coming Soon
//		synopsis = "";
//		director = "";
//		cast = [];
//		overallReviewerRating = 0;
//		ticketSales = 0;
//	}

	//Collection of all getter methods to display movie attributes
	public void viewMovieDetails() {
		getTitle();
		getShowingStatus();
		getSynopsis();
		getDirector();
		getCast();
		getOverallReviewerRating();
		getReviewsAndRatings();
		getTicketSales();
	}
	
	
	//Collection of all setter methods to create movie except overallReviewerRating and ticketSales
	public void createMovie() {
		setTitle();
		setShowingStatus();
		setSynopsis();
		setDirector();
		setCast();
	}
	
	public void getTitle() {
		System.out.println("\n*****************************\nTitle: " + title);
	}

	public void setTitle() {
		System.out.print("\nEnter Movie Title: ");
		title = sc.nextLine();
		System.out.println(title);
	}

	public void getShowingStatus() {
		System.out.print("Showing Status: ");
		switch(showingStatus) {
			case 1: System.out.println("Coming Soon"); break;
			case 2: System.out.println("Preview"); break;
			case 3: System.out.println("Now Showing"); break;
			case 4: System.out.println("End of Showing"); break;
		}
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
		System.out.println(showingStatus);
	}

	public void getSynopsis() {
		System.out.println("Synopsis: " + synopsis);
	}

	public void setSynopsis() {
		System.out.print("\nEnter Synopsis: ");
		synopsis = sc.nextLine();
		System.out.println(synopsis);
	}

	public void getDirector() {
		System.out.println("Director: " + director);
	}

	public void setDirector() {
		System.out.print("\nEnter Director: ");
		director = sc.nextLine();
		System.out.println(director);
	}

	public void getCast() {
		System.out.print("Cast: ");
		for (int i=0; i<cast.size()-1; i++) {
			System.out.print(cast.get(i) + ", ");
		}
		//Print last cast member without comma afterwards
		System.out.println(cast.get(cast.size()-1));
	}

	public void setCast() {
		System.out.print("\nEnter No. of Cast Members (at least 2): ");
		int numCast = sc.nextInt();
		sc.nextLine(); //to fix nextLine() issue
		for (int i=1; i<=numCast; i++) {
			System.out.print("Enter Cast Member " + i + ": ");
			cast.add(sc.nextLine());
		}
		System.out.println(cast);
	}

	//DISPLAY "NA" IF NO RATINGS (UNFINISHED)
	public double getOverallReviewerRating() {
		return overallReviewerRating;
	}

	//CALCULATE USING AVERAGE OF ALL PAST RATINGS (UNFINISHED)
	public void setOverallReviewerRating(double overallReviewerRating) {
		this.overallReviewerRating = overallReviewerRating;
	}

	public void getReviewsAndRatings() {
		System.out.print("Reviews and Ratings: ");
		for (int i=0; i<reviewsAndRatings.size(); i++) {
			System.out.println(reviewsAndRatings.get(i)[0]);
			System.out.println(reviewsAndRatings.get(i)[1]);
		}
	}

	//Store rating as string and convert to int later to calculate overallReviewerRating
	public void addReviewsAndRatings() {
		System.out.print("\nEnter Rating: ");
		String newRating = sc.nextLine();
		System.out.print("\nEnter Review: ");
		String newReview = sc.nextLine();
		String[] newReviewAndRating = new String[]{newRating, newReview};
		reviewsAndRatings.add(newReviewAndRating);
		System.out.println("\nRating and Review Added!\n");
	}

	public void getTicketSales() {
		System.out.println(ticketSales);
	}

	public void addTicketSales() {
		ticketSales += 1;
	}
}

//FOR GETTER METHODS, SHOULD RETURN? OR JUST PRINT AND DON'T RETURN? (prob need return for title only)
