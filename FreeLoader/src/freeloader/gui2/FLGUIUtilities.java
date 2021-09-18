package freeloader.gui2;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import freeloader.gui2.settings.FLSettings;
import freeloader.gui2.settings.mouse.FLSettingsMouseClick;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.mouse.FLActionMouseClick;

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
	 * Builds a settings panel for a given robot action.
	 * @param act Action the panel is derived from.
	 * @return Settings panel based on the action.
	 */
	public static FLSettings buildSettings(FLRobotAction src) {
		if( src == null ) return null;
		FLGUIContext ctxt = new FLGUIContext();
		ctxt.put("action", src);
		
		if( src instanceof FLActionMouseClick ) return new FLSettingsMouseClick(ctxt);
		
		/*if( src instanceof FLActionMouseMove ) return new FLSettingsMouseMove(host, src);
		if( src instanceof FLActionMouseClick ) return new FLSettingsMouseClick(host, src);
		if( src instanceof FLActionMouseHold ) return new FLSettingsMouseHold(host, src);
		if( src instanceof FLActionMouseRelease ) return new FLSettingsMouseRelease(host, src);
		if( src instanceof FLActionMouseScroll ) return new FLSettingsMouseScroll(host, src);
		if( src instanceof FLActionKeyPress ) return new FLSettingsKeyPress(host, src);
		if( src instanceof FLActionKeyHold ) return new FLSettingsKeyHold(host, src);
		if( src instanceof FLActionKeyRelease ) return new FLSettingsKeyRelease(host, src);
		if( src instanceof FLActionWait ) return new FLSettingsWait(host, src);
		if( src instanceof FLActionExec ) return new FLSettingsExec(host, src);*/
		
		return null;
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
	
	/**
	 * Creates an empty container JPanel with BoxLayout along a given axis.
	 * @param blayout Axis along which the elements within are to be placed.
	 * Can be one of: BoxLayout.X_AXIS, BoxLayout.Y_AXIS,BoxLayout.LINE_AXIS or BoxLayout.PAGE_AXIS
	 * 
	 * @return Returns the container JPanel.
	 */
	public static JPanel createBoxContainer(int blayout) {
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, blayout));
		container.setAlignmentX(0);
		
		return container;
	}
	
	/**
	 * Creates an empty container JPanel with BoxLayout where the contents
	 * will be stacked along the Y-axis.
	 * @return Returns the container JPanel.
	 */
	public static JPanel createPageContainer() {
		return createBoxContainer(BoxLayout.PAGE_AXIS);
	}
	
	/**
	 * Creates an empty container JPanel with BoxLayout where the contents
	 * will be stacked along the Y-axis.
	 * @return Returns the container JPanel.
	 */
	public static JPanel createLineContainer() {
		return createBoxContainer(BoxLayout.LINE_AXIS);
	}
	
	/**
	 * Creates a JPanel containing a settings pane with a titled border.
	 * @param title Title to be displayed over the pane.
	 * @return Returns the container JPanel.
	 */
	public static JPanel createSettingsPane(String title) {
		JPanel container = createPageContainer();
		container.setBorder(BorderFactory.createTitledBorder(title));
		
		return container;
	}
	
	/**
	 * Adds a given number of empty spaces in to a JPanel using single-spaced
	 * JLabels ( new JLabel(" ") ).
	 * @param dest JPanel to add the empty spaces to.
	 * @param n Number of empty spaces to add.
	 */
	public static void addEmptySpace(JPanel dest, int n) {
		if( dest == null ) return;
		
		for( int i = 0; i < n; i++ ) dest.add(new JLabel(" "));
	}
	
	/**
	 * Adds a single empty space to a given JPanel.
	 * (see addEmptySpace(JPanel, int)
	 * @param dest JPanel to add the empty spaces to.
	 */
	public static void addEmptySpace(JPanel dest) {
		addEmptySpace(dest, 1);
	}
}
