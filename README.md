# TONG

**Latest release: v1.13**

TONG is a Java Swing Pong-style game developed as a personal learning project. It is a lightweight arcade prototype built to explore the fundamentals of Java game development, including rendering, keyboard input, collision detection, state management, and real-time animation.

The project is intentionally simple and deliberately iterative. Rather than aiming for a polished commercial game, it focuses on learning by building a recognizable game loop around classic Pong mechanics.

## What the game does

The current program includes:

- a fixed 800x600 game window
- a black playfield with a center divider
- a left-side player paddle controlled with the keyboard
- a right-side AI paddle that tracks the ball
- a moving ball with directional velocity
- top and bottom wall collision
- paddle collision detection
- score tracking for both sides
- a win condition at 10 points
- a game-over screen with restart support
- a real-time update loop using a Swing `Timer`

## Gameplay overview

The player controls the paddle on the left side using the Up and Down arrow keys. The AI paddle tracks the ball and tries to block it. The ball bounces off walls and paddles, and each time it passes a paddle, the other side is awarded a point.

Once either player reaches the winning score, the game enters a game-over state and displays a result message. Pressing any key restarts the match.

## Architecture

The game is built around a single `TongGame` class that extends `JPanel` and implements `ActionListener` and `KeyListener`.

This compact structure keeps the project easy to follow while still demonstrating many common game-programming patterns:

- `paintComponent(Graphics g)` handles rendering
- `actionPerformed(ActionEvent e)` drives the game loop
- `updateGame()` updates object positions and logic
- `keyPressed()` and `keyReleased()` handle keyboard state
- instance variables store the current game state, positions, and scores

## Main mechanics

### Player movement

The player paddle moves vertically within the screen bounds using the arrow keys.

### AI behavior

The AI paddle follows the ball's Y position with a simple tracking algorithm. It moves toward the ball but remains slower than the player's input, giving the player a fair challenge.

### Ball physics

The ball has separate X and Y velocities. It bounces off the top and bottom edges and changes direction when hitting either paddle. The collision logic also slightly alters the vertical speed based on impact position, creating a more dynamic feel.

### Scoring and restart

When the ball goes past the left or right edge:

- the opposing side gains a point
- if the score reaches 10, the game ends
- otherwise, the ball is reset to the center and play continues

After a win or loss, any key press resets the game.

## Project structure

```text
TongGame/
├── TongGame.jar
├── README.md
├── bin/
├── lib/
├── src/
│   └── TongGame.java
├── .git/
├── .vscode/
└── .idea/
```

## Running the game

### Requirements

- Java Runtime Environment (JRE) or JDK installed

### v1.13 clickable executable release

Version `v1.13` is distributed as a clickable executable JAR: `TongGame.jar`. Double-click the `.jar` file to launch the game directly, provided Java is installed and `.jar` files are associated with Java on your system.

You can also launch the release from a terminal with:

```bash
java -jar TongGame.jar
```

This release does not require compiling the source first.

### Compile from source

To compile the source version yourself, use a Java Development Kit (JDK):

```bash
javac -d bin src/TongGame.java
```

Then run the compiled classes with:

```bash
java -cp bin TongGame
```

## Learning goals

This project is primarily a practice tool for Java and beginner-friendly game development. It helps explore:

- Swing GUI programming
- event-driven input handling
- object-oriented code organization
- real-time update loops
- collision logic and physics basics
- game state transitions
- AI behavior in simple arcade games

## Current limitations

This is still an early prototype and is intentionally unfinished. It does not yet include:

- sound effects
- menus or start screens
- polished art assets
- advanced multiplayer systems
- more sophisticated game balancing
- networking or external libraries

## Credits

Created as a Java Pong-inspired learning project by Arsal Abbas Mirza.
