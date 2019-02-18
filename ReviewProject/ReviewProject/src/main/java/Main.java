package main.java;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;


	/**
	 * main method for running the program.
	 * @author amehlhas, adalvi1
	 *
	 */
	public final class Main {
		/**
		 * All methods should have a Javadoc according to STYLE.
		 * @param args command-line arguments
		 * @throws Exception as per typical main specifications
		 */
		public static void main(final String[] args) throws Exception {

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String accStr;
			String choice;

			if (args.length == 0) {
				accStr = "5";
				choice = "1";

			}
			else{

				System.out.println("Enter your string of numbers or just one number:");
				accStr = br.readLine();

				System.out.println("Initial String: ");
				System.out.println(accStr);

				System.out.println("Algorithm Codes :\n"
						+ "0 (Power Set 1) \t 1 (Power Set  2) \t 2 (Power Set  3)\n");
				System.out.println("Enter selected algorithm code :");
				choice = br.readLine();

			}
			PowerSetData data = new PowerSetData();

			try {

				data.initializeArray(accStr);

				data.runAlgo(Integer.valueOf(choice).intValue()+1);


			 } catch (NoSuchElementException e) {
				 System.out.println("Not enough numbers.");
		     } catch (NumberFormatException e) {
		    	 System.out.println("Please only use integer values. ");
		     } catch (NegativeArraySizeException e) {
		    	 System.out.println("Negative Array Size.");
		     }


		}

	}
