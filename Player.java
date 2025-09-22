
public abstract class Player {
    protected String name;
    protected int position;
    
    public Player(String name) {
        this.name = name;
        this.position = 1;
    }
    
    
    public final int takeTurn(Dice dice) {
        int diceValue = rollDice(dice);
        System.out.println(name + " rolled: " + diceValue);
        return diceValue;
    }
    
    
    protected abstract int rollDice(Dice dice);
    
    public void moveToPosition(int newPosition) {
        this.position = newPosition;
        System.out.println(name + " is now at position: " + position);
    }
    
    public int getPosition() {
        return position;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean hasWon() {
        return position >= 100;
    }
}