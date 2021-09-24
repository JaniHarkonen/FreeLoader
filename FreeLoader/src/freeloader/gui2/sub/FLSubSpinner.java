package freeloader.gui2.sub;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIUtilities;

public class FLSubSpinner extends FLSubcomponent {

		// Container JPanel
	public JPanel container;
	
		// Title JLabel
	public JLabel title;
	
		// Selection JSpinner
	public JSpinner spinner;
	
	
	public FLSubSpinner(FLGUIComponent c, String t, SpinnerModel spmod) {
		super(c);
		container = FLGUIUtilities.createLineContainer();
		title = new JLabel(t);
		spinner = new JSpinner();
		spinner.setModel(spmod);
		spinner.setMaximumSize(new Dimension(Integer.MAX_VALUE, spinner.getPreferredSize().height));
	}
	
	@Override
	public JPanel render() {
		container.add(title);
		container.add(spinner);
		
		return container;
	}
}
