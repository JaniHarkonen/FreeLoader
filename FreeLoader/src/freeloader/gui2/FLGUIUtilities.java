package freeloader.gui2;

import java.awt.BorderLayout;

import javax.swing.JPanel;

/**
 * This class contains utility methods for the GUI-components of FreeLoader
 * and is not to be instantiated.
 * @author Jani Härkönen
 *
 */
public class FLGUIUtilities {

	/**
	 * Private to avoid instantiation.
	 */
	private FLGUIUtilities() {
	}
	
	
	/**
	 * Creates an empty container JPanel with BorderLayout.
	 * @return Returns the container JPanel.
	 */
	public static JPanel createBorderedContainer() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		return container;
	}
}
