
import java.util.*;


public class Game {
    private List<Player> players;
    private Board board;
    private Dice dice;
    private int currentPlayerIndex;
    
    public Game() {
        this.players = new ArrayList<>();
        this.board = new Board();
        this.dice = new Dice();
        this.currentPlayerIndex = 0;
    }
    
    public void addPlayer(Player player) {
        players.add(player);
    }
    
    public void startGame() {
        if (players.size() < 2) {
            System.out.println("Need at least 2 players to start the game!");
            return;
        }
        
        System.out.println("\n🎮 WELCOME TO SNAKE AND LADDER GAME! 🎮\n");
        board.displayBoard();
        
        System.out.println("Players:");
        for (Player player : players) {
            System.out.println("- " + player.getName());
        }
        System.out.println("\nLet's start!\n");
        
        
        while (!isGameOver()) {
            playTurn();
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        
        announceWinner();
    }
    
    private void playTurn() {
        Player currentPlayer = players.get(currentPlayerIndex);
        
        System.out.println("\n--- " + currentPlayer.getName() + "'s Turn ---");
        System.out.println("Current position: " + currentPlayer.getPosition());
        
        
        int diceValue = currentPlayer.takeTurn(dice);
        
        
        int newPosition = board.getNewPosition(currentPlayer.getPosition(), diceValue);
        
        
        currentPlayer.moveToPosition(newPosition);
        
        
        if (currentPlayer.hasWon()) {
            System.out.println("🎉 " + currentPlayer.getName() + " WINS! 🎉");
        }
        
        System.out.println();
    }
    
    private boolean isGameOver() {
        return players.stream().anyMatch(Player::hasWon);
    }
    
    private void announceWinner() {
        Player winner = players.stream()
            .filter(Player::hasWon)
            .findFirst()
            .orElse(null);
            
        if (winner != null) {
            System.out.println("🏆 GAME OVER! 🏆");
            System.out.println("Winner: " + winner.getName());
            System.out.println("\nFinal positions:");
            for (Player player : players) {
                System.out.println("- " + player.getName() + ": Position " + player.getPosition());
            }
        }
    }
}