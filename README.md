# TONG

TONG is a small Java Pong-style arcade game built as a hobby project and learning exercise. It uses Swing to create a simple windowed game, renders the board directly in Java, and demonstrates how a minimal game loop, keyboard input, and sprite-style drawing can be implemented without a larger game engine.

The project is intentionally lightweight and beginner-friendly, with a focus on learning Java game development fundamentals through a classic and recognizable mechanic: paddles, a moving ball, and score tracking.

## Current Features

The current version of the program includes:

- a fixed 800x600 game window
- a black game board with a centered divider line
- a player-controlled paddle on the left side
- an AI-controlled paddle on the right side
- a ball that moves continuously across the screen
- wall bouncing behavior for the top and bottom edges
- score display for both the player and the AI
- keyboard controls using the Up and Down arrow keys
- a 60 FPS-style update loop using Swing's `Timer`

## How the Game Works

The project is built around a single `TongGame` class that extends `JPanel`. That class is responsible for:

- drawing the game scene
- holding the current game state
- updating positions each tick
- listening for keyboard input
- repainting the screen at a regular interval

A `JFrame` hosts the panel, and the application is launched from the `main` method.

## Architecture

The implementation is deliberately simple and compact:

- `TongGame` extends `JPanel` and acts as the game surface
- `paintComponent(Graphics g)` renders the scene
- `actionPerformed(ActionEvent e)` drives the update loop
- `updateGame()` handles movement and basic physics
- `keyPressed()` and `keyReleased()` respond to keyboard input
- `Timer` repeatedly calls the game update code

This gives the project a classic prototype-game structure: state + render + input + loop.

## Game State

The program stores the following values in the class:

- `playerY` — player paddle Y position
- `aiY` — AI paddle Y position
- `ballX` and `ballY` — ball position
- `playerScore` and `aiScore` — current scoreboard values
- `ballVelX` and `ballVelY` — ball velocity in X and Y directions
- `upPressed` and `downPressed` — keyboard state tracking for the player's movement

## Controls

Use the keyboard to move the player paddle:

- Up Arrow: move up
- Down Arrow: move down

## Project Structure

```text
TongGame/
├── README.md
├── bin/
├── lib/
├── src/
│   └── TongGame.java
├── .git/
└── .vscode/
```

## Running the Game

### Requirements

- JDK installed on your machine
- a terminal/command prompt

### Compile

```bash
javac -d bin src/TongGame.java
```

### Run

```bash
java -cp bin TongGame
```

## Notes on the Current Build

This version is still in an early stage of development. It demonstrates the core mechanics of a Pong-like game but does not yet include full gameplay features such as:

- paddle-ball collision handling
- proper AI scoring logic
- server/client architecture or advanced game systems
- menus, sound, or polished visuals

Instead, it focuses on learning Java GUI programming and basic game loop patterns.

## Learning Purpose

This project is primarily a practice project for Java and game development fundamentals. It is useful for exploring:

- Swing GUI construction
- event-driven programming
- rendering graphics with `Graphics2D`
- simple game loops using `Timer`
- input handling with `KeyListener`
- basic game state management

## Credits

Created as a Java-based Pong-inspired learning project by Arsal Abbas Mirza.
