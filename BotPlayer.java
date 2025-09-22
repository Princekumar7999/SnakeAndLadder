
public class BotPlayer extends Player {
    
    public BotPlayer(String name) {
        super(name);
    }
    
    @Override
    protected int rollDice(Dice dice) {

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return dice.roll();
    }
}