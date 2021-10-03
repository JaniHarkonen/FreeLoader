package freeloader.gui.settings.keyboard;

import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;

public class FLSettingsKeyRelease extends FLSettingsKeyboard {
	
	public FLSettingsKeyRelease(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	protected JPanel draw() {
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
