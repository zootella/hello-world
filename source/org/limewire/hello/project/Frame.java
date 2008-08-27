package org.limewire.hello.project;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;

/** The Frame object is the program's window on the screen. */
public class Frame {

	/** The Java JFrame object which is the window on the screen. */
	private JFrame frame;

	/** The contents of the frame, like the panel, button, and text area. */
	private Content content;

	/** Make a new Frame object to hold a JFrame and put it on the screen. */
	public Frame() {

		// Choose how big the window will be, and where it will appear on the screen
		int w, h, x, y; // Variables for the window's width, height, and x and y position on the screen, in pixels
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // Find out the screen's resolution in pixels
		w = screenSize.width / 2; // Make the window fill a quarter of the screen
		h = screenSize.height / 2;
		Random random = new Random(); // Make a random number generator
		x = (screenSize.width / 8) + random.nextInt(screenSize.width / 4); // Place the window randomly near the middle of the screen
		y = (screenSize.height / 8) + random.nextInt(screenSize.height / 4);

		// Make the program's window, configure it, and show it
		frame = new JFrame();                                    // Make the Swing JFrame object which is the window on the screen
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Make closing the window close the program
		frame.setTitle("Hello Project");                         // Set the text in the window's title bar
		frame.setLocation(x, y);                                 // Set the window's position and size from what we calculated above
		frame.setSize(w, h);

		// Add window contents
		content = new Content(); // Make a new Content object, and save a reference to it here
		frame.setContentPane(content.getPanel()); // Ask our new Content object for its JPanel, and give the JPanel to our JFrame

		// Show the window on the screen
		frame.setVisible(true);
	}

	/** Show the given String message in the program window. */
	public void report(String message) {
		content.report(message); // Have our Content object do it
	}
}
