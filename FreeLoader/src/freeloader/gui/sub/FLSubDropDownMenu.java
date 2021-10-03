package freeloader.gui.sub;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIUtilities;

public class FLSubDropDownMenu extends FLSubcomponent {

		// Container JPanel 
	public JPanel container;
	
		// Title JLabel
	public JLabel title;
	
		// Drop-down menu JComboBox
	public JComboBox<String> dropDownMenu;
	
	
	public FLSubDropDownMenu(FLGUIComponent o, String t, String[] c) {
		super(o);
		container = FLGUIUtilities.createLineContainer();
		title = new JLabel(t);
		dropDownMenu = new JComboBox<String>(c);
		dropDownMenu.setSelectedIndex(0);
		dropDownMenu.setMaximumSize(new Dimension(Integer.MAX_VALUE, dropDownMenu.getPreferredSize().height));
	}
	
	
	@Override
	public JPanel render() {
		container.add(title);
		container.add(dropDownMenu);
		container.setMaximumSize(new Dimension(Integer.MAX_VALUE, container.getPreferredSize().height));
		return container;
	}
}
