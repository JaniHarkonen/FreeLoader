package freeloader.robot.actions.mouse;

import freeloader.robot.FLRobotContext;
import freeloader.robot.actions.FLRobotAction;

public abstract class FLMouseButton extends FLRobotAction {
	
		// Mouse button captions
	public static String[] BUTTON_CAPTIONS = {"Left", "Middle", "Right"};
	
	
		// Mouse button to listen to (from InputEvent)
	protected int mouseButton;
	
		// Description suffix
	protected String descriptionSuffix;
	

	protected FLMouseButton() {
		super();
		
		mouseButton = 0;
		descriptionSuffix = "";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
	}
	
		// Sets the mouse button to listen to (from InputEvent)
	public void setMouseButton(int mb) {
		mouseButton = mb;
		
		updateDescription();
	}
	
		// Returns the mouse button to listen to (from InputEvent)
	public int getMouseButton() {
		return mouseButton;
	}
	
		// Sets the description of the action by mouse button
	public void updateDescription() {
		setDescription(BUTTON_CAPTIONS[mouseButton] + " " + descriptionSuffix);
	}
}
