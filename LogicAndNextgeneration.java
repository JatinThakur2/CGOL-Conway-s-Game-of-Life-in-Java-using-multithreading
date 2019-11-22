package Main;

/**
 * 
 * Description : Program of CGOL which I made for the Project using Java and the
 * Multithreading concept in it.
 * 
 * @author Jatin Thakur
 * 
 * 
 * @version 1.00 All rules of CGOL Any live cell with two or three neighbors
 *          survives. Any dead cell with three live neighbors becomes a live
 *          cell. All other live cells die in the next generation. Similarly,
 *          all other dead cells stay dead.
 */
public class LogicAndNextgeneration extends Thread {

	private int r, c; // Variables row and column r means row and c means column
	private int[][] arr;
	private int[][] futureLife = new int[1000][1000];// This will define the no. of grids

	public LogicAndNextgeneration(int r, int c, int[][] arr) {
		this.r = r;
		this.c = c;
		this.arr = arr;
	}

	public void run() {
		// Calculating the time elapsed so far.
		long startTime = System.nanoTime();
		int i, j, k, l;

		// Loop through every cell of the every row and column
		for (i = 1; i < r - 1; i++) {
			for (j = 1; j < c - 1; j++) {

				// It will finding how many cells are alive
				int aliveCell = 0;
				for (k = -1; k <= 1; k++)
					for (l = -1; l <= 1; l++)
						aliveCell = aliveCell + arr[i + k][j + l];

				aliveCell = aliveCell - arr[i][j];

				// If cell is lonely then it will dead
				if ((arr[i][j] == 1) && (aliveCell < 2)) {
					futureLife[i][j] = 0;
				}

				// If cell is over populated it will dead again
				else if ((arr[i][j] == 1) && (aliveCell > 3)) {
					futureLife[i][j] = 0;
				}

				// A new cell is born as 3 adjacent cells are alive near by the cell
				else if ((arr[i][j] == 0) && (aliveCell == 3)) {
					futureLife[i][j] = 1;
				}

				// Nothing happens so it remains same
				else {
					futureLife[i][j] = arr[i][j];
				}
			}
		}

		System.out.println();
		System.out.println("Next Life is:");

		// This will printing the next life
		for (k = 0; k < r; k++) {
			for (l = 0; l < c; l++) {
				if (futureLife[k][l] == 0)
					System.out.print("-"); // "-" means that the cell is Dead
				else
					System.out.print("*"); // "*" means that the cell is alive
			}
			System.out.println();
		}

		// Assigning the next life to the main array to print further generation
		for (k = 0; k < r; k++) {
			for (l = 0; l < c; l++) {
				arr[k][l] = futureLife[k][l];

			}
		}
		// Calculating the time to execute the next generation of CGOL
		long time = System.nanoTime() - startTime;
		System.out.println("Time taken for next Generation execution time: " + time + " ns");
		System.out.println("Enter the y for continuing the game: ");
	}

}
