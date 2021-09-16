package freeloader.gui.settings;

import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import freeloader.FLAppContext;
import freeloader.gui.settings.keyboard.FLSettingsKeyHold;
import freeloader.gui.settings.keyboard.FLSettingsKeyPress;
import freeloader.gui.settings.keyboard.FLSettingsKeyRelease;
import freeloader.gui.settings.mouse.FLSettingsMouseClick;
import freeloader.gui.settings.mouse.FLSettingsMouseHold;
import freeloader.gui.settings.mouse.FLSettingsMouseMove;
import freeloader.gui.settings.mouse.FLSettingsMouseRelease;
import freeloader.gui.settings.mouse.FLSettingsMouseScroll;
import freeloader.gui.window.FLElement;
import freeloader.robot.actions.FLActionExec;
import freeloader.robot.actions.FLActionWait;
import freeloader.robot.actions.FLRobotAction;
import freeloader.robot.actions.keyboard.FLActionKeyHold;
import freeloader.robot.actions.keyboard.FLActionKeyPress;
import freeloader.robot.actions.keyboard.FLActionKeyRelease;
import freeloader.robot.actions.mouse.FLActionMouseClick;
import freeloader.robot.actions.mouse.FLActionMouseHold;
import freeloader.robot.actions.mouse.FLActionMouseMove;
import freeloader.robot.actions.mouse.FLActionMouseRelease;
import freeloader.robot.actions.mouse.FLActionMouseScroll;

public abstract class FLSettings extends FLElement {

		// The action whose settings are in question
	protected FLRobotAction underlyingAction;
	
	
	protected FLSettings(FLAppContext host, FLRobotAction src) {
		super(host);
		
		underlyingAction = src;
	}
	
	protected FLSettings(FLAppContext host) {
		this(host, null);
	}
	
	
		// Returns the JPanel representing the GUI of the settings
		// (TO BE OVERRIDDEN)
	public JPanel getElement() {
		return null;
	}
	
		// The method to be performed upon changing the settings of the
		// underlying action
		// (TO BE OVERRIDDEN)
	public void updateAction(Object o) {
	}
	
		// Sets the underlying action
	public void setAction(FLRobotAction act) {
		underlyingAction = act;
	}
	
		// Returns the underlying action
	public FLRobotAction getAction() {
		return underlyingAction;
	}
	
		// Returns the description for the underlying action
	public String getUnderlyingDescription() {
		return underlyingAction.getDescription();
	}
	
	
		// Builds a settings object for a given RobotAction
	public static FLSettings buildSettings(FLRobotAction src, FLAppContext host) {
		if( src == null ) return null;
		FLSettings sets = null;
		
		if( src instanceof FLActionMouseMove ) return new FLSettingsMouseMove(host, src);
		if( src instanceof FLActionMouseClick ) return new FLSettingsMouseClick(host, src);
		if( src instanceof FLActionMouseHold ) return new FLSettingsMouseHold(host, src);
		if( src instanceof FLActionMouseRelease ) return new FLSettingsMouseRelease(host, src);
		if( src instanceof FLActionMouseScroll ) return new FLSettingsMouseScroll(host, src);
		if( src instanceof FLActionKeyPress ) return new FLSettingsKeyPress(host, src);
		if( src instanceof FLActionKeyHold ) return new FLSettingsKeyHold(host, src);
		if( src instanceof FLActionKeyRelease ) return new FLSettingsKeyRelease(host, src);
		if( src instanceof FLActionWait ) return new FLSettingsWait(host, src);
		if( src instanceof FLActionExec ) return new FLSettingsExec(host, src);
		
		return sets;
	}
	
		// UTILITY: Creates the default wrapper for the settings
	protected JPanel createSettingsWrapper() {
		JPanel wrapper = createSettingsPane("Action: " + getUnderlyingDescription());
		wrapper.add(new JLabel(" "));
		
		return wrapper;
	}
	
		// UTILITY: Create a settings pane with a title
	public static JPanel createSettingsPane(String title) {
		JPanel wrapper = createPageWrapper();
		wrapper.setBorder(BorderFactory.createTitledBorder(title));
		
		return wrapper;
	}
	
