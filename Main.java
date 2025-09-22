
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        
        System.out.println(" Welcome to Snake and Ladder Game! 🪜🐍");
        System.out.println("=======================================");
        
       
        System.out.print("Enter number of human players (1-4): ");
        int humanPlayers = scanner.nextInt();
        scanner.nextLine(); 
        
        
        for (int i = 1; i <= humanPlayers; i++) {
            System.out.print("Enter name for Player " + i + ": ");
            String name = scanner.nextLine();
            game.addPlayer(new HumanPlayer(name));
        }
        
        
        System.out.print("Add bot players? (y/n): ");
        String addBots = scanner.nextLine().toLowerCase();
        
        if (addBots.equals("y") || addBots.equals("yes")) {
            System.out.print("Enter number of bot players (1-3): ");
            int botPlayers = scanner.nextInt();
            
            for (int i = 1; i <= botPlayers; i++) {
                game.addPlayer(new BotPlayer("Bot" + i));
            }
        }
        
        
        game.startGame();
        
        scanner.close();
    }
}