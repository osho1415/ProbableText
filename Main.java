import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
 
    System.out.print("Enter book name: ");
    String book = keyboard.next().trim();
 
    System.out.print("Enter ngram length: ");
    int ngramLength = keyboard.nextInt();
 
    System.out.print("How many letters? ");
    int letters = keyboard.nextInt();
    keyboard.close();
    
    ProbableTextWithMap rw = new ProbableTextWithMap(book, ngramLength);
    System.out.println();
    rw.printRandom(letters);
  }
}
