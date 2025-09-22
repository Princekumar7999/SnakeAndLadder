# Snake and Ladder Game

A simple console-based Snake and Ladder game implemented in Java. The game supports both human and bot players.

##  Features

- Support for multiple human players (1-4)
- Bot players with automated gameplay
- Traditional 100-square board
- 5 snakes and 5 ladders
- Console-based interface
- Clean architecture with SOLID principles

##  Class Diagram

```
┌─────────────────────────────────────────────────────────────────────────┐
│                          SNAKE AND LADDER GAME                         │
└─────────────────────────────────────────────────────────────────────────┘

┌─────────────────┐         ┌─────────────────┐         ┌─────────────────┐
│      Main       │────────▶│      Game       │────────▶│     Board       │
│                 │         │                 │         │                 │
│ + main(String[])│         │ - players: List │         │ - snakes: List  │
└─────────────────┘         │ - board: Board  │         │ - ladders: List │
                           │ - dice: Dice    │         │                 │
                           │ - currentPlayer │         │ + getNewPos()   │
                           │                 │         │ + displayBoard()│
                           │ + addPlayer()   │         └─────────────────┘
                           │ + startGame()   │
                           └─────────────────┘
                                    │
                                    │ uses
                                    ▼
                           ┌─────────────────┐
                           │     Player      │◀─────────┐
                           │   (abstract)    │          │
                           │                 │          │
                           │ # name: String  │          │
                           │ # position: int │          │
                           │                 │          │
                           │ + takeTurn()    │          │
                           │ + moveToPos()   │          │
                           │ # rollDice()    │          │
                           └─────────────────┘          │
                                    △                   │
                           ┌────────┴────────┐          │
                           │                 │          │
                ┌─────────────────┐ ┌─────────────────┐ │
                │  HumanPlayer    │ │   BotPlayer     │ │
                │                 │ │                 │ │
                │ - scanner       │ │                 │ │
                │                 │ │                 │ │
                │ + rollDice()    │ │ + rollDice()    │ │
                └─────────────────┘ └─────────────────┘ │
                                                        │
                                                        │
                ┌─────────────────┐ ┌─────────────────┐ │
                │     Snake       │ │     Ladder      │ │
                │                 │ │                 │ │
                │ - head: int     │ │ - bottom: int   │ │
                │ - tail: int     │ │ - top: int      │ │
                │                 │ │                 │ │
                │ + isAtHead()    │ │ + isAtBottom()  │ │
                └─────────────────┘ └─────────────────┘ │
                                                        │
                ┌─────────────────┐                     │
                │      Dice       │◀────────────────────┘
                │                 │
                │ - random: Random│
                │                 │
                │ + roll(): int   │
                └─────────────────┘
```

##  File Structure

```
snake-ladder-game/
├── Main.java          # Entry point
├── Game.java          # Game logic controller
├── Player.java        # Abstract player class
├── HumanPlayer.java   # Human player implementation
├── BotPlayer.java     # Bot player implementation
├── Board.java         # Game board management
├── Snake.java         # Snake entity
├── Ladder.java        # Ladder entity
├── Dice.java          # Dice functionality
└── README.md          # This file
```

##  How to Run

### Prerequisites
- Java 8 or higher installed
- Command line interface

### Compilation and Execution

1. **Compile all Java files:**
   ```bash
   javac *.java
   ```

2. **Run the game:**
   ```bash
   java Main
   ```

3. **Follow the prompts:**
   - Enter number of human players (1-4)
   - Enter names for each human player
   - Choose whether to add bot players
   - Press Enter when it's your turn to roll dice
   - Watch the bot players play automatically


##  Game Rules

1. **Board**: 100 squares numbered 1 to 100
2. **Starting Position**: All players start at position 1
3. **Dice**: Standard 6-sided die (1-6)
4. **Movement**: Players move forward by dice value
5. **Winning**: First player to reach or exceed position 100 wins
6. **Snakes**: Landing on snake head sends you to tail
7. **Ladders**: Landing on ladder bottom climbs you to top
8. **Boundary**: Can't move beyond position 100

##  Board Layout

### Snakes (Head → Tail)
- 99 → 54
- 95 → 72  
- 70 → 55
- 52 → 42
- 25 → 2

### Ladders (Bottom → Top)
- 6 → 25
- 11 → 40
- 17 → 69
- 46 → 90
- 60 → 85

##  Function Explanations

### **Main Class**
- **`main(String[] args)`**: Entry point, handles user input and game setup

### **Game Class**
- **`addPlayer(Player player)`**: Adds a player to the game
- **`startGame()`**: Initiates and manages the game loop
- **`playTurn()`**: Manages individual player turns
- **`isGameOver()`**: Checks if any player has won
- **`announceWinner()`**: Displays final results

### **Player Class (Abstract)**
- **`takeTurn(Dice dice)`**: Template method for turn taking
- **`rollDice(Dice dice)`**: Abstract method for dice rolling strategy
- **`moveToPosition(int pos)`**: Updates player position
- **`hasWon()`**: Checks if player reached winning position

### **HumanPlayer Class**
- **`rollDice(Dice dice)`**: Waits for user input before rolling

### **BotPlayer Class**
- **`rollDice(Dice dice)`**: Automatically rolls with thinking delay

### **Board Class**
- **`getNewPosition(int current, int dice)`**: Calculates new position including snakes/ladders
- **`displayBoard()`**: Shows board layout
- **`initializeSnakesAndLadders()`**: Sets up game elements

### **Snake Class**
- **`isAtHead(int position)`**: Checks if position matches snake head

### **Ladder Class**
- **`isAtBottom(int position)`**: Checks if position matches ladder bottom

### **Dice Class**
- **`roll()`**: Returns random number between 1-6

##  Testing the Game

1. **Single Player**: Test with one human player
2. **Multiple Players**: Test with 2-4 human players  
3. **Mixed Players**: Test with human and bot players
4. **Bot Only**: Test with only bot players
5. **Edge Cases**: Test landing on snakes, ladders, and winning conditions

##  Future Enhancements

- Graphical user interface (GUI)
- Network multiplayer support
- Customizable board layouts
- Save/load game functionality
- Player statistics tracking
- Different difficulty levels for bots

##  Notes

- The game uses console input/output for simplicity
- Bot players have a 1-second thinking delay for better user experience
- The board layout is predefined but can be easily modified in the `Board` class
- All SOLID principles and design patterns are clearly implemented and documented
