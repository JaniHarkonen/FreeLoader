package freeloader.gui2.settings.keyboard;

import freeloader.gui2.FLGUIComponent;
import freeloader.gui2.FLGUIContext;
import freeloader.gui2.settings.FLSettings;
import freeloader.gui2.sub.FLSubDropDownMenu;
import freeloader.robot.actions.keyboard.FLKeyboardKey;
import freeloader.robot.actions.mouse.FLMouseButton;

public abstract class FLSettingsKeyboard extends FLSettings {

		// DROP-DOWN MENU - Keyboard key
	protected FLSubDropDownMenu ddKeyboardKey;
	
	
	protected FLSettingsKeyboard(FLGUIContext c) {
		super(c);
	}
	
	
		// UTILITY: Creates a drop-down menu containing the mouse buttons and automatically
		// stores it in 'ddMouseButton'
	protected void createMouseButtonMenu() {
		FLKeyboardKey act = (FLKeyboardKey) context.get("action");
		ddKeyboardKey = buildMouseButtonMenu(this);
		ddKeyboardKey.dropDownMenu.setSelectedIndex(act.getKeyboardKey());
	}
	
	
		// Builds a drop-down menu containing the mouse buttons and assigns it
		// to a given owner
	public static FLSubDropDownMenu buildMouseButtonMenu(FLGUIComponent o) {
		return new FLSubDropDownMenu(o, "Mouse button:  ", FLMouseButton.BUTTON_CAPTIONS);
	}
	
	
	@Override
	public void updateAction() {
		FLMouseButton act = (FLMouseButton) context.get("action");
		//act.setMouseButton(ddMouseButton.dropDownMenu.getSelectedIndex());
	}
}
