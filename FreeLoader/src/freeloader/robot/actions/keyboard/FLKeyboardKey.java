package freeloader.robot.actions.keyboard;

import java.awt.event.KeyEvent;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.FLRobotAction;

public abstract class FLKeyboardKey extends FLRobotAction {
	
		// Key to listen to (from KeyEvent)
	protected int keyboardKey;
	
		// Description suffix
	protected String descriptionSuffix;
	

	protected FLKeyboardKey() {
		super();
		
		keyboardKey = -1;
		descriptionSuffix = "";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
	}
	
		// Sets the key to listen to (from KeyEvent)
	public void setKeyboardKey(int key) {
		keyboardKey = key;
		
		updateDescription();
	}
	
		// Sets the description of the action by mouse button
	public void updateDescription() {
		setDescription(KeyEvent.getKeyText(keyboardKey) + " " + descriptionSuffix);
	}
}
