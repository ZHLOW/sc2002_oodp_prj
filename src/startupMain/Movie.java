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
	private String[] reviewsAndRatings = new String[10]; //stored as (String review, double rating) as one array element
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
		addReviewsAndRatings(); //UNFINISHED
	}
	
	public void getTitle() {
		System.out.print("Title: " + title);
	}

	public void setTitle() {
		System.out.print("\nEnter Movie Title: ");
		title = sc.nextLine();
		System.out.println(title);
	}

	public void getShowingStatus() {
		switch(showingStatus) {
			case 1: System.out.println("Coming Soon");
			case 2: System.out.println("Preview");
			case 3: System.out.println("Now Showing");
			case 4: System.out.println("End of Showing");
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
		System.out.print("Synopsis: " + synopsis);
	}

	public void setSynopsis() {
		System.out.print("\nEnter Synopsis: ");
		synopsis = sc.nextLine();
		System.out.println(synopsis);
	}

	public void getDirector() {
		System.out.print("Director: " + director);
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
		System.out.print(cast.get(cast.size()-1));
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

	public String[] getReviewsAndRatings() {
		return reviewsAndRatings;
	}

	public void addReviewsAndRatings() {
		System.out.print("\nEnter Rating: ");
		int newRating = sc.nextInt();
		System.out.print("\nEnter Review: ");
		String newReview = sc.nextLine();
		
	}

	public int getTicketSales() {
		return ticketSales;
	}

	public void addTicketSales() {
		ticketSales += 1;
	}
}

//FOR GET METHODS, SHOULD RETURN? OR JUST PRINT AND DON'T RETURN?
