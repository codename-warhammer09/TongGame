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