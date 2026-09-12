# TONG

TONG is a Java-based Pong-inspired game built as a hobby project and learning exercise. The current version is a playable prototype that demonstrates core game development concepts in Swing: rendering, input handling, motion, collision checks, AI tracking, and score updates.

This project is intentionally simple and intentionally iterative. It is designed to teach Java fundamentals through a familiar and approachable game structure rather than to mimic a fully polished arcade production.

## Current State of the Game

The program now includes the following features:

- a fixed 800x600 game window
- a black arena with a central divider
- a player paddle on the left side
- an AI-controlled paddle on the right side
- a moving ball with X/Y velocity
- wall collision at the top and bottom of the screen
- paddle collision detection for both paddles
- score counting when the ball passes a paddle
- automatic ball reset after a point is scored
- keyboard movement with the Up and Down arrow keys
- a continuous game loop driven by Swing's `Timer`

## Gameplay Loop

The game loop is centered around a single class, `TongGame`, which extends `JPanel` and implements `ActionListener` and `KeyListener`.

The flow is straightforward:

1. the window is created with a `JFrame`
2. the panel is added to the frame
3. a `Timer` fires every ~16 ms
4. `updateGame()` modifies object positions and states
5. `paintComponent()` redraws the scene
6. keyboard input updates the player's paddle position

This produces a simple but functional game loop suitable for learning real-time game design in Java.

## Architecture and Design

The project is intentionally compact and centered on one file:

- `TongGame.java` contains the full gameplay logic and rendering code
- the class stores game state using instance variables
- moving objects are updated by the `updateGame()` method
- rendering is handled in `paintComponent(Graphics g)`
- keyboard events are handled with `keyPressed()` and `keyReleased()`
- the timer calls `actionPerformed()` repeatedly to drive the simulation

## Core Mechanics

### Player movement

The left paddle moves vertically using the arrow keys:

- Up Arrow: move upward
- Down Arrow: move downward

The player cannot move beyond the top or bottom bounds of the screen.

### AI movement

The right paddle follows the ball's vertical position using a simple tracking algorithm. It moves up or down toward the ball's center, creating a basic opponent that chases the ball.

### Ball physics

The ball uses velocity values for horizontal and vertical motion:

- `ballVelX` controls left/right direction
- `ballVelY` controls up/down movement

The ball bounces off the top and bottom edges and reverses direction when it hits either paddle.

### Scoring

If the ball passes beyond the player or AI side, the opposing side gains a point and the ball resets to the center of the screen. The ball then launches back in the opposite direction with a new velocity.

## Project Structure

```text
TongGame/
├── README.md
├── bin/
├── lib/
├── src/
│   └── TongGame.java
├── .git/
├── .vscode/
└── .idea/
```

## Running the Game

### Prerequisites

- JDK installed on the system
- a terminal or command prompt

### Compile

```bash
javac -d bin src/TongGame.java
```

### Run

```bash
java -cp bin TongGame
```

## Current Limitations

This is still an early-stage learning project and is not yet a polished Pong clone. It does not include:

- a start menu or game-over screen
- sound effects
- advanced AI difficulty tuning
- polished visual effects
- win conditions beyond score tracking
- networked or multiform gameplay

Instead, it focuses on core Java and game logic fundamentals in a compact, understandable format.

## Learning Purpose

TONG exists as a practical Java learning tool and is useful for understanding:

- Swing-based GUI development
- object-oriented game design
- game state management
- event-driven programming
- real-time animation with a timer loop
- simple physics and collision logic
- AI behavior in a basic game environment

## Credits

Developed as a Java Pong-inspired learning project by Arsal Abbas Mirza.