
import java.util.*;


public class Board {
    private List<Snake> snakes;
    private List<Ladder> ladders;
    
    public Board() {
        initializeSnakesAndLadders();
    }
    
    private void initializeSnakesAndLadders() {
        
        snakes = Arrays.asList(
            new Snake(99, 54),
            new Snake(70, 55),
            new Snake(52, 42),
            new Snake(25, 2),
            new Snake(95, 72)
        );
        
        
        ladders = Arrays.asList(
            new Ladder(6, 25),
            new Ladder(11, 40),
            new Ladder(60, 85),
            new Ladder(46, 90),
            new Ladder(17, 69)
        );
    }
    
    public int getNewPosition(int currentPosition, int diceValue) {
        int newPosition = currentPosition + diceValue;
        
        
        if (newPosition > 100) {
            return currentPosition;
        }
        
        
        for (Ladder ladder : ladders) {
            if (ladder.isAtBottom(newPosition)) {
                System.out.println("Climbed a ladder from " + newPosition + " to " + ladder.getTop());
                return ladder.getTop();
            }
        }
        
        
        for (Snake snake : snakes) {
            if (snake.isAtHead(newPosition)) {
                System.out.println("Bitten by snake! Slid from " + newPosition + " to " + snake.getTail());
                return snake.getTail();
            }
        }
        
        return newPosition;
    }
    
    public void displayBoard() {
        System.out.println("\n=== BOARD LAYOUT ===");
        System.out.println("Snakes:");
        for (Snake snake : snakes) {
            System.out.println("  " + snake.getHead() + " -> " + snake.getTail());
        }
        System.out.println("Ladders:");
        for (Ladder ladder : ladders) {
            System.out.println("  " + ladder.getBottom() + " -> " + ladder.getTop());
        }
        System.out.println("==================\n");
    }
}