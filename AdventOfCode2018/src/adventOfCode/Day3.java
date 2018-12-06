package adventOfCode;

public class Day3 {

	String[] input = AOCInput.read("files/Day3.txt");

	int[][] fabrics = new int[1000][1000]; //Declaring the matrix

	//First & Second Puzzle

	/**
	 * Make an matrix of 1000x1000 by filling them with zeros, for each fabric claim, mark the spot in the matrix by
	 * incrementing the value, every time a spot is claimed the value increases. FInally loop through and have a counter
	 * that counts every spot in the matrix that has the value >1. Return this value
	 */


	/**
	 * Creating an 1000x1000 matrix
	 */
	public void createMatrix() {
		for(int row = 0; row < fabrics.length; row++) {
			for(int col = 0; col < fabrics[row].length; col++ ) {
				fabrics[row][col] = 0;
			}
		}

	}

	/**
	 * Printing an 1000x1000 matrix, just for testing
	 */
	public void printMatrix() {
		for(int row = 0; row < fabrics.length; row++) {
			for(int col = 0; col < fabrics[row].length; col++ ) {
				System.out.print(fabrics[row][col]);
			}
			System.out.println();
		}

	}

	/**
	 * Claiming the fabrics
	 * @param fromLeft
	 * @param fromTop
	 * @param width
	 * @param height
	 */
	public void claimFabric(int fromLeft, int fromTop, int width, int height) {
		for(int row = fromTop; row < height+fromTop; row++) {
			for(int col = fromLeft; col < width+fromLeft; col++) {
				fabrics[row][col] += 1;
			}
		}
	}


	/*
	 * "Getters" to get out the meassurements from the claims input
	 */
	public int getFromLeft(String input) {
		int start, end;
		int fromLeft;
		String convert;

		start = input.indexOf("@");
		end = input.indexOf(",");

		convert = input.substring(start+2, end);
		fromLeft = Integer.parseInt(convert);
		return fromLeft;
	}

	public int getFromTop(String input) {
		int start, end;
		int fromTop;
		String convert;

		start = input.indexOf(",");
		end = input.indexOf(":");

		convert = input.substring(start+1, end);
		fromTop = Integer.parseInt(convert);
		return fromTop;
	}

	public int getWidth(String input) {
		int start, end;
		int width;
		String convert;

		start = input.indexOf(":");
		end = input.indexOf("x");

		convert = input.substring(start+2, end);
		width = Integer.parseInt(convert);
		return width;
	}

	public int getHeight(String input) {
		int start;
		int height;
		String convert;

		start = input.indexOf("x");

		convert = input.substring(start+1);
		height = Integer.parseInt(convert);
		return height;
	}

	public String getClaimID(String input) { 	//For the second part
		String id;
		int end;
		end = input.indexOf(" ");		
		id = input.substring(0, end);

		return id;
	}



	public void action() {
		createMatrix();

		for(String claim : input) {
			int fromLeft, fromTop, width, height;
			fromLeft = getFromLeft(claim);
			fromTop = getFromTop(claim);
			width = getWidth(claim);
			height = getHeight(claim);
			claimFabric(fromLeft, fromTop, width, height);
		}
	}

	public void countMatrix() {
		int counter = 0;

		for(int row = 0; row < fabrics.length; row++) {
			for(int col = 0; col < fabrics[row].length; col++ ) {
				if (fabrics[row][col] > 1) {
					counter++;
				}
			}
		}

		System.out.println(counter);

	}

	//For second puzzle 
	public void scanFabric() {
		boolean noOverlap = false;

		while(noOverlap == false) {

			for(String claim : input) {
				int counter = 0;
				int fromLeft, fromTop, width, height;
				fromLeft = getFromLeft(claim);
				fromTop = getFromTop(claim);
				width = getWidth(claim);
				height = getHeight(claim);
				//loop through and check all spots from the claim in specific
				for(int row = fromTop; row < height+fromTop; row++) {
					for(int col = fromLeft; col < width+fromLeft; col++) {
						if(fabrics[row][col] > 1) {
							counter ++;
						}
					}
				}
				if (counter == 0) {
					noOverlap = true;
					System.out.println(getClaimID(claim));
				}
				
			}
		}
	}



	public static void main(String[] args) {
		Day3 prog = new Day3();
		//Tests
		//prog.createMatrix();
		//prog.claimFabric(3, 2, 5, 4);
		//prog.printMatrix();

		//Puzzle 1 
		prog.action();
		prog.countMatrix();
		//Puzzle 2
		prog.scanFabric();

		




	}

}
