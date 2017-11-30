package streichholzspiel;
import java.util.Scanner;

public class Streichholzspiel {
	Scanner scanner = new Scanner(System.in);

	private void gameProcess() {
		boolean computerStarts;
		System.out.println("Mit wie vielen Streichhölzern soll gespielt werden?");
		int numberOfMatchsticks = scanner.nextInt();

		System.out.println("Wer soll beginnen?");
		System.out.println("Computer (c)");
		System.out.println("ich (i)");
		String startChoice = scanner.next();
		if (startChoice.equals("c")) {
			computerStarts = true;
		} else {
			computerStarts = false;
		}

		moves(numberOfMatchsticks, computerStarts);
	}

	void moves(int numberOfMatchsticks, boolean computerStarts) {
		int newNumberOfMatchsticks = numberOfMatchsticks;
		boolean computerWins = false;
		boolean computerPicks = computerStarts;

		do {
			System.out.println("Es sind noch " + newNumberOfMatchsticks + " Hölzer im Spiel.");
			if (computerPicks) {
				newNumberOfMatchsticks = computerPicks(newNumberOfMatchsticks);
				if (newNumberOfMatchsticks == 0) {
					computerWins = true;
				}
			} else {
				newNumberOfMatchsticks -= gamerPicks();
			}
			computerPicks = !computerPicks;
		} while (newNumberOfMatchsticks > 0);

		if (computerWins) {
			System.out.println("Der Computer hat gewonnen.");
		} else {
			System.out.println("Glückwunsch - Du hast gewonnen!");
		}
	}

	int gamerPicks() {
		int numberGamerPicks = 0;
		while (numberGamerPicks < 1 || numberGamerPicks > 3) {
			System.out.println("Wie viele Streichhölzer willst du nehmen? Wähle 1, 2, oder 3.");
			numberGamerPicks = scanner.nextInt();
		}
		return numberGamerPicks;
	}

	int computerPicks(int numberOfMatchsticks) {
		int numberComputerPicks;
		numberComputerPicks = numberOfMatchsticks % 4;
		if (numberComputerPicks == 0) {
			numberComputerPicks = 1;
		}
		System.out.println("Der Computer hat " + numberComputerPicks + " Streichhölzer genommen.");
		return numberOfMatchsticks - numberComputerPicks;
	}

	public static void main(String[] args) {
		Streichholzspiel game = new Streichholzspiel();
		game.gameProcess();
	}

}