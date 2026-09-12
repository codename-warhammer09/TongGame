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


 
 public class TongGame extends JPanel {
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
	public TongGame(){
	// Sets Console Screen Size and Color using our constants for Dims.
	 this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
	 this.setBackground(Color.BLACK);
	 
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