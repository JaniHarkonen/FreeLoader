package freeloader.gui2.settings.mouse;

import javax.swing.JPanel;

import freeloader.gui2.FLGUIContext;

public class FLSettingsMouseRelease extends FLSettingsMouse {
	
	public FLSettingsMouseRelease(FLGUIContext c) {
		super(c);
	}
	
	
	@Override
	public JPanel render() {
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
