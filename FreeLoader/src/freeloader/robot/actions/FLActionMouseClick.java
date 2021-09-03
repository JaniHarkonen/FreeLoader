package freeloader.robot.actions;

import java.awt.Robot;

import freeloader.robot.FLRobotContext;

public class FLActionMouseClick extends FLRobotAction {
	
		// Mouse button captions
	public static String[] BUTTON_CAPTIONS = {"Left", "Middle", "Right"};
	
	
		// Mouse button to click (from InputEvent)
	private int mouseButton;
	

	public FLActionMouseClick() {
		super();
		
		mouseButton = -1;
		description = "Mouse click";
	}
	
	
	@Override
	public void perform(FLRobotContext rc) {
		Robot bot = rc.getRobot();
		
		bot.mousePress(mouseButton);
		bot.mouseRelease(mouseButton);
	}
	
		// Sets the mouse button to listen to (from InputEvent)
	public void setMouseButton(int mb) {
		mouseButton = mb;
		
		updateDescription();
	}
	
		// Sets the description of the action by mouse button
	public void updateDescription() {
		setDescription(BUTTON_CAPTIONS[mouseButton] + " mouse click");
	}
}
