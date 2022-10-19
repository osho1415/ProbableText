import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class ProbableTextWithMap {

	OurHashMap<String, ArrayList<Character>> theMap;
	StringBuffer theBook;
	Scanner fileReader;
	String bookName;
	int nGramLength;

	ProbableTextWithMap(String fileName, int ngramLength) {
		bookName = fileName;
		nGramLength = ngramLength;
		theBook = getBookAsString();
		theMap = buildtheMap();
	}

	public void printRandom(int letters) {

		String nGram = getRandomNGram();
		int totalCountPrint = 0;
		float lineCountPrint = 0;
		Random rand = new Random();
		char element;

		while (totalCountPrint <= letters) {

			ArrayList<Character> printList = theMap.get(nGram);

			int randomIndex = rand.nextInt(printList.size());

			element = printList.get(randomIndex);

			if ((lineCountPrint / 60 >= 1) && (element == ' ')) {
				System.out.print("\n");
				lineCountPrint = 0;
			} else {

				System.out.print(element);
				totalCountPrint++;
				lineCountPrint++;
			}

			nGram = nGram.substring(1) + element;
		}

	}

	public StringBuffer getBookAsString() {
		// gets the entire text as a string with new lines separated by spaces.

		theBook = new StringBuffer();
		fileReader = null;
		try {
			fileReader = new Scanner(new File(bookName));

		} catch (FileNotFoundException fnfe) {
			System.out.println("Book not found, enter valid book name.");
		}

		while (fileReader.hasNextLine()) {
			theBook.append(fileReader.nextLine());
			theBook.append(' ');
		}

		return theBook;
	}

	public OurHashMap<String, ArrayList<Character>> buildtheMap() {
		// builds the map with ngrams as keys and characters following them as values.

		theMap = new OurHashMap<String, ArrayList<Character>>();

		for (int index = 0; index < theBook.length() - nGramLength; index++) {

			String key = theBook.substring(index, index + nGramLength);
			Character keyValue = theBook.charAt(index + nGramLength);
			ArrayList<Character> values = new ArrayList<Character>();

			if (theMap.containsKey(key)) {
				values = theMap.get(key);
				values.add(0, keyValue);

			} else {
				values.add(0, keyValue);

			}

			theMap.put(key, values);
		}

		return theMap;
	}

	public String getRandomNGram() {

		// get a random nGram from the middle of the book.
		Random rand = new Random();
		int randomIndex = rand.nextInt(theBook.length() / 2);
		String nGram = theBook.substring(randomIndex, randomIndex + nGramLength);
		return nGram;

	}

}
