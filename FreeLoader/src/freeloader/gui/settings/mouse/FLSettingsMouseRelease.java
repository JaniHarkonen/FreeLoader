package freeloader.gui.settings.mouse;

import javax.swing.JPanel;

import freeloader.gui.FLGUIContext;

public class FLSettingsMouseRelease extends FLSettingsMouse {
	
	public FLSettingsMouseRelease(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	protected JPanel draw() {
		JPanel container = createSettingsContainer();
		createMouseButtonMenu();
		container.add(ddMouseButton.render());
		return container;
	}
	
	@Override
	public void updateAction() {
		super.updateAction();
	}
}
