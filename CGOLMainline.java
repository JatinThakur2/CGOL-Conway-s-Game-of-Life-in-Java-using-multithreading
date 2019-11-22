package Main;

import java.util.Scanner;

/**
 * 
 * Description : Program of CGOL which I made for the Project using Java and the
 * Multithreading concept in it.
 * 
 * @author Jatin Thakur
 * 
 * @version 1.00 All rules of CGOL Any live cell with two or three neighbors
 *          survives. Any dead cell with three live neighbors becomes a live
 *          cell. All other live cells die in the next generation. Similarly,
 *          all other dead cells stay dead.
 */
public class CGOLMainline {

	public static void main(String[] args) {
		// Taking the input from the User
		Scanner sc = new Scanner(System.in);

		// Variables row and column r means row and c means column
		int r, c;
		char run;
		System.out.println("Enter the no of rows");
		// Taking the row from the user
		r = sc.nextInt();

		System.out.println("Enter the no of Columns");
		// Taking the column from the user
		c = sc.nextInt();

		// Declare the Arrays which will store the intial CGOL
		int[][] arr = new int[r][c];

		System.out.println("Enter the CGOL:");
		System.out.println("Entry must be in 0 and 1, 0 for the dead cell and 1 for the alive cell");
		System.out.println("When the next generation will appear in the from of * and -,");
		System.out.println(" '-' for the dead cell and '*' for the alive cell");
		// Taking the user input for the initial generation
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		do {
			// Making the object of Logic class
			LogicAndNextgeneration object = new LogicAndNextgeneration(r, c, arr);
			// Executing the thread
			object.start();
			// Setting the priority so that it always run after printing the generation
			object.setPriority(2);
			// Asking the User to continue the game
			run = sc.next().charAt(0);
		} while (run == 'y');

		// When user enter any other character then y, loop stops and print below
		// message
		System.out.println("Thank you for playing the game");
		sc.close();
	}

}
