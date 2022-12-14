package startupMain;

import java.util.Scanner;

/**
 * Entity class representing a ticket
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class Ticket {
	
	Scanner sc = new Scanner(System.in);
	
	private String type;
	private String cinemaClass;
	private int age; //<13 child, >54 senior citizen
	private int weekDayOrEnd; //weekday=0, weekend=1
	private String customerName;
	private String customerMobileNumber;
	private String customerEmail;
	private String chosenCinemaShowtime;
	
	/**
	 * Default constructor for Ticket.
	 */
	public Ticket() {
		
	}
	
	/**
	 * Method to create ticket based on chosen movie.
	 * @param movie
	 */
	public void createTicket(Movie movie, Booking booking, String chosenCinemaShowtime) {
		this.type = movie.getType();
		//TODO CHECK IF "booking.getCinemaChoice()" RETURNS CINEMA NO. THROUGH BOOKING.JAVA
		this.cinemaClass = booking.getCinemaChoice();
		System.out.print("\nEnter your age: ");
		this.age = sc.nextInt();
		sc.nextLine();
		
		if (chosenCinemaShowtime.contains("Sat") || chosenCinemaShowtime.contains("Sun"))
			this.weekDayOrEnd = 1;
		else 
			this.weekDayOrEnd = 0;

		System.out.print("Enter your name: ");
		this.customerName = sc.nextLine();
		System.out.print("Enter your mobile number: ");
		this.customerMobileNumber = sc.nextLine();
		System.out.print("Enter your email: ");
		this.customerEmail = sc.nextLine();
		this.chosenCinemaShowtime = chosenCinemaShowtime;
		System.out.println("Confirmed!");
	}
	
	public String getType() {
		return type;
	}

	public String getCinemaClass() {
		return cinemaClass;
	}

	public int getAge() {
		return age;
	}

	public int getWeekDayOrEnd() {
		return weekDayOrEnd;
	}
	
	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}
	
	public String getChosenCinemaShowtime() {
		return chosenCinemaShowtime;
	}
}

//• The movie ticket price can be charged according to the following type : 
//a. type of movie (Regular, Blockbuster(Regular+$1), 3D) 
//b. class of cinema (Cinema 3: Platinum Movie Suites) 
//c. age of movie-goer (child<13, adult, senior citizen>54)
//d. day of the week or public holiday.