		// UTILITY: Creates a BoxLayout wrapper of a given type
		// (BoxLayout.LINE_AXIS, BoxLayout.PAGE_AXIS)
	public static JPanel createBoxWrapper(int blayout) {
		JPanel wrapper = new JPanel();
		wrapper.setLayout(new BoxLayout(wrapper, blayout));
		wrapper.setAlignmentX(0);
		
		return wrapper;
	}
	
		// UTILITY: Creates a BoxLayout page wrapper
	public static JPanel createPageWrapper() {
		return createBoxWrapper(BoxLayout.PAGE_AXIS);
	}
	
		// UTILITY: Creates a BoxLayout line wrapper
	public static JPanel createLineWrapper() {
		return createBoxWrapper(BoxLayout.LINE_AXIS);
	}
	
		// (DERIVED) UTILITY: Creates an enabled JTextField with a label
	public static JPanel createInputField(String lab) {
		return createInputField(lab, true);
	}
	
		// UTILITY: Creates a JTextField with a label and default maximum width
	public static JPanel createInputField(String lab, boolean enabled) {
		return createInputField(lab, enabled, Integer.MAX_VALUE);
	}
	
		// UTILITY: Creates a JTextField with a label with a given maximum width
	public static JPanel createInputField(String lab, boolean enabled, int max_width) {
		JPanel input = createLineWrapper();
		
		input.add(new JLabel(lab));
		JTextField tf = new JTextField(10);
		tf.setEnabled(enabled);
		tf.setMaximumSize(new Dimension(max_width, tf.getPreferredSize().height));
		input.add(tf);
		input.setMaximumSize(new Dimension(Integer.MAX_VALUE, input.getPreferredSize().height));
		return input;
	}
	
		// UTILITY: Creates a JTextField and a JCheckbox that enables it
	public static JPanel createToggleableInputField(String inp_lab, String chk_lab, boolean enabled, boolean inverse) {
		JPanel input = createInputField(inp_lab, enabled);
		
		JCheckBox check = new JCheckBox(chk_lab);
		check.setSelected(enabled ^ inverse);
		check.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				JTextField tf = FLSettings.getTextFieldFromInputField(input);
				tf.setEnabled(!tf.isEnabled());
			}
		});
		
		input.add(check);
		return input;
	}
	
		// UTILITY: Returns a reference to the JTextField of an input field
		// created with 'createInputField'
	public static JTextField getTextFieldFromInputField(JPanel jp) {
		return (JTextField) jp.getComponents()[1]; 
	}
	
		// (DERIVED) UTILITY: Adds a single empty space to a JPanel
		// (based on createEmptySpace(JPanel, int)
	public static void addEmptySpace(JPanel dest) {
		addEmptySpace(dest, 1);
	}
	
		// UTILITY: Adds a given number of " "-JLabels to a given JPanel
		// to create empty spaces
	public static void addEmptySpace(JPanel dest, int n) {
		for( int i = 0; i < n; i++ )
		dest.add(new JLabel(" "));
	}
	
		// (DERIVED) UTILITY: Creates a drop menu with default with
	public static JPanel createDropMenu(String lab, String[] choices) {
		return createDropMenu(lab, choices, Integer.MAX_VALUE);
	}
	
		// UTILITY: Creates a JComboBox with a label in front
	public static JPanel createDropMenu(String lab, String[] choices, int max_width) {
		JPanel menu = createLineWrapper();
		
		menu.add(new JLabel(lab));
		JComboBox cb = new JComboBox(choices);
		cb.setSelectedIndex(0);
		cb.setMaximumSize(new Dimension(max_width, cb.getPreferredSize().height));
		
		menu.add(cb);
		menu.setMaximumSize(new Dimension(Integer.MAX_VALUE, menu.getPreferredSize().height));
		return menu;
	}
	
		// UTILITY: Extracts the JComboBox from a drop menu created with
		// 'createDropMenu'
	public static JComboBox getComboBoxFromDropMenu(JPanel jp) {
		return (JComboBox) jp.getComponents()[1];
	}
}
