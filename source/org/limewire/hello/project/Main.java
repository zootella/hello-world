package org.limewire.hello.project;

import javax.swing.SwingUtilities;

/** The program's Main class, containing its main() method. */
public class Main {

	// When the program runs, Java calls this main() method
	public static void main(String[] arguments) {

		// Have the normal Swing thread call this run() method
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				// Make the Frame object which puts the window on the screen
				frame = new Frame(); // And save a reference to it here
			}
		});
	}

	/**
	 * A reference to the program's Frame object, which is the window on the screen.
	 * null when the program is just starting and hasn't saved it yet.
	 */
	private static Frame frame;

	/** Show the given String message in standard output and in the program window. */
	public static void report(String message) {

		// Show it on the command line
		System.out.println(message);

		// If we've made our window, show it there, too
		if (frame != null) frame.report(message);
	}
}
