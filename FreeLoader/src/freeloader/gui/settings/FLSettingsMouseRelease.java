package freeloader.gui.settings;

import javax.swing.JButton;
import javax.swing.JPanel;

import freeloader.FLAppContext;

public class FLSettingsMouseRelease extends FLSettings {
	
	public FLSettingsMouseRelease(FLAppContext host) {
		super(host);
	}
	

	@Override
	public JPanel getElement() {
		JPanel wrapper = createWrapper();
		
		JButton btn = new JButton("LOL");
		
		wrapper.add(btn);
		return wrapper;
	}
}
