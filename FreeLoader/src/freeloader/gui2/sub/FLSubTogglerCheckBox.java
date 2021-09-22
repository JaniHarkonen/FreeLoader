package freeloader.gui2.sub;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIUtilities;

public class FLSubTogglerCheckBox extends FLSubcomponent {
	
		// Whether the checkbox is checked by default
	public static final boolean DEFAULT_SELECTION = false;
	
	
		// Container JPanel
	public JPanel container;
	
		// Toggler JCheckbox
	public JCheckBox toggler;
	

	public FLSubTogglerCheckBox(FLGUIComponent o, String t, Component c, boolean isinv) {
		super(o);
		
		container = FLGUIUtilities.createLineContainer();
		toggler = new JCheckBox(t);
		toggler.setSelected((c != null) ? c.isEnabled() ^ isinv : DEFAULT_SELECTION);
		toggler.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if( c == null ) return;
				
				if( isinv == false ) c.setEnabled(toggler.isSelected());
				else				 c.setEnabled(!toggler.isSelected());
			}
		});
	}
	
		// CheckBox with no slave component
	public FLSubTogglerCheckBox(FLGUIComponent o, String t, boolean issel) {
		super(o);
		container = FLGUIUtilities.createLineContainer();
		toggler = new JCheckBox(t);
		toggler.setSelected(issel);
	}
	
	
	@Override
	public JPanel render() {
		container.add(toggler);
		return container;
	}
}
