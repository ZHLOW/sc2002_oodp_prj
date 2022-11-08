package startupMain;

import java.util.Scanner;

public class Ticket {
	
	Scanner sc = new Scanner(System.in);
	
	private String type;
	private String cinemaClass;
	private int age; //<13 child, >54 senior citizen
	private int weekDayOrEnd; //weekday=0, weekend=1
	private String customerName;
	private String customerMobileNumber;
	private String customerEmail;
	
	/**
	 * Default constructor for Ticket.
	 */
	public Ticket() {
		
	}
	
	/**
	 * Method to create ticket based on chosen movie.
	 * @param movie
	 */
	public void createTicket(Movie movie, Booking booking) {
		this.type = movie.getType();
		//TODO CHECK IF "booking.getCinemaChoice()" RETURNS CINEMA NO. THROUGH BOOKING.JAVA
		this.cinemaClass = booking.getCinemaChoice();
		System.out.print("\nEnter your age: ");
		this.age = sc.nextInt();
//		TODO CHECK IF "booking.get???()" RETURNS SELECTED CINEMA SHOWTIME THROUGH BOOKING.JAVA
//		if (booking.get???().contains("Sat") || booking.get???().contains("Sun"))
//			this.weekDayOrEnd = 1;
//		else 
//			this.weekDayOrEnd = 0;
		
		//TODO MAY NEED TO ADD "sc.nextLine()" IN BETWEEN SCANS IF SCANNER NOT WORKING PROPERLY
		System.out.print("\nEnter your name: ");
		this.customerName = sc.nextLine();
		System.out.print("\nEnter your mobile number: ");
		this.customerMobileNumber = sc.nextLine();
		System.out.print("\nEnter your email: ");
		this.customerEmail = sc.nextLine();
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
	
	
}

//• The movie ticket price can be charged according to the following type : 
//a. type of movie (Regular, Blockbuster(Regular+$1), 3D) 
//b. class of cinema (Cinema 3: Platinum Movie Suites) 
//c. age of movie-goer (child<13, adult, senior citizen>54)
//d. day of the week or public holiday.