import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final Card card1 = new Card("Deepak", "1234-5678-1234-5678", "1234", 2000);
    private static final Card card2 = new Card("Lavish", "1234-5678-1234-1111", "5678", 2000);
    private static final Card card3 = new Card("Harshdeep", "1234-5678-1234-2222", "1111", 2000);
    private static final Card card4 = new Card("Yashasvi", "1234-5678-1234-3333", "2222", 2000);
    private static ArrayList<Card> cards = new ArrayList<>();


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        cards.add(card1);
        cards.add(card2);
        cards.add(card3);
        cards.add(card4);

        boolean condition = true;
        while(condition){
            System.out.println("Welcome to ATM Simulator\nPress 1 to Use a Card\nPress 2 to Exit");
            if(scanner.nextInt() == 1){
                callATM(scanner);
            }else {
                condition = false;
            }
        }

    }

    private static void callATM(Scanner scanner) {
        Card card;
        System.out.print("Enter card number :- ");
        String cardNumber = scanner.next();
        if(getCard(cardNumber)!=null) {
            card = getCard(cardNumber);
            callOperations(card, scanner);
        }
        else{
            System.out.println("Enter a valid card number");
            callATM(scanner);
        }

    }

    private static void callOperations(Card card, Scanner scanner) {
        System.out.println("Enter 1 to withdraw\nEnter 2 to deposit\nEnter 3 for balance inquiry\nEnter 4 to exit");
        switch(scanner.nextInt()){
            case 1:
                withdraw(scanner, card);
                break;
            case 2:
                deposit(scanner, card);
                break;
            case 3:
                balanceEnquery(card);
                break;
            default:
                break;
        }
    }

    private static void balanceEnquery(Card card) {
        System.out.println("Your balance is " + Integer.toString(card.getBalance()));
    }

    private static void deposit(Scanner scanner, Card card) {
        System.out.print("Enter amount to deposit :- ");
        int amount = scanner.nextInt();
        card.setBalance(card.getBalance() + amount);
        System.out.println("Hooray! " + Integer.toString(amount) + " successfully deposited.");
    }

    private static void withdraw(Scanner scanner, Card card) {
        System.out.print("Enter amount to withdraw :- ");
        int amount = scanner.nextInt();
        System.out.print("Enter pin :- ");
        if(card.getPin().equals(scanner.next())){
            if(card.getBalance()>=amount){
                card.setBalance(card.getBalance()-amount);
                System.out.println("Hooray! " + Integer.toString(amount) + " successfully withdrawn.");
            }else System.out.println("Insufficient balance");
        }else{
            System.out.println("Wrong pin! Try again");
            withdraw(scanner, card);
        }
    }


    private static Card getCard(String cardNumber) {
        for(Card c: cards){
            if(cardNumber.equals(c.getCardNumber()))
                return c;
        }
        return null;
    }
}
