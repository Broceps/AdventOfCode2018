package adventOfCode;

import java.util.HashMap;
import java.util.Map;

public class Day2 {

	//2: x, f, p, {"cvzueihajytoirdkgsxfqihbwnc"}; 
	String[] input = AOCInput.read("files/Day2.txt");


	//First puzzle

	public Map<Character, Integer> initializeHashMap(String str) {
		Map<Character, Integer> alphabet = new HashMap<Character, Integer>(); //Making a dictionary(map) so we can have a counter for each letter
		char c;	

		for(int i = 0; i < str.length(); i++) { //lets us check every character
			int count = 0;
			c = str.charAt(i);
			for(int j=0; j<str.length(); j++) {
				if (!alphabet.containsKey(c)) {	//key does not already exists		
					if(str.charAt(j) == c) {
						count++;
					}
				}
			}
			if (!alphabet.containsKey(c)) {	
				alphabet.put(c, count); 	//Setting up the dictionary(map)
			}
		}
		return alphabet;

	}

	public int first() {
		char c;


		int twoLetters = 0; 	//boxID with letters appearing exactly two times
		int threeLetters = 0;	//boxID with letters appearing exactly three times



		for(String boxID : input) { //iterates through every boxID
			Map<Character, Integer> alphabet = initializeHashMap(boxID); //initializes a new map since we need to restore the results for each boxID

			int maxOfThree = 0, maxOfTwo = 0;
			//iterating through the current Dictionary(map)
			for(int i = 0; i<alphabet.size(); i++) {

				c = boxID.charAt(i);
				int countValue = alphabet.get(c);
				System.out.println("Letter: " + boxID.charAt(i) + "  Value: " + countValue);

				if(countValue == 2 && maxOfTwo < 1) {
					twoLetters++;
					maxOfTwo++;
				} else if(countValue == 3 && maxOfThree < 1) {
					threeLetters++;
					maxOfThree++;
				}

			}

		}
		//System.out.println(alphabet);

		return twoLetters*threeLetters;
	}


	//Second Puzzle

	/**
	 * Should print two similar outputs, except that one word is different at the same index for both outputs
	 * remove this and there is the answer
	 */
	public void second() {


		String compare;

		for(String boxID : input) {

			char[] correctID = new char[boxID.length()];

			for(int i = 0; i < input.length; i++) {
				int count = 0;
				compare = input[i];
				for(int x = 0; x < compare.length(); x++) {
					char a = compare.charAt(x);
					char b = boxID.charAt(x);
					if(a == b) {
						count++;
						correctID[x] = a;
					}
				}
				if(count == (boxID.length()-1)) {
					System.out.println( correctID );
				}
			}
		}
	}


	public static void main(String[] args) {
		Day2 prog = new Day2();
		//System.out.println(prog.first());
		prog.second();


	}


}

