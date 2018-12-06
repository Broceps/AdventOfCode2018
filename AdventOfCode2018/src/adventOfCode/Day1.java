package adventOfCode;

import java.util.ArrayList;
import java.util.List;

public class Day1 {

	String[] frequency = AOCInput.read("files/day1_1.txt"); //input-file
	List<Integer> newFreq = new ArrayList<Integer>();
	int totFrequency = 0;
	int actualFrequency = 0;

	//First puzzle

	public void first() {
		for(int i = 0; i < frequency.length; i++) {
			totFrequency += Integer.parseInt(frequency[i]);
		}

		System.out.println(totFrequency);
	}


	//Second puzzle


	/**
	 * By creating a new arraylist (beacuse we can't specify size) we can run the frequencies over and over and for every 
	 * frequency update (current +/- new freq) we iterate from that element in the arraylist down to the first element.
	 * If we find a matching couple of frequencies, it breaks the loop and gives us an answer.
	 */
	public void second() {
		totFrequency = 0;
		newFreq.add(0, 0);
		
		boolean found = false;
		int counter = 1;
		int res;
		
		while(found == false) {
			for(int i = 0; i < frequency.length; i++) {
				totFrequency += Integer.parseInt(frequency[i]);
				newFreq.add(counter, totFrequency);
				for(int j = counter-1; j >= 0; j--) {
					if(newFreq.get(j) == totFrequency) {
						res = newFreq.get(j);
						System.out.println(res);
						found = true;
					}
				}
				counter++;
			}
		}

	}




	//Result

	public static void main(String[] args) {
		Day1 prog = new Day1();

		prog.first();
		prog.second();
	}

}
