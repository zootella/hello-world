package org.limewire.hello.project;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/** The program's Content object is the contents of the window. */
public class Content {

	/** Margin space used in layout. */
	public static final int space = 6;

	/** The Swing JPanel object that is in the window and holds the contents. */
	private JPanel panel;

	/** The Swing JButton object that is the button titled "Snippet" at the top of the window. */
	private JButton button;

	/** The Swing JTextArea object that is the large text box beneath the button in the window. */
	private JTextArea textArea;

	/** Make a new Content object to hold the contents of the program's window. */
	public Content() {

		// Make our Swing JPanel object, and set it up for GridBagLayout
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c;

		// Prepare GridBagConstraints for the "Snippet" button at the top
		c = new GridBagConstraints();
		c.gridx = 0; // The button is in location 0, 0 in the grid
		c.gridy = 0;
		c.gridwidth = 1; // The button takes up one grid cell
		c.gridheight = 1;
		c.weightx = 1.0; // When the window gets wider, so should the space the button takes up
		c.weighty = 0.0; // When the window gets taller, the space the button takes up shouldn't grow
		c.anchor = GridBagConstraints.NORTHWEST; // Pin the button to the upper left corner
		c.insets = new Insets(space, space, space, space); // Put some space around it
		c.fill = GridBagConstraints.NONE; // Don't stretch the button to fill its cell in the grid

		// Make the "Snippet" button, and add it to our JPanel
		button = new JButton(new SnippetAction()); // Make a SnippetAction object, defined below
		panel.add(button, c);

		// Prepare GridBagConstraints for the text area beneath the button
		c = new GridBagConstraints();
		c.gridx = 0; // The text area is at 0, 1 in the grid
		c.gridy = 1;
		c.gridwidth = 1; // The text area takes up one grid cell
		c.gridheight = 1;
		c.weightx = 1.0; // When the window grows, so does the text area
		c.weighty = 1.0;
		c.anchor = GridBagConstraints.NORTHWEST;
		c.insets = new Insets(0, space, space, space); // Don't insert space at the top
		c.fill = GridBagConstraints.BOTH; // Stretch the text area to fill its grid cell

		// Make the text area
		textArea = new JTextArea();
		textArea.setEditable(false); // Make it read-only
		JScrollPane scrollPane = new JScrollPane(textArea,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // Put it in a JScrollPane
		panel.add(scrollPane, c); // Add it to our JPanel
	}

	/** Get this Content object's Swing JPanel that has the controls on it. */
	public JPanel getPanel() {
		return panel; // Return a reference to the JPanel object we made
	}

	/** The Action behind the "Snippet" button at the top of the window. */
	private class SnippetAction extends AbstractAction {

		/** Make a new SnippetAction object. */
		public SnippetAction() {
			super("Snippet"); // This is the name that will show up on the button
		}

		// When the user clicks the Snippet button, Java calls this method
		public void actionPerformed(ActionEvent a) {

			// Run our snippet of code in the Snippet.snippet() method
			Snippet.snippet();
		}
	}

	/** Show the given String message in the text area. */
	public void report(String s) {
		textArea.append(s + "\n"); // Add the given text and a newline to the end of what's already in the text box
		textArea.setCaretPosition(textArea.getDocument().getLength()); // Scroll to the bottom
	}
}
