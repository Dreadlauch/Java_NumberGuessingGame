package src;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = 1100;
		int sel, randNum = 0;
		String[] range = {"0-10", "0-100", "0-1000"};
		
		System.out.println("Welcome to the Number guessing game!");
		System.out.println("First select a range for the game:");
		System.out.println("(for " + range[0] + " enter 1, for " + range[1] + " enter 2, for " + range[2] + " enter 3)");
		
		sel = scanner.nextInt();
		randNumGen(randNum, sel);
		
		System.out.println("Now pick a number within your chosen range: ");
		
		comparison(scanner, randNum, num);
	}
	
	static void randNumGen(int randNum, int sel) {
		switch (sel){
			case 1:
				randNum = (int) (Math.random() * 11);
				break;
			case 2:
				randNum = (int) (Math.random() * 101);
				break;
			case 3:
				randNum = (int) (Math.random() * 1001);
				break;
			default:
				System.out.println("Invalid selection!");
				main(null);
		}
	}
	
	static void comparison(Scanner scanner, int randNum, int num) {
		String hintPrompt;
		for (int i=0; num != randNum; i++) {
			num = scanner.nextInt();
			if (i == 10) {
				System.out.println("GAME OVER!");
				System.exit(0);
			}
			System.out.println("Not quite, try again.");
			if (i == 5) {
				System.out.println("Do you want a hint? (y) / (n)");
				hintPrompt = scanner.next();
				hint(hintPrompt, num, randNum);
			}
		}
	}
	
	static void hint(String hintPrompt, int num, int randNum) {
		if (hintPrompt.equals("y")) {
			System.out.println("Your number is " + Integer.compare(num, randNum) + " to the random number");
		}
		else {
			return;
		}
	}
}
