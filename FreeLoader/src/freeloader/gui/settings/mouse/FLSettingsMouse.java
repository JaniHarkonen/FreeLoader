package freeloader.gui.settings.mouse;

import freeloader.gui.FLGUIComponent;
import freeloader.gui.FLGUIContext;
import freeloader.gui.settings.FLSettings;
import freeloader.gui.sub.FLSubDropDownMenu;
import freeloader.robot.actions.mouse.FLMouseButton;

public abstract class FLSettingsMouse extends FLSettings {

		// DROP-DOWN MENU - Mouse button
	protected FLSubDropDownMenu ddMouseButton;
	
	
	protected FLSettingsMouse(FLGUIContext c) {
		super(c);
	}
	
	
		// UTILITY: Creates a drop-down menu containing the mouse buttons and automatically
		// stores it in 'ddMouseButton'
	protected void createMouseButtonMenu() {
		FLMouseButton act = (FLMouseButton) context.get("action");
		ddMouseButton = buildMouseButtonMenu(this);
		ddMouseButton.dropDownMenu.setSelectedIndex(act.getMouseButton());
	}
	
	
		// Builds a drop-down menu containing the mouse buttons and assigns it
		// to a given owner
	public static FLSubDropDownMenu buildMouseButtonMenu(FLGUIComponent o) {
		return new FLSubDropDownMenu(o, "Mouse button:  ", FLMouseButton.BUTTON_CAPTIONS);
	}
	
	
	@Override
	public void updateAction() {
		FLMouseButton act = (FLMouseButton) context.get("action");
		act.setMouseButton(ddMouseButton.dropDownMenu.getSelectedIndex());
	}
}
