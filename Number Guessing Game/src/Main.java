import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to Number Guessing Game");
        System.out.println("Guess a number between 1 to 10 :- ");
        int guessednumber = scanner.nextInt();
        int number = random.nextInt(1,11);
        boolean GuessedRight = false;
        for(int i=0; i<5; i++){
            if(guessednumber == number){
                System.out.println("Yay, the guess was right!");
                GuessedRight = true;
                break;
            }
            else{
                System.out.println("Wrong Guess! Guess again :- ");
                guessednumber = scanner.nextInt();
                number = random.nextInt(1, 11);
            }
        }

        if(!GuessedRight){
            System.out.println("Maximum number of attempts reached, you lost!");
        }

    }
}
