package startupMain;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

/**
 * Main method called when initiating program
 * @author Low Zheng Han, Lou Sim Teng, MD Firdaus Bin Azizan, Hsieh Boh Yang, Martin Chin
 *
 */
public class Startup {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * store the type of user (customer or staff)
	 */
	private static int userType;
	
	public static void main(String[] args) {
		// load movie details
		MovieDetails movieDetails = new MovieDetails();
		//Ask for user type
		while (true) {
				
			//Keep asking for input if invalid input is received
			while (true) {
				
				try {
					System.out.println("|===============Main Menu===============|\n" +
									   "    Hi, are you a staff or a customer?\n" +
								   	   "          Enter 0 for Staff\n" +
								   	   "         Enter 1 for Customer\n" +
								   	   "      Enter 2 to exit application\n"+	
								   	   "|=======================================|\n");
					userType = sc.nextInt();
					
					//If input is not 0 or 1, throw new exception
					if (userType!=0 && userType!=1 && userType!=2 ) {
						throw new IOException();
					}
					//If input is 0 or 1, break from while loop
					break;
					
				} catch (IOException e) {
					//Catch exception if input not 0 or 1
					System.out.println("Invalid Option.\n");
				}
			}
			
			//If user is a staff
			if (userType==0) {
				//Create new staff object
				Staff staff = new Staff();
				staff.showStaffSystem();
			}
			
			//If user is a customer
			else if (userType ==1){
				//Create new customer object
				Customer customer = new Customer(movieDetails);
				customer.showCustomerSystem();
			}
			//exit application
			else {
				System.out.println("Exiting aplication now...\n");
				break;
			}
		}
	}
}
