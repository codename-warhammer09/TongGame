/* ======= TONG =======
 A simple game based on the classic
 A hobby project. Mainly written
 During the Night of 12.09.2026 in Java
 and compiled using JDK 25.
 Developed by Arsal Abbas Mirza */
 
 import javax.swing.JFrame; //JFrame is the engine for our UI. It is the easel.
 import javax.swing.JPanel; // The canvas on which we shall paint.
 import java.awt.Color; // If u don't want ts to be colorblind. :sob:
 import java.awt.Dimension; // obviously. We gotta be able to have a conception of all this.
 import java.awt.Graphics; // The brush. The paintbrush. The paintbrush of Tong.
 import java.awt.Graphics2D; // How else u gon make ts render?
 import java.awt.RenderingHints; // So ts doesn't look like poo.
 import java.awt.Font; // For the text. The text of Tong. P.S. This Tong thing is hilarious.
 import java.awt.event.ActionListener; // For the timer. The timer of Tong. Okay fine, ts is starting to get old
 import java.awt.event.ActionEvent; // TONG. Yea, this one also has to do with the Timer. The Timer of Tong. I think I should stop now. 
 import javax.swing.Timer; // Finally, The Timer of Tong. Ugghhh, fine.
 import java.awt.event.KeyListener; // So u can play with yo keyboard
 import java.awt.event.KeyEvent; // So it knows what a Key event, like a press even is.
 
 public class TongGame extends JPanel implements ActionListener, KeyListener {
	 // Set Resolution Constants
	 private static final int WIDTH = 800;
	 private static final int HEIGHT = 600;
     // Game Object State variables with the starting values initialized.
     private int playerY = 250; // starting position of player paddle
     private int aiY = 250; // starting position of pesky AI paddle
     private int ballX = 392; // starting x position of ball
     private int ballY = 292; // starting y position of ball
     private int playerScore = 0; // Gotta keep score
     private int aiScore = 0; // Pesky AI's score.
     private int ballVelX = 2; // Ball's X Speed
     private int ballVelY = 2; // Ball's Y Speed
     // The Actual Rendering of the Game. The Code that draws the whole Panel and stuff.
     @Override
     protected void paintComponent(Graphics g){
        super.paintComponent(g); // So it keeps clearing background automatically
        // Back in the day, I used to have to do this with a loop that called 'cls' in a console.
        // Cool stuff in Java, definitely. Now we can just call ts and it works the same.
        Graphics2D g2 = (Graphics2D) g; // Cast to Graphics2D cuz that guy is the goat.
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Again, So it doesn't look like poo.

        // Now to draw the center Net.
        g2.setColor(Color.DARK_GRAY);
        for (int i = 0; i < HEIGHT; i += 30) {
            g2.fillRect(WIDTH / 2 - 2, i, 4, 15); // And we have a net.
        }
        // Now we go ballin and draw the paddles and za ball.
        g2.setColor(Color.WHITE);
        g2.fillRect(30, playerY, 15, 100); // Our beloved Player Paddle 
        g2.fillRect(WIDTH - 45, aiY, 15, 100); // Pesky AI Paddle
        g2.fillOval(ballX, ballY, 15, 15); // Za Ball
        // Now we gotta draw scores, boi. Cuz we gotta keep score
        // How gangsta, amirite? Very Tong.
        g2.setFont(new Font("Monospaced", Font.BOLD, 40));
        g2.drawString(String.valueOf(playerScore), WIDTH / 4, 50);
        g2.drawString(String.valueOf(aiScore), 3 * WIDTH / 4, 50);
     }
    // Boolean flags for when the player presses the up or down keys. This is so we can move the paddle nice and buttery.
     private boolean upPressed = false; // Player Paddle Up Key State
     private boolean downPressed = false; // Player Paddle Down Key State
    
	public TongGame(){
	// Sets Console Screen Size and Color using our constants for Dims.
	 this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	 this.setBackground(Color.BLACK);
	 // 16 ms delay = 60 FPS
     Timer timer = new Timer(16, this);
     timer.start();
     
     this.setFocusable(true); // To Allow JPanel to accept keyboard inputs 
     this.addKeyListener(this); // Registers the class so it can start listening if any keys start gettingmashed.
 }
 // Called every 16 ms (60 Frames) by the Timer
@Override 
public void actionPerformed(ActionEvent e){
    updateGame(); // Updates the game state based on what just happened.
    repaint(); // Calls paintComponent to redraw the game
}
private void updateGame(){
    // Player Paddle Movement
    if (upPressed && playerY > 0) playerY -= 7; // Move up
    if (downPressed && playerY < HEIGHT - 100) playerY += 7; // Move down

    // Ball Tracking pesky AI. The (pesky) AI of Tong.
    int aiCenter = aiY + 50; // Center of AI paddle
    if (aiCenter < ballY && aiY < HEIGHT - 100) aiY += 4; // Move AI paddle down. 
    // Moves slower so you have a fighting chance.
    else if (aiCenter > ballY && aiY > 0) aiY -= 4; // Move AI paddle up

    // Programmed Motion of the Ball. Basics Physics. Physics of Tong.
    // Okay, I'll see myself out.
    ballX += ballVelX; // Move the ball in X direction
    ballY += ballVelY; // Move the ball in Y direction

    // Bounce off top and bottom wall, but do not bounce off left/right walls.
    // Those edges are where scoring happens in Pong.
    if (ballY <= 0 || ballY >= HEIGHT - 15) {
        ballVelY *= -1;
        ballY = Math.max(0, Math.min(ballY, HEIGHT - 15));
    }

    // NOW FOR PADDLE COLLISIONS!!
    // Player Paddle Collision
    if (ballX <= 45 && ballY + 15 >= playerY && ballY <= playerY + 100) {
        ballVelX = Math.abs(ballVelX); // Bounce off player paddle
        ballX = 45;
    }
    if (ballX + 15 >= WIDTH - 45 && ballY + 15 >= aiY && ballY <= aiY + 100) {
        ballVelX = -Math.abs(ballVelX); // Bounce off AI paddle
        ballX = WIDTH - 60;
    }

    // Now for some mild scoring. Cuz we gotta keep score, boiz.
    if (ballX < 0) { // Player missed the ball
        aiScore++;
        resetBall();
        return;
    }
    else if (ballX > WIDTH - 15) { // AI missed the ball
        playerScore++;
        resetBall();
        return;
    }
}
private void resetBall(){
    ballX = WIDTH / 2 - 7; // Reset ball position
    ballY = HEIGHT / 2 - 7;
    ballVelX = (ballVelX > 0) ? -5 : 5; // Reset ball velocity
}

@Override 
public void keyPressed(KeyEvent e){
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_UP) upPressed = true; // Up Key Pressed
    if (code == KeyEvent.VK_DOWN) downPressed = true; // Down Key Pressed
}
@Override
public void keyReleased(KeyEvent e){
    int code = e.getKeyCode();
    if (code == KeyEvent.VK_UP) upPressed = false; // Up Key Released
    if (code == KeyEvent.VK_DOWN) downPressed = false; // Down Key Released
}
@Override 
public void keyTyped(KeyEvent e){
    // Not used, but required by KeyListener interface. 
    // important for Tong purposes.
}
public static void main(String[] args){
	 JFrame frame = new JFrame("Tong");
	 TongGame game = new TongGame();
	 // Now we have a new instance of Tong.
	 frame.add(game);
	 frame.pack();
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // JFrame has to exit once the user closes the window.
	 frame.setLocationRelativeTo(null); // Where the window'll be placed - null means it'll be centered on screen.
	 frame.setResizable(false); // Window Can't be resized by the user.
	 frame.setVisible(true); // Duh, it has to be visible. So this makes sure it is set as.
  }
 }