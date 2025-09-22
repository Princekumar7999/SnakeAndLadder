
import java.util.Scanner;


public class HumanPlayer extends Player {
    private Scanner scanner;
    
    public HumanPlayer(String name) {
        super(name);
        this.scanner = new Scanner(System.in);
    }
    
    @Override
    protected int rollDice(Dice dice) {
        System.out.println(name + ", press Enter to roll the dice...");
        scanner.nextLine();
        return dice.roll();
    }
}