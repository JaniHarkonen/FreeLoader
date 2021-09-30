package freeloader.gui2.settings.keyboard;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;

public class FLSettingsKeyRelease extends FLSettingsKeyboard {
	
	public FLSettingsKeyRelease(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel render() {
		JPanel container = createSettingsContainer();
		
		createKeyboardKeyMenu();
		container.add(ddKeyboardKey.render());
		
		return container;
	}
	
	@Override
	public void updateAction() {
		super.updateAction();
	}
}
