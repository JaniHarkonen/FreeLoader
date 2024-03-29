package freeloader.gui.sub;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIUtilities;

public class FLSubInputField extends FLSubcomponent {
	
		// Default input field width
	public static final int DEFAULT_WIDTH = 96;
	
	
		// Container JPanel
	public JPanel container;
	
		// Title JLabel
	public JLabel title;
	
		// Reference to the JTextField
	public JTextField textField;
	
	
	public FLSubInputField(FLGUIComponent o, String t) {
		super(o);
		container = FLGUIUtilities.createLineContainer();
		title = new JLabel(t);
		textField = new JTextField(10);
		textField.setMaximumSize(new Dimension(DEFAULT_WIDTH, textField.getPreferredSize().height));
	}
	
	
	@Override
	public JPanel render() {
		container.add(title);
		container.add(textField);
		container.setMaximumSize(new Dimension(Integer.MAX_VALUE, container.getPreferredSize().height));
		
		return container;
	}
}
